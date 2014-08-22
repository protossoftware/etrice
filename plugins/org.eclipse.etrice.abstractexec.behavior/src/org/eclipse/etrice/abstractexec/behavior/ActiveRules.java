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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.InSemanticsRule;
import org.eclipse.etrice.core.fsm.fSM.ProtocolSemantics;
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;

public class ActiveRules {
	private HashMap<AbstractInterfaceItem, List<SemanticsRule>> rules;
	private static boolean traceRules = false;
	private static int traceLevel = 0;
	
	// HOWTO: use debug options to configure tracing (see also the .options file in the plug-in)
	static {
		if (Activator.getDefault().isDebugging()) {
			String value = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/rules");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceRules = true;
			}
			value = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/rules/level");
			if (value != null) {
				traceLevel = Integer.parseInt(value);
			}
		}
	}

	// private static final int TRACE_RESULT = 1;
	private static final int TRACE_DETAILS = 2;

	public ActiveRules() {
		rules = new HashMap<AbstractInterfaceItem, List<SemanticsRule>>();
	}

	private ActiveRules(HashMap<AbstractInterfaceItem, List<SemanticsRule>> r) {
		rules = r;
	}

	public Set<AbstractInterfaceItem> getPortList() {
		return rules.keySet();
	}

	public List<SemanticsRule> getRulesForPort(AbstractInterfaceItem port) {
		return rules.get(port);
	}

	// checks for currently active rules against a message list and modifies the
	// rules which can be merged with the destination node
	public List<HandledMessage> consumeMessages(List<HandledMessage> msgList) {
		List<HandledMessage> wrongMsgList = new ArrayList<HandledMessage>();
		for (HandledMessage msg : msgList) {
			List<SemanticsRule> localRules = rules.get(msg.getIfitem());
			if (localRules != null) {
				SemanticsRule match = null;
				for (SemanticsRule rule : localRules) {
					if (rule.getMsg() == msg.getMsg()) {
						match = rule;
						break;
					}
				}

				if (match != null) {
					if (traceRules && traceLevel >= TRACE_DETAILS)
						System.out.println("  found match for "
								+ msg.getMsg().getName());

					// discard all alternatives
					localRules.clear();

					if (match.getFollowUps().isEmpty()) {
						// all rules of this branch consumed
						// restart at root of semantic rules
						ProtocolSemantics semantics = msg.getIfitem().getSemantics();
						localRules.addAll(semantics.getRules());
					}
					else {
						// and add all follow ups
						localRules.addAll(match.getFollowUps());
					}
					
				} else {
					// TODO: issue a warning?
					wrongMsgList.add(msg);
				}
			}
		}
		return wrongMsgList;
	}

	// merges the rules with the destination active rules
	public boolean merge(ActiveRules ar) {
		boolean added_at_least_one = false;
		for (Entry<AbstractInterfaceItem, List<SemanticsRule>> entry : ar.rules
				.entrySet()) {
			for (SemanticsRule rule : entry.getValue()) {
				AbstractInterfaceItem ifitem = entry.getKey();
				if (rules.containsKey(ifitem)) {
					if (!rules.get(ifitem).contains(rule)) {
						rules.get(ifitem).add(rule);
						added_at_least_one = true;
					}
				} else {
					List<SemanticsRule> tempList = new ArrayList<SemanticsRule>();
					tempList.add(rule);
					rules.put(ifitem, tempList);
					added_at_least_one = true;
				}
			}
		}

		if (traceRules && traceLevel >= TRACE_DETAILS)
			System.out.println("  merge changed rules");

		return added_at_least_one;
	}

	public ActiveRules createCopy() {
		HashMap<AbstractInterfaceItem, List<SemanticsRule>> newRules = new HashMap<AbstractInterfaceItem, List<SemanticsRule>>();
		for (AbstractInterfaceItem ifitem : rules.keySet()) {
			newRules.put(ifitem,
					new ArrayList<SemanticsRule>(rules.get(ifitem)));
		}
		return new ActiveRules(newRules);
	}

	public void buildInitLocalRules(ExpandedModelComponent xpAct) {
		// HashMap<AbstractInterfaceItem, EList<SemanticsRule>> locals = new
		// HashMap<AbstractInterfaceItem, EList<SemanticsRule>>();
		List<AbstractInterfaceItem> portList = xpAct.getModelComponent().getAllAbstractInterfaceItems();
		for (AbstractInterfaceItem ifitem : portList) {
			if (ifitem.getSemantics()!=null) {
				rules.put(ifitem, new ArrayList<SemanticsRule>(ifitem.getSemantics().getRules()));
			}
		}
	}

	public void print() {
		for (AbstractInterfaceItem port : rules.keySet()) {
			System.out.println("      Rules for Port " + port.getName() + ":");
			for (SemanticsRule rule : rules.get(port)) {
				printRule(rule, "        ");
			}
		}
	}

	public void printRule(SemanticsRule rule, String indent) {
		if (rule instanceof InSemanticsRule)
			System.out.println(indent + "in: " + rule.getMsg().getName());
		else
			System.out.println(indent + "out: " + rule.getMsg().getName());
		// recursion
		for (SemanticsRule sr : rule.getFollowUps()) {
			printRule(sr, indent + "  ");
		}
	}
}
