/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm

import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
import org.eclipse.etrice.core.fsm.fSM.RefinedState
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition
import org.eclipse.etrice.core.fsm.fSM.SimpleState
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.StateGraph
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode
import org.eclipse.etrice.core.fsm.fSM.StateTerminal
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.util.FSMHelpers
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.getAllStateNodes;
import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.getLeafStatesLast;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider

class BasicFsmGenBuilder {
	
	protected extension FSMHelpers fsmHelpers
	protected FSMNameProvider fsmNameProvider = new FSMNameProvider();
	
	protected val factory = FsmGenFactory.eINSTANCE
	var int inheritanceLevel = 0
	
	new(FSMHelpers fsmHelpers) {
		this.fsmHelpers = fsmHelpers
	}
	
	def GraphContainer createTransformedModel(ModelComponent mc) {
		mc.createContainer
	}
	
	private def GraphContainer create factory.createGraphContainer createContainer(ModelComponent mc) {
		it.component = mc
		it.graph = createStateMachine(mc)
		
		// ensure consistent state ordering in genmodel and generation
		if(it.graph !== null) {
			it.orderedStates += it.graph.allStateNodes.map[stateGraphNode].filter(State).toList.getLeafStatesLast
			it.orderedStateNames += it.orderedStates.map[fsmNameProvider.getFullPath(it)]
		}
	}
	
	private def Graph createStateMachine(ModelComponent mc) {
		// neither we nor all of our base classes need to have a state machine.
		// So we ask for the super state machine rather than for the base class'
		// state machine
		val superFSM = mc.superStateMachine
		
		if (superFSM!==null) {
			// if we have a super state machine we first recurse down
			val baseGraph = createStateMachine(superFSM.modelComponent)
			
			// when we ascend from the recursion we increment the inheritanceLevel
			inheritanceLevel++
			
			// and then merge with our (actual) state machine
			mergeGraph(baseGraph, mc.actualStateMachine)
		}
		else if (mc.actualStateMachine!==null) {
			// first state machine in the hierarchy: create it
			mc.actualStateMachine?.createGraph
		}
	}
	
	private def Graph mergeGraph(Graph graph, StateGraph sg) {
		// mark existing items as inherited
		graph.nodes.forEach[inherited = true]
		graph.links.forEach[inherited = true]
		
		// add items to already existing graph
		graph.createContents(sg)
		
		// point to the current state graph
		graph.stateGraph = sg
		
		return graph
	}
	
	private def Graph create factory.createGraph createGraph(StateGraph sg) {
		it.stateGraph = sg
		createContents(sg)
	}
	
	private def createContents(Graph graph, StateGraph sg) {
		graph.nodes.addAll(sg.chPoints.map[createNode])
		graph.nodes.addAll(sg.trPoints.map[createNode])
		graph.nodes.addAll(sg.states.filter(typeof(SimpleState)).map[createNode])
		graph.links.addAll(sg.transitions.map[createLink])
		
		// refined states and refined transitions
		sg.states.filter(typeof(RefinedState)).forEach[handleRefinedState]
		sg.refinedTransitions.forEach[handleRefinedTransition]
	}
	
	private def handleRefinedState(RefinedState s) {
		// we pick the node that initially was created from a SimpleState
		val refinedNode = s.finalTarget.createNode
		
		// handle the sub graphs
		if (s.subgraph!==null) {
			if (refinedNode.subgraph!==null) {
				refinedNode.subgraph.mergeGraph(s.subgraph)
			}
			else {
				refinedNode.subgraph = s.subgraph.createGraph
			}
		}
		// else nothing to do, whether the targetGraph exists or not
		
		// change the target Node's stateGraphNode to our RefinedState
		val target = refinedNode
		target.stateGraphNode = s
	}
	
	private def handleRefinedTransition(RefinedTransition t) {
		// change the target link's transition to the refined transition
		t.target.createLink.transition = t
	}
	
	private def Link create factory.createLink createLink(Transition tr) {
		it.transition = tr
		it.source = if (tr instanceof NonInitialTransition) tr.from.createNode
		it.target = tr.to.createNode
	}
	
	private def dispatch create factory.createNode createNode(StateGraphNode s) {
		it.stateGraphNode = s
		it.inheritanceLevel = inheritanceLevel
		it.subgraph = if(s instanceof State) s.subgraph?.createGraph
	}
	
	private def dispatch Node createNode(ChoicepointTerminal tt) {
		tt.cp.createNode
	}
	
	private def dispatch Node createNode(TrPointTerminal tt) {
		tt.trPoint.createNode
	}
	
	private def dispatch Node createNode(StateTerminal tt) {
		tt.state.createNode
	}
	
	private def dispatch Node createNode(SubStateTrPointTerminal tt) {
		tt.trPoint.createNode
	}
}