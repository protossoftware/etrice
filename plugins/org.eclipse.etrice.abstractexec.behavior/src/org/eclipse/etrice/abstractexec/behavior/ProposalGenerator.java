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
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.abstractexec.behavior.util.AbstractExecutionUtil;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.fsm.fSM.SemanticsRule;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;

public class ProposalGenerator {
	private ExpandedModelComponent xpac;
	private SemanticsCheck checker;
	private List<MessageFromIf> outgoingProposal = new LinkedList<MessageFromIf>();
	private List<MessageFromIf> incomingProposal = new LinkedList<MessageFromIf>();
	private FSMNameProvider fsmNameProvider = new FSMNameProvider();
	
	private static boolean traceProposals = false;
	static {
		if (Activator.getDefault().isDebugging()) {
			String value = Platform
					.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/proposals");
			if (value != null && value.equalsIgnoreCase(Boolean.toString(true))) {
				traceProposals = true;
			}
		}
	}

	public ProposalGenerator(ExpandedModelComponent xp, SemanticsCheck chk) {
		xpac = xp;
		checker = chk;
	}

	public List<MessageFromIf> getIncomingProposals() {
		return incomingProposal;
	}

	public List<MessageFromIf> getOutgoingProposals() {
		return outgoingProposal;
	}

	public void createProposals(State st) {
		ActiveRules rules = checker.getActiveRules(st);

		// in case the state is disconnected component of the graph
		if (rules == null)
			return;

		// ignore substates
		if (AbstractExecutionUtil.getInstance().getRoomHelpers().hasDirectSubStructure(st))
			return;

		outgoingProposal.clear();
		incomingProposal.clear();

		for (AbstractInterfaceItem port : rules.getPortList()) {
			// collect all messages from active triggers
			Set<EObject> messages = new HashSet<EObject>();
			for (ActiveTrigger t : xpac.getActiveTriggers(st))
				if (t.getIfitem().equals(port))
					messages.add((EObject)t.getMsg());
			// check if every rule has its messages
			if (rules.getPortList().contains(port)) {
				for (SemanticsRule curRule : rules.getRulesForPort(port)) {
					if (!messages.contains(curRule.getMsg())) {
						MessageFromIf mif = FSMFactory.eINSTANCE
								.createMessageFromIf();
						mif.setFrom(port);
						mif.setMessage(curRule.getMsg());
						boolean isOutgoing = port.getAllOutgoingAbstractMessages().contains(curRule.getMsg());
						if (isOutgoing) {
							outgoingProposal.add(mif);
						} else {
							incomingProposal.add(mif);
						}
					}
				}
			}
		}

		if (traceProposals) {
			System.out.println("  Proposals for : " + st.getName());

			for (MessageFromIf msg : outgoingProposal) {
				System.out.println("    Outgoing msg proposal : "
						+ msg.getFrom().getName() + "."
						+ fsmNameProvider.getMessageName(msg.getMessage()) + "()");
			}
			for (MessageFromIf msg : incomingProposal) {
				System.out.println("    Incoming msg proposal : "
						+ fsmNameProvider.getMessageName(msg.getMessage()) + " from "
						+ msg.getFrom().getName());
			}
		}
	}

}
