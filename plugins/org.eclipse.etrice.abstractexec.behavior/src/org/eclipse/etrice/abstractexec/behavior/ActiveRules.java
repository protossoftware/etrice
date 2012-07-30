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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class ActiveRules {
	private HashMap<InterfaceItem, EList<SemanticsRule>> rules ;
	
	public ActiveRules()
	{
		rules=  new HashMap<InterfaceItem, EList<SemanticsRule>>();
	}
	private ActiveRules(HashMap<InterfaceItem,EList<SemanticsRule>> r)
	{
		rules = r;
	}
	public Set<InterfaceItem> getPortList()
	{
		return rules.keySet();
	}
	public EList<SemanticsRule> getRulesForPort(InterfaceItem port)
	{
		if(rules.containsKey(port))
			return rules.get(port);
		else
			return null;
	}
	//checks for currently active rules against a message list and modifies the
	//rules which can be merged with the destination node
	//also returns a boolean to determine if anything was changed so as to determine the 
	//condition for adding to the queue
	public void consumeMessages(List<MessageFromIf> msgList )
	{
		//boolean changed = false; //to determine if there was any change in rule 
		//keeps a record of the ports contained in the msgList
		Set<InterfaceItem> portList = new HashSet<InterfaceItem>();
		HashMap<InterfaceItem, EList<SemanticsRule>> ruleChange  = new HashMap<InterfaceItem, EList<SemanticsRule>>();
		for(MessageFromIf msg : msgList)
		{
			InterfaceItem port = msg.getFrom();
			portList.add(port);
			EList<SemanticsRule> followUps = this.getFollowingRules(msg);
			
			if(followUps.size()>0)
			{
				ruleChange.put(port, followUps);
			}
		}
		//check also if there is a port in the ActiveRules port set which doesn't send any message 
		//in the action code
		//since the active rules of that port would need to be merged without change
		for(InterfaceItem ports : this.rules.keySet())
		{
			if(!portList.contains(ports))
			{
				ruleChange.put(ports, this.rules.get(ports));
			}
		}
		this.rules = ruleChange;
	}
	
	//merges the rules with the destination active rules
	public boolean merge(ActiveRules ar)
	{
	 	boolean added_at_least_one= false;
		for(InterfaceItem port : ar.rules.keySet())
		{
			for(SemanticsRule rule : ar.rules.get(port))
			{
				if(!this.rules.get(port).contains(rule))
					{
					this.rules.get(port).add(rule);
					added_at_least_one = true;
					}
			}
		}
		return added_at_least_one;
	}
	public ActiveRules createCopy()
	{
		HashMap<InterfaceItem, EList<SemanticsRule>> newRules=  new HashMap<InterfaceItem, EList<SemanticsRule>>();
		for(InterfaceItem port : this.rules.keySet())
		{
			EList<SemanticsRule> list = new BasicEList<SemanticsRule>(this.rules.get(port));
			newRules.put(port, list);
		}
		return new ActiveRules(newRules);
	}
	//advances the pointer to the follow up messages if a message is found matching the rule
	private EList<SemanticsRule> getFollowingRules(MessageFromIf msg)
	{
		EList<SemanticsRule> follow = new BasicEList<SemanticsRule>();
		List<SemanticsRule> toRemove = new ArrayList<SemanticsRule>();
		if(this.rules.containsKey(msg.getFrom()))
		{
			for(SemanticsRule rule : this.rules.get(msg.getFrom()))
			{
				if(rule.getMsg()== msg.getMessage())
				{
					follow.addAll(rule.getFollowUps());
					//added for removal so it can be replaced the followUp rules
					toRemove.add(rule);
			}
				else
				{
					//add the rule for removing since it is violated by the current msg
					toRemove.add(rule);
				}
			}
		}
		//remove the discarded rules now
		for(SemanticsRule rule : toRemove) 
		{
			this.rules.get(msg.getFrom()).remove(rule);
		}
		//this basically just adds the advanced rules back to the ruleSet
		this.rules.get(msg.getFrom()).addAll(follow);
		return follow;
	}
	public void buildInitLocalRules(ExpandedActorClass xpAct)
	{
		//HashMap<InterfaceItem, EList<SemanticsRule>> locals = new HashMap<InterfaceItem, EList<SemanticsRule>>();
		List<InterfaceItem> portList = RoomHelpers.getAllInterfaceItems(xpAct.getActorClass());
		for(InterfaceItem port : portList)
		{
			GeneralProtocolClass gpc = port.getGeneralProtocol();
			this.rules.put(port, ((ProtocolClass) gpc).getSemantics().getRules());
		}
		
		
	}
	public void print()
	{
		for(InterfaceItem port : this.rules.keySet())
		{
			System.out.println("Port : " + port.getName() + "  : rules : " );
			for(SemanticsRule rule : this.rules.get(port))
			{
				System.out.println(rule.getMsg().getName());
			}
		}
	}
}
