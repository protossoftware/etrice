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

import com.google.inject.Inject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.scoping.IGlobalScopeProvider

import static org.eclipse.etrice.core.room.RoomPackage.Literals.ACTOR_REF__TYPE
import org.eclipse.etrice.core.room.GeneralProtocolClass

/**
 *  See room annotation 'InterfaceContract'
 */
class InterfaceContractHelpers {

	public static val InterfaceContract_ANNOTATION = "InterfaceContract"
	public static val MonitorClass_KEY = "definingActorClassName"

	@Inject RoomHelpers roomHelpers
	@Inject IGlobalScopeProvider scopeProvicer
	@Inject IQualifiedNameConverter fqnConverter
	@Inject IQualifiedNameProvider fqnProvider
	
	def boolean hasContract(GeneralProtocolClass pc) {
		roomHelpers.isAnnotationPresent(pc.annotations, InterfaceContract_ANNOTATION)
	}

	def ActorClass getInterfaceContractActorClass(ProtocolClass pc) {
		if (pc.hasContract) {
			val actorClassNameString = roomHelpers.getAttribute(pc.annotations, InterfaceContract_ANNOTATION, MonitorClass_KEY)
			if(actorClassNameString !== null) {
				return findActorClassForName(actorClassNameString, pc.eContainer as RoomModel)	
			}
		}
	}

	def private ActorClass findActorClassForName(String name, RoomModel currentModel) {	
		val fqn = fqnConverter.toQualifiedName(name)
		val modelFQN = fqnProvider.getFullyQualifiedName(currentModel)
		
		if(fqn.segmentCount == 1 || fqn.startsWith(modelFQN)) {
			// search locally
			currentModel.actorClasses.findFirst[it.name == fqn.lastSegment]
		}
		else if (currentModel.eResource !== null) {
			// search globally		
			scopeProvicer.getScope(currentModel.eResource, ACTOR_REF__TYPE, [true]).getSingleElement(fqn)?.EObjectOrProxy as ActorClass
		}
	}
}
