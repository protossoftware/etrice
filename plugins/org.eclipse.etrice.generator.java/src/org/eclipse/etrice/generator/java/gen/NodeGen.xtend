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
import java.util.Collection
import java.util.HashMap
import java.util.HashSet
import org.eclipse.etrice.core.etmap.util.ETMapUtil
import org.eclipse.etrice.core.etphys.eTPhys.ExecMode
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.IDiagnostician
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.CommunicationType
import org.eclipse.etrice.core.room.SubSystemClass
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.base.IDataConfiguration
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo
import org.eclipse.etrice.generator.fsm.base.IntelligentSeparator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.java.Main

import static extension org.eclipse.etrice.generator.fsm.base.Indexed.*
import com.google.common.collect.Lists
import com.google.common.collect.Sets
import org.eclipse.etrice.core.genmodel.builder.GenmodelConstants

@Singleton
class NodeGen {

	@Inject extension JavaExtensions
	@Inject extension RoomExtensions
	@Inject IDataConfiguration dataConfigExt
	@Inject ConfigGenAddon configGenAddon
	@Inject extension ProcedureHelpers
	@Inject extension FileSystemHelpers

	@Inject IGeneratorFileIo fileIO
	@Inject VariableServiceGen varService
	@Inject IDiagnostician diagnostician

	def doGenerate(Root root) {
		val HashMap<SubSystemClass, WiredSubSystemClass> sscc2wired = new HashMap<SubSystemClass, WiredSubSystemClass>
		root.wiredInstances.filter(w|w instanceof WiredSubSystemClass).forEach[w|sscc2wired.put((w as WiredSubSystemClass).subSystemClass, w as WiredSubSystemClass)]
		for (nr : ETMapUtil::getNodeRefs()) {
			for (instpath : ETMapUtil::getSubSystemInstancePaths(nr)) {
				val ssi = root.getInstance(instpath) as SubSystemInstance
				if (ssi!=null && ssi.subSystemClass.validGenerationLocation) {
					val wired = sscc2wired.get(ssi.subSystemClass)
					val path = ssi.subSystemClass.generationTargetPath+ssi.subSystemClass.getPath
					val infopath = ssi.subSystemClass.generationInfoPath+ssi.subSystemClass.getPath
					val file = nr.getJavaFileName(ssi)

					checkDataPorts(ssi)

					val usedThreads = ETMapUtil::getUsedThreads(nr, ssi)

					fileIO.generateFile("generating Node implementation", path, infopath, file, root.generate(ssi, wired, usedThreads))
					if (dataConfigExt.hasVariableService(ssi))
						varService.doGenerate(root, ssi);
				}
			}
		}
	}

	/**
	 * Recursively collect all possible interface instances below a given structure instance.
	 */
	def private HashSet<ActorClass> getOptionalActorClasses(Root root, StructureInstance si) {
		val aifs = Lists::newArrayList(si.eAllContents.filter(i|i instanceof ActorInterfaceInstance).map[aii|aii as ActorInterfaceInstance])
		val result = Sets::newHashSet(aifs.map[aii|(aii as ActorInterfaceInstance).actorClass])
		for (ai : aifs) {
			for (oi : ai.optionalInstances) {
				result.addAll(root.getOptionalActorClasses(oi))
			}
		}

		return result
	}

