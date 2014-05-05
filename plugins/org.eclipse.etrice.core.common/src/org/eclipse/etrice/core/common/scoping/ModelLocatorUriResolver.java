/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;

/**
 * This URI resolver delegates to {@link ModelLocator}.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class ModelLocatorUriResolver extends ImportUriResolver {
	
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
		return ModelLocator.getInstance().resolve(resolve, resource);
	}
}
