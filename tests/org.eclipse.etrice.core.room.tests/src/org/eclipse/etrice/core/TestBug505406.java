/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class TestBug505406 extends TestBase {
	private Resource res = null;

	@Before
	public void SetUp() {
		prepare();
		res = getResource("bug505406.room");
	}

	@Test
	public void testEntryPointAlreadyConnected() {
		EObject obj = res.getEObject("ContinuationTransition:Bug505406Derived$state0$tr2");
		Diagnostic diag = getDiag(obj);
		assertTrue(diag.getChildren().size() == 1);
		assertTrue(diag.getChildren().get(0).getMessage().contains("source transition point already is connected"));
	}

}
