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

package org.eclipse.etrice.ui.common.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.BasicChangeRecorder;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

public abstract class ChangeAwareCreateFeature extends AbstractCreateFeature {
	
	boolean hasDoneChanges;
	
	public ChangeAwareCreateFeature(IFeatureProvider fp, String name,
			String description) {
		super(fp, name, description);
		this.hasDoneChanges = false;
	}

	@Override
	public final Object[] create(ICreateContext context) {
		EObject rootObject = getContainerModelObject(context);
		BasicChangeRecorder changeRecorder = new ChangeRecorder(rootObject);

		Object[] result = doCreate(context);
		boolean newObjects = result != null && result.length > 0;

		ChangeDescription cd = changeRecorder.endRecording();
		hasDoneChanges = !(cd.getObjectChanges().isEmpty()
				&& cd.getObjectsToAttach().isEmpty()
				&& cd.getObjectsToDetach().isEmpty() && cd.getResourceChanges()
				.isEmpty());

		if (!newObjects && hasDoneChanges){
			cd.apply();
			hasDoneChanges = false;
		}

		return result;
	}
	
	@Override
	public final boolean hasDoneChanges() {
		return hasDoneChanges;
	}
	
	/**
	 * {@link AbstractCreateFeature#create(ICreateContext)}
	 */
	protected abstract Object[] doCreate(ICreateContext context);

	/**
	 *  Return the model object, that holds all changed objects for the given context
	 */
	protected EObject getContainerModelObject(ICreateContext context){
		return (EObject) getBusinessObjectForPictogramElement(getDiagram());
	}
}
