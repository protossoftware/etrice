/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etphys;

import org.eclipse.etrice.core.scoping.PlatformRelativeUriResolver;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class ETPhysRuntimeModule extends org.eclipse.etrice.core.etphys.AbstractETPhysRuntimeModule {

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class)
		.annotatedWith(
				com.google.inject.name.Names
						.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
		.to(org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider.class);
	}

	public Class<? extends ImportUriResolver> bindImportUriResolver() {
		return PlatformRelativeUriResolver.class;
	}
}
