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

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.junit.Before;
import org.junit.Test;


public class TestLayers extends TestInstanceModelBuilderBase {
	
	private Root root;
	
	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("layers.room");
		instances = collectInstances(root);
	}
	
	@Test
	public void testInstanceNumbers() {
		checkSize(6, ETriceGenPackage.eINSTANCE.getSAPInstance());
		checkSize(7, ETriceGenPackage.eINSTANCE.getSPPInstance());
		checkSize(3, ETriceGenPackage.eINSTANCE.getServiceImplInstance());
	}
	
	@Test
	public void testLayerConnections() {
		ArrayList<EObject> saps = instances.get(ETriceGenPackage.eINSTANCE.getSAPInstance());
		
		for (EObject obj : saps) {
			assertEquals("SAP has one peer", 1, ((SAPInstance)obj).getPeers().size());
		}
		
		SAPInstance sap = (SAPInstance) getInstance(saps, "/CMain/app/subsysA/userX/sap");
		assertNotNull("sap expected", sap);
		InterfaceItemInstance peer = ((SAPInstance)sap).getPeers().get(0);
		assertTrue("peer is a service", (peer instanceof ServiceImplInstance));
		ServiceImplInstance svc = (ServiceImplInstance) peer;
		assertEquals("number of serviceA peers", 3, svc.getPeers().size());
		assertEquals("sap and service have same protocol", sap.getSap().getProtocol(), svc.getSvcImpl().getSpp().getProtocol());
	}

}
