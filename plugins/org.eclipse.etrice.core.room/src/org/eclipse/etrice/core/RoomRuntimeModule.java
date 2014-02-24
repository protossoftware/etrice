/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

import org.eclipse.etrice.core.converter.RoomValueConverterService;
import org.eclipse.etrice.core.naming.RoomFragmentProvider;
import org.eclipse.etrice.core.naming.RoomQualifiedNameProvider;
import org.eclipse.etrice.core.scoping.ModelLocatorUriResolver;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Binder;


/**
 * Use this class to register components to be used within the IDE.
 */
public class RoomRuntimeModule extends org.eclipse.etrice.core.AbstractRoomRuntimeModule {

	@Override
    public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
        return RoomQualifiedNameProvider.class;
    }
	
	@Override
	public Class<? extends IFragmentProvider> bindIFragmentProvider() {
		return RoomFragmentProvider.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.AbstractRoomRuntimeModule#configureIScopeProviderDelegate(com.google.inject.Binder)
	 */
	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(
				com.google.inject.name.Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(
						org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider.class);
	}
	
	// HOWTO: use URI imports - need special URI resolver
	public Class<? extends ImportUriResolver> bindImportUriResolver() {
		return ModelLocatorUriResolver.class;
	}

	// HOWTO: add a value converter
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return RoomValueConverterService.class;
	}
}
