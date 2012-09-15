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

package org.eclipse.etrice.integration.tests;


import static org.junit.Assert.assertEquals;

import org.eclipse.etrice.integration.tests.base.IntegrationTestBase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class IntegrationTestFSMGenerator extends IntegrationTestBase {
	private SubSystemHFSMTest main_component = null;

	@Before
	public void setUp() throws Exception {
		main_component  = new SubSystemHFSMTest("MainComponent");
		
		// hand over the semaphore to the subsystem
		main_component.setTestSemaphore(this.testSem);
	}
	
	@Test (timeout=5000)
	public void testHFSM(){

		main_component.init(); // lifecycle init
		main_component.start(); // lifecycle start
		
		waitForTestcase();
		
		assertEquals(0,main_component.getTestErrorCode());

	}

	@After
	public void tearDown() throws Exception {
		// end the lifecycle
		main_component.stop(); // lifecycle stop
		main_component.destroy(); // lifecycle destroy
	}

	
}
