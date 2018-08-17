/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.fsm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.common.base.util.BaseHelpers;
import org.eclipse.etrice.core.fsm.fSM.AbstractInterfaceItem;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.FSMFactory;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.RefinedTransition;
import org.eclipse.etrice.core.fsm.fSM.SimpleState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateGraphNode;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionBase;
import org.eclipse.etrice.core.fsm.fSM.TransitionChainStartTransition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;

import com.google.common.base.Function;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMHelpers extends BaseHelpers {

	/**
	 * @param mc the actor class to check
	 * @return {@code true} if the class hierarchy is circular (i.e. a base class refers to one of its sub classes)
	 */
	public boolean isCircularClassHierarchy(ModelComponent mc) {
		HashSet<ModelComponent> classes = new HashSet<ModelComponent>();
		classes.add(mc);
		
		while (mc.getBase()!=null) {
			mc = mc.getBase();
			if (classes.contains(mc))
				return true;
			
			classes.add(mc);
		}
		
		return false;
	}

	/**
	 * returns the actual state machine of this model class. I.e. the own state machine if it has
	 * one or otherwise the first state machine in the super class hierarchy
	 */
	public StateGraph getActualStateMachine(ModelComponent mc) {
		// we go up in the inheritance hierarchy until we find a model class with a state machine
		while (mc!=null) {
			if (mc.getStateMachine()!=null) {
				return mc.getStateMachine();
			}
			
			mc = mc.getBase();
		}
		
		return null;
	}
	
	public StateGraph getSuperStateMachine(ModelComponent mc) {
		StateGraph stateMachine = getActualStateMachine(mc);
		
		// this component is not necessarily the one that was passed in
		mc = getModelComponent(stateMachine);
		
		// now return the actual state machine of the base class...
		if (mc!=null && mc.getBase()!=null) {
			return getActualStateMachine(mc.getBase());
		}
		
		// ...or null if no such one
		return null;
	}
	
	/**
	 * Returns the parent {@link ModelComponent} of a {@link StateGraphItem}.
	 * 
	 * @param item a {@link StateGraphItem}
	 * 
	 * @return the parent {@link ModelComponent} of a {@link StateGraphItem}
	 */
	public ModelComponent getModelComponent(StateGraphItem item) {
		EObject parent = item;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ModelComponent)
				return (ModelComponent) parent;
		}
		assert(false): "data structure broken";
		return null;
	}
	
	/**
	 * Returns the parent {@link ModelComponent} of an arbitrary EObject (result may be null).
	 * 
	 * @param obj an {@link EObject}
	 * 
	 * @return the parent {@link ModelComponent} of an arbitrary EObject (result may be null)
	 */
	public ModelComponent getModelComponent(EObject obj) {
		EObject parent = obj;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ModelComponent)
				return (ModelComponent) parent;
		}
		return null;
	}
	
	/**
	 * Returns whether a {@link State} has sub structure.
	 * That means either of
	 * <ul>
	 * <li>the state has a non-empty sub graph</li>
	 * <li>the state is a RefinedState and its target state has sub structure</li>
	 * <li>a RefinedState of a sub {@link ModelComponent} pointing to this state has sub structure</li>
	 * </ul>
	 * 
	 * @param state the {@link State}
	 * @param mc the containing {@link ModelComponent} (which might be a sub class of the
	 * 		ModelComponent containing the State in the containment hierarchy) 
	 * 
	 * @return whether a {@link State} has sub structure
	 */
	public boolean hasSubStructure(State state, ModelComponent mc) {
		if (hasDirectSubStructure(state))
			return true;
		
		if (state instanceof RefinedState) {
			State target = ((RefinedState) state).getTarget();
			while (target!=null) {
				if (hasDirectSubStructure(target))
					return true;
				if (target instanceof RefinedState)
					target = ((RefinedState) target).getTarget();
				else
					break;
			}
		}
		
		if (mc.getStateMachine()!=null) {
			for (State s : getAllStatesRecursive(mc.getStateMachine())) {
				State predecessor = s;
				while (predecessor instanceof RefinedState) {
					predecessor = ((RefinedState) predecessor).getTarget();
					if (predecessor==state) {
						// we have a chain from s -> state
						// check this chain
						predecessor = s;
						while (predecessor instanceof RefinedState) {
							if (hasDirectSubStructure(predecessor))
								return true;
							predecessor = ((RefinedState) s).getTarget();
							if (predecessor==state)
								break;
						}
						break;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Returns whether a {@link State} has direct sub structure.
	 * This is equivalent with having a non-empty sub graph.
	 * 
	 * @param s the {@link State}
	 * 
	 * @return whether a {@link State} has direct sub structure
	 */
	public boolean hasDirectSubStructure(State s) {
		return !isEmpty(s.getSubgraph());
	}

	/**
	 * Returns whether an {@link ModelComponent} has a non-empty {@link StateGraph}.
	 * 
	 * @param mc the {@link ModelComponent}
	 * 
	 * @return whether an {@link ModelComponent} has a non-empty {@link StateGraph}
	 */
	public boolean hasNonEmptyStateMachine(ModelComponent mc) {
		return !isEmpty(mc.getStateMachine());
	}
	
	public boolean isEmpty(StateGraph sg) {
		if (sg==null)
			return true;
		
		if (!sg.getStates().isEmpty())
			return false;
		if (!sg.getTransitions().isEmpty())
			return false;
		if (!sg.getTrPoints().isEmpty())
			return false;
		if (!sg.getChPoints().isEmpty())
			return false;
		if (!sg.getRefinedTransitions().isEmpty())
			return false;
		
		return true;
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return <code>true</code> if the state graph represents the top level (i.e.
	 * is the actor's state machine)
	 */
	public boolean isTopLevel(StateGraph sg) {
		return !(sg.eContainer() instanceof State);
	}
	
	/**
	 * @param s a {@link State}
	 * @return <code>true</code> if the state resides in the top level (i.e.
	 * directly in the actor's state machine)
	 */
	public boolean isTopLevel(StateGraphNode s) {
		return isTopLevel((StateGraph) s.eContainer());
	}
	
	/**
	 * @param s a {@link State}
	 * @return <code>true</code> if the state has no sub-graph
	 */
	public boolean isLeaf(State s) {
		return s.getSubgraph()==null;
	}
	
	/**
	 * @param state a {@link State}
	 * @return a list of all leaf states recursively
	 */
	public List<State> getLeafStateList(State state) {
		return getLeafStateList(state.getSubgraph());
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return a list of all leaf states recursively
	 */
	public List<State> getLeafStateList(StateGraph sg) {
		ArrayList<State> res = new ArrayList<State>();
		
		if (sg!=null) {
			TreeIterator<EObject> it = sg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if ((obj instanceof State) && isLeaf((State) obj))
					res.add((State) obj);
			}
		}
		
		return res;
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return a list of all states recursively
	 */
	public List<State> getStateList(StateGraph sg) {
		ArrayList<State> res = new ArrayList<State>();
		
		if (sg!=null) {
			TreeIterator<EObject> it = sg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof State)
					res.add((State) obj);
			}
		}
		
		return res;
	}
	
	/**
	 * @param sg a {@link StateGraph}
	 * @return a list of all base states recursively
	 */
	public List<State> getBaseStateList(StateGraph sg) {
		ArrayList<State> res = new ArrayList<State>();
		
		if (sg!=null) {
			TreeIterator<EObject> it = sg.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof SimpleState)
					res.add((State) obj);
			}
		}
		
		return res;
	}
	
	/**
	 * @param mc an {@link ModelComponent} 
	 * @return all base states of the actor class
	 */
	public List<State> getAllBaseStates(ModelComponent mc) {
		return getBaseStateList(mc.getStateMachine());
	}
	
	/**
	 * @param s a {@link State}
	 * @return the parent state of s if there is such. If the state is on
	 * the top level then <code>null</code> is returned
	 */
	public State getParentState(StateGraphNode s) {
		if (isTopLevel(s))
			return null;
		else
			return (State) s.eContainer().eContainer();
	}

	/**
	 * Returns the {@link RefinedState} in the derived state machine of the {@link ModelComponent}
	 * which is (indirectly) targeting the state.
	 * 
	 * @param state the {@link State}
	 * @param mc the {@link ModelComponent}
	 * 
	 * @return the {@link RefinedState} in the derived state machine of the {@link ModelComponent}
	 * which is (indirectly) targeting the state
	 */
	public State getTargettingState(State state, ModelComponent mc) {
		State targetting = state;
		for (State s : getAllStatesRecursive(mc.getStateMachine())) {
			State predecessor = s;
			while (predecessor instanceof RefinedState) {
				predecessor = ((RefinedState) predecessor).getTarget();
				if (predecessor==state)
					targetting = s;
			}
		}
		return targetting;
	}
	
	public SimpleState getFinalTarget(RefinedState state)  {
		State target = state.getTarget();
		if (target instanceof SimpleState) {
			return (SimpleState) target;
		}
		else if (target instanceof RefinedState) {
			return getFinalTarget((RefinedState) target);
		}
		else {
			// must never happen
			assert(false) : "unexpected sub type";
			return null;
		}
	}
	
	/**
	 * Returns <code>false</code> if the {@link DetailCode} is null or empty.
	 * 
	 * @param dc the {@link DetailCode}
	 * @return <code>false</code> if the {@link DetailCode} is null or empty.
	 */
	public boolean hasDetailCode(DetailCode dc) {
		if (dc==null)
			return false;
		
		if (dc.getLines().isEmpty() && dc.isUsed())
			return true;
		
		for (String cmd : dc.getLines()) {
			if (!cmd.isEmpty())
				return true;
		}

		return false;
	}

	/**
	 * @param trig a {@link Trigger}
	 * @return <code>true</code> if a guard condition is defined for this trigger
	 */
	public boolean hasGuard(Trigger trig) {
		return trig.getGuard()!=null && hasDetailCode(trig.getGuard().getGuard());
	}
	
	/**
	 * Returns <code>true</code> if the entry code of a {@link State} is empty.
	 * 
	 * @param s the {@link State}
	 * @param includeInherited if <code>true</code> also parent states are considered
	 * 
	 * @return <code>true</code> if the entry code of a {@link State} is empty
	 */
	public boolean hasEntryCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, FSMPackage.Literals.STATE__ENTRY_CODE);
	}

	/**
	 * Returns <code>true</code> if the exit code of a {@link State} is empty.
	 * 
	 * @param s the {@link State}
	 * @param includeInherited if <code>true</code> also parent states are considered
	 * 
	 * @return <code>true</code> if the exit code of a {@link State} is empty
	 */
	public boolean hasExitCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, FSMPackage.Literals.STATE__EXIT_CODE);
	}

	/**
	 * Returns <code>true</code> if the do code of a {@link State} is empty.
	 * 
	 * @param s the {@link State}
	 * @param includeInherited if <code>true</code> also parent states are considered
	 * 
	 * @return <code>true</code> if the do code of a {@link State} is empty
	 */
	public boolean hasDoCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, FSMPackage.Literals.STATE__DO_CODE);
	}
	
	private boolean hasDetailCode(State s, boolean includeInherited, EReference feature) {
		DetailCode dc = (DetailCode) s.eGet(feature);
		if (hasDetailCode(dc))
			return true;
		
		if (includeInherited && s instanceof RefinedState)
			return !getInheritedCode((RefinedState) s, feature, true /* order doesn't matter here */).getLines().isEmpty();
		
		return false;
	}

	/**
	 * Returns the {@link DetailCode} as String with a newline character after each command.
	 * 
	 * @param code a {@link DetailCode}
	 * 
	 * @return  the {@link DetailCode} as String with a newline character after each command.
	 */
	public String getDetailCode(DetailCode code) {
		if (code==null || code.getLines().isEmpty())
			return "";
		
		StringBuilder result = new StringBuilder();
		for (String cmd : code.getLines()) {
			result.append(cmd + "\n");
		}
		return result.toString();
	}

	/**
	 * Returns a concatenation of inherited entry codes as {@link DetailCode}.
	 * The codes are ordered base class to sub class.
	 * 
	 * @param rs {@link RefinedState}
	 * 
	 * @return a concatenation of inherited entry codes as {@link DetailCode}
	 */
	public DetailCode getInheritedEntryCode(RefinedState rs) {
		return getInheritedCode(rs, FSMPackage.Literals.STATE__ENTRY_CODE, true);
	}

	/**
	 * Returns a concatenation of inherited exit codes as {@link DetailCode}.
	 * The codes are ordered sub class to base class.
	 * 
	 * @param rs {@link RefinedState}
	 * 
	 * @return a concatenation of inherited exit codes as {@link DetailCode}
	 */
	public DetailCode getInheritedExitCode(RefinedState rs) {
		return getInheritedCode(rs, FSMPackage.Literals.STATE__EXIT_CODE, false);
	}

	/**
	 * Returns a concatenation of inherited do codes as {@link DetailCode}.
	 * The codes are ordered base class to sub class.
	 * 
	 * @param rs {@link RefinedState}
	 * 
	 * @return a concatenation of inherited do codes as {@link DetailCode}
	 */
	public DetailCode getInheritedDoCode(RefinedState rs) {
		return getInheritedCode(rs, FSMPackage.Literals.STATE__DO_CODE, true);
	}
	
	/**
	 * @param rs
	 * @param code
	 * @return
	 */
	private DetailCode getInheritedCode(RefinedState rs, EReference code, boolean addFront) {
		DetailCode result = FSMFactory.eINSTANCE.createDetailCode();
		boolean used = false;
		State s = rs.getTarget();
		while (s!=null) {
			DetailCode dc = (DetailCode) s.eGet(code);
			if (dc!=null) {
				if (addFront)
					result.getLines().addAll(0, dc.getLines());
				else
					result.getLines().addAll(dc.getLines());
				
			}
			used = hasDetailCode(dc);
			
			if (s instanceof RefinedState)
				s = ((RefinedState) s).getTarget();
			else
				break;
		}
		result.setUsed(used);
		return result;
	}

	/**
	 * The default resolution mechanism will return a SimpleState.
	 * This method searches for RefinedStates targeting the simple state.
	 * 
	 * @param sg the context for the search
	 * @param state the target state
	 * 
	 * @return a refined state targeting state or state itself
	 */
	public State getRefinedStateFor(StateGraph sg, State state) {
		// first we look for RefinedStates in the current context
		for (State s : sg.getStates()) {
			if (s instanceof RefinedState && s.getName().equals(state.getName())) {
				return s;
			}
		}
		
		// then we check whether our container has a base state/class
		if (sg.eContainer() instanceof State) {
			if (sg.eContainer() instanceof RefinedState) {
				return getRefinedStateFor(((RefinedState)sg.eContainer()).getTarget().getSubgraph(), state);
			}
		}
		else if (sg.eContainer() instanceof ModelComponent) {
			ModelComponent mc = (ModelComponent) sg.eContainer();
			if (mc.getBase()!=null && mc.getBase().getStateMachine()!=null)
				return getRefinedStateFor(mc.getBase().getStateMachine(), state);
		}
		
		// nothing found, return original state
		return state;
	}

	/**
	 * Returns whether a {@link Trigger} contains a guard.
	 * 
	 * @param trig {@link Trigger}
	 * 
	 * @return whether a {@link Trigger} contains a guard
	 */
	public boolean isGuarded(Trigger trig) {
		// TODO: remove this redundant method
		return hasGuard(trig);
	}
	
	public boolean isHandler(Transition tr) {
		if (tr instanceof TransitionChainStartTransition) {
			TransitionChainStartTransition trans = (TransitionChainStartTransition) tr;
			if (trans.getFrom() instanceof TrPointTerminal) {
				TrPoint tp = ((TrPointTerminal)trans.getFrom()).getTrPoint();
				if (tp instanceof TransitionPoint)
					return ((TransitionPoint)tp).isHandler();
			}
			else if (trans.getFrom() instanceof SubStateTrPointTerminal) {
				TrPoint tp = ((SubStateTrPointTerminal)trans.getFrom()).getTrPoint();
				if (tp instanceof TransitionPoint)
					assert(false): "not allowed to connect TransitionPoint to exterior";
			}
		}
		return false;
	}
	
	public State getSuperState(TransitionBase tr) {
		if (tr instanceof RefinedTransition) {
			return getSuperState(((RefinedTransition) tr).getTarget());
		}
		
		if (tr.eContainer().eContainer() instanceof State) {
			return (State) tr.eContainer().eContainer();
		}

		return null;
	}

	/**
	 * Returns the destination {@link StateGraphNode} of a {@link TransitionTerminal}.
	 * 
	 * @param tt the transition terminal
	 * 
	 * @return the destination {@link StateGraphNode} of a {@link TransitionTerminal}
	 */
	public StateGraphNode getNode(TransitionTerminal tt) {
		if (tt instanceof StateTerminal)
			return ((StateTerminal)tt).getState();
		else if (tt instanceof TrPointTerminal)
			return ((TrPointTerminal)tt).getTrPoint();
		else if (tt instanceof SubStateTrPointTerminal)
			return ((SubStateTrPointTerminal)tt).getTrPoint();
		else if (tt instanceof ChoicepointTerminal)
			return ((ChoicepointTerminal)tt).getCp();
		
		return null;
	}

	/**
	 * Returns all {@link State}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link State}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<State> getAllStates(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_States(), false);
	}

	/**
	 * Returns all {@link State}s of a {@link StateGraph} including parent state graphs recursively
	 * and descend also into sub graphs.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link State}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<State> getAllStatesRecursive(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_States(), true);
	}

	/**
	 * Returns all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<TrPoint> getAllTrPoints(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), false);
	}

	/**
	 * Returns all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively
	 * and descend also into sub graphs.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link TrPoint}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<TrPoint> getAllTrPointsRecursive(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_TrPoints(), true);
	}

	/**
	 * Returns all {@link ChoicePoint}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link ChoicePoint}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<ChoicePoint> getAllChoicePoints(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_ChPoints(), false);
	}

	/**
	 * Returns all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<Transition> getAllTransitions(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_Transitions(), false);
	}

	/**
	 * Returns all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively
	 * and descend also into sub graphs.

	 * @param sg the {@link StateGraph}
	 * 
	 * @return all {@link Transition}s of a {@link StateGraph} including parent state graphs recursively
	 */
	public List<Transition> getAllTransitionsRecursive(StateGraph sg) {
		return getAllStateGraphItems(sg, FSMPackage.eINSTANCE.getStateGraph_Transitions(), true);
	}
	
	@SuppressWarnings("unchecked")
	private <T extends StateGraphItem> List<T> getAllStateGraphItems(StateGraph sg, EReference feature, boolean recurse) {
		ArrayList<T> result = new ArrayList<T>();
		
		while (sg!=null) {
			Object items = sg.eGet(feature);
			if (items instanceof List<?>)
				result.addAll((List<? extends T>) items);
			
			if (recurse) {
				for (State s : sg.getStates()) {
					if (s.getSubgraph()!=null) {
						List<T> subItems = getAllStateGraphItems(s.getSubgraph(), feature, recurse);
						result.addAll(subItems);
					}
				}
			}
			
			if (sg.eContainer() instanceof RefinedState) {
				sg = ((RefinedState)sg.eContainer()).getTarget().getSubgraph();
			}
			else if (sg.eContainer() instanceof ModelComponent) {
				ModelComponent base = ((ModelComponent)sg.eContainer()).getBase();
				if(base != null && isCircularClassHierarchy(base))
					break;
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		
		return result;
	}
	
	/**
	 * Returns a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllNames(StateGraph, StateGraphItem)
	 * 	getAllNames(StateGraph, StateGraphItem)
	 */
	public Set<String> getAllNames(StateGraph sg) {
		return getAllNames(sg, null);
	}
	
	/**
	 * Returns a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link StateGraphItem} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link StateGraphItem}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllNames(StateGraph sg, StateGraphItem skip) {
		HashSet<String> result = new HashSet<String>();
		do {
			for (State st : sg.getStates()) {
				if (st!=skip)
					result.add(st.getName());
			}
			for (TrPoint tp : sg.getTrPoints()) {
				if (tp!=skip)
					result.add(tp.getName());
			}
			for (ChoicePoint cp : sg.getChPoints()) {
				if (cp!=skip)
					result.add(cp.getName());
			}
			for (Transition tr : sg.getTransitions()) {
				if (tr!=skip)
					result.add(tr.getName());
			}
			
			if (sg.eContainer() instanceof RefinedState) {
				sg = ((RefinedState)sg.eContainer()).getTarget().getSubgraph();
			}
			else if (sg.eContainer() instanceof ModelComponent) {
				ModelComponent base = ((ModelComponent)sg.eContainer()).getBase();
				if(base != null && isCircularClassHierarchy(base))
					break;
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		while (sg!=null);
		
		return result;
	}
	
	/**
	 * Returns a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllStateNames(StateGraph, State)
	 * 	getAllStateNames(StateGraph, State)
	 */
	public Set<String> getAllStateNames(StateGraph sg) {
		return getAllNames(sg, null, FSMPackage.eINSTANCE.getStateGraph_States());
	}

	/**
	 * Returns a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link State} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link State}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllStateNames(StateGraph sg, State skip) {
		return getAllNames(sg, skip, FSMPackage.eINSTANCE.getStateGraph_States());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllTrPointNames(StateGraph, TrPoint)
	 * 	getAllStateNames(StateGraph, TrPoint)
	 */
	public Set<String> getAllTrPointNames(StateGraph sg) {
		return getAllNames(sg, null, FSMPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link TrPoint} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link TrPoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllTrPointNames(StateGraph sg, TrPoint skip) {
		return getAllNames(sg, skip, FSMPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllChoicePointNames(StateGraph, ChoicePoint)
	 * 	getAllChoicePointNames(StateGraph, ChoicePoint)
	 */
	public Set<String> getAllChoicePointNames(StateGraph sg) {
		return getAllNames(sg, null, FSMPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link ChoicePoint} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link ChoicePoint}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllChoicePointNames(StateGraph sg, ChoicePoint skip) {
		return getAllNames(sg, skip, FSMPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * 
	 * @return a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 * 
	 * @see org.eclipse.etrice.core.room.util.RoomHelpers#getAllTransitionNames(StateGraph, Transition)
	 * 	getAllTransitionNames(StateGraph, Transition)
	 */
	public Set<String> getAllTransitionNames(StateGraph sg) {
		return getAllNames(sg, null, FSMPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	/**
	 * Returns a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively.
	 * 
	 * @param sg the {@link StateGraph}
	 * @param skip a {@link Transition} to be skipped
	 * 
	 * @return a complete list of all names used by the {@link Transition}s of a {@link StateGraph}
	 * including parent state graphs recursively
	 */
	public Set<String> getAllTransitionNames(StateGraph sg, Transition skip) {
		return getAllNames(sg, skip, FSMPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	private <T extends StateGraphItem> Set<String> getAllNames(StateGraph sg, T skip, EReference feature) {
		List<T> items = getAllStateGraphItems(sg, feature, false);
		
		HashSet<String> names = new HashSet<String>();
		for (T item : items) {
			if (item!=skip)
				names.add(item.getName());
		}
		
		return names;
	}
	
	/**
	 * Checks whether the state machine of an {@link ModelComponent} is flat
	 * in the sense that no state has a non-empty sub graph
	 * 
	 * @param mc the actor class
	 * 
	 * @return <code>true</code> if the state machine is flat
	 */
	public boolean hasFlatStateMachine(ModelComponent mc) {
		if (isEmpty(mc.getStateMachine()))
			return false;

		if (!mc.getStateMachine().getTrPoints().isEmpty())
			return false;
		
		for (State st : mc.getStateMachine().getStates()) {
			if (hasDirectSubStructure(st))
				return false;
		}
		
		return true;
	}

	/**
	 * return the {@link SimpleState} of a {@link State}
	 * @param s
	 * @return the state itself if a SimpleState or the base state for a {@link RefinedState}
	 */
	public SimpleState getBaseState(State s) {
		if (s instanceof SimpleState)
			return (SimpleState) s;
		else if (s instanceof RefinedState)
			return getBaseState(((RefinedState) s).getTarget());
		else
			return null;
	}

	/**
	 * Returns a list of target states of a {@link RefinedState} recursively.
	 * 
	 * @param rs the refined state
	 * 
	 * @return a list of target states of a {@link RefinedState} recursively
	 */
	public List<State> getReferencedStatesRecursively(RefinedState rs) {
		ArrayList<State> result = new ArrayList<State>();
		
		State target = rs.getTarget();
		result.add(target);
		
		if (target instanceof RefinedState) {
			List<State> refs = getReferencedStatesRecursively((RefinedState) target);
			result.addAll(refs);
		}
		
		return result;
	}
	
	/**
	 * Checks whether a {@link RefinedState} references a state recursively.
	 * 
	 * @param rs the refined state
	 * @param referenced the potential target state
	 * 
	 * @return <code>true</code> if a state is referenced recursively by a refined state
	 */
	public boolean referencesStateRecursively(RefinedState rs, State referenced) {
		State target = rs.getTarget();
		if (target==referenced)
			return true;
		
		if (target instanceof SimpleState)
			return false;
		
		if (target instanceof RefinedState)
			return referencesStateRecursively((RefinedState) target, referenced);
		
		assert(false): "unexpected sub type";
		return false;
	}

	/**
	 * This highly specialized method is for <b>internal use only</b>.<br/><br/>
	 * 
	 * All refined states of the state machine of an actor class (without inherited states)
	 * are checked if they are semantically nested in another state of the same state machine.
	 * 
	 * @param mc the actor class
	 * @param nameProvider a function that returns the full path of a refined state
	 * 
	 * @return a map of refined states to potential parent refined states
	 */
	public Map<RefinedState, RefinedState> getRefinedStatesToRelocate(ModelComponent mc, Function<RefinedState, String> nameProvider) {
		
		// collect RefinedStates and some information
		ArrayList<RefinedState> refinedStates = new ArrayList<RefinedState>();
		ArrayList<String> paths = new ArrayList<String>();
		HashMap<String, RefinedState> path2rs = new HashMap<String, RefinedState>();
		TreeIterator<EObject> it = mc.getStateMachine().eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof RefinedState) {
				refinedStates.add((RefinedState) obj);
				String path = nameProvider.apply((RefinedState) obj);
				paths.add(path);
				path2rs.put(path, (RefinedState) obj);
			}
		}
		
		// we sort the paths to have paths with same beginning in descending length
		java.util.Collections.sort(paths, java.util.Collections.reverseOrder());
		
		// find the best matching context
		HashMap<RefinedState, RefinedState> rs2parent = new HashMap<RefinedState, RefinedState>();
		for (RefinedState rs : refinedStates) {
			String fullPath = nameProvider.apply(rs);
			for (String path : paths) {
				if (!fullPath.equals(path) && fullPath.startsWith(path) && fullPath.charAt(path.length())==FSMNameProvider.PATH_SEP.charAt(0)) {
					RefinedState parent = path2rs.get(path);
					if (!(parent.getSubgraph()!=null && parent.getSubgraph().getStates().contains(rs)))
						rs2parent.put(rs, parent);
					break;
				}
			}
		}
		return rs2parent;
	}

	/**
	 * Returns the recursive base class entry code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class entry code of a {@link RefinedState} as string
	 */
	public String getBaseEntryCode(RefinedState state) {
		return getBaseCode(state, FSMPackage.Literals.STATE__ENTRY_CODE);
	}

	/**
	 * Returns the recursive base class exit code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class exit code of a {@link RefinedState} as string
	 */
	public String getBaseExitCode(RefinedState state) {
		return getBaseCode(state, FSMPackage.Literals.STATE__EXIT_CODE);
	}

	/**
	 * Returns the recursive base class do code of a {@link RefinedState} as string.
	 * 
	 * @param state the state
	 * 
	 * @return the recursive base class do code of a {@link RefinedState} as string
	 */
	public String getBaseDoCode(RefinedState state) {
		return getBaseCode(state, FSMPackage.Literals.STATE__DO_CODE);
	}

	private String getBaseCode(RefinedState state, EStructuralFeature feat) {
		StringBuilder result = new StringBuilder();
		
		State base = state.getTarget();
		while (base!=null) {
			String code = getDetailCode((DetailCode) base.eGet(feat));
			result.append(code);
			if (base instanceof RefinedState)
				base = ((RefinedState)base).getTarget();
			else
				break;
		}
		return result.toString();
	}

	/**
	 * <code>true</code> if the transition or one of its refinements has action code
	 * as determined by {@link #hasDetailCode(DetailCode)}.
	 * 
	 * @param trans the transition
	 * @param mc the current model class
	 * @return <code>true</code> if the transition or one of its refined transitions has action code
	 */
	public boolean hasActionCode(Transition trans, ModelComponent mc) {
		
		ModelComponent baseMC = getModelComponent(trans);
		
		while (mc!=null) {
			if (mc==baseMC) {
				return hasDetailCode((trans.getAction()));
			}
			
			if (mc.getStateMachine()!=null)
				for (RefinedTransition rt : mc.getStateMachine().getRefinedTransitions()) {
					if (rt.getTarget()==trans)
						if (hasDetailCode((rt.getAction())))
							return true;
				}
			
			mc = mc.getBase();
		}
		
		return false;
	}

	/**
	 * Returns the recursive base class code of a transition.
	 * 
	 * @param trans the transition
	 * @param mc the model component
	 * 
	 * @return the recursive base class code of a transition
	 */
	public String getInheritedActionCode(Transition trans, ModelComponent mc) {
		return getActionCode(trans, mc, false);
	}
	
	/**
	 * Returns the complete action code including base class code of a {@link Transition}.
	 * 
	 * @param trans the transition
	 * @param mc the model component
	 * 
	 * @return the complete action code including base class code of a {@link Transition}
	 */
	public String getAllActionCode(Transition trans, ModelComponent mc) {
		return getActionCode(trans, mc, true);
	}

	private String getActionCode(Transition trans, ModelComponent mc, boolean includeOwn) {
		StringBuilder result = new StringBuilder();
		
		ModelComponent baseMC = getModelComponent(trans);
		
		if (!includeOwn) {
			if (mc==baseMC)
				return null;
			mc = mc.getBase();
		}
		
		while (mc!=null) {
			if (mc==baseMC) {
				result.insert(0, getDetailCode(trans.getAction()));
				return result.toString();
			}
			
			if (mc.getStateMachine()!=null)
				for (RefinedTransition rt : mc.getStateMachine().getRefinedTransitions()) {
					if (rt.getTarget()==trans)
						result.insert(0, getDetailCode(rt.getAction()));
				}
			
			mc = mc.getBase();
		}
		
		return null;
	}

	/**
	 * @param mc an {@link ModelComponent}
	 * @return a list of {@link MessageFromIf} that may come in through one of the
	 * event driven interface items of this actor class (<i>without</i> inherited ones)
	 */
	public List<MessageFromIf> getMessagesFromInterfaces(ModelComponent mc) {
		ArrayList<MessageFromIf> result = new ArrayList<MessageFromIf>();
		
		List<AbstractInterfaceItem> items = mc.getAbstractInterfaceItems();
		for (AbstractInterfaceItem item : items) {
			for (EObject msg : item.getAllIncomingAbstractMessages()) {
				MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
				mif.setMessage(msg);
				mif.setFrom(item);
				result.add(mif);
			}
		}
		
		return result;
	}

	/**
	 * @param mc an {@link ModelComponent}
	 * @return a list of {@link MessageFromIf} that may come in through one of the
	 * event driven interface items of this actor class (<i>with</i> inherited ones as far as a base class has its own state machine)
	 */
	public List<MessageFromIf> getOwnMessagesFromInterfaces(ModelComponent mc) {
		ArrayList<MessageFromIf> result = new ArrayList<MessageFromIf>();
		
		result.addAll(getMessagesFromInterfaces(mc));
		mc = mc.getBase();
		while (mc!=null) {
			if (hasNonEmptyStateMachine(mc))
				break;
			
			List<AbstractInterfaceItem> items = mc.getAbstractInterfaceItems();
			for (AbstractInterfaceItem item : items) {
				for (EObject msg : item.getAllIncomingAbstractMessages()) {
					MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
					mif.setMessage(msg);
					mif.setFrom(item);
					result.add(mif);
				}
			}
			
			mc = mc.getBase();
		}
		
		return result;
	}

	/**
	 * @param mc an {@link ModelComponent}
	 * @return a list of {@link MessageFromIf} that may come in through one of the
	 * event driven interface items of this actor class(<i>including</i> inherited ones)
	 */
	public List<MessageFromIf> getAllMessagesFromInterfaces(ModelComponent mc) {
		ArrayList<MessageFromIf> result = new ArrayList<MessageFromIf>();
		
		while (mc!=null) {
			List<AbstractInterfaceItem> items = mc.getAbstractInterfaceItems();
			for (AbstractInterfaceItem item : items) {
				for (EObject msg : item.getAllIncomingAbstractMessages()) {
					MessageFromIf mif = FSMFactory.eINSTANCE.createMessageFromIf();
					mif.setMessage(msg);
					mif.setFrom(item);
					result.add(mif);
				}
			}
			
			mc = mc.getBase();
		}
		
		return result;
	}

	/**
	 * @param sg a {@link StateGraph}
	 * @return the initial transition or <code>null</code> if no such is available
	 */
	public Transition getInitTransition(StateGraph sg) {
		for (Transition tr : sg.getTransitions()) {
			if (tr instanceof InitialTransition)
				return tr;
		}
		return null;
	}

	/**
	 * @param sg a {@link StateGraph}
	 * @return <code>true</code> if an initial transition is available
	 */
	public boolean hasInitTransition(StateGraph sg) {
		return getInitTransition(sg)!=null;
	}

}
