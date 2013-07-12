/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Before;
import org.junit.Test;

/**
 * Example test to illustrate validation unit tests.
 * 
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public class TestCases extends TestBase {

	/**
	 * 
	 */
	private static final String MSG1 = "connected sub component ports must be conjugated to each other";
	private Resource resource;

	@Before
	public void setUp() {
		prepare();
		
		resource = getResource("test.room");
	}
	
	@Test
	public void testSomething() {
		Diagnostic diag = getDiag(resource.getContents().get(0));
		HashMap<String, Diagnostic> msg2diag = getMappedDiagnostics(diag);
		assertEquals("number of problems", 1, msg2diag.size());
		assertNotNull(MSG1, msg2diag.get(MSG1));
	}

	/**
	 * @param diag
	 * @return
	 */
	private HashMap<String, Diagnostic> getMappedDiagnostics(Diagnostic diag) {
		HashMap<String, Diagnostic> msg2diag = new HashMap<String, Diagnostic>();
		recursivlyCollectErrors(diag, msg2diag);
		return msg2diag;
	}

	/**
	 * @param diag
	 * @param msg2diag
	 */
	private void recursivlyCollectErrors(Diagnostic diag, HashMap<String, Diagnostic> msg2diag) {
		for (Diagnostic d : diag.getChildren()) {
			if ((d.getSeverity() & Diagnostic.ERROR) != 0) {
				msg2diag.put(d.getMessage(), d);
			}
		}
		for (Diagnostic d : diag.getChildren()) {
			if (!d.getChildren().isEmpty())
				recursivlyCollectErrors(d, msg2diag);
		}
	}
}
