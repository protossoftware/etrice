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

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;

public class BaseConverterService extends DefaultTerminalConverters {

	private TimeConverter timeConverter = new TimeConverter();
	private LongConverter longConverter = new LongConverter();
	private DoubleConverter doubleConverter = new DoubleConverter();

	@ValueConverter(rule = "TIME")
	public IValueConverter<Long> getTimeConverter() {
		return timeConverter;
	}

	@ValueConverter(rule = "Integer")
	public IValueConverter<Long> getLongConverter() {
		return longConverter;
	}

	@ValueConverter(rule = "Real")
	public IValueConverter<Double> getRealConverter() {
		return doubleConverter;
	}
}
