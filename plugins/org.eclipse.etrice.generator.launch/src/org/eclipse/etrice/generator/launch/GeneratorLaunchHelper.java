/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;

import com.google.inject.Inject;

public class GeneratorLaunchHelper {
	
	@Inject
	private XtextResourceSetProvider resourceSetProvider;
	
	public GeneratorLaunchHelper() {
		 RoomUiModule.getInjector().injectMembers(this);
	}
	
	/**
	 * Loads some files of a project and optionally their dependencies within the project.
	 * 
	 * @param project the project of the files to load
	 * @param files the files to load as resources
	 * @param includeDependencies whether to include dependencies within the project of the resources 
	 * @return all transitive dependencies from files within the project
	 */
	public List<Resource> loadResources(IProject project, List<IFile> files, boolean includeDependencies) throws CoreException {
		ResourceSet resourceSet = resourceSetProvider.get(project);
		List<URI> uris = files.stream()
			.map(file -> URI.createPlatformResourceURI(file.getFullPath().toString(), true))
			.collect(Collectors.toList());
		
		for(URI uri : uris) {
			try {
				resourceSet.getResource(uri, true);
			}
			catch(RuntimeException e) {
				throw new CoreException(new Status(Status.ERROR, getClass(),
					"Failed to load resource " + uri, e));
			}
		}
		
		EcoreUtil.resolveAll(resourceSet);
		
		if(includeDependencies) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			return resourceSet.getResources().stream()
				.filter(resource ->
					resource.getURI().isPlatformResource() &&
					root.getFile(new Path(resource.getURI().toPlatformString(true))).getProject().equals(project))
				.collect(Collectors.toList());
		}
		return uris.stream().map(uri -> resourceSet.getResource(uri, false)).collect(Collectors.toList());
	}
	
}
