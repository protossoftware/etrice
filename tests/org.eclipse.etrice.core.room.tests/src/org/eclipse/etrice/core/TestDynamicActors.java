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

package org.eclipse.etrice.core;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.ReferenceType;
import org.eclipse.etrice.core.validation.WiringValidator;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class TestDynamicActors extends TestBase {
	private Resource resource;

	@Before
	public void setUp() {
		prepare(CoreTestsActivator.getInstance().getBundle());
		
		resource = getResource("TestDynamicActors.room");
	}

	@Test
	public void testDynamicActors() {
		ActorClass ac = (ActorClass) resource.getEObject("ActorClass:Test");
		assertNotNull("actor class test found", ac);
		ActorRef ar;
		
		// scalar refs
		ar = (ActorRef) resource.getEObject("ActorRef:Test$dflt");
		assertTrue("ActorRef dflt is of ref type fixed", ar.getRefType()==ReferenceType.FIXED);
		ar = (ActorRef) resource.getEObject("ActorRef:Test$fix");
		assertTrue("ActorRef fix is of ref type fixed", ar.getRefType()==ReferenceType.FIXED);
		ar = (ActorRef) resource.getEObject("ActorRef:Test$opt");
		assertTrue("ActorRef opt is of ref type fixed", ar.getRefType()==ReferenceType.OPTIONAL);
	}

	@Test
	public void testDynamicActorValidation() {
		ActorRef ar;
		List<Diagnostic> errors;
		
		// arrays
		ar = (ActorRef) resource.getEObject("ActorRef:Test$dfltArrayFixed");
		errors = getDiag(ar).getChildren();
		assertTrue("ActorRef dfltArrayFixed has no errors", errors.isEmpty());
		ar = (ActorRef) resource.getEObject("ActorRef:Test$fixArrayFixed");
		errors = getDiag(ar).getChildren();
		assertTrue("ActorRef fixArrayFixed has no errors", errors.isEmpty());
		ar = (ActorRef) resource.getEObject("ActorRef:Test$optArrayAny");
		errors = getDiag(ar).getChildren();
		assertTrue("ActorRef optArrayAny has no errors", errors.isEmpty());
		ar = (ActorRef) resource.getEObject("ActorRef:Test$dfltArrayAny");
		errors = getDiag(ar).getChildren();
		assertEquals("ActorRef dfltArrayAny has one error", 1, errors.size());
		assertEquals("ActorRef dfltArrayAny has error: "+WiringValidator.MULTIPLICITY_ANY_REQUIRES_OPTIONAL,
				WiringValidator.MULTIPLICITY_ANY_REQUIRES_OPTIONAL,
				errors.get(0).getMessage());
		ar = (ActorRef) resource.getEObject("ActorRef:Test$fixArrayAny");
		errors = getDiag(ar).getChildren();
		assertEquals("ActorRef fixArrayAny has one error", 1, errors.size());
		assertEquals("ActorRef fixArrayAny has error: "+WiringValidator.MULTIPLICITY_ANY_REQUIRES_OPTIONAL,
				WiringValidator.MULTIPLICITY_ANY_REQUIRES_OPTIONAL,
				errors.get(0).getMessage());
		ar = (ActorRef) resource.getEObject("ActorRef:Test$optArrayFixed");
		errors = getDiag(ar).getChildren();
		assertTrue("ActorRef optArrayFixed has no errors", errors.isEmpty());
	}
}
