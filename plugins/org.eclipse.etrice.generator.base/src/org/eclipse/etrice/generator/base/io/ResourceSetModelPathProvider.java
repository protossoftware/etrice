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

package org.eclipse.etrice.generator.base.io;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * Retrieves the modelpath from the load options of the underlying resource set.
 */
public class ResourceSetModelPathProvider implements IModelPathProvider {

	public static final String LOAD_OPTION_MODELPATH = "org.eclipse.etrice.generator.base.modelpath";
	
	@Override
	public IModelPath get(Resource resource) {
		ResourceSet resourceSet = resource.getResourceSet();
		Object modelpath = resourceSet.getLoadOptions().get(LOAD_OPTION_MODELPATH);
		if(modelpath != null && modelpath instanceof IModelPath) {
			return (IModelPath) modelpath;
		}
		return IModelPath.EMPTY;
	}
	
}