/*******************************************************************************
* Copyright (c) 2013 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Henrik Rentz-Reichert (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.io;

import com.google.inject.ImplementedBy;

/**
 * @author Henrik Rentz-Reichert
 *
 */
@ImplementedBy(GeneratorFileIO.class)
public interface IGeneratorFileIO {

	/**
	 * Saves the contents in a file at the given path.
	 * 
	 * @param filePath the file path of the generated file
	 * @param content the contents of the generated file
	 */
	void generateFile(String filePath, CharSequence content);
	
	/**
	 * @return the configured output path
	 */
	String getOutputPath();
	
	/**
	 * logs some introduction with the output directory that was configured
	 */
	void logIntro();
	
	/**
	 * This method saves the contents in a file in the given path.
	 * 
	 * @param description a description which may be logged
	 * @param filePath the file path name of the generated file
	 * @param content the contents of the generated file
	 */
	default void generateFile(String description, String filePath, CharSequence content) {
		generateFile(filePath, content);
	}
	
}
