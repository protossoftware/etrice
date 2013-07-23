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
import java.util.HashSet
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.room.CommunicationType
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions

import static extension org.eclipse.etrice.generator.base.Indexed.*
import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode
import org.eclipse.etrice.generator.base.IntelligentSeparator

@Singleton
class NodeGen {
	
	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject IDataConfiguration dataConfigExt
	@Inject ConfigGenAddon configGenAddon
	@Inject extension ProcedureHelpers

	@Inject IGeneratorFileIo fileIO
	@Inject VariableServiceGen varService
	@Inject IDiagnostician diagnostician
	
	def doGenerate(Root root) {
		for (nr : ETMapUtil::getNodeRefs()) {
			for (instpath : ETMapUtil::getSubSystemInstancePaths(nr)) {
				val ssi = root.getInstance(instpath) as SubSystemInstance
				val path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
				val infopath = ssi.subSystemClass.generationInfoPath+ssi.subSystemClass.getPath
				val file = nr.getJavaFileName(ssi)
				
				checkDataPorts(ssi)
				
				val usedThreads = new HashSet<PhysicalThread>();
				for (thread: nr.type.threads) {
					val instancesOnThread = ssi.allContainedInstances.filter(ai|ETMapUtil::getPhysicalThread(ai)==thread)
					if (!instancesOnThread.empty)
						usedThreads.add(thread)
				}
				
				fileIO.generateFile("generating Node implementation", path, infopath, file, root.generate(ssi, usedThreads))
				if (dataConfigExt.hasVariableService(ssi))
					varService.doGenerate(root, ssi);
			}
		}
	}

	def generate(Root root, SubSystemInstance comp, HashSet<PhysicalThread> usedThreads) {
		val cc = comp.subSystemClass
		val models = root.getReferencedModels(cc)
		val nr = ETMapUtil::getNodeRef(comp)
		val clsname = nr.getJavaClassName(comp)
		val threads = nr.type.threads.filter(t|usedThreads.contains(t))
		
	'''
		package «cc.getPackage()»;
		
		import org.eclipse.etrice.runtime.java.config.IVariableService;
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.IMessageService;
		import org.eclipse.etrice.runtime.java.messaging.MessageService;
		import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
		import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		
		«FOR model : models»
			import «model.name».*;
		«ENDFOR»
		
		«cc.userCode(1)»
		
		public class «clsname» extends SubSystemClassBase {
			
			«FOR thread : threads.indexed»
				public final int «thread.value.threadId» = «thread.index0»;
			«ENDFOR»
		
			«cc.userCode(2)»
			
			public «clsname»(IRTObject parent, String name) {
				super(parent, name);
			}
			
			@Override
			public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
			}
			
			@Override	
			public void instantiateMessageServices() {
			
				IMessageService msgService;
				«FOR thread: threads»
					«IF thread.execmode==ExecMode::POLLED || thread.execmode==ExecMode::MIXED»
						msgService = new MessageService(this, MessageService.ExecMode.«thread.execmode.name», «thread.time», 0, «thread.threadId», "MessageService_«thread.name»" /*, thread_prio */);
					«ELSE»
						msgService = new MessageService(this, MessageService.ExecMode.«thread.execmode.name», 0, «thread.threadId», "MessageService_«thread.name»" /*, thread_prio */);
					«ENDIF»
					RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);
				«ENDFOR»
			}
		
			@Override
			public void instantiateActors() {
				
				// thread mappings
				«FOR ai : comp.allContainedInstances»
						addPathToThread("«ai.path»", «ETMapUtil::getPhysicalThread(ai).threadId»);
				«ENDFOR»
				
				// port to peer port mappings
				«FOR ai : comp.allContainedInstances»
					«FOR pi : ai.orderedIfItemInstances»
						«IF pi.peers.size>0»
							addPathToPeers("«pi.path»", «FOR peer : pi.peers SEPARATOR ","»"«peer.path»"«ENDFOR»);
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
		
				// sub actors
				«FOR sub : cc.actorRefs»
					«IF sub.size>1»
						for (int i=0; i<«sub.size»; ++i)
							new «sub.type.name»(this, "«sub.name»_"+i); 
					«ELSE»
						new «sub.type.name»(this, "«sub.name»"); 
					«ENDIF»
				«ENDFOR»
				
				// apply instance attribute configurations
				«FOR ai: comp.allContainedInstances»
					«val cfg = configGenAddon.genActorInstanceConfig(ai, "inst")»
					«IF cfg.length>0»
						{
							«ai.actorClass.name» inst = («ai.actorClass.name») getObject("«ai.path»");
							if (inst!=null) {
								«cfg»
							}
						}
					«ENDIF»
				«ENDFOR»
			}
			
			@Override
			public void init(){
				«IF dataConfigExt.hasVariableService(comp)»
					variableService = new «clsname»VariableService(this);
				«ENDIF»
				super.init();
				«IF dataConfigExt.hasVariableService(comp)»
					variableService.init();
				«ENDIF»
			}
				
			@Override
			public void stop(){
				super.stop();
				«IF dataConfigExt.hasVariableService(comp)»
					variableService.stop();
				«ENDIF»
			}
			
			public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {
				«val else1 = new IntelligentSeparator("else ")»
				«FOR oa : root.optionalActorClasses»
					«else1»if (optionalActorClass.equals("«oa.name»")) {
						«val else2 = new IntelligentSeparator("else ")»
						«FOR subcls : root.getSubClasses(oa).union(oa).filter(s|!s.abstract)»
							«else2»if ("«subcls.name»".equals(actorClass)) {
								return new «subcls.javaFactoryName»();
							}
						«ENDFOR»
					}
				«ENDFOR»
				
				return null;
			}
		};
	'''
	}

	def private getThreadId(PhysicalThread thread) {
		"THREAD_"+thread.name.toUpperCase
	}
	
	def private checkDataPorts(SubSystemInstance comp) {
		val found = new HashSet<String>()
		for (ai: comp.allContainedInstances) {
			val thread = ai.threadId
			for (pi: ai.orderedIfItemInstances) {
				if (pi.protocol.commType==CommunicationType::DATA_DRIVEN) {
					for (peer: pi.peers) {
						val peer_ai = peer.eContainer as ActorInstance
						val peer_thread = peer_ai.threadId
						if (thread!=peer_thread) {
							val path = pi.path
							val ppath = peer.path
							val pair = if (path.compareTo(ppath)<0) path+" and "+ppath
										else ppath+" and "+path
							if (!found.contains(pair)) {
								found.add(pair)
								diagnostician.error(pair+": data ports placed on different threads (not supported yet)",
									pi.interfaceItem, pi.interfaceItem.eContainingFeature)
							}
						}
					}
				}
			}
		}
	}
}
