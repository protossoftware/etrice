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
	private final List<IMarker> problemMarkers;
	
	private ModelPathDescription(List<IFolder> sourceDirectories, List<IProject> projectDependencies, List<IMarker> problemMarkers) {
		this.sourceDirectories = sourceDirectories;
		this.projectDependencies = projectDependencies;
		
		this.problemMarkers = problemMarkers;
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
	 * @return the list of problem markers
	 */
	public List<IMarker> getProblemMarkers() {
		return problemMarkers;
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
		private List<IMarker> problemMarkers;
		private int lineNumber;
		
		public ModelPathDescriptionLoader(IFile file) {
			this.file = file;
			project = file.getProject();
			root = ResourcesPlugin.getWorkspace().getRoot();
			srcDirs = new ArrayList<>();
			projects = new ArrayList<>();
			problemMarkers = new ArrayList<IMarker>();
			lineNumber = 0;
		}
		
		public ModelPathDescription load() throws CoreException, IOException {
			file.deleteMarkers(IMarker.PROBLEM, false, IResource.DEPTH_ZERO);
			
			try(BufferedReader reader = new BufferedReader(new InputStreamReader(file.getContents()))) {
				for(String line = reader.readLine(); line != null; line = reader.readLine(), lineNumber++) {
					line = trimComments(line);
					parseLine(line);
				}
			}
			
			return new ModelPathDescription(Collections.unmodifiableList(srcDirs),
					Collections.unmodifiableList(projects),
					Collections.unmodifiableList(problemMarkers));
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
					addProblemMarker(IMarker.SEVERITY_ERROR, "unexpected keyword " + keyword);
				}
			}
		}
		
		private String trimComments(String line) {
			int index = line.indexOf("//");
			if(index != -1) {
				line = line.substring(0, index);
			}
			return line;
		}
		
		private void parseSrcDir(String str) throws CoreException {
			if(str.isEmpty()) {
				addProblemMarker(IMarker.SEVERITY_ERROR, "directory path is missing");
				return;
			}
			if(!Path.EMPTY.isValidPath(str)) {
				addProblemMarker(IMarker.SEVERITY_ERROR, str + " isn't a valid path");
				return;
			}
			
			IFolder dir = project.getFolder(str);
			if(!dir.exists()) {
				addProblemMarker(IMarker.SEVERITY_WARNING, "directory " + dir.getFullPath() + " doesn't exist");
			}
			srcDirs.add(dir);
		}
		
		private void parseProject(String str) throws CoreException {
			if(str.isEmpty()) {
				addProblemMarker(IMarker.SEVERITY_ERROR, "project name is missing");
				return;
			}
			if(!Path.EMPTY.isValidSegment(str)) {
				addProblemMarker(IMarker.SEVERITY_ERROR, str + " isn't a valid project name");
				return;
			}
			
			IProject project = root.getProject(str);
			if(!project.isAccessible()) {
				addProblemMarker(IMarker.SEVERITY_WARNING, "project " + project.getName() + " doesn't exist");
			}
			projects.add(project);
		}
		
		private void addProblemMarker(int severity, String message) throws CoreException {
			IMarker marker = file.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.SEVERITY, severity);
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber + 1);
			marker.setAttribute(IMarker.MESSAGE, message);
			problemMarkers.add(marker);
		}
	}
}