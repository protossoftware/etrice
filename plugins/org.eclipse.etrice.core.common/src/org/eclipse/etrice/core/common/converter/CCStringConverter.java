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

package org.eclipse.etrice.core.common.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

public class CCStringConverter extends AbstractLexerBasedConverter<String> {
	
	static public String addDelim(final String text, String delim) {
		if(CCStringIndentation.hasLineBreak(text)) {
			final String lineEnding = CCStringIndentation.getLineEnding(text);
			return delim + lineEnding + text + delim;
		}
		return delim + text + delim;
	}
	
	static public String stripDelim(String nodeText, String delim) {
		if (nodeText.startsWith(delim) && nodeText.endsWith(delim)) {
			return nodeText.substring(delim.length(),  nodeText.length() - delim.length());
		}
		
		return nodeText;
	}
	
	private final String delim;
	
	public CCStringConverter(String delim) {
		this.delim = delim;
	}
	
	public String getDelim() {
		return delim;
	}
	
	@Override
	protected String toEscapedString(String value) {
		return addDelim(value, delim);
	}

	public String toValue(String string, INode node) {
		if (string == null)
			return null;
		try {
			return new CCStringIndentation(stripDelim(string, delim)).removeEditorWhiteSpace();
		} catch (IllegalArgumentException e) {
			throw new ValueConverterException(e.getMessage(), node, e);
		}
	}
	
	public String addDelim(String text) {
		return addDelim(text, delim);
	}
	
	public String stripDelim(String text) {
		return stripDelim(text, delim);
	}
}
