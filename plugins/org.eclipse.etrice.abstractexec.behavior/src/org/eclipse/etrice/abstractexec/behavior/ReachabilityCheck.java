/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.generic.RoomExtensions;

public class ReachabilityCheck {
	
	private static RoomExtensions roomExt;
	
	Queue<StateGraphNode> queue;
	public Set<StateGraphItem> visited;
	private ExpandedActorClass xpAct;
	//private Set<StateGraphItem> exitUsed;

	public ReachabilityCheck(ExpandedActorClass xpac) {
		roomExt = new RoomExtensions();
		queue = new LinkedList<StateGraphNode>();
		xpAct = xpac;
		visited = new HashSet<StateGraphItem>();
		//exitUsed = new HashSet<StateGraphItem>();
	}

	public void computeReachability() {
		StateGraph graph = xpAct.getStateMachine();
		addStartingPoints(graph, true);
		doTraversal();
	}

	private void addStartingPoints(StateGraph graph, boolean add_initial) {
		EList<Transition> transitions = graph.getTransitions();
		EList<TrPoint> trPoint = graph.getTrPoints();
		if (add_initial)
			for (Transition trans : transitions)
				if (trans instanceof InitialTransition) {
					visited.add(trans);
					StateGraphNode cur = RoomHelpers.getNode(trans.getTo());
					if (!visited.contains(cur))
						queue.add(cur);
					break;
				}
		for (TrPoint tp : trPoint) {
			if (tp instanceof TransitionPoint && !visited.contains(tp)) {
				queue.add(tp);
			}
		}
	}

	private void doTraversal() {
		while (!queue.isEmpty()) {
			StateGraphNode node = queue.poll();
			if (!visited.contains(node))
				visit(node);
			// System.out.println("Visited node : " + node.getName());
		}
	}

//	public boolean isExitUsed(StateGraphItem item) {
//		return exitUsed.contains(item);
//	}

	public boolean isReachable(StateGraphItem item) {

		return visited.contains(item);
	}

	private void visit(StateGraphNode node) {
		visited.add(node);
		if (node instanceof State) {
			State st = (State) node;
			if (RoomHelpers.hasDirectSubStructure(st)) {
				addStartingPoints(st.getSubgraph(), true);
			} else {
				// visit outgoing triggered transitions
				for (ActiveTrigger trigger : xpAct.getActiveTriggers(st)) {
					for (TriggeredTransition trans : trigger.getTransitions())
						visit(trans);
				}
				// visit outgoing guarded transitions
				for(Transition trans : roomExt.getOutgoingTransitionsHierarchical(xpAct, st)){
					if(trans instanceof GuardedTransition)
						visit(trans);
				}
			}
		} else {
			if (node instanceof EntryPoint) {
				// if container has no initial transition then mark it visited
				boolean markVisited = true;
				State container = (State) node.eContainer().eContainer();
				StateGraph parentGraph = container.getSubgraph();
				for (Transition tr : parentGraph.getTransitions())
					if (tr instanceof InitialTransition)
						markVisited = false;
				if (markVisited)
					visited.add(container);
			}
			for (Transition trans : xpAct.getOutgoingTransitions(node))
				visit(trans);
		}

	}
	
	private void visit(Transition trans){
		visited.add(trans);
		StateGraphNode target = RoomHelpers.getNode(trans.getTo());
		if (!visited.contains(target))
			queue.add(target);
	}

}
