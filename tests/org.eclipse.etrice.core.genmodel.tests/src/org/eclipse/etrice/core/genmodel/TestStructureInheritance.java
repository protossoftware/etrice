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

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.junit.Test;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.ExpandedActorClass;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.Port;
import org.eclipse.etrice.core.room.SAP;

public class TestStructureInheritance extends TestInstanceModelBuilderBase {
	
	private Root root;
	private ExpandedActorClass xpac;
	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("structure_inheritance.room");
		xpac = getTestee();
		instances = collectInstances(root);
	}

	private ExpandedActorClass getTestee() {
		for (ExpandedActorClass xpac : root.getXpActorClasses()) {
			if (xpac.getActorClass().getName().equals("AFunctionA"))
				return xpac;
		}
		return null;
	}

//	private void assertEquals(String msg, int exp, int is) {
//		LogicalSystem.out.println(msg+" exp:"+exp+" is:"+is);
//	}
//
//	private void assertEquals(String msg, EObject exp, EObject is) {
//		LogicalSystem.out.println(msg+" exp:"+exp+" is:"+is);
//	}

	@Test
	public void testInstanceNumbers() {
		checkSize(8, ETriceGenPackage.eINSTANCE.getActorInstance());
		checkSize(30, ETriceGenPackage.eINSTANCE.getPortInstance());
		checkSize(8, ETriceGenPackage.eINSTANCE.getSAPInstance());
		checkSize(2, ETriceGenPackage.eINSTANCE.getSPPInstance());
		checkSize(2, ETriceGenPackage.eINSTANCE.getServiceImplInstance());
	}
	
	@Test
	public void testLayerConnections() {
		ArrayList<EObject> saps = instances.get(ETriceGenPackage.eINSTANCE.getSAPInstance());
		
		for (EObject obj : saps) {
			assertEquals("SAP has one peer", 1, ((SAPInstance)obj).getPeers().size());
		}
		
		SAPInstance sap = (SAPInstance) getInstance(saps, "/CMain/application/fcta/sub2/timeout");
		assertNotNull("sap expected", sap);
		InterfaceItemInstance peer = ((SAPInstance)sap).getPeers().get(0);
		assertTrue("peer is a service", (peer instanceof ServiceImplInstance));
		ServiceImplInstance svc = (ServiceImplInstance) peer;
		assertEquals("number of serviceA peers", 8, svc.getPeers().size());
		assertEquals("sap and service have same protocol", sap.getSap().getProtocol(), svc.getSvcImpl().getSpp().getProtocol());
	}
	
	private Port getPort(ActorClass ac, String name) {
		for (Port p : ac.getInterfacePorts()) {
			if (p.getName().equals(name))
				return p;
		}
		for (Port p : ac.getInternalPorts()) {
			if (p.getName().equals(name))
				return p;
		}
		
		if (ac.getBase()!=null)
			return getPort(ac.getBase(), name);
		
		fail("port "+name+" not found");
		return null;
	}
	
	private SAP getSAP(ActorClass ac, String name) {
		for (SAP sap : ac.getServiceAccessPoints()) {
			if (sap.getName().equals(name))
				return sap;
		}
		
		if (ac.getBase()!=null)
			return getSAP(ac.getBase(), name);
		
		fail("sap "+name+" not found");
		return null;
	}
	
	@Test
	public void testIfItems() {
		Port base = getPort(xpac.getActorClass(), "base");
		Port subbase = getPort(xpac.getActorClass(), "subbase");
		Port ctrl = getPort(xpac.getActorClass(), "ctrl");
		Port subctrl = getPort(xpac.getActorClass(), "subctrl");
		Port fct1 = getPort(xpac.getActorClass(), "fct1");
		Port fct2 = getPort(xpac.getActorClass(), "fct2");
		SAP ctrltimeout = getSAP(xpac.getActorClass(), "ctrltimeout");
		SAP timeout = getSAP(xpac.getActorClass(), "timeout");
		
		int lid = 0;
		assertEquals("port local id", lid++, xpac.getInterfaceItemLocalId(base));
		assertEquals("port local id", lid++, xpac.getInterfaceItemLocalId(subbase));
		assertEquals("port local id", lid++, xpac.getInterfaceItemLocalId(ctrl));
		assertEquals("port local id", lid++, xpac.getInterfaceItemLocalId(subctrl));
		assertEquals("sap local id", lid++, xpac.getInterfaceItemLocalId(ctrltimeout));
		assertEquals("sap local id", lid++, xpac.getInterfaceItemLocalId(timeout));
		assertEquals("relay port local id", -1, xpac.getInterfaceItemLocalId(fct1));
		assertEquals("relay port local id", -1, xpac.getInterfaceItemLocalId(fct2));
	}
	
	@Test
	public void testPortConnection() {
		ArrayList<EObject> ports = instances.get(ETriceGenPackage.eINSTANCE.getPortInstance());

		PortInstance p = (PortInstance) getInstance(ports, "/CMain/application/fcta/sub2/fct");
		assertNotNull("port expected", p);
		assertEquals("external port expected", PortKind.EXTERNAL.getValue(), p.getKind().getValue());
		assertFalse("no conjuagted port expected", p.getPort().isConjugated());
		assertEquals("port connected once", 1, p.getPeers().size());
		PortInstance peer = (PortInstance) getInstance(p.getPeers(), "/CMain/application/client/pa1");
		assertNotNull("peer expected", peer);
		peer = (PortInstance) getInstance(peer.getPeers(), "/CMain/application/fcta/sub2/fct");
		assertNotNull("peer expected", peer);
		assertEquals("peer of peer is start", p, peer);
	}
}
