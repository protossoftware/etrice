/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.fSM.util.FSMSwitch;

import com.google.common.base.Function;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMNameProvider {

	/**
	 * a name for the virtual top level state containing the whole state machine
	 */
	public static final String TOP_STATE_NAME = "TOP";
	/**
	 * a separator character (a string of size 1) for paths
	 */
	public static final String PATH_SEP = "_";

	protected class FSMProvider extends FSMSwitch<String> {
		public FSMProvider() {}
		
		@Override
		public String caseState(State object) { return getStateName(object); }
		@Override
		public String caseChoicePoint(ChoicePoint object) { return object.getName(); }
		@Override
		public String caseTrPoint(TrPoint object) { return object.getName(); }
		@Override
		public String caseTransition(Transition object) { return getTransitionName(object); }
	}
	
	private FSMProvider fsmNameProvider = new FSMProvider();
	
	/**
	 * Explicitly supported types are
	 * <ul>
	 *   <li>State</li>
	 *   <li>ChoicePoint</li>
	 *   <li>TrPoint</li>
	 *   <li>Transition</li>
	 * </ul>
	 * 
	 * Also supported are the sub types of these types.
	 * 
	 * @param item an {@link EObject}
	 * @return a human readable name of the item
	 */
	public String getName(EObject item) {
		String name = fsmNameProvider.doSwitch(item);
		if (name==null)
			name = item.toString();
		return name;
	}
	
	/**
	 * @param item a {@link StateGraphItem}
	 * @return the path in the state machine of this item
	 */
	public String getFullPath(StateGraphItem item) {
		return getParentPath(item)+getName(item);
	}

	/**
	 * @param sg a {@link StateGraph}
	 * @return a path to the containing state (using {@link #getFullPath(StateGraphItem)}
	 * 		or the {@link #TOP_STATE_NAME}
	 */
	public String getFullPath(StateGraph sg) {
		if (sg.eContainer() instanceof State)
			return getFullPath((State)sg.eContainer());
		else
			return TOP_STATE_NAME;
	}
	
	/**
	 * @param s a {@link State}
	 * @return the full path of the state
	 */
	public String getStatePathName(State s) {
		return getParentPath(s)+getStateName(s);
	}
	
	/**
	 * @param t a {@link Transition}
	 * @return a unique identifier for the transition composed of the transition name, the terminal names
	 * 		and the trigger (if applicable)
	 */
	public String getTransitionName(Transition t) {
		String toName = getTerminalName(t.getTo());
		if (t instanceof InitialTransition) {
			return "TRANS_INITIAL_TO__"+toName;
		}
		else {
			String fromName = getTerminalName(((NonInitialTransition) t).getFrom());
			String fromTo = "TRANS_"+t.getName()+"_FROM_"+fromName+"_TO_"+toName;
			if (t instanceof TriggeredTransition) {
				if (fromName.equals(toName))
					return fromTo + "_BY_" + getTriggerName((TriggeredTransition) t) + "_" + t.getName();
				else
					return fromTo + "_BY_" + getTriggerName((TriggeredTransition) t);
			}
			else if (t instanceof ContinuationTransition) {
				return fromTo;
			}
			else if (t instanceof CPBranchTransition) {
				return fromTo+"_COND_"+t.getName();
			}
			else if (t instanceof GuardedTransition) {
				return fromTo+"_GUARD_"+t.getName();
			}
		}
		
		assert(false): "Unexpected transition class "+t.eClass().getName();
		return null;
	}
	
	/**
	 * @param s a {@link State}
	 * @return the name of the state of {@link #TOP_STATE_NAME} if s is <code>null</code>
	 */
	public String getStateName(State s) {
		if (s==null) {
			return TOP_STATE_NAME;
		}
		else {
			return s.getName();
		}
	}
	
	/**
	 * This is a redundant implementation of
	 * {@link org.eclipse.etrice.core.room.util.RoomHelpers#isTopLevel(StateGraphNode)}
	 * which is here to avoid cyclic dependencies.
	 * 
	 * @param item
	 * @return
	 */
	private boolean isTopLevel(StateGraphItem item) {
		return item==null? true : !(item.eContainer().eContainer() instanceof State);
	}
	
	/**
	 * This is a redundant implementation of
	 * {@link org.eclipse.etrice.core.room.util.RoomHelpers#getParentState(StateGraphItem)}
	 * which is here to avoid cyclic dependencies.
	 * 
	 * @param item
	 * @return
	 */
	private State getParentState(StateGraphItem item) {
		if (isTopLevel(item))
			return null;
		else
			return (State) item.eContainer().eContainer();
	}
	
	/**
	 * @param tr a {@link TriggeredTransition}
	 * @return a unique name for the transition triggers
	 */
	private String getTriggerName(TriggeredTransition tr) {
		String result = "";
		for (Trigger tri : tr.getTriggers()) {
			for (MessageFromIf mif : tri.getMsgFromIfPairs()) {
				result += mif.getMessage().getName()+mif.getFrom().getName();
			}
		}
		return result;
	}

	/**
	 * @param tt a {@link TransitionTerminal}
	 * @return a name for the terminal
	 */
	private String getTerminalName(TransitionTerminal tt) {
		if (tt instanceof StateTerminal) {
			return getStateName(((StateTerminal) tt).getState());
		}
		else if (tt instanceof TrPointTerminal) {
			return ((TrPointTerminal) tt).getTrPoint().getName();
		}
		else if (tt instanceof SubStateTrPointTerminal) {
			return getStatePathName(((SubStateTrPointTerminal) tt).getState())+PATH_SEP+((SubStateTrPointTerminal) tt).getTrPoint().getName();
		}
		else if (tt instanceof ChoicepointTerminal) {
			return ((ChoicepointTerminal) tt).getCp().getName();
		}
		
		assert(false): "Unexpected TransitionTerminal class "+tt.eClass().getName();
		return null;
	}
	
	/**
	 * @param item a {@link StateGraphItem}
	 * @return the path of the parent of this item (for refined states the parent path of the target state)
	 */
	private String getParentPath(StateGraphItem item) {
		if (item instanceof RefinedState)
			item = ((RefinedState)item).getTarget();
		
		State parent = getParentState(item);
		if (parent==null)
			return "";
		else
			return getStatePathName(parent)+PATH_SEP;
	}
	
	/**
	 * @return a {@link Function} that provides a name for a {@link RefinedState}
	 */
	public Function<RefinedState, String> getRefinedStateNameProvider() {
		
		return new Function<RefinedState, String>() {
			/* (non-Javadoc)
			 * @see com.google.common.base.Function#apply(java.lang.Object)
			 */
			@Override
			public String apply(RefinedState rs) {
				return getFullPath(rs);
			}
		};

	}
	
	/**
	 * @param t a {@link Transition}
	 * @return a human readable label name for the transition
	 */
	public String getTransitionLabelName(Transition t) {
		String name = null;
		if (t instanceof InitialTransition) {
			return "init";
		}
		else {
			if (t.getName()!=null)
				name = t.getName()+": ";
			else
				name ="";
			
			NonInitialTransition nit = (NonInitialTransition) t;
			if (nit.getFrom() instanceof ChoicepointTerminal) {
				if (nit instanceof ContinuationTransition)
					return name+"[else]";
				
				if (nit instanceof CPBranchTransition) {
					CPBranchTransition cpt = (CPBranchTransition) nit;
					if (cpt.getCondition()!=null && !cpt.getCondition().getLines().isEmpty())
						return name+"["+cpt.getCondition().getLines().get(0)+"]";
				}

				return name+"[?]";
			}
			
			if (t instanceof TriggeredTransition) {
				boolean first = true;
				for (Trigger trig : ((TriggeredTransition) t).getTriggers()) {
					if (first)
						first = false;
					else
						name += "or";
					name += getTriggerLabel(trig);
				}
			}
			
			if (t instanceof GuardedTransition) {
				name += " guard {"+((GuardedTransition)t).getGuard().getLines().get(0)+"}";
			}
		}
		return name;
	}
	
	/**
	 * @param trig a {@link Trigger}
	 * @return a human readable label name for the trigger
	 */
	public String getTriggerLabel(Trigger trig) {
		String name = "<";
		boolean first = true;
		for (MessageFromIf mif : trig.getMsgFromIfPairs()) {
			if (first)
				first = false;
			else
				name += "|";
			name += getMsgFromIfLabel(mif);
		}
		if (trig.getGuard()!=null && !trig.getGuard().getGuard().getLines().isEmpty())
			name += " guard {"+trig.getGuard().getGuard().getLines().get(0)+"}";
		
		return name+">";
	}

	/**
	 * @param mif a {@link MessageFromIf}
	 * @return a label for a message from interface pair
	 */
	public String getMsgFromIfLabel(MessageFromIf mif) {
		String from = (mif.getFrom()!=null) ? (":"+mif.getFrom().getName()) : "";
		return mif.getMessage().getName()+from;
	}

	/**
	 * @param sg a {@link StateGraph}
	 * @return a human readable label for the state graph
	 */
	public String getStateGraphLabel(StateGraph sg) {
		if (sg.eContainer() instanceof State) {
			State s = (State) sg.eContainer();
			return getStatePathLabel(s);
		}
		else
			return "/";
	}

	/**
	 * @param s a {@link State}
	 * @return a / separated path label for the state
	 */
	public String getStatePathLabel(State s) {
		if (s.eContainer().eContainer() instanceof State) {
			return getStatePathLabel((State) s.eContainer().eContainer())+"/"+s.getName();
		}
		else
			return "/"+s.getName();
	}
}
