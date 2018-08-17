/*******************************************************************************
 * Copyright (c) 2012 Rohit Agrawal
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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

import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;

public class ReachabilityCheck {
	
	private GraphContainer gc;
	
	Queue<Node> queue = new LinkedList<Node>();
	public Set<GraphItem> visited = new HashSet<GraphItem>();
	private Set<Node> visitedSubStates = new HashSet<Node>();

	public ReachabilityCheck(GraphContainer gc) {
		this.gc = gc;
	}

	public void computeReachability() {
		addStartingPoints(gc.getGraph(), true);
		doTraversal();
		visited.addAll(visitedSubStates);
	}

	private void addStartingPoints(Graph graph, boolean add_initial) {
		if (add_initial)
			for (Link link : graph.getLinks())
				if (link.getTransition() instanceof InitialTransition) {
					visited.add(link);
					Node cur = link.getTarget();
					if (!visited.contains(cur))
						queue.add(cur);
					break;
				}
	}

	private void doTraversal() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (!visited.contains(node)) {
				visit(node);
			}
		}
	}

	public boolean isReachable(GraphItem item) {
		return visited.contains(item);
	}

	private void visit(Node node) {
		visited.add(node);
		if (node.getStateGraphNode() instanceof State) {
			if (node.getSubgraph()!=null) {
				addStartingPoints(node.getSubgraph(), true);
			} else {
				// visit outgoing triggered transitions
				for (CommonTrigger trigger : node.getCaughtTriggers()) {
					for (Link link : trigger.getLinks())
						visit(link);
				}
				// visit outgoing guarded transitions
				for(Link link : FsmGenExtensions.getOutgoingLinksHierarchically(node)){
					if (link.getTransition() instanceof GuardedTransition)
						visit(link);
				}
			}
		} else {
			if (node.getStateGraphNode() instanceof EntryPoint) {
				// don't set container visited. otherwise its initial transition could not be visited any more
				Node container = FsmGenExtensions.getParentState(node);
				visitedSubStates.add(container);
			}
			for (Link link : node.getOutgoing())
				visit(link);
		}

	}
	
	private void visit(Link link){
		visited.add(link);
		Node target = link.getTarget();
		if (!visited.contains(target))
			queue.add(target);
	}

}
