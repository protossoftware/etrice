package org.eclipse.etrice.core.common.converter;


import org.eclipse.etrice.core.common.util.CCStringIndentation;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class CC_StringConveter extends AbstractLexerBasedConverter<String> {

	public final static String DELIM = "'''";
	public final static String NEW_LINE = Strings.newLine();
	
	@Override
	protected String toEscapedString(String value) {
		return DELIM + NEW_LINE + value + NEW_LINE + DELIM;
	}
	
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			return new CCStringIndentation(string.substring(DELIM.length(), string.length() - DELIM.length())).removeIndentation();
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
}
