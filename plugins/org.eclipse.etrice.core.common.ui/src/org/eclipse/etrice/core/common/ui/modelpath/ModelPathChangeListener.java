/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.modelpath;

import java.util.Collection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.etrice.core.common.ui.modelpath.ModelPathManager.IModelPathListener;
import org.eclipse.xtext.builder.impl.BuildScheduler;
import org.eclipse.xtext.builder.impl.IBuildFlag;
import org.eclipse.xtext.resource.impl.CoarseGrainedChangeEvent;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Inject;

/**
 * Listens for modelpath changes and triggers a rebuild if necessary.
 */
@SuppressWarnings("restriction")
public class ModelPathChangeListener implements IEagerContribution, IModelPathListener {

	private BuildScheduler buildScheduler;
	private IDirtyStateManager dirtyStateManager;
	
	@Inject
	public ModelPathChangeListener(BuildScheduler buildScheduler, IDirtyStateManager dirtyStateManager) {
		this.buildScheduler = buildScheduler;
		this.dirtyStateManager = dirtyStateManager;
	}
	
	@Override
	public void onChange(Collection<IProject> projects) {
		// Notify xtext of modelpath changes
		dirtyStateManager.notifyListeners(new CoarseGrainedChangeEvent());
		
		// Trigger build for all projects if auto build is enabled
		if(ResourcesPlugin.getWorkspace().isAutoBuilding()) {
			buildScheduler.scheduleBuildIfNecessary(projects, IBuildFlag.FORGET_BUILD_STATE_ONLY);
		}
	}

	@Override
	public void initialize() {
		ModelPathManager.INSTANCE.addListener(this);
		ModelPathManager.INSTANCE.startListening();
	}

	@Override
	public void discard() {
		ModelPathManager.INSTANCE.stopListening();
		ModelPathManager.INSTANCE.removeListener(this);
	}

}
