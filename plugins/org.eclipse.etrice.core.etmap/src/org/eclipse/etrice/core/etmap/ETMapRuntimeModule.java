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

package org.eclipse.etrice.core.etmap;

import org.eclipse.etrice.core.common.scoping.CompoundGlobalScopeProvider;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.core.common.scoping.ModelPathFileExtensionFilter;
import org.eclipse.etrice.core.common.scoping.ModelPathGlobalScopeProvider.IModelPathFileFilter;
import org.eclipse.etrice.core.etmap.formatting.ETMapFormatter;
import org.eclipse.xtext.formatting.IFormatter;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ETMapRuntimeModule extends org.eclipse.etrice.core.etmap.AbstractETMapRuntimeModule {
	
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return CompoundGlobalScopeProvider.class;
	}
	
	public IModelPathFileFilter bindIModelPathFileFilter() {
		return new ModelPathFileExtensionFilter("room", "etphys");
	}

	// HOWTO: use URI imports - need special URI resolver
	public Class<? extends ImportUriResolver> bindImportUriResolver() {
		return ModelLocatorUriResolver.class;
	}
	
	@Override
	public Class<? extends IFormatter> bindIFormatter() {
		return ETMapFormatter.class;
	}

}
