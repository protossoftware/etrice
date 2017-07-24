package org.eclipse.etrice.core.common.converter;


import org.eclipse.etrice.core.common.util.CCStringIndentation;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

public class CC_StringConveter extends AbstractLexerBasedConverter<String> {

	public final static String DELIM = "'''";
	final static String CRLF = "\r\n";
	final static String LF = "\n";
	
	@Override
	protected String toEscapedString(String value) {
		String lineEnding = getLineEnding(value);
		return DELIM + lineEnding + value + lineEnding + DELIM;
	}
	
	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			return new CCStringIndentation(stripDelim(string)).removeIndentation();
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
	
	static public String stripDelim(String ccstring) {
		if(ccstring.startsWith(DELIM) && ccstring.endsWith(DELIM))
			return ccstring.substring(DELIM.length(), ccstring.length() - DELIM.length());
		
		return ccstring;
	}
	
	static public String getLineEnding(String ccstring) {
		if (ccstring.indexOf(CRLF) >= 0)
			return CRLF;
		return LF;
	}
}
