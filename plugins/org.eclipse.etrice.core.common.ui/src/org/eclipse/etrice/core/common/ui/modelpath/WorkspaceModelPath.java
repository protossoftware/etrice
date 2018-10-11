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

import java.util.List;
import java.util.stream.Stream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.generator.base.io.IModelPath;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * Modelpath implementation based on the eclipse workspace.
 */
public class WorkspaceModelPath implements IModelPath {
	
	private List<IContainer> paths;
	
	/**
	 * Constructs a new modelpath.
	 * 
	 * @param paths the paths to seach for model files
	 */
	public WorkspaceModelPath(List<IContainer> paths) {
		this.paths = paths;
	}
	
	@Override
	public Stream<URI> getFiles(QualifiedName name) {
		Stream<URI> stream = Stream.empty();
		while(!name.isEmpty()) {
			name = name.skipLast(1);
			stream = Stream.concat(stream, getPackage(name));
		}
		return stream;
	}

	@Override
	public Stream<URI> getAllFiles() {
		return paths.stream()
				.filter(container -> container.isAccessible())
				.flatMap(container -> getAllFiles(container));
	}
	
	public List<IContainer> getPaths() {
		return paths;
	}
	
	@Override
	public String toString() {
		return paths.toString();
	}
	
	/**
	 * Constructrs a stream of file contained in the specified package.
	 * 
	 * @param name the fully qualified name of the package
	 * @return a stream of file uris
	 */
	private Stream<URI> getPackage(QualifiedName name) {
		String pathStr = name.toString().replace('.', '/');
		Path path = new Path(pathStr);
		return paths.stream()
			.map(container -> container.getFolder(path))
			.filter(folder -> folder.exists())
			.flatMap(folder -> getFiles(folder));
	}
	
	/**
	 * Constructs a stream of files contained in the specified container.
	 * 
	 * @param container the container to be searched for files
	 * @return a stream of file uris
	 */
	private Stream<URI> getFiles(IContainer container) {
		return getMembers(container)
			.filter(resource -> resource.getType() == IResource.FILE)
			.map(IFile.class::cast)
			.map(file -> createURI(file));
	}
	
	/**
	 * Constructs a stream that contains all files in the container including files of subfolders.
	 * 
	 * @param container the container to be searched for files
	 * @return a stream of file uris
	 */
	private Stream<URI> getAllFiles(IContainer container) {
		return getMembers(container)
			.flatMap(resource -> {
				if(resource.getType() == IResource.FILE) {
					IFile file = (IFile) resource;
					URI uri = createURI(file);
					return Stream.of(uri);
				}
				else if(resource.getType() == IResource.FOLDER) {
					IFolder subfolder = (IFolder) resource;
					return getAllFiles(subfolder);
				}
				return Stream.empty();
			});
	}
	
	/**
	 * Creates an uri for the passed file.
	 */
	private URI createURI(IFile file) {
		return URI.createPlatformResourceURI(file.getFullPath().toString(), true);
	}
	
	/**
	 * Returns a stream of resources contained in the passed container.
	 */
	private Stream<IResource> getMembers(IContainer container) {
		try {
			return Stream.of(container.members());
		}
		catch(CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
}
