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

import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.NullLogger
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.naming.RoomNameProvider
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.SimpleState

class TestStatesInheritance extends FsmGenTestBase {
	
	RoomNameProvider roomNameProvider = new RoomNameProvider
	
	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("StatesInheritanceExample.room", "TestActor")
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
		assertEquals("Number of states", 11, gc.graph.allStateNodes.size)
		assertEquals("Number of states", 9, gc.graph.allStateNodes.filter[stateGraphNode instanceof SimpleState].size)
		assertEquals("Number of choice points", 1, gc.graph.allChoicePointNodes.size)
		assertEquals("Number of transition points", 5, gc.graph.allTransitionPointNodes.size)
		assertEquals("Number of entry points", 2, gc.graph.allEntryPointNodes.size)
		assertEquals("Number of exit points", 1, gc.graph.allExitPointNodes.size)
		assertEquals("Number of initial transitions", 3, gc.graph.allInitialTranisitionLinks.size)
		assertEquals("Number of triggered transitions", 17, gc.graph.allTriggeredTranisitionLinks.size)
		assertEquals("Number of continuation transitions", 4, gc.graph.allContinuationTranisitionLinks.size)
		assertEquals("Number of cpbranch transitions", 3, gc.graph.allCPBranchTranisitionLinks.size)
	}
	
	@Test
	def void testChainsAndTriggers() {
		assertEquals("transition chains", 20, gc.graph.getAllChainHeads.size)
	}
	
	@Test
	def void testGraph() {
		var s = gc.graph.allStateNodes.filter[roomNameProvider.getFullPath(stateGraphNode).equals("State3_State3")].head
		assertNotNull("state exists", s)
		assertEquals("number of incoming transitions", 3, s.incoming.size)
		assertEquals("number of outgoing transitions", 2, s.outgoing.size)
		assertEquals("active triggers", 6, s.caughtTriggers.size)
		
		s = gc.graph.allStateNodes.filter[roomNameProvider.getFullPath(stateGraphNode).equals("State2")].head
		assertNotNull("state exists", s)
		assertEquals("number of incoming transitions", 4, s.incoming.size)
		assertEquals("number of outgoing transitions", 1, s.outgoing.size)
		assertEquals("active triggers", 3, s.caughtTriggers.size)
		
		val cp = gc.graph.allChoicePointNodes.filter[stateGraphNode.name.equals("CP1")].head
		assertNotNull("cp exists", cp)
		assertEquals("number of incoming transitions", 1, cp.incoming.size)
		assertEquals("number of outgoing transitions", 4, cp.outgoing.size)
		
		val cts = cp.outgoing.filter[transition instanceof ContinuationTransition]
		assertEquals("Exactly one continuation (=default) transition", 1, cts.size)
	}
	
	@Test
	def void testChains() {
		var tr = gc.graph.allLinks.filter[roomNameProvider.getFullPath((transition as Transition)).equals("State3_TRANS_tr1_FROM_tp1_TO_State3")].head
		assertNotNull("transition", tr)
		
		assertEquals("one chain head", 1, tr.chainHeads.size)
		assertEquals("chain name", "TRANS_tr5_FROM_tp0_TO_State3_tp1_BY_afct", roomNameProvider.getFullPath(tr.chainHeads.head.transition as Transition))
		
		tr = gc.graph.allLinks.filter[roomNameProvider.getFullPath((transition as Transition)).equals("State3_TRANS_tr8_FROM_tp6_TO_State2")].head
		assertNotNull("transition", tr)
		
		assertEquals("one chain head", 1, tr.chainHeads.size)
		assertEquals("chain name", "TRANS_tr12_FROM_State5_TO_State3_tp6_BY_aport", roomNameProvider.getFullPath(tr.chainHeads.head.transition as Transition))
		
	}
}