/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys.converters;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TimeConverter extends AbstractLexerBasedConverter<Integer> {

	/* (non-Javadoc)
	 * @see org.eclipse.xtext.conversion.IValueConverter#toValue(java.lang.String, org.eclipse.xtext.nodemodel.INode)
	 */
	@Override
	public Integer toValue(String string, INode node) throws ValueConverterException {
		if (string==null || string.isEmpty())
			throw new ValueConverterException("Couldn't convert empty string to time.", node, null);
		else {
			// determine power and extract number
			int power;
			int pos;
			String value;
			if ((pos=string.indexOf("ns"))>0) {
				value = string.substring(0,pos);
				power = 1;
			}
			else if ((pos=string.indexOf("us"))>0) {
				value = string.substring(0,pos);
				power = 1000;
			}
			else if ((pos=string.indexOf("ms"))>0) {
				value = string.substring(0,pos);
				power = 1000000;
			}
			else if ((pos=string.indexOf("s"))>0) {
				value = string.substring(0,pos);
				power = 1000000000;
			}
			else
				throw new ValueConverterException("No unit specified with time (s, ms, us or ns).", node, null);
			
			try {
				int val = Integer.parseInt(value.trim());
				return Integer.valueOf(val)*power;
			}
			catch (NumberFormatException e) {
				throw new ValueConverterException("Could not parse time value.", node, e);
			}
		}
	}

}
