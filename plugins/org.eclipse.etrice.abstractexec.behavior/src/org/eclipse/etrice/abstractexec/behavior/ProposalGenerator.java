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
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.State;

public class ProposalGenerator {
	private ExpandedActorClass xpac ;
	private SemanticsCheck checker;
	private List<MessageFromIf> outgoingProposal  = new LinkedList<MessageFromIf>();
	private List<MessageFromIf> incomingProposal  = new LinkedList<MessageFromIf>();
	private List<ActiveTrigger> warningTrigger = new LinkedList<ActiveTrigger>();
	private static boolean traceProposals = false;
	      static 
	      {
	    	  if (Activator.getDefault().isDebugging()) 
	    	  {
	    		  String value = Platform.getDebugOption("org.eclipse.etrice.abstractexec.behavior/trace/proposals");
	    		  if (value!=null && value.equalsIgnoreCase(Boolean.toString(true)))
	    		  {
	    			  traceProposals = true;
	    		  }
	       		}		
	}
	public ProposalGenerator(ExpandedActorClass xp , SemanticsCheck chk)
	{
		xpac = xp;
		checker = chk;
	}
	public List<MessageFromIf> getIncomingProposals()
	{
		return incomingProposal;
	}
	public List<MessageFromIf> getOutgoingProposals()
	{
		return outgoingProposal;
	}
	public List<ActiveTrigger> getWarningTriggers()
	{
		return warningTrigger;
	}
	public boolean getProposals(State st )
	{
		boolean issueWarning = false;
		ActiveRules rules = checker.getActiveRules(st);
		//in case the state is disconnected component of the graph
		if(rules==null)
			return false;
		xpac.getActiveTriggers(st);
		
		Set<SemanticsRule> rulesToIgnore = new HashSet<SemanticsRule>();
		for(ActiveTrigger trigger : xpac.getActiveTriggers(st))
		{
			Port port = (Port) trigger.getIfitem();
			if(rules.getPortList().contains(port))
			{
				EList<SemanticsRule> ruleList = rules.getRulesForPort(port);
				for(SemanticsRule curRule : ruleList)
				{
					//mark this rule for ignoring while generating proposals
					//as they have already been taken care of
					rulesToIgnore.add(curRule);
					if(!(curRule.getMsg()==trigger.getMsg()))
					{
						// issue a warning 
						issueWarning= true;
						warningTrigger.add(trigger);
					}
				}
			}
		}
		// now start generating proposals by listing all the rules and ignoring the ones 
		//marked above
		for(InterfaceItem item : rules.getPortList())
		{
			for(SemanticsRule ruleToCheck : rules.getRulesForPort(item))
			{
				if(!rulesToIgnore.contains(ruleToCheck))
				{
					MessageFromIf mif = RoomFactory.eINSTANCE.createMessageFromIf();
					mif.setFrom(item);
					mif.setMessage(ruleToCheck.getMsg());
					ProtocolClass pc = (ProtocolClass) ruleToCheck.getMsg().eContainer();
					if(pc.getIncomingMessages().contains(ruleToCheck.getMsg()))
					{
						if(((Port)item).isConjugated())
							outgoingProposal.add(mif);
						else
							incomingProposal.add(mif);
					}
					else if (pc.getOutgoingMessages().contains(ruleToCheck.getMsg()))
					{
						if(((Port)item).isConjugated())
							incomingProposal.add(mif);
						else
							outgoingProposal.add(mif);
					}
					
				}
			}
		}
		if(traceProposals)
		{
		System.out.println("Proposals for : " + st.getName());
		
		for(MessageFromIf msg : outgoingProposal)
		{
			System.out.println("Outgoing msg proposal : " + msg.getMessage().getName());
		}
		for(MessageFromIf msg : incomingProposal)
		{
			System.out.println("Incoming msg proposal : " + msg.getMessage().getName());
		}
		}
		return issueWarning;
	}

}
