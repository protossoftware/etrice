/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

import org.eclipse.etrice.core.common.scoping.CompoundGlobalScopeProvider;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.core.common.scoping.ModelPathGlobalScopeProvider.IModelPathFileFilter;
import org.eclipse.etrice.core.converter.ConfigValueConverterService;
import org.eclipse.etrice.core.scoping.RoomModelPathFileExtensionFilter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class ConfigRuntimeModule extends
		org.eclipse.etrice.core.AbstractConfigRuntimeModule {

	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return CompoundGlobalScopeProvider.class;
	}
	
	public IModelPathFileFilter bindIModelPathFileFilter() {
		return new RoomModelPathFileExtensionFilter();
	}

	// HOWTO: use URI imports - need special URI resolver
	public Class<? extends ImportUriResolver> bindImportUriResolver() {
		return ModelLocatorUriResolver.class;
	}

	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return ConfigValueConverterService.class;
	}

}
