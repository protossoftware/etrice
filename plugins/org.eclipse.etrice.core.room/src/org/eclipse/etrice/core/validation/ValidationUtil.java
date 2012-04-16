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

package org.eclipse.etrice.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.ChoicepointTerminal;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.ContinuationTransition;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.EntryPoint;
import org.eclipse.etrice.core.room.ExitPoint;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.GuardedTransition;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StateGraphItem;
import org.eclipse.etrice.core.room.StateTerminal;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubStateTrPointTerminal;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.TrPointTerminal;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.TransitionPoint;
import org.eclipse.etrice.core.room.TransitionTerminal;
import org.eclipse.etrice.core.room.TriggeredTransition;
import org.eclipse.etrice.core.room.util.RoomHelpers;

public class ValidationUtil {

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
	
	public static boolean isCircularClassHierarchy(DataClass dc) {
		HashSet<DataClass> classes = new HashSet<DataClass>();
		classes.add(dc);
		
		while (dc.getBase()!=null) {
			dc = dc.getBase();
			if (classes.contains(dc))
				return true;
			
			classes.add(dc);
		}
		
		return false;
	}

	public static boolean isCircularClassHierarchy(ProtocolClass pc) {
		HashSet<ProtocolClass> classes = new HashSet<ProtocolClass>();
		classes.add(pc);
		
		while (pc.getBase()!=null) {
			pc = pc.getBase();
			if (classes.contains(pc))
				return true;
			
			classes.add(pc);
		}
		
		return false;
	}

	/**
	 * check whether ac1 is super type of ac2 
	 * @param ac1
	 * @param ac2
	 * @return <code>true</code> if ac1 or one of its base types is identical to ac2
	 */
	private static boolean isKindOf(ActorClass ac1, ActorClass ac2) {
		if (ac2==null)
			return false;

		if (ac1==null || isCircularClassHierarchy(ac1))
			return false;
		
		while (ac1!=null) {
			if (ac2==ac1)
				return true;
			
			ac1 = ac1.getBase();
		}
		return false;
	}

	public static boolean isCircularClassHierarchy(ActorClass ac) {
		HashSet<ActorClass> classes = new HashSet<ActorClass>();
		classes.add(ac);
		
		while (ac.getBase()!=null) {
			ac = ac.getBase();
			if (classes.contains(ac))
				return true;
			
			classes.add(ac);
		}
		
		return false;
	}
	
