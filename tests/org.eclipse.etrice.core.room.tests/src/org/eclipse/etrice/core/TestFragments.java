/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

import static org.junit.Assert.*;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestFragments extends TestBase {
	private Resource resource;

	@Before
	public void setUp() {
		prepare(CoreTestsActivator.getInstance().getBundle());
		
		resource = getResource("ChoicePointTest.room");
	}
	
	@Test
	public void testFragments() {
		System.out.println("============ begin fragment test ============");
		RoomModel model = (RoomModel) resource.getContents().get(0);
		for (ActorClass ac : model.getActorClasses()) {
			TreeIterator<EObject> iter = ac.eAllContents();
			while (iter.hasNext()) {
				EObject obj = iter.next();
				String fragment = resource.getURIFragment(obj);
				
				if (!fragment.startsWith("//@")) {
					System.out.println(fragment);
				}
				
				EObject found = resource.getEObject(fragment);
				
				assertEquals(obj, found);
			}
		}
		System.out.println("============ end fragment test ============");
	}

}
