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

package org.eclipse.etrice.core.common.scoping;

import java.util.Arrays;

import org.eclipse.emf.common.util.URI;
import org.eclipse.etrice.core.common.scoping.ModelPathGlobalScopeProvider.IModelPathFileFilter;

/**
 * Filters the model path by file extension.
 */
public class ModelPathFileExtensionFilter implements IModelPathFileFilter {

	private final String[] legalFileExtensions;
	
	/**
	 * Constructs new model path filter that only allows files with specific file extenions.
	 * 
	 * @param legalFileExtensions an array of permitted file extensions
	 */
	public ModelPathFileExtensionFilter(String... legalFileExtensions) {
		this.legalFileExtensions = legalFileExtensions;
		Arrays.sort(this.legalFileExtensions);
	}
	
	@Override
	public boolean apply(URI uri) {
		String fileExtension = uri.fileExtension();
		if(fileExtension != null) {
			return Arrays.binarySearch(legalFileExtensions, fileExtension) >= 0;
		}
		return false;
	}

}
