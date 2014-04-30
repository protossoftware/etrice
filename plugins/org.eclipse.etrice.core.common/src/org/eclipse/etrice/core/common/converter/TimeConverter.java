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

package org.eclipse.etrice.core.common.converter;

import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class TimeConverter extends AbstractLexerBasedConverter<Long> {

	public static final String SEC = "s";
	public static final String MILLI_SEC = "ms";
	public static final String MICRO_SEC = "us";
	public static final String NANO_SEC = "ns";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.conversion.IValueConverter#toValue(java.lang.String,
	 * org.eclipse.xtext.nodemodel.INode)
	 */
	@Override
	public Long toValue(String string, INode node) throws ValueConverterException {
		if (Strings.isEmpty(string)) {
			if (node != null && !Strings.isEmpty(node.getText()))
				throw new ValueConverterException("No valid time value.", node, null);
			else
				throw new ValueConverterException("Couldn't convert empty string to time.", node, null);
		}
		else {
			// determine power and extract number
			int power;
			int pos;
			String value;
			if ((pos = string.indexOf(NANO_SEC)) > 0) {
				value = string.substring(0, pos);
				power = 1;
			}
			else if ((pos = string.indexOf(MICRO_SEC)) > 0) {
				value = string.substring(0, pos);
				power = 1000;
			}
			else if ((pos = string.indexOf(MILLI_SEC)) > 0) {
				value = string.substring(0, pos);
				power = 1000000;
			}
			else if ((pos = string.indexOf(SEC)) > 0) {
				value = string.substring(0, pos);
				power = 1000000000;
			}
			else
				throw new ValueConverterException("No unit specified with time (s, ms, us or ns).", node, null);

			try {
				long val = Long.parseLong(value.trim());
				// TIME rule implies val >= 0
				return val * power;
			}
			catch (NumberFormatException e) {
				throw new ValueConverterException("Could not parse time value.", node, e);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.conversion.impl.AbstractLexerBasedConverter#toEscapedString
	 * (java.lang.Object)
	 */
	@Override
	protected String toEscapedString(Long value) {
		if (value % 1000 == 0) {
			if (value % 1000000 == 0) {
				if (value % 1000000000 == 0) {
					return (value / 1000000000) + SEC;
				}
				else {
					return (value / 1000000) + MILLI_SEC;
				}
			}
			else {
				return (value / 1000) + MICRO_SEC;
			}
		}
		else {
			return value + NANO_SEC;
		}
	}

	/**
	 * Returns the part of <b>nanoSeconds</b>, that is descriped by <b>unit</b>
	 * and <b>isNewUnit</b>.<br>
	 * If <b>isNewUnit</b> = true then anything that can not be represented by
	 * <b>unit</b> is cut away.<br>
	 * If <b>isNewUnit</b> = false then the unit remains nano seconds but
	 * contains nothing higher than <b>unit</b>.
	 * 
	 * @param unit
	 *            - split along inclusive
	 * @param isNewUnit
	 *            - upper/lower part
	 */
	public static long split(long nanoSeconds, String unit, boolean isNewUnit) {
		if (unit.equals(SEC))
			return (isNewUnit) ? (nanoSeconds / 1000000000) : nanoSeconds;
		if (unit.equals(MILLI_SEC))
			return (isNewUnit) ? (nanoSeconds / 1000000) : nanoSeconds - split(nanoSeconds, SEC, true) * 1000000000;
		if (unit.equals(MICRO_SEC))
			return (isNewUnit) ? (nanoSeconds / 1000) : nanoSeconds - split(nanoSeconds, MILLI_SEC, true) * 1000000;
		if (unit.equals(NANO_SEC))
			return (isNewUnit) ? nanoSeconds : nanoSeconds - split(nanoSeconds, MICRO_SEC, true) * 1000;

		throw new UnsupportedOperationException("Invalid time unit");
	}

}
