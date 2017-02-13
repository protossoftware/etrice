/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm

import com.google.inject.Inject
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal
import org.eclipse.etrice.core.fsm.fSM.ModelComponent
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition
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
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.RefinedState
import org.eclipse.etrice.core.fsm.fSM.SimpleState
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import com.google.inject.Injector
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition

class FsmGenBuilder {
	
	@Inject extension FSMHelpers fsmHelpers
	val factory = FsmGenFactory.eINSTANCE
	
	new(Injector injector) {
		injector.injectMembers(this)
	}
	
	def GraphContainer createTransformedModel(ModelComponent mc) {
		mc.createContainer
	}
	
	private def GraphContainer create factory.createGraphContainer createContainer(ModelComponent mc) {
		it.component = mc
		it.graph = createStateMachine(mc)
	}
	
	private def Graph createStateMachine(ModelComponent mc) {
		// neither we nor all of our base classes need to have a state machine.
		// So we ask for the super state machine rather than for the base class'
		// state machine
		val superFSM = mc.superStateMachine
		
		if (superFSM!=null) {
			// if we have a super state machine we first recurse down
			val baseGraph = createStateMachine(superFSM.modelComponent)
			
			// and then merge with our (actual) state machine
			mergeGraph(baseGraph, mc.actualStateMachine)
		}
		else {
			// first state machine in the hierarchy: create it
			mc.actualStateMachine.createGraph
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
	
	private def create factory.createGraph createGraph(StateGraph sg) {
		it.stateGraph = sg
		createContents(sg)
	}
	
	private def createContents(Graph graph, StateGraph sg) {
		graph.nodes.addAll(sg.chPoints.map[createNode])
		graph.nodes.addAll(sg.trPoints.map[createNode])
		graph.nodes.addAll(sg.states.filter(typeof(SimpleState)).map[createNode])
		graph.links.addAll(sg.transitions.map[createLink])
		
		// refined states and transitions
		sg.states.filter(typeof(RefinedState)).forEach[handleRefinedState]
		sg.refinedTransitions.forEach[handleRefinedTransition]
	}
	
	private def handleRefinedState(RefinedState s) {
		// handle the sub graphs
		if (s.subgraph!=null) {
			if (s.target.subgraph!=null) {
				val targetGraph = s.target.subgraph.createGraph
				targetGraph.mergeGraph(s.subgraph)
			}
			else {
				s.target.createNode.subgraph = s.subgraph.createGraph
			}
		}
		// else nothing to do, whether the targetGraph exist or not
		
		// change the target Node's stateGraphNode to our RefinedState
		val target = s.target.createNode
		target.stateGraphNode = s
	}
	
	private def handleRefinedTransition(RefinedTransition t) {
		// change the target link's transition to the refined transition
		t.target.createLink.transition = t
	}
	
	private def create factory.createLink createLink(Transition tr) {
		it.transition = tr
		
		it.source = if (tr instanceof NonInitialTransition)  {
			tr.from.createNode
		}
		else {
			null
		}
		it.target = tr.to.createNode
	}
	
	private def dispatch create factory.createNode createNode(StateGraphNode s) {
		it.stateGraphNode = s

		it.subgraph = 
			if (s instanceof State && (s as State).subgraph!=null) {
				(s as State).subgraph.createGraph
			}
			else null
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