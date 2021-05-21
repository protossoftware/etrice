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

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.io.GeneratorResourceLoader;
import org.eclipse.etrice.generator.base.io.IGeneratorEMFSetup;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Henrik Rentz-Reichert
 * @deprecated replaced by {@link GeneratorResourceLoader}
 */
@Deprecated public class ModelLoader extends GeneratorResourceLoader {
	
	@Inject
	public ModelLoader(Provider<ResourceSet> resourceSetProvider, IGeneratorEMFSetup emfSetup) {
		super(resourceSetProvider, emfSetup);
	}
}
