/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm.tests

import org.eclipse.etrice.core.fsm.fSM.ChoicePoint
import org.eclipse.etrice.core.fsm.fSM.State
import org.eclipse.etrice.core.fsm.fSM.TrPoint
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.NullLogger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*

class TestFlatFSM extends FsmGenTestBase {

	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("FlatFSMExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
	}
	
	@Test
	def void testFlatFSMItemCounts() {
		assertEquals("number of nodes", 6, gc.graph.nodes.size)
		assertEquals("number of links", 6, gc.graph.links.size)
		assertEquals("number of states", 4, gc.graph.nodes.filter[stateGraphNode instanceof State].size)
		assertEquals("number of tr points", 1, gc.graph.nodes.filter[stateGraphNode instanceof TrPoint].size)
		assertEquals("number of choice points", 1, gc.graph.nodes.filter[stateGraphNode instanceof ChoicePoint].size)
	}
	
	@Test
	def void testFlatFSMState1Connections() {
		val s1 = gc.graph.stateNodes.filter[name.equals("state1")].head
		assertNotNull("state found", s1)
		
		assertEquals("incoming links", 1, s1.incoming.size)
		assertEquals("outgoing links", 1, s1.outgoing.size)
	}
	
	@Test
	def void testFlatFSMState3Connections() {
		val s3 = gc.graph.stateNodes.filter[name.equals("state3")].head
		assertNotNull("state found", s3)
		
		assertEquals("incoming links", 1, s3.incoming.size)
		assertEquals("outgoing links", 0, s3.outgoing.size)
	}
	
	@Test
	def void testFlatFSMCPConnections() {
		val cp = gc.graph.choicePointNodes.filter[name.equals("cp0")].head
		assertNotNull("choice point found", cp)
		
		assertEquals("incoming links", 1, cp.incoming.size)
		assertEquals("outgoing links", 2, cp.outgoing.size)
	}
}