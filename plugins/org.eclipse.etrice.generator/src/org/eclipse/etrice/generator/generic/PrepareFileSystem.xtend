/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO

/**
 * A class that is used to place a readme file in the generation directory.
 */
@Singleton
class PrepareFileSystem {
	
	@Inject IGeneratorFileIO fileIO
	
	/**
	 * Place a readme.txt in the generation directory.
	 */
	def void prepare() {
		fileIO.generateFile("readme.txt", readmeText)
	}
	
	def private readmeText() {
		'''
			This directory is an eTrice code generation target.
			It will be erased every time the generator is executed.
			
			DO NOT PLACE OTHER FILES HERE!
		'''
	}
}