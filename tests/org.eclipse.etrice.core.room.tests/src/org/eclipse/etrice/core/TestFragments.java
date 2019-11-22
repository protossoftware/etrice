/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.RoomModel;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Streams;

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
		getActorClasses(model).flatMap(ac -> Streams.stream(ac.eAllContents())).forEach(obj -> {
			String fragment = resource.getURIFragment(obj);
			
			if (!fragment.startsWith("//@")) {
				System.out.println(fragment);
			}
			
			EObject found = resource.getEObject(fragment);
			
			assertEquals(obj, found);
		});
		System.out.println("============ end fragment test ============");
	}

}
