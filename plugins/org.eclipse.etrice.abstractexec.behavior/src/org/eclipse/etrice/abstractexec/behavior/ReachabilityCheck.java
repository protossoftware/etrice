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
import org.eclipse.etrice.abstractexec.behavior.util.AbstractExecutionUtil;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.generator.fsm.generic.FSMExtensions;

public class ReachabilityCheck {
	
	private static FSMExtensions fsmExt;
	
	Queue<StateGraphNode> queue;
	public Set<StateGraphItem> visited;
	private Set<State> visitedSubStates;
	private ExpandedModelComponent xpAct;
	//private Set<StateGraphItem> exitUsed;

	public ReachabilityCheck(ExpandedModelComponent xpac) {
		fsmExt = new FSMExtensions();
		queue = new LinkedList<StateGraphNode>();
		xpAct = xpac;
		visited = new HashSet<StateGraphItem>();
		visitedSubStates = new HashSet<State>();
		//exitUsed = new HashSet<StateGraphItem>();
	}

	public void computeReachability() {
		StateGraph graph = xpAct.getStateMachine();
		addStartingPoints(graph, true);
		doTraversal();
		visited.addAll(visitedSubStates);
	}

	private void addStartingPoints(StateGraph graph, boolean add_initial) {
		EList<Transition> transitions = graph.getTransitions();
		EList<TrPoint> trPoint = graph.getTrPoints();
		if (add_initial)
			for (Transition trans : transitions)
				if (trans instanceof InitialTransition) {
					visited.add(trans);
					StateGraphNode cur = AbstractExecutionUtil.getInstance().getRoomHelpers().getNode(trans.getTo());
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
			if (AbstractExecutionUtil.getInstance().getRoomHelpers().hasDirectSubStructure(st)) {
				addStartingPoints(st.getSubgraph(), true);
			} else {
				// visit outgoing triggered transitions
				for (ActiveTrigger trigger : xpAct.getActiveTriggers(st)) {
					for (TriggeredTransition trans : trigger.getTransitions())
						visit(trans);
				}
				// visit outgoing guarded transitions
				for(Transition trans : fsmExt.getOutgoingTransitionsHierarchical(xpAct, st)){
					if(trans instanceof GuardedTransition)
						visit(trans);
				}
			}
		} else {
			if (node instanceof EntryPoint) {
				// don't set container visited. otherwise its initial transition could not be visited any more
				State container = (State) node.eContainer().eContainer();
				visitedSubStates.add(container);
			}
			for (Transition trans : xpAct.getOutgoingTransitions(node))
				visit(trans);
		}

	}
	
	private void visit(Transition trans){
		visited.add(trans);
		StateGraphNode target = AbstractExecutionUtil.getInstance().getRoomHelpers().getNode(trans.getTo());
		if (!visited.contains(target))
			queue.add(target);
	}

}
