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

package org.eclipse.etrice.generator.doc.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.base.args.Arguments

import static org.eclipse.etrice.generator.doc.setup.DocGeneratorOptions.INCLUDE_IMAGES

@Singleton
class MainGen {
	
	@Inject InstanceDiagramGen instanceDiagramGen
	@Inject AsciiDocGen docGen
	
	def void doGenerate(Root root, Arguments args, IGeneratorFileIO fileIO) {
		val includeImages = args.get(INCLUDE_IMAGES)
		
		fileIO.logIntro();
		instanceDiagramGen.doGenerate(root, fileIO);
		docGen.doGenerate(root, fileIO, includeImages);
	}
}