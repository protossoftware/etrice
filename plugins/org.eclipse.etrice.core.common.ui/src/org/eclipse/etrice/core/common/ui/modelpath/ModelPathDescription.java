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

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.etrice.core.common.ide.modelpath.ModelPathDescriptionLexer;
import org.eclipse.etrice.core.common.ide.modelpath.ModelPathDescriptionLexer.ModelPathDescriptionEntry;

/**
 * Represents a modelpath description.
 */
public class ModelPathDescription {
	
	private final List<IContainer> sourceDirectories;
	private final List<IProject> projectDependencies;
	
	private ModelPathDescription(List<IContainer> sourceDirectories, List<IProject> projectDependencies) {
		this.sourceDirectories = sourceDirectories;
		this.projectDependencies = projectDependencies;
	}
	
	/**
	 * @return the list of source directories
	 */
	public List<IContainer> getSourceDirectories() {
		return sourceDirectories;
	}
	
	/**
	 * @return the list of project dependencies
	 */
	public List<IProject> getProjectDependencies() {
		return projectDependencies;
	}
	
	/**
	 * Loads the modelpath description from a file.
	 * 
	 * @param file the file to load from
	 * @return the loaded modelpath description
	 * 
	 * @throws CoreException if the file doesn't exist or is out of sync
	 * @throws UncheckedIOException if an io exception occurs
	 */
	public static ModelPathDescription load(IFile file) throws CoreException {
		try {
			return new ModelPathDescriptionLoader(file).load();
		}
		catch(IOException e) {
			throw new UncheckedIOException(e);
		}
	}
	
	/**
	 * Helper class to load and validate modelpath description files.
	 */
	private static class ModelPathDescriptionLoader {
		
		private IFile file;
		private IProject project;
		private IWorkspaceRoot root;
		private List<IContainer> srcDirs;
		private List<IProject> projects;
		
		public ModelPathDescriptionLoader(IFile file) {
			this.file = file;
			project = file.getProject();
			root = ResourcesPlugin.getWorkspace().getRoot();
			srcDirs = new ArrayList<>();
			projects = new ArrayList<>();
		}
		
		public ModelPathDescription load() throws CoreException, IOException {
			file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_ZERO);
			
			try(InputStream input = file.getContents()) {
				for(ModelPathDescriptionEntry entry : ModelPathDescriptionLexer.read(input)) {
					parseEntry(entry);
				}
			}
			
			return new ModelPathDescription(Collections.unmodifiableList(srcDirs), Collections.unmodifiableList(projects));
		}
		
		private void parseEntry(ModelPathDescriptionEntry entry) throws CoreException {
			switch(entry.key) {
			case ModelPathDescriptionLexer.MODELPATH_KEYWORD_SRCDIR:
				parseSrcDir(entry.value, entry.lineNumber);
				break;
			case ModelPathDescriptionLexer.MODELPATH_KEYWORD_PROJECT:
				parseProject(entry.value, entry.lineNumber);
				break;
			default:
				createProblemMarker(IMarker.SEVERITY_ERROR, entry.lineNumber, "unexpected keyword " + entry.key);
			}
		}
		
		private void parseSrcDir(String value, int lineNumber) throws CoreException {
			if(value.isEmpty()) {
				createProblemMarker(IMarker.SEVERITY_ERROR, lineNumber, "directory path is missing");
				return;
			}
			if(!Path.EMPTY.isValidPath(value)) {
				createProblemMarker(IMarker.SEVERITY_ERROR, lineNumber, value + " isn't a valid path");
				return;
			}
			
			try {
				IContainer dir = project.getFolder(value);
				if(!dir.exists()) {
					createProblemMarker(IMarker.SEVERITY_WARNING, lineNumber, "directory " + dir.getFullPath() + " doesn't exist");
				}
				srcDirs.add(dir);
			}
			catch(IllegalArgumentException e) {
				createProblemMarker(IMarker.SEVERITY_ERROR, lineNumber, value + " is not a valid directory");
			}
		}
		
		private void parseProject(String value, int lineNumber) throws CoreException {
			if(value.isEmpty()) {
				createProblemMarker(IMarker.SEVERITY_ERROR, lineNumber, "project name is missing");
				return;
			}
			if(!Path.EMPTY.isValidSegment(value)) {
				createProblemMarker(IMarker.SEVERITY_ERROR, lineNumber, value + " isn't a valid project name");
				return;
			}
			
			IProject project = root.getProject(value);
			if(!project.isAccessible()) {
				createProblemMarker(IMarker.SEVERITY_WARNING, lineNumber, "project " + project.getName() + " doesn't exist");
			}
			projects.add(project);
		}
		
		private void createProblemMarker(int severity, int lineNumber, String message) throws CoreException {
			IMarker marker = file.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber + 1);
			marker.setAttribute(IMarker.MESSAGE, message);
		}
	}
}