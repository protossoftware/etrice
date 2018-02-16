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

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.CommonTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Graph;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphItem;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node;

public class SemanticsCheck {
	private GraphContainer gc;
	private Queue<Node> queue = new LinkedList<Node>();
	private Set<Node> visited = new HashSet<Node>();;
	private HashMap<GraphItem, ActiveRules> mapToRules = new HashMap<GraphItem, ActiveRules>();
	private ActionCodeAnalyzer codeAnalyzer;
	private HashMap<GraphItem, List<HandledMessage>> mapToWarnings = new HashMap<GraphItem, List<HandledMessage>>();
	private FSMNameProvider fsmNameProvider = new FSMNameProvider();
	
	private static boolean traceChecks = false;
	private static int traceLevel = 0;
	static {
		if (Activator.getDefault().isDebugging()) {
			String value = Platform.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/checks");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceChecks = true;
			}
			value = Platform.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/checks/level");
			if (value != null) {
				traceLevel = Integer.parseInt(value);
			}
		}
	}

	private static final int TRACE_RESULT = 1;
	private static final int TRACE_DETAILS = 2;
	
	public SemanticsCheck(GraphContainer gc) {
		this.gc = gc;
		this.codeAnalyzer = new ActionCodeAnalyzer(gc.getComponent());
	}

	public void checkSemantics() {
		if (traceChecks) {
			System.out.println("checkSemantics: check of ActorClass "+gc.getComponent().getComponentName());
		}
		
		ActiveRules localRules = new ActiveRules();
		localRules.buildInitLocalRules(gc.getComponent());
		addStartingPoints(gc.getGraph(), localRules);
		doTraversal();
		
		if (traceChecks) {
			if (traceLevel>=TRACE_RESULT) {
				printRules();
			}
			
			System.out.println("checkSemantics: done with check of ActorClass "+gc.getComponent().getComponentName());
		}
	}

	private void addStartingPoints(Graph graph, ActiveRules localRules) {
		List<Link> links = graph.getLinks();
		for (Link link : links)
			if (link.getTransition() instanceof InitialTransition) {
				Node cur = link.getTarget();
				List<HandledMessage> msgList = codeAnalyzer.analyze(link.getTransition().getAction());
				if (cur.getStateGraphNode() instanceof State) {
					msgList.addAll(codeAnalyzer.analyze(((State) cur.getStateGraphNode()).getEntryCode()));
				}
				List<HandledMessage> wrongMsgList = localRules.consumeMessages(msgList);
				if (!wrongMsgList.isEmpty()) {
					addToWarning(link, wrongMsgList);
				}
				boolean rulesChanged = false;
				if (mapToRules.containsKey(cur)) {
					rulesChanged = mapToRules.get(cur).merge(localRules);
				} else {
					mapToRules.put(link.getTarget(), localRules);
					rulesChanged = true;
				}
				if (!visited.contains(link.getTarget()) || rulesChanged)
					queue.add(link.getTarget());

				break;
			}
	}

	private void doTraversal() {
		while (!queue.isEmpty()) {
			visit(queue.poll());
		}
	}

	private void visit(Node node) {
		visited.add(node);
		if (node.getStateGraphNode() instanceof State) {
			State st = (State) node.getStateGraphNode();
			if (node.getSubgraph()!=null) {
				addStartingPoints(node.getSubgraph(), mapToRules.get(node));
			}
			else {
				for (CommonTrigger trigger : node.getCaughtTriggers()) {
					if (traceChecks && traceLevel>=TRACE_DETAILS) {
						System.out.println("  Currently visiting: " + st.getName());
						System.out.println("  Trigger: " + fsmNameProvider.getMessageName(trigger.getMsg()));
					}
					
					for (Link link : trigger.getLinks()) {
						Node target = link.getTarget();
						List<HandledMessage> msgList = new LinkedList<HandledMessage>();
						// create a list of codes here in the order
						// trigger, exit, action, entry
						msgList.add(new HandledMessage(trigger.getIfitem(), trigger.getMsg(), trigger));
						StateGraph triggerContext = link.getGraph().getStateGraph();
						State exitCalled = st;
						while (true) {
							// this is where all the exit code is added
							msgList.addAll(codeAnalyzer.analyze(exitCalled.getExitCode()));
							if (exitCalled.eContainer() == triggerContext)
								break;
							exitCalled = (State) exitCalled.eContainer().eContainer();
						}
						msgList.addAll(codeAnalyzer.analyze(link.getTransition().getAction()));
						if (target.getStateGraphNode() instanceof State) {
							msgList.addAll(codeAnalyzer.analyze(((State) target.getStateGraphNode()).getEntryCode()));
						}
						ActiveRules tempRule = mapToRules.get(node).createCopy();
						
						if (traceChecks && traceLevel>=TRACE_DETAILS) {
							System.out.println("  Messages in msglist before consuming: ");
							for (HandledMessage msg : msgList) {
								System.out.println("  Msg: "+ fsmNameProvider.getMessageName(msg.getMsg()));
							}
						}
						if (traceChecks && traceLevel>=TRACE_DETAILS) {
							System.out.println("  rules before consuming message list : ");
							printRules();
						}
						List<HandledMessage> wrongMsgList = tempRule.consumeMessages(msgList);
						if (!wrongMsgList.isEmpty()) {
							addToWarning(link, wrongMsgList);
						}
															
						if (traceChecks && traceLevel>=TRACE_DETAILS) {
							System.out.println("  Messages consumed");
						}
						
						addAndMergeRules(target, tempRule);
						
						if (traceChecks && traceLevel>=TRACE_DETAILS) {
							System.out.println("  rules after consuming and merging message list : ");
							printRules();
						}

					}
				}
			}
		} else {
			/*
			 * If the current node is an Entry/Exit/Transition/Choice pt , then
			 * only the action code in the outgoing transition needs to be
			 * considered. For this, a copy of the ActiveRules of the current
			 * node is created and is checked against each outgoing transition
			 * for Rule changes. If there is any rule change or if the
			 * destination state hasn't been visited then the destination rules
			 * are merged with the current rules and destination node is added
			 * to the current queue.
			 */
			for (Link link : node.getOutgoing()) {
				ActiveRules tempRule = mapToRules.get(node).createCopy();
				List<HandledMessage> msgList = codeAnalyzer.analyze(link.getTransition().getAction());
				Node target = link.getTarget();
				if (target.getStateGraphNode() instanceof State) {
					msgList.addAll(codeAnalyzer.analyze(((State) target.getStateGraphNode()).getEntryCode()));
				}
				List<HandledMessage> wrongMsgList = tempRule.consumeMessages(msgList);
				if (!wrongMsgList.isEmpty()) {
					addToWarning(link, wrongMsgList);
				}
				addAndMergeRules(target, tempRule);
			}
		}
	}

	private void addToWarning(GraphItem item,
			List<HandledMessage> wrongMsgList) {
		if (mapToWarnings.containsKey(item)) {
			mapToWarnings.get(item).addAll(wrongMsgList);
		} else {
			mapToWarnings.put(item, wrongMsgList);
		}
	}
	private void addAndMergeRules(Node target, ActiveRules tempRule) {
		boolean rulesChanged = false;
		if (mapToRules.containsKey(target)) {
			rulesChanged = mapToRules.get(target).merge(tempRule);
		} else {
			mapToRules.put(target, tempRule);
			rulesChanged = true;
		}
		if (!visited.contains(target) || rulesChanged) {
			queue.add(target);
		}

	}

	public void printRules() {
		System.out.println("  Current Rules: ");
		System.out.println("    MapToRules size: " + this.mapToRules.size());
		for (GraphItem item : this.mapToRules.keySet()) {
			
			System.out.println("    Rules for " + FsmGenExtensions.getName(item) + " : ");
			mapToRules.get(item).print();
		}
	}

	public ActiveRules getActiveRules(GraphItem item) {
		return mapToRules.get(item);
	}
	
	public List<HandledMessage> getWarningMsg (GraphItem item) {
		return mapToWarnings.get(item);
	}
}
