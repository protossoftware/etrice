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

package org.eclipse.etrice.generator.base;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO;
import org.eclipse.etrice.generator.base.logging.ILogger;

/**
 * A generator that produces code from an emf resource.
 */
public interface IGenerator {
		
	/**
	 * Generates code for the passed resources.
	 * 
	 * @param resources the resources to generate the code from
	 * @param arguments the generator arguments
	 * @param fileIO the file access
	 * @param logger the logger
	 */
	void generate(List<Resource> resources, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) throws GeneratorException;
	
}
