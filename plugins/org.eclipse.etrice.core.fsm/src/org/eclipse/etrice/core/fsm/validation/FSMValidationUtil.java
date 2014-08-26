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

package org.eclipse.etrice.core.fsm.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.fsm.fSM.ChoicePoint;
import org.eclipse.etrice.core.fsm.fSM.ChoicepointTerminal;
import org.eclipse.etrice.core.fsm.fSM.ComponentCommunicationType;
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition;
import org.eclipse.etrice.core.fsm.fSM.EntryPoint;
import org.eclipse.etrice.core.fsm.fSM.ExitPoint;
import org.eclipse.etrice.core.fsm.fSM.FSMPackage;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.InitialTransition;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.fsm.fSM.NonInitialTransition;
import org.eclipse.etrice.core.fsm.fSM.RefinedState;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.StateTerminal;
import org.eclipse.etrice.core.fsm.fSM.SubStateTrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.TrPoint;
import org.eclipse.etrice.core.fsm.fSM.TrPointTerminal;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.TransitionPoint;
import org.eclipse.etrice.core.fsm.fSM.TransitionTerminal;
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.fsm.util.FSMHelpers;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMValidationUtil {
	
	@Inject
	private FSMHelpers fsmHelpers;
	
	@Inject
	private FSMNameProvider fsmNameProvider;

	public static class Result {
		private boolean ok;
		private String msg;
		private EObject source;
		private EStructuralFeature feature;
		private int index;

		public static Result ok() {
			return new Result(true, "", null, null, 0);
		}
		public static Result error(String msg) {
			return new Result(false, msg, null, null, -1);
		}
		public static Result error(String msg, EObject source, EStructuralFeature feature) {
			return new Result(false, msg, source, feature, -1);
		}
		public static Result error(String msg, EObject source, EStructuralFeature feature, int index) {
			return new Result(false, msg, source, feature, index);
		}
		
		private Result(boolean ok, String msg, EObject source, EStructuralFeature feature, int index) {
			this.ok = ok;
			this.msg = msg;
			this.source = source;
			this.feature = feature;
			this.index = index;
		}

		public boolean isOk() {
			return ok;
		}
		public String getMsg() {
			return msg;
		}
		public EObject getSource() {
			return source;
		}
		public EStructuralFeature getFeature() {
			return feature;
		}
		public int getIndex() {
			return index;
		}
	}
	
	public Result isConnectable(TransitionTerminal src, TransitionTerminal tgt, StateGraph sg) {
		return isConnectable(src, tgt, null, sg);
	}
	
	public Result isConnectable(TransitionTerminal src, TransitionTerminal tgt, Transition trans, StateGraph sg) {
		Result result = isConnectableSrc(src, trans, sg);
		if (!result.isOk())
			return result;
		
		if (tgt instanceof TrPointTerminal) {
			if (((TrPointTerminal) tgt).getTrPoint() instanceof EntryPoint)
				return Result.error("entry point can not be transition target", tgt, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);

			TrPoint tgtTP = ((TrPointTerminal) tgt).getTrPoint();
			if (((TrPointTerminal) tgt).getTrPoint() instanceof TransitionPoint) {
				if (src instanceof TrPointTerminal) {
					TrPoint srcTP = ((TrPointTerminal)src).getTrPoint();
					if (srcTP!=tgtTP)
						return Result.error("transition point can only be target of self transition", tgt, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
				}
				else if (src instanceof ChoicepointTerminal) {
					ChoicePoint cp = ((ChoicepointTerminal) src).getCp();
					while (cp!=null) {
						for (Transition tr : sg.getTransitions()) {
							if (tr.getTo() instanceof ChoicepointTerminal)
								if (((ChoicepointTerminal)tr.getTo()).getCp()==cp) {
									if (tr instanceof NonInitialTransition) {
										if (((NonInitialTransition) tr).getFrom() instanceof TrPointTerminal) {
											TrPoint srcTP = ((TrPointTerminal)((NonInitialTransition) tr).getFrom()).getTrPoint();
											if (srcTP!=tgtTP)
												return Result.error("transition point can only be target of self transition", tgt, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
											else
												return Result.ok();
										}
										else if (((NonInitialTransition) tr).getFrom() instanceof ChoicepointTerminal) {
											cp = ((ChoicepointTerminal)((NonInitialTransition) tr).getFrom()).getCp();
											break;
										}
									}
								}
						}
					}
					return Result.error("transition point can only be target of self transition", tgt, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
				}
				else {
					return Result.error("transition point can only be target of self transition", tgt, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
				}
			}
			// ExitPoint is a valid destinations
			// ExitPoint can be multiply connected inside a state
		}
		else if (tgt instanceof SubStateTrPointTerminal) {
			if (((SubStateTrPointTerminal) tgt).getTrPoint() instanceof ExitPoint)
				return Result.error("sub state exit point can not be transition target", tgt, FSMPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
			// sub state EntryPoint is valid as destination
		}

		return Result.ok();
	}
	
	public Result isConnectable(TransitionTerminal src, StateGraph sg) {
		return isConnectableSrc(src, null, sg);
	}
	
	public Result isConnectableSrc(TransitionTerminal src, Transition trans, StateGraph sg) {
		if (src==null) {
			for (Transition t : sg.getTransitions()) {
				if (t==trans)
					continue;

				if (t instanceof InitialTransition)
					return Result.error("there already is an InitialTransition", sg, FSMPackage.eINSTANCE.getStateGraph_Transitions(), sg.getTransitions().indexOf(trans));
			}
		}
		else if (src instanceof TrPointTerminal) {
			TrPoint srcTP = ((TrPointTerminal) src).getTrPoint();
			if (srcTP instanceof ExitPoint)
				return Result.error("exit point can not be transition source", trans, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
			// TransitionPoint and EntryPoint are valid
			if (srcTP instanceof EntryPoint) {
				for (Transition t : sg.getTransitions()) {
					if (t==trans)
						continue;

					if (t instanceof NonInitialTransition) {
						if (((NonInitialTransition) t).getFrom() instanceof TrPointTerminal) {
							TrPointTerminal tpt = (TrPointTerminal)((NonInitialTransition) t).getFrom();
							if (tpt.getTrPoint()==srcTP)
								return Result.error("source transition point already is connected", src, FSMPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
						}
					}
				}
			}
		}
		else if (src instanceof SubStateTrPointTerminal) {
			if (((SubStateTrPointTerminal) src).getTrPoint() instanceof EntryPoint)
				return Result.error("sub state entry point can not be transition source", src, FSMPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
			// ExitPoint is valid as source
			for (Transition t : sg.getTransitions()) {
				if (t==trans)
					continue;
				
				if (t instanceof NonInitialTransition) {
					if (((NonInitialTransition) t).getFrom() instanceof SubStateTrPointTerminal) {
						SubStateTrPointTerminal tpt = (SubStateTrPointTerminal)((NonInitialTransition) t).getFrom();
						if (tpt.getTrPoint()==((SubStateTrPointTerminal) src).getTrPoint())
							return Result.error("source transition point already is connected", src, FSMPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
					}
				}
			}
		}
		
		return Result.ok();
	}

	public Result isValid(TrPoint tp) {
		if (!isUniqueName(tp, tp.getName()).isOk())
			return Result.error("name is not unique", tp, FSMPackage.Literals.TR_POINT__NAME);
		
		if (tp instanceof TransitionPoint)
			return Result.ok();
		
		if (!(tp.eContainer().eContainer() instanceof State)) {
			StateGraph sg = (StateGraph) tp.eContainer();
			int idx = sg.getTrPoints().indexOf(tp);
			return Result.error("entry and exit points forbidden on top level state graph", tp.eContainer(), FSMPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
		}
		return Result.ok();
		
	}
	
	public boolean isConnectedOutside(TrPoint tp) {
		if (tp instanceof TransitionPoint)
			return false;
		
		StateGraph parentSG = (StateGraph) tp.eContainer().eContainer().eContainer();
		for (Transition t : parentSG.getTransitions()) {
			if (t.getTo() instanceof SubStateTrPointTerminal) {
				SubStateTrPointTerminal term = (SubStateTrPointTerminal) t.getTo();
				if (term.getTrPoint()==tp)
					return true;
			}
			if (t instanceof NonInitialTransition) {
				if (((NonInitialTransition) t).getFrom() instanceof SubStateTrPointTerminal) {
					SubStateTrPointTerminal term = (SubStateTrPointTerminal) ((NonInitialTransition) t).getFrom();
					if (term.getTrPoint()==tp)
						return true;
				}
			}
		}
		
		return false;
	}

	/**
	 * @param tr
	 * @return the {@link Result} of the check
	 */
	public Result checkTransition(Transition tr) {
		ModelComponent mc = fsmHelpers.getModelComponent(tr);
		if (mc.getCommType()==ComponentCommunicationType.DATA_DRIVEN) {
			if (tr instanceof TriggeredTransition)
				return Result.error("data driven state machine must not contain triggered transition",
						tr.eContainer(),
						FSMPackage.eINSTANCE.getStateGraph_Transitions(),
						((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			else if (tr instanceof ContinuationTransition) {
				// if at this point no continuation transition is allowed it probably should be a guarded transition
				TransitionTerminal term = ((ContinuationTransition) tr).getFrom();
				if (term instanceof StateTerminal || (term instanceof TrPointTerminal && ((TrPointTerminal)term).getTrPoint() instanceof TransitionPoint))
					return Result.error("guard must not be empty",
							tr.eContainer(),
							FSMPackage.eINSTANCE.getStateGraph_Transitions(),
							((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			}
			else if (tr instanceof GuardedTransition)
				if (!fsmHelpers.hasDetailCode(((GuardedTransition) tr).getGuard()))
					return Result.error("guard must not be empty", tr, FSMPackage.eINSTANCE.getGuardedTransition_Guard());
		}
		else if (mc.getCommType()==ComponentCommunicationType.EVENT_DRIVEN) {
			if (tr instanceof GuardedTransition) {
				return Result.error("event driven state machine must not contain guarded transition",
						tr.eContainer(),
						FSMPackage.eINSTANCE.getStateGraph_Transitions(),
						((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			}
			else if (tr instanceof ContinuationTransition) {
				// if at this point no continuation transition is allowed it probably should be a triggered transition
				TransitionTerminal term = ((ContinuationTransition) tr).getFrom();
				if (term instanceof StateTerminal || (term instanceof TrPointTerminal && ((TrPointTerminal)term).getTrPoint() instanceof TransitionPoint))
					return Result.error("trigger must not be empty",
							tr.eContainer(),
							FSMPackage.eINSTANCE.getStateGraph_Transitions(),
							((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			}
		}
		else if (mc.getCommType()==ComponentCommunicationType.ASYNCHRONOUS) {
			if (tr instanceof ContinuationTransition) {
				// if at this point no continuation transition is allowed it probably should be a triggered or guarded transition
				TransitionTerminal term = ((ContinuationTransition) tr).getFrom();
				if (term instanceof StateTerminal || (term instanceof TrPointTerminal && ((TrPointTerminal)term).getTrPoint() instanceof TransitionPoint))
					return Result.error("trigger/guard must not be empty",
							tr.eContainer(),
							FSMPackage.eINSTANCE.getStateGraph_Transitions(),
							((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			}
		}
		return Result.ok();
	}
	
	public Result checkState(State state) {
		if (state.getDoCode()!=null) {
			ModelComponent mc = fsmHelpers.getModelComponent(state);
			if (mc.getCommType()==ComponentCommunicationType.EVENT_DRIVEN) {
				return Result.error("event driven state machines must not have 'do' action code",
						state,
						FSMPackage.eINSTANCE.getState_DoCode());
			}
		}
		return Result.ok();
	}
	
	public List<Result> checkTopLevelRefinedStates(ModelComponent mc) {
		ArrayList<Result> errors = new ArrayList<Result>();
		if (mc.getStateMachine()==null)
			return errors;
		
		Function<RefinedState, String> nameProvider = fsmNameProvider.getRefinedStateNameProvider();
		Map<RefinedState, RefinedState> rs2parent = fsmHelpers.getRefinedStatesToRelocate(mc, nameProvider);
		for (RefinedState rs : rs2parent.keySet()) {
			RefinedState parent = rs2parent.get(rs);
			String path = fsmNameProvider.getFullPath(parent);
			int idx = ((StateGraph)rs.eContainer()).getStates().indexOf(rs);
			errors.add(Result.error(
					"RefinedState has to be in the context of "+path,
					rs.eContainer(),
					FSMPackage.Literals.STATE_GRAPH__STATES,
					idx));
		}
		
		return errors;
	}
	
	public Result isUniqueName(StateGraphItem s, String name) {
		if (name.trim().isEmpty())
			return Result.error("name must not be empty");
		
		if (!isValidID(name))
			return Result.error("name is no valid ID");
		
		StateGraph sg = (StateGraph) s.eContainer();
		Set<String> names = fsmHelpers.getAllNames(sg, s);
		
		if (names.contains(name))
			return Result.error("name already used");
		
		return Result.ok();
	}
	
	public boolean isValidID(String name) {
		return name.matches("\\^?[a-zA-Z_][a-zA-Z_0-9]*");
	}

}
