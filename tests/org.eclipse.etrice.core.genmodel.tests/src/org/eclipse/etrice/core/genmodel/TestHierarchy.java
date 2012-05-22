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
import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.genmodel.etricegen.ActorInstance;
import org.eclipse.etrice.core.genmodel.etricegen.ETriceGenPackage;
import org.eclipse.etrice.core.genmodel.etricegen.Root;
import org.junit.Before;
import org.junit.Test;


public class TestHierarchy extends TestInstanceModelBuilderBase {
	
	private Root root;

	@Before
	public void setUp() {
		prepare();
		
		root = buildInstanceModel("hierarchy.room");
	}

	@Test
	public void testInstances() {
		
		HashMap<EClass,ArrayList<EObject>> instances = collectInstances(root);
		
		assertEquals("Number of ComponentInstances", 1, instances.get(ETriceGenPackage.eINSTANCE.getSubSystemInstance()).size());
		assertEquals("Number of ActorInstances", 18, instances.get(ETriceGenPackage.eINSTANCE.getActorInstance()).size());
		
		ActorInstance ai = root.getSubSystemInstances().get(0).getInstances().get(0);
		assertEquals("Instance Path", "/CMain/l1a", ai.getPath());
		
		ai = ai.getInstances().get(1);
		assertEquals("Instance Path", "/CMain/l1a/l2b", ai.getPath());
		
		ai = ai.getInstances().get(2);
		assertEquals("Instance Path", "/CMain/l1a/l2b/l3c", ai.getPath());
	}
}
