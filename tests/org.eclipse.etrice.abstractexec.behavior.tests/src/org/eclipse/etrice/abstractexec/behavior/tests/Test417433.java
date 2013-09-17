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
