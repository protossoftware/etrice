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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.PortKind;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.junit.Before;
import org.junit.Test;


public class TestConnectedPorts extends TestInstanceModelBuilderBase {
	
	private Root root;
	private HashMap<EClass, ArrayList<EObject>> instances;
	
	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("connected_ports.room");
		instances = collectInstances(root);
	}
	
	@Test
	public void testPortNumbers() {
		ArrayList<EObject> ports = instances.get(ETriceGenPackage.eINSTANCE.getPortInstance());
		assertEquals("Number of PortInstances", 19, ports.size());
	}
	
	@Test
	public void testRelayPort() {
		ArrayList<EObject> ports = instances.get(ETriceGenPackage.eINSTANCE.getPortInstance());
		
		PortInstance p = (PortInstance) getInstance(ports, "/CMain/test_a1/relay");
		assertNotNull("port expected", p);
		assertEquals("relay port expected", PortKind.RELAY, p.getKind());
		assertFalse("no conjuagted port expected", p.getPort().isConjugated());
	}
	
	@Test
	public void testInternalEndPort() {
		ArrayList<EObject> ports = instances.get(ETriceGenPackage.eINSTANCE.getPortInstance());

		PortInstance p = (PortInstance) getInstance(ports, "/CMain/test_a2/int_end");
		assertNotNull("port expected", p);
		assertEquals("internal port expected", PortKind.INTERNAL, p.getKind());
		assertTrue("conjuagted port expected", p.getPort().isConjugated());
		assertEquals("port connected once", 1, p.getPeers().size());
		PortInstance peer = (PortInstance) getInstance(p.getPeers(), "/CMain/test_a2/subact/p2");
		assertNotNull("peer expected", peer);
		PortInstance start = (PortInstance) getInstance(peer.getPeers(), "/CMain/test_a2/int_end");
		assertNotNull("peer expected", start);
		assertEquals("peer of peer is start", p, start);
	}
	
	@Test
	public void testExternalEndPortConnectedToRelayPort() {
		ArrayList<EObject> ports = instances.get(ETriceGenPackage.eINSTANCE.getPortInstance());
		
		PortInstance p = (PortInstance) getInstance(ports, "/CMain/test_a2/subact/p1");
		assertNotNull("port expected", p);
		assertEquals("external port expected", PortKind.EXTERNAL, p.getKind());
		assertEquals("port connected once", 1, p.getPeers().size());
		PortInstance peer = (PortInstance) getInstance(p.getPeers(), "/CMain/test_b/sub1/p");
		assertEquals("port connected twice", 2, peer.getPeers().size());
	}

}
