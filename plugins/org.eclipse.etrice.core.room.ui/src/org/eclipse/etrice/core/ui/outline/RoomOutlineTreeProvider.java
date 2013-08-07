/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ExternalPort;
import org.eclipse.etrice.core.room.Import;
import org.eclipse.etrice.core.room.LogicalThread;
import org.eclipse.etrice.core.room.Message;
import org.eclipse.etrice.core.room.Operation;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.PortOperation;
import org.eclipse.etrice.core.room.ProtocolClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.SAP;
import org.eclipse.etrice.core.room.SPP;
import org.eclipse.etrice.core.room.ServiceImplementation;
import org.eclipse.etrice.core.room.State;
import org.eclipse.etrice.core.room.StateGraph;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.ui.internal.RoomActivator;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import com.google.inject.Inject;

/**
 * customization of the default outline structure
 * 
 * @author Henrik Rentz-Reichert
 */
public class RoomOutlineTreeProvider extends DefaultOutlineTreeProvider {

	private static final String STATE_MACHINE_LABEL = "StateMachine";
	private static final String BEHAVIOR_LABEL = "Behavior";
	private static final String STRUCTURE_LABEL = "Structure";
	private static final String INTERFACE_LABEL = "Interface";
	private static final Object INCOMING_LABEL = "incoming";
	private static final Object OUTGOING_LABEL = "outgoing";
	private static final Object REG_PORT_CLASS_LABEL = "regular port class";
	private static final Object CONJ_PORT_CLASS_LABEL = "conjugated port class";
	
	@Inject ImportUriResolver importUriResolver;
	
	protected boolean _isLeaf(ActorClass ac) {
		if (ac.getInterfacePorts().size()>0 || ac.getServiceProvisionPoints().size()>0) {
			return false;
		}
		if (ac.getInternalPorts().size()>0 || ac.getServiceImplementations().size()>0 ||
				ac.getServiceAccessPoints().size()>0 || ac.getAttributes().size()>0 ||
				ac.getActorRefs().size()>0) {
			return false;
		}
		if (ac.getOperations().size()>0 || ac.getStateMachine()!=null) {
			return false;
		}
		return true;
	}
	
	protected void _createChildren(IOutlineNode parentNode, ActorClass ac) {
		Object nodeName = parentNode.getText();
		if (parentNode.getText() instanceof StyledString)
			nodeName = ((StyledString)parentNode.getText()).getString();
		
		// if the parent is the top node of an actor class it starts with the actor class name
		// (eventually followed by 'extends')
		// otherwise it is one of the Interface/Structure/Behavior nodes
		if (((String)nodeName).startsWith(ac.getName()))
			createChildren1(parentNode, ac);
		else
			createChildren2(parentNode, ac);
	}
	
	private void createChildren1(IOutlineNode parentNode, ActorClass ac) {
		if (ac.getInterfacePorts().size()>0 || ac.getServiceProvisionPoints().size()>0) {
			createExtraNode(ac, parentNode, INTERFACE_LABEL);
		}
		if (ac.getInternalPorts().size()>0 || ac.getExternalPorts().size()>0 || ac.getServiceImplementations().size()>0 ||
				ac.getServiceAccessPoints().size()>0 || ac.getAttributes().size()>0 ||
				ac.getActorRefs().size()>0) {
			createExtraNode(ac, parentNode, STRUCTURE_LABEL);
		}
		if (ac.getOperations().size()>0 || ac.getStateMachine()!=null) {
			createExtraNode(ac, parentNode, BEHAVIOR_LABEL);
		}
	}
	
	private void createChildren2(IOutlineNode parentNode, ActorClass ac) {
		if (parentNode.getText().equals(INTERFACE_LABEL)) {
			for (Port port : ac.getInterfacePorts())
				createNode(parentNode, port);
			for (SPP spp : ac.getServiceProvisionPoints())
				createNode(parentNode, spp);
		}
		else if (parentNode.getText().equals(STRUCTURE_LABEL)) {
			for (Port port : ac.getInternalPorts())
				createNode(parentNode, port);
			for (ExternalPort port : ac.getExternalPorts())
				createNode(parentNode, port.getInterfacePort());
			for (ServiceImplementation svc : ac.getServiceImplementations())
				createNode(parentNode, svc);
			for (SAP sap : ac.getServiceAccessPoints())
				createNode(parentNode, sap);
			for (Attribute attr : ac.getAttributes())
				createNode(parentNode, attr);
			for (ActorRef ar : ac.getActorRefs())
				createNode(parentNode, ar);
		}
		else if (parentNode.getText().equals(BEHAVIOR_LABEL)) {
			for (Operation op : ac.getOperations())
				createNode(parentNode, op);
			if (ac.getStateMachine()!=null) {
				createNode(parentNode, ac.getStateMachine());
			}
		}
	}
	
	protected void _createChildren(IOutlineNode parentNode, StateGraph st) {
		for (State s : st.getStates()) 
			createNode(parentNode, s);
	}
	
	protected Object _text(StateGraph modelElement) {
		return STATE_MACHINE_LABEL;
	}
	
	protected Image _image(StateGraph modelElement) {
		return RoomActivator.getInstance().getImageRegistry().get("defaultoutlinenode.gif");
	}
	
