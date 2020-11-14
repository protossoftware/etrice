/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.ui.outline;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.common.base.Import;
import org.eclipse.etrice.core.fsm.fSM.State;
import org.eclipse.etrice.core.fsm.fSM.StateGraph;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorInstanceMapping;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.Attribute;
import org.eclipse.etrice.core.room.ClassStructor;
import org.eclipse.etrice.core.room.ExternalPort;
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
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.ui.internal.RoomActivator;
import org.eclipse.jface.viewers.ILabelProvider;
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

	// extra node labels should be != valid room name/id
	private static final String STATE_MACHINE_LABEL = "StateMachine";
	private static final String BEHAVIOR_LABEL = "Behavior";
	private static final String STRUCTURE_LABEL = "Structure";
	private static final String INTERFACE_LABEL = "Interface";
	private static final Object INCOMING_LABEL = "incoming";
	private static final Object OUTGOING_LABEL = "outgoing";
	private static final Object REG_PORT_CLASS_LABEL = "regular port class";
	private static final Object CONJ_PORT_CLASS_LABEL = "conjugated port class";
	
	@Inject ImportUriResolver importUriResolver;
	@Inject ILabelProvider labelProvider;
	
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
		
		// Labels have to be distinct from actor class name due recursion
		// Identify extra node by label name or
		// if the parent is the top node of an actor class it starts with the actor class name
		// (eventually followed by 'extends')
		if(nodeName.equals(INTERFACE_LABEL) || nodeName.equals(STRUCTURE_LABEL) || nodeName.equals(BEHAVIOR_LABEL))
			createChildren2(parentNode, ac);
		else if (((String)nodeName).startsWith(ac.getName()))
			createChildren1(parentNode, ac);
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
			for (ClassStructor structor : ac.getStructors())
				createNode(parentNode, structor);
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
		if(nodeName.equals(labelProvider.getText(pc)))
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
	
	protected boolean _isLeaf(ClassStructor structor) {
		return true;
	}
	
	protected boolean _isLeaf(Attribute ac) {
		return true;
	}
	
	protected void _createChildren(IOutlineNode parentNode, Import im) {
		String resolvedURI = importUriResolver.resolve(im);
		if(resolvedURI == null) return;
		
		Resource res = im.eResource().getResourceSet().getResource(URI.createURI(resolvedURI), false);
		if(res == null) return;
		
		for(EObject content : res.getContents()) {
			if(content instanceof RoomModel) {
				for(EObject topLevel : content.eContents()){
					if(!(topLevel instanceof Import)){
						_createNode(parentNode, topLevel);
					}
				}
			}
		}
	}
	
	protected  boolean _isLeaf(Import im){
		return false;
	}
	
	private void createExtraNode(EObject obj, IOutlineNode parent, Object text){		
		createEObjectNode(parent, obj, RoomActivator.getInstance().getImageRegistry().get("defaultoutlinenode.gif"), text, false);
	}
	
	protected boolean _isLeaf(ActorInstanceMapping aim){
		return true;
	}
}
