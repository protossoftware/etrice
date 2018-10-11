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

import com.google.inject.ImplementedBy;

@ImplementedBy(ResourceSetModelPathProvider.class)
public interface IModelPathProvider {
	
	/**
	 * Requests the modelpath for the specified resource.
	 * 
	 * @param resource the resource that requested modelpath is for
	 * @return the modelpath for the resource
	 */
	public IModelPath get(Resource resource);
	
}
