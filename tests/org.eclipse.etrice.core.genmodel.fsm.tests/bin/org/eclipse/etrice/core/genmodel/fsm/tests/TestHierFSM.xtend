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

import org.eclipse.etrice.core.fsm.fSM.SimpleState
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.NullLogger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*

class TestHierFSM extends FsmGenTestBase {
	
	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("HierFSMExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
	}
	
	@Test
	def void testHierFSMItemCounts() {
		assertEquals("number of nodes", 3, gc.graph.nodes.size)
		assertEquals("number of links", 4, gc.graph.links.size)
		assertEquals("number of states", 3, gc.graph.stateNodes.size)
		assertEquals("number of tr points", 0, gc.graph.trPointNodes.size)
		assertEquals("number of choice points", 0, gc.graph.choicePointNodes.size)
	}
	
	@Test
	def void testHierFSMSubGraphItemCounts() {
		val subGraph = gc.graph.stateNodes.filter[name.equals("state1")].head.subgraph
		
		assertEquals("number of nodes", 4, subGraph.nodes.size)
		assertEquals("number of links", 4, subGraph.links.size)
		assertEquals("number of states", 2, subGraph.stateNodes.size)
		assertEquals("number of tr points", 2, subGraph.trPointNodes.size)
		assertEquals("number of choice points", 0, subGraph.choicePointNodes.size)
	}
	
	@Test
	def void testHierFSMState1_1Connections() {
		val subGraph = gc.graph.stateNodes.filter[name.equals("state1")].head.subgraph
		val s1_1 = subGraph.stateNodes.filter[name.equals("state1_1")].head
		assertNotNull("state found", s1_1)
		
		assertEquals("incoming links", 2, s1_1.incoming.size)
		assertEquals("outgoing links", 1, s1_1.outgoing.size)
	}
	
	@Test
	def void testHierFSMPointersIntoOriginalFSM() {
		val n = gc.graph.stateNodes.filter[name.equals("state1")].head
		val s = actor.stateMachine.states.filter[name.equals("state1")].head
		
		assertNotNull("node found", n)
		assertNotNull("state found", s)
		assertTrue("State expected", n.stateGraphNode instanceof SimpleState)
		assertEquals("correct target", s, n.stateGraphNode)
	}
}