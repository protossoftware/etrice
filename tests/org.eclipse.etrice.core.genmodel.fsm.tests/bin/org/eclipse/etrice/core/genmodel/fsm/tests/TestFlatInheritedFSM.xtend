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

import org.eclipse.etrice.core.fsm.fSM.RefinedState
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertFalse

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.core.genmodel.fsm.NullLogger
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker

class TestFlatInheritedFSM extends FsmGenTestBase {
	
	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("FlatInheritedFSMExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
	}
	
	@Test
	def void testFlatInheritedFSMItemCounts() {
		assertEquals("number of nodes", 6, gc.graph.nodes.size)
		assertEquals("number of links", 6, gc.graph.links.size)
		assertEquals("number of states", 6, gc.graph.stateNodes.size)
		assertEquals("number of tr points", 0, gc.graph.trPointNodes.size)
		assertEquals("number of choice points", 0, gc.graph.choicePointNodes.size)
	}
	
	@Test
	def void testFlatInheritedFSMState0Connections() {
		val s = gc.graph.stateNodes.filter[name.equals("state0")].head
		assertNotNull("state found", s)
		
		assertEquals("incoming links", 1, s.incoming.size)
		assertEquals("outgoing links", 1, s.outgoing.size)
	}
	
	@Test
	def void testHierFSMPointersIntoOriginalFSM() {
		val n = gc.graph.stateNodes.filter[name.equals("state1")].head
		val s = actor.stateMachine.states.filter[name.equals("state1")].head
		
		assertNotNull("node found", n)
		assertNotNull("state found", s)
		assertTrue("RefinedState expected", n.stateGraphNode instanceof RefinedState)
		assertEquals("correct target", s, n.stateGraphNode)
	}
}