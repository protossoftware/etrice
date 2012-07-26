/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core.room.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.naming.RoomNameProvider;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DataType;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.GeneralProtocolClass;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.KeyValue;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefableType;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.Trigger;
import org.eclipse.etrice.core.room.VarDecl;
import org.eclipse.etrice.core.validation.ValidationUtil;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class RoomHelpers {
	
	public static List<InterfaceItem> getInterfaceItems(StructureClass sc, boolean includeInherited) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		
		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getIfSPPs());
				result.addAll(ac.getIfPorts());
				ac = ac.getBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getIfSPPs());
			result.addAll(((SubSystemClass) sc).getRelayPorts());
		}
		else if (sc instanceof LogicalSystem) {
			// has no interface items
		}
		else {
			assert(false): "unexpected sub type";
		}
		
		return result;
	}

	public static List<ActorContainerRef> getRefs(StructureClass sc, boolean includeInherited) {
		ArrayList<ActorContainerRef> result = new ArrayList<ActorContainerRef>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getActorRefs());
				ac = ac.getBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getActorRefs());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getSubSystems());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	public static List<Binding> getBindings(StructureClass sc, boolean includeInherited) {
		ArrayList<Binding> result = new ArrayList<Binding>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getBindings());
				ac = ac.getBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getBindings());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getBindings());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	public static List<LayerConnection> getConnections(StructureClass sc, boolean includeInherited) {
		ArrayList<LayerConnection> result = new ArrayList<LayerConnection>();

		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass) sc;
			do {
				result.addAll(ac.getConnections());
				ac = ac.getBase();
			}
			while (includeInherited && ac!=null);
		}
		else if (sc instanceof SubSystemClass) {
			result.addAll(((SubSystemClass) sc).getConnections());
		}
		else if (sc instanceof LogicalSystem) {
			result.addAll(((LogicalSystem) sc).getConnections());
		}
		else {
			assert(false): "unexpected sub type";
		}

		return result;
	}
	
	public static List<EObject> getContainedObjects(StructureClass sc) {
		ArrayList<EObject> result = new ArrayList<EObject>();
		
		result.addAll(getInterfaceItems(sc, true));
		result.addAll(getRefs(sc, true));
		result.addAll(getBindings(sc, true));
		result.addAll(getConnections(sc, true));
		
		return result;
	}

	public static String getDeepUserCode1(DataClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.DATA_CLASS__USER_CODE1);
	}

	public static String getDeepUserCode2(DataClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.DATA_CLASS__USER_CODE2);
	}

	public static String getDeepUserCode3(DataClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.DATA_CLASS__USER_CODE3);
	}

	public static String getDeepUserCode1(ProtocolClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.PROTOCOL_CLASS__USER_CODE1);
	}

	public static String getDeepUserCode2(ProtocolClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.PROTOCOL_CLASS__USER_CODE2);
	}

	public static String getDeepUserCode3(ProtocolClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.PROTOCOL_CLASS__USER_CODE3);
	}

	public static String getDeepUserCode1(ActorContainerClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.ACTOR_CONTAINER_CLASS__USER_CODE1);
	}

	public static String getDeepUserCode2(ActorContainerClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.ACTOR_CONTAINER_CLASS__USER_CODE2);
	}

	public static String getDeepUserCode3(ActorContainerClass ac) {
		return getDeepUserCode(ac, RoomPackage.Literals.ACTOR_CONTAINER_CLASS__USER_CODE3);
	}
	
	private static String getDeepUserCode(EObject obj, EStructuralFeature code) {
		StringBuffer result = new StringBuffer();
		
		while (obj!=null) {
			DetailCode dc = (DetailCode) obj.eGet(code);
			result.insert(0, getDetailCode(dc));
			
			if (obj instanceof ActorClass)
				obj = ((ActorClass) obj).getBase();
			else if (obj instanceof ProtocolClass)
				obj = ((ProtocolClass) obj).getBase();
			else if (obj instanceof DataClass)
				obj = ((DataClass) obj).getBase();
			else
				break;
		}

		return result.toString();
	}
	
	public static boolean hasSubStructure(State state, ActorClass ac) {
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
		
		if (ac.getStateMachine()!=null) {
			for (State s : getAllStateTrees(ac.getStateMachine())) {
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
	
	public static boolean hasDirectSubStructure(State s) {
		return !isEmpty(s.getSubgraph());
	}

	public static boolean hasNonEmptyStateMachine(ActorClass ac) {
		return !isEmpty(ac.getStateMachine());
	}
	
	public static boolean isEmpty(StateGraph sg) {
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
		
		return true;
	}

	/**
	 * @param state
	 * @param ac
	 * @return
	 */
	public static State getTargettingState(State state, ActorClass ac) {
		State targetting = state;
		for (State s : getAllStateTrees(ac.getStateMachine())) {
			State predecessor = s;
			while (predecessor instanceof RefinedState) {
				predecessor = ((RefinedState) predecessor).getTarget();
				if (predecessor==state)
					targetting = s;
			}
		}
		return targetting;
	}
	
	public static boolean hasDetailCode(DetailCode dc) {
		if (dc==null)
			return false;
		if (dc.getCommands().isEmpty())
			return false;
		
		return true;
	}

	public static boolean hasEntryCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, RoomPackage.Literals.STATE__ENTRY_CODE);
	}

	public static boolean hasExitCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, RoomPackage.Literals.STATE__EXIT_CODE);
	}

	public static boolean hasDoCode(State s, boolean includeInherited) {
		return hasDetailCode(s, includeInherited, RoomPackage.Literals.STATE__DO_CODE);
	}
	
	private static boolean hasDetailCode(State s, boolean includeInherited, EReference feature) {
		DetailCode dc = (DetailCode) s.eGet(feature);
		if (hasDetailCode(dc))
			return true;
		
		if (includeInherited && s instanceof RefinedState)
			return !getInheritedCode((RefinedState) s, feature, true /* order doesn't matter here */).getCommands().isEmpty();
		
		return false;
	}

	/**
	 * @param code a detail code
	 * @return the concatenation of all lines including new line characters (also last line)
	 */
	public static String getDetailCode(DetailCode code) {
		if (code==null || code.getCommands().isEmpty())
			return "";
		
		StringBuilder result = new StringBuilder();
		for (String cmd : code.getCommands()) {
			result.append(cmd + "\n");
		}
		return result.toString();
	}

	public static DetailCode getInheritedEntryCode(RefinedState rs) {
		return getInheritedCode(rs, RoomPackage.Literals.STATE__ENTRY_CODE, true);
	}

	public static DetailCode getInheritedExitCode(RefinedState rs) {
		return getInheritedCode(rs, RoomPackage.Literals.STATE__EXIT_CODE, false);
	}

	public static DetailCode getInheritedDoCode(RefinedState rs) {
		return getInheritedCode(rs, RoomPackage.Literals.STATE__DO_CODE, true);
	}
	
	/**
	 * @param rs
	 * @param code
	 * @return
	 */
	private static DetailCode getInheritedCode(RefinedState rs, EReference code, boolean addFront) {
		DetailCode result = RoomFactory.eINSTANCE.createDetailCode();
		State s = rs.getTarget();
		while (s!=null) {
			DetailCode dc = (DetailCode) s.eGet(code);
			if (dc!=null) {
				if (addFront)
					result.getCommands().addAll(0, dc.getCommands());
				else
					result.getCommands().addAll(dc.getCommands());
				
			}
			if (s instanceof RefinedState)
				s = ((RefinedState) s).getTarget();
			else
				break;
		}
		return result;
	}

	/**
	 * The default resolution mechanism will return a SimpleState.
	 * This methods searches for RefinedStates targeting the simple state.
	 * 
	 * @param sg the context for the search
	 * @param state the target state
	 * 
	 * @return a refined state targeting state or state itself
	 */
	public static State getRefinedStateFor(StateGraph sg, State state) {
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
		else if (sg.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) sg.eContainer();
			if (ac.getBase()!=null && ac.getBase().getStateMachine()!=null)
				return getRefinedStateFor(ac.getBase().getStateMachine(), state);
		}
		
		// nothing found, return original state
		return state;
	}

	public static boolean isGuarded(Trigger trig) {
		return trig.getGuard()!=null && RoomHelpers.hasDetailCode(trig.getGuard().getGuard());
	}

	public static List<State> getAllStates(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_States(), false);
	}

	public static List<State> getAllStateTrees(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_States(), true);
	}

	public static List<TrPoint> getAllTrPoints(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_TrPoints(), false);
	}

	public static List<ChoicePoint> getAllChoicePoints(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_ChPoints(), false);
	}

	public static List<Transition> getAllTransitions(StateGraph sg) {
		return getAllStateGraphItems(sg, RoomPackage.eINSTANCE.getStateGraph_Transitions(), false);
	}
	
	@SuppressWarnings("unchecked")
	private static <T extends StateGraphItem> List<T> getAllStateGraphItems(StateGraph sg, EReference feature, boolean recurse) {
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
			else if (sg.eContainer() instanceof ActorClass) {
				ActorClass base = ((ActorClass)sg.eContainer()).getBase();
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		
		return result;
	}
	
	public static Set<String> getAllNames(StateGraph sg) {
		return getAllNames(sg, null);
	}
	
	public static Set<String> getAllNames(StateGraph sg, StateGraphItem skip) {
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
			else if (sg.eContainer() instanceof ActorClass) {
				ActorClass base = ((ActorClass)sg.eContainer()).getBase();
				sg = base!=null? base.getStateMachine():null;
			}
			else {
				break;
			}
		}
		while (sg!=null);
		
		return result;
	}
	
	public static Set<String> getAllStateNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_States());
	}

	public static Set<String> getAllStateNames(StateGraph sg, State skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_States());
	}
	
	public static Set<String> getAllTrPointNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	public static Set<String> getAllTrPointNames(StateGraph sg, TrPoint skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_TrPoints());
	}
	
	public static Set<String> getAllChoicePointNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	public static Set<String> getAllChoicePointNames(StateGraph sg, ChoicePoint skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_ChPoints());
	}
	
	public static Set<String> getAllTransitionNames(StateGraph sg) {
		return getAllNames(sg, null, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	public static Set<String> getAllTransitionNames(StateGraph sg, Transition skip) {
		return getAllNames(sg, skip, RoomPackage.eINSTANCE.getStateGraph_Transitions());
	}
	
	private static <T extends StateGraphItem> Set<String> getAllNames(StateGraph sg, T skip, EReference feature) {
		List<T> items = RoomHelpers.getAllStateGraphItems(sg, feature, false);
		
		HashSet<String> names = new HashSet<String>();
		for (T item : items) {
			if (item!=skip)
				names.add(item.getName());
		}
		
		return names;
	}
	
	public static List<Message> getAllMessages(ProtocolClass pc, boolean incoming) {
		ArrayList<Message> result = new ArrayList<Message>();
		
		while (pc!=null) {
			if (incoming)
				result.addAll(0, pc.getIncomingMessages());
			else
				result.addAll(0, pc.getOutgoingMessages());
			
			pc = pc.getBase();
		}
		
		return result;
	}

	public static List<Attribute> getAllAttributes(ActorClass ac) {
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		
		while (ac!=null) {
			result.addAll(0, ac.getAttributes());
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static List<Attribute> getAllAttributes(DataClass dc) {
		ArrayList<Attribute> result = new ArrayList<Attribute>();
		
		while (dc!=null) {
			result.addAll(0, dc.getAttributes());
			
			dc = dc.getBase();
		}
		
		return result;
	}

	public static List<Operation> getAllOperations(ActorClass ac) {
		ArrayList<Operation> result = new ArrayList<Operation>();
		
		while (ac!=null) {
			result.addAll(0, ac.getOperations());
			
			ac = ac.getBase();
		}
		
		return result;
	}

	public static List<Operation> getAllOperations(DataClass dc) {
		ArrayList<Operation> result = new ArrayList<Operation>();
		
		while (dc!=null) {
			result.addAll(0, dc.getOperations());
			
			dc = dc.getBase();
		}
		
		return result;
	}
	
	public static List<Port> getAllEndPorts(ActorClass ac) {
		ArrayList<Port> result = new ArrayList<Port>();
		
		while (ac!=null) {
			result.addAll(ac.getIntPorts());
			for (ExternalPort p : ac.getExtPorts()) {
				result.add(p.getIfport());
			}
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static List<InterfaceItem> getAllInterfaceItems(ActorClass ac) {
		ArrayList<InterfaceItem> result = new ArrayList<InterfaceItem>();
		if (ValidationUtil.isCircularClassHierarchy(ac))
			return result;
		
		while (ac!=null) {
			result.addAll(ac.getIntPorts());
			for (ExternalPort p : ac.getExtPorts()) {
				result.add(p.getIfport());
			}
			result.addAll(ac.getStrSAPs());
			for (ServiceImplementation svc : ac.getServiceImplementations()) {
				result.add(svc.getSpp());
			}
			
			ac = ac.getBase();
		}
		
		return result;
	}
	
	public static ActorClass getActorClass(StateGraphItem item) {
		EObject parent = item;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
		}
		assert(false): "data structure broken";
		return null;
	}
	
	public static ActorClass getActorClass(EObject obj) {
		EObject parent = obj;
		while (parent!=null) {
			parent = parent.eContainer();
			if (parent instanceof ActorClass)
				return (ActorClass) parent;
		}
		return null;
	}
	
	/**
	 * first container of type {@link ProtocolClass}
	 * @param obj
	 * @return ActorClass container
	 */
	public static ProtocolClass getProtocolClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof ProtocolClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof ProtocolClass)
			return (ProtocolClass) ctx;
		
		return null;
	}
	
	public static boolean isAnnotationPresent(ActorClass ac, String name) {
		return isAnnotationPresent(ac.getAnnotations(), name);
	}
	
	public static boolean isBehaviorAnnotationPresent(ActorClass ac, String name) {
		return isAnnotationPresent(ac.getBehaviorAnnotations(), name);
	}
	
	public static boolean isAnnotationPresent(List<Annotation> annotations, String name) {
		for (Annotation annotation : annotations) {
			if (annotation.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public static List<KeyValue> getAttributes(ActorClass ac, String name) {
		return getAttributes(ac.getAnnotations(), name);
	}
	
	public static List<KeyValue> getBehaviorAttributes(ActorClass ac, String name) {
		return getAttributes(ac.getBehaviorAnnotations(), name);
	}
	
	public static List<KeyValue> getAttributes(List<Annotation> annotations, String name) {
		for (Annotation annotation : annotations) {
			if (annotation.getName().equals(name))
				return annotation.getAttributes();
		}
		return Collections.emptyList();
	}
	
	public static boolean isAttributePresent(ActorClass ac, String name, String key) {
		return isAttributePresent(ac.getAnnotations(), name, key);
	}
	
	public static boolean isBehaviorAttributePresent(ActorClass ac, String name, String key) {
		return isAttributePresent(ac.getBehaviorAnnotations(), name, key);
	}
	
	public static boolean isAttributePresent(List<Annotation> annotations, String name, String key) {
		List<KeyValue> attributes = getAttributes(annotations, name);
		for (KeyValue attrib : attributes) {
			if (attrib.getKey().equals(key))
				return true;
		}
		return false;
	}
	
	public static String getAttribute(ActorClass ac, String name, String key) {
		return getAttribute(ac.getAnnotations(), name, key);
	}
	
	public static String getBehaviorAttribute(ActorClass ac, String name, String key) {
		return getAttribute(ac.getBehaviorAnnotations(), name, key);
	}
	
	public static String getAttribute(List<Annotation> annotations, String name, String key) {
		List<KeyValue> attributes = getAttributes(annotations, name);
		for (KeyValue attrib : attributes) {
			if (attrib.getKey().equals(key))
				return attrib.getValue();
		}
		return "";
	}
	
	public static boolean isAttributePresent(Annotation annotation, String key) {
		for (KeyValue attrib : annotation.getAttributes()) {
			if (attrib.getKey().equals(key))
				return true;
		}
		return false;
	}
	
	public static String getAttribute(Annotation annotation, String key) {
		for (KeyValue attrib : annotation.getAttributes()) {
			if (attrib.getKey().equals(key))
				return attrib.getValue();
		}
		return "";
	}
	
	public static boolean hasFlatStateMachine(ActorClass ac) {
		if (isEmpty(ac.getStateMachine()))
			return false;

		if (!ac.getStateMachine().getTrPoints().isEmpty())
			return false;
		
		for (State st : ac.getStateMachine().getStates()) {
			if (hasDirectSubStructure(st))
				return false;
		}
		
		return true;
	}
	
	public static List<Message> getMessageList(InterfaceItem item, boolean outgoing) {
		ProtocolClass protocol = null;
		if (item instanceof Port) {
			if (!(((Port) item).getProtocol() instanceof ProtocolClass)) {
				// end ports (for which this is called) can have no CompoundProtocolClass
				assert(false): "unexpected protocol type";
				return null;
			}
			
			protocol = (ProtocolClass) ((Port) item).getProtocol();
			if (((Port) item).isConjugated())
				outgoing = !outgoing;
		}
		else if (item instanceof SAPRef) {
			outgoing = !outgoing;
			protocol = ((SAPRef)item).getProtocol();
		}
		else if (item instanceof SPPRef) {
			protocol = ((SPPRef)item).getProtocol();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		return outgoing? protocol.getOutgoingMessages():protocol.getIncomingMessages();
	}
	
	public static PortClass getPortClass(InterfaceItem item) {
		ProtocolClass protocol = null;
		boolean conjugated = false;
		if (item instanceof Port) {
			if (!(((Port) item).getProtocol() instanceof ProtocolClass)) {
				// end ports (for which this is called) can have no CompoundProtocolClass
				assert(false): "unexpected protocol type";
				return null;
			}
			
			protocol = (ProtocolClass) ((Port) item).getProtocol();
			conjugated = ((Port) item).isConjugated();
		}
		else if (item instanceof SAPRef) {
			protocol = ((SAPRef)item).getProtocol();
			conjugated = true;
		}
		else if (item instanceof SPPRef) {
			protocol = ((SPPRef)item).getProtocol();
		}
		else {
			assert(false): "unexpected sub type";
			return null;
		}
		
		return conjugated? protocol.getConjugate():protocol.getRegular();
	}
	
	/**
	 * returns true if this is a relay port
	 * 
	 * @param port
	 * @return true if relay port
	 */
	public static boolean isRelay(Port port) {
		ActorContainerClass acc = (ActorContainerClass) port.eContainer();
		if (acc instanceof ActorClass) {
			if (((ActorClass)acc).getIfPorts().contains(port)) {
				for (ExternalPort xp : ((ActorClass)acc).getExtPorts()) {
					if (xp.getIfport()==port)
						return false;
				}
				return true;
			}
			return false;
		}
		else
			return true;
	}

	public static boolean isConstructor(Operation op) {
		if (op instanceof PortOperation)
			return false;
		
		RoomClass cls = (RoomClass) op.eContainer();
		if (cls.getName().equals(op.getName()))
			return !((StandardOperation)op).isDestructor();
		
		return false;
	}

	public static boolean isDestructor(Operation op) {
		if (op instanceof PortOperation)
			return false;
		
		RoomClass cls = (RoomClass) op.eContainer();
		if (cls.getName().equals(op.getName()))
			return ((StandardOperation)op).isDestructor();
		
		return false;
	}
	
	public static String getSignature(Operation op) {
		/* TODO TS: create complete signature including return type and ref */
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

	public static String getArguments(Operation op) {
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
	 * return the {@link BaseState} of a {@link State}
	 * @param s
	 * @return the state itself if a BaseState or the BaseState for a {@link RefinedState}
	 */
	public static SimpleState getBaseState(State s) {
		if (s instanceof SimpleState)
			return (SimpleState) s;
		else if (s instanceof RefinedState)
			return getBaseState(((RefinedState) s).getTarget());
		else
			return null;
	}

	public static List<State> getReferencedStatesRecursively(RefinedState rs) {
		ArrayList<State> result = new ArrayList<State>();
		
		State target = rs.getTarget();
		result.add(target);
		
		if (target instanceof RefinedState) {
			List<State> refs = getReferencedStatesRecursively((RefinedState) target);
			result.addAll(refs);
		}
		
		return result;
	}
	
	public static boolean hasConstructor(ActorClass ac) {
		for (StandardOperation op : ac.getOperations()) {
			if (op.getName().equals(ac.getName()))
				if (!op.isDestructor())
					return true;
		}
		
		return false;
	}
	
	public static boolean hasDestructor(ActorClass ac) {
		for (StandardOperation op : ac.getOperations()) {
			if (op.getName().equals(ac.getName()))
				if (op.isDestructor())
					return true;
		}
		
		return false;
	}
	
	public static boolean referencesStateRecursively(RefinedState rs, State referenced) {
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
	 * @param ac
	 * @return
	 */
	public static Map<RefinedState, RefinedState> getRefinedStatesToRelocate(ActorClass ac) {
		
		// collect RefinedStates and some information
		ArrayList<RefinedState> refinedStates = new ArrayList<RefinedState>();
		ArrayList<String> paths = new ArrayList<String>();
		HashMap<String, RefinedState> path2rs = new HashMap<String, RefinedState>();
		TreeIterator<EObject> it = ac.getStateMachine().eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof RefinedState) {
				refinedStates.add((RefinedState) obj);
				String path = RoomNameProvider.getFullPath((RefinedState) obj);
				paths.add(path);
				path2rs.put(path, (RefinedState) obj);
			}
		}
		
		// we sort the paths to have paths with same beginning in descending length
		java.util.Collections.sort(paths, java.util.Collections.reverseOrder());
		
		// find the best matching context
		HashMap<RefinedState, RefinedState> rs2parent = new HashMap<RefinedState, RefinedState>();
		for (RefinedState rs : refinedStates) {
			String fullPath = RoomNameProvider.getFullPath(rs);
			for (String path : paths) {
				if (!fullPath.equals(path) && fullPath.startsWith(path) && fullPath.charAt(path.length())==RoomNameProvider.PATH_SEP.charAt(0)) {
					RefinedState parent = path2rs.get(path);
					if (!(parent.getSubgraph()!=null && parent.getSubgraph().getStates().contains(rs)))
						rs2parent.put(rs, parent);
					break;
				}
			}
		}
		return rs2parent;
	}
	
	public static ProtocolClass getProtocol(InterfaceItem item) {
		if (item instanceof Port) {
			if (((Port)item).getProtocol() instanceof ProtocolClass)
				return (ProtocolClass) ((Port)item).getProtocol();
			else
				return null;
		}
		else if (item instanceof SAPRef)
			return ((SAPRef)item).getProtocol();
		else if (item instanceof SPPRef)
			return ((SPPRef)item).getProtocol();
		
		assert(false): "unexpected sub type";
		return null;
	}
	
	public static GeneralProtocolClass getGeneralProtocol(InterfaceItem item) {
		if (item instanceof Port) {
			return ((Port)item).getProtocol();
		}
		else if (item instanceof SAPRef)
			return ((SAPRef)item).getProtocol();
		else if (item instanceof SPPRef)
			return ((SPPRef)item).getProtocol();
		
		assert(false): "unexpected sub type";
		return null;
	}

	public static String getBaseEntryCode(RefinedState state) {
		return getBaseCode(state, RoomPackage.Literals.STATE__ENTRY_CODE);
	}

	public static String getBaseExitCode(RefinedState state) {
		return getBaseCode(state, RoomPackage.Literals.STATE__EXIT_CODE);
	}
	
	private static String getBaseCode(RefinedState state, EStructuralFeature feat) {
		StringBuffer result = new StringBuffer();
		
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
	 * @param types
	 * @return
	 */
	public static RefableType getLastCommonSuperType(List<RefableType> types) {
		int nref = 0;
		int ndc = 0;
		for (RefableType rt : types) {
			if (rt==null)
				// no data
				return null;
			
			if (rt.getType() instanceof DataClass)
				++ndc;
			
			if (rt.isRef())
				++nref;
		}
		
		// all or none can be ref
		if (!(nref==0 || nref==types.size()))
			return null;
		
		if (ndc==0) {
			// in this case all types have to be the same
			DataType type = types.get(0).getType();
			for (RefableType rt : types) {
				if (rt.getType()!=type)
					return null;
			}
			return types.get(0);
		}
		else if (ndc==types.size()) {
			// in this case we have to find a common super type
			ArrayList<ArrayList<DataClass>> allSuperTypes = new ArrayList<ArrayList<DataClass>>();
			for (RefableType rt : types) {
				DataClass dc = (DataClass) rt.getType();
				ArrayList<DataClass> superTypes = new ArrayList<DataClass>();
				allSuperTypes.add(superTypes);
				
				// add base classes first
				while (dc!=null) {
					superTypes.add(0, dc);
					dc = dc.getBase();
				}
			}
			int min = allSuperTypes.get(0).size();
			DataClass common = allSuperTypes.get(0).get(0);
			for (ArrayList<DataClass> superTypes : allSuperTypes) {
				min = Math.min(min, superTypes.size());
				if (superTypes.get(0)!=common)
					return null;
			}
			
			// common is a candidate
			
			// lets try to improve
			tryImprove:
				for (int idx = 1; idx<min; ++idx) {
					DataClass better = allSuperTypes.get(0).get(idx);
					for (ArrayList<DataClass> superTypes : allSuperTypes) {
						if (superTypes.get(idx)!=better)
							break tryImprove;
					}
					common = better;
				}
			
			RefableType rt = RoomFactory.eINSTANCE.createRefableType();
			rt.setRef(nref>0);
			rt.setType(common);
			return rt;
		}
		
		return null;
	}
}
