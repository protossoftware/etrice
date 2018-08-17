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

import org.eclipse.etrice.core.fsm.fSM.CPBranchTransition
import org.eclipse.etrice.core.fsm.fSM.ContinuationTransition
import org.eclipse.etrice.core.fsm.fSM.Transition
import org.eclipse.etrice.core.fsm.fSM.TriggeredTransition
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.room.DataClass
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.generator.base.logging.NullLogger
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

import static extension org.eclipse.etrice.core.genmodel.fsm.FsmGenExtensions.*

class TestMultipleConnectedChoicepoint extends FsmGenTestBase {
	
	GraphContainer gc
	
	@Before
	def void SetUp() {
		gc = getGraphContainer("MultipleConnectedChoicepointExample.room", "TestActor")
		assertNotNull("graph context was created", gc)
		
		val logger = new NullLogger
		FsmGenChecker.check(gc, logger)
		assertFalse("logger has no errors", logger.hasErrors)
		
		// enrich our generator model with all we have
		gc.withTriggersInStates.withChainHeads.withCommonData
		
		assertFalse("diagnostician has no errors", diagnostician.isFailed)
	}
	
	@Test
	def void testObjectNumbers() {
		assertEquals("Number of states", 6, gc.graph.allStateNodes.size)
		assertEquals("Number of choice points", 1, gc.graph.allChoicePointNodes.size)
		assertEquals("Number of transition points", 0, gc.graph.allTransitionPointNodes.size)
		assertEquals("Number of entry points", 1, gc.graph.allEntryPointNodes.size)
		assertEquals("Number of exit points", 1, gc.graph.allExitPointNodes.size)
		assertEquals("Number of initial transitions", 1, gc.graph.allInitialTranisitionLinks.size)
		assertEquals("Number of triggered transitions", 5, gc.graph.allTriggeredTranisitionLinks.size)
		assertEquals("Number of continuation transitions", 3, gc.graph.allContinuationTranisitionLinks.size)
		assertEquals("Number of cpbranch transitions", 1, gc.graph.allCPBranchTranisitionLinks.size)
	}
	
	@Test
	def void testChainsAndTriggers() {
		assertEquals("transition chains", 6, gc.graph.getAllChainHeads.size)
	}
	
	@Test
	def void testData() {
		var tr = gc.graph.links.filter[(transition as Transition).name.equals("tr0")].head
		assertNotNull("transition found", tr)
		assertTrue("transition is TriggeredTransition", tr.transition instanceof TriggeredTransition)
		var data = tr.commonData as MessageData
		assertTrue("data is DataClass", data.refType.type instanceof DataClass)
		assertEquals("data is of type", "DC2", data.refType.type.name)
		
		val s = gc.graph.nodes.filter[stateGraphNode.name.equals("state1")].head
		assertNotNull("state found", s)
		
		tr = s.subgraph.links.filter[(transition as Transition).name.equals("tr2")].head
		assertTrue("transition is TriggeredTransition", tr.transition instanceof TriggeredTransition)
		data = tr.commonData as MessageData
		assertTrue("data is DataClass", data.refType.type instanceof DataClass)
		assertEquals("data is of type", "DC2", data.refType.type.name)
		
		tr = s.subgraph.links.filter[(transition as Transition).name.equals("tr3")].head
		assertTrue("transition is TriggeredTransition", tr.transition instanceof TriggeredTransition)
		data = tr.commonData as MessageData
		assertTrue("data is DataClass", data.refType.type instanceof DataClass)
		assertEquals("data is of type", "DC4", data.refType.type.name)
		
 		tr = gc.graph.links.filter[(transition as Transition).name.equals("tr1")].head
		assertNotNull("transition found", tr)
		assertTrue("transition is TriggeredTransition", tr.transition instanceof TriggeredTransition)
		data = tr.commonData as MessageData
		assertTrue("data is DataClass", data.refType.type instanceof DataClass)
		assertEquals("data is of type", "DC3", data.refType.type.name)
		
 		tr = gc.graph.links.filter[(transition as Transition).name.equals("tr3")].head
		assertNotNull("transition found", tr)
		assertTrue("transition is ContinuationTransition", tr.transition instanceof ContinuationTransition)
		data = tr.commonData as MessageData
		assertTrue("data is DataClass", data.refType.type instanceof DataClass)
		assertEquals("data is of type", "DC", data.refType.type.name)
		
 		tr = gc.graph.links.filter[(transition as Transition).name.equals("tr4")].head
		assertNotNull("transition found", tr)
		assertTrue("transition is CPBranchTransition", tr.transition instanceof CPBranchTransition)
		data = tr.commonData as MessageData
		assertTrue("data is DataClass", data.refType.type instanceof DataClass)
		assertEquals("data is of type", "DC", data.refType.type.name)
	}
}