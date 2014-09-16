package org.eclipse.etrice.core.ui.quickfix

import java.util.ArrayList
import org.eclipse.xtext.ui.editor.model.IXtextDocument
import org.eclipse.xtext.util.Strings
import org.eclipse.xtext.validation.Issue

class DetailCodeIndentHelper {

	/**
	 * Converts the issued multi line string to single line strings
	 * - line with least indentation is adjusted to first line
	 * - lines are enclosed with " or '
	 * - lines get editor indentation of first line
	 * - 
	 */
	def static convertToSingleLines(IXtextDocument document, Issue issue) {
		val issuedRegion = document.getLineInformationOfOffset(issue.getOffset()) // note: other methods return wrong line
		
		val firstEditorLine = document.get(issuedRegion.getOffset(), issuedRegion.getLength())
		val editorIndent = Strings.getLeadingWhiteSpace(firstEditorLine)
		
		val editorString = document.get(issue.getOffset(), issue.getLength())
		val mark = editorString.charAt(0).toString // " or '
		val editorLines = Strings::split(editorString, Strings.newLine())

		//val initialIndent = editorLines.head.countIndent
		val minIndent = editorLines.tail.sortBy[countIndent()].head.countIndent

		val newEditorLines = new ArrayList<String>()
		editorLines.forEach [ line, lineCount |
			var front = if(lineCount != 0) editorIndent + mark
			var indentCount = line.countIndent - minIndent
			var indent = if (lineCount != 0 && indentCount > 0) '''«FOR i : (1 .. indentCount)»	«ENDFOR»''' // \t
			var noneWSLine = Strings::removeLeadingWhitespace(line)
			var end = if(lineCount != editorLines.size - 1) mark
			var newEditorLine = '''«front»«indent»«noneWSLine»«end»'''
			newEditorLines.add(newEditorLine)
		]

		return Strings::concat(Strings.newLine(), newEditorLines)
	}

	private static def countIndent(String line) {
		// simplistic whitespace handling, drop spaces etc.
		// first convert 4x spaces to 1 indent, after that remove everything else
		Strings::getLeadingWhiteSpace(line).replace("\t", "    ").replace("    ", "\t").replaceAll("!\\t","").length
		
	}
}
