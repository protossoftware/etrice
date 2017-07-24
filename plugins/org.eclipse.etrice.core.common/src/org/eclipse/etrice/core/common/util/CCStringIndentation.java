package org.eclipse.etrice.core.common.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.core.common.converter.CC_StringConveter;
import org.eclipse.xtext.util.Strings;

public class CCStringIndentation {
	
	private String ccString;
	private List<String> splittedLines;
	private boolean ignoreFirst;
	private boolean ignoreLast;
	private String lineEnding;
	
	public CCStringIndentation(String ccString){
		this.ccString = ccString;
		this.lineEnding = CC_StringConveter.getLineEnding(ccString);
		this.splittedLines = Strings.split(ccString, lineEnding);
		this.ignoreFirst = splittedLines.size() > 1 && splittedLines.get(0).isEmpty();
		this.ignoreLast = splittedLines.size() > 1 && splittedLines.get(splittedLines.size() - 1).trim().isEmpty();
	}
	
	/**
	 * Remove editor's indentation from DetailCodeString
	 * 
	 * @see #highlight()
	 */
	public String removeIndentation() {
		List<int[]> offsetLengthList = highlight();

		StringBuffer buffer = new StringBuffer(ccString.length());
		for (int[] offsetLength : offsetLengthList)
			buffer.append(ccString.substring(offsetLength[0], offsetLength[0] + offsetLength[1]));

		return buffer.toString();
	}

	/**
	 * Returns highlighted positions without editor's indentation
	 * 
	 * @see #removeIndentation()
	 */
	public List<int[]> highlight() {
		List<int[]> offsetLengthLines = new ArrayList<int[]>();
		if (ccString == null || ccString.isEmpty())
			return offsetLengthLines;

		String minIndent = calcMinIndent(false);

		int offset = 0;
		int skip = minIndent.length();
		List<String> lines = splittedLines;
		for (int i = 0; i < lines.size(); i++) {
			String line = lines.get(i);

			if (i == 0 && ignoreFirst) {
				offset += line.length() + lineEnding.length();
				continue;
			}

			if (i == lines.size() - 1 && ignoreLast)
				continue;

			int[] pos;
			if (line.startsWith(minIndent))
				pos = new int[] { offset + skip, line.length() - skip };
			else
				pos = new int[] { offset, line.length() };
			if (i < lines.size() - 1)
				pos[1] += lineEnding.length();

			offset += line.length() + lineEnding.length();
			offsetLengthLines.add(pos);
		}

		return offsetLengthLines;
	}

	/**
	 * Check consistent indentation
	 */
	public boolean validateIndentation() {

		return calcMinIndent(true) != null;
	}

	/**
	 * TODO
	 */
	public String fixInconsistentIndentation() {
		//use jface TabsToSpacesConverter
		return null;
	}

	
	
	/**
	 * Returns the least indentation, or maybe null if consistent is set
	 */
	private String calcMinIndent(boolean consistent) {
		if(splittedLines.size() <= 1)
			return "";
		List<String> lines = splittedLines.subList(((ignoreFirst) ? 1 : 0), splittedLines.size() - ((ignoreLast) ? 1 : 0));
		if (lines.isEmpty())
			return "";
		
		ArrayList<String> wsLines = new ArrayList<String>(lines.size());
		for (String line : lines)
			wsLines.add(Strings.getLeadingWhiteSpace(line));
	
		final String baseIndent = wsLines.get(0);		
		String commonIndent = baseIndent;
		for(String wsLine : wsLines){
			if(!wsLine.isEmpty())
				commonIndent = com.google.common.base.Strings.commonPrefix(commonIndent, wsLine);
		}
	
		if (!consistent)
			return commonIndent;
	
		int afterMinIndentIndex = baseIndent.length();
	
		// 1. check if every line contains the minIndent
		if(!baseIndent.equals(commonIndent))
			return null;
	
		// 2. check if there is still space between minIndent and first terminal
		boolean containsTerminal = false;
		for (int i = 0; i < lines.size(); i++)
			containsTerminal |= lines.get(i).length() > wsLines.get(i).length();
	
		if (containsTerminal) {
			boolean terminalAfterMinIndent = false;
			for (String line : lines)
				if (line.length() > afterMinIndentIndex)
					terminalAfterMinIndent |= !Character.isWhitespace(line.charAt(afterMinIndentIndex));
	
			if (!terminalAfterMinIndent)
				return null;
		}
	
		return baseIndent;
	}

}
