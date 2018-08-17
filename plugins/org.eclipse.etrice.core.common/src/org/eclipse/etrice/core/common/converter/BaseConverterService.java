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
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.core.common.converter;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class BaseConverterService extends DefaultTerminalConverters {

	private TimeConverter timeConverter = new TimeConverter();
	private LongConverter longConverter = new LongConverter();
	private DoubleConverter doubleConverter = new DoubleConverter();
	private CCStringConverter ccStringConverter = new CCStringConverter("'''");

	@Inject
	private QualifiedNameValueConverter fqnConverter;

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

	@ValueConverter(rule = "FQN")
	public IValueConverter<String> FQN() {
		return fqnConverter;
	}
	
	@ValueConverter(rule = "CC_STRING")
	public CCStringConverter getCC_StringConverter() {
		return ccStringConverter;
	}
	
}
