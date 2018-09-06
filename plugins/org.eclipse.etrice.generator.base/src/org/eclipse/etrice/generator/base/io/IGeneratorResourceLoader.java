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

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.generator.base.GeneratorException;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.ImplementedBy;

/**
 * Loads and resolves resources.
 */
@ImplementedBy(GeneratorResourceLoader.class)
public interface IGeneratorResourceLoader {
	
	/**
	 * Loads the specified files.
	 * 
	 * @param files the files to load
	 * @param arguments the generator arguments
	 * @param logger the logger
	 * @return the loaded resources
	 */
	List<Resource> load(List<String> files, Arguments arguments, ILogger logger) throws GeneratorException;
	
}
