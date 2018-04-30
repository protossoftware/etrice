/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.ast

import java.util.Deque
import java.util.LinkedList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.EnumerationType
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.PortClass
import org.eclipse.etrice.core.room.RoomClass
import org.eclipse.etrice.core.room.SAP
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.core.room.util.RoomHelpers
import org.eclipse.etrice.dctools.fsm.ast.CandidateMap
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstArrayAccessNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstFeatureCallNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOperationCallNode
import org.eclipse.etrice.dctools.fsm.ast.util.IDCAstNodeVisitor

import static org.eclipse.etrice.core.fsm.fSM.FSMPackage.Literals.*

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.etrice.core.fsm.fSM.DetailCode

class DCLinker implements IDCAstNodeVisitor {
	
	enum FeatureType {
		SCALAR,
		ARRAY,
		OPERATION
	}
	
	EObject owner
	EReference reference
	MessageData transitionData
	
	protected val extension RoomHelpers roomHelpers = new RoomHelpers
	
	val Deque<EObject> contexts = new LinkedList
	
	new(DetailCode dc) {
		this(dc.eContainer, dc.eContainingFeature as EReference)
	}
	
	new(EObject owner, EReference reference) {
		this(owner, reference, null)
	}
	
	new(DetailCode dc, MessageData transitionData) {
		this(dc.eContainer, dc.eContainingFeature as EReference, transitionData)
	}
	
	new(EObject owner, EReference reference, MessageData transitionData) {
		this.owner = owner
		this.reference = reference
		this.transitionData = transitionData
	}
	
	override visitBegin(DCAstNode node) {
		switch node {
			DCAstFeatureCallNode: {
				// a feature call always starts in the global context
				contexts.push(owner)
			}
			DCAstIdentifierNode case node.parent instanceof DCAstFeatureCallNode: link(node)
			DCAstArrayAccessNode: link(node)
			DCAstOperationCallNode: link(node)
		}
		
		return true
	}
	
	override visitEnd(DCAstNode node) {
		switch node {
			DCAstFeatureCallNode: contexts.pop
		}
	}
	
	protected def dispatch void link(DCAstIdentifierNode node) {
		val candidates = getCandidates(FeatureType.SCALAR)
		node.linkedObject = candidates.get(node.identifier)
		replaceContext(node.linkedObject)
	}
	
	protected def dispatch void link(DCAstArrayAccessNode node) {
		val candidates = getCandidates(FeatureType.ARRAY)
		node.linkedObject = candidates.get(node.id)
		replaceContext(node.linkedObject)
	}
	
	protected def dispatch void link(DCAstOperationCallNode node) {
		val candidates = getCandidates(FeatureType.OPERATION)
		node.linkedObject = candidates.get(node.id)
		replaceContext(node.linkedObject)
	}
	
	protected def replaceContext(EObject obj) {
		contexts.pop
		contexts.push(obj?.contextOf)
	}
	
	protected def dispatch getContextOf(EObject obj) {
		null
	}
	
	protected def dispatch getContextOf(Port port) {
		port
	}
	
	protected def dispatch getContextOf(Attribute att) {
		att.type.type
	}
	
	protected def dispatch getContextOf(VarDecl vd) {
		vd.refType.type
	}
	
	protected def dispatch getContextOf(MessageData md) {
		md?.refType?.type
	}
	
	protected def dispatch getContextOf(Operation op) {
		op?.returnType?.type
	}
	
	//http://git.eclipse.org/c/etrice/org.eclipse.etrice.git/tree/tests/org.eclipse.etrice.generator.common.tests/models/EnumTest.room?h=newfsmgen_finalize&id=79aa00b074c61bde5173d4859ce2b52e50b52dec#n117
	
