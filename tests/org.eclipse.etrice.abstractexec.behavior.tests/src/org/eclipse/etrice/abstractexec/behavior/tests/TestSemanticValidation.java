/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.abstractexec.behavior.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class TestSemanticValidation extends TestBase {

	@SuppressWarnings("unused")
	private static final String MSG1 = "replace this with the expected error/Warning message";

	@Before
	public void setUp() {
		prepare("semantics.room");
	}
	
	@Test
	public void testSomething() {
		assertEquals("number of infos", 2, getInfoMsgToDiagnostic().size());
		assertEquals("number of warnings", 5, getWarningMsgToDiagnostic().size());
//		assertEquals("number of errors", 1, getErrorMsgToDiagnostic().size());
//		assertNotNull(MSG1, getErrorMsgToDiagnostic().get(MSG1));
		// further checks for all other messages...
	}
}
