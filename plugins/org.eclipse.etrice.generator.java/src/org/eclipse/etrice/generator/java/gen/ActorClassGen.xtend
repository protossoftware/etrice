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

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import static extension org.eclipse.etrice.core.room.util.RoomHelpers.*
import org.eclipse.etrice.generator.base.AbstractGenerator
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.generator.base.IDataConfiguration

@Singleton
class ActorClassGen extends GenericActorClassGenerator {
	
	@Inject JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject IDataConfiguration dataConfigExt
	@Inject ConfigGenAddon configGenAddon
	
	@Inject extension ProcedureHelpers
	@Inject extension Initialization
	@Inject extension StateMachineGen
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (xpac: root.xpActorClasses) {
			var path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath
			var file = xpac.actorClass.getJavaFileName
			logger.logInfo("generating ActorClass implementation '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(xpac, xpac.actorClass))
		}
	}
	
	def generate(Root root, ExpandedActorClass xpac, ActorClass ac) {
		val ctor = ac.operations.filter(op|op.constructor).head
		val dtor = ac.operations.filter(op|op.destructor).head
		val models = root.getReferencedModels(ac)
		
	'''
		package «ac.getPackage»;
		
		«IF !dataConfigExt.getDynConfigReadAttributes(ac).empty»
			import org.eclipse.etrice.runtime.java.config.DynConfigLock;
		«ENDIF»
		import org.eclipse.etrice.runtime.java.messaging.Address;
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.IMessageReceiver;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		import static org.eclipse.etrice.runtime.java.etunit.EtUnit.*;
		
		«FOR model : models»
			import «model.name».*;
		«ENDFOR»
		
		«FOR pc : root.getReferencedProtocolClasses(ac)»
			import «pc.^package».«pc.name».*;
		«ENDFOR»
		
		«ac.userCode(1)»
		
		
		public «IF ac.^abstract»abstract «ENDIF»class «ac.name» extends «IF ac.base!=null»«ac.base.name»«ELSE»ActorClassBase«ENDIF» {
		
			«ac.userCode(2)»
			
			//--------------------- ports
			«FOR ep : ac.getEndPorts()»
				protected «ep.getPortClassName()» «ep.name» = null;
			«ENDFOR»
			
			//--------------------- saps
			«FOR sap : ac.strSAPs»
				protected «sap.getPortClassName()» «sap.name» = null;
			«ENDFOR»
			
			//--------------------- services
			«FOR svc : ac.serviceImplementations»
				protected «svc.getPortClassName()» «svc.spp.name» = null;
			«ENDFOR»
		
			//--------------------- interface item IDs
			«genInterfaceItemConstants(xpac, ac)»

			«configGenAddon.genMinMaxConstants(ac)»
			«ac.attributes.attributes»
			«FOR a : dataConfigExt.getDynConfigReadAttributes(ac)»
				private DynConfigLock lock_«a.name»;
			«ENDFOR»
			«ac.operationsImplementation»
		
			//--------------------- construction
			public «ac.name»(IRTObject parent, String name) {
				super(parent, name);
				setClassName("«ac.name»");
				
				«ac.attributes.attributeInitialization(ac, false)»
		
				// own ports
				«FOR ep : ac.getEndPorts()»
					«ep.name» = new «ep.getPortClassName()»(this, "«ep.name»", IFITEM_«ep.name»); 
				«ENDFOR»
				
				// own saps
				«FOR sap : ac.strSAPs»
					«sap.name» = new «sap.getPortClassName()»(this, "«sap.name»", IFITEM_«sap.name», 0); 
				«ENDFOR»
				
				// own service implementations
				«FOR svc : ac.serviceImplementations»
					«svc.spp.name» = new «svc.getPortClassName()»(this, "«svc.spp.name»", IFITEM_«svc.spp.name»); 
				«ENDFOR»
				
				// sub actors
				«FOR sub : ac.actorRefs»
					«IF sub.size>1»
						for (int i=0; i<«sub.size»; ++i)
							new «sub.type.name»(this, "«sub.name»_"+i); 
					«ELSE»
						new «sub.type.name»(this, "«sub.name»"); 
					«ENDIF»
				«ENDFOR»
				«IF ctor!=null»
					
					{
						// user defined constructor body
						«AbstractGenerator::getInstance().getTranslatedCode(ctor.detailCode)»
					}
				«ENDIF»

				«IF !dataConfigExt.getDynConfigReadAttributes(ac).empty || !dataConfigExt.getDynConfigWriteAttributes(ac).empty»
					«FOR a : dataConfigExt.getDynConfigReadAttributes(ac)»
						lock_«a.name» = new DynConfigLock();
					«ENDFOR»
				«ENDIF»
			}
			
			«attributeSettersGettersImplementation(ac.attributes.minus(dataConfigExt.getDynConfigReadAttributes(ac)), ac.name)»
			
			«configGenAddon.genDynConfigGetterSetter(ac)»
			
			//--------------------- port getters
			«FOR ep : ac.getEndPorts()»
				«ep.portClassName.getterImplementation(ep.name, ac.name)»
			«ENDFOR»
			«FOR sap : ac.strSAPs»
				«sap.portClassName.getterImplementation(sap.name, ac.name)»
			«ENDFOR»
			«FOR svc : ac.serviceImplementations»
				«svc.portClassName.getterImplementation(svc.spp.name, ac.name)»
			«ENDFOR»
		
			//--------------------- lifecycle functions
			«IF !ac.overridesStop()»
				public void stop(){
					stopUser();
					super.stop();
				}
			«ENDIF»
			
			«IF dtor!=null»
				public void destroy(){
					«ac.name.destructorCall»;
					super.destroy();
				}
			«ENDIF»
		
			«IF ac.hasNonEmptyStateMachine»
				«xpac.genStateMachine()»
			«ELSEIF !xpac.hasStateMachine()»
				//--------------------- no state machine
				public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
					handleSystemEvent(ifitem, evt, data);
				}
				
				public void executeInitTransition() {}
			«ENDIF»
		};
	'''
	}
}
