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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.xtext.ide.server.BuildManager;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.resource.impl.ProjectDescription;

/**
 * A build manager that respects project dependencies.
 * If a project is rebuilt, all downstream dependencies of that project are rebuilt as well.
 */
public class DependencyAwareBuildManager extends BuildManager {

	private WorkspaceManager workspaceManager;

	@Override
	protected List<ProjectDescription> sortByDependencies(Iterable<ProjectDescription> projectDescriptions) {
		// We abuse this sort function to add the downstream dependencies to the internal build of the super class.
		Set<String> projectNames = StreamSupport.stream(projectDescriptions.spliterator(), false)
				.map(ProjectDescription::getName).collect(Collectors.toSet());
		List<ProjectDescription> downstream = workspaceManager.getProjectManagers().stream()
				.map(ProjectManager::getProjectDescription)
				.filter(description -> projectNames.contains(description.getName())
					|| description.getDependencies().stream().anyMatch(projectNames::contains))
				.collect(Collectors.toList());
		return super.sortByDependencies(downstream);
	}

	@Override
	public void setWorkspaceManager(WorkspaceManager workspaceManager) {
		// The workspace manager attribute of the super class is private.
		super.setWorkspaceManager(workspaceManager);
		this.workspaceManager = workspaceManager;
	}
}
