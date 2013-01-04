/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenFactory;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.RoomPackage;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class BindingUtil {
	
	private static class BindingInfo {
		private Binding binding;
		private int multiplicity;
		
		public BindingInfo(Binding binding) {
			this.binding = binding;
			
			int m1 = getMultiplicity(binding.getEndpoint1());
			int m2 = getMultiplicity(binding.getEndpoint2());
			
			multiplicity = Math.max(m1, m2);
		}

		public int getMultiplicity() {
			return multiplicity;
		}

		public Port getPeer(Port p) {
			if (binding.getEndpoint1().getPort()==p)
				return binding.getEndpoint2().getPort();
			else
				return binding.getEndpoint1().getPort();
		}
		
		private int getMultiplicity(BindingEndPoint ep) {
			if (ep.getActorRef() instanceof ActorRef)
				return ((ActorRef) ep.getActorRef()).getSize();
			
			return 1;
		}
	}
	private static final String SEP = "#";

	private StructureInstance si;
	private IDiagnostician diagnostician;
	private ArrayList<Binding> bindings = new ArrayList<Binding>();

	private HashMap<String, ArrayList<PortInstance>> ep2portInstances = new HashMap<String, ArrayList<PortInstance>>();
	private HashMap<String, ArrayList<BindingInfo>> ep2bindings = new HashMap<String, ArrayList<BindingInfo>>();
	private HashMap<Binding, BindingInfo> binding2info = new HashMap<Binding, BindingInfo>();
	
	/**
	 * @param diagnostician
	 */
	public BindingUtil(StructureInstance si, IDiagnostician diagnostician) {
		this.si = si;
		this.diagnostician = diagnostician;
		
		// collect bindings
		if (si instanceof ActorInstance) {
			ActorClass ac = ((ActorInstance) si).getActorClass();
			while (ac!=null) {
				bindings.addAll(ac.getBindings());
				ac = ac.getBase();
			}
		}
		else if (si instanceof SubSystemInstance)
			bindings.addAll(((SubSystemInstance) si).getSubSystemClass().getBindings());
	}

	/**
	 * create binding instances. Since bindings connect port instances the ports can point back to their bindings
	 * using EOpposite
	 * @param si - create bindings for this actor instance
	 * @param bindings - a list of bindings
	 */
	public void createBindingInstances() {
		initPortInstanceMap();
		
		for (Binding bind : bindings) {
			if (bind.getEndpoint1().getActorRef()==null && bind.getEndpoint2().getActorRef()==null) {
				int idx = bindings.indexOf(bind);
				diagnostician.error("binding connects two ports of the same actor", bind, RoomPackage.eINSTANCE.getStructureClass_Bindings(), idx);
			}
			else {
				ArrayList<PortInstance> ep1Ports = ep2portInstances.get(getEndPointKey(bind.getEndpoint1()));
				ArrayList<PortInstance> ep2Ports = ep2portInstances.get(getEndPointKey(bind.getEndpoint2()));
				BindingInfo bi = binding2info.get(bind);
				int nBind = Math.min(bi.getMultiplicity(), ep1Ports.size());
				nBind = Math.min(nBind, ep2Ports.size());
				for (int i=0; i<nBind; ++i) {
					createBindingInstance(ep1Ports.get(0), ep2Ports.get(0), bind);
					ep1Ports.remove(0);
					ep2Ports.remove(0);
				}
			}
		}
	}

	private void createBindingInstance(PortInstance pi1, PortInstance pi2, Binding bind) {
		BindingInstance bi = ETriceGenFactory.eINSTANCE.createBindingInstance();
		
		bi.getPorts().add(pi1);
		bi.getPorts().add(pi2);
		bi.setBinding(bind);
		
		si.getBindings().add(bi);
	}

	private void initPortInstanceMap() {
		// 1. register existing port instances
		
		// local end ports
		for (PortInstance pi : si.getPorts()) {
			if (pi.getKind()!=PortKind.EXTERNAL) {
				addPortInstance(pi, getEndPointKey(null, pi));
			}
		}
		
		// ports of actor refs
		for (ActorInstance sub : si.getInstances()) {
			boolean forceMultFixed = sub.getReplIdx()>1;
			for (PortInstance pi : sub.getPorts()) {
				if (pi.getKind()!=PortKind.INTERNAL) {
					if (forceMultFixed && pi.getPort().getMultiplicity()<0)
						diagnostician.error("port multiplicity of replicated actor has to be fixed", pi.getPort(), RoomPackage.eINSTANCE.getPort_Multiplicity());
					addPortInstance(pi, getEndPointKey(sub, pi));
				}
			}
		}
		
		// 2. compute binding info
		for (Binding bind : bindings) {
			BindingInfo bi = new BindingInfo(bind);
			binding2info.put(bind, bi);
			addBindingInfoToEndPoint(bi, bind.getEndpoint1());
			addBindingInfoToEndPoint(bi, bind.getEndpoint2());
		}
		
		// 3. determine * multiplicities
		outer: for (Entry<String, ArrayList<BindingInfo>> entry : ep2bindings.entrySet()) {
			ArrayList<PortInstance> ports = ep2portInstances.get(entry.getKey());
			PortInstance pi = ports.get(0);
			Port p = pi.getPort();
			boolean implicitMany = pi.getProtocol()==null || pi.getProtocol().getCommType() == CommunicationType.DATA_DRIVEN; 
			if (implicitMany || p.getMultiplicity()<0) {
				int m = 0;
				for (BindingInfo bi : entry.getValue()) {
					Port peer = bi.getPeer(p);
					if (peer.getMultiplicity()>0)
						m += bi.getMultiplicity();
					else {
						diagnostician.error("could not compute multiplicity", p, RoomPackage.Literals.PORT__MULTIPLICITY);
						break outer;
					}
				}
				
				// fill in port instances such that ports.size()==m
				m -= ports.size();
				for (; m>0; --m)
					ports.add(pi);
			}
		}
	}
	
	/**
	 * @param bi
	 * @param ep
	 */
	private void addBindingInfoToEndPoint(BindingInfo bi, BindingEndPoint ep) {
		String key = getEndPointKey(ep.getActorRef(), ep.getPort());
		ArrayList<BindingInfo> list = ep2bindings.get(key);
		if (list==null) {
			list = new ArrayList<BindingInfo>();
			ep2bindings.put(key, list);
		}
		
		list.add(bi);
	}

	private static String getEndPointKey(ActorInstance ai, PortInstance pi) {
		return (ai!=null? ai.getUnindexedName():"")+SEP+pi.getPort().getName();
	}
	
	private static String getEndPointKey(BindingEndPoint ep) {
		return getEndPointKey(ep.getActorRef(), ep.getPort());
	}
	
	private static String getEndPointKey(ActorContainerRef ref, Port port) {
		return ref==null? SEP+port.getName() : ref.getName()+SEP+port.getName();
	}
	
	/**
	 * add the port instance to the map. Replicated ports are added 'multiplicity' times. If the multiplicity is * then the port is added once.
	 *  
	 * @param pi
	 * @param ep2portInstances
	 */
	private void addPortInstance(PortInstance pi, String key) {
		ArrayList<PortInstance> ports = ep2portInstances.get(key);
		if (ports==null) {
			ports = new ArrayList<PortInstance>();
			ep2portInstances.put(key, ports);
		}
		int repl = pi.getPort().getMultiplicity();
		if (repl<=0)
			repl = 1;
		for (int i=0; i<repl; ++i)
			ports.add(pi);
	}

}
