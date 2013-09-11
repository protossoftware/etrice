/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 		Eyrak Paen
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.converter;

import org.eclipse.etrice.core.common.converter.DoubleConverter;
import org.eclipse.etrice.core.common.converter.LongConverter;
import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

public class ConfigValueConverterService extends DefaultTerminalConverters {

	@ValueConverter(rule = "Integer")
	public IValueConverter<Long> getLongConverter() {
		return new LongConverter();
	}

	@ValueConverter(rule = "Real")
	public IValueConverter<Double> getRealConverter() {
		return new DoubleConverter();
	}
}
