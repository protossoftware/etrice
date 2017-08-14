package org.eclipse.etrice.core.common.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

public class CC_StringConverter extends AbstractLexerBasedConverter<String> {

	static public String DELIM = "'''";
	
	static public String addDelim(final String text) {
		if(CCStringIndentation.hasLineBreak(text)) {
			final String lineEnding = CCStringIndentation.getLineEnding(text);
			return DELIM + lineEnding + text + DELIM;
		}
		return DELIM + text + DELIM;
	}
	
	static public String stripDelim(String nodeText) {
		if (nodeText.startsWith(DELIM) && nodeText.endsWith(DELIM)) {
			return nodeText.substring(DELIM.length(),  nodeText.length() - DELIM.length());
		}
		
		return nodeText;
	}
	
	@Override
	protected String toEscapedString(String value) {
		return addDelim(value);
	}

	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			return new CCStringIndentation(stripDelim(string)).removeEditorWhiteSpace();
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
}
