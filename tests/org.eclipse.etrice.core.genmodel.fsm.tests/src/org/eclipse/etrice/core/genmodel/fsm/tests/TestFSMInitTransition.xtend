/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm.tests

import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull

/**
 * Bug 551966 - [fsm] Allow subgraph without init transition
 */
class TestFSMInitTransition extends FsmGenTestBase {
	
	GraphContainer gc
	
	@Before
	def void setUp() {
		gc = getGraphContainer("HierFSMInitTransition.room", "TestActor")
		assertNotNull("graph context was created", gc)
	}
	
	@Test
	def void noErrors() {
		// there is a check in the ExtendedFsmGenBuilder which is called during setUp
		assertFalse("logger has no errors", diagnostician.isFailed)
	}
	
}