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
	
	public static def dispatch getName(Node nd) {
		nd.stateGraphNode.name
	}
	
	public static def dispatch getName(Link l) {
		l.transition.name
	}
	
	public static def getStateNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof State]
	}
	
	public static def getAllNodes(Graph g) {
		g.eAllContents.filter(typeof(Node))
	}
	
	public static def getAllStateNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof State]
	}
	
	public static def getChoicePointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof ChoicePoint]
	}
	
	public static def getAllChoicePointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof ChoicePoint]
	}
	
	public static def getTrPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof TrPoint]
	}
	
	public static def getAllTrPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof TrPoint]
	}
	
	public static def getTransitionPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof TransitionPoint]
	}
	
	public static def getAllTransitionPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof TransitionPoint]
	}
	
	public static def getEntryPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof EntryPoint]
	}
	
	public static def getAllEntryPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof EntryPoint]
	}
	
	public static def getExitPointNodes(Graph g) {
		g.nodes.filter[stateGraphNode instanceof ExitPoint]
	}
	
	public static def getAllExitPointNodes(Graph g) {
		g.allNodes.filter[stateGraphNode instanceof ExitPoint]
	}
	
	public static def getStates(Graph g) {
		g.stateNodes.map[stateGraphNode].filter(typeof(State))
	}
	
	public static def getAllStates(Graph g) {
		g.allStateNodes.map[stateGraphNode].filter(typeof(State))
	}
	
	public static def getChoicePoints(Graph g) {
		g.choicePointNodes.map[stateGraphNode].filter(typeof(ChoicePoint))
	}
	
	public static def getTrPoints(Graph g) {
		g.trPointNodes.map[stateGraphNode].filter(typeof(TrPoint))
	}
	
	public static def getInitialTransition(Graph g) {
		g.links.map[transition].filter(typeof(InitialTransition)).head
	}
	
	public static def getAllLinks(Graph g) {
		g.eAllContents.filter(typeof(Link))
	}
	
	public static def getAllInitialTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof InitialTransition]
	}
	
	public static def getAllTriggeredTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof TriggeredTransition]
	}
	
	public static def getAllContinuationTranisitionLinks(Graph g) {
		g.allLinks.filter[transition instanceof ContinuationTransition]
	}
	
	public static def getAllCPBranchTranisitionLinks(Graph g) {
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
	public static def getAllChainHeads(Graph g) {
		g.allLinks.filter[isChainHead]
	}
	
	/**
	 * @param l a link
	 * @return {@code true} if the transition associated with this link is a chain head
	 * 
     * @see #isChainHead(TransitionBase))
	 */
	public static def isChainHead(Link l) {
		l.transition.isChainHead
	}
	
	/**
	 * the head of a transition chain is an initial, a guarded or a triggered transition
	 * 
	 * @param l a link
	 * @return {@code true} if this transition is of one of the above types
	 */
	public static def boolean isChainHead(TransitionBase t) {
		if (t instanceof RefinedTransition) {
			t.target.isChainHead
		}
		else {
			t instanceof InitialTransition ||
			t instanceof GuardedTransition ||
			t instanceof TriggeredTransition
		}
	}
	
	public static def getOutgoingTriggeredTransitionLinks(Node s) {
		s.outgoing.filter[transition instanceof TriggeredTransition]
	}
	
	public static def getOutgoingTriggeredTransitions(Node s) {
		s.getOutgoingTriggeredTransitionLinks.map[transition].filter(typeof(TriggeredTransition))
	}
	
	public static def getOutgoingTransitionsHierarchically(Node s) {
		s.getOutgoingLinksHierarchically.map[transition]
	}
	
	public static def getOutgoingLinksHierarchically(Node s) {
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
	
	public static def isTopLevel(Graph g) {
		if (g!==null) {
			g.eContainer instanceof GraphContainer
		}
		else true
	}
	
	public static def isEmpty(Graph g) {
		g===null || (g.nodes.empty && g.links.empty)
	}
	
	public static def isLeaf(Node n) {
		n.subgraph===null
	}
	
	public static def isTopLevel(Node n) {
		n.graph.isTopLevel
	}
	
	public static def getParentState(Node n) {
		if (n.isTopLevel) {
			null
		}
		else {
			n.graph.eContainer as Node
		}
	}
	
	public static def getChoicepointDefaultBranch(Node n) {
		if (!(n.stateGraphNode instanceof ChoicePoint)) {
			return null
		}
		
		return n.outgoing.filter[transition instanceof ContinuationTransition].head
	}
	
	public static def getParentState(Link l) {
		if (l.graph.isTopLevel) {
			null
		}
		else {
			l.graph.eContainer as Node
		}
	}
	
	public static def isHandler(Link l) {
		val sourceNode = l.source.stateGraphNode
		if (sourceNode instanceof TransitionPoint) {
			sourceNode.isHandler
		}
		else {
			false
		}
	}
	
	public static def List<DetailCode> getAllDetailCodes(Graph graph) {
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
	
	public static def getLinkFor(GraphContainer gc, TransitionBase t) {
		gc.graph.allLinks.findFirst[transition===t]
	}
}