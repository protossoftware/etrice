/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class TestSemanticValidation extends TestBase {

	private static final String MSG1 = "replace this with the expected error/Warning message";

	@Before
	public void setUp() {
		prepare("semantics.room");
	}
	
	@Test
	public void testSomething() {
		assertEquals("number of infos", 0, getInfoMsgToDiagnostic().size());
		assertEquals("number of warnings", 0, getWarningMsgToDiagnostic().size());
		assertEquals("number of errors", 1, getErrorMsgToDiagnostic().size());
		assertNotNull(MSG1, getErrorMsgToDiagnostic().get(MSG1));
		// further checks for all other messages...
	}
}
