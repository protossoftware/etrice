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

import java.util.List
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.fsm.fSM.EntryPoint
import org.eclipse.etrice.core.fsm.fSM.ExitPoint
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition
import org.eclipse.etrice.core.fsm.fSM.InitialTransition
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TrPoint
import org.eclipse.etrice.core.fsm.fSM.TransitionBase
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node

class FsmGenExtensions {
	
	static def dispatch getName(Node nd) {
		nd.stateGraphNode.name
	}
	
	static def dispatch getName(Link l) {
		l.transition.name
	}
	
	static def getStateNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof State]
	}
	
	static def getAllNodes(Graph g) {
		g.eAllContents.filter(typeof(Node))
	}
	
	static def getAllStateNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof State]
	}
	
	static def getChoicePointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof ChoicePoint]
	}
	
	static def getAllChoicePointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof ChoicePoint]
	}
	
	static def getTrPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof TrPoint]
	}
	
	static def getAllTrPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof TrPoint]
	}
	
	static def getTransitionPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof TransitionPoint]
	}
	
	static def getAllTransitionPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof TransitionPoint]
	}
	
	static def getEntryPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof EntryPoint]
	}
	
	static def getAllEntryPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof EntryPoint]
	}
	
	static def getExitPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof ExitPoint]
	}
	
	static def getAllExitPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof ExitPoint]
	}
	
	static def getStates(Graph g) {
		g.stateNodes.map[stateGraphNode].filter(typeof(State))
	}
	
	static def getAllStates(Graph g) {
		g.allStateNodes.map[stateGraphNode].filter(typeof(State))
	}
	
	static def getChoicePoints(Graph g) {
		g.choicePointNodes.map[stateGraphNode].filter(typeof(ChoicePoint))
	}
	
	static def getTrPoints(Graph g) {
		g.trPointNodes.map[stateGraphNode].filter(typeof(TrPoint))
	}
	
	static def getInitialTransition(Graph g) {
		g.links.map[transition].filter(typeof(InitialTransition)).head
	}
	
	static def getAllLinks(Graph g) {
		g.eAllContents.filter(typeof(Link))
	}
	
	static def getAllInitialTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof InitialTransition]
	}
	
	static def getAllTriggeredTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof TriggeredTransition]
	}
	
	static def getAllContinuationTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof ContinuationTransition]
	}
	
	static def getAllCPBranchTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof CPBranchTransition]
	}
	
	/**
	 * returns all links whose transitions are chain heads
	 * 
	 * @param g a graph
	 * @return all deeply contained links that are chain heads
	 * 
     * @see #isChainHead(Link))
	 */
	static def getAllChainHeads(Graph g) {
		g.allLinks.filter[isChainHead]
	}
	
	/**
	 * @param l a link
	 * @return {@code true} if the transition associated with this link is a chain head
	 * 
     * @see #isChainHead(TransitionBase))
	 */
	static def isChainHead(Link l) {
		l.transition.isChainHead
	}
	
	/**
	 * the head of a transition chain is an initial, a guarded or a triggered transition
	 * 
	 * @param l a link
	 * @return {@code true} if this transition is of one of the above types
	 */
	static def boolean isChainHead(TransitionBase t) {
		if (t instanceof RefinedTransition) {
			t.target.isChainHead
		}
		else {
			t instanceof InitialTransition ||
			t instanceof GuardedTransition ||
			t instanceof TriggeredTransition
		}
	}
	
	static def getOutgoingTriggeredTransitionLinks(Node s) {
		s.outgoing.filter[transition instanceof TriggeredTransition]
	}
	
	static def getOutgoingTriggeredTransitions(Node s) {
		s.getOutgoingTriggeredTransitionLinks.map[transition].filter(typeof(TriggeredTransition))
	}
	
	static def getOutgoingTransitionsHierarchically(Node s) {
		s.getOutgoingLinksHierarchically.map[transition]
	}
	
	static def getOutgoingLinksHierarchically(Node s) {
		val result = newArrayList
		
		var current = s
		while (current!==null) {
			// outgoing transitions of the state
			result.addAll(s.outgoing)
			
			// outgoing transitions of the transition points of the same level
			result.addAll(s.graph.transitionPointNodes.map[outgoing].flatten)
			
			// ascend to the parent state (iff)
			current = current.getParentState
		}
		
		return result
	}
	
	static def isTopLevel(Graph g) {
		if (g!==null) {
			g.eContainer instanceof GraphContainer
		}
		else true
	}
	
	static def isEmpty(Graph g) {
		g===null || (g.nodes.empty && g.links.empty)
	}
	
	static def isLeaf(Node n) {
		n.subgraph===null
	}
	
	static def isTopLevel(Node n) {
		n.graph.isTopLevel
	}
	
	static def getParentState(Node n) {
		if (n.isTopLevel) {
			null
		}
		else {
			n.graph.eContainer as Node
		}
	}
	
	static def getChoicepointDefaultBranch(Node n) {
		if (!(n.stateGraphNode instanceof ChoicePoint)) {
			return null
		}
		
		return n.outgoing.filter[transition instanceof ContinuationTransition].head
	}
	
	static def getParentState(Link l) {
		if (l.graph.isTopLevel) {
			null
		}
		else {
			l.graph.eContainer as Node
		}
	}
	
	static def isHandler(Link l) {
		val sourceNode = l.source.stateGraphNode
		if (sourceNode instanceof TransitionPoint) {
			sourceNode.isHandler
		}
		else {
			false
		}
	}
	
	static def List<DetailCode> getAllDetailCodes(Graph graph) {
		val detailCodes = <DetailCode>newArrayList
		
		if (graph!==null) {
			val allTransitions = graph.allLinks.map[transition]
			detailCodes += allTransitions.map[action].toList
			
			val allStates = graph.allStateNodes.map[stateGraphNode].filter(typeof(State))
			detailCodes += allStates.map[entryCode].toList
			detailCodes += allStates.map[doCode].toList
			detailCodes += allStates.map[exitCode].toList
		}
		
		return detailCodes
	}
	
	static def getLinkFor(GraphContainer gc, TransitionBase t) {
		gc.graph.allLinks.findFirst[transition===t]
	}
	
	/**
     * @param states a list of {@link State}s
     * @return a list ordered such that leaf states are last
     */
    static def getLeafStatesLast(List<State> states) {
		val leaf = states.filter(s|s.subgraph === null)
		val nonLeaf = states.filter(s|s.subgraph !== null)

		nonLeaf + leaf
	}
}