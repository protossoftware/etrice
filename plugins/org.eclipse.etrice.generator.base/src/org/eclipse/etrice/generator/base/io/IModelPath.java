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

import java.util.stream.Stream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.QualifiedName;

public interface IModelPath {
	
	public static final IModelPath EMPTY = new EmptyModelPath();
	
	/**
	 * Returns all files that could contain the object with the specified name.
	 * 
	 * @param name the fully qualified name of the object
	 * @return a stream of file uris
	 */
	public Stream<URI> getFiles(QualifiedName name);
	
	/**
	 * Returns all files on this modelpath.
	 * 
	 * @return a stream of file uris
	 */
	public Stream<URI> getAllFiles();
	
	static class EmptyModelPath implements IModelPath {
		
		@Override
		public Stream<URI> getFiles(QualifiedName name) {
			return Stream.empty();
		}

		@Override
		public Stream<URI> getAllFiles() {
			return Stream.empty();
		}
	}
}
