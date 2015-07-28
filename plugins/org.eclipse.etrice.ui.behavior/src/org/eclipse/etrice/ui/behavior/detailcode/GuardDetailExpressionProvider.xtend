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
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider
import org.eclipse.etrice.ui.behavior.support.SupportUtil
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.util.SimpleAttributeResolver

/**
 * Defines expression for fsm guards of an ActorClass
 * <ul>
 * <li>attributes and operations of ActorClass</li>
 * <li>data-driven incoming messages</li>
 * </ul>
 */
class GuardDetailExpressionProvider implements IDetailExpressionProvider {

	@Accessors protected val ActorClass actorClass
	
	@Accessors protected Message currentEventMessage

	protected val extension RoomHelpers roomHelpers
	protected val Function<EObject, String> nameProvider = SimpleAttributeResolver.NAME_RESOLVER

	new(ActorClass actorClass){
		this.actorClass = actorClass
		roomHelpers = SupportUtil.getInstance.roomHelpers
	}

	override getInitialFeatures() {
		val List<ExpressionFeature> scope = newArrayList

		if(currentEventMessage != null)
			scope += createExprFeature(currentEventMessage.data)
		scope += actorClass.allInterfaceItems.filter[isDataDriven && !isConjugated].map[
			switch it {
				Port case multiplicity > 1: createExprFeature(ExpressionPostfix.BRACKETS)
				default: createExprFeature
			}]
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
			InterfaceItem: {
				val pc = obj.protocol
				switch pc.commType {
					case DATA_DRIVEN:
						if (!obj.conjugated)
							scope += pc.allIncomingMessages.map[createExprFeature]
				}
			}
			Attribute case obj.type.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[
					if(size > 1) createExprFeature(ExpressionPostfix.BRACKETS) else createExprFeature]
				scope += dc.latestOperations.map[createExprFeature(ExpressionPostfix.PARENTHESES)]
			}
		}

		return scope
	}

	def protected createExprFeature(EObject eObj) {
		createExprFeature(eObj, ExpressionPostfix.NONE)
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
