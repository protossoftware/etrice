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

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class ProposalGenerator {
	private ExpandedActorClass xpac;
	private SemanticsCheck checker;
	private List<MessageFromIf> outgoingProposal = new LinkedList<MessageFromIf>();
	private List<MessageFromIf> incomingProposal = new LinkedList<MessageFromIf>();
	//private List<ActiveTrigger> warningTrigger = new LinkedList<ActiveTrigger>();
	private static boolean traceProposals = false;
	static {
		if (Activator.getDefault().isDebugging()) {
			String value = Platform.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/proposals");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceProposals = true;
			}
		}
	}

	public ProposalGenerator(ExpandedActorClass xp, SemanticsCheck chk) {
		xpac = xp;
		checker = chk;
	}

	public List<MessageFromIf> getIncomingProposals() {
		return incomingProposal;
	}

	public List<MessageFromIf> getOutgoingProposals() {
		return outgoingProposal;
	}

//	public List<ActiveTrigger> getWarningTriggers() {
//		return warningTrigger;
//	}

	public boolean getProposals(State st) {
		ActiveRules rules = checker.getActiveRules(st);
		
		// in case the state is disconnected component of the graph
		if (rules == null)
			return false;
		
		boolean issueWarning = false;
		outgoingProposal.clear();
		incomingProposal.clear();
		
		xpac.getActiveTriggers(st);
		Set<SemanticsRule> rulesToIgnore = new HashSet<SemanticsRule>();
		for (ActiveTrigger trigger : xpac.getActiveTriggers(st)) {
			Port port = (Port) trigger.getIfitem();
			if (rules.getPortList().contains(port)) {
				List<SemanticsRule> ruleList = rules.getRulesForPort(port);
				for (SemanticsRule curRule : ruleList) {
					// mark this rule for ignoring while generating proposals
					// as they have already been taken care of
					if (curRule.getMsg() == trigger.getMsg()) {
						rulesToIgnore.add(curRule);
					}
					/*else {
						// issue a warning
						if (traceProposals) {
							System.out.println("Violation of rules with trigger msg : "
											+ trigger.getMsg().getName());
						}
						issueWarning = true;
						warningTrigger.add(trigger);
					}*/
				}
			}
		}
		
		// now start generating proposals by listing all the rules and ignoring
		// the ones
		// marked above
		for (InterfaceItem item : rules.getPortList()) {
			for (SemanticsRule ruleToCheck : rules.getRulesForPort(item)) {
				if (!rulesToIgnore.contains(ruleToCheck)) {
					MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
					mif.setFrom(item);
					mif.setMessage(ruleToCheck.getMsg());
					boolean isOutgoing = RoomHelpers.getMessageList(item, true).contains(ruleToCheck.getMsg());
					if (isOutgoing) {
						outgoingProposal.add(mif);
					}
					else {
						incomingProposal.add(mif);
					}

				}
			}
		}
		
		if (traceProposals) {
			System.out.println("  Proposals for : " + st.getName());

			for (MessageFromIf msg : outgoingProposal) {
				System.out.println("    Outgoing msg proposal : " + msg.getFrom().getName()+"."+msg.getMessage().getName()+"()");
			}
			for (MessageFromIf msg : incomingProposal) {
				System.out.println("    Incoming msg proposal : " + msg.getMessage().getName() + " from " + msg.getFrom().getName());
			}
		}
		
		return issueWarning;
	}

}
