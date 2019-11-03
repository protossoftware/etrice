/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.contractmonitor.gen

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.base.args.Arguments
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.base.logging.ILogger
import org.eclipse.etrice.core.room.ActorClass

class MainGen {
	
	@Inject MonitorActorGen monitorGen
	
	def void doGenerate(Resource resource, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		val model = resource.contents.head
		if(model instanceof RoomModel) {
			val generatedModel = monitorGen.generateMonitors(model)
			if(!generatedModel.roomClasses.filter(ActorClass).empty) {
				val serializedModel = monitorGen.serializeMonitors(generatedModel, resource.resourceSet)
				val path = generatedModel.name.replace('.', '/') + '.room'
				fileIO.generateFile("Saving generated contracts", path, serializedModel)
			}
		}
	}
	
}
