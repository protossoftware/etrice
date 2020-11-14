/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.etphys;

import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.core.etphys.converters.ETPhysConverter;
import org.eclipse.etrice.core.etphys.formatting.ETPhysFormatter;
import org.eclipse.etrice.core.etphys.serializer.ETPhysTransientValueService;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class ETPhysRuntimeModule extends org.eclipse.etrice.core.etphys.AbstractETPhysRuntimeModule {

	@SuppressWarnings("restriction")
	public void configureITransientValueService(Binder binder) {
		binder.bind(org.eclipse.xtext.serializer.sequencer.ITransientValueService.class).to(
				ETPhysTransientValueService.class);
	}

	public Class<? extends ImportUriResolver> bindImportUriResolver() {
		return ModelLocatorUriResolver.class;
	}

	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return ETPhysConverter.class;
	}
	
	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return ETPhysFormatter.class;
	}
}
