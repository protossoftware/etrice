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

package org.eclipse.etrice.core.genmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInterfaceInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.InterfaceItemInstance;
import org.eclipse.etrice.core.genmodel.etricegen.OptionalActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.eclipse.etrice.core.genmodel.etricegen.SAPInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ServiceImplInstance;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestOptionalActors extends TestInstanceModelBuilderBase {
	
	private Root root;
	
	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("dynamic_actors.room");
		instances = collectInstances(root);
	}
	
	@Test
	public void testInstanceNumbers() {
		checkSize(4, ETriceGenPackage.eINSTANCE.getSAPInstance());
		checkSize(3, ETriceGenPackage.eINSTANCE.getSPPInstance());
		checkSize(6, ETriceGenPackage.eINSTANCE.getServiceImplInstance());
		checkSize(12, ETriceGenPackage.eINSTANCE.getActorInstance());
		checkSize(3, ETriceGenPackage.eINSTANCE.getActorInterfaceInstance());
		checkSize(6, ETriceGenPackage.eINSTANCE.getOptionalActorInstance());
	}
	
	@Test
	public void testLayerConnections() {
		ArrayList<EObject> saps = instances.get(ETriceGenPackage.eINSTANCE.getSAPInstance());
		
		SAPInstance sap = (SAPInstance) getInstance(saps, "/OptionalForSvcOK/ref0/sap1");
		assertNotNull("sap expected", sap);
		assertEquals("SAP has one peer", 1, sap.getPeers().size());
		InterfaceItemInstance peer = sap.getPeers().get(0);
		assertTrue("peer is a service", (peer instanceof ServiceImplInstance));
		ServiceImplInstance svc = (ServiceImplInstance) peer;
		assertEquals("number of service peers", 1, svc.getPeers().size());
		assertEquals("sap and service have same protocol", sap.getSap().getProtocol(), svc.getSvcImpl().getSpp().getProtocol());
		
		sap = (SAPInstance) getInstance(saps, "/OptionalForSvcOK/ref0/sap2");
		assertNotNull("sap expected", sap);
		assertEquals("SAP has one peer", 1, sap.getPeers().size());
	}
	
	@Test
	public void testRequiredProvided() {
		ArrayList<EObject> aifs = instances.get(ETriceGenPackage.eINSTANCE.getActorInterfaceInstance());
		ActorInterfaceInstance aif = (ActorInterfaceInstance) getInstance(aifs, "/LS/main/appl/cont3/ref0");
		assertNotNull("actor interface expected", aif);
		assertEquals("number of provided services", 1, aif.getProvidedServices().size());
		
		ArrayList<EObject> oais = instances.get(ETriceGenPackage.eINSTANCE.getOptionalActorInstance());
		OptionalActorInstance oai = (OptionalActorInstance) getInstance(oais, "/OptionalForSvcOK");
		assertNotNull("optional actor expected", oai);
		assertEquals("number of required services", 1, oai.getRequiredServices().size());
		
		oai = (OptionalActorInstance) getInstance(oais, "/OptionalForSvcNOK");
		assertNotNull("optional actor expected", oai);
		assertEquals("number of required services", 2, oai.getRequiredServices().size());
	}

	// un-comment for debugging purposes
//	private void assertEquals(String msg, int expect, int actual) {
//		System.out.println(msg+" "+actual);
//	}
//	private void assertEquals(String msg, Object expect, Object actual) {
//	}
}