	/**
	 * check if ref recursively is referencing ac
	 * @param ref
	 * @param ac
	 * @return <code>true</code> if ref recursively is referencing ac
	 */
	public static boolean isReferencing(ActorClass ref, ActorClass ac) {
		if (isKindOf(ref,ac))
			return true;
		
		for (ActorRef ar : ref.getActorRefs()) {
			if (isKindOf(ar.getType(), ac))
				return true;
			else if (isReferencing(ar.getType(), ac))
				return true;
		}
		return false;
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
	
	/**
	 * returns true if this port is connectable inside its parent, i.e. an internal end port or a relay port
	 * 
	 * @param port
	 * @return ok if connectable
	 */
	public static Result isConnectable(Port port, ActorContainerRef ref, StructureClass acc) {
		return isConnectable(port, ref, acc, null);
	}
	
	public static Result isConnectable(Port port, ActorContainerRef ref, StructureClass acc, Binding exclude) {
		if (!isMultipleConnectable(port, ref) && isConnected(port, ref, acc, exclude))
			return Result.error("port with multiplicity 1 is already connected");

		if (acc instanceof ActorClass) {
			for (ExternalPort xp : ((ActorClass)acc).getExtPorts()) {
				if (xp.getIfport()==port)
					return Result.error("external end ports must not be connected");
			}
		}

		return Result.ok();
	}
	
	public static boolean isMultipleConnectable(Port port, ActorContainerRef ref) {
		if (port.isReplicated())
			return true;

		if (ref!=null && ref instanceof ActorRef && ((ActorRef)ref).getSize()>1)
			return true;
		
		if (port.getProtocol().getCommType() == CommunicationType.DATA_DRIVEN) {
			if (ref == null) {
				// this port is local in the structure class
				if (isRelay(port))
					return !port.isConjugated();
				else
					return port.isConjugated();
			}
			else
				return port.isConjugated();
		}

		return false;
	}

	public static Result isValid(Binding bind) {
		return isConnectable(bind.getEndpoint1().getPort(), bind.getEndpoint1().getActorRef(), bind.getEndpoint2().getPort(), bind.getEndpoint2().getActorRef(), (StructureClass)bind.eContainer(), bind);
	}

	public static Result isConnectable(BindingEndPoint ep1, BindingEndPoint ep2, StructureClass sc) {
		return isConnectable(ep1.getPort(), ep1.getActorRef(), ep2.getPort(), ep2.getActorRef(), sc);
	}
	
	public static Result isConnectable(Port p1, ActorContainerRef ref1, Port p2, ActorContainerRef ref2, StructureClass sc) {
		return isConnectable(p1, ref1, p2, ref2, sc, null);
	}
	
	public static Result isConnectable(Port p1, ActorContainerRef ref1, Port p2, ActorContainerRef ref2, StructureClass sc, Binding exclude) {
		if (p1==p2)
			return Result.error("no self connection allowed, ports are indentical");
		
		if (p1.getProtocol()!=p2.getProtocol())
			return Result.error("protocols don't match");
		
		if (p1.getProtocol().getCommType()!=p2.getProtocol().getCommType())
			return Result.error("protocol communication types don't match");
		
		if (ref1==null && ref2==null)
			return Result.error("cannot connect two local ports");
		
		if (ref1!=null && ref2!=null) {
			if (ref1==ref2)
				return Result.error("ports of one ref must not be connected");

			// both ports are on references
			if (p1.isConjugated()==p2.isConjugated())
				return Result.error("connected sub component ports must be conjugated to each other");
			
			Result result = isConnectable(p1, ref1, sc, exclude);
			if (!result.isOk())
				return result;
			result = isConnectable(p2, ref2, sc, exclude);
			if (!result.isOk())
				return result;
		}
		else {
			// one port is an internal end port or a relay port
			Port local = ref1==null? p1:p2;
			Port sub = ref1!=null? p1:p2;
			ActorContainerRef ref = ref1!=null? ref1:ref2;
			ActorContainerClass acc = (ActorContainerClass) ref.eContainer();
			
			if (isRelay(local)) {
				if (local.isConjugated()!=sub.isConjugated())
					return Result.error("connected relay port must have same direction");

				Result result = isConnectable(local, null, acc, exclude);
				if (!result.isOk())
					return result;
				result = isConnectable(sub, ref, acc, exclude);
				if (!result.isOk())
					return result;
			}
			else {
				// local port must be an internal end port
				
				if (local.isConjugated()==sub.isConjugated())
					return Result.error("internal end port must have opposite direction");

				Result result = isConnectable(sub, ref, sc, exclude);
				if (!result.isOk())
					return result;

				result = isConnectable(local, null, sc, exclude);
				if (!result.isOk())
					return result;
			}
		}
		
		return Result.ok();
	}

	public static Result isFreeOfReferences(Port port) {
		Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(port, port.eResource().getResourceSet());
		boolean bound = false;
		boolean usedByFSM = false;
		for (Setting ref : refs) {
			if (ref.getEObject() instanceof BindingEndPoint)
				bound = true;
			else if (ref.getEObject() instanceof MessageFromIf)
				usedByFSM = true;
		}
		
		if (bound && usedByFSM)
			return Result.error("port is bound and also used by state machine (triggers)");
		else if (bound)
			return Result.error("port is bound (may be externally)");
		else if (usedByFSM)
			return Result.error("port is used by state machine (triggers)");
		
		return Result.ok();
	}

	public static boolean isReferencedAsReplicatedInModel(ActorClass ac) {
		Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(ac, ac.eResource().getResourceSet());
		for (Setting ref : refs) {
			if (ref.getEObject() instanceof ActorRef)
				return ((ActorRef)ref.getEObject()).getSize()>1;
		}
		
		return false;
	}
	
	public static boolean isConnected(Port port, ActorContainerRef ref, StructureClass sc) {
		return isConnected(port, ref, sc, null);
	}
	
	public static boolean isConnected(Port port, ActorContainerRef ref, StructureClass sc, Binding exclude) {
		for (Binding bind : sc.getBindings()) {
			if (bind!=exclude) {
				if (isEndpoint(bind.getEndpoint1(), port, ref))
					return true;
				if (isEndpoint(bind.getEndpoint2(), port, ref))
					return true;
			}
		}
		
		if (sc instanceof ActorClass) {
			if (((ActorClass)sc).getBase()!=null)
				return isConnected(port, ref, ((ActorClass)sc).getBase(), exclude);
		}
		return false;
	}

	private static boolean isEndpoint(BindingEndPoint ep, Port port, ActorContainerRef ref) {
		return ep.getActorRef()==ref && ep.getPort()==port;
	}

	public static boolean isRelay(SPPRef spp) {
		ActorContainerClass acc = (ActorContainerClass) spp.eContainer();
		if (acc instanceof ActorClass) {
			ActorClass ac = (ActorClass) acc;
			for (ServiceImplementation svc : ac.getServiceImplementations()) {
				if (svc.getSpp()==spp)
					return false;
			}
		}
		return true;
	}
	
	public static Result isValid(LayerConnection lc) {
		if (lc.getFrom() instanceof RelaySAPoint)
			return isConnectable(((RelaySAPoint)lc.getFrom()).getRelay(), null, lc.getTo().getService(), lc.getTo().getRef(), (StructureClass)lc.eContainer(), lc);
		else if (lc.getFrom() instanceof RefSAPoint)
			return isConnectable(null, ((RefSAPoint)lc.getFrom()).getRef(), lc.getTo().getService(), lc.getTo().getRef(), (StructureClass)lc.eContainer(), lc);
		else {
			assert(false): "unexpected sub type";
			return Result.error("internal error");
		}
	}
	
	public static Result isConnectable(SPPRef src, ActorContainerRef srcRef,
			SPPRef tgt, ActorContainerRef tgtRef, StructureClass ac) {
		return isConnectable(src, srcRef, tgt, tgtRef, ac, null);
	}
	
	public static Result isConnectable(SPPRef src, ActorContainerRef srcRef,
			SPPRef dst, ActorContainerRef dstRef, StructureClass sc, LayerConnection exclude) {

		if (sc==null) {
			return Result.error("internal error");
		}
		
		if ((src==null && srcRef==null) || (src!=null && srcRef!=null))
			return Result.error("source can be an own SPP _or_ a ref");
		
		if (dst==null || dstRef==null)
			return Result.error("destination must be an SPP on a ref");

		if (src!=null && isConnectedSrc(src, sc, exclude))
			return Result.error("source SPP is already connected");
		
		// the destination may be connected several times, so don't check this
		//		if (isConnectedDst(dst, dstRef, sc, exclude))
		//			return Result.error("destination SPP is already connected");
		
		
		return Result.ok();
	}

	public static boolean isConnectableSrc(SPPRef src, ActorContainerRef ref,
			StructureClass sc) {
		return isConnectableSrc(src, ref, sc, null);
	}
	
	public static boolean isConnectableSrc(SPPRef src, ActorContainerRef ref,
			StructureClass sc, LayerConnection exclude) {
		
		if (sc==null) {
			return false;
		}
		
		if ((src==null && ref==null) || (src!=null && ref!=null))
			return false;

		if (ref instanceof ActorRef)
			if (((ActorRef) ref).getSize()>1)
				return false;
		
		// in case of ref!=null no further checks possible
		// the connection is attached to an ActorContainerRef
		// which can be multiply connected
		
		if (src!=null) {
			if (isConnectedSrc(src, sc, exclude))
				return false;
		}
		
		return true;
	}

	public static boolean isReferencedInModel(SPPRef spp) {
		Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(spp, spp.eResource().getResourceSet());
		for (Setting ref : refs) {
			if (ref.getEObject() instanceof ServiceImplementation)
				return true;
			else if (ref.getEObject() instanceof RelaySAPoint)
				return true;
			else if (ref.getEObject() instanceof SPPoint)
				return true;
		}
		
		return false;
	}
	
	public static boolean isConnectedSrc(SPPRef src, StructureClass sc) {
		return isConnectedSrc(src, sc, null);
	}
	
	public static boolean isConnectedSrc(SPPRef src, StructureClass sc, LayerConnection exclude) {
		for (LayerConnection lc : sc.getConnections()) {
			if (lc!=exclude)
				if (lc.getFrom() instanceof RelaySAPoint) {
					if (((RelaySAPoint)lc.getFrom()).getRelay()==src)
						return true;
				}
		}
		
		if (sc instanceof ActorClass) {
			ActorClass ac = (ActorClass)sc;
			
			// check for attached services
			for (ServiceImplementation svc : ac.getServiceImplementations()) {
				if (svc.getSpp()==src)
					return true;
			}
			
			// recurse into base classes
			if (ac.getBase()!=null)
				return isConnectedSrc(src, ac.getBase(), exclude);
		}
		return false;
	}

	public static boolean isConnectableDst(SPPRef src, ActorContainerRef ref,
			StructureClass sc) {
		return isConnectableDst(src, ref, sc, null);
	}
	
	public static boolean isConnectableDst(SPPRef dst, ActorContainerRef ref,
			StructureClass sc, LayerConnection exclude) {
		
		if (sc==null) {
			return false;
		}
		
		if (dst==null || ref==null)
			return false;

		if (dst!=null) {
			if (isConnectedDst(dst, ref, sc, exclude))
				return false;
		}
		
		return true;
	}
	
	public static boolean isConnectedDst(SPPRef src, ActorContainerRef acr, StructureClass sc) {
		return isConnectedDst(src, acr, sc, null);
	}
	
	public static boolean isConnectedDst(SPPRef src, ActorContainerRef acr, StructureClass sc, LayerConnection exclude) {
		for (LayerConnection lc : sc.getConnections()) {
			if (lc!=exclude)
					if (lc.getTo().getService()==src && lc.getTo().getRef()==acr)
						return true;
		}
		
		if (sc instanceof ActorClass) {
			if (((ActorClass)sc).getBase()!=null)
				return isConnectedDst(src, acr, ((ActorClass)sc).getBase(), exclude);
		}
		return false;
	}
	
	public static Result isConnectable(TransitionTerminal src, TransitionTerminal tgt, StateGraph sg) {
		return isConnectable(src, tgt, null, sg);
	}
	
	public static Result isConnectable(TransitionTerminal src, TransitionTerminal tgt, Transition trans, StateGraph sg) {
		Result result = isConnectableSrc(src, trans, sg);
		if (!result.isOk())
			return result;
		
		if (tgt instanceof TrPointTerminal) {
			if (((TrPointTerminal) tgt).getTrPoint() instanceof EntryPoint)
				return Result.error("entry point can not be transition target", tgt, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);

			TrPoint tgtTP = ((TrPointTerminal) tgt).getTrPoint();
			if (((TrPointTerminal) tgt).getTrPoint() instanceof TransitionPoint) {
				if (src instanceof TrPointTerminal) {
					TrPoint srcTP = ((TrPointTerminal)src).getTrPoint();
					if (srcTP!=tgtTP)
						return Result.error("transition point can only be target of self transition", tgt, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
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
												return Result.error("transition point can only be target of self transition", tgt, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
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
					return Result.error("transition point can only be target of self transition", tgt, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
				}
				else {
					return Result.error("transition point can only be target of self transition", tgt, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
				}
			}
			// ExitPoint is a valid destinations
			// ExitPoint can be multiply connected inside a state
		}
		else if (tgt instanceof SubStateTrPointTerminal) {
			if (((SubStateTrPointTerminal) tgt).getTrPoint() instanceof ExitPoint)
				return Result.error("sub state exit point can not be transition target", tgt, RoomPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
			// sub state EntryPoint is valid as destination
			for (Transition t : sg.getTransitions()) {
				if (t==trans)
					continue;

				if (t.getTo() instanceof SubStateTrPointTerminal) {
					SubStateTrPointTerminal tpt = (SubStateTrPointTerminal)t.getTo();
					if (tpt.getTrPoint()==((SubStateTrPointTerminal) tgt).getTrPoint())
						return Result.error("target transition point already is connected", tgt, RoomPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
				}
			}
		}

		return Result.ok();
	}
	
	public static Result isConnectable(TransitionTerminal src, StateGraph sg) {
		return isConnectableSrc(src, null, sg);
	}
	
	public static Result isConnectableSrc(TransitionTerminal src, Transition trans, StateGraph sg) {
		if (src==null) {
			for (Transition t : sg.getTransitions()) {
				if (t==trans)
					continue;

				if (t instanceof InitialTransition)
					return Result.error("there already is an InitialTransition", sg, RoomPackage.eINSTANCE.getStateGraph_Transitions(), sg.getTransitions().indexOf(trans));
			}
		}
		else if (src instanceof TrPointTerminal) {
			TrPoint srcTP = ((TrPointTerminal) src).getTrPoint();
			if (srcTP instanceof ExitPoint)
				return Result.error("exit point can not be transition source", trans, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
			// TransitionPoint and EntryPoint are valid
			if (srcTP instanceof EntryPoint) {
				for (Transition t : sg.getTransitions()) {
					if (t==trans)
						continue;

					if (t instanceof NonInitialTransition) {
						if (((NonInitialTransition) t).getFrom() instanceof TrPointTerminal) {
							TrPointTerminal tpt = (TrPointTerminal)((NonInitialTransition) t).getFrom();
							if (tpt.getTrPoint()==srcTP)
								return Result.error("source transition point already is connected", src, RoomPackage.eINSTANCE.getTrPointTerminal_TrPoint(), 0);
						}
					}
				}
			}
		}
		else if (src instanceof SubStateTrPointTerminal) {
			if (((SubStateTrPointTerminal) src).getTrPoint() instanceof EntryPoint)
				return Result.error("sub state entry point can not be transition source", src, RoomPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
			// ExitPoint is valid as source
			for (Transition t : sg.getTransitions()) {
				if (t==trans)
					continue;
				
				if (t instanceof NonInitialTransition) {
					if (((NonInitialTransition) t).getFrom() instanceof SubStateTrPointTerminal) {
						SubStateTrPointTerminal tpt = (SubStateTrPointTerminal)((NonInitialTransition) t).getFrom();
						if (tpt.getTrPoint()==((SubStateTrPointTerminal) src).getTrPoint())
							return Result.error("source transition point already is connected", src, RoomPackage.eINSTANCE.getSubStateTrPointTerminal_TrPoint(), 0);
					}
				}
			}
		}
		
		return Result.ok();
	}

	public static Result isValid(TrPoint tp) {
		if (tp instanceof TransitionPoint)
			return Result.ok();
		
		if (tp.eContainer().eContainer() instanceof State)
			return Result.ok();
		
		StateGraph sg = (StateGraph) tp.eContainer();
		int idx = sg.getTrPoints().indexOf(tp);
		return Result.error("entry and exit points forbidden on top level state graph", tp.eContainer(), RoomPackage.eINSTANCE.getStateGraph_TrPoints(), idx);
	}

	public static Result isUniqueName(InterfaceItem item) {
		return isUniqueName(item, item.getName());
	}
	
	public static boolean isConnectedOutside(TrPoint tp) {
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
	
	public static Result isUniqueName(InterfaceItem item, String name) {
		if (name.isEmpty())
			return Result.error("name must not be empty");
		
		if (item.eContainer() instanceof ActorClass) {
			ArrayList<InterfaceItem> all = new ArrayList<InterfaceItem>();
			ActorClass ac = (ActorClass) item.eContainer();
			if (isCircularClassHierarchy(ac))
				return Result.ok();
			
			do {
				all.addAll(ac.getIfPorts());
				all.addAll(ac.getIntPorts());
				all.addAll(ac.getIfSPPs());
				all.addAll(ac.getStrSAPs());
				
				ac = ac.getBase();
			}
			while (ac!=null);
			
			for (InterfaceItem ii : all) {
				if (ii!=item && ii.getName().equals(name)) {
					if (ii.eContainer()!=item.eContainer())
						return Result.error("name already used in base class "+((ActorClass)ii.eContainer()).getName());
					else
						return Result.error("name already used");
				}
			}
		}
		else if (item.eContainer() instanceof SubSystemClass) {
			SubSystemClass ssc = (SubSystemClass) item.eContainer();
			ArrayList<InterfaceItem> all = new ArrayList<InterfaceItem>();
			all.addAll(ssc.getIfSPPs());
			all.addAll(ssc.getRelayPorts());
			
			for (InterfaceItem ii : all) {
				if (ii!=item && ii.getName().equals(name)) {
					return Result.error("name already used");
				}
			}
		}
		
		return Result.ok();
	}
	
	public static Result isUniqueName(StateGraphItem s, String name) {
		if (name.isEmpty())
			return Result.error("name must not be empty");
		
		StateGraph sg = (StateGraph) s.eContainer();
		Set<String> names = RoomHelpers.getAllNames(sg, s);
		
		if (names.contains(name))
			return Result.error("name already used");
		
		return Result.ok();
	}

	/**
	 * @param tr
	 * @return
	 */
	public static Result checkTransition(Transition tr) {
		ActorClass ac = RoomHelpers.getActorClass(tr);
		if (ac.getCommType()==ActorCommunicationType.DATA_DRIVEN) {
			if (tr instanceof TriggeredTransition)
				return Result.error("data driven state machine must not contain triggered transition",
						tr.eContainer(),
						RoomPackage.eINSTANCE.getStateGraph_Transitions(),
						((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			else if (tr instanceof ContinuationTransition) {
				// if at this point no continuation transition is allowed it probably should be a guarded transition
				TransitionTerminal term = ((ContinuationTransition) tr).getFrom();
				if (term instanceof StateTerminal || (term instanceof TrPointTerminal && ((TrPointTerminal)term).getTrPoint() instanceof TransitionPoint))
					return Result.error("guard must not be empty",
							tr.eContainer(),
							RoomPackage.eINSTANCE.getStateGraph_Transitions(),
							((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			}
			else if (tr instanceof GuardedTransition)
				if (!RoomHelpers.hasDetailCode(((GuardedTransition) tr).getGuard()))
					return Result.error("guard must not be empty", tr, RoomPackage.eINSTANCE.getGuardedTransition_Guard());
		}
		else {
			if (tr instanceof GuardedTransition)
				return Result.error("event driven state machine must not contain guarded transition",
						tr.eContainer(),
						RoomPackage.eINSTANCE.getStateGraph_Transitions(),
						((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			else if (tr instanceof ContinuationTransition) {
				// if at this point no continuation transition is allowed it probably should be a triggered transition
				TransitionTerminal term = ((ContinuationTransition) tr).getFrom();
				if (term instanceof StateTerminal || (term instanceof TrPointTerminal && ((TrPointTerminal)term).getTrPoint() instanceof TransitionPoint))
					return Result.error("trigger must not be empty",
							tr.eContainer(),
							RoomPackage.eINSTANCE.getStateGraph_Transitions(),
							((StateGraph)tr.eContainer()).getTransitions().indexOf(tr));
			}
		}
		return Result.ok();
	}
	
	public static Result checkState(State state) {
		if (state.getDoCode()!=null) {
			ActorClass ac = RoomHelpers.getActorClass(state);
			if (ac.getCommType()==ActorCommunicationType.EVENT_DRIVEN) {
				return Result.error("event driven state machines must not have 'do' action code",
						state,
						RoomPackage.eINSTANCE.getState_DoCode());
			}
		}
		return Result.ok();
	}
}
