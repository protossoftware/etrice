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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Peter Karlitschek
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.cpp.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.generator.generic.PrepareFileSystem

@Singleton
class MainGen {
	
	@Inject DataClassGen dataClassGen
	@Inject ProtocolClassGen protocolClassGen
	@Inject ActorClassGen actorClassGen
	@Inject NodeGen subsystemClassGen
	@Inject NodeRunnerGen subsystemRunnerGen
	@Inject PrepareFileSystem prepFS
	
	def void doGenerate(Resource resource) {
		prepFS.prepareCodeTargetPaths(resource)
		prepFS.prepareInfoTargetPaths(resource)
		for (e: resource.contents){
			if (e instanceof Root) {
				doGenerate(e as Root)
			}
		}
	}
	
	def void doGenerate(Root e) {
		dataClassGen.doGenerate(e);
		protocolClassGen.doGenerate(e);
		actorClassGen.doGenerate(e);
		subsystemClassGen.doGenerate(e);

		if (!e.library) {
			subsystemRunnerGen.doGenerate(e);
		}
	}
}