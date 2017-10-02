/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.converter

import com.google.common.collect.ImmutableList
import java.util.List
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Strings

/**
 *  Implementation of "smart strings". Support of text manipulation operations. 
 *  Editor whitespace (indentation and line break) can be removed, replaced and validated.
 *  Central operation is highlight(), which computes the actual text without editor whitespace.
 *  
 *  Improvement: Too much strings matching => use token scanner
 */
class CCStringIndentation {
	
	static def boolean hasLineBreak(String nodeText) {
		Strings.countLineBreaks(nodeText) > 0;
	}
	
	static def String firstLineSeparator(String it) {
		switch it {
			case indexOf('\r\n') >= 0: '\r\n'
			case indexOf('\n') >= 0: '\n'
			case indexOf('\r') >= 0: '\r'
			default: Strings.newLine
		}
	}
	
	
	static val lineSeparatorPattern = Pattern.compile('''(\r(\n)?|\n)''');
	
	val String ccString
	
	@Accessors(PUBLIC_GETTER)
	val ImmutableList<String> splittedLines
	@Accessors(PUBLIC_GETTER)
	val boolean ignoreFirst
	@Accessors(PUBLIC_GETTER)
	val boolean ignoreLast
	
	/**
	 *  CCString without delimiters. Caller should handle their own delims.
	 */
	new(String ccString) {
		this.ccString = ccString
		splittedLines = ImmutableList.copyOf(newArrayList => [ lines |
			// split lines by line separator, keep all whitespace
			val matcher = lineSeparatorPattern.matcher(ccString)
			var lastOffset = 0
			while (matcher.find) {
				lines += ccString.substring(lastOffset, matcher.end)
				lastOffset = matcher.end
			}
			if (lastOffset < ccString.length) {
				// put rest
				lines += ccString.substring(lastOffset)
			} else if (ccString.endsWith('\n') || ccString.endsWith('\r')) {
				// consider empty last line
				lines += ''
			}
		])
		ignoreFirst = splittedLines.size >= 2 && splittedLines.head.trim.empty
		ignoreLast = splittedLines.size >= 2 && splittedLines.last.trim.empty
	}
	
	/**
	 * Returns ccString without editor white space and delims.
	 * 
	 * @see #highlight()
	 */
	def String removeEditorWhiteSpace() {
		removeEditorWhiteSpace('', null)
	}
	
	protected def String removeEditorWhiteSpace(String indent, String lineSeparator) {
		highlight.map[offsetLength | 
			indent + ccString.substring(offsetLength.key, offsetLength.key + offsetLength.value)
		].map[
			replaceLineBreak(lineSeparator)
		].join
	}
	
	/**
	 *  Returns whether editor indentation can be removed safely.
	 */
	def boolean canRemoveEditorIndentation() {
		splittedLines.size >= 2 && ignoreFirst && hasConsistentIndentation
	}
	
	/**
	 * Returns ccString replaced with given indentation if possible. Ignored lines are trimmed. No delims included.
	 * 
	 * @param indentation null to preserve original indentation
	 * @param lineSeparator null to preserve original line endings 
	 * 
	 * @see #highlight()
	 */
	def String replaceEditorIndentation(String indentation, String lineSeparator) {		
		if(indentation !== null && canRemoveEditorIndentation) {
			// replace body indentation
			// first editor line is whitespace, add it trimmed again
			val addFirstLine = if(ignoreFirst && splittedLines.size > 2) lineSeparator?:splittedLines.head?.firstLineSeparator else ''
			addFirstLine + removeEditorWhiteSpace(indentation, lineSeparator)
		} 
		else {
			// keep body indentation
			// trim delim lines and replace line separator
			val lines = <String>newArrayList(splittedLines) => [
				// trim delim lines
				if(ignoreFirst) set(0, head.firstLineSeparator)
				if(ignoreLast) remove(size - 1)
			]
			lines.map[
				replaceLineBreak(lineSeparator)
			].join
		}
	}
	
	private def replaceLineBreak(String line, String newLineSeparator) {
		if (newLineSeparator !== null && Strings.countLineBreaks(line) > 0)
			Strings.trimTrailingLineBreak(line) + newLineSeparator
		else
			line
	}
	
	/**
	 * Returns highlighted positions without editor's indentation.<br>
	 * Positions are pairs of (offset, length) relative to {@link #CCStringIndentation(String)}
	 * 
	 * @see #removeEditorWhiteSpace()
	 */
	def List<Pair<Integer, Integer>> highlight() {
		val offsetLengthLines = newArrayList
		
		val editorIndent = computeEditorIndent(false)
		val skip = editorIndent.length
			
		var offset = 0
		for (var i = 0 ; i < splittedLines.length; i++) {
			val line = splittedLines.get(i)

			if (i == 0 && ignoreFirst) {
				offset += line.length
			}
			else if (i == splittedLines.size - 1 && ignoreLast){
				// skip
			}
			else {	
				offsetLengthLines += {	
					if (line.startsWith(editorIndent))
						 offset + skip -> line.length - skip
					else
						offset -> line.length
				}	
				offset += line.length
			}
		}

		return offsetLengthLines
	}
	
	
	/**
	 * Check consistent indentation
	 */
	def boolean hasConsistentIndentation() {
		computeEditorIndent(true) !== null
	}
	
	protected def String computeEditorIndent(boolean consistentOnly) {
		// no editor indent
		if(splittedLines.size <= 1 || !ignoreFirst) 
			return ''
		
		// leading space -> line
		val wsLinePairs = {
			val begin = if(ignoreFirst) 1 else 0
			val end = splittedLines.size - (if(ignoreLast) 1 else 0)
			splittedLines.map[Strings.trimTrailingLineBreak(it).toString].subList(begin, end).map[ line |
				Strings.getLeadingWhiteSpace(line) -> line
			].toList	
		}
		
		val (Iterable<String>) => String minWSComputor = [if(empty) '' else min]
		val textIndent = minWSComputor.apply(wsLinePairs.filter[!value.trim.empty].map[key])
		val consistent = wsLinePairs.map[key].filter[!empty].forall[nonEmptyIndent | 
			nonEmptyIndent.startsWith(textIndent)
		]		
			
		switch this {
			case consistent: textIndent
			case consistentOnly: null
			default: minWSComputor.apply(wsLinePairs.map[key].filter[!empty]) // minimal non-empty white space
		}
	}
}