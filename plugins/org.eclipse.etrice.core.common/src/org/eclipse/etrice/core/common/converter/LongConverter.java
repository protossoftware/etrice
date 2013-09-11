/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 		Eyrak Paen
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class LongConverter extends AbstractLexerBasedConverter<Long> {

	@Override
	public Long toValue(String string, INode node)
			throws ValueConverterException {
		if (Strings.isEmpty(string))
			throw new ValueConverterException(
					"Couldn't convert empty string to integer.", node, null);
		if (string.startsWith("0x") || string.startsWith("0X")) {
			try {
				long value = Long.parseLong(string.substring(2), 16);
				return value;
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '"
						+ string + "' to hex.", node, e);
			}
		} else {
			try {
				String tmp = string;
				if(string.charAt(0) == '+'){
					tmp = string.substring(1, string.length());
				}
				long value = Long.parseLong(tmp);
				return value;
			} catch (NumberFormatException e) {
				throw new ValueConverterException("Couldn't convert '"
						+ string + "' to integer.", node, e);
			}
		}
	}
}