/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		hrr@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm.tests

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.RoomStandaloneSetup
import org.eclipse.etrice.core.TestBase
import org.eclipse.etrice.core.genmodel.fsm.FsmGenBuilder
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI

class FsmGenTestBase extends TestBase {

	protected Resource res = null
	protected ActorClass actor

	protected def getGraphContainer(String roomFile, String actorName) {
		prepare(FSMGenModelTestsActivator.getInstance().getBundle())
		res = getResource(roomFile)
		actor = (res.contents.get(0) as RoomModel).actorClasses.findFirst[name.equals(actorName)]
		val injector = new RoomStandaloneSetup().createInjectorAndDoEMFRegistration()
		val FsmGenBuilder builder = new FsmGenBuilder(injector)
		builder.createTransformedModel(actor)
	}
	
	protected def save(GraphContainer gc, String fileName) {
		val rs = new ResourceSetImpl
		val uri = URI.createFileURI("./output/" + fileName + ".fsmgen2")
		val res = rs.createResource(uri)
		res.contents.add(gc)
		res.save(newHashMap)
	}
}