/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

import com.google.common.base.Strings
import java.util.List
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.Guard
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.xtend.lib.annotations.AccessorType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.util.SimpleAttributeResolver

import static extension org.eclipse.xtend.lib.annotations.AccessorType.*
import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

@FinalFieldsConstructor
class DetailExpressionProvider implements IDetailExpressionProvider {
	
	// ctor
	protected val EObject model
	protected val extension RoomHelpers roomHelpers = new RoomHelpers
	protected val nameProvider = SimpleAttributeResolver.NAME_RESOLVER
	
	// optional
	@Accessors(AccessorType.PUBLIC_SETTER) protected MessageData transitionEventData

	override getInitialFeatures() {
		val scope = newArrayList

		if(transitionEventData !== null) { 
			scope += new ExpressionFeature('transitionData', ExpressionPostfix.NONE) => [
				data = transitionEventData
			]
		}
		if(model.isInContainment(Operation)) {
			scope += model.getContainerOfType(Operation).arguments.map[createExprFeature(ExpressionPostfix.NONE)]
		}
		switch model {
			case model.isInContainment(ActorClass): {
				val ac = model.getContainerOfType(ActorClass)
				scope += initialFsmExpression(ac)
				scope += ac.latestOperations.map[createExprFeature]
				scope += ac.allAttributes.map[createExprFeature]
			}
			case model.isInContainment(PortClass): {
				val pc = model.getContainerOfType(PortClass)
				// TODO operations
				// TODO inherited attributes
				scope += pc.attributes.map[createExprFeature]
			}
			case model.isInContainment(DataClass): {
				val dc = model.getContainerOfType(DataClass)
				scope += dc.latestOperations.map[createExprFeature]
				scope += dc.allAttributes.map[createExprFeature]
			}
		}

		return scope.filterNull.filter[id !== null].toList
	}
	
	protected def List<ExpressionFeature> initialFsmExpression(ActorClass ac) {
		val scope = newArrayList
		switch model {
			case model.isInContainment(Guard): {
				scope += ac.allInterfaceItems.filter[isEventDriven || !isConjugated].map[
					switch it {
						Port case isReplicated: createExprFeature(IDetailExpressionProvider.ExpressionPostfix.BRACKETS)
						default: createExprFeature(IDetailExpressionProvider.ExpressionPostfix.NONE)
				}]
			}
			case model.isInContainment(StateGraphItem): {
				ac.allInterfaceItems.forEach [
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
			}
		}
		
		return scope
	}
	
	protected def List<ExpressionFeature> contextFsmMessages(InterfaceItem ifItem, ExpressionFeature ctx) {
		val scope = newArrayList
		switch model {
			case model.isInContainment(Guard): {
				val pc = ifItem.protocol
				switch pc?.commType {
					case DATA_DRIVEN:
						if (!ifItem.conjugated) scope += pc.allIncomingMessages.map[createExprFeature]
					case EVENT_DRIVEN: { /* no async message calls */}
					case SYNCHRONOUS: {}
				}
			}
			case model.isInContainment(StateGraphItem): {
				val pc = ifItem.protocol
				switch pc?.commType {
					case EVENT_DRIVEN:
						scope += pc.getAllMessages(ifItem.conjugated).map[createExprFeature]
					case DATA_DRIVEN:
						if (ifItem.conjugated)
							scope += pc.allIncomingMessages.map[createExprFeature]
						else
							scope += pc.allIncomingMessages.map[createExprFeature(ExpressionPostfix.NONE)] // data message has no Parenthesis
					case SYNCHRONOUS: {}
				}				
			}
		}
		
		return scope
	}
	
	override getContextFeatures(ExpressionFeature ctx) {
		val List<ExpressionFeature> scope = newArrayList
		
		switch obj : ctx.data {
			Port case obj.multiplicity == 1/* fall through  */,
			SAP: scope +=
				obj.protocol.getAllOperations(!obj.conjugated).map[createExprFeature]
		}
		switch obj : ctx.data {
			Port case obj.multiplicity == 1/* fall through  */,
			SAP: scope +=
				obj.protocol.getAllOperations(!obj.conjugated).map[createExprFeature]	
			InterfaceItem:
				scope += contextFsmMessages(obj, ctx)		
			Attribute case obj.type?.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[createExprFeature]
				scope += dc.latestOperations.map[createExprFeature]
			}
		}

		return scope.filterNull.filter[id !== null].toList
	}
	
	def ExpressionFeature createExprFeature(Operation it){
		// assuming all operations have parenthesis
		createExprFeature(IDetailExpressionProvider.ExpressionPostfix.PARENTHESES)
	}
	
	def ExpressionFeature createExprFeature(Message it){
		// assuming all message have parenthesis
		createExprFeature(IDetailExpressionProvider.ExpressionPostfix.PARENTHESES)
	}
	
	def ExpressionFeature createExprFeature(Attribute it){
		// assuming all attributes have brackets or not depending on size
		switch (size) {
			case size > 1: createExprFeature(IDetailExpressionProvider.ExpressionPostfix.BRACKETS)
			default: createExprFeature(IDetailExpressionProvider.ExpressionPostfix.NONE)
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
	
	private def isInContainment(EObject it, Class<? extends EObject> clazz) {
		getContainerOfType(clazz) !== null
	}
	
}