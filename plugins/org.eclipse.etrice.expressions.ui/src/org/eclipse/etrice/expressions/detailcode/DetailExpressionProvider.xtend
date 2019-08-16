/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.expressions.detailcode

import com.google.common.base.Strings
import com.google.common.collect.ImmutableList
import com.google.common.collect.Sets
import com.google.inject.Inject
import java.util.List
import java.util.Set
import org.eclipse.core.runtime.Assert
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
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

import static org.eclipse.etrice.core.fsm.fSM.FSMPackage.Literals.*

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

class DetailExpressionProvider implements IDetailExpressionProvider {
	
	@Inject IGlobalScopeProvider globalScopeProvider
	
	protected val extension RoomHelpers roomHelpers = new RoomHelpers
	protected val nameProvider = SimpleAttributeResolver.NAME_RESOLVER
	
	/* DetailCode owner */
	@Accessors EObject owner	
	
	/* Role of DetailCode */
	@Accessors EReference reference	
	
	//
	// Logic for IDetailExpressionProvider.getInitialFeatures()
	//
	
	/* Special transitionData in FSM context */
	@Accessors
	MessageData transitionEventData = null
	
	/* Cache for expressions in RoomClass context. Can be shared among multiple instance.
	 * Currently all available DataTypes.
	 */
	@Accessors
	ImmutableList<ExpressionFeature> sharedCache = null
	
	def ImmutableList<ExpressionFeature> createAndSetSharedCache() {
		verifyNotNull(owner)
		
		if(sharedCache === null) {
			val classScope = newArrayList
			
			val roomClass = owner.getContainerOfType(RoomClass)
			if(roomClass !== null) {
				classTypes(roomClass, classScope)
			}
		
			sharedCache = ImmutableList.copyOf(classScope.filterNull.filter[id !== null])
		}
		
		return sharedCache
	}
	
	override getInitialFeatures() {
		verifyNotNull(owner)
		verifyNotNull(owner.eContainer)
		verifyNotNull(reference)
		verifyNotNull(globalScopeProvider)
		
		val elementScope = newArrayList

		if(transitionEventData !== null) { 
			elementScope += new ExpressionFeature('transitionData', ExpressionPostfix.NONE) => [
				data = transitionEventData
			]
		}
		if(owner.isInContainment(Operation)) {
			elementScope += owner.getContainerOfType(Operation).arguments.map[createExprFeature(ExpressionPostfix.NONE)]
		}
		if(!reference.name.contains('userCode')) {
			val roomClass = owner.getContainerOfType(RoomClass)
			switch cls: roomClass {
				ActorClass: {
					elementScope += cls.latestOperations.map[createExprFeature]
					elementScope += cls.allAttributes.map[createExprFeature]
					initialFsmExpression(owner, cls, elementScope)
				}
				DataClass: {
					elementScope += cls.latestOperations.map[createExprFeature]
					elementScope += cls.allAttributes.map[createExprFeature]
				}
				case owner.isInContainment(PortClass): {
					val portClass = owner.getContainerOfType(PortClass)
					// TODO inheritance
					elementScope += portClass.operations.map[createExprFeature]
					elementScope += portClass.attributes.map[createExprFeature]
				}
			}	
		}	
		
		val typesScope = {
			switch reference {
				case CP_BRANCH_TRANSITION__CONDITION,
				case GUARDED_TRANSITION__GUARD,
				case GUARD__GUARD: {	
					// enums only			
					createAndSetSharedCache.filter[data instanceof EnumerationType]
				}
				default: createAndSetSharedCache
			}
		}
		
		return (elementScope.filterNull.filter[id !== null] + typesScope).toList
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
					cls.allInterfaceItems.map[roomProtocol].filterNull.toHashSet.map[classHierarchy].flatten + cls.attributes + cls.operations
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
		switch reference {
			case CP_BRANCH_TRANSITION__CONDITION,
			case GUARDED_TRANSITION__GUARD: {
				scope += ac.allInterfaceItems.filter[isEventDriven || !isConjugated].map[
					switch it {
						Port case isReplicated: createExprFeature(IDetailExpressionProvider.ExpressionPostfix.BRACKETS)
						default: createExprFeature(IDetailExpressionProvider.ExpressionPostfix.NONE)
				}]
			}
			case model.isInContainment(Operation),
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
		verifyNotNull(owner)
		verifyNotNull(reference)
		
		val List<ExpressionFeature> scope = newArrayList
		
		switch obj : ctx.data {
			Port case obj.multiplicity == 1/* fall through  */,
			SAP: scope += obj.roomProtocol.getAllOperations(!obj.conjugated).map[createExprFeature]
		}
		switch obj : ctx.data {
			InterfaceItem:
				contextFsmMessages(obj, ctx, scope)		
			Attribute case obj.type?.type instanceof DataClass: {
				val dc = obj.type.type as DataClass
				scope += dc.allAttributes.map[createExprFeature]
				scope += dc.latestOperations.map[createExprFeature]
			}
			MessageData case obj.refType?.type instanceof DataClass: {
				val dc = obj.refType.type as DataClass
				scope += dc.allAttributes.map[createExprFeature]
				scope += dc.latestOperations.map[createExprFeature]
			}
			EnumerationType: {
				// from descriptions, have to be resolved
				var enumType = obj
				if(obj.eIsProxy) {
					val resolved = EcoreUtil.resolve(obj, owner)
					if(resolved instanceof EnumerationType)
						enumType = resolved
				}
				scope += enumType.literals.map[createExprFeature(it, ExpressionPostfix.NONE)]	
			}
		}

		return scope.filterNull.filter[id !== null].toList
	}
	
	protected def void contextFsmMessages(InterfaceItem ifItem, ExpressionFeature ctx, List<ExpressionFeature> scope) {				
		switch reference {
			case CP_BRANCH_TRANSITION__CONDITION,
			case GUARDED_TRANSITION__GUARD,
			case GUARD__GUARD: {
				val pc = ifItem.roomProtocol
				switch pc?.commType {
					case DATA_DRIVEN:
						if (!ifItem.conjugated) scope += pc.allIncomingMessages.map[createExprFeature]
					case EVENT_DRIVEN: { /* no async message calls */}
					case SYNCHRONOUS: {}
				}
			}
			case owner.isInContainment(StateGraphItem): {
				val pc = ifItem.roomProtocol
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
	
	private def <T> verifyNotNull(T ref) {
		if(ref === null)
			throw new NullPointerException
		
		return ref
	}
	
}