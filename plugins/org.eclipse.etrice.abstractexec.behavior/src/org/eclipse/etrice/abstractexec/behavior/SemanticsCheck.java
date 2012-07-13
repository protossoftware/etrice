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

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class SemanticsCheck {
	Queue<StateGraphNode> queue;
	public Set<StateGraphItem> visited;
	private ExpandedActorClass xpAct;
	private Set<StateGraphItem> exitUsed;
	private HashMap<StateGraphItem, ActiveRules> mapToRules = new HashMap<StateGraphItem, ActiveRules>(); 
	private ActionCodeAnalyzer codeAnalyzer;
	private ActiveRules localRules;
	public SemanticsCheck (ExpandedActorClass xpac) {
		queue= new LinkedList<StateGraphNode>();
		xpAct = xpac;
		visited = new HashSet<StateGraphItem>();
		exitUsed = new HashSet<StateGraphItem>();
		codeAnalyzer = new ActionCodeAnalyzer(xpac.getActorClass());
		
	}

	public void checkSemantics()
	{
		System.out.println("Checking semantics");
		StateGraph graph  = xpAct.getStateMachine();
		buildLocalRules();
		addStartingPoints(graph, true, localRules);
		doTraversal();
	}
	private void buildLocalRules()
	{
		System.out.println("Buidling Local Rules");
		HashMap<InterfaceItem, EList<SemanticsRule>> locals = new HashMap<InterfaceItem, EList<SemanticsRule>>();
		List<InterfaceItem> portList = RoomHelpers.getAllInterfaceItems(xpAct.getActorClass());
		for(InterfaceItem port : portList)
		{
			GeneralProtocolClass gpc = port.getGeneralProtocol();
			locals.put(port, ((ProtocolClass) gpc).getSemantics().getRules());
		}
		localRules = new ActiveRules(locals);
		System.out.println("Exiting building local rules");
	}
	private void addStartingPoints(StateGraph graph, boolean add_initial, ActiveRules localRules)
	{
		System.out.println("Adding starting points");
		EList<Transition> transitions = graph.getTransitions();
		EList<TrPoint> trPoint = graph.getTrPoints();
		if(add_initial)
		for(Transition trans  : transitions)
			if(trans instanceof InitialTransition) 
			{ 
				visited.add(trans);
				StateGraphNode cur = xpAct.getNode(trans.getTo());
				List<MessageFromIf> msgList = codeAnalyzer.analyze(trans.getAction());
				if(cur instanceof State)
				{
					msgList.addAll(codeAnalyzer.analyze(((State) cur).getEntryCode()));
				}
				
				System.out.println("Analyzing code in init : " + trans.getName());
				boolean rulesChanged = localRules.checkRules(msgList);
				System.out.println("Rules changed for init : " + rulesChanged);
				
				if(!visited.contains(cur) || rulesChanged) queue.add(cur);
				if(mapToRules.containsKey(cur))
	
				{
					System.out.println("Added "+ cur.getName() + " in if of mapToRules");
					mapToRules.get(cur).merge(localRules);
				}
				else {
				//	System.out.println("Added "+ cur.getName() + " in else  of mapToRules and localRules added are as follows");
				//	localRules.print();
					mapToRules.put(cur,localRules);
					}
				break;
			}
		//add transition points
		for(TrPoint tp : trPoint)
		{
			// CANT DETERMINE HOW TO MERGE RULES HERE
			if(tp instanceof TransitionPoint && !visited.contains(tp) ) {
				queue.add(tp);
				mapToRules.put(tp, new ActiveRules());
			}
		}
		
		System.out.println("Exiting Adding starting points");
	}
	private void doTraversal()
	{
		System.out.println("adding traversal");
		while(!queue.isEmpty())
		{
			System.out.println("Visiting : " + queue.peek().getName());
			//this.printRules();
			Visit(queue.poll());
			
		}
		System.out.println("Exiting traversal");
	}
	private void Visit(StateGraphNode node)
	{
		visited.add(node);
		if(node instanceof State)
		{
			//List<MessageFromIf> completeList = new LinkedList<MessageFromIf>();
			State st = (State) node;
			//mapToRules.get(st).checkRules(codeAnalyzer.analyze(st.getEntryCode()));
			if(RoomHelpers.hasDirectSubStructure(st))
			{
				addStartingPoints(st.getSubgraph(),true, mapToRules.get(st));
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
						visited.add(trans);
						StateGraphNode target = xpAct.getNode(trans.getTo());
						List<MessageFromIf> msgList = new LinkedList<MessageFromIf>();
						//create a list of codes here in the order
						// trigger, action , exit
						//entry code has already been added and merged
						msgList.add(mifTrig);
						StateGraph triggerContext = (StateGraph) trans.eContainer();
						State exitCalled = st;
						while(true)
						{
							//this is where all the exit code is added
							msgList.addAll(codeAnalyzer.analyze(exitCalled.getExitCode()));
							exitUsed.add(exitCalled);
							if(exitCalled.eContainer()==triggerContext) break;
							exitCalled = (State) exitCalled.eContainer().eContainer();
						}
						msgList.addAll(codeAnalyzer.analyze(trans.getAction()));
						if(target instanceof State)
						{
							msgList.addAll(codeAnalyzer.analyze(((State) target).getEntryCode()));
						}
						ActiveRules tempRule = mapToRules.get(node).createCopy();
					//System.out.println("Cur rules before temp checking : ");
					//	mapToRules.get(node).print();
						ActiveRules orig = mapToRules.get(node);
						boolean rulesChanged = tempRule.checkRules(msgList);
					//	System.out.println("Copy rules after checking : ");
					//	tempRule.print();
					//	System.out.println("Orig rules after temp checking : ");
					//	mapToRules.get(node).print();
						addAndMergeRules( target,  rulesChanged, tempRule);
					}
				}
			}
		}
		else {
			/* If the current node is an Entry/Exit/Transition pt , 
			 * then only the action code in the outgoing transition needs to be considered 
			 * For this, a copy of the ActiveRules of the current node is created
			 * and is checked against each outgoing transition for Rule changes
			 * If there is any rule change or if the destination state hasn't been visited
			 * then the destination rules are merged with the current rules and destination 
			 * node is added to the current queue.
			 */			
			if(node instanceof EntryPoint){
			State container = (State) node.eContainer().eContainer();
			visited.add(container);
			} 
			for(Transition trans : xpAct.getOutgoingTransitions(node))
			{
			ActiveRules tempRule = mapToRules.get(node).createCopy();
			List<MessageFromIf> msgList = codeAnalyzer.analyze(trans.getAction());
			StateGraphNode target = xpAct.getNode(trans.getTo());
			if(target instanceof State)
			{
				msgList.addAll(codeAnalyzer.analyze(((State) target).getEntryCode()));
			}
			boolean rulesChanged = tempRule.checkRules(msgList);
			visited.add(trans);
			
			addAndMergeRules(target, rulesChanged, tempRule);
			
			}
		}
	}
	private void addAndMergeRules(StateGraphNode target,  boolean rulesChanged, ActiveRules tempRule)
	{
		//System.out.println("Before merging : ");
		//mapToRules.get(source).print();
		if(!visited.contains(target) || rulesChanged) {
			queue.add(target);
			if(mapToRules.containsKey(target))
			{
				mapToRules.get(target).merge(tempRule);
			}
			else {
				mapToRules.put(target,tempRule);
			//	System.out.println("adding in merge condition : ");
			//  tempRule.print();
			}
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
}
