/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class MultiplicityConverter extends AbstractValueConverter<Integer> {

	public Integer toValue(String string, INode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to integer.", node, null);
		if (string.indexOf("*") >= 0)
			return -1;

		// we have to find the substring containing the digits
		int first = 0;
		for (; first < string.length(); ++first)
			if (Character.isDigit(string.charAt(first)))
				break;
		int last = first;
		for (; last < string.length(); ++last)
			if (!Character.isDigit(string.charAt(last)))
				break;
		String val = string.substring(first, last);
		try {
			int intValue = Integer.parseInt(val);
			if(intValue <= 0)
				throw new ValueConverterException("multiplicity must be positive or any [*]", node, null);
			return Integer.valueOf(intValue);
		}
		catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + val + "' to integer.", node, e);
		}
	}

	@Override
	public String toString(Integer value) throws ValueConverterException {
		if (value == -1)
			return "[*]";
		return "[" + value.toString() + "]";
	}

}
