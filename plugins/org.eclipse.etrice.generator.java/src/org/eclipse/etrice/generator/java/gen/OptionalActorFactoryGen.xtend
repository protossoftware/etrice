package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance

class OptionalActorFactoryGen {

	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	
	def doGenerate(Root root) {
		for (oi: root.optionalInstances) {
			val ac = oi.actorClass
			val path = ac.generationTargetPath+ac.path
			val infopath = ac.generationInfoPath+ac.path
			val file = ac.getJavaFactoryFileName
			fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, root.generate(oi))
		}
	}
	
	def generate(Root root, OptionalActorInstance oi) {
		val ac = oi.actorClass
		val clsname = ac.javaFactoryName
		'''
			package «ac.package»;
			
			import «ac.package».«ac.name»;
			import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
			import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
			import org.eclipse.etrice.runtime.java.modelbase.PathToPeers;
			
			public class «clsname» implements IOptionalActorFactory {
				
				private PathToPeers path2peers = new PathToPeers();
				
				public «ac.name» create(OptionalActorInterfaceBase ai, String name) {
					// set port mappings of this sub tree
					«FOR ai : oi.allSubInstances»
						«val ports = if (ai instanceof ActorInstance) (ai as ActorInstance).orderedIfItemInstances else ai.ports»
						«FOR pi : ports»
							«IF pi.peers.size>0»
								path2peers.put("«oi.relPath(pi)»", «FOR peer : pi.peers SEPARATOR ","»"«oi.relPath(peer)»"«ENDFOR»);
							«ENDIF»
						«ENDFOR»
					«ENDFOR»
					ai.setPath2peers(path2peers);
					
					// instantiate sub tree
					«ac.name» actor = new «ac.name»(ai, name);
					
					ai.setPath2peers(null);
					
					return actor;
				}
			}
		'''
	}
	
	def private relPath(OptionalActorInstance oi, InterfaceItemInstance pi) {
		var path = pi.path.substring(oi.actorClass.name.length+1)
			
		return path
	}
}