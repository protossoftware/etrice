/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.room.util

import com.google.common.base.Strings
import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.common.base.util.ImportHelpers
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.room.RoomPackage
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 *  See modellib etrice.api.contracts.*
 */
class InterfaceContractHelpers {

	public static val InterfaceContract_NAME= "InterfaceContract"
	public static val ContractClass_KEY = "definedBy"
	
	public static val InterfaceContractDefinition_NAME = "InterfaceContractDefinition"
	public static val Protocol_KEY = "protocol"
	public static val GeneratedMonitorName_KEY = "generatedMonitorName"

	@Inject RoomHelpers roomHelpers
	@Inject ImportHelpers importHelpers
	@Inject IQualifiedNameConverter fqnConverter
	@Inject IQualifiedNameProvider fqnProvider
	
	def boolean hasContract(ProtocolClass pc) {
		roomHelpers.isAnnotationPresent(pc.annotations, InterfaceContract_NAME)
	}
	
	def boolean isContract(ActorClass ac) {
		roomHelpers.isAnnotationPresent(ac.annotations, InterfaceContractDefinition_NAME)
	}

	def ActorClass getInterfaceContractActorClass(ProtocolClass pc) {
		val name = roomHelpers.getAttribute(pc.annotations, InterfaceContract_NAME, ContractClass_KEY)
		if(!Strings.isNullOrEmpty(name)) {
			val match = findClassForName(name, RoomPackage.Literals.ACTOR_CLASS, pc.eContainer as RoomModel)	
			val resolved = if(match !== null && match.eIsProxy)  EcoreUtil.resolve(match, pc.eResource.resourceSet)	else match
			if(resolved instanceof ActorClass)
				return resolved
		}
	}
	
	def ProtocolClass getContractProtocol(ActorClass ac) {
		val name = roomHelpers.getAttribute(ac.annotations, InterfaceContractDefinition_NAME, Protocol_KEY)
		if(!Strings.isNullOrEmpty(name)) {
			val match = findClassForName(name, RoomPackage.Literals.PROTOCOL_CLASS, ac.eContainer as RoomModel) as ProtocolClass 	
			val resolved = if(match !== null && match.eIsProxy)  EcoreUtil.resolve(match, ac.eResource.resourceSet)	else match
			if(resolved instanceof ProtocolClass)
				return resolved
		}
	}
	
	def String getGeneratedMonitorName(ActorClass ac) {
		val userName = roomHelpers.getAttribute(ac.annotations, InterfaceContractDefinition_NAME, GeneratedMonitorName_KEY)
		return if(!Strings.isNullOrEmpty(userName))
			userName
		else
			ac.name + '_GeneratedMontior'
	}
	
	/** returns list of regularPorts and conjugatedPorts of contract protocol */
	def Pair<List<Port>, List<Port>> getContractPorts(ActorClass ac, ProtocolClass contractProtocol) {
		val allPorts = roomHelpers.getAllEndPorts(ac)
		val List<Port> regularPorts = newArrayList(allPorts.filter[it.protocol == contractProtocol && !it.conjugated])
		val List<Port> conjugatedPorts = newArrayList(allPorts.filter[it.protocol == contractProtocol && it.conjugated])
		
		regularPorts -> conjugatedPorts
	}

	def private EObject findClassForName(String name, EClass type, RoomModel currentModel) {	
		val fqn = fqnConverter.toQualifiedName(name)
		val modelFQN = fqnProvider.getFullyQualifiedName(currentModel)
		
		if(fqn.segmentCount == 1 || fqn.startsWith(modelFQN)) {
			// search locally
			currentModel.eContents.filter[type.isSuperTypeOf(it.eClass)].filter(RoomClass).findFirst[it.name == fqn.lastSegment]
		}
		else if (currentModel.eResource !== null) {
			// search globally		
			importHelpers.getVisibleScope(currentModel.eResource, type).getSingleElement(fqn)?.EObjectOrProxy
		}
	}
}
