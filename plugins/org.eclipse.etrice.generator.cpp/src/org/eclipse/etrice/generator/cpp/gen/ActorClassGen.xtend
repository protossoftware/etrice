/*******************************************************************************
 * Copyright (c) 2011 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Map
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.cpp.Main
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers
import org.eclipse.etrice.generator.fsm.base.IGeneratorFileIo
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions

@Singleton
class ActorClassGen extends GenericActorClassGenerator {

	@Inject protected IGeneratorFileIo fileIO
	@Inject protected extension CppExtensions
	@Inject protected extension RoomExtensions

	@Inject protected extension ProcedureHelpers
	@Inject protected Initialization initHelper
	@Inject protected extension StateMachineGen
	@Inject protected extension FileSystemHelpers

	def doGenerate(Root root) {
		val Map<ActorClass, WiredActorClass> ac2wired = newHashMap
		root.wiredInstances.filter(typeof(WiredActorClass)).forEach[ac2wired.put(actorClass, it)]
		for (xpac: root.xpActorClasses.filter(cl|cl.actorClass.isValidGenerationLocation)) {
			val wired = ac2wired.get(xpac.actorClass)
			val manualBehavior = xpac.actorClass.isBehaviorAnnotationPresent("BehaviorManual")
			val path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath
			val infopath = xpac.actorClass.generationInfoPath+xpac.actorClass.getPath
			var file = if (manualBehavior) 'Abstract' else ''
			fileIO.generateFile("generating ActorClass declaration", path, infopath, file + xpac.actorClass.getCppHeaderFileName, root.generateHeaderFile(xpac, wired, manualBehavior))
			fileIO.generateFile("generating ActorClass implementation", path, infopath, file + xpac.actorClass.getCppSourceFileName, root.generateSourceFile(xpac, wired, manualBehavior))
		}
	}

	def protected generateHeaderFile(Root root, ExpandedActorClass xpac, WiredActorClass wired, boolean manualBehavior) {
		val ac = xpac.actorClass
		val clsname = if (manualBehavior) "Abstract"+ac.name else ac.name
		//val models = root.getReferencedModels(ac)
		val rtBaseClassName = ac.actorBase?.name ?: 'etRuntime::ActorClassBase'

	'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of ActorClass �clsname�
		 *
		 */

		�generateIncludeGuardBegin(ac, '')�

		#include "common/etDatatypesCpp.hpp"
		#include "common/messaging/IRTObject.h"
		#include "common/modelbase/PortBase.h"
		#include "common/modelbase/ReplicatedActorClassBase.h"
		#include "common/modelbase/InterfaceItemBase.h"
		#include "common/modelbase/SubSystemClassBase.h"
		#include "common/messaging/Address.h"
		#include "common/messaging/IMessageReceiver.h"
		#include "common/debugging/DebuggingService.h"
		#include <vector>

		�FOR pc : root.getReferencedProtocolClasses(ac)�
			#include "�pc.path��pc.name�.h"
		�ENDFOR�
		�FOR dc : root.getReferencedDataClasses(ac)�
			#include "�dc.path��dc.name�.h"
		�ENDFOR�

		�IF ac.actorBase==null�
			#include "common/modelbase/ActorClassBase.h"
		�ELSE�
			#include "�ac.actorBase.path��ac.actorBase.name�.h"
		�ENDIF�
		�FOR ar : ac.actorRefs�
			#include "�ar.type.actorIncludePath�"
		�ENDFOR�

		�ac.userCode1.userCode�
		
