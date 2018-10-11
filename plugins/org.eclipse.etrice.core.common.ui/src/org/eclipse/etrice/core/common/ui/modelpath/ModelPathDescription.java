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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;

/**
 * Represent a modelpath description.
 */
public class ModelPathDescription {
	
	private final List<IFolder> sourceDirectories;
	private final List<IProject> projectDependencies;
	
	private ModelPathDescription(List<IFolder> sourceDirectories, List<IProject> projectDependencies) {
		this.sourceDirectories = sourceDirectories;
		this.projectDependencies = projectDependencies;
	}
	
	/**
	 * @return the list of source directories
	 */
	public List<IFolder> getSourceDirectories() {
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
	 * Helper class to parse and validate modelpath description files.
	 */
	private static class ModelPathDescriptionLoader {
		
		private static final String KEYWORD_SRCDIR = "srcDir";
		private static final String KEYWORD_PROJECT = "project";
		private static final Pattern KEYWORD_PATTERN = Pattern.compile("\\S+");
		
		private IFile file;
		private IProject project;
		private IWorkspaceRoot root;
		private List<IFolder> srcDirs;
		private List<IProject> projects;
		private int lineNumber;
		
		public ModelPathDescriptionLoader(IFile file) {
			this.file = file;
			project = file.getProject();
			root = ResourcesPlugin.getWorkspace().getRoot();
			srcDirs = new ArrayList<>();
			projects = new ArrayList<>();
			lineNumber = 0;
		}
		
		public ModelPathDescription load() throws CoreException, IOException {
			file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_ZERO);
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()))) {
				for(String line = reader.readLine(); line != null; line = reader.readLine(), lineNumber++) {
					parseLine(line);
				}
			}
			
			return new ModelPathDescription(Collections.unmodifiableList(srcDirs), Collections.unmodifiableList(projects));
		}
		
		private void parseLine(String line) throws CoreException {
			Matcher matcher = KEYWORD_PATTERN.matcher(line);
			if(matcher.find()) {
				String keyword = matcher.group();
				String str = line.substring(matcher.end()).trim();
				
				switch(keyword) {
				case KEYWORD_SRCDIR:
					parseSrcDir(str);
					break;
				case KEYWORD_PROJECT:
					parseProject(str);
					break;
				default:
					createProblemMarker(IMarker.SEVERITY_ERROR, "unexpected keyword " + keyword);
				}
			}
		}
		
		private void parseSrcDir(String str) throws CoreException {
			if(Path.EMPTY.isValidPath(str)) {
				IFolder dir = project.getFolder(str);
				if(!dir.exists()) {
					createProblemMarker(IMarker.SEVERITY_WARNING, "directory " + dir.getFullPath() + " doesn't exist");
				}
				srcDirs.add(dir);
			}
			else {
				createProblemMarker(IMarker.SEVERITY_ERROR, str + " isn't a valid path");
			}
		}
		
		private void parseProject(String str) throws CoreException {
			if(Path.EMPTY.isValidSegment(str)) {
				IProject project = root.getProject(str);
				if(!project.isAccessible()) {
					createProblemMarker(IMarker.SEVERITY_WARNING, "project " + project.getName() + " doesn't exist");
				}
				projects.add(project);
			}
			else {
				createProblemMarker(IMarker.SEVERITY_ERROR, str + " isn't a valid project name");
			}
		}
		
		private void createProblemMarker(int severity, String message) throws CoreException {
			IMarker marker = file.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber + 1);
			marker.setAttribute(IMarker.MESSAGE, message);
		}
	}
}