/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base;

import com.google.inject.ImplementedBy;

/**
 * @author Henrik Rentz-Reichert
 *
 */
@ImplementedBy(IncrementalGenerationFileIo.class)
public interface IGeneratorFileIo {

	/**
	 * This method saves the contents in a file in the given path.
	 * Implementations may use the infopath for extra information like a hash key
	 * for incremental generation.
	 * 
	 * @param desc a description which is may be logged
	 * @param path the file system path for the generated file
	 * @param infopath the file system path for the generated info file (if used by the implementation)
	 * @param file the file name of the generated file
	 * @param contents the contents of the generated file
	 */
	void generateFile(String desc, String path, String infopath, String file, CharSequence contents);
}
