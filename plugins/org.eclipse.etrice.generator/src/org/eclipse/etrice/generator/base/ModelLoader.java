/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.base;

import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver;
import org.eclipse.etrice.generator.base.io.GeneratorResourceLoader;
import org.eclipse.etrice.generator.base.io.IGeneratorEMFSetup;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class ModelLoader extends GeneratorResourceLoader {
	
	private ModelLocatorUriResolver uriResolver;
	
	@Inject
	public ModelLoader(Provider<ResourceSet> resourceSetProvider, IGeneratorEMFSetup emfSetup, ModelLocatorUriResolver uriResolver) {
		super(resourceSetProvider, emfSetup);
		
		this.uriResolver = uriResolver;
	}
	
	@Override
	protected URI createURI(Path path) {
		String uri = uriResolver.resolve(path.toString(), null);
		return URI.createURI(uri);
	}
}
