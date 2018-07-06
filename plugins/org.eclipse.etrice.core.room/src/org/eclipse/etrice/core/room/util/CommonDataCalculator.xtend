/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.room.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition
import org.eclipse.etrice.core.fsm.fSM.TransitionBase
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.ICommonDataCalculator
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.RoomFactory

class CommonDataCalculator implements ICommonDataCalculator {
	
	RoomHelpers roomHelpers = new RoomHelpers
	
	// TODO 529445: return a RefableType, not MessageData
	override EObject calculateCommonData(Link l) {
		if (!l.isIfitemTriggered) {
			return null
		}
		else {
			// since l isIfitemTriggered we have at least one triggered transition
			var transitions = l.chainHeads.map[transition.realTransition].filter(typeof(TriggeredTransition))
			
			// we also expect to have triggers
			val triggers = transitions.map[triggers].flatten
			
			// and we have data which may be null
			val varDeclarations = triggers.map[msgFromIfPairs].flatten.map[message].filter(Message).map[data]
			val allData = varDeclarations.map[it?.refType?.type].toSet
			if (allData.size==1) {
				return varDeclarations.head
			}
			else {
				val types = varDeclarations.map[it?.refType].toList
				val rt = roomHelpers.getLastCommonSuperType(types);
				if (rt!==null) {
					// artificial variable declaration
					val vd = RoomFactory.eINSTANCE.createMessageData
					vd.deprecatedName = "data"
					vd.refType = rt
					return vd
				}
			}
		}
		
		return null
	}
	
	private static def realTransition(TransitionBase t) {
		var tr = t
		while (tr instanceof RefinedTransition) {
			tr = tr.target
		}
		
		return tr
	}
}