	protected def getCandidates(FeatureType type) {
		val candidates = new CandidateMap
		
		if (contexts.peek===owner) {
			// this is the top level
			topLevelCandidates(candidates, type)
		}
		else {
			val current = contexts.peek
			switch current {
				DataClass: {
					current.getCandidates(type, candidates)
				}
				
				InterfaceItem: {
					current.getCandidates(candidates)
				}
				
				Attribute case current.type?.type instanceof DataClass: {
					val dc = current.type.type as DataClass
					dc.getCandidates(type, candidates)
				}
				MessageData case current.refType?.type instanceof DataClass: {
					val dc = current.refType.type as DataClass
					dc.getCandidates(type, candidates)
				}
				EnumerationType: {
					// from descriptions, have to be resolved
					var enumType = current
					if (current.eIsProxy) {
						val resolved = EcoreUtil.resolve(current, owner)
						if (resolved instanceof EnumerationType)
							enumType = resolved
					}
					enumType.literals.forEach[candidates.put(it.name, it)]	
				}
			}
		}
		
		return candidates
	}
	
	protected def void topLevelCandidates(CandidateMap candidates, FeatureType type) {
		// operation arguments
		owner.getContainerOfType(Operation)?.arguments?.forEach[candidates.put(it.name, it)]
		
		// TODO: compare with org.eclipse.etrice.expressions.detailcode.DetailExpressionProvider.initialFsmExpression(EObject, ActorClass, List<ExpressionFeature>)
		if (!reference.name.contains('userCode')) {
			val roomClass = owner.getContainerOfType(RoomClass)
			switch roomClass {
				ActorClass: {
					if (transitionData!==null) {
						candidates.put("transitionData", transitionData)
					}
					if (type==FeatureType.SCALAR) {
						roomClass.allAttributes.forEach[candidates.put(it.name, it)]
					}
					if (type==FeatureType.ARRAY) {
						roomClass.allAttributes.filter[size>1].forEach[candidates.put(it.name, it)]
					}
					if (type==FeatureType.OPERATION) {
						roomClass.latestOperations.forEach[candidates.put(it.name, it)]
					}
					roomClass.allInterfaceItems.forEach[
						switch it {
							Port case type==FeatureType.SCALAR: candidates.put(it.name, it)
							Port case type==FeatureType.ARRAY && it.replicated: candidates.put(it.name, it)
							SAP case type==FeatureType.SCALAR: candidates.put(it.name, it)
						}
					]
				}
				
				DataClass: {
					roomClass.getCandidates(type, candidates)
				}
				
				case owner.getContainerOfType(PortClass)!==null: {
					val portClass = owner.getContainerOfType(PortClass)
					// TODO inheritance
					portClass.operations.forEach[candidates.put(it.name, it)]
					portClass.attributes.forEach[candidates.put(it.name, it)]
				}
			}
		}
	}
	
	protected def void getCandidates(DataClass dataClass, FeatureType type, CandidateMap candidates) {
		if (type==FeatureType.SCALAR) {
			dataClass.allAttributes.forEach[candidates.put(it.name, it)]
		}
		if (type==FeatureType.ARRAY) {
			dataClass.allAttributes.filter[size>1].forEach[candidates.put(it.name, it)]
		}
		if (type==FeatureType.OPERATION) {
			dataClass.latestOperations.forEach[candidates.put(it.name, it)]
		}
	}
	
	protected def void getCandidates(InterfaceItem ifItem, CandidateMap candidates) {
		// operations
		ifItem.protocol.getAllOperations(!ifItem.conjugated).forEach[candidates.put(it.name, it)]
		
		// messages
		switch reference {
			case CP_BRANCH_TRANSITION__CONDITION,
			case GUARDED_TRANSITION__GUARD,
			case GUARD__GUARD: {
				val pc = ifItem.protocol
				switch pc?.commType {
					case DATA_DRIVEN:
						if (!ifItem.conjugated) pc.allIncomingMessages.forEach[candidates.put(it.name, it)]
					case EVENT_DRIVEN: { /* no async message calls */}
					case SYNCHRONOUS: {}
				}
			}
			case owner.getContainerOfType(StateGraphItem)!==null: {
				val pc = ifItem.protocol
				switch pc?.commType {
					case EVENT_DRIVEN:
						pc.getAllMessages(ifItem.conjugated).forEach[candidates.put(it.name, it)]
					case DATA_DRIVEN:
						pc.allIncomingMessages.forEach[candidates.put(it.name, it)]
					case SYNCHRONOUS: {}
				}				
			}
		}
	}
}