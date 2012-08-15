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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InSemanticsRule;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class ActiveRules {
	private HashMap<InterfaceItem, List<SemanticsRule>> rules;
	private static boolean traceRules = false;
	private static int traceLevel = 0;
	static {
		if (Activator.getDefault().isDebugging()) {
			String value = Platform.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/rules");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceRules = true;
			}
			value = Platform.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/rules/level");
			if (value != null) {
				traceLevel = Integer.parseInt(value);
			}
		}
	}

	//private static final int TRACE_RESULT = 1;
	private static final int TRACE_DETAILS = 2;

	public ActiveRules() {
		rules = new HashMap<InterfaceItem, List<SemanticsRule>>();
	}

	private ActiveRules(HashMap<InterfaceItem, List<SemanticsRule>> r) {
		rules = r;
	}

	public Set<InterfaceItem> getPortList() {
		return rules.keySet();
	}

	public List<SemanticsRule> getRulesForPort(InterfaceItem port) {
		return rules.get(port);
	}

	// checks for currently active rules against a message list and modifies the
	// rules which can be merged with the destination node
	public void consumeMessages(List<HandledMessage> msgList) {
		for (HandledMessage msg : msgList) {
			List<SemanticsRule> localRules = rules.get(msg.getIfitem());
			if (localRules!=null) {
				SemanticsRule match = null;
				for (SemanticsRule rule : localRules) {
					if (rule.getMsg() == msg.getMsg()) {
						match = rule;
						break;
					}
				}
				
				if (match!=null) {
					if (traceRules && traceLevel>=TRACE_DETAILS)
						System.out.println("  found match for "+msg.getMsg().getName());

					// discard all alternatives
					localRules.clear();
					
					// and add all follow ups
					localRules.addAll(match.getFollowUps());
				}
				else {
					// TODO: issue a warning?
				}
			}
		}
	}

	// merges the rules with the destination active rules
	public boolean merge(ActiveRules ar) {
		boolean added_at_least_one = false;
		for (Entry<InterfaceItem, List<SemanticsRule>> entry : ar.rules.entrySet()) {
			for (SemanticsRule rule : entry.getValue()) {
				InterfaceItem ifitem = entry.getKey();
				if (rules.containsKey(ifitem)) {
					if (!rules.get(ifitem).contains(rule)) {
						rules.get(ifitem).add(rule);
						added_at_least_one = true;
					}
				}
				else {
					List<SemanticsRule> tempList = new ArrayList<SemanticsRule>();
					tempList.add(rule);
					rules.put(ifitem, tempList);
					added_at_least_one = true;
				}
			}
		}
		
		if (traceRules && traceLevel>=TRACE_DETAILS)
			System.out.println("  merge changed rules");

		return added_at_least_one;
	}

	public ActiveRules createCopy() {
		HashMap<InterfaceItem, List<SemanticsRule>> newRules = new HashMap<InterfaceItem, List<SemanticsRule>>();
		for (InterfaceItem ifitem : rules.keySet()) {
			newRules.put(ifitem, new ArrayList<SemanticsRule>(rules.get(ifitem)));
		}
		return new ActiveRules(newRules);
	}

	public void buildInitLocalRules(ExpandedActorClass xpAct) {
		// HashMap<InterfaceItem, EList<SemanticsRule>> locals = new
		// HashMap<InterfaceItem, EList<SemanticsRule>>();
		List<InterfaceItem> portList = RoomHelpers.getAllInterfaceItems(xpAct.getActorClass());
		for (InterfaceItem ifitem : portList) {
			GeneralProtocolClass gpc = ifitem.getGeneralProtocol();
			if (gpc instanceof ProtocolClass && ((ProtocolClass) gpc).getSemantics()!=null)
				rules.put(ifitem, ((ProtocolClass) gpc).getSemantics().getRules());
		}

	}

	public void print() {
		for (InterfaceItem port : rules.keySet()) {
			System.out.println("      Rules for Port " + port.getName() + ":");
			for (SemanticsRule rule : rules.get(port)) {
				printRule(rule, "        ");
			}
		}
	}
	
	public void printRule(SemanticsRule rule, String indent) {
		if (rule instanceof InSemanticsRule)
			System.out.println(indent+"in: "+rule.getMsg().getName());
		else
			System.out.println(indent+"out: "+rule.getMsg().getName());
		
		// recursion
		for (SemanticsRule sr : rule.getFollowUps()) {
			printRule(sr, indent+"  ");
		}
	}
}
