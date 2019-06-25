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
 * 		hrr@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm

import java.util.HashMap
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.etrice.core.fsm.fSM.FSMPackage
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint
import org.eclipse.etrice.core.fsm.fSM.Trigger
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.core.fsm.util.FSMHelpers
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph

class ExtendedFsmGenBuilder extends BasicFsmGenBuilder {

	protected extension ICommonDataCalculator commonDataCalculator
	protected extension TriggerExtensions triggerExtensions
	
	protected IDiagnostician validator
	
	val factory = FsmGenFactory.eINSTANCE
	
	new(FSMHelpers fsmHelpers, ICommonDataCalculator commonDataCalculator, TriggerExtensions triggerExtensions, IDiagnostician validator) {
		super(fsmHelpers)
		this.commonDataCalculator = commonDataCalculator
		this.triggerExtensions = triggerExtensions
		this.validator = if(validator === null) new NullDiagnostician else validator
	}
	
	override GraphContainer createTransformedModel(ModelComponent mc) {
		super.createTransformedModel(mc).check(mc)
	}
	
	/**
	 * computes the available triggers for all leaf states
	 */
	def withTriggersInStates(GraphContainer gc) {
		if (!gc.initializedTriggersInStates) {
			if (gc.graph!==null) {
				gc.graph.allStateNodes.filter[subgraph===null].forEach[computeTriggers]
			}
			gc.initializedTriggersInStates = true
		}
		
		return gc
	}
	
	/**
	 * determines all transition chain heads of all transitions
	 */
	def withChainHeads(GraphContainer gc) {
		if (!gc.initializedChainHeads) {
			if (gc.graph!==null) {
				gc.graph.allChainHeads.forEach[it.followChain(it)]
			}
			gc.initializedChainHeads = true
		}
		
		return gc
	}
	
	/**
	 * calculates and stores the common data. Prerequisite is the computation of the
	 * chain heads, which is performed if not done already.
	 */
	def withCommonData(GraphContainer gc) {
		if (!gc.initializedChainHeads) {
			gc.withChainHeads
		}
		if (!gc.initializedCommonData) {
			if (gc.graph!==null) {
				gc.graph.allLinks.forEach[commonData = calculateCommonData]
			}
			gc.initializedCommonData = true
		}
		
		return gc
	}
	
	private def void followChain(Link l, Link head) {
		// if we started at an initial or guarded transition no interface item can be provided
		if (!(head.transition instanceof TriggeredTransition)) {
			l.ifitemTriggered = false
		}
		
		// add our chain head
		l.chainHeads.add(head)
		
		// have a look at the target node: the chain terminates in states and in transition points
		val target = l.target.stateGraphNode
		if (target instanceof State || target instanceof TransitionPoint) {
			return
		}
		else {
			// follow all outgoing links recursively
			for (next : l.target.outgoing) {
				next.followChain(head)
			}
		}
	}
	
	private def void computeTriggers(Node s) {
		// we use a linked HashMap to preserve the order (insertion) to facilitate testability
		val caughtTriggers = <String, CommonTrigger>newLinkedHashMap
		
		s.computeTriggersRecursive(caughtTriggers)
		
		// make it safe against a duplicate call
		s.caughtTriggers.clear
		
		// transfer the result
		s.caughtTriggers.addAll(caughtTriggers.values)
	}
	
	private def void computeTriggersRecursive(Node s, HashMap<String, CommonTrigger> caughtTriggers) {
		// first visit this state: consider all outgoing triggered transitions
		s.outgoingTriggeredTransitionLinks.toList.computeTriggers(caughtTriggers)
		
		// then handle transition points: consider all outgoing triggered transitions of ALL
		// transition points of the parent graph of this state
		val trPointTransitions = s.graph.transitionPointNodes.map[outgoingTriggeredTransitionLinks].flatten.toList
		trPointTransitions.computeTriggers(caughtTriggers)
		
		// recursively ascend to surrounding context
		if (!s.graph.isTopLevel) {
			s.parentState.computeTriggersRecursive(caughtTriggers)
		}
	}
	
