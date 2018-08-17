/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.genmodel.fsm.tests

import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.generator.base.logging.NullLogger

class TestHierInheritedFSM extends FsmGenTestBase {
	
	GraphContainer gc
	GraphContainer gc2
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("HierInheritedFSMExample.room", "TestActor")
		gc2 = getGraphContainer("HierInheritedFSMExample.room", "TestActor2")
		assertNotNull("graph context was created", gc)
		assertNotNull("graph context was created", gc2)
		
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
		
		save(gc, "HierInheritedFSMExample")
		save(gc2, "HierInheritedFSMExample2")
	}
	
	@Test
	def void testHierInheritedFSMItemCounts() {
		assertEquals("number of nodes", 4, gc.graph.nodes.size)
		assertEquals("number of links", 6, gc.graph.links.size)
		assertEquals("number of states", 4, gc.graph.stateNodes.size)
		assertEquals("number of tr points", 0, gc.graph.trPointNodes.size)
		assertEquals("number of choice points", 0, gc.graph.choicePointNodes.size)
	}
	
	@Test
	def void testHierInheritedFSMDeepItemCounts() {
		assertEquals("number of nodes", 12, gc.graph.allNodes.size)
		assertEquals("number of links", 14, gc.graph.allLinks.size)
		assertEquals("number of states", 10, gc.graph.allStateNodes.size)
		assertEquals("number of tr points", 2, gc.graph.allTrPointNodes.size)
		assertEquals("number of choice points", 0, gc.graph.allChoicePointNodes.size)
	}
	
	@Test
	def void testHierInheritedFSMLinks() {
		val s = gc.graph.allStateNodes.filter[name.equals("state1_0")].head
		assertNotNull("state found", s)
		
		assertEquals("incoming links", 2, s.incoming.size)
		assertEquals("outgoing links", 1, s.outgoing.size)
	}
	
	@Test
	def void testOriginRefs() {
		gc2.graph.nodes.filter[stateGraphNode.name == 'state0'] => [
			assertEquals(1, size)
			assertEquals('RefinedState:TestActor2$state0', EcoreUtil.getURI(head.stateGraphNode).fragment)
		]
		gc2.graph.links.filter[transition.name == 'tr3'] => [
			assertEquals(1, size)
			assertEquals('RefinedTransition:TestActor2$tr3', EcoreUtil.getURI(head.transition).fragment)
		]
	}
}