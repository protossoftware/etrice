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

import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.TriggerExtensions
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.generator.base.logging.NullLogger

class TestTrigger extends FsmGenTestBase {
	
	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("TriggerExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
		
		gc.withTriggersInStates
		assertFalse("diagnostician has no errors", diagnostician.isFailed)
		val s = gc.graph.allStateNodes.filter[name.equals("state0_0")].head
		assertEquals("leave state triggers", 3, s.caughtTriggers.size)
	}
	
	@Test
	def void testNoTrigger() {
		val s = gc.graph.allStateNodes.filter[name.equals("state0")].head
		assertNotNull("state found", s)
		
		assertEquals("non-leave state has no caught triggers", 0, s.caughtTriggers.size)
	}
	
	@Test
	def void testTrigger_state0_0() {
		val s = gc.graph.allStateNodes.filter[name.equals("state0_0")].head
		assertNotNull("state found", s)
		
		assertEquals("leave state triggers", 3, s.caughtTriggers.size)
		
		assertEquals("1st trigger", "in3".trigger , s.caughtTriggers.get(0).trigger)
		assertEquals("1st trigger, transitions", 1, s.caughtTriggers.get(0).links.size)
		assertEquals("2nd trigger", "in1".trigger , s.caughtTriggers.get(1).trigger)
		assertEquals("2nd trigger, transitions", 1, s.caughtTriggers.get(1).links.size)
		assertEquals("3rd trigger", "in2".trigger , s.caughtTriggers.get(2).trigger)
		assertEquals("3rd trigger, transitions", 1, s.caughtTriggers.get(2).links.size)
	}
	
	@Test
	def void testTrigger_state0_1() {
		val s = gc.graph.allStateNodes.filter[name.equals("state0_1")].head
		assertNotNull("state found", s)
		
		assertEquals("leave state triggers", 2, s.caughtTriggers.size)
		
		assertEquals("1st trigger", "in2".trigger , s.caughtTriggers.get(0).trigger)
		assertEquals("1st trigger, transitions", 1, s.caughtTriggers.get(0).links.size)
		assertEquals("2nd trigger", "in1".trigger , s.caughtTriggers.get(1).trigger)
		assertEquals("2nd trigger, transitions", 1, s.caughtTriggers.get(1).links.size)
	}
	
	@Test
	def void testTrigger_state1_0() {
		val s = gc.graph.allStateNodes.filter[name.equals("state1_0")].head
		assertNotNull("state found", s)
		
		assertEquals("leave state triggers", 2, s.caughtTriggers.size)
		
		assertEquals("1st trigger", "in1".trigger , s.caughtTriggers.get(0).trigger)
		// note: the transition in the sub graph is unguarded and hides the top level one
		assertEquals("1st trigger, transitions", 1, s.caughtTriggers.get(0).links.size)
		assertEquals("2nd trigger", "in2".trigger , s.caughtTriggers.get(1).trigger)
		assertEquals("2nd trigger, transitions", 1, s.caughtTriggers.get(1).links.size)
	}
	
	@Test
	def void testTrigger_state1_1() {
		val s = gc.graph.allStateNodes.filter[name.equals("state1_1")].head
		assertNotNull("state found", s)
		
		assertEquals("leave state triggers", 2, s.caughtTriggers.size)
		
		assertEquals("1st trigger", "in1".trigger , s.caughtTriggers.get(0).trigger)
		// note: the transition in the sub graph is guarded and two top level ones are also added
		assertEquals("1st trigger, transitions", 3, s.caughtTriggers.get(0).links.size)
		assertEquals("2nd trigger", "in2".trigger , s.caughtTriggers.get(1).trigger)
		assertEquals("2nd trigger, transitions", 1, s.caughtTriggers.get(1).links.size)
	}
	
	def trigger(String msg) {
		"p0" + TriggerExtensions.TRIGGER_SEP + msg
	}
}