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

package org.eclipse.etrice.abstractexec.behavior.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class Test417433 extends TestBase {

	@Before
	public void setUp() {
		prepare("bug417433.room");
	}
	
	@Test
	public void testSomething() {
		assertEquals("number of infos", 3, getInfoMsgToDiagnostic().size());
		assertEquals("number of warnings", 0, getWarningMsgToDiagnostic().size());
		assertEquals("number of errors", 0, getErrorMsgToDiagnostic().size());
	}

}
