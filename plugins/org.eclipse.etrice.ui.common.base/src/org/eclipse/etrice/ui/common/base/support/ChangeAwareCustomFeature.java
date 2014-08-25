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
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;

public abstract class ChangeAwareCustomFeature extends AbstractCustomFeature {

	boolean hasDoneChanges;
	
	public ChangeAwareCustomFeature(IFeatureProvider fp) {
		super(fp);
		this.hasDoneChanges = false;
	}

	@Override
	public final void execute(ICustomContext context) {
		EObject rootObject = getContainerModelObject(context);
		BasicChangeRecorder changeRecorder = new ChangeRecorder(rootObject);

		boolean doExecute = doExecute(context);

		ChangeDescription cd = changeRecorder.endRecording();
		hasDoneChanges = !(cd.getObjectChanges().isEmpty()
				&& cd.getObjectsToAttach().isEmpty()
				&& cd.getObjectsToDetach().isEmpty() && cd.getResourceChanges()
				.isEmpty());

		if (!doExecute && hasDoneChanges){
			cd.apply();
			hasDoneChanges = false;
		}
	}
	
	@Override
	public final boolean hasDoneChanges() {
		return hasDoneChanges;
	}
	
	protected abstract boolean doExecute(ICustomContext context);

	/**
	 *  Return the model object, that holds all changed objects for the given context
	 */
	protected EObject getContainerModelObject(ICustomContext context){
		return (EObject) getBusinessObjectForPictogramElement(getDiagram());
	}
}
