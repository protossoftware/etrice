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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

/**
 * Maintains the modelpaths for all eclipse projects.
 */
public class ModelPathManager implements IResourceChangeListener {
	
	public static final ModelPathManager INSTANCE = new ModelPathManager();
	
	public static final Path MODELPATH_FILE = new Path("modelpath");
	
	private HashMap<IProject, ModelPathDescription> descriptionCache;
	private HashMap<IProject, WorkspaceModelPath> modelpathCache;
	private List<IModelPathListener> listeners;
	
	@FunctionalInterface
	public interface IModelPathListener {
		
		/**
		 * Notifies of a change in the modelpath description file.
		 * 
		 * @param projects whose modelpath description has been changed
		 */
		void onChange(Collection<IProject> projects);
	}
	
	private ModelPathManager() {
		descriptionCache = new HashMap<>();
		modelpathCache = new HashMap<>();
		listeners = new ArrayList<>();
	}
	
	/**
	 * Retrieves the modelpath for the specified project.
	 * 
	 * @param project a project of the workspace
	 * @return the modelpath of project
	 */
	public synchronized WorkspaceModelPath getModelPath(IProject project) {
		return modelpathCache.computeIfAbsent(project, this::computeModelPath);
	}
	
	/**
	 * Adds a modelpath listener.
	 * 
	 * @param listener the listener to add
	 */
	public synchronized void addListener(IModelPathListener listener) {
		listeners.add(listener);
	}
	
	/**
	 * Removes a modelpath listener.
	 * 
	 * @param listener the listener to remove
	 */
	public synchronized void removeListener(IModelPathListener listener) {
		listeners.remove(listener);
	}
	
	/**
	 * Starts listening for changes in modelpath description files.
	 */
	public void startListening() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this, IResourceChangeEvent.POST_CHANGE);
	}

	/**
	 * Stops listening for changes in modelpath description files.
	 */
	public void stopListening() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(this);
	}
	
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		// Check for changes in the modelpath description files
		IResourceDelta rootDelta = event.getDelta();
		IResourceDelta[] projectDeltas = rootDelta.getAffectedChildren();
		ArrayList<IProject> projects = new ArrayList<>();
		for(IResourceDelta projectDelta: projectDeltas) {
			IResourceDelta modelpathDelta = projectDelta.findMember(MODELPATH_FILE);
			if(modelpathDelta != null &&
					((modelpathDelta.getFlags() & IResourceDelta.CONTENT) != 0
					|| modelpathDelta.getKind() == IResourceDelta.ADDED
					|| modelpathDelta.getKind() == IResourceDelta.REMOVED)) {
				IProject project = (IProject) projectDelta.getResource();
				projects.add(project);
			}
		}
		
		// Schedule update of modelpath if changes were detected
		if(!projects.isEmpty()) {
			new ModelPathUpdateJob(projects).schedule();
		}
	}
	
	/**
	 * Computes a workspace modelpath for the specified project.
	 * 
	 * @param project a project
	 * @return the workspace modelpath for the project
	 */
	private WorkspaceModelPath computeModelPath(IProject project) {
		Set<IProject> dependencies = new HashSet<>();
		addAllProjectDependencies(project, dependencies);
		List<IContainer> paths = dependencies.stream()
			.flatMap(p -> getSourceDirectories(p).stream())
			.collect(Collectors.toList());
		return new WorkspaceModelPath(paths);
	}
	
	/**
	 * Recursively adds all (including transitive) project dependencies of a project to the set of dependencies.
	 * 
	 * @param project a project
	 * @param dependencies a set to add the project dependencies
	 */
	private void addAllProjectDependencies(IProject project, Set<IProject> dependencies) {
		if(dependencies.add(project)) {
			getProjectDependencies(project).forEach(p -> addAllProjectDependencies(p, dependencies));
		}
	}
	
	/**
	 * Returns the modelpath description project dependencies of a project.
	 * 
	 * @param project a project
	 * @return a list of projects
	 */
	private List<IProject> getProjectDependencies(IProject project) {
		return getModelPathDescription(project)
			.map(ModelPathDescription::getProjectDependencies)
			.orElse(Collections.emptyList());
	}
	
	/**
	 * Return the modelpath description source directories of a project.
	 * 
	 * @param project a project
	 * @return a list of source directories
	 */
	private List<IFolder> getSourceDirectories(IProject project) {
		return getModelPathDescription(project)
			.map(ModelPathDescription::getSourceDirectories)
			.orElse(Collections.emptyList());
	}
	
	/**
	 * Retrieves a modelpath description for a project from the cache.
	 * If the description is not in the cache yet, it is loaded and added to the cache.
	 * 
	 * @param project a project
	 * @return the modelpath description of the project or nothing if the modelpath description file does not exist
	 */
	private Optional<ModelPathDescription> getModelPathDescription(IProject project) {
		return Optional.ofNullable(descriptionCache.computeIfAbsent(project, this::loadModelPathDescription));
	}
	
	/**
	 * Loads the modelpath description file of a project.
	 * 
	 * @param project a project
	 * @return the modelpath description or null if the file does not exist
	 */
	private ModelPathDescription loadModelPathDescription(IProject project) {
		IFile file = project.getFile(MODELPATH_FILE);
		if(file.exists()) {
			try {
				return ModelPathDescription.load(file);
			}
			catch(CoreException e) {
				try {
					file.refreshLocal(IResource.DEPTH_ZERO, null);
				}
				catch(CoreException ex) {}
			}
		}
		return null;
	}
	
	private class ModelPathUpdateJob extends WorkspaceJob {

		private Collection<IProject> projects;
		
		public ModelPathUpdateJob(Collection<IProject> projects) {
			super("modelpath updater");
			this.projects = projects;
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
			synchronized(ModelPathManager.this) {
				// Reload changed modelpath description files
				projects.forEach(project -> descriptionCache.compute(project, (p, d) -> loadModelPathDescription(p)));
				
				// Clear modelpath cache
				modelpathCache.clear();
				
				// Notify listeners of change
				listeners.forEach(listener -> listener.onChange(projects));
			}
			
			return Status.OK_STATUS;
		}
	}
}
