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
		instances = collectInstances(root);
	}

	@Test
	public void testInstances() {
		checkSize(1, ETriceGenPackage.eINSTANCE.getSubSystemInstance());
		checkSize(18, ETriceGenPackage.eINSTANCE.getActorInstance());
		
		ActorInstance ai = root.getSubSystemInstances().get(0).getActorInstances().get(0);
		assertEquals("Instance Path", "/CMain/l1a", ai.getPath());
		
		ai = ai.getActorInstances().get(1);
		assertEquals("Instance Path", "/CMain/l1a/l2b", ai.getPath());
		
		ai = ai.getActorInstances().get(2);
		assertEquals("Instance Path", "/CMain/l1a/l2b/l3c", ai.getPath());
	}
}
