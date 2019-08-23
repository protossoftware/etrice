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
import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
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
	 * @param paths the paths to search for model files
	 */
	public WorkspaceModelPath(List<IContainer> paths) {
		this.paths = paths;
	}
	
	@Override
	public Stream<ModelFile> getFiles(QualifiedName name) {
		QualifiedName pkgName = name.skipLast(1);
		String fileName = name.getLastSegment();
		return getPackage(pkgName)
				.filter(mf -> mf.name.getLastSegment().equals(fileName));
	}

	@Override
	public Stream<ModelFile> getAllFiles() {
		return paths.stream()
				.filter(container -> container.isAccessible())
				.flatMap(container -> listAllFiles(container, QualifiedName.EMPTY));
	}
	
	@Override
	public Optional<QualifiedName> getQualifiedName(URI uri) {
		if(uri.isPlatform()) {
			IPath path = new Path(uri.toPlatformString(true));
			return paths.stream().map(container -> container.getFullPath())
				.filter(p -> p.isPrefixOf(path))
				.map(p -> path.makeRelativeTo(p).removeFileExtension())
				.map(p -> QualifiedName.create(p.segments()))
				.findFirst();
		}
		return Optional.empty();
	}
	
	@Override
	public boolean isEmpty() {
		return paths.isEmpty();
	}
	
	public List<IContainer> getPaths() {
		return paths;
	}
	
	@Override
	public String toString() {
		return paths.toString();
	}
	
	/**
	 * Constructs a stream of files contained in the specified package.
	 * 
	 * @param name the fully qualified name of the package
	 * @return a stream of files
	 */
	private Stream<ModelFile> getPackage(QualifiedName name) {
		Path path = new Path(name.toString("/"));
		return paths.stream()
			.map(container -> container.getFolder(path))
			.filter(folder -> folder.exists())
			.flatMap(folder -> listFiles(folder, name));
	}
	
	/**
	 * Constructs a stream of files contained in the specified container.
	 * 
	 * @param container the container to be searched for files
	 * @param name the qualified name of the container
	 * @return a stream of file uris
	 */
	private Stream<ModelFile> listFiles(IContainer container, QualifiedName name) {
		return getMembers(container)
			.filter(resource -> resource.getType() == IResource.FILE)
			.map(file -> createModelFile((IFile) file, name));
	}
	
	/**
	 * Constructs a stream that contains all files in the container including files of subfolders.
	 * 
	 * @param container the container to be searched for files
	 * @param name the qualified name of the container
	 * @return a stream of file uris
	 */
	private Stream<ModelFile> listAllFiles(IContainer container, QualifiedName name) {
		return getMembers(container)
			.flatMap(resource -> {
				if(resource.getType() == IResource.FILE) {
					return Stream.of(createModelFile((IFile) resource, name));
				}
				else if(resource.getType() == IResource.FOLDER) {
					IFolder subfolder = (IFolder) resource;
					return listAllFiles(subfolder, name.append(subfolder.getName()));
				}
				return Stream.empty();
			});
	}
	
	/**
	 * Creates a model file from an eclipse file and the name of the package.
	 * 
	 * @param file the eclipse file
	 * @param pkg the qualified name of the package
	 * @return the new model file
	 */
	private ModelFile createModelFile(IFile file, QualifiedName pkg) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		String fileName = file.getName();
		return ModelFile.create(uri, pkg, fileName);
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
