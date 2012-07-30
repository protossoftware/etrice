package org.eclipse.etrice.abstractexec.behavior;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ActiveTrigger;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.State;

public class ProposalGenerator {
	private ExpandedActorClass xpac ;
	private SemanticsCheck checker;
	public ProposalGenerator(ExpandedActorClass xp , SemanticsCheck chk)
	{
		xpac = xp;
		checker = chk;
	}
	public void getProposals(State st )
	{
		ActiveRules rules = checker.getActiveRules(st);
		xpac.getActiveTriggers(st);
		List<MessageFromIf> outgoingProposal  = new LinkedList<MessageFromIf>();
		List<MessageFromIf> incomingProposal  = new LinkedList<MessageFromIf>();
		Set<SemanticsRule> rulesToIgnore = new HashSet<SemanticsRule>();
		for(ActiveTrigger trigger : xpac.getActiveTriggers(st))
		{
			MessageFromIf mifTrig = RoomFactory.eINSTANCE.createMessageFromIf();
			mifTrig.setFrom(trigger.getIfitem());
			mifTrig.setMessage(trigger.getMsg());
			Port port = (Port) mifTrig.getFrom();
			if(rules.getPortList().contains(port))
			{
				EList<SemanticsRule> ruleList = rules.getRulesForPort(port);
				for(SemanticsRule curRules : ruleList)
				{
					if(curRules.getMsg()==mifTrig.getMessage())
					{
						//mark this rule for ignoring while generating proposals
						//as they have already been taken care of
						rulesToIgnore.add(curRules);
					}
					else
					{
						// issue a warning 
						rulesToIgnore.add(curRules);
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
					if(((Port)item).isConjugated())
					{
						incomingProposal.add(mif);
					}
					else
					{
						outgoingProposal.add(mif);
					}
					
				}
			}
		}
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

}
