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
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.genmodel.etricegen.Root
import org.eclipse.etrice.generator.generic.PrepareFileSystem
import org.eclipse.etrice.generator.java.Main
import org.eclipse.etrice.generator.java.setup.GeneratorOptionsHelper

@Singleton
class MainGen {
	
	@Inject DataClassGen dataClassGen
	@Inject EnumerationTypeGen enumTypeGen
	@Inject ProtocolClassGen protocolClassGen
	@Inject ActorClassGen actorClassGen
	@Inject ActorClassDataGen actorClassDataGen
	@Inject OptionalActorInterfaceGen optionalActorInterfaceGen
	@Inject OptionalActorFactoryGen optionalActorFactoryGen
	@Inject NodeGen nodeGen
	@Inject NodeRunnerGen nodeRunnerGen
	@Inject PrepareFileSystem prepFS
	
	@Inject protected extension GeneratorOptionsHelper
	
	def void doGenerate(Resource resource) {
		prepFS.prepare
		for (e: resource.contents){
			if (e instanceof Root) {
				doGenerate(e as Root)
			}
		}
	}
	
	def void doGenerate(Root e) {
		dataClassGen.doGenerate(e)
		enumTypeGen.doGenerate(e)
		protocolClassGen.doGenerate(e)
		actorClassGen.doGenerate(e)
		if (Main::settings.isGenerateStoreDataObj)
			actorClassDataGen.doGenerate(e)
		optionalActorInterfaceGen.doGenerate(e)
		optionalActorFactoryGen.doGenerate(e)
		nodeGen.doGenerate(e);
		
		if (!e.library) {
			nodeRunnerGen.doGenerate(e)
		}
	}
}