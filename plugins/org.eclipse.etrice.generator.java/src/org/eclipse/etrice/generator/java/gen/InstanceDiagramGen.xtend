/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import com.google.inject.Inject

import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import static extension org.eclipse.xtext.xtend2.lib.*

import org.eclipse.etrice.core.room.*
import org.eclipse.etrice.generator.etricegen.*
import org.eclipse.etrice.generator.java.setup.Logger

class InstanceDiagramGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension StdExtensions stdExt
	@Inject Logger logger
	
	def doGenerate(Root root) {
		for (sc: root.subSystemInstances) {
			var path = sc.subSystemClass.generationTargetPath+sc.subSystemClass.getPath
			var file = sc.subSystemClass.name+".dot"
			logger.logInfo("generating instance diagram: '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(sc, sc.subSystemClass))
		}
	}
	
	def generate(Root root, SubSystemInstance ssc, SubSystemClass cc) {'''
		digraph �ssc.name� {
			rankdir=LR;
			node [shape=box];
			�cc.path.getPathName()� [label="�cc.name�\n(�ssc.name�)" style=filled color=yellow];
			�FOR ai : ssc.instances�
				�instance(ai)�
			�ENDFOR�
		}
	'''
	}
	
	def instance(ActorInstance ai) {'''
		�var parent = ai.eContainer as StructureInstance�
		�ai.path.getPathName()� [label="�ai.name�\n(�ai.actorClass.name�)"];
		�parent.path.getPathName()� -> �ai.path.getPathName()�;  
		�FOR sub_ai : ai.instances�
			�instance(sub_ai)�
		�ENDFOR�
	'''}	
}