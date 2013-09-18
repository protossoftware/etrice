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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.common.base.BooleanLiteral;
import org.eclipse.etrice.core.common.base.IntLiteral;
import org.eclipse.etrice.core.common.base.Literal;
import org.eclipse.etrice.core.common.base.RealLiteral;
import org.eclipse.etrice.core.common.base.StringLiteral;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Annotation;
import org.eclipse.etrice.core.room.AnnotationAttribute;
import org.eclipse.etrice.core.room.AnnotationTargetType;
import org.eclipse.etrice.core.room.AnnotationType;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.ChoicePoint;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.CompoundProtocolClass;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.DetailCode;
import org.eclipse.etrice.core.room.Documentation;
import org.eclipse.etrice.core.room.EnumAnnotationAttribute;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.KeyValue;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.MessageFromIf;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RefPath;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.room.RefinedState;
import org.eclipse.etrice.core.room.RefinedTransition;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.SimpleAnnotationAttribute;
import org.eclipse.etrice.core.room.SimpleState;
import org.eclipse.etrice.core.room.StandardOperation;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.TrPoint;
import org.eclipse.etrice.core.room.Transition;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.validation.ValidationUtil.Result;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.validation.Check;

import com.google.inject.Inject;

 

public class RoomJavaValidator extends AbstractRoomJavaValidator {

	/* message strings */
	public static final String OPTIONAL_REFS_HAVE_TO_HAVE_MULTIPLICITY_ANY = "optional refs have to have multiplicity any [*]";
	public static final String MULTIPLICITY_ANY_REQUIRES_OPTIONAL = "multiplicity any [*] requires optional";
	public static final String A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER = "a replicated port must have at most one replicated peer";
	
	/* tags for quick fixes */
	public static final String THREAD_MISSING = "RoomJavaValidator.ThreadMissing";
	public static final String DUPLICATE_ACTOR_INSTANCE_MAPPING = "RoomJavaValidator.DuplicateActorInstanceMapping";
	public static final String WRONG_NAMESPACE = "RoomJavaValidator.WrongNamespace";
	public static final String CIRCULAR_CONTAINMENT = "RoomJavaValidator.CircularContainment";
	public static final String ACTOR_REF_CHANGE_REF_TYPE_TO_FIXED_OR_MULT_TO_ANY = "RoomJavaValidator.ActorRefChangeRefTypeToFixed";
	public static final String ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL = "RoomJavaValidator.ActorRefChangeRefTypeToOptional";
	public static final String CHANGE_DESTRUCTOR_NAME = "RoomJavaValidator.ChangeDestructorName";
	public static final String CHANGE_CONSTRUCTOR_NAME = "RoomJavaValidator.ChangeConstructorName";
	
	@Inject ImportUriResolver importUriResolver;
	
	@Check
	public void checkImportedNamespace(Import imp) {
		if (imp.getImportedNamespace()==null)
			return;
		
		if (imp.getImportURI()==null)
			return;
		
		String uriString = importUriResolver.resolve(imp);
		
		URI uri = URI.createURI(uriString);
		ResourceSet rs = new ResourceSetImpl();

		try {
			Resource res = rs.getResource(uri, true);
			if (res==null)
				return;
			
			if (res.getContents().isEmpty()) {
				error("referenced model is empty", RoomPackage.Literals.IMPORT__IMPORT_URI);
				return;
			}
			
			if (!(res.getContents().get(0) instanceof RoomModel)) {
				if (uri.lastSegment().endsWith(".room"))
					error("referenced model is no ROOM model (but has .room extension)", RoomPackage.Literals.IMPORT__IMPORT_URI);
				else
					warning("referenced model is no ROOM model", RoomPackage.Literals.IMPORT__IMPORT_URI);
				return;
			}
			
			RoomModel model = (RoomModel) res.getContents().get(0);
			if (!imp.getImportedNamespace().equals(model.getName()+".*")) {
				error("the imported namespace should be '"+model.getName()+".*'", RoomPackage.Literals.IMPORT__IMPORTED_NAMESPACE, WRONG_NAMESPACE, model.getName()+".*");
			}
		}
		catch (RuntimeException re) {
			warning("could not load referenced model", RoomPackage.Literals.IMPORT__IMPORT_URI);
			return;
		}
	}
	
