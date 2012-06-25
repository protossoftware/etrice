/*******************************************************************************
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Rohit Agrawal (initial contribution)
 * 
 * 
 *******************************************************************************/


package org.eclipse.etrice.abstractexec.behavior;

import java.util.*;


import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.*;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.generator.base.DefaultTranslationProvider;
import org.eclipse.etrice.generator.base.DetailCodeTranslator;


public class ReachabilityCheck {
Queue<StateGraphNode> queue;
public Set<StateGraphItem> visited;
private ExpandedActorClass xpAct;
private Set<StateGraphItem> exitUsed;
public ReachabilityCheck (ExpandedActorClass xpac) {
	queue= new LinkedList<StateGraphNode>();
	xpAct = xpac;
	visited = new HashSet<StateGraphItem>();
	exitUsed = new HashSet<StateGraphItem>();
}
public void computeReachability() {
	StateGraph graph = xpAct.getStateMachine();
	addStartingPoints(graph, true);
	doTraversal();
}

private void addStartingPoints(StateGraph graph, boolean add_initial) 
{
	
	EList<Transition> transitions = graph.getTransitions();
	EList<TrPoint> trPoint = graph.getTrPoints();
	if(add_initial)
	for(Transition trans  : transitions)
		if(trans instanceof InitialTransition) 
		{ 
			visited.add(trans);
			StateGraphNode cur = xpAct.getNode(trans.getTo());
			if(!visited.contains(cur)) queue.add(cur); 
			break;
		}
	for(TrPoint tp : trPoint)
	{
		if(tp instanceof TransitionPoint && !visited.contains(tp) ) {
			queue.add(tp);
		}
	}
	
	//add transition points
}
private void doTraversal() {
	while(!queue.isEmpty())
	{
		StateGraphNode node = queue.poll();
		Visit(node);
		//System.out.println("Visited node : " + node.getName());
	}
}
public boolean isExitUsed(StateGraphItem item)
{
	return exitUsed.contains(item);
}
public boolean isReachable(StateGraphItem item)
{
	
	return visited.contains(item);
}
private void Visit(StateGraphNode node)
{
	visited.add(node);
	if(node instanceof State)
	{
		State st = (State) node;
		if(RoomHelpers.hasDirectSubStructure(st))
		{
			addStartingPoints(st.getSubgraph(),true);
		}
		else
		{
			for(ActiveTrigger trigger : xpAct.getActiveTriggers(st))
			{
				for(Transition trans : trigger.getTransitions())
				{
					visited.add(trans);
					StateGraphNode target = xpAct.getNode(trans.getTo());
					if(!visited.contains(target)) {
						queue.add(target);
						StateGraph triggerContext = (StateGraph) trans.eContainer();
						State exitCalled = st;
						while(true)
						{
							exitUsed.add(exitCalled);
							if(exitCalled.eContainer()==triggerContext) break;
							exitCalled = (State) exitCalled.eContainer().eContainer();
						}
					}
				}
			}
		}
	}
	else {
		if(node instanceof EntryPoint)
		{
			State container = (State) node.eContainer().eContainer();
			visited.add(container);
		}
		for(Transition trans : xpAct.getOutgoingTransitions(node))
		{
			visited.add(trans);
			StateGraphNode target = xpAct.getNode(trans.getTo());
			if(!visited.contains(target))
			{
				queue.add(target);
				
			}
		}
	}
	
}


}

