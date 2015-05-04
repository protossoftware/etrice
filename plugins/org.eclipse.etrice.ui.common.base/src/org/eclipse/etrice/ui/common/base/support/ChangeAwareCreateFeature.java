/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public abstract class ChangeAwareCreateFeature extends AbstractCreateFeature {
	
	protected ResourceChangeRecorder changeRecorder = null;
	
	public ChangeAwareCreateFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
	}

	@Override
	public final Object[] create(ICreateContext context) {
		changeRecorder = new ResourceChangeRecorder(getContainerResource(context));

		Object[] result = doCreate(context);
		boolean newObjects = result != null && result.length > 0;

		changeRecorder.endRecording(!newObjects);

		return result;
	}
	
	@Override
	public final boolean hasDoneChanges() {
		return changeRecorder.hasResourceChanged();
	}
	
	/**
	 * {@link AbstractCreateFeature#create(ICreateContext)}
	 */
	protected abstract Object[] doCreate(ICreateContext context);

	/**
	 *  Return the resource, that holds all changed objects for the given context
	 */
	protected Resource getContainerResource(ICreateContext context){
		return ((EObject) getBusinessObjectForPictogramElement(getDiagram())).eResource();
	}
}
