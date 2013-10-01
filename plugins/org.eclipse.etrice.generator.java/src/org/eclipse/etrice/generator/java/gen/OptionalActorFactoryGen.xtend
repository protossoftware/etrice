package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance
import org.eclipse.etrice.core.room.ActorClass
import java.util.HashMap
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.core.room.CommunicationType

class OptionalActorFactoryGen {

	@Inject IGeneratorFileIo fileIO
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	
	def doGenerate(Root root) {
		val HashMap<ActorClass, WiredActorClass> ac2wired = new HashMap<ActorClass, WiredActorClass>
		root.wiredInstances.filter(w|w instanceof WiredActorClass).forEach[w|ac2wired.put((w as WiredActorClass).actorClass, w as WiredActorClass)]
		for (oi: root.optionalInstances) {
			val ac = oi.actorClass
			val wired = ac2wired.get(ac)
			val path = ac.generationTargetPath+ac.path
			val infopath = ac.generationInfoPath+ac.path
			val file = ac.getJavaFactoryFileName
			fileIO.generateFile("generating ActorClass Interface implementation", path, infopath, file, root.generate(oi, wired))
		}
	}
	
	def generate(Root root, OptionalActorInstance oi, WiredActorClass wired) {
		val ac = oi.actorClass
		val clsname = ac.javaFactoryName
		'''
			package «ac.package»;
			
			import «ac.package».«ac.name»;
			import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
			import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
			import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
			
			public class «clsname» implements IOptionalActorFactory {
				
				public «ac.name» create(OptionalActorInterfaceBase ai, String name) {
					// instantiate sub tree
					«ac.name» actor = new «ac.name»(ai, name);
					
					// wiring
					«FOR port: RoomHelpers::getAllEndPorts(ac).filter(p|RoomHelpers::isExternal(p))»
						«if (RoomHelpers::isDataDriven(port)) "DataPortBase" else "InterfaceItemBase"».connect(ai, "«port.name»", name+"/«port.name»");
					«ENDFOR»
					«FOR open: wired.openBindings»
						«if (RoomHelpers::isDataDriven(open.port)) "DataPortBase" else "InterfaceItemBase"».connect(ai, "«open.port.name»", name+"/«open.path.join('/')»");
					«ENDFOR»
					«FOR req: wired.requiredServices»
						«if (req.protocol.commType==CommunicationType::DATA_DRIVEN) "DataPortBase" else "InterfaceItemBase"».connect(ai, "«req.protocol.fullyQualifiedName»", name+"/«req.path.join('/')»");
					«ENDFOR»
					
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