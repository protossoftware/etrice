/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.genmodel.builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenFactory;
import org.eclipse.etrice.core.genmodel.etricegen.OpenBinding;
import org.eclipse.etrice.core.genmodel.etricegen.OpenServiceConnection;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.Wire;
import org.eclipse.etrice.core.genmodel.etricegen.WiredActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredStructureClass;
import org.eclipse.etrice.core.genmodel.etricegen.WiredSubSystemClass;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.BindingEndPoint;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class Wiring {
	
	private RoomHelpers roomHelpers = new RoomHelpers();
	
	private static class EndPoint {
		ActorContainerRef ref;
		Port port;
		int ridx = 0;
		
		public EndPoint(ActorContainerRef ref, Port port, int ridx) {
			super();
			this.ref = ref;
			this.port = port;
			this.ridx = ridx;
		}

		String getPortName() {
			return port.getName();
		}
		
		String getRefName() {
			if (ridx>=0)
				return ref.getName()+GenmodelConstants.INDEX_SEP+ridx;
			else
				return ref.getName();
		}

		public ActorContainerRef getActorRef() {
			return ref;
		}

		public Port getPort() {
			return port;
		}
	}
	
	private static class EndPointCreator {
		ActorContainerRef ref;
		Port port;
		int rsize = 1;
		int ridx = 0;
		int psize;
		int pidx = 0;
		
		public EndPointCreator(BindingEndPoint ep, RoomHelpers roomHelpers) {
			this(ep.getActorRef(), ep.getPort(), roomHelpers);
		}
		
		public EndPointCreator(ActorContainerRef ref, Port port, RoomHelpers roomHelpers) {
			this.ref = ref;
			this.port = port;
			
			psize = port.getMultiplicity();
			if (ref instanceof ActorRef) {
				ActorRef ar = (ActorRef) ref;
				rsize = ar.getMultiplicity();
			}
			
			ProtocolClass pc = roomHelpers.getRoomProtocol(port);
			boolean implicitMany = pc==null || pc.getCommType() == CommunicationType.DATA_DRIVEN;
			if (implicitMany)
				psize = -1;
		}
		
		EndPoint createEndPoint() {
			if (psize>0 && pidx>=psize)
				return null;
			if (rsize>0 && ridx>=rsize)
				return null;
			
			if (rsize==1) {
				// scalar actor ref
				++pidx;
				EndPoint ep = new EndPoint(ref, port, -1);
				return ep;
			}
			else if (rsize<0) {
				// optional actor array with arbitrary size (broker end point)
				// how many bindings allowed?
				EndPoint ep = new EndPoint(ref, port, -1);
				return ep;
			}
			else {
				// fixed actor array
				EndPoint ep = new EndPoint(ref, port, ridx);
				++pidx;
				if (pidx>=psize) {
					if (ridx<rsize) {
						++ridx;
						pidx = 0;
					}
				}
				return ep;
			}
		}

		/**
		 * @return
		 */
		public int remaining() {
			if (psize>0 && pidx>=psize)
				return 0;
			if (rsize>0 && ridx>=rsize)
				return 0;

			if (rsize==1) {
				if (psize<0)
					return -1;
				else
					return psize-pidx;
			}
			else if (rsize<0) {
				return -1;
			}
			else {
				return (rsize-ridx-1)*psize+(psize-pidx);
			}
		}
	}

	private static final String SEP = "#";
	
	private Root root;
	private HashMap<ActorClass, WiredActorClass> handled = new HashMap<ActorClass, WiredActorClass>();

	/**
	 * @param root
	 */
	public Wiring(Root root) {
		this.root = root;
	}

	public void createWiredClasses() {
		for (ActorClass ac : root.getActorClasses()) {
			getWiredActorClass(ac);
		}
		
		// the wiring model also needs actor classes to connect with
		for (RoomModel model : root.getImportedModels()) {
			for (ActorClass ac : model.getActorClasses()) {
				getWiredActorClass(ac);
			}
		}
		
		for (SubSystemClass ssc : root.getSubSystemClasses()) {
			createWiredSubSystemClass(ssc);
		}
	}

	/**
	 * @param ac
	 */
	private WiredActorClass createWiredActorClass(ActorClass ac) {
		WiredActorClass wired = ETriceGenFactory.eINSTANCE.createWiredActorClass();
		wired.setActorClass(ac);
		
		wireBindings(wired, roomHelpers.getAllBindings(ac));
		wireServices(wired,
				roomHelpers.getAllActorContainerRefs(ac),
				roomHelpers.getAllLayerConnections(ac),
				roomHelpers.getAllSAPs(ac),
				roomHelpers.getAllServiceImplementations(ac));
		handled.put(ac, wired);
		root.getWiredInstances().add(wired);
		
		return wired;
	}

	/**
	 * @param ssc
	 */
	private WiredSubSystemClass createWiredSubSystemClass(SubSystemClass ssc) {
		WiredSubSystemClass wired = ETriceGenFactory.eINSTANCE.createWiredSubSystemClass();
		wired.setSubSystemClass(ssc);
		
		wireBindings(wired, ssc.getBindings());
		wireServices(wired, roomHelpers.getAllActorContainerRefs(ssc), ssc.getConnections(), null, null);

		root.getWiredInstances().add(wired);
		
		return wired;
	}
	
	private WiredActorClass getWiredActorClass(ActorClass ac) {
		WiredActorClass cls = handled.get(ac);
		if (cls!=null)
			return cls;
		
		return createWiredActorClass(ac);
	}

	/**
	 * @param wired
	 * @param bindings
	 */
	private void wireBindings(WiredStructureClass wired, List<Binding> bindings) {
		HashMap<String, EndPointCreator> epkey2creator = new HashMap<String, EndPointCreator>();
		
		for (Binding binding : bindings) {
			EndPointCreator epc1 = getEndPointCreator(binding.getEndpoint1(), epkey2creator);
			EndPointCreator epc2 = getEndPointCreator(binding.getEndpoint2(), epkey2creator);
			
			int n = getMultiplicity(binding);
			int r1 = epc1.remaining();
			if (r1>=0)
				n = Math.min(n, r1);
			int r2 = epc2.remaining();
			if (r2>=0)
				n = Math.min(n, r2);
			for (int i=0; i<n; ++i) {
				EndPoint ep1 = epc1.createEndPoint();
				EndPoint ep2 = epc2.createEndPoint();
				if (ep1!=null && ep2!=null) {
					if (ep1.getActorRef()==null) {
						handleBindingToLocal(wired, ep1, ep2);
					}
					else if (ep2.getActorRef()==null) {
						handleBindingToLocal(wired, ep2, ep1);
					}
					else {
						handleBindingBetweenRefs(wired, ep1, ep2);
					}
				}
			}
		}
	}
	
	private EndPointCreator getEndPointCreator(BindingEndPoint ep, HashMap<String, EndPointCreator> epkey2creator) {
		String key = getEndPointKey(ep);
		EndPointCreator creator = epkey2creator.get(key);
		if (creator==null) {
			creator = new EndPointCreator(ep, roomHelpers);
			epkey2creator.put(key, creator);
		}
		return creator;
	}

	private int getMultiplicity(Binding binding) {
		int m1 = getMultiplicity(binding.getEndpoint1());
		int m2 = getMultiplicity(binding.getEndpoint2());
		
		return Math.max(m1, m2);
	}
	
	private int getMultiplicity(BindingEndPoint ep) {
		if (ep.getActorRef() instanceof ActorRef)
			if (((ActorRef) ep.getActorRef()).getRefType()==ReferenceType.FIXED)
				return ((ActorRef) ep.getActorRef()).getMultiplicity();
		
		return 1;
	}

	/**
	 * @param wired
	 * @param ep1
	 * @param ep2
	 */
	private void handleBindingBetweenRefs(WiredStructureClass wired, EndPoint ep1, EndPoint ep2) {
		List<String> path1 = getPath(ep1);
		if (path1!=null) {
			List<String> path2 = getPath(ep2);
			if (path2!=null) {
				// we can wire and just have to assemble the paths
				Wire wire = ETriceGenFactory.eINSTANCE.createWire();
				wire.setDataDriven(roomHelpers.isDataDriven(ep1.port) && roomHelpers.isDataDriven(ep2.port));
				wire.getPath1().addAll(path1);
				wire.getPath2().addAll(path2);
				wired.getWires().add(wire);
			}
		}
	}

	/**
	 * @param ep1
	 * @return
	 */
	private List<String> getPath(EndPoint ep) {
		assert(ep.getActorRef()!=null): "endpoint expected on ref";
		assert(ep.getActorRef() instanceof ActorRef): "ActorRef expected";
		
		ActorRef ar = (ActorRef) ep.getActorRef();
		
		if (ar.getRefType()==ReferenceType.FIXED && roomHelpers.isRelay(ep.getPort())) {
			OpenBinding open = getOpenBinding(ep);
			if (open!=null) {
				ArrayList<String> path = new ArrayList<String>();
				path.add(ep.getRefName());
				path.addAll(open.getPath());
				return path;
			}
			// else: no path since not connected inside ref
			return null;
		}
		else {
			ArrayList<String> path = new ArrayList<String>();
			path.add(ep.getRefName());
			path.add(ep.getPortName());
			return path;
		}
	}

	/**
	 * @param ep
	 * @return
	 */
	private OpenBinding getOpenBinding(EndPoint ep) {
		assert(ep.getActorRef()!=null): "endpoint expected on ref";
		
		ActorRef ref = (ActorRef) ep.getActorRef();
		WiredActorClass wiredRef = getWiredActorClass(ref.getType());
		for (OpenBinding ob: wiredRef.getOpenBindings())
			if (ob.getPort()==ep.getPort())
				return ob;
		
		return null;
	}

	/**
	 * @param wired
	 * @param localEnd
	 * @param refEnd
	 */
	private void handleBindingToLocal(WiredStructureClass wired, EndPoint localEnd, EndPoint refEnd) {
		List<String> refPath = getPath(refEnd);
		if (refPath!=null) {
			if (roomHelpers.isRelay(localEnd.getPort())) {
				// create an OpenBinding for ourselves
				OpenBinding myOpen = ETriceGenFactory.eINSTANCE.createOpenBinding();
				myOpen.getPath().addAll(refPath);
				myOpen.setPort(localEnd.getPort());
				wired.getOpenBindings().add(myOpen);
			}
			else {
				// we can create a wire
				Wire wire = ETriceGenFactory.eINSTANCE.createWire();
				wire.setDataDriven(roomHelpers.isDataDriven(localEnd.port) && roomHelpers.isDataDriven(refEnd.port));
				wire.getPath1().addAll(refPath);
				wire.getPath2().add(localEnd.getPortName());
				wired.getWires().add(wire);
			}
		}
		// else: nothing to do since not connected inside ref
	}

	/**
	 * @param wired
	 * @param connections 
	 * @param list 
	 * @param allSAPs
	 * @param allServiceImplementations
	 */
	private void wireServices(
			WiredStructureClass wired,
			List<ActorContainerRef> refs,
			List<LayerConnection> connections,
			List<SAP> allSAPs,
			List<ServiceImplementation> allServiceImplementations) {
		
		// propagate services we provide directly
		if (allServiceImplementations!=null)
			for (ServiceImplementation svcImpl : allServiceImplementations)
				if (svcImpl.getSpp()!=null) {
					OpenServiceConnection osc = ETriceGenFactory.eINSTANCE.createOpenServiceConnection();
					osc.setProtocol(svcImpl.getSpp().getProtocol());
					osc.getPath().add(svcImpl.getSpp().getName());
					wired.getProvidedServices().add(osc);
				}
		
		// propagate services we require directly
		if (allSAPs!=null)
			for (SAP sap : allSAPs) {
				OpenServiceConnection osc = ETriceGenFactory.eINSTANCE.createOpenServiceConnection();
				osc.setProtocol(sap.getProtocol());
				osc.getPath().add(sap.getName());
				wired.getRequiredServices().add(osc);
			}
		
		// satisfy services
		HashSet<OpenServiceConnection> satisfied = new HashSet<OpenServiceConnection>();
		for (LayerConnection conn : connections) {
			if (conn.getFrom() instanceof RefSAPoint) {
				// we can satisfy the service that is provided by this connection
				RefSAPoint from = (RefSAPoint) conn.getFrom();
				if (from.getRef() instanceof ActorRef) {
					if (conn.getTo().getRef() instanceof ActorRef) {
						ActorRef reqRef = (ActorRef) from.getRef();
						WiredActorClass requestor = getWiredActorClass(reqRef.getType());
						if (!requestor.getRequiredServices().isEmpty()) {
							ActorRef prvRef = (ActorRef) conn.getTo().getRef();
							WiredActorClass provider = getWiredActorClass(prvRef.getType());
							for (OpenServiceConnection prv : provider.getProvidedServices()) {
								if (conn.getTo().getService().getProtocol()==prv.getProtocol()) {
									for (OpenServiceConnection req : requestor.getRequiredServices()) {
										if (req.getProtocol()==prv.getProtocol()) {
											// can satisfy: do wire and remember as satisfied
											Wire wire = ETriceGenFactory.eINSTANCE.createWire();
											wire.setDataDriven(roomHelpers.isDataDriven(conn.getTo().getService()));
											wire.getPath1().add(prvRef.getName());
											wire.getPath1().addAll(prv.getPath());
											wire.getPath2().add(reqRef.getName());
											wire.getPath2().addAll(req.getPath());
											wired.getWires().add(wire);
											
											satisfied.add(req);
											
											// don't break: may be several requests for the same protocol
										}
									}
									break;
								}
							}
						}
					}
				}
				// this case would occur for LogicalSystems only which aren't treated currently
			}
			else if (conn.getFrom() instanceof RelaySAPoint) {
				// this service is provided by ourselves
				RelaySAPoint from = (RelaySAPoint) conn.getFrom();
				WiredActorClass sub = getWiredActorClass(((ActorRef)conn.getTo().getRef()).getType());
				for (OpenServiceConnection prv : sub.getProvidedServices()) {
					if (prv.getProtocol()==from.getRelay().getProtocol()) {
						OpenServiceConnection osc = ETriceGenFactory.eINSTANCE.createOpenServiceConnection();
						osc.setProtocol(prv.getProtocol());
						osc.getPath().add(conn.getTo().getRef().getName());
						osc.getPath().addAll(prv.getPath());
						wired.getProvidedServices().add(osc);
						break;
					}
				}
			}
			else {
				assert(false): "unexpected sub type";
			}
		}
		
		// propagate unsatisfied requested services
		for (ActorContainerRef ref : refs) {
			WiredStructureClass sub = null;
			if (ref instanceof ActorRef && ((ActorRef)ref).getRefType()==ReferenceType.FIXED)
				sub = getWiredActorClass(((ActorRef) ref).getType());
			
			if (sub!=null) {
				for (OpenServiceConnection req : sub.getRequiredServices()) {
					if (!satisfied.contains(req)) {
						OpenServiceConnection osc = ETriceGenFactory.eINSTANCE.createOpenServiceConnection();
						osc.setProtocol(req.getProtocol());
						osc.getPath().add(ref.getName());
						osc.getPath().addAll(req.getPath());
						wired.getRequiredServices().add(osc);
					}
				}
			}
		}
	}
	
	private static String getEndPointKey(BindingEndPoint ep) {
		return getEndPointKey(ep.getActorRef(), ep.getPort());
	}
	
	private static String getEndPointKey(ActorContainerRef ref, Port port) {
		return ref==null? SEP+port.getName() : ref.getName()+SEP+port.getName();
	}
}
