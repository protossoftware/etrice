/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.etrice.core.fsm.fSM.MessageFromIf;
import org.eclipse.etrice.core.fsm.validation.FSMValidationUtil;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;

import com.google.inject.Inject;

public class ValidationUtil extends FSMValidationUtil {
	
	public static final String CONNECTED_SUB_COMPONENT_PORTS_MUST_BE_CONJUGATED_TO_EACH_OTHER = "connected sub component ports must be conjugated to each other";
	
	@Inject
	private RoomHelpers roomHelpers;

	/**
	 * returns true if this port is connectable inside its parent, i.e. an internal end port or a relay port
	 * 
	 * @param port
	 * @return ok if connectable
	 */
	public Result isConnectable(Port port, ActorContainerRef ref, StructureClass acc) {
		return isConnectable(port, ref, acc, null);
	}
	
	public Result isConnectable(Port port, ActorContainerRef ref, StructureClass acc, Binding exclude) {
		if (!isMultipleConnectable(port, ref) && isConnected(port, ref, acc, exclude))
			return Result.error("port with multiplicity 1 is already connected");

		if (acc instanceof ActorClass) {
			for (ExternalPort xp : ((ActorClass)acc).getExternalPorts()) {
				if (xp.getInterfacePort()==port)
					return Result.error("external end ports must not be connected");
			}
		}

		return Result.ok();
	}
	
	public boolean isMultipleConnectable(Port port, ActorContainerRef ref) {
		if (port.isReplicated())
			return true;

		if (ref!=null && ref instanceof ActorRef && ((ActorRef)ref).getMultiplicity()>1)
			return true;
		
		if (port.getProtocol() instanceof ProtocolClass && ((ProtocolClass)port.getProtocol()).getCommType() == CommunicationType.DATA_DRIVEN) {
			if (ref == null) {
				// this port is local in the structure class
				if (roomHelpers.isRelay(port))
					return !port.isConjugated();
				else
					return port.isConjugated();
			}
			else
				return port.isConjugated();
		}

		return false;
	}

	public Result isValid(Binding bind) {
		return isConnectable(
				bind.getEndpoint1().getPort(), bind.getEndpoint1().getActorRef(),
				bind.getEndpoint2().getPort(), bind.getEndpoint2().getActorRef(),
				(StructureClass)bind.eContainer(), bind);
	}

	public Result isConnectable(BindingEndPoint ep1, BindingEndPoint ep2, StructureClass sc) {
		return isConnectable(ep1.getPort(), ep1.getActorRef(), ep2.getPort(), ep2.getActorRef(), sc);
	}
	
	public Result isConnectable(Port p1, ActorContainerRef ref1, Port p2, ActorContainerRef ref2, StructureClass sc) {
		return isConnectable(p1, ref1, p2, ref2, sc, null);
	}
	
