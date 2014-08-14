/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.postprocessing

import org.eclipse.xtext.GeneratedMetamodel

import org.eclipse.emf.ecore.EcorePackage

import static extension org.eclipse.etrice.core.common.postprocessing.PostprocessingHelpers.*

class ImplPostprocessor {
	
	def process(GeneratedMetamodel metamodel) {
		val roomPackage = metamodel.EPackage
		
		val port = roomPackage.getClass("Port")
		port.getAttribute("multiplicity").setDefaultValueLiteral("1")
		port.addOperation("isReplicated", EcorePackage::eINSTANCE.getEClassifier("EBoolean"), 1, 
			'''return multiplicity>1 || multiplicity==-1;''')
		
		val actorRef = roomPackage.getClass("ActorRef")
		actorRef.getAttribute("multiplicity").setDefaultValueLiteral("1")
			
		val interfaceItem = roomPackage.getClass("InterfaceItem")
		interfaceItem.addOperation("getGeneralProtocol", roomPackage.getEClassifier("GeneralProtocolClass"), 1, 
			'''
			if (this instanceof <%org.eclipse.etrice.core.room.Port%>)
				return ((Port) this).getProtocol();
			else if (this instanceof <%org.eclipse.etrice.core.room.SAP%>)
				return ((SAP) this).getProtocol();
			else if (this instanceof <%org.eclipse.etrice.core.room.SPP%>)
				return ((SPP) this).getProtocol();
			return null;
			''')
			
		val actorClass = roomPackage.getClass("ActorClass")
		actorClass.addOperation("getExternalEndPorts", roomPackage.getEClassifier("Port"), -1,
			'''
				EList<Port> ports = new org.eclipse.emf.common.util.BasicEList<Port>();
				for (ExternalPort ep : getExternalPorts()) {
					ports.add(ep.getInterfacePort());
				}
				return ports;
			'''
		)
		actorClass.addOperation("getRelayPorts", roomPackage.getEClassifier("Port"), -1,
			'''
				EList<Port> ports = new org.eclipse.emf.common.util.BasicEList<Port>(getInterfacePorts());
				for (ExternalPort ep : getExternalPorts()) {
					ports.remove(ep.getInterfacePort());
				}
				return ports;
			'''
		)
		actorClass.addOperation("getImplementedSPPs", roomPackage.getEClassifier("SPP"), -1,
			'''
				EList<SPP> spps = new org.eclipse.emf.common.util.BasicEList<SPP>();
				for (ServiceImplementation spp : getServiceImplementations()) {
					spps.add(spp.getSpp());
				}
				return spps;
			'''
		)
		actorClass.addOperation("getActorBase", roomPackage.getEClassifier("ActorClass"), 1,
			'''
				return (ActorClass)getBase();
			'''
		)
		actorClass.addOperation("getComponentName", EcorePackage::eINSTANCE.getEClassifier("EString"), 1,
			'''
				return getName();
			'''
		)
		
		val actorContainerRef = roomPackage.getClass("ActorContainerRef")
		actorContainerRef.addOperation("getStructureClass",
			roomPackage.getEClassifier("StructureClass"),
			1,
			'''
				if (this instanceof <%org.eclipse.etrice.core.room.ActorRef%>)
					return ((ActorRef)this).getType();
				else if (this instanceof <%org.eclipse.etrice.core.room.SubSystemRef%>)
					return ((SubSystemRef)this).getType();
				else
					return null;
			'''
		)
				
		val refPath = roomPackage.getClass("RefPath")
		refPath.addOperation(
			"toString",
			EcorePackage::eINSTANCE.getEClassifier("EString"),
			1,
			'''
				StringBuilder sb = new StringBuilder();
				for (RefSegment ref : getRefs()) {
					sb.append("/"+ref.toString());
				}
				return sb.toString();
			'''
		)
				
		val refSeg = roomPackage.getClass("RefSegment")
		refSeg.getAttribute("idx").setDefaultValueLiteral("-1")
		refSeg.addOperation(
			"toString",
			EcorePackage::eINSTANCE.getEClassifier("EString"),
			1,
			'''
				return getRef() + ((getIdx()>=0)? ":"+getIdx() : "");
			'''
		)
		
		val enumLiteral = roomPackage.getClass("EnumLiteral")
		enumLiteral.addOperation(
			"getLiteralValue",
			EcorePackage::eINSTANCE.getEClassifier("ELong"),
			1,
			'''
				if (this.getLiteral() != null)
					return this.getLiteral().getValue();
				
				// recursively from predecessor
				<%org.eclipse.etrice.core.room.EnumerationType%> et = ((EnumerationType) this.eContainer());
				int idx = et.getLiterals().indexOf(this);
				if (idx > 0)
					return et.getLiterals().get(idx - 1).getLiteralValue() + 1;
				
				return 0;
			'''
			)
			
			enumLiteral.addOperation(
			"getFullName",
			EcorePackage::eINSTANCE.getEClassifier("EString"),
			1,
			'''
				<%org.eclipse.etrice.core.room.EnumerationType%> et = ((EnumerationType) this.eContainer());
				return et.getName() + "." + this.getName();
			'''
		)
	}
}

