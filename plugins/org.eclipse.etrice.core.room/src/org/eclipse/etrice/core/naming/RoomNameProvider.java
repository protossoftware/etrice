/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/


package org.eclipse.etrice.core.naming;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CPBranchTransition;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateGraphNode;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomSwitch;

import com.google.common.base.Function;


/**
 * A class providing names for instances of central types of the ROOM model.
 * 
 * @author Henrik Rentz-Reichert
 */
public class RoomNameProvider {
	
	/**
	 * a name for the virtual top level state containing the whole state machine
	 */
	public static final String TOP_STATE_NAME = "TOP";
	/**
	 * a separator character (a string of size 1) for paths
	 */
	public static final String PATH_SEP = "_";
	
	private RoomSwitch<String> nameProvider = new RoomSwitch<String>() {
		public String caseState(State object) { return getStateName(object); }
		public String caseChoicePoint(ChoicePoint object) { return object.getName(); }
		public String caseTrPoint(TrPoint object) { return object.getName(); }
		public String caseTransition(Transition object) { return getTransitionName(object); }
		public String caseActorRef(org.eclipse.etrice.core.room.ActorRef object) { return "ActorRef '"+object.getName()+"'"; }
		public String casePort(org.eclipse.etrice.core.room.Port object) { return "Port '"+object.getName()+"'"; }
		public String caseSAP(org.eclipse.etrice.core.room.SAP object) { return "SAP '"+object.getName()+"'"; }
		public String caseSPP(org.eclipse.etrice.core.room.SPP object) { return "SPP '"+object.getName()+"'"; }
		public String caseActorClass(ActorClass object) { return "ActorClass "+object.getName(); }
		public String caseSubSystemClass(SubSystemClass object) { return "SubsystemClass "+object.getName(); }
	};
	
