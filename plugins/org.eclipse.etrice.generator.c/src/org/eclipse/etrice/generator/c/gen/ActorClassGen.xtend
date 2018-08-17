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
 * 		Thomas Schuetz (changed for C code generator)
 *
 *******************************************************************************/

package org.eclipse.etrice.generator.c.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions
import org.eclipse.etrice.core.room.CommunicationType
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.c.Main
import org.eclipse.etrice.generator.generic.GenericActorClassGenerator
import org.eclipse.etrice.generator.generic.ILanguageExtension
import org.eclipse.etrice.generator.generic.ProcedureHelpers
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.c.setup.GeneratorOptionsHelper
import org.eclipse.etrice.generator.base.logging.ILogger

@Singleton
class ActorClassGen extends GenericActorClassGenerator {

	@Inject protected extension RoomExtensions
	@Inject protected extension CExtensions
	@Inject protected extension ProcedureHelpers
	@Inject protected extension StateMachineGen
	@Inject protected extension GeneratorOptionsHelper

	@Inject protected ILanguageExtension langExt
	@Inject protected IGeneratorFileIO fileIO
	@Inject protected ILogger logger

	def doGenerate(Root root) {
		for (xpac: root.actorClasses.map[root.getExpandedActorClass(it)]) {
			val path = xpac.actorClass.generationTargetPath+xpac.actorClass.getPath
			val infopath = xpac.actorClass.generationInfoPath+xpac.actorClass.getPath
			var file = xpac.actorClass.getCHeaderFileName

			// header file
			fileIO.generateFile("generating ActorClass header", path, infopath, file, root.generateHeaderFile(xpac))

			// utils file
			file = xpac.actorClass.getCUtilsFileName
			fileIO.generateFile("generating ActorClass utils", path, infopath, file, root.generateUtilsFile(xpac))

			// source file
			if (xpac.actorClass.isBehaviorAnnotationPresent("BehaviorManual")) {
				logger.logInfo("omitting ActorClass source for '"+xpac.actorClass.name+"' since @BehaviorManual is specified")
			}
			else {
				file = xpac.actorClass.getCSourceFileName
				fileIO.generateFile("generating ActorClass source", path, infopath, file, root.generateSourceFile(xpac))
			}
		}
	}

	def protected generateHeaderFile(Root root, ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		val eventPorts = ac.allEndPorts.filter(p|(p.protocol as ProtocolClass).commType==CommunicationType::EVENT_DRIVEN)
		val sendPorts = ac.allEndPorts.filter(p|(p.protocol as ProtocolClass).commType==CommunicationType::DATA_DRIVEN && p.conjugated)
		val recvPorts = ac.allEndPorts.filter(p|(p.protocol as ProtocolClass).commType==CommunicationType::DATA_DRIVEN && !p.conjugated)
		val dataDriven = ac.commType==ComponentCommunicationType::DATA_DRIVEN
		val async = ac.commType==ComponentCommunicationType::ASYNCHRONOUS
		val hasConstData = !(eventPorts.empty && recvPorts.empty && ac.allSAPs.empty && ac.allServiceImplementations.empty)
							|| Main::settings.generateMSCInstrumentation
		val isEmptyStateGraph = FsmGenExtensions.isEmpty(xpac.graphContainer.graph)
		val hasVarData = !(sendPorts.empty && ac.allAttributes.empty && isEmptyStateGraph && !hasConstData)

	'''
		/**
		 * @author generated by eTrice
		 *
		 * Header File of ActorClass �ac.name�
		 *
		 */

		�generateIncludeGuardBegin(ac)�

		#include "etDatatypes.h"
		#include "messaging/etMessage.h"

		/* include all referenced room classes */
		�FOR rc : (root.getReferencedDataClasses(ac) + root.getReferencedEnumClasses(ac) + root.getReferencedProtocolClasses(ac)).sortBy[name]�
			#include �rc.includePath�
		�ENDFOR�

		�ac.userCode(1, true)�

		typedef struct �ac.name� �ac.name�;

		/* const part of ActorClass (ROM) */
		�IF hasConstData�
			typedef struct �ac.name�_const {
				�IF Main::settings.generateMSCInstrumentation�
					const char* instName;

				�ENDIF�
				/* simple ports */
				�FOR ep : eventPorts�
					�IF ep.multiplicity==1�
						const �ep.getPortClassName()� �ep.name�;
					�ENDIF�
				�ENDFOR�

				/* data receive ports */
				�FOR ep : recvPorts�
					�IF ep.multiplicity==1�
						const �ep.getPortClassName()� �ep.name�;
					�ENDIF�
				�ENDFOR�

				/* saps */
				�FOR sap: ac.allSAPs�
					const �sap.getPortClassName()� �sap.name�;
				�ENDFOR�

				/* replicated ports */
				�FOR ep : ac.allEndPorts�
					�IF ep.multiplicity!=1�
						const etReplPort �ep.name�;
					�ENDIF�
				�ENDFOR�

				/* services */
				�FOR svc : ac.allServiceImplementations�
					const etReplPort �svc.spp.name�;
				�ENDFOR�
			} �ac.name�_const;
		�ELSE�
			/* this actor class has no ports and thus no constant data */
		�ENDIF�

		�IF !isEmptyStateGraph�

			�xpac.genHeaderConstants�
		�ENDIF�

		/* variable part of ActorClass (RAM) */
		�IF hasVarData�
			struct �ac.name� {
				�IF hasConstData�
					const �ac.name�_const* const constData;

				�ENDIF�
				/* data send ports */
				�FOR ep : sendPorts�
					�IF ep.multiplicity==1�
						�ep.getPortClassName()� �ep.name�;
					�ENDIF�
				�ENDFOR�

				�ac.allAttributes.attributes�

				�IF !isEmptyStateGraph�

					�xpac.genDataMembers�
				�ENDIF�
			};
		�ELSE�
			struct �ac.name� {
				/* This actor class has no data at all.
				   But the private actor instance data is passed to all life cycle functions.
				   By introducing the dummy data we keep this case simple
				*/
				int dummy;
			};
		�ENDIF�

		void �ac.name�_init(�ac.name�* self);

		void �ac.name�_receiveMessage(void* self, const void* ifitem, const etMessage* msg);

		�IF dataDriven || async�
			void �ac.name�_execute(�ac.name�* self);
		�ENDIF�

		�ac.userStructorsDeclaration�

		�ac.latestOperations.operationsDeclaration(ac.name)�

		�ac.userCode(2, true)�

		�generateIncludeGuardEnd(ac)�

	'''
	}