	protected boolean _isLeaf(SubSystemClass ssc) {
		if (!ssc.getActorRefs().isEmpty()) {
			return false;
		}
		return true;
	}
	
	protected void _createChildren(IOutlineNode parentNode, SubSystemClass ssc) {
		for (ActorRef aref : ssc.getActorRefs()) {
			createNode(parentNode, aref);
		}
		for (LogicalThread thread : ssc.getThreads()) {
			createNode(parentNode, thread);
		}
		for (ActorInstanceMapping aim : ssc.getActorInstanceMappings()) {
			createNode(parentNode, aim);
		}
	}

	protected void _createChildren(IOutlineNode parentNode, State s) {
		if (s.getSubgraph()!=null) {
			for (State state : s.getSubgraph().getStates()) {
				createNode(parentNode, state);
			}
		}
	}
	
	protected boolean _isLeaf(State s) {
		if (s.getSubgraph()!=null)
			if (!s.getSubgraph().getStates().isEmpty())
				return false;
		return true;
	}
	
	protected void _createChildren(IOutlineNode parentNode, ProtocolClass pc) {
		Object nodeName = parentNode.getText();
		if(parentNode.getText() instanceof StyledString)
			nodeName = ((StyledString)parentNode.getText()).getString();
		if(nodeName.equals(pc.getName()))
			createChildren1(parentNode, pc);
		else
			createChildren2(parentNode, pc);
	}
	
	private void createChildren1(IOutlineNode parentNode, ProtocolClass pc) {
		if (pc.getIncomingMessages().size()>0) {
			createExtraNode(pc, parentNode, INCOMING_LABEL);
		}
		if (pc.getOutgoingMessages().size()>0) {
			createExtraNode(pc, parentNode, OUTGOING_LABEL);
		}
		if (pc.getRegular()!=null)
			createExtraNode(pc, parentNode, REG_PORT_CLASS_LABEL);
		if (pc.getConjugated()!=null)
			createExtraNode(pc, parentNode, CONJ_PORT_CLASS_LABEL);
	}	
	
	private void createChildren2(IOutlineNode parentNode, ProtocolClass pc) {
		if (parentNode.getText().equals(INCOMING_LABEL)) {
			for (Message m : pc.getIncomingMessages()) {
				createNode(parentNode, m);
			}
		}
		else if (parentNode.getText().equals(OUTGOING_LABEL)) {
			for (Message m : pc.getOutgoingMessages()) {
				createNode(parentNode, m);
			}
		}
		else if (parentNode.getText().equals(REG_PORT_CLASS_LABEL)) {
			for (Attribute att : pc.getRegular().getAttributes()) {
				createNode(parentNode, att);
			}
			for (PortOperation op : pc.getRegular().getOperations()) {
				createNode(parentNode, op);
			}
		}
		else if (parentNode.getText().equals(CONJ_PORT_CLASS_LABEL)) {
			for (Attribute att : pc.getConjugated().getAttributes()) {
				createNode(parentNode, att);
			}
			for (PortOperation op : pc.getConjugated().getOperations()) {
				createNode(parentNode, op);
			}
		}
	}
	
	protected boolean _isLeaf(Message m) {
		return true;
	}
	
	protected boolean _isLeaf(Operation o) {
		return true;
	}
	
	protected boolean _isLeaf(Attribute ac) {
		return true;
	}
	
	protected void _createChildren(IOutlineNode parentNode, Import im) {
		String uriString = importUriResolver.resolve(im);
		
		if (uriString==null)
			return;
		
		URI uri = URI.createURI(uriString);
		ResourceSet rs = new ResourceSetImpl();
		RoomModel refModel = null;
		
		try {
			Resource res = rs.getResource(uri, true);
			if(res != null && !res.getContents().isEmpty() && res.getContents().get(0) instanceof RoomModel)
				refModel = (RoomModel)res.getContents().get(0);
		}catch (RuntimeException re) {
		}
		
		if(refModel != null){
			for(EObject firstLevelElement : refModel.getActorClasses())
				_createNode(parentNode, firstLevelElement);
			for(EObject firstLevelElement : refModel.getDataClasses())
				_createNode(parentNode, firstLevelElement);
			for(EObject firstLevelElement : refModel.getExternalTypes())
				_createNode(parentNode, firstLevelElement);
			for(EObject firstLevelElement : refModel.getPrimitiveTypes())
				_createNode(parentNode, firstLevelElement);
			for(EObject firstLevelElement : refModel.getProtocolClasses())
				_createNode(parentNode, firstLevelElement);
			for(EObject firstLevelElement : refModel.getSubSystemClasses())
				_createNode(parentNode, firstLevelElement);
			for(EObject firstLevelElement : refModel.getSystems())
				_createNode(parentNode, firstLevelElement);
		}
	}
	
	protected  boolean _isLeaf(Import im){
		return false;
	}
	
	private void createExtraNode(EObject obj, IOutlineNode parent, Object text){		
		createEObjectNode(parent, obj, RoomActivator.getInstance().getImageRegistry().get("defaultoutlinenode.gif"), text, false);
	}
}
