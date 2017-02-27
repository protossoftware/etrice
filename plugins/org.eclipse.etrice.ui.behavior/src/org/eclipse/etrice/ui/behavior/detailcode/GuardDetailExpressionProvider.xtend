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

import com.google.common.base.Function
import com.google.common.base.Strings
import java.util.List
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider
import org.eclipse.etrice.ui.behavior.support.SupportUtil
import org.eclipse.xtend.lib.annotations.AccessorType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.SimpleAttributeResolver

import static extension org.eclipse.xtend.lib.annotations.AccessorType.*
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Message

/**
 * Defines expression for fsm guards of an ActorClass
 * <ul>
 * <li>attributes and operations of ActorClass</li>
 * <li>data-driven incoming messages</li>
 * </ul>
 */
 @FinalFieldsConstructor
class GuardDetailExpressionProvider implements IDetailExpressionProvider {

	// ctor
	protected val ActorClass actorClass
	protected val extension RoomHelpers roomHelpers = SupportUtil.getInstance.roomHelpers
	protected val Function<EObject, String> nameProvider = SimpleAttributeResolver.NAME_RESOLVER
	
	// optional
	@Accessors(AccessorType.PUBLIC_SETTER) protected VarDecl transitionEventData

	override getInitialFeatures() {
		val List<ExpressionFeature> scope = newArrayList

		if(transitionEventData != null) { 
			scope += transitionEventData.createExprFeature(ExpressionPostfix.NONE)
		}
		scope += actorClass.allInterfaceItems.filter[isEventDriven || !isConjugated].map[
			switch it {
				Port case isReplicated: createExprFeature(ExpressionPostfix.BRACKETS)
				default: createExprFeature(ExpressionPostfix.NONE)
		}]
		scope += actorClass.latestOperations.map[createExprFeature]
		scope += actorClass.allAttributes.map[createExprFeature]

		return scope
	}

	override getContextFeatures(ExpressionFeature ctx) {
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
					case DATA_DRIVEN:
						if (!obj.conjugated) scope += pc.allIncomingMessages.map[createExprFeature]
					case EVENT_DRIVEN: { /* no async message calls */}
					case SYNCHRONOUS: {}
				}
			}
			Attribute case obj.type.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[createExprFeature]
				scope += dc.latestOperations.map[createExprFeature]
			}
		}

		return scope
	}
	
	def ExpressionFeature createExprFeature(Operation it){
		// assuming all operations have parenthesis
		createExprFeature(ExpressionPostfix.PARENTHESES)
	}
	
	def ExpressionFeature createExprFeature(Message it){
		// assuming all message have parenthesis
		createExprFeature(ExpressionPostfix.PARENTHESES)
	}
	
	def ExpressionFeature createExprFeature(Attribute it){
		// assuming all attributes have brackets or not depending on size
		switch (size) {
			case size > 1: createExprFeature(ExpressionPostfix.BRACKETS)
			default: createExprFeature(ExpressionPostfix.NONE)
		}
	}

	def protected createExprFeature(EObject eObj, ExpressionPostfix postfix) {
		val feature = new ExpressionFeature(nameProvider.apply(eObj), postfix)
		feature.data = eObj

		return feature
	}

	def protected assertNotNull(ExpressionFeature feature) {
		Assert.isTrue(!Strings.isNullOrEmpty(feature.id))
		Assert.isNotNull(feature.postfix)
		Assert.isNotNull(feature.data)
	}

}
