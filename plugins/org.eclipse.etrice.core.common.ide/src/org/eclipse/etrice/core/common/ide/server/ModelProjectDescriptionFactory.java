/*******************************************************************************
 * Copyright (c) 2021 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.ide.server;

import org.eclipse.etrice.core.common.ide.modelpath.ModelPathManager;
import org.eclipse.xtext.ide.server.IProjectDescriptionFactory;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.workspace.IProjectConfig;

import com.google.inject.Inject;

/**
 * A project description factory that configures the project dependencies according to
 * the corresponding modelpath description file. 
 */
public class ModelProjectDescriptionFactory implements IProjectDescriptionFactory {

	@Inject
	private ModelPathManager modelPathManager;
	
	@Override
	public ProjectDescription getProjectDescription(IProjectConfig project) {
		ProjectDescription result = new ProjectDescription();
		result.setName(project.getName());
		if(project.getPath() != null) {
			// Configure project dependencies
			modelPathManager.getProjectDependencies(project.getPath().toString())
				.forEach(result.getDependencies()::add);
		}
		return result;
	}
}
