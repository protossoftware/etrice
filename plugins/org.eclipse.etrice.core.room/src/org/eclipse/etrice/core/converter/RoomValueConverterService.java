/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Eyrak Paen
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.converter;

import org.eclipse.etrice.core.common.converter.DoubleConverter;
import org.eclipse.etrice.core.common.converter.LongConverter;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomValueConverterService extends DefaultTerminalConverters {
	
	private MultiplicityConverter multiplicityConverter = new MultiplicityConverter();

	@ValueConverter(rule = "MULTIPLICITY")
	public IValueConverter<Integer> MULTIPLICITY() {
		return multiplicityConverter;
	}
	
	@ValueConverter(rule = "Integer")
	public IValueConverter<Long> getLongConverter() {
		return new LongConverter();
	}

	@ValueConverter(rule = "Real")
	public IValueConverter<Double> getRealConverter() {
		return new DoubleConverter();
	}
}
