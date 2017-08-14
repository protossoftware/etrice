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

import java.util.List
import java.util.regex.Pattern
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.Strings
import com.google.common.collect.ImmutableList

/**
 *  TODO: Handling mixed line endings
 *  
 *  Improvement: Too much strings matching => use token scanner
 */
class CCStringIndentation {
	
	val static JAVA_NL = Strings.newLine
	val static CRLF = "\r\n"
	val static LF = "\n"
	val static CR = "\r"
	
	static def boolean hasLineBreak(String nodeText) {
		Strings.countLineBreaks(nodeText) > 0;
	}

	static def String getLineEnding(String it) {
		switch it {
			case indexOf(CRLF) >= 0: CRLF
			case indexOf(LF) >= 0: LF
			case indexOf(CR) >= 0: CR
			default: JAVA_NL
		}
	}
	
	val String ccString
	val String lineEnding // first lineEnding found (mixed line endings ?!)
	
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
		lineEnding = getLineEnding(ccString) // use contents line ending
		splittedLines = ImmutableList.copyOf(newArrayList => [ lines |
			// split lines by lineEnding, keep all whitespace
			val matcher = Pattern.compile(lineEnding).matcher(ccString)
			var lastOffset = 0
			while (matcher.find) {
				lines += ccString.substring(lastOffset, matcher.start)
				lastOffset = matcher.end
			}
			if (lastOffset < ccString.length) {
				// put rest
				lines += ccString.substring(lastOffset)
			} else if (ccString.endsWith(lineEnding)) {
				// empty last line is important
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
		removeEditorWhiteSpace('')
	}
	
	protected def String removeEditorWhiteSpace(String indent) {
		highlight.fold('', [lines, offsetLength | 
			lines + indent + ccString.substring(offsetLength.key, offsetLength.key + offsetLength.value)
		])
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
	 * @see #highlight()
	 */
	def String replaceEditorIndentation(String indentation) {
		val indent = if(indentation === null) '' else indentation
		if(canRemoveEditorIndentation) {
			if(ignoreFirst && splittedLines.size == 2) {
				removeEditorWhiteSpace('')
			} else {
				(if(ignoreFirst) lineEnding else '') + removeEditorWhiteSpace(indent)			
			}
		} else {
			val lines = <String>newLinkedList(splittedLines) => [
				if(ignoreFirst) set(0, '')
				if(ignoreLast) set(size - 1, '')
			]
			lines.join(lineEnding)
		}
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
				offset += line.length + lineEnding.length
			}
			else if (i == splittedLines.size - 1 && ignoreLast){
				// skip
			}
			else {	
				offsetLengthLines += {	
					val NL = if (i < splittedLines.size - 1) lineEnding.length else 0
					if (line.startsWith(editorIndent))
						 offset + skip -> line.length - skip + NL
					else
						offset -> line.length + NL
				}	
				offset += line.length + lineEnding.length
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
			splittedLines.subList(begin, end).map[ line |
				Strings.getLeadingWhiteSpace(line) -> line
			].toList	
		}
		
		val (Iterable<String>) => String minWSComputor = [if(empty) '' else min]
		val textIndent = minWSComputor.apply(wsLinePairs.filter[!value.trim.empty].map[key])
		val consistent = wsLinePairs.map[key].filter[!empty].forall[nonEmptyIndent | nonEmptyIndent.startsWith(textIndent)]		
			
		switch this {
			case consistent: textIndent
			case consistentOnly: null
			default: minWSComputor.apply(wsLinePairs.map[key].filter[!empty]) // minimal non-empty white space
		}
	}
}