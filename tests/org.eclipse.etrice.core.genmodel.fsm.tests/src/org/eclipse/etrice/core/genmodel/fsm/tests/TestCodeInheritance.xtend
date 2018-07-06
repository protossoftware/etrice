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
import org.eclipse.etrice.core.fsm.util.FSMHelpers
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.NullLogger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertNull
import static org.junit.Assert.assertTrue

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*

class TestCodeInheritance extends FsmGenTestBase {
	
	GraphContainer gc
	
	extension FSMHelpers fsmHelpers = new FSMHelpers
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("CodeInheritanceExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
		assertFalse("diagnostician has no errors", diagnostician.isFailed)
	}
	
	@Test
	def void testActionCodes_BaseEntryExit() {
		val s = gc.graph.allStateNodes.findFirst[name.equals("BaseEntryExit")]
		assertNotNull("state found", s)
		assertTrue("refined state", s.stateGraphNode instanceof RefinedState)
		val rs = s.stateGraphNode as RefinedState
		assertEquals("entry code", "// derived entry\n", rs.entryCode.detailCode)
		assertNull("exit code", rs.exitCode)
		assertEquals("inherited entry", "// base entry\n", rs.inheritedEntryCode.detailCode)
		assertEquals("inherited exit", "// base exit\n", rs.inheritedExitCode.detailCode)
	}
	
	@Test
	def void testActionCodes_Base() {
		val s = gc.graph.allStateNodes.findFirst[name.equals("Base")]
		assertNotNull("state found", s)
		assertTrue("refined state", s.stateGraphNode instanceof RefinedState)
		val rs = s.stateGraphNode as RefinedState
		assertNull("entry code", rs.entryCode)
		assertEquals("exit code", "// derived exit\n", rs.exitCode.detailCode)
		assertEquals("inherited entry", "", rs.inheritedEntryCode.detailCode)
		assertEquals("inherited exit", "", rs.inheritedExitCode.detailCode)
	}
	
	@Test
	def void testActionCodes_BaseSub() {
		val s = gc.graph.allStateNodes.findFirst[name.equals("BaseSub")]
		assertNotNull("state found", s)
		assertTrue("refined state", s.stateGraphNode instanceof RefinedState)
		val rs = s.stateGraphNode as RefinedState
		assertEquals("entry code", "// derived entry\n", rs.entryCode.detailCode)
		assertNull("exit code", rs.exitCode)
		assertEquals("inherited entry", "", rs.inheritedEntryCode.detailCode)
		assertEquals("inherited exit", "", rs.inheritedExitCode.detailCode)
	}
}