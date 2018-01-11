/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.expressions.detailcode

import java.util.List
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.expressions.detailcode.GuardDetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionPostfix
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor

/**
 * Defines expression for fsm detail code of an ActorClass
 */
@FinalFieldsConstructor
class DefaultDetailExpressionProvider extends GuardDetailExpressionProvider {

	override getInitialFeatures() {
		// no super call, keep it simple
		val List<ExpressionFeature> scope = newArrayList

		if(transitionEventData !== null) { 
			scope += new ExpressionFeature('transitionData', ExpressionPostfix.NONE) => [
				data = transitionEventData
			]
		}
		scope += actorClass.latestOperations.map[createExprFeature]
		scope += actorClass.allAttributes.map[createExprFeature]
		actorClass.allInterfaceItems.forEach [
			switch it {
				SPP case isEventDriven/* fall through */,
				Port case isEventDriven && isReplicated: {
					scope += createExprFeature(ExpressionPostfix.NONE) // additional feature for broadcast 
					scope += createExprFeature(ExpressionPostfix.BRACKETS)
				}
				Port case isReplicated/* fall through  */,
				SPP:
					scope += createExprFeature(ExpressionPostfix.BRACKETS)
				default:
					scope += createExprFeature(ExpressionPostfix.NONE)
			}
		]

		return scope.filterNull.filter[id !== null].toList
	}

	override getContextFeatures(ExpressionFeature ctx) {
		// no super call, keep it simple
		ctx.assertNotNull

		val List<ExpressionFeature> scope = newArrayList
		switch obj : ctx.data {
			Port case obj.multiplicity == 1/* fall through  */,
			SAP: scope +=
				obj.protocol.getAllOperations(!obj.conjugated).map[createExprFeature]
		}
		switch obj : ctx.data {
			InterfaceItem: {
				val pc = obj.protocol
				switch pc.commType {
					case EVENT_DRIVEN:
						scope += pc.getAllMessages(obj.conjugated).map[createExprFeature]
					case DATA_DRIVEN:
						if (obj.conjugated)
							scope += pc.allIncomingMessages.map[createExprFeature]
						else
							scope += pc.allIncomingMessages.map[createExprFeature(ExpressionPostfix.NONE)] // data message has no Parenthesis
					case SYNCHRONOUS: {}
				}

			// TODO Attributes ?
			}
			Attribute case obj.type.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[createExprFeature]
				// not supported yet by code translation:
				// scope += dc.latestOperations.map[createExprFeature(ExpressionPostfix.PARENTHESES)]
			}
		}

		return scope.filterNull.filter[id !== null].toList
	}

}
