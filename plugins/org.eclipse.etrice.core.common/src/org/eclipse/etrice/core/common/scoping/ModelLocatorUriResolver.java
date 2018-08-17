/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

import com.google.inject.Inject;

/**
 * This URI resolver delegates to {@link ModelLocator}.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class ModelLocatorUriResolver extends ImportUriResolver {
	
	@Inject
	private ModelLocator modelLocator;
	
	/* (non-Javadoc)
	 * @see org.eclipse.xtext.scoping.impl.ImportUriResolver#resolve(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public String resolve(EObject object) {
		String resolve = super.resolve(object);
		
		// can't do anything about empty URIs
		if (resolve==null || resolve.trim().isEmpty())
			return null;

		return resolve(resolve, object.eResource());
	}
	
	public String resolve(String resolve, Resource resource) {
		return modelLocator.resolve(resolve, resource);
	}
}
