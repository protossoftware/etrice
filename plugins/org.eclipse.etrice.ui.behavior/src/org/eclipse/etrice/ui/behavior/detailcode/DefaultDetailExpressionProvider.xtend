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
package org.eclipse.etrice.ui.behavior.detailcode

import java.util.List
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Port
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.SAP
/**
 * Defines expression for fsm detail code of an ActorClass
 */
@FinalFieldsConstructor
class DefaultDetailExpressionProvider extends GuardDetailExpressionProvider {

	override getInitialFeatures() {
		val List<ExpressionFeature> scope = newArrayList

		if (currentEventMessage != null)
			scope += createExprFeature(currentEventMessage.data)
		actorClass.allInterfaceItems.forEach [
			switch it {
				SPP case isEventDriven/* fall through */,
				Port case isEventDriven && isReplicated: {
					scope += createExprFeature // additional feature for broadcast 
					scope += createExprFeature(ExpressionPostfix.BRACKETS)
				}
				Port case isReplicated/* fall through  */,
				SPP:
					scope += createExprFeature(ExpressionPostfix.BRACKETS)
				default:
					scope += createExprFeature
			}
		]
		scope += actorClass.latestOperations.map[createExprFeature(ExpressionPostfix.PARENTHESES)]
		scope += actorClass.allAttributes.map[
			switch (size) {
				case size > 1: createExprFeature(ExpressionPostfix.BRACKETS)
				default: createExprFeature
			}]

		return scope
	}

	override getContextFeatures(ExpressionFeature ctx) {
		ctx.assertNotNull

		val List<ExpressionFeature> scope = newArrayList
		switch obj : ctx.data {
			Port case obj.multiplicity == 1/* fall through  */,
			SAP: scope +=
				obj.protocol.getAllOperations(!obj.conjugated).map[createExprFeature(ExpressionPostfix.PARENTHESES)]
		}
		switch obj : ctx.data {
			InterfaceItem: {
				val pc = obj.protocol
				switch pc.commType {
					case EVENT_DRIVEN:
						scope += pc.getAllMessages(obj.conjugated).map[createExprFeature(ExpressionPostfix.PARENTHESES)]
					case DATA_DRIVEN:
						if (obj.conjugated)
							scope += pc.allIncomingMessages.map[createExprFeature(ExpressionPostfix.PARENTHESES)]
						else
							scope += pc.allIncomingMessages.map[createExprFeature]
					case SYNCHRONOUS: {
					}
				}

			// TODO Attributes ?
			}
			Attribute case obj.type.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[
					if(size > 1) createExprFeature(ExpressionPostfix.BRACKETS) else createExprFeature]
				// not supported yet by code translation:
				// scope += dc.latestOperations.map[createExprFeature(ExpressionPostfix.PARENTHESES)]
			}
		}

		return scope
	}

}
