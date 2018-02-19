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
import com.google.common.collect.ImmutableList
import com.google.common.collect.Sets
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.fsm.fSM.Guard
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.DataType
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.ProtocolClass
import org.eclipse.etrice.core.room.RefableType
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.RoomPackage
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.SPP
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.util.SimpleAttributeResolver

import static com.google.common.base.Verify.*

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class DetailExpressionProvider implements IDetailExpressionProvider {
	
	@Inject IGlobalScopeProvider globalScopeProvider
	
	protected val extension RoomHelpers roomHelpers = new RoomHelpers
	protected val nameProvider = SimpleAttributeResolver.NAME_RESOLVER
	
	/* Context element TODO could be typed to DetailCode */
	@Accessors
	EObject model
	
	//
	// Logic for IDetailExpressionProvider.getInitialFeatures()
	//
	
	/* Special transitionData in FSM context */
	@Accessors
	MessageData transitionEventData = null
	
	/* Cache for expressions in RoomClass context. Can be shared among multiple instance. */
	@Accessors
	ImmutableList<ExpressionFeature> classScopeCache = null
	
	def ImmutableList<ExpressionFeature> createAndSetClassScopeCache() {
		verifyNotNull(model)
		if(classScopeCache === null) {
			val classScope = newArrayList
			
			val roomClass = model.getContainerOfType(RoomClass)
			if(roomClass !== null) {
				initialClassFeatures(roomClass, classScope)
			}
		
			classScopeCache = ImmutableList.copyOf(classScope.filterNull.filter[id !== null])
		}
		
		return classScopeCache
	}
	
	override getInitialFeatures() {
		verifyNotNull(model)
		verifyNotNull(globalScopeProvider)
		
		val elementScope = newArrayList

		if(transitionEventData !== null) { 
			elementScope += new ExpressionFeature('transitionData', ExpressionPostfix.NONE) => [
				data = transitionEventData
			]
		}
		if(model.isInContainment(Operation)) {
			elementScope += model.getContainerOfType(Operation).arguments.map[createExprFeature(ExpressionPostfix.NONE)]
		}
		if(model.isInContainment(ActorClass)) {
			initialFsmExpression(model, model.getContainerOfType(ActorClass), elementScope)
		}
	
		return {
			if(elementScope.empty)
				 createAndSetClassScopeCache
			else 
				(elementScope.filterNull.filter[id !== null] + createAndSetClassScopeCache).toList
		}
	}
	
	protected def void initialClassFeatures(RoomClass cls, List<ExpressionFeature> scope) {
		switch cls {
			ActorClass: {
				scope += cls.latestOperations.map[createExprFeature]
				scope += cls.allAttributes.map[createExprFeature]
			}
			PortClass: {
				// TODO operations
				// TODO inherited attributes
				scope += cls.attributes.map[createExprFeature]
			}
			DataClass: {
				scope += cls.latestOperations.map[createExprFeature]
				scope += cls.allAttributes.map[createExprFeature]
			}
		}
				
		classTypes(cls, scope)
	}
	
	/**
	 *  TODO align with generator
	 */
	protected def void classTypes(RoomClass cls, List<ExpressionFeature> scope) {
		val types = <DataType>newHashSet
		
		// imported types
		types += globalScopeProvider.getScope(cls.eResource, RoomPackage.Literals.REFABLE_TYPE__TYPE, null)
					.allElements.map[EObjectOrProxy].filter(DataType)
		// local types
		types += EcoreUtil.getRootContainer(cls).eContents.filter(DataType)
		
		// indirectly referenced types	
		types += {
			// everything that contains RefableType
			val refableContainers = switch cls {
				ActorClass:
					cls.interfaceItems.map[protocol].filterNull.toHashSet.map[classHierarchy].flatten + cls.attributes + cls.operations
				ProtocolClass:
					#[cls] + cls.classHierarchy
				DataClass:
					#[cls] + cls.classHierarchy
				default:
					emptyList
			}
			// get all data types
			refableContainers.map[EcoreUtil2.eAllOfType(it, RefableType)].flatten.map[type]
		}
		
		// nested + class hierarchy of DataClasses
		var toResolve = types.filter(DataClass).toList
		while(!toResolve.empty) {
			val newTypes = toResolve.map[EcoreUtil2.eAllOfType(it, RefableType)].flatten.map[type].toHashSet
			toResolve = Sets.difference(newTypes, types).filter(DataClass).map[base].filterNull.map[classHierarchy].flatten.toList
			types += newTypes
		}
		
		scope += types.map[createExprFeature(it, ExpressionPostfix.NONE)]
	}
	
	protected def void initialFsmExpression(EObject model, ActorClass ac, List<ExpressionFeature> scope) {
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
	}
	
	//
	// Logic for IDetailExpressionProvider.getContextFeatures()
	//
	
	override getContextFeatures(ExpressionFeature ctx) {
		verifyNotNull(ctx)
		
		val List<ExpressionFeature> scope = newArrayList
		
		switch obj : ctx.data {
			Port case obj.multiplicity == 1/* fall through  */,
			SAP: scope +=
				obj.protocol.getAllOperations(!obj.conjugated).map[createExprFeature]
		}
		switch obj : ctx.data {
			InterfaceItem:
				contextFsmMessages(obj, ctx, scope)		
			Attribute case obj.type?.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[createExprFeature]
				scope += dc.latestOperations.map[createExprFeature]
			}
			EnumerationType: {
				// from descriptions, have to be resolved
				var enumType = obj
				if(obj.eIsProxy) {
					val resolved = EcoreUtil.resolve(obj, model)
					if(resolved instanceof EnumerationType)
						enumType = resolved
				}
				scope += enumType.literals.map[createExprFeature(it, ExpressionPostfix.NONE)]	
			}
		}

		return scope.filterNull.filter[id !== null].toList
	}
	
	protected def void contextFsmMessages(InterfaceItem ifItem, ExpressionFeature ctx, List<ExpressionFeature> scope) {
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
	}
	
	//
	// extensions
	//
	
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
	
	private def static <T> Set<T> toHashSet(Iterable<T> iterable) {
		if (iterable instanceof Set<?>) {
			return iterable as Set<T>
		}
		return Sets.newHashSet(iterable);
	}
	
}