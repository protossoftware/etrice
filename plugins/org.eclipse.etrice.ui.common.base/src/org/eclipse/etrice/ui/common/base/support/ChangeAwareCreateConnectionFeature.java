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
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.BasicChangeRecorder;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Connection;

public abstract class ChangeAwareCreateConnectionFeature extends
		AbstractCreateConnectionFeature {

	boolean hasDoneChanges;
	
	public ChangeAwareCreateConnectionFeature(IFeatureProvider fp, String name, String description) {
		super(fp, name, description);
		this.hasDoneChanges = false;
	}

	
	@Override
	public Connection create(ICreateConnectionContext context) {
		EObject rootObject = getContainerModelObject(context);
		BasicChangeRecorder changeRecorder = new ChangeRecorder(rootObject);

		Connection result = doCreate(context);
		boolean newObjects = result != null;

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
	protected abstract Connection doCreate(ICreateConnectionContext context);

	/**
	 *  Return the model object, that holds all changed objects for the given context
	 */
	protected EObject getContainerModelObject(ICreateConnectionContext context){
		return (EObject) getBusinessObjectForPictogramElement(getDiagram());
	}
}