	def protected generateUtilsFile(Root root, ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		val eventPorts = ac.allEndPorts.filter(p|(p.protocol as ProtocolClass).commType==CommunicationType::EVENT_DRIVEN)
		val replEventPorts = eventPorts.filter[multiplicity!=1]
		val sendPorts = ac.allEndPorts.filter(p|(p.protocol as ProtocolClass).commType==CommunicationType::DATA_DRIVEN &&  p.conjugated && p.multiplicity==1)
		val recvPorts = ac.allEndPorts.filter(p|(p.protocol as ProtocolClass).commType==CommunicationType::DATA_DRIVEN && !p.conjugated && p.multiplicity==1)
		val portsWithOperations = ac.allInterfaceItems.filter(p|p.portClass!==null && p.portClass.operations.size>0)
		val filename = (ac.eContainer as RoomModel).name.replaceAll("\\.","_")+"_"+ac.name+"_Utils"

	'''
		/**
		 * @author generated by eTrice
		 *
		 * Utils File of ActorClass �ac.name�
		 *
		 */

		�generateIncludeGuardBegin(filename)�

		#include �ac.includePath�

		/*
		 * access macros for ports, operations and attributes
		*/

		/* simple event ports */
		�FOR ep : eventPorts.filter[multiplicity==1]�
			�FOR msg : ep.outgoing�
				�val data1 = if (msg.data!==null) "data" else ""�
				�val data2 = if (msg.data!==null) ", data" else ""�
				#define �ep.name�_�msg.name�(�data1�) �ep.portClassName�_�msg.name�(&self->constData->�ep.name��data2�)
			�ENDFOR�
		�ENDFOR�

		/* data receive ports */
		�FOR ep : recvPorts�
			�FOR msg : ep.incoming�
				#define �ep.name�_�msg.name� �ep.portClassName�_�msg.name�_get(&self->constData->�ep.name�)
			�ENDFOR�
		�ENDFOR�

		/* data send ports */
		�FOR ep : sendPorts�
			�FOR msg : ep.outgoing�
				�val data1 = if (msg.data!==null) "data" else ""�
				�val data2 = if (msg.data!==null) ", data" else ""�
				#define �ep.name�_�msg.name�(�data1�) �ep.portClassName�_�msg.name�_set(&self->�ep.name��data2�)
			�ENDFOR�
		�ENDFOR�

		/* saps */
		�FOR sap: ac.allSAPs�
			�FOR msg : sap.outgoing�
				�val data1 = if (msg.data!==null) "data" else ""�
				�val data2 = if (msg.data!==null) ", data" else ""�
				#define �sap.name�_�msg.name�(�data1�) �sap.portClassName�_�msg.name�(&self->constData->�sap.name��data2�)
			�ENDFOR�
		�ENDFOR�

		/* replicated event ports */
		�IF !replEventPorts.empty�
			#define ifitem_index (((etReplSubPort*)ifitem)->index)
		�ENDIF�
		�FOR ep : replEventPorts�
			�FOR msg : ep.outgoing�
				�val data1 = if (msg.data!==null) "data" else ""�
				�val data2 = if (msg.data!==null) ", data" else ""�
				#define �ep.name�_�msg.name�_broadcast(�data1�) �ep.portClassName�_�msg.name�_broadcast(&self->constData->�ep.name��data2�)
				#define �ep.name�_�msg.name�(idx�data2�) �ep.portClassName�_�msg.name�(&self->constData->�ep.name�, idx�data2�)
			�ENDFOR�
		�ENDFOR�

		/* services */
		�FOR svc : ac.allServiceImplementations�
			�FOR msg : svc.spp.outgoing�
				�val data1 = if (msg.data!==null) "data" else ""�
				�val data2 = if (msg.data!==null) ", data" else ""�
				#define �svc.spp.name�_�msg.name�_broadcast(�data1�) �svc.spp.portClassName�_�msg.name�_broadcast(&self->constData->�svc.spp.name��data2�)
				#define �svc.spp.name�_�msg.name�(idx�data2�) �svc.spp.portClassName�_�msg.name�(&self->constData->�svc.spp.name�, idx�data2�)
			�ENDFOR�
		�ENDFOR�

		/* operations */
		�FOR op : ac.latestOperations�
			�val args = op.argList�
			#define �op.name�(�args�) �ac.name�_�op.name�(self�IF !op.arguments.empty�, �args��ENDIF�)
		�ENDFOR�

		/* attributes */
		�FOR a : ac.allAttributes�
			#define �a.name� (self->�a.name�)
		�ENDFOR�

		/* port operations */
		�FOR p : portsWithOperations�
			�FOR op : p.portClass.operations�
				�val args = op.argList�
				#define �p.name�_�op.name�(�args�) �p.portClassName�_�op.name�((�p.portClassName�*)&self->constData->�p.name��IF !op.arguments.empty�, �args��ENDIF�)
			�ENDFOR�
		�ENDFOR�

		�generateIncludeGuardEnd(filename)�

	'''
	}

