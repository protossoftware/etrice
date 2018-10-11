/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.core.common.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.ImportUriGlobalScopeProvider;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * Global scope provider that combines the {@link ImportUriGlobalScopeProvider} and {@link ModelPathGlobalScopeProvider}.
 */
public class CompoundGlobalScopeProvider implements IGlobalScopeProvider {
	
	@Inject
	ModelPathGlobalScopeProvider modelPathGlobalScopeProvider;
	
	@Inject
	ImportUriGlobalScopeProvider importURIGlobalSopeProvider;

	@Override
	public IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter) {
		IScope uriScope = importURIGlobalSopeProvider.getScope(context, reference, filter);
		IScope combinedScope = modelPathGlobalScopeProvider.getScope(uriScope, context, reference, filter);
		
		return combinedScope;
	}
}