	def generate(Root root, SubSystemInstance comp, WiredSubSystemClass wired, Collection<PhysicalThread> usedThreads) {
		val cc = comp.subSystemClass
		val models = root.getReferencedModels(cc)
		val nr = ETMapUtil::getNodeRef(comp)
		val clsname = nr.getJavaClassName(comp)
		val threads = nr.type.threads.filter(t|usedThreads.contains(t))
		val opt = root.getOptionalActorClasses(comp)

	'''
		package «cc.getPackage()»;

		import org.eclipse.etrice.runtime.java.config.IVariableService;
		«IF Main::settings.generateMSCInstrumentation»
			import org.eclipse.etrice.runtime.java.debugging.DebuggingService;
		«ENDIF»
		import org.eclipse.etrice.runtime.java.messaging.IRTObject;
		import org.eclipse.etrice.runtime.java.messaging.IMessageService;
		import org.eclipse.etrice.runtime.java.messaging.MessageService;
		import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
		import org.eclipse.etrice.runtime.java.messaging.RTServices;
		import org.eclipse.etrice.runtime.java.modelbase.ActorClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.DataPortBase;
		import org.eclipse.etrice.runtime.java.modelbase.OptionalActorInterfaceBase;
		import org.eclipse.etrice.runtime.java.modelbase.IOptionalActorFactory;
		import org.eclipse.etrice.runtime.java.modelbase.SubSystemClassBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBase;
		import org.eclipse.etrice.runtime.java.modelbase.InterfaceItemBroker;

		«FOR model : models»
			import «model.name».*;
		«ENDFOR»

		«cc.userCode(1, false)»

		public class «clsname» extends SubSystemClassBase {

			«FOR thread : threads.indexed»
				public static final int «thread.value.threadId» = «thread.index0»;
			«ENDFOR»

			«cc.userCode(2, false)»

			public «clsname»(IRTObject parent, String name) {
				super(parent, name);
			}

			@Override
			public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data){
			}

			@Override
			public void instantiateMessageServices() {

				IMessageService msgService;
				«FOR thread: threads.sortBy[-prio]»
					«IF thread.execmode==ExecMode::POLLED || thread.execmode==ExecMode::MIXED»
						msgService = new MessageService(this, MessageService.ExecMode.«thread.execmode.getName», «thread.time»L, 0, «thread.threadId», "MessageService_«thread.name»" /*, thread_prio */);
					«ELSE»
						msgService = new MessageService(this, MessageService.ExecMode.«thread.execmode.getName», 0, «thread.threadId», "MessageService_«thread.name»" /*, thread_prio */);
					«ENDIF»
					RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(msgService);
				«ENDFOR»
			}

			@Override
			public void instantiateActors() {

				// thread mappings
				«FOR ai : comp.allContainedInstances»
					«val mapped = ETMapUtil::getMappedThread(ai)»
					«IF !(mapped.implicit || mapped.asParent)»
						addPathToThread("«ai.path»", «mapped.thread.threadId»);
					«ENDIF»
				«ENDFOR»

				// sub actors
				«FOR sub : cc.actorRefs»
					«IF sub.multiplicity>1»
						for (int i=0; i<«sub.multiplicity»; ++i) {
							«IF Main::settings.generateMSCInstrumentation»
								DebuggingService.getInstance().addMessageActorCreate(this, "«sub.name»«GenmodelConstants::INDEX_SEP»"+i);
							«ENDIF»
							new «sub.type.name»(this, "«sub.name»«GenmodelConstants::INDEX_SEP»"+i);
						}
					«ELSE»
						«IF Main::settings.generateMSCInstrumentation»
							DebuggingService.getInstance().addMessageActorCreate(this, "«sub.name»");
						«ENDIF»
						new «sub.type.name»(this, "«sub.name»");
					«ENDIF»
				«ENDFOR»

				// create service brokers in optional actor interfaces
				«FOR aii: comp.allSubInstances.filter(inst|inst instanceof ActorInterfaceInstance).map(inst|inst as ActorInterfaceInstance)»
					{
						OptionalActorInterfaceBase oai = (OptionalActorInterfaceBase) getObject("«aii.getPath()»");
						«FOR svc: aii.providedServices»
							new InterfaceItemBroker(oai, "«svc.protocol.fullyQualifiedName»", 0);
							InterfaceItemBase.connect(this, "«svc.path»", "«aii.getPath()+InstanceBase::pathDelim+svc.protocol.fullyQualifiedName»");
						«ENDFOR»
					}
				«ENDFOR»

				// wiring
				«FOR wire: wired.wires»
					«if (wire.dataDriven) "DataPortBase" else "InterfaceItemBase"».connect(this, "«wire.path1.join('/')»", "«wire.path2.join('/')»");
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
				«IF Main::settings.generateMSCInstrumentation»
					DebuggingService.getInstance().addVisibleComment("begin sub system initialization");
				«ENDIF»
				«IF dataConfigExt.hasVariableService(comp)»
					variableService = new «clsname»VariableService(this);
				«ENDIF»
				super.init();
				«IF dataConfigExt.hasVariableService(comp)»
					variableService.init();
				«ENDIF»
				«IF Main::settings.generateMSCInstrumentation»
					DebuggingService.getInstance().addVisibleComment("done sub system initialization");
				«ENDIF»
			}

			@Override
			public void stop(){
				super.stop();
				«IF dataConfigExt.hasVariableService(comp)»
					variableService.stop();
				«ENDIF»
			}
			«IF Main::settings.generateMSCInstrumentation»

				@Override
				public boolean hasGeneratedMSCInstrumentation() {
					return true;
				}

				@Override
				public void destroy() {
					DebuggingService.getInstance().addVisibleComment("begin sub system destruction");
					super.destroy();
					DebuggingService.getInstance().addVisibleComment("done sub system destruction");
				}
			«ENDIF»

			public IOptionalActorFactory getFactory(String optionalActorClass, String actorClass) {
				«val else1 = new IntelligentSeparator("else ")»
				«FOR oa : opt»
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