	/**
	 * Explicitly supported types are
	 * <ul>
	 *   <li>State</li>
	 *   <li>ChoicePoint</li>
	 *   <li>TrPoint</li>
	 *   <li>Transition</li>
	 *   <li>ActorRef</li>
	 *   <li>Port</li>
	 *   <li>SAP</li>
	 *   <li>SPP</li>
	 *   <li>ActorClass</li>
	 *   <li>SubSystemClass</li>
	 * </ul>
	 * 
	 * Also supported are the sub types of these types.
	 * 
	 * @param item an {@link EObject}
	 * @return a human readable name of the item
	 */
	public String getName(EObject item) {
		String name = nameProvider.doSwitch(item);
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
	 * @param obj an {@link EObject}
	 * @return the {@link RoomClass} containing this object or null
	 */
	public RoomClass getModelClass(EObject obj) {
		while (obj!=null) {
			if (obj instanceof RoomClass) {
				return (RoomClass) obj;
			}
			obj = obj.eContainer();
		}
		return null;
	}
	
	/**
	 * @param cls a {@link RoomClass}
	 * @return a human readable name for the ROOM class including its name space (model name)
	 */
	public String getClassLocation(RoomClass cls) {
		if (cls==null)
			return null;
		
		if (cls.eContainer() instanceof RoomModel) {
			return ((RoomModel)cls.eContainer()).getName()+"."+cls.getName();
		}
		return cls.getName();
	}
	
	/**
	 * @param source an {@link EObject}
	 * @return a human readable location that allows to identify the object in the model
	 */
	public String getLocation(EObject source) {
		String location = null;
		String clsLocation = getClassLocation(getModelClass(source));
		
		while (source!=null) {
			if (source instanceof StateGraph) {
				location = getFullPath((StateGraph)source);
				break;
			}
			else if (source instanceof StateGraphItem) {
				location = getFullPath((StateGraphItem)source);
				break;
			}
			else {
				location = getName(source);
				if (location!=null)
					break;
			}
			source = source.eContainer();
		}
		
		if (location==null)
			location = "";
		
		if (clsLocation!=null)
			location += " ["+clsLocation+"]";
		
		return location;
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
	 * @param s a {@link State}
	 * @return the full path of the state
	 */
	public String getStatePathName(State s) {
		return getParentPath(s)+getStateName(s);
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
	 * @param acr a {@link ActorContainerRef}
	 * @return a human readable label name for the reference
	 */
	public String getRefLabelName(ActorContainerRef acr) {
		String className = "<unknown>";
		if (acr instanceof ActorRef) {
			if (((ActorRef)acr).getType()!=null)
				className = ((ActorRef)acr).getType().getName();
		}
		else if (acr instanceof SubSystemRef) {
			if (((SubSystemRef)acr).getType()!=null)
				className = ((SubSystemRef)acr).getType().getName();
		}
		return acr.getName()+"\n("+className+")";
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
		return mif.getMessage().getName()+":"+mif.getFrom().getName();
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
	
	/**
	 * Returns an operation's signature as a string.
	 * 
	 * @param op the operation
	 * 
	 * @return the signature string
	 */
	public String getSignature(Operation op) {
		String signature = "";
		for (VarDecl arg : op.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName()+": "+arg.getRefType().getType().getName();
			else
				signature += ", "+arg.getName()+": "+arg.getRefType().getType().getName();
		}
		String rt = op.getReturnType()!=null? ": "+op.getReturnType().getType().getName():"";
		if (op instanceof PortOperation && ((PortOperation) op).getSendsMsg()!=null)
			rt = " sends "+((PortOperation) op).getSendsMsg().getName();
		signature = op.getName()+"("+signature+")"+rt;
		return signature;
	}

	/**
	 * Returns an operation's argument list as a string.
	 * 
	 * @param op the operation
	 * 
	 * @return the argument list string
	 */
	public String getArguments(Operation op) {
		String signature = "";
		for (VarDecl arg : op.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName();
			else
				signature += ", "+arg.getName();
		}
		signature = "("+signature+")";
		return signature;
	}

	/**
	 * Returns an operation's typed argument list as a string.
	 * 
	 * @param op the operation
	 * 
	 * @return the argument list string
	 */
	public String getTypedArgumentList(Operation op) {
		String signature = "";
		for (VarDecl arg : op.getArguments()) {
			if (signature.isEmpty())
				signature = arg.getName()+": "+arg.getRefType().getType().getName();
			else
				signature += ", "+arg.getName()+": "+arg.getRefType().getType().getName();
		}
		signature = "("+signature+")";
		return signature;
	}
	
	/**
	 * @param code a {@link DetailCode}
	 * @return a human readable location of a detail code in the model
	 */
	public String getDetailCodeLocation(DetailCode code) {
		if (code.eContainer() instanceof Transition) {
			Transition tr = (Transition) code.eContainer();
			String where = "?";
			if (code==tr.getAction())
				where = "action";
			else if (tr instanceof CPBranchTransition && code==((CPBranchTransition)tr).getCondition())
				where = "condition";
			else if (tr instanceof GuardedTransition && code==((GuardedTransition)tr).getGuard())
				where = "guard";
			return "transition "+tr.getName()+": "+getTransitionName(tr)+" "+where+" code";
		}
		else if (code.eContainer() instanceof Trigger) {
			Transition tr = (Transition) code.eContainer().eContainer();
			return "transition "+tr.getName()+": "+getTransitionName(tr)+" trigger guard";
		}
		else if (code.eContainer() instanceof State) {
			State state = (State) code.eContainer();
			String where = "?";
			if (code==state.getEntryCode())
				where = "entry";
			else if (code==state.getExitCode())
				where = "exit";
			else
				where = "do";
			return "state "+getStatePathName(state)+" "+where+" code";
		}
		else if (code.eContainer() instanceof Operation) {
			return "operation "+getSignature(((Operation)code.eContainer()));
		}
		else {
			assert(false): "unexpected detaild code location";
			return "???";
		}
	}

	/**
	 * @param ep a {@link BindingEndPoint}
	 * @return a human readable name for the end point
	 */
	public String getDisplayName(BindingEndPoint ep) {
		if (ep.getSub()!=null)
			return ep.getPort().getName()+" sub "+ep.getSub().getName();
		else
			return ep.getPort().getName();
	}

	/**
	 * @param bind a {@link Binding}
	 * @return a human readable name for the binding
	 */
	public String getDisplayName(Binding bind) {
		return getDisplayName(bind.getEndpoint1())+" and "+getDisplayName(bind.getEndpoint2());
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
}
