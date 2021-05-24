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

package org.eclipse.etrice.core.common.ide.modelpath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.eclipse.etrice.generator.base.io.FileSystemModelPath.ModelDirectory;
import org.eclipse.etrice.core.common.ide.modelpath.ModelPathDescriptionLexer.ModelPathDescriptionEntry;
import org.eclipse.etrice.generator.base.io.FileSystemModelPath;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.lsp4j.FileChangeType;
import org.eclipse.lsp4j.FileEvent;
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.inject.Inject;

/**
 * Manages the modelpath configurations of all projects in the workspace.
 * The manager must be informed about changes to workspace folders as well as
 * changes to files in the workspace. 
 */
public class ModelPathManager {
	
	private static final Logger LOG = Logger.getLogger(ModelPathManager.class);
	
	public static final String MODELPATH_FILE_NAME = "modelpath";
	
	// workspace folder names are *not* unique
	private Map<Path, ModelPathDescription> descriptions;
	private ListMultimap<String, ModelPathDescription> name2description;
	private Map<Path, FileSystemModelPath> modelpaths;
	
	@Inject
	public ModelPathManager() {
		descriptions = new HashMap<>();
		name2description = MultimapBuilder.hashKeys().arrayListValues().build();
		modelpaths = Collections.emptyMap();
	}
	
	/**
	 * Retrieves the modelpath for the specified project.
	 * 
	 * @param uri the uri of the project
	 * @return the modelpath of the project
	 */
	public IModelPath getModelPath(String uri) {
		return uriToPath(uri).<IModelPath>map(modelpaths::get).orElse(IModelPath.EMPTY);
	}
	
	/**
	 * @param uri the uri of the project
	 * @return a stream of paths to model directories relative to the project directory
	 */
	public Stream<String> getModelDirectories(String uri) {
		return uriToPath(uri).map(descriptions::get)
			.map(description -> description.modelDirs.stream()
				.map(dir -> description.path.relativize(dir.getPath()).toString()))
			.orElse(Stream.empty());
	}
	
	/**
	 * @param uri the uri of the project
	 * @return a set of all dependencies of the project including transitive dependencies
	 */
	public Set<String> getProjectDependencies(String uri) {
		return uriToPath(uri).map(descriptions::get)
			.<Set<String>>map(this::getAllDependencies).orElse(Collections.emptySet());
	}
	
	/**
	 * Informs this modelpath manager about added and removed workspace folders.
	 * 
	 * @param added the list of added workspace folders
	 * @param removed the list of removed workspace folders
	 */
	public void workspaceFoldersChanged(List<WorkspaceFolder> added, List<WorkspaceFolder> removed) {
		removed.forEach(folder ->
			uriToPath(folder.getUri()).ifPresent(path -> discardDescription(path, folder.getName())));
		added.forEach(folder ->
			uriToPath(folder.getUri()).ifPresent(path -> loadDescription(path, folder.getName())));
		computeModelPaths();
	}
	
	/**
	 * Informs this modelpath manager about file changes in the workspace.
	 * 
	 * @param changes the list of changes in the workspace
	 * @return {@code true} if the modelpath description of some projects changed and
	 * the workspace must be refreshed, {@code false} otherwise
	 */
	public boolean filesChanged(List<FileEvent> changes) {
		ArrayList<Pair<Path, String>> dirtyDescriptions = new ArrayList<>();
		changes.forEach(event -> {
			uriToPath(event.getUri()).ifPresent(path -> {
				findDescription(path).ifPresent(description -> {
					// If the changed file is a modelpath description file, mark it as dirty.
					if(description.path.resolve(MODELPATH_FILE_NAME).equals(path)) {
						dirtyDescriptions.add(Pair.of(description.path, description.name));
					}
					if(event.getType() != FileChangeType.Changed) {
						// If the changed file belongs to a model directory, update the index of that directory.
						findDirectory(description, path).ifPresent(modelDir -> {
							if(event.getType() == FileChangeType.Created && Files.isRegularFile(path))
								modelDir.addFile(path);
							else if(event.getType() == FileChangeType.Deleted)
								modelDir.removeFile(path);
						});
					}
				});
			});
		});
		
		// Reload all changed modelpath description files and recompute the modelpaths if necessary.
		if(!dirtyDescriptions.isEmpty()) {
			dirtyDescriptions.forEach(pair -> {
				discardDescription(pair.getKey(), pair.getValue());
				loadDescription(pair.getKey(), pair.getValue());
			});
			computeModelPaths();
			return true;
		}
		return false;
	}
	
	/**
	 * Computes the modelpaths of all projects currently in the workspace.
	 */
	private void computeModelPaths() {
		modelpaths = descriptions.values().stream().collect(Collectors.toMap(
			description -> description.path,
			description -> Stream
				.concat(Stream.of(description),
					getAllDependencies(description).stream().flatMap(name -> name2description.get(name).stream()))
				.flatMap(descr -> descr.modelDirs.stream())
				.collect(Collectors.collectingAndThen(Collectors.toList(), FileSystemModelPath::new))));
	}
	