��� //TODO JH remove
		using namespace etRuntime;

		�ac.generateNamespaceBegin�

		class �clsname� : public �rtBaseClassName� {


			protected:
				//--------------------- ports
				�FOR ep : ac.getEndPorts�
					�ep.getPortClassName� �ep.name�;
				�ENDFOR�

				//--------------------- sub actors
				�FOR sub : ac.actorRefs�
					�IF sub.multiplicity > 1�
						Replicated�sub.type.implementationClassName� �sub.name�;
					�ELSE�
						�sub.type.implementationClassName� �sub.name�;
					�ENDIF�
				�ENDFOR�

				//--------------------- saps
				�FOR sap : ac.serviceAccessPoints�
					�sap.getPortClassName� �sap.name�;
				�ENDFOR�

				//--------------------- services
				�FOR svc : ac.serviceImplementations�
					�svc.getPortClassName� �svc.spp.name�;
				�ENDFOR�

				//--------------------- interface item IDs
				�xpac.genInterfaceItemConstants�

				�ac.attributes.attributes�

				�operationsDeclaration(ac.operations, ac.name)�

			public:
				//--------------------- construction
				�ac.name�(etRuntime::IRTObject* parent, const std::string& name);
				void initialize(void);
				�IF Main::settings.generateMSCInstrumentation�
					void setProbesActive(bool recursive, bool active);
				�ENDIF�

���	TODO: check whether attribute setters/getters are necessary at all, if yes own cpp implementation is needed for *,[],& variables
���				�attributeSettersGettersImplementation(ac.attributes, ac.name)�
				//--------------------- port getters
				�ac.endPorts.map[getterImplementation(portClassName+'&', name, clsname)].join(NEWLINE)�

				�ac.serviceAccessPoints.map[getterImplementation(portClassName+'&', name, clsname)].join(NEWLINE)�

				�ac.serviceImplementations.map[getterImplementation(portClassName+'&', spp.name, clsname)].join(NEWLINE)�

				//--------------------- lifecycle functions
				virtual void destroy();

				�IF ac.hasNonEmptyStateMachine�
					�xpac.genStateMachineConstants�

					�xpac.genStateMachineMethods(false)�
					�IF ac.commType == ComponentCommunicationType::DATA_DRIVEN�
						void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* generic_data);
					�ENDIF�
					�IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN�
						virtual void receive(const etRuntime::Message* msg);
					�ENDIF�
				�ELSEIF xpac.stateMachine.empty�
