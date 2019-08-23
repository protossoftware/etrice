/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.io;

import java.util.Optional;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;

public interface IModelPath {
	
	public static final IModelPath EMPTY = new EmptyModelPath();
	
	/**
	 * Returns all files on this modelpath with the specified name.
	 * 
	 * @param name the name of the desired files
	 * @return a stream of files
	 */
	public Stream<ModelFile> getFiles(QualifiedName name);
	
	/**
	 * Returns all files on this modelpath.
	 * 
	 * @return a stream of files
	 */
	public Stream<ModelFile> getAllFiles();
	
	/**
	 * Returns a qualified name for the model objects in the file.
	 * 
	 * @param uri an uri to a file
	 * @return the qualified name for the file or nothing if the file is not on the modelpath.
	 */
	public Optional<QualifiedName> getQualifiedName(URI uri);
	
	/**
	 * Checks whether the modelpath is empty.
	 * 
	 * @return true if the modelpath is empty
	 */
	public boolean isEmpty();
	
	public static final class ModelFile {
		public final URI uri;
		public final QualifiedName name;
		public final String extension;
		
		public ModelFile(URI uri, QualifiedName name, String extension) {
			this.uri = uri;
			this.name = name;
			this.extension = extension;
		}

		/**
		 * Computes the name and extension of the new model file from package and file name. 
		 * 
		 * @param uri the uri of the file
		 * @param pkg the package of the file
		 * @param fileName the name of the file
		 * @return a new model file
		 */
		public static ModelFile create(URI uri, QualifiedName pkg, String fileName) {
			int periodIndex = fileName.lastIndexOf('.');
			if(periodIndex != -1) {
				String name = fileName.substring(0, periodIndex);
				String extension = fileName.substring(periodIndex + 1);
				return new ModelFile(uri, pkg.append(name), extension);
			}
			return new ModelFile(uri, pkg.append(fileName), "");
		}
	}
	
	public static class EmptyModelPath implements IModelPath {
		
		@Override
		public Stream<ModelFile> getFiles(QualifiedName name) {
			return Stream.empty();
		}

		@Override
		public Stream<ModelFile> getAllFiles() {
			return Stream.empty();
		}

		@Override
		public Optional<QualifiedName> getQualifiedName(URI uri) {
			return Optional.empty();
		}
		
		@Override
		public boolean isEmpty() {
			return true;
		}
	}
}
