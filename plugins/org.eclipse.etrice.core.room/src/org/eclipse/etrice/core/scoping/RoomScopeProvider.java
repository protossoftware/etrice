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

package org.eclipse.etrice.core.scoping;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.BaseState;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InMessageHandler;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.OutMessageHandler;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;


/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class RoomScopeProvider extends AbstractDeclarativeScopeProvider {
	
	public static final String STATE_PATH_DELIMITER = ".";

	/**
	 * first container of type {@link StateGraph} ({@link State}, {@link StateMachine})
	 * @param obj
	 * @return StateGraph Container
	 */
	private StateGraph getStateGraph(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof StateGraph) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof StateGraph)
			return (StateGraph) ctx;
		
		return null;
	}
	
	/**
	 * first container of type {@link ActorClass}
	 * @param obj
	 * @return ActorClass container
	 */
	private ActorClass getActorClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof ActorClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof ActorClass)
			return (ActorClass) ctx;
		
		return null;
	}
	
	/**
	 * first container of type {@link ActorClass}
	 * @param obj
	 * @return ActorClass container
	 */
	private ActorContainerClass getActorContainerClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof ActorContainerClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof ActorContainerClass)
			return (ActorContainerClass) ctx;
		
		return null;
	}

	/**
	 * check whether port is referenced by external port
	 * @param p - port to be checked
	 * @param ports - list of external ports
	 * @return true if contained
	 */
	private boolean isContained(Port p, EList<ExternalPort> ports) {
		for (ExternalPort port : ports) {
			if (port.getIfport()==p)
				return true;
		}
		return false;
	}
	
	/**
	 * recursively collect all {@link BaseState}s of an actor class in a list
	 * @param ac
	 * @param states
	 */
	private void collectAllStates(ActorClass ac,
			LinkedList<BaseState> states) {
		while (ac!=null) {
			collectStates(ac.getStateMachine(), states);
			ac = ac.getBase();
		}
	}

	private void collectStates(StateGraph sg,
			LinkedList<BaseState> states) {
		
		if (sg==null)
			return;
		
		for (State s : sg.getStates()) {
			if (s instanceof BaseState)
				states.add((BaseState) s);
		}
		for (State s : sg.getStates()) {
			collectStates(s.getSubgraph(), states);
		}
	}

	/**
	 * compute the path of a {@link BaseState}
	 * @param bs
	 * @return the path
	 */
	private QualifiedName getStatePath(BaseState bs) {
		EObject parent = bs.eContainer().eContainer();
		if (parent instanceof BaseState)
			return getStatePath((BaseState) parent).append(bs.getName());
		else if (parent instanceof RefinedState) {
			BaseState base = ((RefinedState) parent).getBase();
			if (base!=null)
				return getStatePath(base).append(bs.getName());
		}
		return QualifiedName.create(bs.getName());
	}
	
	/**
	 * return a list of base classes of an {@link ActorClass}, parent classes first.
	 * The list includes the class itself
	 * @param ac
	 * @return
	 */
	private LinkedList<ActorClass> getBaseClasses(ActorClass ac) {
		LinkedList<ActorClass> classes = new LinkedList<ActorClass>();
		if (ac!=null) {
			classes.addFirst(ac);
			while (ac.getBase()!=null) {
				if (ac==ac.getBase())
					// avoid endless loop - circularity in class hierarchy detected elsewhere
					break;

				ac = ac.getBase();
				classes.addFirst(ac);
			}	
		}
		return classes;
	}
	
	/**
	 * return a list of base classes of an {@link ProtocolClass}, parent classes first.
	 * The list includes the class itself
	 * @param pc
	 * @return
	 */
	private LinkedList<ProtocolClass> getBaseClasses(ProtocolClass pc) {
		LinkedList<ProtocolClass> classes = new LinkedList<ProtocolClass>();
		classes.addFirst(pc);
		while (pc.getBase()!=null) {
			pc = pc.getBase();
			classes.addFirst(pc);
		}
		return classes;
	}

	/**
	 * return the {@link BaseState} of a {@link State}
	 * @param s
	 * @return the state itself if a BaseState or the BaseState for a {@link RefinedState}
	 */
	private BaseState getBaseState(State s) {
		if (s instanceof BaseState)
			return (BaseState) s;
		else if (s instanceof RefinedState)
			return ((RefinedState) s).getBase();
		else
			return null;
	}

	private IScope getStateScopes(EObject obj) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		// first state in container hierarchy
		StateGraph parent = getStateGraph(obj);
		
		// collect states of my parent
		if (parent!=null) {
			for (State s : parent.getStates()) {
				BaseState bs = getBaseState(s);
				scopes.add(EObjectDescription.create(bs.getName(), bs));
			}
		
			// if my parent is a refined state we also add its base state contents
			if (parent.eContainer() instanceof RefinedState) {
				parent = ((RefinedState) parent.eContainer()).getBase().getSubgraph();
				if (parent!=null)
					for (State s : parent.getStates()) {
						BaseState bs = getBaseState(s);
						scopes.add(EObjectDescription.create(bs.getName(), bs));
					}
			}
			else if (parent.eContainer() instanceof ActorClass) {
				ActorClass ac = (ActorClass) parent.eContainer();
				if (ac.getBase()!=null) {
					for (State s : ac.getBase().getStateMachine().getStates()) {
						BaseState bs = getBaseState(s);
						scopes.add(EObjectDescription.create(bs.getName(), bs));
					}
				}
			}
		}
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of State scopes for a {@link StateTerminal}
	 * @param st - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_StateTerminal_state(StateTerminal st, EReference ref) {
		return getStateScopes(st);
	}

	/**
	 * returns a flat list of TransitionPoint scopes for a {@link TrPointTerminal}
	 * @param ep - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_TrPointTerminal_trPoint(TrPointTerminal ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		StateGraph parent = getStateGraph(ep);
		StateGraph targetStateGraph = parent;
		
		getTrPointScopes(scopes, targetStateGraph);
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of TransitionPoint scopes for a {@link SubStateTrPointTerminal}
	 * @param ep - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_SubStateTrPointTerminal_trPoint(SubStateTrPointTerminal ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		StateGraph parent = getStateGraph(ep);
		StateGraph targetStateGraph = parent;
		if (ep.getState()!=null) {
			targetStateGraph = ep.getState().getSubgraph();	// always a BaseState
			
			// if one of our siblings is a RefinedState of our target we take that as target
			for (State sibling : parent.getStates()) {
				if (sibling instanceof RefinedState) {
					if (((RefinedState)sibling).getBase()==ep.getState())
						targetStateGraph = sibling.getSubgraph();
				}
			}
		}
		
		if (targetStateGraph!=null)
			getTrPointScopes(scopes, targetStateGraph);
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	private void getTrPointScopes(final List<IEObjectDescription> scopes,
			StateGraph sg) {
		
		// collect transition points of this state
		for (TrPoint tp : sg.getTrPoints()) {
			scopes.add(EObjectDescription.create(tp.getName(), tp));
		}
		
		// if this state is a refined state we also add its base state transition points
		if (sg.eContainer() instanceof RefinedState) {
			sg = ((RefinedState) sg.eContainer()).getBase().getSubgraph();
			if (sg!=null)
				for (TrPoint tp : sg.getTrPoints()) {
					scopes.add(EObjectDescription.create(tp.getName(), tp));
				}
		}
	}

	/**
	 * returns a flat list of State scopes for a {@link SubStateTrPointTerminal}
	 * @param st - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_SubStateTrPointTerminal_state(SubStateTrPointTerminal st, EReference ref) {
		return getStateScopes(st);
	}

	/**
	 * returns a flat list of Choicepoint scopes for a {@link SubStateTrPointTerminal}
	 * @param ct - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_ChoicepointTerminal_cp(ChoicepointTerminal ct, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		// first state in container hierarchy
		StateGraph parent = getStateGraph(ct);
		
		// collect choicepoints of my parent
		if (parent!=null)
			for (ChoicePoint cp : parent.getChPoints()) {
				scopes.add(EObjectDescription.create(cp.getName(), cp));
			}
		
		// if my parent is a refined state we also add its base state contents
		if (parent.eContainer() instanceof RefinedState) {
			parent = ((RefinedState) parent.eContainer()).getBase().getSubgraph();
			if (parent!=null)
				for (ChoicePoint cp : parent.getChPoints()) {
					scopes.add(EObjectDescription.create(cp.getName(), cp));
				}
		}
		else if (parent.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) parent.eContainer();
			if (ac.getBase()!=null) {
				for (ChoicePoint cp : ac.getBase().getStateMachine().getChPoints()) {
					scopes.add(EObjectDescription.create(cp.getName(), cp));
				}
			}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of Message scopes for a {@link MessageFromIf}
	 * @param mfi - the message from interface
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_MessageFromIf_message(MessageFromIf mfi, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		InterfaceItem item = mfi.getFrom();
		if (item!=null) {
			ProtocolClass protocol = item.getProtocol();
			boolean conjugated = false;
			if (item instanceof Port)
				conjugated = ((Port)item).isConjugated();
			else if (item instanceof SAPRef)
				conjugated = true;
			for (Message msg : conjugated?protocol.getOutgoingMessages():protocol.getIncomingMessages()) {
				scopes.add(EObjectDescription.create(msg.getName(), msg));
			}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of Port scopes for a {@link MessageFromIf}
	 * @param mfi - the message from interface
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_MessageFromIf_port(MessageFromIf mfi, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(mfi);
		for (Port p : ac.getIntPorts()) {
			scopes.add(EObjectDescription.create(p.getName(), p));
		}
		for (ExternalPort p : ac.getExtPorts()) {
			scopes.add(EObjectDescription.create(p.getIfport().getName(), p.getIfport()));
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	/**
	 * returns a flat list of InterfaceItem scopes for a {@link MessageFromIf}
	 * @param mfi - the message from interface
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_MessageFromIf_from(MessageFromIf mfi, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(mfi);
		List<InterfaceItem> items = RoomHelpers.getAllInterfaceItems(ac);
		
		for (InterfaceItem item : items) {
			scopes.add(EObjectDescription.create(item.getName(), item));
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of ActorRef scopes for a {@link BindingEndPoint}
	 * @param ep - the endpoint
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_BindingEndPoint_actorRef(BindingEndPoint ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorContainerClass sc = getActorContainerClass(ep);
		if (sc instanceof ActorClass) {
			LinkedList<ActorClass> classes = getBaseClasses((ActorClass)sc);
			for (ActorClass a : classes) {
				for (ActorRef ar : a.getActorRefs()) {
					scopes.add(EObjectDescription.create(ar.getName(), ar));
				}
			}
		}
		else {
			for (ActorRef ar : sc.getActorRefs()) {
				scopes.add(EObjectDescription.create(ar.getName(), ar));
			}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	/**
	 * returns a flat list of Port scopes for a {@link BindingEndPoint}
	 * @param ep - the endpoint
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_BindingEndPoint_port(BindingEndPoint ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorContainerClass acc = getActorContainerClass(ep);
		
		if (ep.getActorRef() == null){
			if (acc instanceof ActorClass) {
				ActorClass ac = (ActorClass) acc;
				// for all super classes (including this class)
				LinkedList<ActorClass> classes = getBaseClasses(ac);
				for (ActorClass a : classes) {
					// collect internal and relay ports, i.e.
					// structure ports not in interface (internal)
					for (Port p : a.getIntPorts()) {
						scopes.add(EObjectDescription.create(p.getName(), p));
					}
					// interface ports not in structure (relay)
					for (Port p : a.getIfPorts()) {
						if (!isContained(p, a.getExtPorts()))
							scopes.add(EObjectDescription.create(p.getName(), p));
					}
				}
			}
			else {
				// SubSystemClass has no internal end ports
			}
		}
		else {
			// all ports in the sub actor's interface
			if (ep.getActorRef() instanceof ActorRef) {
				ActorClass ac = ((ActorRef)ep.getActorRef()).getType();
				LinkedList<ActorClass> classes = getBaseClasses(ac);
				for (ActorClass a : classes) {
					for (Port p : a.getIfPorts()) {
						scopes.add(EObjectDescription.create(p.getName(), p));
					}
				}
			}
			else {
				SubSystemClass ssc = ((SubSystemRef)ep.getActorRef()).getType();
				for (Port p : ssc.getRelayPorts()) {
					scopes.add(EObjectDescription.create(p.getName(), p));
				}
			}
		}
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	/**
	 * returns a flat list of BaseState scopes for a {@link RefinedState}
	 * @param rs - the refined state
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_RefinedState_base(RefinedState rs, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(rs);
		LinkedList<BaseState> states = new LinkedList<BaseState>();
		collectAllStates(ac.getBase(), states);
		for (BaseState bs : states) {
			scopes.add(EObjectDescription.create(getStatePath(bs), bs));
		}
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	/**
	 * returns a flat list of Message scopes for a {@link SemanticsInRule}
	 * @param sr - the semantics rule for incoming messages
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_SemanticsRule_msg(SemanticsRule sr, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ProtocolClass pc = RoomHelpers.getProtocolClass(sr);
		LinkedList<ProtocolClass> classes = getBaseClasses(pc);
		for (ProtocolClass bpc : classes) {
			for (Message m : bpc.getIncomingMessages()) {
				scopes.add(EObjectDescription.create(m.getName(), m));
			}
			for (Message m : bpc.getOutgoingMessages()) {
				scopes.add(EObjectDescription.create(m.getName(), m));
			}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of ActorRef scopes for a {@link SubActorSAPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	public IScope scope_RefSAPoint_ref(RefSAPoint pt, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorContainerClass acc = getActorContainerClass(pt);
		if (acc instanceof ActorClass) {
			LinkedList<ActorClass> classes = getBaseClasses((ActorClass) acc);
			for (ActorClass a : classes) {
				for (ActorRef ar : a.getActorRefs()) {
					scopes.add(EObjectDescription.create(ar.getName(), ar));
				}
			}
		}
		else {
			for (ActorRef ar : acc.getActorRefs()) {
				scopes.add(EObjectDescription.create(ar.getName(), ar));
			}
		}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of SPPRef scopes for a {@link RelaySAPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	public IScope scope_RelaySAPoint_relay(RelaySAPoint pt, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(pt);
		LinkedList<ActorClass> classes = getBaseClasses(ac);
		for (ActorClass a : classes) {
			for (SPPRef spp : a.getIfSPPs()) {
				scopes.add(EObjectDescription.create(spp.getName(), spp));
			}
		}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of ActorRef scopes for a {@link SPPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	public IScope scope_SPPoint_actorRef(SPPoint pt, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorContainerClass acc = getActorContainerClass(pt);
		if (acc instanceof ActorClass) {
			LinkedList<ActorClass> classes = getBaseClasses((ActorClass)acc);
			for (ActorClass a : classes) {
				for (ActorRef ar : a.getActorRefs()) {
					scopes.add(EObjectDescription.create(ar.getName(), ar));
				}
			}
		}
		else {
			for (ActorRef ar : acc.getActorRefs()) {
				scopes.add(EObjectDescription.create(ar.getName(), ar));
			}
		}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of SPPRef scopes for a {@link SPPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	public IScope scope_SPPoint_service(SPPoint pt, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		if (pt.getRef()!=null) {
			if (pt.getRef() instanceof ActorRef) {
				ActorClass ac = ((ActorRef)pt.getRef()).getType();
				LinkedList<ActorClass> classes = getBaseClasses(ac);
				for (ActorClass a : classes) {
					for (SPPRef spp : a.getIfSPPs()) {
						scopes.add(EObjectDescription.create(spp.getName(), spp));
					}
				}
			}
			else if (pt.getRef() instanceof SubSystemRef) {
				SubSystemClass ssc = ((SubSystemRef)pt.getRef()).getType();
				for (SPPRef spp : ssc.getIfSPPs()) {
					scopes.add(EObjectDescription.create(spp.getName(), spp));
				}
			}
		}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	public IScope scope_MessageHandler_msg(MessageHandler handler, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ProtocolClass pc = RoomHelpers.getProtocolClass(handler);
		if (pc!=null) {
			if (handler instanceof InMessageHandler)
				for (Message m : pc.getIncomingMessages()) {
					scopes.add(EObjectDescription.create(m.getName(), m));
				}
			if (handler instanceof OutMessageHandler)
				for (Message m : pc.getOutgoingMessages()) {
					scopes.add(EObjectDescription.create(m.getName(), m));
				}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	public IScope scope_PortOperation_sendsMsg(PortOperation op, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		PortClass pcls = (PortClass) op.eContainer();
		ProtocolClass pc = RoomHelpers.getProtocolClass(op);
		if (pc!=null) {
			if (pcls==pc.getConjugate())
				for (Message m : pc.getIncomingMessages()) {
					scopes.add(EObjectDescription.create(m.getName(), m));
				}
			else
				for (Message m : pc.getOutgoingMessages()) {
					scopes.add(EObjectDescription.create(m.getName(), m));
				}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/*
	 * we prefer loose scoping here and rely on validation for meaningful error messages
	 * 
	 * returns a flat list of ActorClass scopes for a {@link ActorRef}
	 * @param ar - the actor reference
	 * @param ref - not used
	 * @return a list of scopes
	 */
