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
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public abstract class ChangeAwareCustomFeature extends AbstractCustomFeature {

	protected ResourceChangeRecorder changeRecorder = null;
	
	public ChangeAwareCustomFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public final void execute(ICustomContext context){
		changeRecorder = new ResourceChangeRecorder(getContainerResource(context));
		
		boolean doExecute = doExecute(context);
		
		changeRecorder.endRecording(!doExecute);
	}
	
	@Override
	public final boolean hasDoneChanges() {
		return changeRecorder.hasResourceChanged();
	}
	
	protected abstract boolean doExecute(ICustomContext context);

	/**
	 *  Return the resource, that holds all changed objects for the given context
	 */
	protected Resource getContainerResource(ICustomContext context){
		return ((EObject) getBusinessObjectForPictogramElement(getDiagram())).eResource();
	}
}
