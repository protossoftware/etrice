/*******************************************************************************
* Copyright (c) 2021 protos software gmbh (http://www.protos.de).
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

import java.nio.file.Path;

import org.eclipse.emf.common.util.URI;

/**
 * Utility class for {@link java.nio.Path} 
 */
public class NIOPathUtil {
	
	/**
	 * Convert a path object to an emf uri. If the authority is absent an empty authority is added.
	 * 
	 * @param path the path to convert
	 * @return an emf uri representing the path
	 */
	public static URI toEMFUri(Path path) {
		URI uri = URI.createURI(path.toUri().toString());
		if(uri.isFile() && !uri.hasAuthority())
			return URI.createHierarchicalURI(uri.scheme(), "", uri.device(), uri.segments(), uri.query(), uri.fragment());
		return uri;
	}
	
}
