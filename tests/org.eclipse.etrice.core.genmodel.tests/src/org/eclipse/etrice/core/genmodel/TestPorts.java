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

import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.PortInstance;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.junit.Before;
import org.junit.Test;


public class TestPorts extends TestInstanceModelBuilderBase {
	
	private Root root;

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("ports.room");
	}
	
	@Test
	public void testPortNumbers() {
		HashMap<EClass, ArrayList<EObject>> instances = collectInstances(root);
		assertEquals("Number of PortInstances", 3, instances.get(ETriceGenPackage.eINSTANCE.getPortInstance()).size());
	}
	
	@Test
	public void testPortInstancePaths() {
		PortInstance pi = root.getSubSystemInstances().get(0).getInstances().get(0).getPorts().get(0);
		assertEquals("Port Name", "/CMain/test/externalEnd", pi.getPath());
		
		pi = root.getSubSystemInstances().get(0).getInstances().get(0).getPorts().get(1);
		assertEquals("Port Name", "/CMain/test/internalEnd", pi.getPath());
		
		pi = root.getSubSystemInstances().get(0).getInstances().get(0).getPorts().get(2);
		assertEquals("Port Name", "/CMain/test/relay", pi.getPath());
	}

}
