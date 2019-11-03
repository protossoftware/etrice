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
 * 		hrr@protos.de (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm.tests

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.etrice.core.RoomStandaloneSetup
import org.eclipse.etrice.core.TestBase
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician
import org.eclipse.etrice.core.genmodel.fsm.NullDiagnostician
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.GraphContainer
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilderFactory
import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilder

class FsmGenTestBase extends TestBase {

	protected Resource res = null
	protected ActorClass actor
	protected IDiagnostician diagnostician = new NullDiagnostician
	protected extension ExtendedFsmGenBuilder builder
	
	new() {
		val injector = new RoomStandaloneSetup().createInjectorAndDoEMFRegistration()
		builder = injector.getInstance(ExtendedFsmGenBuilderFactory).create(diagnostician)
	}

	protected def getGraphContainer(String roomFile, String actorName) {
		prepare(FSMGenModelTestsActivator.getInstance().getBundle())
		res = getResource(roomFile)
		actor = (res.contents.head as RoomModel).roomClasses.filter(ActorClass).findFirst[name.equals(actorName)]
		builder.createTransformedModel(actor)
	}
	
	protected def save(GraphContainer gc, String fileName) {
		val rs = new ResourceSetImpl
		val uri = URI.createFileURI("./output/" + fileName + ".fsmgen")
		val res = rs.createResource(uri)
		res.contents.add(gc)
		res.save(newHashMap)
	}
}