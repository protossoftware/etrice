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

import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.naming.RoomNameProvider
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.generator.base.logging.NullLogger

class TestStatesTriggers extends FsmGenTestBase {
	
	RoomNameProvider roomNameProvider = new RoomNameProvider
	
	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("StatesTriggersExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
		
		// enrich our generator model with all we have
		gc.withTriggersInStates.withChainHeads.withCommonData
		
		assertFalse("diagnostician has no errors", diagnostician.isFailed)
	}
	
	@Test
	def void testNoTrigger() {
		val s = gc.graph.allStateNodes.filter[name.equals("State3")].head
		assertNotNull("state found", s)
		
		assertEquals("non-leave state has no caught triggers", 0, s.caughtTriggers.size)
	}
	
	@Test
	def void testObjectNumbers() {
		assertEquals("Number of states", 7, gc.graph.allStateNodes.size)
		assertEquals("Number of choice points", 1, gc.graph.allChoicePointNodes.size)
		assertEquals("Number of transition points", 4, gc.graph.allTransitionPointNodes.size)
		assertEquals("Number of entry points", 1, gc.graph.allEntryPointNodes.size)
		assertEquals("Number of exit points", 1, gc.graph.allExitPointNodes.size)
		assertEquals("Number of initial transitions", 2, gc.graph.allInitialTranisitionLinks.size)
		assertEquals("Number of triggered transitions", 11, gc.graph.allTriggeredTranisitionLinks.size)
		assertEquals("Number of continuation transitions", 3, gc.graph.allContinuationTranisitionLinks.size)
		assertEquals("Number of cpbranch transitions", 2, gc.graph.allCPBranchTranisitionLinks.size)
	}
	
	@Test
	def void testChainsAndTriggers() {
		assertEquals("transition chains", 13, gc.graph.getAllChainHeads.size)
	}
	
	@Test
	def void testGraph() {
		var s = gc.graph.nodes.filter[name.equals("State3")].head
		s = s.subgraph.nodes.filter[name.equals("State3")].head
		assertNotNull("state found", s)
		assertEquals("number of incoming transitions", 3, s.incoming.size);
		assertEquals("number of outgoing transitions", 2, s.outgoing.size);
		assertEquals("active triggers", 6, s.caughtTriggers.size);
		
		s = gc.graph.nodes.filter[name.equals("State2")].head
		assertNotNull("state found", s)
		assertEquals("number of incoming transitions", 4, s.incoming.size);
		assertEquals("number of outgoing transitions", 1, s.outgoing.size);
		assertEquals("active triggers", 3, s.caughtTriggers.size);
		
		val cp = gc.graph.nodes.filter[name.equals("CP1")].head
		assertNotNull("cp found", cp)
		assertEquals("number of incoming transitions", 1, cp.incoming.size);
		assertEquals("number of outgoing transitions", 3, cp.outgoing.size);
		
		val cts = cp.outgoing.filter[transition instanceof ContinuationTransition]
		assertEquals("Exactly one continuation (=default) transition", 1, cts.size)
	}
	
	@Test
	def void testChains() {
		val tr = gc.graph.allLinks.filter[roomNameProvider.getFullPath((transition as Transition)).equals("State3_TRANS_tr1_FROM_tp1_TO_State3")].head
		assertNotNull("transition found", tr)
		assertEquals("one chain head", 1, tr.chainHeads.size)
		assertEquals("correct chain head", "TRANS_tr5_FROM_tp0_TO_State3_tp1_BY_afct", roomNameProvider.getFullPath((tr.chainHeads.head.transition as Transition)))
	}
}