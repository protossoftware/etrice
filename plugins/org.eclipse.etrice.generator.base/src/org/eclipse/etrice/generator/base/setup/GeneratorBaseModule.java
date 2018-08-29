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

package org.eclipse.etrice.generator.base.setup;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.generator.base.IGenerator;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * An abstract base module for generators that configures standard implementations.
 */
public abstract class GeneratorBaseModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ResourceSet.class).to(XtextResourceSet.class);
		binder.bind(IEncodingProvider.class).to(IEncodingProvider.Runtime.class);
		
		binder.bind(IGenerator.class).to(bindIGenerator());
	}
	
	/**
	 * Binds the {@link IGenerator}.
	 * 
	 * @return the class of the generator implementation
	 */
	public abstract Class<? extends IGenerator> bindIGenerator();

}
