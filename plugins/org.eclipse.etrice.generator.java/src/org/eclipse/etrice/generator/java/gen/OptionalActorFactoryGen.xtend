package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance

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
					«FOR pi : oi.ports»
						«IF pi.peers.size>0»
							path2peers.put("«pi.path»", «FOR peer : pi.peers SEPARATOR ","»"«peer.path»"«ENDFOR»);
						«ENDIF»
					«ENDFOR»
					ai.setPath2peers(path2peers);
					
					// instantiate sub tree
					return new «ac.name»(ai, ai.getName());
				}
			}
		'''
	}
}