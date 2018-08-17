/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.java.gen

import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import com.google.inject.Inject
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.room.EnumerationType

import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers

/**
 * @author Henrik Rentz-Reichert
 *
 */
class EnumerationTypeGen {

	@Inject IGeneratorFileIO fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject extension FileSystemHelpers
	
	def doGenerate(Root root) {
		for (et: root.enumClasses.filter(cl|cl.isValidGenerationLocation)) {
			var path = et.generationTargetPath+et.getPath
			var infopath = et.generationInfoPath+et.getPath
			var file = et.getJavaFileName
			fileIO.generateFile("generating Enumeration implementation", path, infopath, file, root.generate(et))
		}
	}
	
	def generate(Root root, EnumerationType et) {
		val type = et.targetType
		'''
		package «et.getPackage()»;
		
		public interface «et.name» {
			«FOR lit: et.literals»
				static final «type» «lit.name» = «lit.literalValue»;
			«ENDFOR»
		}
		'''
	}
	
}