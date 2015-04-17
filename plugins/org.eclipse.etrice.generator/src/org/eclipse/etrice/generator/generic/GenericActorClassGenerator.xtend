/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic

import com.google.inject.Inject
import java.util.ArrayList
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass
import org.eclipse.etrice.generator.generic.RoomExtensions
import org.eclipse.xtext.util.Pair
import static org.eclipse.xtext.util.Tuples.*
import org.eclipse.etrice.core.room.util.RoomHelpers
import static extension org.eclipse.etrice.generator.fsm.base.Indexed.*
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.generator.fsm.generic.IIfItemIdGenerator
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem

/**
 * Target language independent part of an actor class generator.
 * It uses the {@link ILanguageExtension}.
 */
class GenericActorClassGenerator implements IIfItemIdGenerator {

	@Inject protected extension RoomHelpers
	@Inject protected extension RoomExtensions
	@Inject protected ILanguageExtension langExt

	/**
	 * Generate constants for the local IDs of all interface items of an actor
	 * class.
	 * 
	 * @param xpac an {@link ExpandedActorClass}
	 * @return the generated code
	 */
	def genInterfaceItemConstants(ExpandedActorClass xpac) {
		val ac = xpac.actorClass
		val endPorts = if (langExt.usesInheritance)
			ac.endPorts else ac.allEndPorts
		val strSAPs = if (langExt.usesInheritance)
			ac.serviceAccessPoints else ac.getAllSAPs
		val svcImpls = if (langExt.usesInheritance)
			ac.serviceImplementations else ac.allServiceImplementations
			
		val list = new ArrayList<Pair<String, String>>()
		for (ep : endPorts) {
			list.add(pair(ep.ifItemId, (1+xpac.getInterfaceItemLocalId(ep)).toString))
		}
		for (sap : strSAPs) {
			list.add(pair(sap.ifItemId, (1+xpac.getInterfaceItemLocalId(sap)).toString))
		}
		for (svc : svcImpls) {
			list.add(pair(svc.spp.ifItemId, (1+xpac.getInterfaceItemLocalId(svc.spp)).toString))
		}
		
		return langExt.genEnumeration("interface_items", list)
	}
	
	def genInterfaceItemConstantsForOptionalActor(ActorClass ac) {
		val ports = ac.allInterfacePorts
		val list = new ArrayList<Pair<String, String>>()
		for (ep : ports.indexed) {
			list.add(pair(ep.value.ifItemId, ep.index1.toString))
		}
		
		return langExt.genEnumeration("interface_items", list)
	}
    
    override getIfItemId(AbstractInterfaceItem item) {
        "IFITEM_"+item.name
    }

}