	/**
	 * @param description the modelpath description of the project
	 * @return a set of all dependencies of the project including transitive depdendencies
	 */
	private HashSet<String> getAllDependencies(ModelPathDescription description) {
		HashSet<String> dependencies = new HashSet<>();
		description.dependencies.forEach(name -> addAllDependencies(name, dependencies));
		return dependencies;
	}
	
	// Recursive helper function to compute transitive dependencies
	private void addAllDependencies(String name, HashSet<String> dependencies) {
		if(dependencies.add(name)) {
			name2description.get(name).forEach(description ->
				description.dependencies.forEach(dependency ->
					addAllDependencies(dependency, dependencies)));
		}
	}
	
	/**
	 * Loads the modelpath description file of a project.
	 * 
	 * @param path the path to the project
	 * @param name the name of the project
	 */
	private void loadDescription(Path path, String name) {
		// Parse the content of the modelpath description file
		Path file = path.resolve(MODELPATH_FILE_NAME);
		List<ModelPathDescriptionEntry> entries = Collections.emptyList();
		if(Files.isRegularFile(file)) {
			try(InputStream input = Files.newInputStream(file)) {
				entries = ModelPathDescriptionLexer.read(input); 
			}
			catch(IOException e) {
				LOG.error("Failed to read modelpath description file " + file + " of project " + name, e);
			}
		}
		
		// Interpret the modelpath description entries
		List<ModelDirectory> modelDirs = new ArrayList<>();
		List<String> dependencies = new ArrayList<>();
		entries.forEach(entry -> {
			if(entry.key.equals(ModelPathDescriptionLexer.MODELPATH_KEYWORD_SRCDIR)) {
				try {
					Path dir = path.resolve(entry.value);
					modelDirs.add(new ModelDirectory(dir));
				}
				catch(InvalidPathException e) {
					LOG.error("Invalid model directory name " + entry.value + " in modelpath description of project " + name);
				}
			}
			else if(entry.key.equals(ModelPathDescriptionLexer.MODELPATH_KEYWORD_PROJECT)) {
				dependencies.add(entry.value);
			}
			else {
				LOG.error("Unknown keyword " + entry.key + " in modelpath description of project " + name);
			}
		});
		
		// Build the initial index of the model directories
		modelDirs.forEach(modelDir -> {
			if(Files.isDirectory(modelDir.getPath())) {
				try {
					modelDir.indexDirectory();
				}
				catch(IOException e) {
					LOG.error("Failed to read model directory " + modelDir.getPath() + " of project " + name, e);
				}
			}
			else {
				LOG.warn("Model directory " + modelDir.getPath() + " of project " + name + " does not exists.");
			}
		});
		
		// Update the maps with the new modelpath description
		ModelPathDescription description = new ModelPathDescription(path, name, modelDirs, dependencies);
		descriptions.put(path, description);
		name2description.put(name, description);
	}
	
	/**
	 * Discards the modelpath description of a project.
	 * 
	 * @param path the path to the project
	 * @param name the name of the project
	 */
	private void discardDescription(Path path, String name) {
		descriptions.remove(path);
		name2description.get(name).removeIf(description -> description.path.equals(path));
	}
	
	/**
	 * @param path a path
	 * @return the modelpath description of the project that contains the path, if any
	 */
	private Optional<ModelPathDescription> findDescription(Path path) {
		return descriptions.values().stream()
			.filter(description -> path.startsWith(description.path))
			.max(Comparator.comparingInt(description -> description.path.getNameCount()));
	}
	
	/**
	 * @param description a modelpath description of a project
	 * @param path a path within the project
	 * @return the model directory that contains the path, if any
	 */
	private Optional<ModelDirectory> findDirectory(ModelPathDescription description, Path path) {
		Optional<ModelDirectory> result = description.modelDirs.stream()
			.filter(dir -> path.startsWith(dir.getPath()))
			.max(Comparator.comparingInt(dir -> dir.getPath().getNameCount()));
		return result;
	}
	
	/**
	 * Tries to convert a uri to a path.
	 * If this is not possible, an empty optional is returned and an error is logged. 
	 * 
	 * @param uri the uri to covert to a path
	 * @return maybe the converted path
	 */
	private static Optional<Path> uriToPath(String uri) {
		try {
			return Optional.of(Path.of(java.net.URI.create(uri)));
		}
		catch(FileSystemNotFoundException e) {
			LOG.error("Unknown uri " + uri + "; " + e.getMessage(), e);
		}
		catch(IllegalArgumentException e) {
			LOG.error("Illegal uri " + uri + "; " + e.getMessage(), e);
		}
		return Optional.empty();
	}
	
	/** Represents a modelpath description file */
	private static class ModelPathDescription {
		public final Path path;
		public final String name;
		public final List<ModelDirectory> modelDirs;
		public final List<String> dependencies;
		
		public ModelPathDescription(Path path, String name, List<ModelDirectory> modelDirs, List<String> dependencies) {
			this.path = path;
			this.name = name;
			this.modelDirs = modelDirs;
			this.dependencies = dependencies;
		}
	}
	
}
