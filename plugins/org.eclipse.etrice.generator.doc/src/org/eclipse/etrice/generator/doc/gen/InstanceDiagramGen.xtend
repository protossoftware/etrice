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
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance
import org.eclipse.etrice.generator.generic.RoomExtensions

import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO

@Singleton
class InstanceDiagramGen {

	@Inject extension RoomExtensions roomExt
	
	def doGenerate(Root root, IGeneratorFileIO fileIO) {
		var path = "images/"
		for (sys : root.systemInstances) {
			var file = sys.name+"_instanceTree.dot"
			fileIO.generateFile("generating instance tree diagram", path + file, root.generate(sys))
		}
	}
	
	def private generate(Root root, SystemInstance sys) '''
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
	
	def private String instance(AbstractInstance ai) {
		val parent = ai.eContainer as StructureInstance
		val pthread = ETMapUtil::getMappedThread(ai)
		val tname = if (pthread===null) "?" else pthread.thread.name
		val node = ETMapUtil::getNodeRef(ai)
		val nname = if (node===null) "?" else node.name
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
	
}
	