	@Check
	public void checkActorRef(ActorRef ar) {
		if (ar.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) ar.eContainer();
			
			if (ValidationUtil.isReferencing(ar.getType(), ac)) {
				error("Actor reference is circular", RoomPackage.eINSTANCE.getActorRef_Type());
			}
		}
		
		// check actor ref array upper bound
		if (ar.getMultiplicity()<0) {
			// multiplicity * requires optional
			if (ar.getRefType()!=ReferenceType.OPTIONAL)
				error(MULTIPLICITY_ANY_REQUIRES_OPTIONAL,
						RoomPackage.eINSTANCE.getActorRef_RefType(), ACTOR_REF_CHANGE_REF_TYPE_TO_OPTIONAL);
		}
		else if (ar.getMultiplicity()>1) {
			// fixed multiplicity requires fixed type
			if (ar.getRefType()==ReferenceType.OPTIONAL)
				error(OPTIONAL_REFS_HAVE_TO_HAVE_MULTIPLICITY_ANY,
						RoomPackage.eINSTANCE.getActorRef_RefType(), ACTOR_REF_CHANGE_REF_TYPE_TO_FIXED_OR_MULT_TO_ANY, ar.getName());
		}
		
		// check actor ref array has ports with fixed multiplicity
		if (ar!=null) {
			ActorClass ac = ar.getType();
			if (ar.getMultiplicity()>1) {
				for (Port p : ac.getInterfacePorts()) {
					if (p.getMultiplicity()<0) {
						int idx = ((ActorContainerClass)ar.eContainer()).getActorRefs().indexOf(ar);
						error("replicated actor must not have replicated port with arbitrary multiplicity", RoomPackage.Literals.ACTOR_CONTAINER_CLASS__ACTOR_REFS, idx);
					}
				}
			}
		}
	}

	@Check
	public void checkLayerConnectiontarget(LayerConnection lc) {
		if (lc.getTo().getRef() instanceof ActorRef)
			if (((ActorRef)lc.getTo().getRef()).getMultiplicity()>1) {
				int idx = ((StructureClass)lc.eContainer()).getConnections().indexOf(lc);
				error("layer connection must not connect to replicated actor", RoomPackage.Literals.STRUCTURE_CLASS__CONNECTIONS, idx);
			}
	}
	
	@Check
	public void checkBaseClassesNotCircular(DataClass dc) {
		if (dc==null)
			return;
		
		if (ValidationUtil.isCircularClassHierarchy(dc))
			error("Base classes are circular", RoomPackage.eINSTANCE.getDataClass_Base());
	}

	@Check
	public void checkAttributeNotCircular(Attribute att) {
		if (att.eContainer() instanceof ActorClass)
			// no circle possible
			return;
		
		if (att.eContainer() instanceof PortClass)
			// no circle possible
			return;
		
		if (!(att.eContainer() instanceof DataClass)) {
			assert(false): "unexpected parent class";
			return;
		}
		
		DataClass dc = (DataClass) att.eContainer();
		if (ValidationUtil.isCircularClassHierarchy(dc))
			return;
		
		while (dc!=null) {
			if (att.getType().getType()==dc && !att.getType().isRef()) {
				error(
						"Attribute type must not refer to own class or a super class",
						RoomPackage.Literals.ATTRIBUTE__TYPE,
						CIRCULAR_CONTAINMENT,
						""+att.getType().getType().getName().length()
					);
				break;
			}
			
			dc = dc.getBase();
		}
	}
	
	@Check
	public void checkAttributeNoStringArray(Attribute att){
		if(!att.getType().isRef() && att.getType().getType() instanceof PrimitiveType){
			PrimitiveType type = (PrimitiveType)att.getType().getType();
			if(type.getName().equalsIgnoreCase("string") && att.getSize() > 0)
				error("string type must have multiplicity 0", RoomPackage.Literals.ATTRIBUTE__SIZE);
		}
	}
	
	@Check
	public void checkBaseClassesNotCircular(ProtocolClass pc) {
		if (pc==null)
			return;
		
		if (ValidationUtil.isCircularClassHierarchy(pc))
			error("Base classes are circular", RoomPackage.eINSTANCE.getProtocolClass_Base());
	}

	@Check
	public void checkBaseClassesNotCircular(ActorClass ac) {
		if (ac==null)
			return;
		
		if (ValidationUtil.isCircularClassHierarchy(ac))
			error("Base classes are circular", RoomPackage.eINSTANCE.getActorClass_Base());
	}
	
	@Check
	public void checkExecModelConsistent(ActorClass ac) {
		if (ValidationUtil.isCircularClassHierarchy(ac))
			return;
		
		ActorCommunicationType commType = ac.getCommType();
		
		switch (commType) {
		case ASYNCHRONOUS:
			break;
		case DATA_DRIVEN:
			break;
		case EVENT_DRIVEN:
			break;
		case SYNCHRONOUS:
			error("synchronous communication type not supported yet", RoomPackage.eINSTANCE.getActorClass_CommType());
		}
		
		while (ac.getBase()!=null) {
			ac = ac.getBase();

			if (commType!=ac.getCommType())
				error("data_driven attribute not consistent in inheritance hierarchy", RoomPackage.eINSTANCE.getActorClass_CommType());
		}
	}
	
	@Check
	public void checkTopLevelRefinedStates(ActorClass ac) {
		List<Result> errors = ValidationUtil.checkTopLevelRefinedStates(ac);
		for (Result err : errors) {
			error(err);
		}
	}
	
	@Check
	public void checkRefinedStateUnique(RefinedState rs) {
		StateGraph sg = (StateGraph) rs.eContainer();
		TreeIterator<EObject> it = sg.eAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (obj!=rs && obj instanceof RefinedState)
				if (rs.getTarget()==((RefinedState)obj).getTarget()) {
					if (rs.eContainer().eContainer() instanceof ActorClass)
						error("refined state conflicts with nested refined state with same target", RoomPackage.Literals.REFINED_STATE__TARGET);
					else
						error("refined state not unique", RoomPackage.Literals.REFINED_STATE__TARGET);
				}
		}
	}
	
	@Check
	public void checkStateNameUnique(SimpleState s) {
		Result result = ValidationUtil.isUniqueName(s, s.getName());
		if (!result.isOk())
			error(result.getMsg(), RoomPackage.Literals.SIMPLE_STATE__NAME);
	}
	
	@Check  
	public void checkSubSystem(SubSystemClass ssc){
		if (ssc.getActorRefs().isEmpty())
			warning("SubSystemClass must contain at least one ActorRef", RoomPackage.eINSTANCE.getActorContainerClass_ActorRefs());

		if (ssc.getThreads().isEmpty())
			warning("at least one thread has to be defined", RoomPackage.Literals.SUB_SYSTEM_CLASS__THREADS, THREAD_MISSING, "LogicalThread dflt_thread");
		
		checkMappings(ssc.getActorInstanceMappings());
	}

	@Check
	public void checkLogicalSystem(LogicalSystem ls){
		if (ls.getSubSystems().isEmpty())
			error("LogicalSystem must contain at least one SubSystemRef", RoomPackage.eINSTANCE.getLogicalSystem_SubSystems());
	}


	@Check
	public void checkActorInstanceMapping(ActorInstanceMapping aim) {
		ActorContainerClass root = RoomHelpers.getParentContainer(aim);
		if (root != null && !root.eIsProxy()) {
			RefPath path = aim.getPath();
			if (path != null) {
				String invalidSegment = RoomHelpers.checkPath(root, path);
				if (invalidSegment != null)
					error("no match for segment '" + invalidSegment + "'",
							RoomPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
				else {
					ActorRef aRef = RoomHelpers.getLastActorRef(root, path);
					if (aRef != null) {
						if (aRef.getMultiplicity() > 1)
							error("no arrays of actor references supported",
									RoomPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
					} else
						error("invalid actor reference",
								RoomPackage.Literals.ACTOR_INSTANCE_MAPPING__PATH);
				}
			}
		}
		checkMappings(aim.getActorInstanceMappings());
	}
	
	private void checkMappings(EList<ActorInstanceMapping> actorInstanceMappings) {
		HashSet<String> paths = new HashSet<String>();
		for (ActorInstanceMapping aim : actorInstanceMappings) {
			if (!paths.add(RoomHelpers.asString(aim.getPath()))) {
				EObject parent = aim.eContainer();
				int idx = actorInstanceMappings.indexOf(aim);
				error("duplicate mapping", parent, aim.eContainingFeature(), idx, DUPLICATE_ACTOR_INSTANCE_MAPPING);
			}
		}
	}

	@Check
	public void checkPortCompatibility(Binding bind) {
		Result result = ValidationUtil.isValid(bind);
		if (!result.isOk()) {
			EObject sc = bind.eContainer();
			@SuppressWarnings("unchecked")
			int idx = ((List<EObject>)sc.eGet(bind.eContainingFeature())).indexOf(bind);
			error(result.getMsg(), sc, bind.eContainingFeature(), idx);
		}
	}
	
	@Check
	public void checkServiceCompatibility(LayerConnection conn) {
		Result result = ValidationUtil.isValid(conn);
		if (!result.isOk())
			error(result.getMsg(), RoomPackage.eINSTANCE.getLayerConnection_From());
	}
	
	@Check
	public void checkTrPoint(TrPoint tp) {
		Result result = ValidationUtil.isValid(tp);
		if (!result.isOk())
			error(result);
	}
	
	@Check
	public void checkChoicePoint(ChoicePoint cp) {
		if (!ValidationUtil.isUniqueName(cp, cp.getName()).isOk())
			error("name is not unique", RoomPackage.Literals.CHOICE_POINT__NAME);
	}
	
	@Check
	public void checkInterfaceItemUniqueName(InterfaceItem item) {
		Result result = ValidationUtil.isUniqueName(item);
		if (!result.isOk())
			error(result.getMsg(), RoomPackage.eINSTANCE.getInterfaceItem_Name());
	}
	
	@Check
	public void checkTransition(Transition trans) {
		Result result = ValidationUtil.checkTransition(trans);
		if (!result.isOk())
			error(result);

		if (trans instanceof InitialTransition) {
			result = ValidationUtil.isConnectable(null, trans.getTo(), trans, (StateGraph)trans.eContainer());
		}
		else {
			result = ValidationUtil.isConnectable(((NonInitialTransition)trans).getFrom(), trans.getTo(), trans, (StateGraph)trans.eContainer());
		}
		if (!result.isOk())
			error(result);
	}
	
	@Check
	public void checkState(org.eclipse.etrice.core.room.State state) {
		Result result = ValidationUtil.checkState(state);
		if (!result.isOk())
			error(result);
	}
	
	@Check
	public void checkPortCommunicationCompatibility(ActorClass ac){
		if(ac.getCommType() == ActorCommunicationType.SYNCHRONOUS){
			// not supported yet
			return;
		}
		
		// check external ports
		List<InterfaceItem> extPorts = new ArrayList<InterfaceItem>();
		for(ExternalPort exPort : ac.getExternalPorts())
			extPorts.add(exPort.getInterfacePort());
		checkPortCommunicationCompatibility(ac, extPorts, RoomPackage.eINSTANCE.getActorClass_ExternalPorts());
		// check internal ports
		checkPortCommunicationCompatibility(ac, ac.getInternalPorts(), RoomPackage.eINSTANCE.getActorClass_InternalPorts());
		// check SAPs
		checkPortCommunicationCompatibility(ac, ac.getServiceAccessPoints(), RoomPackage.eINSTANCE.getActorClass_ServiceAccessPoints());
		// check service implementations
		List<InterfaceItem> serviceImpls = new ArrayList<InterfaceItem>();
		for(ServiceImplementation si: ac.getServiceImplementations())
			serviceImpls.add(si.getSpp());
		checkPortCommunicationCompatibility(ac, serviceImpls, RoomPackage.eINSTANCE.getActorClass_ServiceImplementations());
	}
	
	private void checkPortCommunicationCompatibility(ActorClass ac, List<? extends InterfaceItem> items, EReference ref){
		boolean datadriven = ac.getCommType() == ActorCommunicationType.DATA_DRIVEN;
		boolean eventdriven = ac.getCommType() == ActorCommunicationType.EVENT_DRIVEN;
		boolean async = ac.getCommType() == ActorCommunicationType.ASYNCHRONOUS;
		//boolean synchronous = ac.getCommType() == ActorCommunicationType.SYNCHRONOUS;
		
		for(InterfaceItem item : items){
			ProtocolClass pc = RoomHelpers.getProtocol(item);
			if (pc!=null)
				switch(pc.getCommType()){
					case DATA_DRIVEN:
						if(!datadriven && !async)
							error("ports with datadriven protocols not allowed", ref, items.indexOf(item));
						break;
					case EVENT_DRIVEN:
						if(!eventdriven && !async)
							error("ports with eventdriven protocols not allowed", ref, items.indexOf(item));
						break;
					case SYNCHRONOUS:
						// not supported yet
				}
		}
	}
	
	@Check
	public void checkPort(Port port) {
		if (port.getMultiplicity()==0)
			error("multiplicity must not be 0", RoomPackage.eINSTANCE.getPort_Multiplicity());
		if (port.getMultiplicity()<-1)
			error("multiplicity must be -1 or positive", RoomPackage.eINSTANCE.getPort_Multiplicity());
		if (port.getProtocol() instanceof ProtocolClass)
			if (((ProtocolClass)port.getProtocol()).getCommType()==CommunicationType.DATA_DRIVEN && port.getMultiplicity()!=1)
			error("multiplicity must be 1 for data driven ports", RoomPackage.eINSTANCE.getPort_Multiplicity());
	}
	
	@Check
	public void checkProtocol(ProtocolClass pc) {
		if (ValidationUtil.isCircularClassHierarchy(pc))
			return;
		
		switch (pc.getCommType()) {
		case DATA_DRIVEN:
			if (pc.getBase()!=null && pc.getBase().getCommType()!=CommunicationType.DATA_DRIVEN)
				error("super protocol has to have same communication type", RoomPackage.Literals.PROTOCOL_CLASS__COMM_TYPE);
			if (RoomHelpers.getAllMessages(pc, true).isEmpty())
				error("at least one incoming message must be defined", RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES);
			if (!RoomHelpers.getAllMessages(pc, false).isEmpty())
				error("data driven protocols must have no outgoing messages", RoomPackage.Literals.PROTOCOL_CLASS__OUTGOING_MESSAGES);
			break;
		case EVENT_DRIVEN:
			if (pc.getBase()!=null && pc.getBase().getCommType()!=CommunicationType.EVENT_DRIVEN)
				error("super protocol has to have same communication type", RoomPackage.Literals.PROTOCOL_CLASS__COMM_TYPE);
			if (RoomHelpers.getAllMessages(pc, true).isEmpty() && RoomHelpers.getAllMessages(pc, false).isEmpty())
				error("at least one message (incoming or outgoing) must be defined", RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES);
			break;
		case SYNCHRONOUS:
			error("synchronous communication type not supported yet", RoomPackage.Literals.PROTOCOL_CLASS__COMM_TYPE);
			break;
		default:
		}
		
		if (pc.getBase()!=null) {
			// derived protocol
			if (pc.getIncomingMessages().size()>0 && pc.getOutgoingMessages().size()>0)
				warning("a derived protocol should add either incoming or outgoing messages, not both", RoomPackage.Literals.PROTOCOL_CLASS__OUTGOING_MESSAGES);
			
			{
				List<Message> incoming = RoomHelpers.getAllMessages(pc, true);
				HashSet<String> inNames = new HashSet<String>();
				for (Message in : incoming) {
					if (!inNames.add(in.getName())) {
						int idx = pc.getIncomingMessages().indexOf(in);
						if (idx>=0)
							error("duplicate message name", pc, RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES, idx);
					}
				}
			}

			{
				List<Message> outgoing = RoomHelpers.getAllMessages(pc, true);
				HashSet<String> outNames = new HashSet<String>();
				for (Message out : outgoing) {
					if (!outNames.add(out.getName())) {
						int idx = pc.getOutgoingMessages().indexOf(out);
						if (idx>=0)
							error("duplicate message name", pc, RoomPackage.Literals.PROTOCOL_CLASS__OUTGOING_MESSAGES, idx);
					}
				}
			}
		}
	}
	
	@Check
	public void checkMessage(Message msg) {
		ProtocolClass pc = (ProtocolClass) msg.eContainer();
		if (pc.getCommType()==CommunicationType.DATA_DRIVEN)
			if (msg.getData()==null)
				error("Messages of data driven protocols must carry data", RoomPackage.Literals.MESSAGE__DATA);
	}
	
	@Check
	public void checkMessageFromIf(MessageFromIf mfi){
		if(mfi.getFrom() != null){
			if(RoomHelpers.getProtocol(mfi.getFrom()).getCommType() != CommunicationType.EVENT_DRIVEN)
				error("port must have event driven protocol", mfi, RoomPackage.eINSTANCE.getMessageFromIf_From());
		}
	}

	@Check
	public void checkOperation(StandardOperation op) {
		if (RoomHelpers.isConstructor(op)) {
			if (!op.getArguments().isEmpty())
				error("Constructor must have no arguments", RoomPackage.Literals.OPERATION__ARGUMENTS);
			if (op.getReturnType()!=null)
				error("Constructor must have no return type", RoomPackage.Literals.OPERATION__RETURN_TYPE);
		}
		else if (RoomHelpers.isDestructor(op)) {
			if (!op.getArguments().isEmpty())
				error("Destructor must have no arguments", RoomPackage.Literals.OPERATION__ARGUMENTS);
			if (op.getReturnType()!=null)
				error("Destructor must have no return type", RoomPackage.Literals.OPERATION__RETURN_TYPE);
		}
		else if (op.isDestructor()) {
			RoomClass cls = (RoomClass) op.eContainer();
			error("Destructor must have class name", RoomPackage.Literals.OPERATION__NAME, CHANGE_DESTRUCTOR_NAME, cls.getName());
		}
		else if (op.getArguments().isEmpty()) {
			RoomClass cls = (RoomClass) op.eContainer();
			
			// check for method with same name with destructor flag set
			EList<StandardOperation> ops = null;
			if (cls instanceof ActorClass)
				ops = ((ActorClass) cls).getOperations();
			else if (cls instanceof DataClass)
				ops = ((DataClass) cls).getOperations();
			else {
				assert(false): "unexpected parent class";
			}
			
			for (StandardOperation o : ops) {
				if (o.isDestructor() && o.getName().equals(op.getName())) {
					warning("Constructor meant?", RoomPackage.Literals.OPERATION__NAME, CHANGE_CONSTRUCTOR_NAME, cls.getName());
				}
			}
			
		}
	}
	
	@Check
	public void checkRefinedTransition(RefinedTransition rt) {
		if (!(rt.eContainer().eContainer() instanceof ActorClass)) {
			StateGraph sg = (StateGraph) rt.eContainer();
			int idx = sg.getRefinedTransitions().indexOf(rt);
			error("RefinedTransition only allowed in top level state graph of an actor", sg, RoomPackage.Literals.STATE_GRAPH__REFINED_TRANSITIONS, idx);
		}
	}
	
	@Check
	public void checkDataClass(DataClass dc) {
		if (dc.getAttributes().isEmpty() && dc.getBase()==null)
			error("Non-derived data classes have to define at least one attribute", RoomPackage.Literals.DATA_CLASS__ATTRIBUTES);
	}
	
	@Check
	public void checkAttribute(Attribute att) {
		ArrayList<Attribute> all = new ArrayList<Attribute>();
		
		if (att.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) att.eContainer();
			if (ValidationUtil.isCircularClassHierarchy(ac))
				// is checked elsewhere
				return;
			
			do {
				all.addAll(ac.getAttributes());
				ac = ac.getBase();
			}
			while (ac!=null);
		}
		else if (att.eContainer() instanceof DataClass) {
			DataClass dc = (DataClass) att.eContainer();
			if (ValidationUtil.isCircularClassHierarchy(dc))
				// is checked elsewhere
				return;
			
			do {
				all.addAll(dc.getAttributes());
				dc = dc.getBase();
			}
			while (dc!=null);
		}
		// skip PortClass case since they don't inherit (yet)
		
		String name = att.getName();
		for (Attribute a : all) {
			if (a!=att && a.getName().equals(name))
				if (a.eContainer()!=att.eContainer())
					error("name already used in base class '"+((RoomClass)a.eContainer()).getName()+"'",
							RoomPackage.Literals.ATTRIBUTE__NAME);
				else
					error("name already used", RoomPackage.Literals.ATTRIBUTE__NAME);
		}
	}
	
	@Check
	public void checkReplicatedPortBindingPatterns(StructureClass sc) {
		HashSet<Port> haveReplPeer = new HashSet<Port>();
		for (Binding bind : sc.getBindings()) {
			Port p1 = bind.getEndpoint1().getPort();
			Port p2 = bind.getEndpoint2().getPort();
			if (p1.getMultiplicity()!=1 && p2.getMultiplicity()!=1) {
				if (!haveReplPeer.add(p1))
					error(A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER,
							bind,
							RoomPackage.Literals.BINDING__ENDPOINT1);
				if (!haveReplPeer.add(p2))
					error(A_REPLICATED_PORT_MUST_HAVE_AT_MOST_ONE_REPLICATED_PEER,
							bind,
							RoomPackage.Literals.BINDING__ENDPOINT2);
			}
		}
	}
	
	@Check
	public void checkDetailCode(DetailCode dc) {
		if (dc.getLines().isEmpty())
			error("detail code must not be empty", dc, RoomPackage.Literals.DETAIL_CODE__LINES);
	}
	
	@Check
	public void checkDocumentation(Documentation doc) {
		if (doc.getLines().isEmpty())
			error("documentation must not be empty", doc, RoomPackage.Literals.DOCUMENTATION__LINES);
	}
	
	@Check
	public void checkPortClassContents(PortClass pc) {
		if (pc.getAttributes().isEmpty() && pc.getMsgHandlers().isEmpty() && pc.getOperations().isEmpty())
			error("port class must not be empty", pc, RoomPackage.Literals.PORT_CLASS__ATTRIBUTES);
	}
	
	@Check
	public void checkCompoundProtocolClass(CompoundProtocolClass cpc) {
		if (cpc.getSubProtocols().isEmpty())
			error("no sub protocols defined", cpc, RoomPackage.Literals.COMPOUND_PROTOCOL_CLASS__SUB_PROTOCOLS);
	}
	
	@Check
	public void checkAnnotationTypeTargetsUnique(AnnotationType at) {
		for(AnnotationTargetType targetType : AnnotationTargetType.values()) {
			int count = 0;
			for(int i = 0; i < at.getTargets().size(); i++) {
				AnnotationTargetType target = at.getTargets().get(i);
				if(target.equals(targetType)) {
					count++;
					if(count > 1) {
						error("duplicate target "+target.getLiteral(), at, RoomPackage.Literals.ANNOTATION_TYPE__TARGETS, i);
					}
				}
			}
		}
	}
	
	@Check
	public void checkAnnotationTarget(Annotation a) {
		if(a.getType() == null || a.getType().eIsProxy())
			return;
		
		EObject parent = a.eContainer();
		EList<AnnotationTargetType> targetList = a.getType().getTargets();
		AnnotationTargetType invalidTargetType = null;
		if(parent instanceof ActorClass) {
			ActorClass actorParent = (ActorClass)parent;
			if(actorParent.getAnnotations().contains(a) && !targetList.contains(AnnotationTargetType.ACTOR_CLASS)) {
				invalidTargetType = AnnotationTargetType.ACTOR_CLASS;
			}
			else if(actorParent.getBehaviorAnnotations().contains(a) && !targetList.contains(AnnotationTargetType.ACTOR_BEHAVIOR)) {
				invalidTargetType = AnnotationTargetType.ACTOR_BEHAVIOR;
			}
		}
		else if(parent instanceof DataClass && !targetList.contains(AnnotationTargetType.DATA_CLASS)) {
			invalidTargetType = AnnotationTargetType.DATA_CLASS;
		}
		else if(parent instanceof ProtocolClass && !targetList.contains(AnnotationTargetType.PROTOCOL_CLASS)) {
			invalidTargetType = AnnotationTargetType.PROTOCOL_CLASS;
		}
		else if(parent instanceof CompoundProtocolClass && !targetList.contains(AnnotationTargetType.COMPOUND_PROTOCOL_CLASS)) {
			invalidTargetType = AnnotationTargetType.COMPOUND_PROTOCOL_CLASS;
		}
		else if(parent instanceof LogicalSystem && !targetList.contains(AnnotationTargetType.LOGICAL_SYSTEM_CLASS)) {
			invalidTargetType = AnnotationTargetType.LOGICAL_SYSTEM_CLASS;
		}
		else if(parent instanceof SubSystemClass && !targetList.contains(AnnotationTargetType.SUBSYSTEM_CLASS)) {
			invalidTargetType = AnnotationTargetType.SUBSYSTEM_CLASS;
		}
		if(invalidTargetType != null) {
			error("AnnotationType " + a.getType().getName() + " is not allowed for target " + invalidTargetType.getLiteral(), a, RoomPackage.Literals.ANNOTATION__TYPE);
		}
	}
	
	@Check
	public void checkAnnotationAttributeKeys(Annotation a) {
		EList<AnnotationAttribute> validAttrList = a.getType().getAttributes();
		EList<KeyValue> attrList = a.getAttributes();
		Set<String> validAttrNames = new HashSet<String>();
		for(AnnotationAttribute attr : validAttrList) {
			validAttrNames.add(attr.getName());
		}
		for(int i = 0; i < attrList.size(); i++) {
			if(!validAttrNames.contains(attrList.get(i).getKey())) {
				error("Annotation contains undefined attribute", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
			}
		}
	}
	
	@Check
	public void checkAnnotationAttributeMandatory(Annotation a) {
		Set<String> mandatoryAttrNames = new HashSet<String>();
		Set<String> annoAttrNames = new HashSet<String>();
		for(AnnotationAttribute attr : a.getType().getAttributes()) {
			if(!attr.isOptional()) mandatoryAttrNames.add(attr.getName());
		}
		for(KeyValue kv : a.getAttributes()) {
			annoAttrNames.add(kv.getKey());
		}
		mandatoryAttrNames.removeAll(annoAttrNames);
		if(!mandatoryAttrNames.isEmpty()) {
			error("Annotation is missing mandatory attributes " + mandatoryAttrNames.toString(), a, null);
		}
	}
	
	@Check
	public void checkAnnotationAttributeType(Annotation a) {
		Map<String, AnnotationAttribute> attrDefs = new HashMap<String, AnnotationAttribute>();
		for(AnnotationAttribute annoAttr : a.getType().getAttributes()) {
			attrDefs.put(annoAttr.getName(), annoAttr);
		}
		for(int i = 0; i < a.getAttributes().size(); i++) {
			KeyValue kv = a.getAttributes().get(i);
			if(attrDefs.containsKey(kv.getKey())) {
				Literal val = kv.getValue();
				AnnotationAttribute attr = attrDefs.get(kv.getKey());
				if(RoomPackage.Literals.SIMPLE_ANNOTATION_ATTRIBUTE.isInstance(attr)) {
					SimpleAnnotationAttribute simpleAttrDef = (SimpleAnnotationAttribute)attr;
					switch(simpleAttrDef.getType()) {
					case BOOL:
						if(!(val instanceof BooleanLiteral)) {
							error("Expected boolean attribute value", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					case INT:
						if(!(val instanceof IntLiteral)) {
							error("Expected integer number attribute value", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					case REAL:
						if(!(val instanceof RealLiteral)) {
							error("Expected real number attribute value", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					case CHAR:
						if(!(val instanceof StringLiteral)) {
							error("Expected character string attribute value", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
						break;
					}
				}
				else if(RoomPackage.Literals.ENUM_ANNOTATION_ATTRIBUTE.isInstance(attr)) {
					if(!(val instanceof StringLiteral)) {
						error("Expected enum attribute value", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
					}
					else {
						EnumAnnotationAttribute enumAttrDef = (EnumAnnotationAttribute)attr;
						String strVal = ((StringLiteral)val).getValue(); 
						if(!enumAttrDef.getValues().contains(strVal)) {
							error("Invalid enum attribute value", a, RoomPackage.Literals.ANNOTATION__ATTRIBUTES, i);
						}
					}
				}
			}
		}
	}
	
	private void error(Result result) {
		error(result.getMsg(), result.getSource(), result.getFeature(), result.getIndex());
	}
}