	private def void computeTriggers(List<Link> sameLevelLinks, HashMap<String, CommonTrigger> caughtTriggers) {
		// we need a mapping from transitions to links below
		val trans2link = newHashMap
		sameLevelLinks.forEach[trans2link.put(transition, it)]
		
		for (l : sameLevelLinks) {
			for (tr : (l.transition as TriggeredTransition).triggers) {
				val triggerHasGuard = tr.hasGuard
				for (mif : tr.msgFromIfPairs) {
					val tag = mif.triggerTag
					var ct = caughtTriggers.get(tag)
					
					/*
					 * accept new trigger if
					 * 
					 *  - no inner or inner with guard
					 *  - accept several but only one without guard (count),
					 *    insert those with guard first in the list of the _same_ level(!)
					 */
					if (ct===null) {
						// no inner transition with this trigger exists yet,
						// so this is a new trigger (and our unique point of CommonTrigger creation)
						ct = l.createCommonTrigger(mif, tag)
						ct.hasGuard = triggerHasGuard
						caughtTriggers.put(tag, ct)
					}
					else {
						// check guards of previous transitions: compare all triggers and
						// find matching ones that aren't guarded
						val unguarded = ct.links.map[(transition as TriggeredTransition).triggers].flatten.
								filter[hasMatchingTrigger(tag) && !hasGuard].head?.eContainer as TriggeredTransition
						
						if (unguarded!==null) {
							// we found an unguarded trigger in one of the previous transitions
							
							val unguardedLink = trans2link.get(unguarded)
							if (sameLevelLinks.contains(unguardedLink)) {
								// we have an unguarded transition
								if (triggerHasGuard) {
									// this case is valid. Now we add the transition RIGHT BEFORE the
									// unguarded one we found on the same level
									val idx = ct.links.indexOf(unguardedLink)
									ct.hasGuard = triggerHasGuard
									ct.links.add(idx, l)
								}
								else {
									validationError("Transitions with same trigger on same level have to be guarded!", l.transition, FSMPackage.eINSTANCE.getTriggeredTransition_Triggers())
								}
							}
							//else {
								// this trigger is hidden by a previous unguarded transition on a higher level.
								// No action needed
							//}
						}
						else {
							// append this transition
							ct.links.add(l)
						}
					}
				}
			}
		}
	}
	
	private def boolean hasMatchingTrigger(Trigger trig, String tag) {
		for (mifp2 : trig.msgFromIfPairs) {
			val tr2 = mifp2.triggerTag
			if (tr2.equals(tag)) {
				return true
			}
		}
		return false
	}
	
	def private CommonTrigger createCommonTrigger(Link l, MessageFromIf mif, String tag) {
		val it = factory.createCommonTrigger
		it.trigger = tag
		it.ifitem = mif.from
		it.msg = mif.message
		it.links.add(l)
		
		return it
	}

	def protected check(GraphContainer gc, ModelComponent mc) {
		if (!mc.isAbstract) {
			gc.eAllContents.toIterable.filter(Graph).forEach[checkInitialTransition(mc)]
		}
		return gc
	}
	
	def protected checkInitialTransition(Graph graph, ModelComponent mc) {
		if (graph.initialTransition!==null) {
			// graph has an initial transition
			return
		}
		
		if (graph.eContainer instanceof GraphContainer) {
			validationError("Top level state graph must have an initial transition", mc, FSMPackage.Literals.MODEL_COMPONENT__STATE_MACHINE);
			return;
		}
		
		// in the super state graph search for a transition which points to our parent state
		val parentState = graph.eContainer as Node
		val parentGraph = parentState.eContainer as Graph
		if (!parentGraph.links.filter[target==parentState].empty) {
			validationError("The state graph has transitions to history in its parent graph, thus it must have an initial transition", parentState.stateGraphNode, FSMPackage.Literals.STATE__SUBGRAPH);
		}
	}
	
	protected def void validationError(String msg, EObject obj, EStructuralFeature feature) {
		validationError(msg, obj, feature, IDiagnostician.INSIGNIFICANT_INDEX)
	}
	
	protected def void validationError(String msg, EObject obj, EStructuralFeature feature, int idx) {
		validator.error(msg, obj, feature, idx)
	}
}