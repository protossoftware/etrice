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
import org.eclipse.emf.ecore.util.ComposedSwitch;
import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.fsm.fSM.GuardedTransition;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem;
import org.eclipse.etrice.core.fsm.fSM.Transition;
import org.eclipse.etrice.core.fsm.fSM.Trigger;
import org.eclipse.etrice.core.fsm.naming.FSMNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.room.util.RoomSwitch;

import com.google.inject.Inject;


/**
 * A class providing names for instances of central types of the ROOM model.
 * 
 * @author Henrik Rentz-Reichert
 */
public class RoomNameProvider extends FSMNameProvider {
	
	@Inject
	protected RoomHelpers roomHelpers;
	
	/**
	 * @author Henrik Rentz-Reichert
	 *
	 */
	protected class RoomProvider extends RoomSwitch<String> {
		@Override
		public String caseActorRef(org.eclipse.etrice.core.room.ActorRef object) { return "ActorRef '"+object.getName()+"'"; }
		@Override
		public String casePort(org.eclipse.etrice.core.room.Port object) { return "Port '"+object.getName()+"'"; }
		@Override
		public String caseSAP(org.eclipse.etrice.core.room.SAP object) { return "SAP '"+object.getName()+"'"; }
		@Override
		public String caseSPP(org.eclipse.etrice.core.room.SPP object) { return "SPP '"+object.getName()+"'"; }
		@Override
		public String caseActorClass(ActorClass object) { return "ActorClass "+object.getName(); }
		@Override
		public String caseSubSystemClass(SubSystemClass object) { return "SubsystemClass "+object.getName(); }
	}
	
	private class CombinedProvider  extends ComposedSwitch<String> {
		public CombinedProvider() {
			addSwitch(new RoomProvider());
			addSwitch(new FSMProvider());
		}
	}
	private CombinedProvider roomNameProvider = new CombinedProvider();
	
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
	@Override
	public String getName(EObject item) {
		String name = roomNameProvider.doSwitch(item);
		if (name==null)
			name = item.toString();
		return name;
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
		String clsLocation = getClassLocation(roomHelpers.getRoomClass(source));
		
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
}
