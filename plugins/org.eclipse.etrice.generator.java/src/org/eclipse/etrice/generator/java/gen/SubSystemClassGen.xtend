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
import org.eclipse.etrice.core.genmodel.base.ILogger
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.generic.ConfigExtension
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.generic.TypeHelpers
import org.eclipse.xtext.generator.JavaIoFileSystemAccess

import static extension org.eclipse.etrice.generator.base.Indexed.*


@Singleton
class SubSystemClassGen {
	
	@Inject JavaIoFileSystemAccess fileAccess
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject extension ConfigExtension
	@Inject ConfigGenAddon configAddon
	@Inject extension ProcedureHelpers

	@Inject extension TypeHelpers
	@Inject VariableServiceGen varService
	@Inject ILogger logger
	
	def doGenerate(Root root) {
		for (ssi: root.subSystemInstances) {
			var path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
			var file = ssi.subSystemClass.getJavaFileName
			logger.logInfo("generating SubSystemClass implementation: '"+file+"' in '"+path+"'")
			fileAccess.setOutputPath(path)
			fileAccess.generateFile(file, root.generate(ssi, ssi.subSystemClass))
			if(ssi.subSystemClass.hasVariableService)
				varService.doGenerate(root, ssi);
		}
	}

	def generate(Root root, SubSystemInstance comp, SubSystemClass cc) {'''
		package «cc.getPackage()»;
		
		«IF cc.hasVariableService»import org.eclipse.etrice.runtime.java.config.VariableService;«ENDIF»
		import org.eclipse.etrice.runtime.java.messaging.MessageService;
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
		import org.eclipse.etrice.runtime.java.messaging.Address;
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.RTSystemServicesProtocol.*;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		
		«var models = root.getReferencedModels(cc)»
		«FOR model : models»import «model.name».*;«ENDFOR»
		
		
		«cc.userCode(1)»
		
		public class «comp.name» extends SubSystemClassBase{
		
			«cc.userCode(2)»
			
			public «comp.name»(String name) {
				super(name);
			}
			
			@Override
			public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
			}
			
			@Override	
			public void instantiateMessageServices(){
			
				RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, 0, 0),"MessageService_Main"));
				«FOR thread : cc.threads»
					RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(new MessageService(this, new Address(0, «cc.threads.indexOf(thread)+1», 0),"MessageService_«thread.name»", «thread.prio»));
				«ENDFOR»
				}
		
			@Override
			public void instantiateActors(){
				
				// all addresses
				// Addresses for the Subsystem Systemport
				«FOR ai : comp.allContainedInstances.indexed(comp.maxObjId)»
					Address addr_item_SystemPort_«comp.allContainedInstances.indexOf(ai.value)» = new Address(0,0,«ai.index1»);
				«ENDFOR»
				
				«FOR ai : comp.allContainedInstances»
					// actor instance «ai.path» itself => Systemport Address
					// TODOTJ: For each Actor, multiple addresses should be generated (actor?, systemport, debugport)
					Address addr_item_«ai.path.getPathName()» = new Address(0,«ai.threadId»,«ai.objId»);
					// interface items of «ai.path»
					«FOR pi : ai.orderedIfItemInstances»
						«IF pi.replicated»
							«FOR peer : pi.peers»
								«var i = pi.peers.indexOf(peer)»
								Address addr_item_«pi.path.getPathName()»_«i» = new Address(0,«pi.threadId»,«pi.objId+i»);
							«ENDFOR»
						«ELSE»
							Address addr_item_«pi.path.getPathName()» = new Address(0,«ai.threadId»,«pi.objId»);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
		
				// instantiate all actor instances
				instances = new ActorClassBase[«comp.allContainedInstances.size»];
				«FOR ai : comp.allContainedInstances»
					instances[«comp.allContainedInstances.indexOf(ai)»] = new «ai.actorClass.name»(
						«IF ai.eContainer instanceof SubSystemInstance»
							this,
						«ELSE»
							instances[«comp.allContainedInstances.indexOf(ai.eContainer)»],
						«ENDIF»
						"«ai.name»",
						// own interface item addresses
						new Address[][] {{addr_item_«ai.path.getPathName()»}«IF !ai.orderedIfItemInstances.empty»,«ENDIF»
							«FOR pi : ai.orderedIfItemInstances SEPARATOR ","»
								«IF pi.replicated»
									«IF pi.peers.empty»
										null
									«ELSE»
										{
											«FOR peer : pi.peers SEPARATOR ","»
												addr_item_«pi.path.getPathName()»_«pi.peers.indexOf(peer)»
											«ENDFOR»
										}
									«ENDIF»
								«ELSE»
									{
										addr_item_«pi.path.getPathName()»
									}
								«ENDIF»
							«ENDFOR»
						},
						// peer interface item addresses
						new Address[][] {{addr_item_SystemPort_«comp.allContainedInstances.indexOf(ai)»}«IF !ai.orderedIfItemInstances.empty»,«ENDIF»
							«FOR pi : ai.orderedIfItemInstances SEPARATOR ","»
								«IF pi.replicated && pi.peers.isEmpty»
									null
								«ELSE»
									{
										«IF pi.peers.empty»
											null
										«ELSE»
											«FOR pp : pi.peers SEPARATOR ","»
												«IF pp.replicated»
													addr_item_«pp.path.getPathName()»_«pp.peers.indexOf(pi)»
												«ELSE»
													addr_item_«pp.path.getPathName()»
												«ENDIF»
											«ENDFOR»
										«ENDIF»
									}
								«ENDIF»
							«ENDFOR»
						}
						«IF ai.configAttributes.exists(c | c.dynConfig)»
							, variableService
						«ENDIF»
					); 
				«ENDFOR»
				
				// apply instance attribute configurations
				«FOR ai : comp.allContainedInstances»
					«IF !(ai.configAttributes.empty && ai.getConfigPorts.empty)»
						{
							«ai.actorClass.name» inst = («ai.actorClass.name») instances[«comp.allContainedInstances.indexOf(ai)»];
							«configAddon.applyInstanceConfig("inst", ai.actorClass.name, ai.configAttributes)»
							«FOR portConfig : ai.configPorts»
								«configAddon.applyInstanceConfig(("inst."+portConfig.item.name.invokeGetter(ai.actorClass.name)), portConfig.item.portClassName, portConfig.attributes)»
							«ENDFOR»
						}
					«ENDIF»
				«ENDFOR»
		
				// create the subsystem system port	
				RTSystemPort = new RTSystemServicesProtocolConjPortRepl(this, "RTSystemPort",
						0, //local ID
						// own addresses
						new Address[]{
							«FOR ai : comp.allContainedInstances SEPARATOR ","»
								addr_item_SystemPort_«comp.allContainedInstances.indexOf(ai)»
							«ENDFOR»
						},
						// peer addresses
						new Address[]{
							«FOR ai : comp.allContainedInstances SEPARATOR ","»
								addr_item_«ai.path.getPathName()»
							«ENDFOR»
						});
				}
			
				«IF cc.hasVariableService»
					private VariableService variableService;
				«ENDIF»
				
				@Override
				public void init(){
					«IF cc.hasVariableService»
						variableService = new «comp.name»VariableService(this);
					«ENDIF»
					super.init();
					«IF cc.hasVariableService»
						variableService.init();
					«ENDIF»
				}
					
				@Override
				public void stop(){
					super.stop();
					«IF cc.hasVariableService»
						variableService.stop();
					«ENDIF»
				}
				
		};
	'''
	}

}
