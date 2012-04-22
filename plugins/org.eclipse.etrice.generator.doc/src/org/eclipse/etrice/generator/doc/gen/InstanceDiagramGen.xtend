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

package org.eclipse.etrice.generator.doc.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.base.ILogger
import org.eclipse.etrice.generator.base.IRoomGenerator
import org.eclipse.etrice.generator.etricegen.ActorInstance
import org.eclipse.etrice.generator.etricegen.Root
import org.eclipse.etrice.generator.etricegen.StructureInstance
import org.eclipse.etrice.generator.etricegen.SubSystemInstance
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import static java.lang.Runtime.*
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class InstanceDiagramGen implements IRoomGenerator {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension RoomExtensions roomExt
	@Inject ILogger logger
	
		override doGenerate(Root root) {
		for (model: root.models) {
			var path = model.docGenerationTargetPath+ "/images"
			fileAccess.setOutputPath(path)
			var file2 = "dot2jpg.bat"
			for(sc:root.subSystemInstances){
				var file = sc.name+"_instanceTree.dot"
				logger.logInfo("generating LaTeX documentation: '"+file+"' in '"+path+"'")
				fileAccess.generateFile(file, root.generate(sc,sc.subSystemClass))
			}
			fileAccess.generateFile(file2, root.generate2jpg())
			runDot2Jpg()
		}
	}
	
	// generate batch file to convert .dot to .jpg
	// dot -Tjpg -oSS.jpg SS.dot	
	def generate2jpg(Root root){'''
		«FOR sc : root.subSystemInstances»
			dot -Tjpg -o «sc.name»_instanceTree.jpg «sc.name»_instanceTree.dot
		«ENDFOR»
		'''
	}
	
	def generate(Root root, SubSystemInstance ssi, SubSystemClass ssc) {'''
		digraph «ssi.name» {
			rankdir=LR;
			node [shape=box];
			«ssi.path.getPathName()» [label="«ssc.name»\n(«ssi.name»)" style=filled color=yellow];
			«FOR ai : ssi.instances»
				«instance(ai)»
			«ENDFOR»
		}
	'''
	}
	
	def instance(ActorInstance ai) {'''
		«var parent = ai.eContainer as StructureInstance»
		«ai.path.getPathName()» [label="«ai.name»\n(«ai.actorClass.name»)"];
		«parent.path.getPathName()» -> «ai.path.getPathName()»;  
		«FOR sub_ai : ai.instances»
			«instance(sub_ai)»
		«ENDFOR»
	'''}

 	def runDot2Jpg(){
 		try{
			getRuntime.exec("dot2jpg.bat");
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
	