	public Result isConnectable(Port p1, ActorContainerRef ref1, Port p2, ActorContainerRef ref2, StructureClass sc, Binding exclude) {
		if (p1==p2)
			return Result.error("no self connection allowed, ports are identical");
		
		// check protocol compatibility
		boolean pc1extendsIncoming = false;
		boolean pc1extendsOutgoing = false;
		boolean pc2extendsIncoming = false;
		boolean pc2extendsOutgoing = false;
		{
			ProtocolClass pc1 = p1.getProtocol();
			ProtocolClass pc2 = p2.getProtocol();
			if (pc1!=pc2) {
				if (roomHelpers.isDerivedFrom((ProtocolClass)pc1, (ProtocolClass)pc2)) {
					if (roomHelpers.getAllMessages((ProtocolClass)pc1,true).size() > roomHelpers.getAllMessages((ProtocolClass)pc2,true).size())
						pc1extendsIncoming = true;
					if (roomHelpers.getAllMessages((ProtocolClass)pc1,false).size()>roomHelpers.getAllMessages((ProtocolClass)pc2,false).size())
						pc1extendsOutgoing = true;
					if (pc1extendsIncoming && pc1extendsOutgoing)
						return Result.error("derived protocols not connectable (both directions extended)");

				}
				else if (roomHelpers.isDerivedFrom((ProtocolClass)pc2, (ProtocolClass)pc1)) {
					if (roomHelpers.getAllMessages((ProtocolClass)pc2,true).size()>roomHelpers.getAllMessages((ProtocolClass)pc1,true).size())
						pc2extendsIncoming = true;
					if (roomHelpers.getAllMessages((ProtocolClass)pc2,false).size()>roomHelpers.getAllMessages((ProtocolClass)pc1,false).size())	
						pc2extendsOutgoing = true;
					if (pc2extendsIncoming && pc2extendsOutgoing)
						return Result.error("derived protocols not connectable (both directions extended)");
				}
				else {
					if (pc1.getName().equals(pc2.getName())) {
						String ns1 = ((RoomModel)pc1.eContainer()).getName();
						String ns2 = ((RoomModel)pc2.eContainer()).getName();
						if (!ns1.equals(ns2))
							return Result.error("protocols have different name spaces");
						if(pc1.eResource() != pc2.eResource())
							return Result.error("protocols were not loaded uniquely - check imports");
						
						// should not happen
						return Result.error("protocols don't match (but have same name)");
					}
					
					return Result.error("protocols don't match");
				}
			}

			if (pc1.getCommType() != pc2.getCommType())
				return Result.error("protocol communication types don't match");
			if (alreadyConnected(p1, ref1, p2, ref2, sc, exclude))
				return Result.error("ports are already bound");
		}
		
		
		if (ref1==null && ref2==null)
			return Result.error("cannot connect two local ports");
		
		if (ref1!=null && ref2!=null) {
			if (ref1==ref2)
				return Result.error("ports of one ref must not be connected");

			// both ports are on references
			if (p1.isConjugated()==p2.isConjugated())
				return Result.error(CONNECTED_SUB_COMPONENT_PORTS_MUST_BE_CONJUGATED_TO_EACH_OTHER);
			
			if (p1.isConjugated() && pc1extendsIncoming)
				return Result.error("protocol extends incoming");
			if (p2.isConjugated() && pc2extendsIncoming)
				return Result.error("protocol extends incoming");
			if (!p1.isConjugated() && pc1extendsOutgoing)
				return Result.error("protocol extends outgoing");
			if (!p2.isConjugated() && pc2extendsOutgoing)
				return Result.error("protocol extends outgoing");
			
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
			
			if (ref instanceof ActorRef && ((ActorRef) ref).getRefType()==ReferenceType.OPTIONAL) {
				if (((ActorRef) ref).getMultiplicity()==-1) {
					// the port must have multiplicity any
					if (local.getMultiplicity()!=-1)
						return Result.error("local port '"+local.getName()+"' must have multiplicity any");
				}
			}
			if (roomHelpers.isRelay(local)) {
				if (local.isConjugated()!=sub.isConjugated())
					return Result.error("relay port must have same direction as local port");

				if (local==p1) {
					if (!p1.isConjugated() && pc1extendsIncoming)
						return Result.error("protocol extends incoming");
					if (p2.isConjugated() && pc2extendsIncoming)
						return Result.error("protocol extends incoming");
					if (p1.isConjugated() && pc1extendsOutgoing)
						return Result.error("protocol extends outgoing");
					if (!p2.isConjugated() && pc2extendsOutgoing)
						return Result.error("protocol extends outgoing");
				}
				else {
					if (p1.isConjugated() && pc1extendsIncoming)
						return Result.error("protocol extends incoming");
					if (!p2.isConjugated() && pc2extendsIncoming)
						return Result.error("protocol extends incoming");
					if (!p1.isConjugated() && pc1extendsOutgoing)
						return Result.error("protocol extends outgoing");
					if (p2.isConjugated() && pc2extendsOutgoing)
						return Result.error("protocol extends outgoing");
				}
				ActorContainerClass acc = (ActorContainerClass) ref.eContainer();
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
				
				if (p1.isConjugated() && pc1extendsIncoming)
					return Result.error("protocol extends incoming");
				if (p2.isConjugated() && pc2extendsIncoming)
					return Result.error("protocol extends incoming");
				if (!p1.isConjugated() && pc1extendsOutgoing)
					return Result.error("protocol extends outgoing");
				if (!p2.isConjugated() && pc2extendsOutgoing)
					return Result.error("protocol extends outgoing");

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

	/**
	 * @param p1
	 * @param ref1
	 * @param p2
	 * @param ref2
	 * @param sc
	 * @param exclude
	 * @return
	 */
	private boolean alreadyConnected(Port p1, ActorContainerRef ref1,
			Port p2, ActorContainerRef ref2, StructureClass sc, Binding exclude) {
		
		HashSet<String> bindings = new HashSet<String>();
		String key = getKey(p1, ref1, p2, ref2);
		bindings.add(key);
		for (Binding bind : sc.getBindings()) {
			if (bind==exclude)
				continue;

			key = getKey(bind.getEndpoint1().getPort(), bind.getEndpoint1().getActorRef(),
					bind.getEndpoint2().getPort(), bind.getEndpoint2().getActorRef());
			if (!bindings.add(key))
				return true;
		}
		return false;
	}

	private String getKey(Port p1, ActorContainerRef ref1, Port p2, ActorContainerRef ref2) {
		String ep1 = getEndpointName(p1, ref1);
		String ep2 = getEndpointName(p2, ref2);
		// we order endpoint names to be able to identify bindings with exchanged endpoints
		return (ep1.compareTo(ep2)>0)? ep1+ep2:ep2+ep1;
	}
	/**
	 * @param p1
	 * @param ref1
	 * @return
	 */
	private String getEndpointName(Port p1, ActorContainerRef ref1) {
		if (ref1==null)
			return p1.getName()+"#.";
		else
			return p1.getName()+"#"+ref1.getName();
	}

	public Result isFreeOfReferences(Port port) {
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

	public boolean isReferencedAsReplicatedInModel(ActorClass ac) {
		Collection<Setting> refs = EcoreUtil.UsageCrossReferencer.find(ac, ac.eResource().getResourceSet());
		for (Setting ref : refs) {
			if (ref.getEObject() instanceof ActorRef)
				return ((ActorRef)ref.getEObject()).getMultiplicity()>1;
		}
		
		return false;
	}
	
	public boolean isConnected(Port port, ActorContainerRef ref, StructureClass sc) {
		return isConnected(port, ref, sc, null);
	}
	
	public boolean isConnected(Port port, ActorContainerRef ref, StructureClass sc, Binding exclude) {
		for (Binding bind : sc.getBindings()) {
			if (bind!=exclude) {
				if (isEndpoint(bind.getEndpoint1(), port, ref))
					return true;
				if (isEndpoint(bind.getEndpoint2(), port, ref))
					return true;
			}
		}
		
		if (sc instanceof ActorClass) {
			if (((ActorClass)sc).getActorBase()!=null)
				return isConnected(port, ref, ((ActorClass)sc).getActorBase(), exclude);
		}
		return false;
	}

	private boolean isEndpoint(BindingEndPoint ep, Port port, ActorContainerRef ref) {
		return ep.getActorRef()==ref && ep.getPort()==port;
	}

	public boolean isRelay(SPP spp) {
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
	
	public Result isValid(LayerConnection lc) {
		if (lc.getFrom() instanceof RelaySAPoint)
			return isConnectable(((RelaySAPoint)lc.getFrom()).getRelay(), null, lc.getTo().getService(), lc.getTo().getRef(), (StructureClass)lc.eContainer(), lc);
		else if (lc.getFrom() instanceof RefSAPoint)
			return isConnectable(null, ((RefSAPoint)lc.getFrom()).getRef(), lc.getTo().getService(), lc.getTo().getRef(), (StructureClass)lc.eContainer(), lc);
		else {
			assert(false): "unexpected sub type";
			return Result.error("internal error");
		}
	}
	
	public Result isConnectable(SPP src, ActorContainerRef srcRef,
			SPP tgt, ActorContainerRef tgtRef, StructureClass ac) {
		return isConnectable(src, srcRef, tgt, tgtRef, ac, null);
	}
	
	public Result isConnectable(SPP src, ActorContainerRef srcRef,
			SPP dst, ActorContainerRef dstRef, StructureClass sc, LayerConnection exclude) {

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

	public boolean isConnectableSrc(SPP src, ActorContainerRef ref,
			StructureClass sc) {
		return isConnectableSrc(src, ref, sc, null);
	}
	
	public boolean isConnectableSrc(SPP src, ActorContainerRef ref,
			StructureClass sc, LayerConnection exclude) {
		
		if (sc==null) {
			return false;
		}
		
		if ((src==null && ref==null) || (src!=null && ref!=null))
			return false;

		if (ref instanceof ActorRef)
			if (((ActorRef) ref).getMultiplicity()>1)
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

	public boolean isReferencedInModel(SPP spp) {
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
	
	public boolean isConnectedSrc(SPP src, StructureClass sc) {
		return isConnectedSrc(src, sc, null);
	}
	
	public boolean isConnectedSrc(SPP src, StructureClass sc, LayerConnection exclude) {
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
			if (ac.getActorBase()!=null)
				return isConnectedSrc(src, ac.getActorBase(), exclude);
		}
		return false;
	}

	public boolean isConnectableDst(SPP src, ActorContainerRef ref,
			StructureClass sc) {
		return isConnectableDst(src, ref, sc, null);
	}
	
	public boolean isConnectableDst(SPP dst, ActorContainerRef ref,
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
	
	public boolean isConnectedDst(SPP src, ActorContainerRef acr, StructureClass sc) {
		return isConnectedDst(src, acr, sc, null);
	}
	
	public boolean isConnectedDst(SPP src, ActorContainerRef acr, StructureClass sc, LayerConnection exclude) {
		for (LayerConnection lc : sc.getConnections()) {
			if (lc!=exclude)
					if (lc.getTo().getService()==src && lc.getTo().getRef()==acr)
						return true;
		}
		
		if (sc instanceof ActorClass) {
			if (((ActorClass)sc).getActorBase()!=null)
				return isConnectedDst(src, acr, ((ActorClass)sc).getActorBase(), exclude);
		}
		return false;
	}

	public Result isUniqueName(InterfaceItem item) {
		return isUniqueName(item, item.getName());
	}
	
	public Result isUniqueName(InterfaceItem item, String name) {
		if (name.isEmpty())
			return Result.error("name must not be empty");
		
		if (!isValidID(name))
			return Result.error("name is no valid ID");
		
		if (item.eContainer() instanceof ActorClass) {
			ArrayList<InterfaceItem> all = new ArrayList<InterfaceItem>();
			ActorClass ac = (ActorClass) item.eContainer();
			if (roomHelpers.isCircularClassHierarchy(ac))
				return Result.ok();
			
			do {
				all.addAll(ac.getInterfacePorts());
				all.addAll(ac.getInternalPorts());
				all.addAll(ac.getServiceProvisionPoints());
				all.addAll(ac.getServiceAccessPoints());
				
				ac = ac.getActorBase();
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
			all.addAll(ssc.getServiceProvisionPoints());
			all.addAll(ssc.getRelayPorts());
			
			for (InterfaceItem ii : all) {
				if (ii!=item && ii.getName().equals(name)) {
					return Result.error("name already used");
				}
			}
		}
		
		return Result.ok();
	}
}
