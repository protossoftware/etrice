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
import java.io.File
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static java.lang.Runtime.*
import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.core.genmodel.fsm.ILogger

@Singleton
class InstanceDiagramGen {

	@Inject extension JavaIoFileSystemAccess fileAccess
	@Inject extension RoomExtensions roomExt
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (model: root.models) {
			var path = model.docGenerationTargetPath+ "/images"
			fileAccess.setOutputPath(path)
			var batchFile = "dot2jpg.bat"
			for (sys : root.systemInstances) {
				var file = sys.name+"_instanceTree.dot"
				logger.logInfo("generating instance tree diagram: '"+file+"' in '"+path+"'")
				fileAccess.generateFile(file, root.generate(sys))
			}
			fileAccess.generateFile(batchFile, root.generate2jpg())
			runDot2Jpg(path, batchFile)
		}
	}
	
	// generate batch file to convert .dot to .jpg
	// dot -Tjpg -oSS.jpg SS.dot	
	def private generate2jpg(Root root){
		'''
			«FOR sys : root.systemInstances»
				dot -Tjpg -o «sys.name»_instanceTree.jpg «sys.name»_instanceTree.dot
			«ENDFOR»
		'''
	}
	
	def private generate(Root root, SystemInstance sys) {
		'''
			digraph «sys.name» {
				rankdir=LR;
				node [shape=box];
				«sys.path.getPathName()» [label="«sys.name»\n(«sys.name»)" style=filled color=red];
				«FOR ssi : sys.instances»
					«ssi.path.getPathName()» [label="«ssi.name»\n(«ssi.subSystemClass.name»)" style=filled color=yellow];
					«sys.path.getPathName()» -> «ssi.path.getPathName()»;  
					«FOR ai : ssi.instances»
						«instance(ai)»
					«ENDFOR»
				«ENDFOR»
			}
		'''
	}
	
	def private String instance(AbstractInstance ai) {
		val parent = ai.eContainer as StructureInstance
		val pthread = ETMapUtil::getMappedThread(ai)
		val tname = if (pthread==null) "?" else pthread.thread.name
		val node = ETMapUtil::getNodeRef(ai)
		val nname = if (node==null) "?" else node.name
		val optional = if (ai instanceof ActorInterfaceInstance) "optional " else ""
		val clsname = if (ai instanceof ActorInstance) (ai as ActorInstance).actorClass.name
			else if (ai instanceof ActorInterfaceInstance) (ai as ActorInterfaceInstance).actorClass.name else "?"
			
		'''
			«ai.path.getPathName()» [label="«optional»«ai.name»\n(«clsname»)\n@«nname»:«tname»"«IF !optional.empty» color=blue style=dashed«ENDIF»];
			«parent.path.getPathName()» -> «ai.path.getPathName()»;
			«IF ai instanceof StructureInstance»
				«FOR sub_ai : (ai as StructureInstance).instances»
					«instance(sub_ai)»
				«ENDFOR»
			«ENDIF» 
		'''
	}

 	def private runDot2Jpg(String path, String bat){
 		var wdir = new File(path)
 		try {
			val p = getRuntime.exec("cmd /C "+bat, null, wdir)
			logger.logInfo(bat+" finished with "+p.waitFor)
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
	