//	public IScope scope_ActorRef_type(ActorRef ar, EReference ref) {
//		ActorClass ac = getActorClass(ar);
//		IScope scope = delegateGetScope(ar, ref);
//		return new FilteringScope(scope, new ActorRefFilter(ac));
//	}

	/**
	 * returns a flat list of Port scopes for a {@link ExternalPort}
	 * @param ar - the external port
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_ExternalPort_ifport(ExternalPort ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		ActorClass ac = getActorClass(ep);
		for (Port ip : ac.getIfPorts()) {
			scopes.add(EObjectDescription.create(ip.getName(), ip));
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	/**
	 * returns a flat list of Port scopes for a {@link ExternalPort}
	 * @param ar - the external port
	 * @param ref - not used
	 * @return a list of scopes
	 */
//	public IScope scope_ActorInstance_segments(ActorInstance ai, EReference ref) {
//		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
//		
//		if (ai.getSegments().isEmpty()) {
//			// context is my ActorContainerClass
//			ActorContainerClass acc = getActorContainerClass(ai);
//			for (ActorRef ar : acc.getActorRefs()) {
//				scopes.add(EObjectDescription.create(ar.getName(), ar));
//			}
//		}
//		else {
//			// context is actor class of last segment
//			ActorClass ac = ai.getSegments().get(ai.getSegments().size()-1).getType();
//			for (ActorRef ar : ac.getActorRefs()) {
//				scopes.add(EObjectDescription.create(ar.getName(), ar));
//			}
//		}
//		
//		return new SimpleScope(IScope.NULLSCOPE, scopes);
//	}
	
	/*
	public IScope scope_ChoicePointCaseRef_case(ChoicePointCaseRef cr, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		if (cr.getCp()!=null) {
			for (ChoicePointCase cas : cr.getCp().getCases()) {
				scopes.add(EObjectDescription.create(cas.getName(), cas));
			}
		}
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}*/
}
