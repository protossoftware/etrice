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

package org.eclipse.etrice.core.genmodel.builder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.etrice.core.genmodel.base.ILogger;
import org.eclipse.etrice.core.genmodel.etricegen.AbstractInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.BindingInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ConnectionInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenFactory;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.IDiagnostician;
import org.eclipse.etrice.core.genmodel.etricegen.InstanceBase;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SPPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.genmodel.etricegen.StructureInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SubSystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.SystemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.impl.AbstractInstanceImpl;
import org.eclipse.etrice.core.genmodel.etricegen.impl.StructureInstanceImpl;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorContainerRef;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefSAPoint;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RelaySAPoint;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.SAPRef;
import org.eclipse.etrice.core.room.SAPoint;
import org.eclipse.etrice.core.room.SPPRef;
import org.eclipse.etrice.core.room.SPPoint;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SubProtocol;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.etrice.core.room.util.RoomHelpers;

/**
 * A class for the creation of an intermediate model combining all information needed by
 * the code generator.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class GeneratorModelBuilder {

	private enum WorkItem {

		CREATE_INSTANCES,
		CREATE_PORTS,
		CREATE_BINDINGS,
		CONNECT_PORTS,
		CONNECT_SERVICES,
		CREATE_OPTIONAL_INSTANCES
	}
	
	HashSet<WorkItem> alreadyDone = new HashSet<WorkItem>();

	/**
	 * the first object id used for the {@link org.eclipse.etrice.core.etrice.runtime.messaging.Address Address}es s of runtime instances
	 */
	private static final int OBJ_ID_OFFSET = 0;
	
	/**
	 * a list containing all InstanceBase objects
	 */
	private LinkedList<InstanceBase> allObjects = new LinkedList<InstanceBase>();
	
	/**
	 * a set of all actor classes that are candidates for optional actors
	 */
	private HashMap<ActorClass, OptionalActorInstance> optionalActors = new HashMap<ActorClass, OptionalActorInstance>();
	
	/**
	 * an instance of a logger
	 */
	private ILogger logger;
	
	/**
	 * an instance of a diagnostician
	 */
	private IDiagnostician diagnostician;

	private boolean debug;

	/**
	 * the only constructor takes a logger and a diagnostician as arguments
	 * @param logger
	 * @param diagnostician
	 */
	public GeneratorModelBuilder(ILogger logger, IDiagnostician diagnostician) {
		this.logger = logger;
		this.diagnostician = diagnostician;
	}
	
	public Root createGeneratorModel(List<RoomModel> models, boolean asLibrary) {
		return createGeneratorModel(models, asLibrary, false);
	}
	
	/**
	 * Creates a model of all instances for all sub systems.
	 * Actor instances are created in a hierarchical structure.
	 * There is only one list of port per actor instances.
	 * Ports have a type attribute (relay, intern, external).
	 * Bindings connect port instances. And since ports are
	 * instances it is possible to have pointers back to the
	 * bindings.
	 * After creating the instance tree ports are connected to
	 * their peers.
	 * Similar SAPs, Services and layer connections are treated.
	 * Finally expanded (xp) actor classes are created which
	 * contain also inherited state graph items and where RefinedStates
	 * are removed and their contents is relocated.
	 * 
	 * @param models
	 * @param asLibrary
	 * @param debug if true more output is produced
	 * @return the root of the newly created instance model
	 */
	public Root createGeneratorModel(List<RoomModel> models, boolean asLibrary, boolean debug) {
		Root root = ETriceGenFactory.eINSTANCE.createRoot();
		root.getModels().addAll(models);
		root.setLibrary(asLibrary);
		this.debug = debug;

		if (root.isLibrary()) {
			findOptionalActorClasses(root);
		}
		else {
			// create instance model
			
			checkRelayPorts(root);
			
			boolean hasSystem = false;
			for (RoomModel mdl : models) {
				for (LogicalSystem sys : mdl.getSystems()) {
					hasSystem = true;
					SystemInstance si = createLogicalSystemInstance(sys);
					root.getSystemInstances().add(si);
				}
			}
			
			if (!hasSystem) {
				logger.logInfo("GeneratorModelBuilder: no SystemClass found, assuming SubSystemClasses as top level elements");
				for (RoomModel mdl : models) {
					for (SubSystemClass comp : mdl.getSubSystemClasses()) {
						root.getOwnSubSystemInstances().add(createSubSystemInstance(comp, comp.getName()));
					}
				}
			}
			
			createOptionalActorInstanceTrees(root);
			
			connectPorts(root);
			checkPortMultiplicity(root);
			connectServices(root);
			
			matchOptionalActorInstances(root);
			
			setObjectIDs();
		}
		
		// transform actor classes
		createExpandedActorClasses(root);
		
		return root;
	}

	boolean dependenciesSatisfied(WorkItem... items) {
		for (WorkItem item : items) {
			if (!alreadyDone.contains(item))
				return false;
		}
		return true;
	}
	
	/**
	 * @param root
	 */
	private void matchOptionalActorInstances(Root root) {
		assert(dependenciesSatisfied(WorkItem.CONNECT_SERVICES, WorkItem.CREATE_OPTIONAL_INSTANCES)): "dependencies satisfied";
		
		for (SubSystemInstance ssi : root.getSubSystemInstances()) {
			TreeIterator<EObject> it = ssi.eAllContents();
			while (it.hasNext()) {
				EObject obj = it.next();
				if (obj instanceof ActorInterfaceInstance) {
					ActorInterfaceInstance aii = (ActorInterfaceInstance) obj;
					HashSet<ProtocolClass> provided = computeProvidedServices(aii);

					String kind = aii.isArray()?"array":"instance";
					logger.logInfo("matches for optional actor "+kind+": "+aii.getPath());
					
					ActorClass optAC = aii.getActorClass();
					EList<ActorClass> candidates = root.getSubClasses(optAC);
					for (ActorClass candidate : candidates) {
						OptionalActorInstance optAIC = optionalActors.get(candidate);
						HashSet<ProtocolClass> required = new HashSet<ProtocolClass>();
						for (SAPInstance sap : optAIC.getRequiredServices()) {
							required.add(sap.getProtocol());
						}
						if (provided.containsAll(required)) {
							logger.logInfo("  ok: "+optAIC.getActorClass().getName());
							aii.getOptionalInstances().add(optAIC);
						}
						else {
							logger.logInfo("  SAPs not satisfied: "+optAIC.getActorClass().getName());
							for (ProtocolClass pc : required) {
								if (!provided.contains(pc))
									logger.logInfo("    missing protocol: "+pc.getName());
							}
						}
					}
				}
			}
		}
	}

	/**
	 * @param aii
	 */
	private HashSet<ProtocolClass> computeProvidedServices(ActorInterfaceInstance aii) {
		HashSet<ProtocolClass> satisfied = new HashSet<ProtocolClass>();
		EObject inst = aii;
		while (inst instanceof AbstractInstanceImpl) {
			AbstractInstanceImpl sii = (AbstractInstanceImpl) inst;
			for (ServiceImplInstance svc: sii.protocol2service.values()) {
				if (!satisfied.contains(svc.getProtocol())) {
					aii.getProvidedServices().add(svc);
					satisfied.add(svc.getProtocol());
				}
			}
			
			inst = inst.eContainer();
		}
		
		return satisfied;
	}

	private void findOptionalActorClasses(Root root) {
		HashSet<ActorClass> optionalActorClasses = new HashSet<ActorClass>();
		for (RoomModel mdl : root.getModels()) {
			for (ActorClass ac : mdl.getActorClasses()) {
				for (ActorRef ar : ac.getActorRefs()) {
					if (ar.getRefType()==ReferenceType.OPTIONAL)
						optionalActorClasses.add(ar.getType());
				}
			}
		}
		root.getOptionalActorClasses().addAll(optionalActorClasses);
	}
	
	/**
	 * Create all optional actor instance trees.
	 * To determine the needed ones each {@link ActorInterfaceInstance} has to get the list of sub classes
	 * and determine matches.
	 * 
	 * To be able to determine matches the provided and required services have to be computed and compared.
	 * So this method must be called after {@link #connectServices(Root)} ran.
	 * 
	 * @param root
	 */
	private void createOptionalActorInstanceTrees(Root root) {
		root.computeSubClasses();
		
		/* determine all optional actor classes
		 * 
		 * For the sake of simplicity we have to do this for all models to really get all possibilities.
		 * Otherwise if we start from the SubSystems and descend until we hit an
		 * optional actor we might get further optional actors when considering
		 * all possible instance sub trees. This would require a complicated iteration
		 * until all optional actors are found.
		 */
		for (RoomModel mdl : root.getModels()) {
			for (ActorClass ac : mdl.getActorClasses()) {
				for (ActorRef ar : ac.getActorRefs()) {
					if (ar.getRefType()==ReferenceType.OPTIONAL)
						optionalActors.put(ar.getType(), null);
				}
			}
		}
		
		// all optional actor classes as interfaces
		root.getOptionalActorClasses().addAll(optionalActors.keySet());

		// now compute all possible actor classes for optional actors (omit abstract types)
		ArrayList<ActorClass> optional = new ArrayList<ActorClass>(optionalActors.keySet());
		for (ActorClass ac : optional) {
			EList<ActorClass> subCls = root.getSubClasses(ac);
			for (ActorClass subCl : subCls) {
				if (!subCl.isAbstract())
					optionalActors.put(subCl, null);
			}
			if (ac.isAbstract())
				optionalActors.remove(ac);
		}
		
		for (Entry<ActorClass, OptionalActorInstance> entry : optionalActors.entrySet()) {
			OptionalActorInstance ai = ETriceGenFactory.eINSTANCE.createOptionalActorInstance();
			recursivelyCreateActorInstances(ai, entry.getKey(), entry.getKey().getName(), -1);
			entry.setValue(ai);
			root.getOptionalInstances().add(ai);
			
			for (PortInstance pi : ai.getPorts()) {
				if (pi.getKind()==PortKind.RELAY)
					pi.setKind(PortKind.INTERFACE);
			}
		}
		
		for (OptionalActorInstance optAI : optionalActors.values()) {
			createServiceMappings(optAI);
			
			bindSAPs(optAI, optAI.getRequiredServices());
		}
		
		alreadyDone.add(WorkItem.CREATE_OPTIONAL_INSTANCES);
	}

	/**
	 * Connect all services hierarchically. This finally connects SAPs with corresponding services
	 * according to layer connections.
	 * 
	 * @param root
	 */
	private void connectServices(Root root) {
		createServiceMappings(root);
		bindSAPs(root);
		
		alreadyDone.add(WorkItem.CONNECT_SERVICES);
	}

	/**
	 * Hierarchically create service mappings at each starting point of layer connections (root level).
	 * 
	 * @param root
	 */
	private void createServiceMappings(Root root) {
		assert(dependenciesSatisfied(WorkItem.CREATE_INSTANCES, WorkItem.CREATE_BINDINGS)): "dependencies satisfied";
		for (SubSystemInstance comp : root.getSubSystemInstances()) {
			createServiceMappings(comp);
		}
	}
	
	/**
	 * Hierarchically create service mappings at each starting point of layer connections (recursively for all structure instances).
	 * 
	 * @see createServiceMappings
	 * @param si
	 */
	private void createServiceMappings(StructureInstance si) {
		for (ConnectionInstance ci : si.getConnections()) {
			if (ci.getFromSPP()==null) {
				// this connection originates at an actor instance
				addService(ci.getFromAI(), ci);
			}
			else if (ci.getFromSPP().getIncoming().isEmpty()) {
				// this connection originates at an SPP instance which is not connected outside
				addService(si, ci);
			}
		}
		
		// recursive call for all children
		for (ActorInstance child : si.getActorInstances()) {
			createServiceMappings(child);
		}
	}

	/**
	 * Determines a connected service and attaches it to the protocol2service mapping
	 * of a structure instance
	 * 
	 * @param si
	 * @param ci
	 */
	private void addService(AbstractInstance si, ConnectionInstance ci) {
		assert(si instanceof AbstractInstanceImpl): "unknown implementation "+si.eClass().getName();
		AbstractInstanceImpl sii = (AbstractInstanceImpl) si;
		
		ProtocolClass pc = ci.getToSPP().getSpp().getProtocol();
		if (sii.protocol2service.get(pc)!=null) {
			
			// this protocol is already handled on this level
			
			EObject obj = null;
			if (si instanceof ActorInstance)
				obj = ((ActorInstance)si).getActorClass();
			else if (si instanceof ActorInterfaceInstance)
				obj = ((ActorInterfaceInstance)si).getActorClass();
			else if (si instanceof SubSystemInstance)
				obj = ((SubSystemInstance)si).getSubSystemClass();
			else
				obj = si;
			diagnostician.error("A service can only be offered once per actor instance, consider pushing one down to a contained actor!", obj, RoomPackage.eINSTANCE.getActorContainerClass_IfSPPs());
		}
		else {
			if (ci.getFromSPP()!=null && ci.getFromSPP().getSpp().getProtocol()!=pc) {
				diagnostician.error("Layer connection must connect same protocols!", ci.getConnection(), RoomPackage.eINSTANCE.getLayerConnection_From());
			}
			else {
				// now we follow the layer connections
				while(true) {
					SPPInstance sppi = ci.getToSPP();
					if (sppi.getOutgoing()==null) {
						// we reached the end, find the ServiceImplementation
						boolean found = false;
						if (sppi.eContainer() instanceof ActorInstance) {
							ActorInstance implementor = (ActorInstance) sppi.eContainer();
							for (ServiceImplInstance svc : implementor.getServices()) {
								if (svc.getSvcImpl().getSpp()==sppi.getSpp()) {
									found = true;
									sii.protocol2service.put(pc, svc);
								}
							}
						}
						else {
							assert(false);
						}
						if (!found) {
							ActorContainerClass acr = (ActorContainerClass) sppi.getSpp().eContainer();
							int idx = acr.getIfSPPs().indexOf(sppi.getSpp());
							diagnostician.error("An SPP mus be connected by a layer connection or implemented by a ServiceImplementation!", sppi.getSpp(), RoomPackage.eINSTANCE.getActorContainerClass_IfSPPs(), idx);
						}
						return;
					}
					else {
						ci = sppi.getOutgoing();
						if (ci.getToSPP().getSpp().getProtocol()!=pc) {
							diagnostician.error("Layer connection must connect same protocols!", ci.getConnection(), RoomPackage.eINSTANCE.getLayerConnection_From());
							return;
						}
					}
				}
			}
		}
	}

	/**
	 * Connect a SAP to its service (root level)
	 * 
	 * @param root
	 */
	private void bindSAPs(Root root) {
		ArrayList<SAPInstance> unsatisfied = new ArrayList<SAPInstance>();
		
		for (SubSystemInstance comp : root.getSubSystemInstances()) {
			bindSAPs(comp, unsatisfied);
		}
		
		for (SAPInstance sap : unsatisfied) {
			ActorClass ac = (ActorClass) sap.getSap().eContainer();
			int idx = ac.getStrSAPs().indexOf(sap.getSap());
			diagnostician.error("SAP "+sap.getPath()+" not satisfied!", ac, RoomPackage.eINSTANCE.getActorClass_StrSAPs(), idx);
		}
	}

	/**
	 * Connect a SAP to its service (recursively for all structure instances).
	 * 
	 * @param si a StructureInstance
	 * @param unsatisfied a list of unsatisfied SAPs (to be returned)
	 */
	private void bindSAPs(StructureInstance si, List<SAPInstance> unsatisfied) {
		for (SAPInstance sap : si.getSaps()) {
			if (!bindSAP(si, sap))
				unsatisfied.add(sap);
		}

		// recursive call for all children
		for (ActorInstance child : si.getActorInstances()) {
			bindSAPs(child, unsatisfied);
		}
	}

	/**
	 * Do the actual binding of a SAP instance.
	 * 
	 * @param si
	 * @param sap
	 * 
	 * @return {@code true} if the SAP could be satisfied
	 */
	private boolean bindSAP(StructureInstance si, SAPInstance sap) {
		assert(si instanceof StructureInstanceImpl);
		StructureInstanceImpl sii = (StructureInstanceImpl) si;
		
		// walk up the container hierarchy until the sap is satisfied
		do {
			ServiceImplInstance svc = sii.protocol2service.get(sap.getSap().getProtocol());
			if (svc!=null) {
				sap.getPeers().add(svc);
				svc.getPeers().add(sap);
				return true;
			}
			if (sii.eContainer() instanceof StructureInstanceImpl)
				sii = (StructureInstanceImpl) sii.eContainer();
			else
				sii = null;
		}
		while (sii!=null);
		
		return false;
	}

	/**
	 * Check the consistency of data driven port bindings
	 * 
	 * @param root - the root object
	 */
	private void checkRelayPorts(Root root) {
		for (RoomModel model : root.getModels()) {
			for (ActorClass ac : model.getActorClasses()) {
				
				// check own relay ports
				for (Port port : ac.getRelayPorts()) {
					
					if (port.getProtocol() instanceof ProtocolClass && ((ProtocolClass)port.getProtocol()).getCommType()==CommunicationType.DATA_DRIVEN) {
						if (port.isConjugated()) {
							// check whether relay port is multiply connected
							int count = 0;
							for (Binding b : ac.getBindings()) {
								if (b.getEndpoint1().getPort()==port)
									++count;
								if (b.getEndpoint2().getPort()==port)
									++count;
							}
							if (count>1) {
								int idx = ac.getIfPorts().indexOf(port);
								diagnostician.error("data driven conjugate relay port is multiply connected inside its actor class", ac, RoomPackage.eINSTANCE.getActorClass_IfPorts(), idx);
							}
						}
					}
				}
			}
		}
	}

	/**
	 * this method loops over all InstaneBase objects and sets the ObjId. It starts enumerating at
	 * offset {@link OBJ_ID_OFFSET}
	 */
	private void setObjectIDs() {
		int counter = 0;
		for (InstanceBase obj : allObjects) {
			if (obj instanceof SubSystemInstance) {
				counter = OBJ_ID_OFFSET;
				obj.setObjId(counter++);
			}
			else if (obj instanceof ActorInstance) {
				obj.setObjId(counter++);
			}
			else if (obj instanceof PortInstance) {
				PortInstance pi = (PortInstance) obj;
				// relay ports are not instantiated and thus have no object ID
				if (pi.getKind()!=PortKind.RELAY) {
					// replicated ports have subsequent object IDs
					int multiplicity = pi.getPort().getMultiplicity();
					if (multiplicity==-1)
						multiplicity = pi.getPeers().size();
					pi.setObjId(counter);
					counter += multiplicity;
				}
			}
			else if (obj instanceof SAPInstance) {
				obj.setObjId(counter++);
			}
			else if (obj instanceof ServiceImplInstance) {
				ServiceImplInstance svc = (ServiceImplInstance) obj;
				svc.setObjId(counter);
				counter += svc.getPeers().size();
			}
		}
	}
	
	private SystemInstance createLogicalSystemInstance(LogicalSystem sys) {
		logger.logInfo("GeneratorModelBuilder: creating system class from "+sys.getName());
		
		SystemInstance instance = ETriceGenFactory.eINSTANCE.createSystemInstance();
		allObjects.add(instance);
		
		instance.setName(sys.getName());
		instance.setLogicalSystem(sys);
		
		for (SubSystemRef sr : sys.getSubSystems()) {
			SubSystemInstance ssi = createSubSystemInstance(sr.getType(), sr.getName());
			instance.getInstances().add(ssi);
		}
		
		return instance;
	}
	
	/**
	 * hierarchically (i.e. recursively) creates all instances implied by this component
	 * @param ssc the component class
	 * @param name the name to be used for the instance
	 * @return the newly created hierarchy of instances
	 */
	private SubSystemInstance createSubSystemInstance(SubSystemClass ssc, String name) {
		logger.logInfo("GeneratorModelBuilder: creating subsystem instance from "+name);

		SubSystemInstance instance = ETriceGenFactory.eINSTANCE.createSubSystemInstance();
		allObjects.add(instance);
		
		instance.setName(name);
		instance.setSubSystemClass(ssc);
		
		// TODOHRR: enumerate object ids per thread
		
		for (ActorRef ar : ssc.getActorRefs()) {
			addRefInstances(instance, ar);
		}
		
		// bindings are handled now since port instances of sub-actor instances are available
		new BindingUtil(instance, diagnostician).createBindingInstances();
		createConnectionInstances(instance, ssc.getConnections());
		
		alreadyDone.add(WorkItem.CREATE_INSTANCES);
		alreadyDone.add(WorkItem.CREATE_BINDINGS);
		
		return instance;
	}
	
	/**
	 * hierarchically (i.e. recursively) creates all instances implied by this actor ref
	 * 
	 * @param aref
	 * @return
	 */
	private StructureInstance recursivelyCreateActorInstances(ActorRef aref) {
		return recursivelyCreateActorInstances(aref, -1);
	}
	
	/**
	 * hierarchically (i.e. recursively) creates all instances implied by this actor ref
	 * 
	 * @param aref - create the instance sub-tree of this actor reference
	 * @param idx - index in replication array or -1 if no replication 
	 * @return the newly created actor instance
	 */
	private StructureInstance recursivelyCreateActorInstances(ActorRef aref, int idx) {
		String name = aref.getName();
		if (idx>=0)
			name += "_"+idx;
		
		if (debug)
			logger.logInfo("GeneratorModelBuilder: creating actor instance "+name+" from "+aref.getType().getName());

		ActorInstance ai = ETriceGenFactory.eINSTANCE.createActorInstance();
		return recursivelyCreateActorInstances(ai, aref.getType(), name, idx);
	}

	private StructureInstance recursivelyCreateActorInstances(StructureInstance ai, ActorClass ac, String name, int idx) {
		allObjects.add(ai);
		
		ai.setName(name);
		if (ai instanceof ActorInstance) {
			((ActorInstance)ai).setActorClass(ac);
			if (idx>=0)
				((ActorInstance)ai).setReplIdx(idx);
		}
		else if (ai instanceof OptionalActorInstance)
			((OptionalActorInstance)ai).setActorClass(ac);

		// get a list of super classes, super first, sub-classes last
		List<ActorClass> classes = RoomHelpers.getClassHierarchy(ac);
		
		// create instances for super classes recursively (ports, actor refs and bindings)
		// super classes first ensures that actor refs are present when bindings are created
		for (ActorClass acl : classes) {
			// first we add our port instances to have them numbered subsequently
			createPortInstances(ai, acl);
			createServiceRelatedInstances(ai, acl);
			
			// recurse down into sub-actors
			for (ActorRef ar : acl.getActorRefs()) {
				addRefInstances(ai, ar);
			}
			
		}
		
		// bindings and layer connections are handled now since port instances of sub-actor instances are available
		// this has to be done in one step per actor instance
		// so we collect all bindings and connections first
		new BindingUtil(ai, diagnostician).createBindingInstances();
		ArrayList<LayerConnection> connections = new ArrayList<LayerConnection>();
		for (ActorClass acl : classes) {
			connections.addAll(acl.getConnections());
		}
		createConnectionInstances(ai, connections);
		
		return ai;
	}
	
	/**
	 * @param ar
	 * @return
	 */
	private ActorInterfaceInstance createActorInterfaceInstance(ActorRef aref) {
		String name = aref.getName();
		
		if (debug)
			logger.logInfo("GeneratorModelBuilder: creating actor interface instance "+name+" from "+aref.getType().getName());

		ActorInterfaceInstance ai = ETriceGenFactory.eINSTANCE.createActorInterfaceInstance();
		allObjects.add(ai);
		
		ai.setName(name);
		ActorClass ac = aref.getType();
		ai.setActorClass(ac);
		ai.setArray(aref.getSize()<0);
		
		for (ActorClass acl : RoomHelpers.getClassHierarchy(ac)) {
			createPortInstances(ai, acl);
		}
		
		for (PortInstance pi : ai.getPorts()) {
			pi.setKind(PortKind.INTERFACE);
		}
		
		return ai;
	}

	/**
	 * create instances for this actor ref
	 * 
	 * @param si the container structure instance
	 * @param ar the actor ref
	 */
	private void addRefInstances(StructureInstance si, ActorRef ar) {
		if (ar.getRefType()==ReferenceType.OPTIONAL) {
			si.getInstances().add(createActorInterfaceInstance(ar));
		}
		else if (ar.getSize()>1) {
			for (int idx=0; idx<ar.getSize(); ++idx)
				si.getInstances().add(recursivelyCreateActorInstances(ar, idx));
		}
		else
			si.getInstances().add(recursivelyCreateActorInstances(ar));
	}
	
	/**
	 * create port instances for every kind of port
	 * @param ai - the currently considered abstract instance
	 * @param ac - the actor class (might be a base class)
	 */
	private void createPortInstances(AbstractInstance ai, ActorClass ac) {
		createPortInstances(ac.getExternalEndPorts(), PortKind.EXTERNAL, ai);
		if (ai instanceof ActorInstance)
			createPortInstances(ac.getIntPorts(), PortKind.INTERNAL, ai);
		createPortInstances(ac.getRelayPorts(), PortKind.RELAY, ai);
	}

	/**
	 * Create port instances for all ports with the given kind
	 * @param ports a list of {@link Port}s
	 * @param kind a {@link PortKind}
	 * @param ai the {@link AbstractInstance} that owns the port instances
	 */
	private void createPortInstances(EList<Port> ports, PortKind kind, AbstractInstance ai) {
		for (Port port : ports) {
			PortInstance pi = ETriceGenFactory.eINSTANCE.createPortInstance();
			allObjects.add(pi);
			
			pi.setName(port.getName());
			pi.setPort(port);
			pi.setKind(kind);
			
			ai.getPorts().add(pi);
		}
	}
	
	/**
	 * create sap, spp and service instances
	 * @param ai - the currently considered actor instance
	 * @param ac - the actor class (might be a base class)
	 */
	private void createServiceRelatedInstances(StructureInstance ai, ActorClass ac) {
		for (SAPRef sap : ac.getStrSAPs()) {
			SAPInstance si = ETriceGenFactory.eINSTANCE.createSAPInstance();
			allObjects.add(si);
			si.setName(sap.getName());
			si.setSap(sap);
			
			ai.getSaps().add(si);
		}
		for (SPPRef sap : ac.getIfSPPs()) {
			SPPInstance si = ETriceGenFactory.eINSTANCE.createSPPInstance();
			allObjects.add(si);
			si.setName(sap.getName());
			// SPPs are not instantiated and thus need no object ID
			//si.setObjId(objCounter.getAndIncrementCount());
			si.setSpp(sap);
			
			ai.getSpps().add(si);
		}
		for (ServiceImplementation svcimpl : ac.getServiceImplementations()) {
			ServiceImplInstance sii = ETriceGenFactory.eINSTANCE.createServiceImplInstance();
			allObjects.add(sii);
			sii.setName(svcimpl.getSpp().getName());
			//will set the object ID later when we know all connected saps
			//sii.setObjId(objCounter.getAndIncrementCount());
			sii.setSvcImpl(svcimpl);
			
			ai.getServices().add(sii);
		}
	}

	/**
	 * Create layer connection instances.
	 * @param si - create layer connections for this actor instance
	 * @param connections - a list of layer connections
	 */
	private void createConnectionInstances(StructureInstance si, List<LayerConnection> connections) {
		for (LayerConnection lc : connections) {
			
			SPPoint to = lc.getTo();
			SPPInstance toSPPinst = getSPPInstance(si, to.getRef(), to.getService());

			SAPoint from = lc.getFrom();
			if (from instanceof RefSAPoint) {
				if (((RefSAPoint)from).getRef() instanceof ActorRef) {
					List<AbstractInstance> fromInstances = getSubInstances(si, ((ActorRef)((RefSAPoint)from).getRef()));
					for (AbstractInstance fromInst : fromInstances) {
						ConnectionInstance ci = ETriceGenFactory.eINSTANCE.createConnectionInstance();
						ci.setConnection(lc);
						ci.setFromAI(fromInst);
						ci.setToSPP(toSPPinst);
						si.getConnections().add(ci);
					}
				}
				else {
					//TODOHRR: handle SubSystemRef
					System.err.println("error");
				}
			}
			else if (from instanceof RelaySAPoint) {
				SPPInstance fromSPPinst = getSPPInstance(si, null, ((RelaySAPoint)from).getRelay());
				if (fromSPPinst.getOutgoing()!=null) {
					ActorContainerClass acr = (ActorContainerClass) fromSPPinst.getSpp().eContainer();
					int idx = acr.getIfSPPs().indexOf(fromSPPinst.getSpp());
					diagnostician.error("SPPRef has several outgoing layer connections!", fromSPPinst.getSpp(), RoomPackage.eINSTANCE.getActorContainerClass_IfSPPs(), idx);
				}
				ConnectionInstance ci = ETriceGenFactory.eINSTANCE.createConnectionInstance();
				ci.setConnection(lc);
				ci.setFromSPP(fromSPPinst);
				ci.setToSPP(toSPPinst);
				si.getConnections().add(ci);
			}
			else {
				assert(false): "unknown type of "+from.eClass().getName();
			}
			
		}
	}
	
	/**
	 * Returns the endpoint of a layer connection.
	 * 
	 * @param si
	 * @param ar
	 * @param spp
	 * @return
	 */
	private SPPInstance getSPPInstance(AbstractInstance si, ActorContainerRef ar, SPPRef spp) {
		if (ar==null && si instanceof StructureInstance) {
			for (SPPInstance sppi : ((StructureInstance)si).getSpps()) {
				if (sppi.getSpp()==spp)
					return sppi;
			}
		}
		else {
			if (ar instanceof ActorRef) {
				List<AbstractInstance> subais = getSubInstances(si, (ActorRef)ar);
				if (!subais.isEmpty())
					return getSPPInstance(subais.get(0), null, spp);
			}
			else if (ar instanceof SubSystemRef) {
				// TODOHRR: handle SubSystemRef
			}
		}
		return null;
	}
	
	/**
	 * Returns all actor instances corresponding to an ActorRef (one for scalar, several for array).
	 * 
	 * @param si
	 * @param ar
	 * @return
	 */
	private List<AbstractInstance> getSubInstances(AbstractInstance si, ActorRef ar) {
		ArrayList<AbstractInstance> result = new ArrayList<AbstractInstance>();

		if (si instanceof StructureInstance) {
			for (AbstractInstance subai : ((StructureInstance) si)
					.getInstances()) {
				if (subai instanceof ActorInstance) {
					if (((ActorInstance) subai).getUnindexedName().equals(ar.getName())) {
						result.add(subai);
					}
				}
				else if (subai.getName().equals(ar.getName())) {
					result.add(subai);
				}
			}
		}

		return result;
	}
	
	/**
	 * set peer ports in the whole instance model
	 * @param root
	 */
	private void connectPorts(Root root) {
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof AbstractInstance) {
				for (PortInstance pi : ((AbstractInstance) obj).getPorts()) {
					if (pi.getKind()!=PortKind.RELAY) {
						List<PortInstance> peers = getFinalPeers(pi, null, null);
						pi.getPeers().addAll(peers);
						// we don't have to add pi to its peer.peers since we do that once we reach there
					}
				}
			}
		}
		
		// check for situations where bindings fan out on both sides of a relay port
		// i.e. a port has several peers and each peer in turn has several peers
		it = root.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof AbstractInstance) {
				for (PortInstance pi : ((AbstractInstance) obj).getPorts()) {
					if (pi.getKind()!=PortKind.RELAY && pi.getPeers().size()>1)
						if (pi.getPeers().get(0).getPeers().size()>1) {
							BindingInstance bi = pi.getBindings().get(0);
							if (bi.getPorts().get(0).getKind()==PortKind.RELAY
									|| bi.getPorts().get(1).getKind()==PortKind.RELAY)
								connectPeersOneToOne(pi);
						}
				}
			}
		}
	}

	/**
	 * determine final peers of an end port
	 * @param pi - a end port
	 * @param from - the binding from which we reached pi or null if start
	 * @return a list of final peer port instances (end ports themselves)
	 */
	private List<PortInstance> getFinalPeers(PortInstance pi, BindingInstance from, SubProtocol fromSub) {
		List<PortInstance> peers = new LinkedList<PortInstance>();
		
		for (BindingInstance bi : pi.getBindings()) {
			if (bi==from)
				// skip the binding where we came from
				continue;
			
			if (from!=null && from.eContainer()==bi.eContainer())
				// the container of a binding instance is a StructureInstance
				// by this we make sure that we go from inside to outside or vice versa
				continue;
			
			SubProtocol mySub = getMySubProtocol(pi, bi);
			if (mySub!=null && fromSub!=null && fromSub!=mySub)
				// we follow only same sub protocols
				continue;
			
			PortInstance end = (bi.getPorts().get(0)!=pi)? bi.getPorts().get(0) : bi.getPorts().get(1);
			if (end.getKind()==PortKind.RELAY) {
				SubProtocol peerSub = getPeerSubProtocol(pi, bi);
				if (peerSub!=null)
					fromSub = peerSub;
				
				// continue recursion
				peers.addAll(getFinalPeers(end, bi, fromSub));
			}
			else {
				
				// this is a final peer
				peers.add(end);
			}
		}
		return peers;
	}

	private SubProtocol getMySubProtocol(PortInstance pi, BindingInstance bi) {
		return (bi.getPorts().get(0)==pi)? bi.getBinding().getEndpoint1().getSub() : bi.getBinding().getEndpoint2().getSub();
	}

	private SubProtocol getPeerSubProtocol(PortInstance pi, BindingInstance bi) {
		return (bi.getPorts().get(0)!=pi)? bi.getBinding().getEndpoint1().getSub() : bi.getBinding().getEndpoint2().getSub();
	}
	
	private void connectPeersOneToOne(PortInstance pi) {
		HashSet<InterfaceItemInstance> thisSide = new HashSet<InterfaceItemInstance>(pi.getPeers());
		HashSet<InterfaceItemInstance> thatSide = new HashSet<InterfaceItemInstance>(pi.getPeers().get(0).getPeers());
		
		// consistency checks
		if (!Collections.disjoint(thisSide, thatSide)) {
			assert(false): "sets expected to be disjoint";
			return;
		}
		for (InterfaceItemInstance pi1 : thisSide) {
			if (!isSameCollection(thatSide, pi1.getPeers())) {
				assert(false): "expected reciprocal peer lists";
			}
		}
		for (InterfaceItemInstance pi2 : thatSide) {
			if (!isSameCollection(thisSide, pi2.getPeers())) {
				assert(false): "expected reciprocal peer lists";
			}
		}
		
		// connect one to one (with multiplicity)
		boolean thisGreaterThat = totalSize(thisSide)>totalSize(thatSide);
		Iterator<InterfaceItemInstance> lit = thisGreaterThat? thisSide.iterator() : thatSide.iterator();
		Iterator<InterfaceItemInstance> sit = thisGreaterThat? thatSide.iterator() : thisSide.iterator();
		while (sit.hasNext() && lit.hasNext()) {
			InterfaceItemInstance first = lit.next();
			InterfaceItemInstance second = sit.next();
			first.getPeers().clear();
			first.getPeers().add(second);
			second.getPeers().clear();
			second.getPeers().add(first);
		}
		
		// report unconnected ports
		while (lit.hasNext()) {
			InterfaceItemInstance item = lit.next();
			reportPortInstanceError(item, "port '"+item.getPath()+"'could not be connected");
		}
	}

	private void reportPortInstanceError(InterfaceItemInstance item, String msg) {
		if (item.eContainer() instanceof ActorInstance) {
			ActorClass ac = ((ActorInstance)item.eContainer()).getActorClass();
			Port port = ((PortInstance)item).getPort();
			EStructuralFeature feat = ac.getIfPorts().contains(port)?
					RoomPackage.Literals.ACTOR_CLASS__INT_PORTS: RoomPackage.Literals.ACTOR_CLASS__IF_PORTS;
			int idx = ac.getIfPorts().indexOf(port);
			if (idx<0)
				ac.getIntPorts().indexOf(port);
			diagnostician.warning(msg, ac, feat, idx);
		}
		else {
			assert(false): "SubSystems can only have relay ports";
		}
	}
	
	private int totalSize(Collection<InterfaceItemInstance> coll) {
		int size = 0;
		for (InterfaceItemInstance ii : coll) {
			if (ii instanceof PortInstance) {
				int multiplicity = ((PortInstance) ii).getPort().getMultiplicity();
				if (multiplicity!=1)
					reportPortInstanceError(ii, "port '"+ii.getPath()+"' must have multiplicity 1");
				size += multiplicity;
			}
			else {
				assert(false): "should be called with PortInstances onl";
			}
		}
		return size;
	}

	private boolean isSameCollection(Collection<InterfaceItemInstance> coll1, Collection<InterfaceItemInstance> coll2) {
		for (InterfaceItemInstance ii : coll1) {
			if (!coll2.contains(ii))
				return false;
		}
		for (InterfaceItemInstance ii : coll2) {
			if (!coll1.contains(ii))
				return false;
		}
		return true;
	}

	/**
	 * check that the number of peer ports does not exceed the multiplicity of a port
	 * @param root
	 */
	private void checkPortMultiplicity(Root root) {
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj instanceof ActorInstance) {
				ActorInstance ai = (ActorInstance) obj;
				ActorClass ac = ai.getActorClass();
				for (PortInstance pi : ai.getPorts()) {
					if (pi.getKind()!=PortKind.RELAY) {
						if (pi.getProtocol().getCommType()==CommunicationType.EVENT_DRIVEN) {
							if (pi.getBindings().size()>pi.getPort().getMultiplicity() && pi.getPort().getMultiplicity()!=-1) {
								EStructuralFeature feature = RoomPackage.eINSTANCE.getActorClass_IfPorts();
								int idx = ac.getIfPorts().indexOf(pi.getPort());
								if (idx<0) {
									feature = RoomPackage.eINSTANCE.getActorClass_IntPorts();
									idx = ac.getIntPorts().indexOf(pi.getPort());
								}
								diagnostician.error("number of peers ("+pi.getBindings().size()
										+ ") of port '"+pi.getName()
										+"' exceeds multiplicity "+pi.getPort().getMultiplicity()
										+" in instance "+ai.getPath(), ac, feature, idx);
							}
						}
					}
				}
			}
			else if (obj instanceof SubSystemInstance) {
				SubSystemInstance ssi = (SubSystemInstance) obj;
				SubSystemClass ssc = ssi.getSubSystemClass();
				for (PortInstance pi : ssi.getPorts()) {
					EReference feature = RoomPackage.eINSTANCE.getSubSystemClass_RelayPorts();
					int idx = ssc.getRelayPorts().indexOf(pi.getPort());
					
					diagnostician.error("number of peers ("+pi.getBindings().size()
							+ ") of port '"+pi.getName()
							+"' exceeds multiplicity "+pi.getPort().getMultiplicity()
							+" in instance "+ssi.getPath(), ssc, feature, idx);
				}
			}
		}
	}

	/**
	 * expanded (xp) actor classes are created which
	 * contain also inherited features and where RefinedStates
	 * are removed and their contents is relocated.
	 * @param root - the model root
	 */
	private void createExpandedActorClasses(Root root) {
		for (ActorClass ac : root.getUsedActorClasses()) {
			root.getXpActorClasses().add(createExpandedActorClass(ac));
		}
	}

	/**
	 * create an expanded actor class from the original model class
	 * @param ac - the original model class
	 * @return - the newly created expanded actor class
	 */
	public ExpandedActorClass createExpandedActorClass(ActorClass ac) {
		if (debug)
			logger.logInfo("GeneratorModelBuilder: creating expanded actor class from "+ac.getName()
					+" of "+((RoomModel)ac.eContainer()).getName());

		ExpandedActorClass xpac = ETriceGenFactory.eINSTANCE.createExpandedActorClass();
		xpac.setActorClass(ac);
		
		xpac.prepare(diagnostician);
		
		return xpac;
	}
}
