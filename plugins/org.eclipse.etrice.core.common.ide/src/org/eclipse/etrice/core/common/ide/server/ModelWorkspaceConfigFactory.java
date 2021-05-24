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

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.common.ide.modelpath.ModelPathManager;
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.ide.server.MultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.UnknownProjectConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;

import com.google.inject.Inject;

/**
 * A workspace configuration factory that configures the source directories
 * of the projects according to their modelpath description file. 
 */
public class ModelWorkspaceConfigFactory extends MultiRootWorkspaceConfigFactory {
	
	private static final Logger LOG = Logger.getLogger(ModelWorkspaceConfigFactory.class);
	
	@Inject
	private ModelPathManager modelPathManager;
	
	@Override
	public IWorkspaceConfig getWorkspaceConfig(List<WorkspaceFolder> workspaceFolders) {
		WorkspaceConfig workspaceConfig = new WorkspaceConfig() {
			// The project of a file is its closest project root directory.
			// The default implementation only considers source folders.
			@Override
			public IProjectConfig findProjectContaining(URI member) {
				// Unfortunately getProjects uses a generic wildcard in its return type.
				return ((Set<IProjectConfig>) getProjects()).stream()
					.filter(project -> project.getPath() != null && UriUtil.isPrefixOf(project.getPath(), member))
					.max(Comparator.comparingInt(project -> project.getPath().segmentCount()))
					.orElseGet(() -> (IProjectConfig) (new UnknownProjectConfig(this)));
			}
		};
		
		// Configure the projects of the workspace and their source folders
		HashSet<String> existingNames = new HashSet<>();
		for(WorkspaceFolder folder : workspaceFolders) {
			FileProjectConfig project = new FileProjectConfig(
				getUriExtensions().toUri(folder.getUri()),
				getUniqueProjectName(folder.getName(), existingNames),
				workspaceConfig);
			modelPathManager.getModelDirectories(folder.getUri()).forEach(project::addSourceFolder);
			workspaceConfig.addProject(project);
		}
		return workspaceConfig;
	}
	
	@Override
	protected String getUniqueProjectName(String proposal, Set<String> existingNames) {
		// We can't handle projects with the same name properly because dependencies are declared by project name.
		if(existingNames.contains(proposal))
			LOG.warn("Multiple workspace folders with name " + proposal);
		return super.getUniqueProjectName(proposal, existingNames);
	}
}
