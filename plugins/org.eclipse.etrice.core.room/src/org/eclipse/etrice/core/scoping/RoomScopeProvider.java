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
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InMessageHandler;
import org.eclipse.etrice.core.room.InSemanticsRule;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.MessageHandler;
import org.eclipse.etrice.core.room.OutMessageHandler;
import org.eclipse.etrice.core.room.OutSemanticsRule;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RefinedTransition;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.SemanticsRule;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.inject.Inject;


/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class RoomScopeProvider extends AbstractDeclarativeScopeProvider {

	@Inject
	private RoomHelpers roomHelpers;
	
	public static final String STATE_PATH_DELIMITER = ".";

	@Inject
	private IQualifiedNameProvider nameProvider;
	
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
	 * first container of type {@link StructureClass}
	 * @param obj
	 * @return StructureClass container
	 */
	private StructureClass getStructureClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof StructureClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof StructureClass)
			return (StructureClass) ctx;
		
		return null;
	}

	/**
	 * compute the path of a {@link BaseState}
	 * @param bs
	 * @return the path
	 */
	private QualifiedName getStatePath(State bs) {
		EObject parent = bs.eContainer().eContainer();
		if (parent instanceof SimpleState)
			return getStatePath((SimpleState) parent).append(bs.getName());
		else if (parent instanceof RefinedState) {
			State target = ((RefinedState) parent).getTarget();
			if (target!=null)
				return getStatePath(target).append(bs.getName());
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
	 * returns a flat list of State scopes for a {@link StateTerminal}
	 * @param st - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_StateTerminal_state(StateTerminal st, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		// first state graph in container hierarchy
		StateGraph parent = getStateGraph(st);
		getStateScopes(parent, scopes);

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * @param parent
	 * @param scopes
	 */
	private void getStateScopes(StateGraph parent, final List<IEObjectDescription> scopes) {
		List<State> states = roomHelpers.getAllStates(parent);
		HashMap<String, SimpleState> name2state = new HashMap<String, SimpleState>();
		for (State s : states) {
			// returning SimpleStates only simplifies the relocation task in the generator model:
			// there we shuffle RefinedState contents to SimpleStates and remove the RefinedStates.
			// If we had references to RefinedStates we had to redirect those
			name2state.put(s.getName(), roomHelpers.getBaseState(s));
		}
		for (Entry<String, SimpleState> entry : name2state.entrySet()) {
			scopes.add(EObjectDescription.create(entry.getKey(), entry.getValue()));
		}
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
		List<TrPoint> tps = roomHelpers.getAllTrPoints(parent);
		for (TrPoint tp : tps) {
			scopes.add(EObjectDescription.create(tp.getName(), tp));
		}
		
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
		if (ep.getState()!=null) {
			State epState = ep.getState();
			
			// check if there is a refined state for this state
			epState = roomHelpers.getRefinedStateFor(parent, epState);
			
			if (epState.getSubgraph()!=null) {
				List<TrPoint> tps = roomHelpers.getAllTrPoints(epState.getSubgraph());
				for (TrPoint tp : tps) {
					scopes.add(EObjectDescription.create(tp.getName(), tp));
				}
			}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of State scopes for a {@link SubStateTrPointTerminal}
	 * @param st - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_SubStateTrPointTerminal_state(SubStateTrPointTerminal st, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		// first state graph in container hierarchy
		StateGraph parent = getStateGraph(st);
		getStateScopes(parent, scopes);
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of Choicepoint scopes for a {@link SubStateTrPointTerminal}
	 * @param ct - the transition endpoint or terminal
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_ChoicepointTerminal_cp(ChoicepointTerminal ct, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		// first state graph in container hierarchy
		StateGraph parent = getStateGraph(ct);
		List<ChoicePoint> choicePoints = roomHelpers.getAllChoicePoints(parent);
		for (ChoicePoint cp : choicePoints) {
			scopes.add(EObjectDescription.create(cp.getName(), cp));
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
			ProtocolClass protocol = null;
			boolean conjugated = false;
			if (item instanceof Port && ((Port)item).getProtocol() instanceof ProtocolClass) {
				protocol = (ProtocolClass) ((Port)item).getProtocol();
				conjugated = ((Port)item).isConjugated();
			}
			else if (item instanceof SAP) {
				protocol = ((SAP)item).getProtocol();
				conjugated = true;
			}
			else if (item instanceof SPP) {
				protocol = ((SPP)item).getProtocol();
				conjugated = false;
			}
			
			if (protocol!=null)
				for (Message msg : conjugated?roomHelpers.getAllMessages(protocol,false):roomHelpers.getAllMessages(protocol,true)) {
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
		for (Port p : ac.getInternalPorts()) {
			scopes.add(EObjectDescription.create(p.getName(), p));
		}
		for (ExternalPort p : ac.getExternalPorts()) {
			scopes.add(EObjectDescription.create(p.getInterfacePort().getName(), p.getInterfacePort()));
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
		List<InterfaceItem> items = roomHelpers.getAllInterfaceItems(ac);
		
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
		
		StructureClass sc = getStructureClass(ep);
		if (sc instanceof ActorClass) {
			LinkedList<ActorClass> classes = getBaseClasses((ActorClass)sc);
			for (ActorClass a : classes) {
				for (ActorRef ar : a.getActorRefs()) {
					scopes.add(EObjectDescription.create(ar.getName(), ar));
				}
			}
		}
		else if (sc instanceof SubSystemClass){
			for (ActorRef ar : ((SubSystemClass) sc).getActorRefs()) {
				scopes.add(EObjectDescription.create(ar.getName(), ar));
			}
		}
		else {
			LogicalSystem ls = (LogicalSystem) sc;
			for (SubSystemRef ssr : ls.getSubSystems()) {
				scopes.add(EObjectDescription.create(ssr.getName(), ssr));
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
		
		StructureClass sc = getStructureClass(ep);
		
		if (ep.getActorRef() == null){
			if (sc instanceof ActorClass) {
				ActorClass ac = (ActorClass) sc;
				// for all super classes (including this class)
				LinkedList<ActorClass> classes = getBaseClasses(ac);
				for (ActorClass a : classes) {
					// collect internal and relay ports, i.e.
					// structure ports not in interface (internal)
					for (Port p : a.getInternalPorts()) {
						scopes.add(EObjectDescription.create(p.getName(), p));
					}
					// interface ports not in structure (relay)
					for (Port p : a.getRelayPorts()) {
						scopes.add(EObjectDescription.create(p.getName(), p));
					}
				}
			}
			else if (sc instanceof SubSystemClass) {
				SubSystemClass ssc = (SubSystemClass) sc;
				for (Port p : ssc.getRelayPorts()) {
					scopes.add(EObjectDescription.create(p.getName(), p));
				}
			}
		}
		else {
			// all ports in the sub actor's interface
			if (ep.getActorRef() instanceof ActorRef) {
				ActorClass ac = ((ActorRef)ep.getActorRef()).getType();
				LinkedList<ActorClass> classes = getBaseClasses(ac);
				for (ActorClass a : classes) {
					for (Port p : a.getInterfacePorts()) {
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
	 * returns a flat list of SubProtocol scopes for a {@link BindingEndPoint}
	 * @param ep - the endpoint
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_BindingEndPoint_sub(BindingEndPoint ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		if (ep.getPort()!=null) {
			if (ep.getPort().getProtocol() instanceof CompoundProtocolClass) {
				CompoundProtocolClass pc = (CompoundProtocolClass) ep.getPort().getProtocol();

				for (SubProtocol sub : pc.getSubProtocols()) {
					scopes.add(EObjectDescription.create(sub.getName(), sub));
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
	public IScope scope_RefinedState_target(RefinedState rs, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(rs);
		StateGraph sg = getStateGraph(rs);
		if (sg.eContainer() instanceof ActorClass) {
			if (ac.getBase()!=null) {
				ac = ac.getBase();
				HashSet<State> covered = new HashSet<State>();
				ArrayList<State> states = new ArrayList<State>();
				while (ac!=null) {
					recursivelyAddStates(ac.getStateMachine(), covered, states);
					ac = ac.getBase();
				}
				for (State s : states) {
					scopes.add(EObjectDescription.create(getStatePath(s), s));
				}
			}
		}
		else if (sg.eContainer() instanceof RefinedState) {
			sg = ((RefinedState) sg.eContainer()).getTarget().getSubgraph();
			if (sg!=null)
				for (State s : sg.getStates()) {
					scopes.add(EObjectDescription.create(s.getName(), s));
				}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	
	/**
	 * returns a flat list of Transition scopes for a {@link RefinedTransition}
	 * @param trans - the refined transition
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_RefinedTransition_target(RefinedTransition trans, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(trans);
		ac = ac.getBase();
		while (ac!=null) {
			if (ac.getStateMachine()!=null) {
				int acNameSegments = nameProvider.getFullyQualifiedName(ac).getSegmentCount();
				TreeIterator<EObject> it = ac.getStateMachine().eAllContents();
				while (it.hasNext()) {
					EObject obj = it.next();
					if (obj instanceof Transition) {
						// use qualified name but skip ac FQN and also omit state machine name 'sm'
						scopes.add(EObjectDescription.create(nameProvider.getFullyQualifiedName(obj).skipFirst(acNameSegments+1), obj));
					}
				}
			}
			ac = ac.getBase();
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}
	/**
	 * @param sg
	 * @param covered
	 * @param states
	 */
	private void recursivelyAddStates(StateGraph sg, HashSet<State> covered, ArrayList<State> states) {
		for (State s : sg.getStates()) {
			if (s instanceof SimpleState && !covered.contains(s)) {
				states.add(s);
			}
			else if (s instanceof RefinedState && !covered.contains(s)) {
				states.add(s);
				covered.add(((RefinedState) s).getTarget());
			}
		}
		
		// recursion
		for (State s : sg.getStates()) {
			if (s.getSubgraph()!=null)
				recursivelyAddStates(s.getSubgraph(), covered, states);
		}
	}
	
	/**
	 * returns a flat list of Message scopes for a {@link InSemanticsRule}
	 * @param sr - the semantics rule for incoming messages
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_SemanticsRule_msg(SemanticsRule sr, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ProtocolClass pc = roomHelpers.getProtocolClass(sr);
		LinkedList<ProtocolClass> classes = getBaseClasses(pc);
		for (ProtocolClass bpc : classes) {
			if (sr instanceof InSemanticsRule)
				for (Message m : bpc.getIncomingMessages()) {
					scopes.add(EObjectDescription.create(m.getName(), m));
				}
			if (sr instanceof OutSemanticsRule)
				for (Message m : bpc.getOutgoingMessages()) {
					scopes.add(EObjectDescription.create(m.getName(), m));
				}
		}
		
		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	/**
	 * returns a flat list of ActorRef scopes for a {@link RefSAPoint}
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
	 * returns a flat list of SPP scopes for a {@link RelaySAPoint}
	 * @param pt
	 * @param ref
	 * @return a list of scopes
	 */
	public IScope scope_RelaySAPoint_relay(RelaySAPoint pt, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ActorClass ac = getActorClass(pt);
		LinkedList<ActorClass> classes = getBaseClasses(ac);
		for (ActorClass a : classes) {
			for (SPP spp : a.getServiceProvisionPoints()) {
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
	 * returns a flat list of SPP scopes for a {@link SPPoint}
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
					for (SPP spp : a.getServiceProvisionPoints()) {
						scopes.add(EObjectDescription.create(spp.getName(), spp));
					}
				}
			}
			else if (pt.getRef() instanceof SubSystemRef) {
				SubSystemClass ssc = ((SubSystemRef)pt.getRef()).getType();
				for (SPP spp : ssc.getServiceProvisionPoints()) {
					scopes.add(EObjectDescription.create(spp.getName(), spp));
				}
			}
		}

		return new SimpleScope(IScope.NULLSCOPE, scopes);
	}

	public IScope scope_MessageHandler_msg(MessageHandler handler, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();
		
		ProtocolClass pc = roomHelpers.getProtocolClass(handler);
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
		ProtocolClass pc = roomHelpers.getProtocolClass(op);
		if (pc!=null) {
			if (pcls==pc.getConjugated())
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
	 * @param ep - the external port
	 * @param ref - not used
	 * @return a list of scopes
	 */
	public IScope scope_ExternalPort_ifport(ExternalPort ep, EReference ref) {
		final List<IEObjectDescription> scopes = new ArrayList<IEObjectDescription>();

		ActorClass ac = getActorClass(ep);
		for (Port ip : ac.getInterfacePorts()) {
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