	private def argList(Operation op) {
		'''�FOR a : op.arguments SEPARATOR ", "��a.name��ENDFOR�'''
	}

	def protected generateSourceFile(Root root, ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		val async = ac.commType==ComponentCommunicationType::ASYNCHRONOUS
		val eventDriven = ac.commType==ComponentCommunicationType::EVENT_DRIVEN
		val dataDriven = ac.commType==ComponentCommunicationType::DATA_DRIVEN
		val handleEvents = async || eventDriven
		val isEmptyStateGraph = FsmGenExtensions.isEmpty(xpac.graphContainer.graph)

	'''
		/**
		 * @author generated by eTrice
		 *
		 * Source File of ActorClass �ac.name�
		 *
		 */

		#include "�ac.getCHeaderFileName�"

		#include "modelbase/etActor.h"
		#include "debugging/etLogger.h"
		#include "debugging/etMSCLogger.h"
		#include "etUnit/etUnit.h"
		#include "base/etMemory.h"

		�FOR pc : root.getReferencedProtocolClasses(ac)�
			#include �pc.includePath�
		�ENDFOR�

		#include "�ac.getCUtilsFileName�"

		�ac.userCode(3, true)�

		/* interface item IDs */
		�xpac.genInterfaceItemConstants�

		�IF !isEmptyStateGraph�
			�xpac.graphContainer.genStateMachine�
		�ENDIF�

		void �ac.name�_init(�ac.name�* self){
			ET_MSC_LOGGER_SYNC_ENTRY("�ac.name�", "init")
			�IF !isEmptyStateGraph�
				�xpac.genInitialization�
			�ENDIF�
			ET_MSC_LOGGER_SYNC_EXIT
		}


		void �ac.name�_receiveMessage(void* self, const void* ifitem, const etMessage* msg){
			ET_MSC_LOGGER_SYNC_ENTRY("�ac.name�", "_receiveMessage")
			�IF !isEmptyStateGraph�
				�IF handleEvents�
					�langExt.operationScope(ac.name, false)�receiveEvent(self, (etPort*)ifitem, msg->evtID, (void*)(((char*)msg)+MEM_CEIL(sizeof(etMessage))));
				�ELSE�
					�langExt.operationScope(ac.name, false)�receiveEventInternal(self);
				�ENDIF�
			�ENDIF�

			ET_MSC_LOGGER_SYNC_EXIT
		}

		�IF dataDriven || async�
			void �ac.name�_execute(�ac.name�* self) {
				ET_MSC_LOGGER_SYNC_ENTRY("�ac.name�", "_execute")
				�IF !isEmptyStateGraph�

					�IF handleEvents�
						�langExt.operationScope(ac.name, false)�receiveEvent(self, NULL, 0, NULL);
					�ELSE�
						�langExt.operationScope(ac.name, false)�receiveEventInternal(self);
					�ENDIF�
				�ENDIF�

				ET_MSC_LOGGER_SYNC_EXIT
			}
		�ENDIF�

		�ac.userStructorsImplementation�

		�operationsImplementation(ac.latestOperations, ac.name)�

		'''
	}
}
