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
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * A  base module for generator applications that configures standard implementations.
 */
public abstract class GeneratorApplicationModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(ResourceSet.class).to(XtextResourceSet.class);
	}

}
