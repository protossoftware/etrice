/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.behavior.commands

import com.google.common.collect.Sets
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.RoomStandaloneSetup
import org.eclipse.etrice.core.TestBase
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder
import org.eclipse.etrice.core.genmodel.fsm.FsmGenChecker
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician
import org.eclipse.etrice.core.genmodel.fsm.NullDiagnostician
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Link
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.Node
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.ui.behavior.BehaviorTestActivator
import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue
import org.eclipse.etrice.generator.base.logging.NullLogger
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilderFactory

class TestFSMGenModel extends TestBase {

	val injector = new RoomStandaloneSetup().createInjectorAndDoEMFRegistration()
	protected IDiagnostician diagnostician = new NullDiagnostician
	protected extension ExtendedFsmGenBuilder builder = injector.getInstance(ExtendedFsmGenBuilderFactory).create(diagnostician)

	protected def createResourceSetWithGc(String roomFile, String actorName) {
		prepare(BehaviorTestActivator.^default.getBundle())
		val res = getResource(roomFile)
		val actor = (res.contents.get(0) as RoomModel).actorClasses.findFirst[name.equals(actorName)]	
		
		val gc = builder.createTransformedModel(actor) => [gc |
			assertNotNull("graph context was created", gc)
			
			val logger = new NullLogger
			FsmGenChecker.check(gc, logger)
			assertFalse("logger has no errors", logger.hasErrors)
			save(gc, actor.name)
		]
		
		res.resourceSet.createResource(URI.createURI('dummy://' + actorName + '.fsmgen')) => [
			contents += gc
		]
		
		return res.resourceSet
	}
	
	protected def save(GraphContainer gc, String fileName) {
		val rs = new ResourceSetImpl
		val uri = URI.createFileURI("./output/" + fileName + ".fsmgen")
		val res = rs.createResource(uri)
		res.contents.add(gc)
		res.save(newHashMap)
	}
	
	@Test
	def void testBaseClass() {
		val rs = createResourceSetWithGc("InheritedStateMachine.room", "Base")
		val actorClasses = EcoreUtil.getAllContents(rs, true).filter(ActorClass).filter[name == 'Base'].toList
		val gc = rs.resources.map[contents].flatten.filter(GraphContainer).head
		
		checkAgainstRoom(gc, actorClasses)
	}
	
	@Test
	def void testDerivedClass() {
		val rs = createResourceSetWithGc("InheritedStateMachine.room", "Derived")
		val actorClasses = EcoreUtil.getAllContents(rs, true).filter(ActorClass).filter[name == 'Base' || name == 'Derived'].toList
		val gc = rs.resources.map[contents].flatten.filter(GraphContainer).head
		
		checkAgainstRoom(gc, actorClasses)
	}
	
	@Test
	def void testDoubleDerivedClass() {
		val rs = createResourceSetWithGc("InheritedStateMachine.room", "DoubleDerived")
		val actorClasses = EcoreUtil.getAllContents(rs, true).filter(ActorClass).filter[name == 'Base' || name == 'Derived' || name == 'DoubleDerived'].toList
		val gc = rs.resources.map[contents].flatten.filter(GraphContainer).head
		
		checkAgainstRoom(gc, actorClasses)
	}
	
	def void checkAgainstRoom(GraphContainer gc, List<ActorClass> actorClasses) {
		// genmodel should refer to latest fsm	(check in-memory ref)
		val genModelRefs = (EcoreUtil.getAllContents(gc, true).filter(Node).map[stateGraphNode] + EcoreUtil.getAllContents(gc, true).filter(Link).map[transition]).toSet
		EcoreUtil.getAllContents(actorClasses.last, false).filter(StateGraphItem).forEach[
			assertTrue('missing ' + EcoreUtil.getURI(it), genModelRefs.contains(it))
		]
		
		// all fsm items should be in genmodel	(check name) 
		// node, there are duplicate names in subgraphs => not complete
		val stateGraphItemsNames = EcoreUtil.getAllContents(actorClasses, true).filter(StateGraphItem).map[name].toIterable.toSortedSet
		val namesFromGenModel = genModelRefs.map[name].toSortedSet	
		assertEquals(stateGraphItemsNames, namesFromGenModel)
	}
	
	private def <T extends Comparable<?>> toSortedSet(Iterable<T> iterable) {
		 Sets.<T>newTreeSet(iterable)
	}
	
}