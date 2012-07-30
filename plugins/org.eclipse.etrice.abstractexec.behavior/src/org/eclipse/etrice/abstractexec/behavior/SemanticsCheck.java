/*******************************************************************************
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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class SemanticsCheck {
	private Queue<StateGraphNode> queue;
	private Set<StateGraphNode> visited;
	private ExpandedActorClass xpAct;
	private HashMap<StateGraphItem, ActiveRules> mapToRules = new HashMap<StateGraphItem, ActiveRules>(); 
	private ActionCodeAnalyzer codeAnalyzer;
	public SemanticsCheck (ExpandedActorClass xpac) {
		queue= new LinkedList<StateGraphNode>();
		xpAct = xpac;
		visited = new HashSet<StateGraphNode>();
		codeAnalyzer = new ActionCodeAnalyzer(xpac.getActorClass());
	}

	public void checkSemantics()
	{
		StateGraph graph  = xpAct.getStateMachine();
		ActiveRules localRules = new ActiveRules();
		localRules.buildInitLocalRules(xpAct);
		addStartingPoints(graph, localRules);
		doTraversal();
	}
	
	private void addStartingPoints(StateGraph graph,  ActiveRules localRules)
	{
		EList<Transition> transitions = graph.getTransitions();
		for(Transition trans  : transitions)
			if(trans instanceof InitialTransition) 
			{ 
				StateGraphNode cur = xpAct.getNode(trans.getTo());
				List<MessageFromIf> msgList = codeAnalyzer.analyze(trans.getAction());
				if(cur instanceof State)
				{
					msgList.addAll(codeAnalyzer.analyze(((State) cur).getEntryCode()));
				}
				 localRules.consumeMessages(msgList);
				boolean rulesChanged = false;
				 if(mapToRules.containsKey(cur))
		     		{
					 rulesChanged =	mapToRules.get(cur).merge(localRules);
		     		}
				 else {
						mapToRules.put(cur,localRules);
						rulesChanged = true;
					}
				if(!visited.contains(cur) || rulesChanged) queue.add(cur);
				
				break;
			}
		}
	private void doTraversal()
	{
		while(!queue.isEmpty())
		{
			Visit(queue.poll());
		}
	}
	private void Visit(StateGraphNode node)
	{
		visited.add(node);
		if(node instanceof State)
		{
			State st = (State) node;
			if(RoomHelpers.hasDirectSubStructure(st))
			{
				addStartingPoints(st.getSubgraph(), mapToRules.get(st));
			}
			else
			{
				for(ActiveTrigger trigger : xpAct.getActiveTriggers(st))
				{
					MessageFromIf mifTrig = RoomFactory.eINSTANCE.createMessageFromIf();
					mifTrig.setFrom(trigger.getIfitem());
					mifTrig.setMessage(trigger.getMsg());
					for(Transition trans : trigger.getTransitions())
					{
						StateGraphNode target = xpAct.getNode(trans.getTo());
						List<MessageFromIf> msgList = new LinkedList<MessageFromIf>();
						//create a list of codes here in the order
						// trigger,  exit, action,  entry
						msgList.add(mifTrig);
						StateGraph triggerContext = (StateGraph) trans.eContainer();
						State exitCalled = st;
						while(true)
						{
							//this is where all the exit code is added
							msgList.addAll(codeAnalyzer.analyze(exitCalled.getExitCode()));
							if(exitCalled.eContainer()==triggerContext) break;
							exitCalled = (State) exitCalled.eContainer().eContainer();
						}
						msgList.addAll(codeAnalyzer.analyze(trans.getAction()));
						if(target instanceof State)
						{
							msgList.addAll(codeAnalyzer.analyze(((State) target).getEntryCode()));
						}
						ActiveRules tempRule = mapToRules.get(node).createCopy();
						tempRule.consumeMessages(msgList);
						addAndMergeRules( target,  tempRule);
					}
				}
			}
		}
		else {
			/* If the current node is an Entry/Exit/Transition/Choice pt , 
			 * then only the action code in the outgoing transition needs to be considered 
			 * For this, a copy of the ActiveRules of the current node is created
			 * and is checked against each outgoing transition for Rule changes
			 * If there is any rule change or if the destination state hasn't been visited
			 * then the destination rules are merged with the current rules and destination 
			 * node is added to the current queue.
			 */			
			for(Transition trans : xpAct.getOutgoingTransitions(node))
			{
				ActiveRules tempRule = mapToRules.get(node).createCopy();
				List<MessageFromIf> msgList = codeAnalyzer.analyze(trans.getAction());
				StateGraphNode target = xpAct.getNode(trans.getTo());
				if(target instanceof State)
					{
						msgList.addAll(codeAnalyzer.analyze(((State) target).getEntryCode()));
					}
				tempRule.consumeMessages(msgList);
				addAndMergeRules(target,  tempRule);
			}
		}
	}
	private void addAndMergeRules(StateGraphNode target, ActiveRules tempRule)
	{
		boolean rulesChanged = false;
		if(mapToRules.containsKey(target))
		{
			rulesChanged = mapToRules.get(target).merge(tempRule);
		}
		else {
			mapToRules.put(target,tempRule);
			rulesChanged = true;
			}
		if(!visited.contains(target) || rulesChanged) {
			queue.add(target);
			}
		
	}
	public void printRules()
	{
		System.out.println("Rules So Far : ");
		System.out.println("MapToRules size : " + this.mapToRules.size());
		for(StateGraphItem item : this.mapToRules.keySet())
		{
		   System.out.println("Rules for : " + item.getName() + " : " );
		   mapToRules.get(item).print();
		}
	}
	public ActiveRules getActiveRules(StateGraphItem item)
	{
		if(mapToRules.containsKey(item))
			return mapToRules.get(item);
		else
			return null;
	}
	
}
