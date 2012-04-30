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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorCommunicationType;
import org.eclipse.etrice.core.room.ActorContainerClass;
import org.eclipse.etrice.core.room.ActorInstancePath;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.Binding;
import org.eclipse.etrice.core.room.CommunicationType;
import org.eclipse.etrice.core.room.DataClass;
import org.eclipse.etrice.core.room.ExternalType;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.InitialTransition;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.core.room.LayerConnection;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.NonInitialTransition;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortClass;
import org.eclipse.etrice.core.room.PrimitiveType;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.RoomPackage;
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
				error("the imported namespace should be '"+model.getName()+".*'", RoomPackage.Literals.IMPORT__IMPORTED_NAMESPACE);
			}
		}
		catch (RuntimeException re) {
			warning("could not load referenced model", RoomPackage.Literals.IMPORT__IMPORT_URI);
			return;
		}
	}
	
	@Check
	public void checkTypeNameStartsWithCapital(RoomClass type) {
		if (type instanceof PrimitiveType || type instanceof ExternalType)
			return;
		
		if (!Character.isUpperCase(type.getName().charAt(0))) {
			warning("Name should start with a capital", RoomPackage.eINSTANCE.getRoomClass_Name());
		}
	}

	@Check
	public void checkActorRefIsNotCircular(ActorRef ar) {
		if (ar.eContainer() instanceof ActorClass) {
			ActorClass ac = (ActorClass) ar.eContainer();
			
			if (ValidationUtil.isReferencing(ar.getType(), ac)) {
				error("Actor reference is circular", RoomPackage.eINSTANCE.getActorRef_Type());
			}
		}
	}
	
	@Check
	public void checkRefHasFixedMultiplicityPorts(ActorRef ar) {
		if (ar.getSize()>1) {
			ActorClass ac = ar.getType();
			if (ar!=null) {
				for (Port p : ac.getIfPorts()) {
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
			if (((ActorRef)lc.getTo().getRef()).getSize()>1) {
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
			if (att.getRefType().getType()==dc)
				error("Attribute type must not refer to own class or a super class", RoomPackage.Literals.ATTRIBUTE__REF_TYPE);
			
			dc = dc.getBase();
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
		
		while (ac.getBase()!=null) {
			ac = ac.getBase();

			if (commType!=ac.getCommType())
				error("data_driven attribute not consistent in inheritance hierarchy", RoomPackage.eINSTANCE.getActorClass_CommType());
		}
	}
	
	private SubSystemClass getSubSystemClass(EObject obj) {
		EObject ctx = obj.eContainer();
		while (!(ctx instanceof SubSystemClass) && ctx.eContainer()!=null)
			ctx = ctx.eContainer();
		if (ctx instanceof SubSystemClass)
			return (SubSystemClass) ctx;
		
		return null;
	}

	@Check  
	public void checkSubSystem(SubSystemClass ssc){
		if (ssc.getActorRefs().isEmpty())
			warning("SubSystemClass must contain at least one ActorRef", RoomPackage.eINSTANCE.getActorContainerClass_ActorRefs());
	}

	@Check
	public void checkLogicalSystem(LogicalSystem ls){
		if (ls.getSubSystems().isEmpty())
			error("LogicalSystem must contain at least one SubSystemRef", RoomPackage.eINSTANCE.getLogicalSystem_SubSystems());
	}

	
	@Check
	public void checkInstancePath(ActorInstancePath ai) {
		ActorContainerClass acc = getSubSystemClass(ai);
		for (String seg : ai.getSegments()) {
			boolean found = false;
			for (ActorRef ar : acc.getActorRefs()) {
				if (ar.getName().equals(seg)) {
					acc = ar.getType();
					found = true;
					break;
				}
			}
			if (!found)
				error("wrong actor instance path (segment number "+ai.getSegments().indexOf(seg)+")", RoomPackage.eINSTANCE.getActorInstancePath_Segments());
		}
	}
	
	@Check
	public void checkPortCompatibility(Binding bind) {
		Result result = ValidationUtil.isValid(bind);
		if (!result.isOk())
			error(result.getMsg(), RoomPackage.eINSTANCE.getBinding_Endpoint1());
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
	public void checkPort(Port port) {
		if (port.getMultiplicity()==0)
			error("multiplicity must not be 0", RoomPackage.eINSTANCE.getPort_Multiplicity());
		if (port.getMultiplicity()<-1)
			error("multiplicity must be -1 or positive", RoomPackage.eINSTANCE.getPort_Multiplicity());
		if (port.getProtocol().getCommType()==CommunicationType.DATA_DRIVEN && port.getMultiplicity()!=1)
			error("multiplicity must be 1 for data driven ports", RoomPackage.eINSTANCE.getPort_Multiplicity());
	}
	
	@Check
	public void checkProtocol(ProtocolClass pc) {
		switch (pc.getCommType()) {
		case DATA_DRIVEN:
			if (pc.getIncomingMessages().isEmpty())
				error("at least one incoming message must be defined", RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES);
			if (!pc.getOutgoingMessages().isEmpty())
				error("data driven protocols must have no outgoing messages", RoomPackage.Literals.PROTOCOL_CLASS__OUTGOING_MESSAGES);
			break;
		case EVENT_DRIVEN:
			if (pc.getIncomingMessages().isEmpty() && pc.getOutgoingMessages().isEmpty())
				error("at least one message (incoming or outgoing) must be defined", RoomPackage.Literals.PROTOCOL_CLASS__INCOMING_MESSAGES);
			break;
		case SYNCHRONOUS:
			break;
		default:
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
	public void checkOperation(StandardOperation op) {
		if (RoomHelpers.isConstructor(op)) {
			if (!op.getArguments().isEmpty())
				error("Constructor must have no arguments", RoomPackage.Literals.OPERATION__ARGUMENTS);
			if (op.getReturntype()!=null)
				error("Constructor must have no return type", RoomPackage.Literals.OPERATION__RETURNTYPE);
		}
		else if (RoomHelpers.isDestructor(op)) {
			if (!op.getArguments().isEmpty())
				error("Destructor must have no arguments", RoomPackage.Literals.OPERATION__ARGUMENTS);
			if (op.getReturntype()!=null)
				error("Destructor must have no return type", RoomPackage.Literals.OPERATION__RETURNTYPE);
		}
	}
	
	private void error(Result result) {
		error(result.getMsg(), result.getSource(), result.getFeature(), result.getIndex());
	}
}