���					no state machine in the super classes
					//--------------------- no state machine
					virtual void receiveEvent(etRuntime::InterfaceItemBase* ifitem, int evt, void* data);
					virtual void executeInitTransition() {}
				�ENDIF�

				�ac.userCode2.userCode�

		};

		class Replicated�clsname� : public ReplicatedActorClassBase {
		public:
			Replicated�clsname�(IRTObject* parent, const std::string& name) :
				ReplicatedActorClassBase(parent, name) {}
			
		protected:
			ActorClassBase* createActor(IRTObject* parent, const std::string& name) {
				return new �clsname�(parent, name);
			}
		};

		�ac.generateNamespaceEnd�

		�generateIncludeGuardEnd(ac, '')�
	'''
	}

	def private generateConstructorInitalizerList(ActorClass ac) {
		val extension initHelper = initHelper
		var initList = <CharSequence>newArrayList

		// super class
		initList += '''�ac.actorBase?.name ?: 'ActorClassBase'�(parent, name)'''
	    // own ports
	    initList += ac.endPorts.map['''�name�(this, "�name�", IFITEM_�name�)''']
	    // own sub actors
	    initList += ac.actorRefs.map['''�name�(this, "�name�")''']
		// own saps
		initList += ac.serviceAccessPoints.map['''�name�(this, "�name�", IFITEM_�name�)''']
		// own service implementations
		initList += ac.serviceImplementations.map['''�spp.name�(this, "�spp.name�", IFITEM_�spp.name�)''']
		// own attributes
		initList += ac.attributes.map['''�name�(�initializerListValue�)''']

		initList.generateCtorInitializerList
	}


	def protected generateSourceFile(Root root, ExpandedActorClass xpac, WiredActorClass wired, boolean manualBehavior) {
		val ac = xpac.actorClass
		val clsname = if (manualBehavior) "Abstract"+ac.name else ac.name
		//val models = root.getReferencedModels(ac)
		val rtBaseClassName = ac.actorBase?.name ?: 'ActorClassBase'

		'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of ActorClass �ac.name�
		 *
		 */

		#include "�ac.getCppHeaderFileName�"

		#include "common/messaging/RTObject.h"
		#include "common/messaging/RTServices.h"
		#include "common/debugging/DebuggingService.h"
		#include "common/debugging/MSCFunctionObject.h"

		using namespace etRuntime;

		�ac.generateNamespaceBegin�

		�ac.userCode3.userCode�

		�clsname�::�clsname�(etRuntime::IRTObject* parent, const std::string& name)
				�ac.generateConstructorInitalizerList�
		{
			�IF Main::settings.generateMSCInstrumentation�
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "Constructor");
			�ENDIF�
			
			�IF ac.hasNonEmptyStateMachine�
				for (int i = 0; i < s_numberOfStates; i++) {
					history[i] = NO_STATE;
				}
			�ENDIF�
			setClassName("�ac.name�");

			// sub actors
			�FOR sub : ac.actorRefs�
				�IF sub.multiplicity>1�
					�sub.name�.createSubActors(�sub.multiplicity�);
				�ENDIF�
			�ENDFOR�

			�initHelper.genExtraInitializers(ac.attributes)�
			�ac.userStructorBody(true)�
		}
		
		void �ac.name�::initialize() {
			�IF Main::settings.generateMSCInstrumentation�
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "initialize()");
				�FOR sub : ac.actorRefs�
					�IF sub.multiplicity > 1�
						for (int i=0; i<�sub.multiplicity�; ++i) {
							DebuggingService::getInstance().addMessageActorCreate(*this, �sub.name�.getSubActor(i)->getName());
						}
					�ELSE�
						DebuggingService::getInstance().addMessageActorCreate(*this, "�sub.name�");
					�ENDIF�
				�ENDFOR�
			�ENDIF�
			
			ActorClassBase::initialize();
			
			�FOR sub : ac.actorRefs�
				�sub.name�.initialize();
			�ENDFOR�
			
			// wiring
			�FOR wire: wired.wires�
				�if (wire.dataDriven) "DataPortBase" else "InterfaceItemBase"�::connect(this, "�wire.path1.join('/')�", "�wire.path2.join('/')�");
			�ENDFOR�

			�IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN�
				// activate polling for data-driven communication
				RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(getThread())->addPollingMessageReceiver(*this);
			�ENDIF�
		}
		
		�IF Main::settings.generateMSCInstrumentation�
			void �ac.name�::setProbesActive(bool recursive, bool active) {
				DebuggingService::getInstance().addPortInstance(m_RTSystemPort);
				�IF ac.actorRefs.size > 0�
					if(recursive) {
						�FOR sub : ac.actorRefs�
							�sub.name�.setProbesActive(recursive, active);
						�ENDFOR�
					}
				�ENDIF�
				�FOR ep : ac.endPorts�
					�IF !ep.dataDriven�
						�IF ep.replicated�
							for(int i = 0; i < �ep.name�.getNInterfaceItems(); i++)
								DebuggingService::getInstance().addPortInstance(*(�ep.name�.getInterfaceItem(i)));
						�ELSE�
							DebuggingService::getInstance().addPortInstance(�ep.name�);
						�ENDIF�
					�ENDIF�
				�ENDFOR�
				�FOR sap : ac.serviceAccessPoints�
					DebuggingService::getInstance().addPortInstance(�sap.name�);
				�ENDFOR�
				�FOR spp : ac.serviceProvisionPoints�
					for(int i = 0; i < �spp.name�.getNInterfaceItems(); i++)
							DebuggingService::getInstance().addPortInstance(*(�spp.name�.getInterfaceItem(i)));
				�ENDFOR�
			}
		�ENDIF�

		void �ac.name�::destroy(){
			�IF Main::settings.generateMSCInstrumentation�
				MSCFunctionObject mscFunctionObject(getInstancePathName(), "destroy()");
			�ENDIF�
			
			�ac.userStructorBody(false)�
			�IF Main::settings.generateMSCInstrumentation�
				DebuggingService::getInstance().addMessageActorDestroy(*this);
			�ENDIF�
			�IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN�
				RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(getThread())->removePollingMessageReceiver(*this);
			�ENDIF�
			�rtBaseClassName�::destroy();
		}

		�operationsImplementation(ac.operations, ac.name)�

		�IF ac.hasNonEmptyStateMachine�
			�xpac.genStateMachineMethods(true)�
			�IF ac.commType == ComponentCommunicationType::DATA_DRIVEN�
				void �ac.name�::receiveEvent(InterfaceItemBase* ifitem, int evt, void* generic_data) {
					handleSystemEvent(ifitem, evt, generic_data);
				}
			�ENDIF�
			�IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS || ac.commType == ComponentCommunicationType::DATA_DRIVEN�
				void �ac.name�::receive(const Message* msg) {
					�IF ac.commType == ComponentCommunicationType::ASYNCHRONOUS�
						receiveEvent(0, -1, 0);
					�ELSE�
						receiveEventInternal();
					�ENDIF�
				}
			�ENDIF�
		�ELSEIF xpac.stateMachine.empty�
���			no state machine in the super classes
			//--------------------- no state machine
			void �ac.name�::receiveEvent(InterfaceItemBase* ifitem, int evt, void* data) {
				handleSystemEvent(ifitem, evt, data);
			}
		�ENDIF�

		�ac.generateNamespaceEnd�

		'''
	}
}
