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
import java.io.ByteArrayOutputStream
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.etrice.core.room.RoomModel
import org.eclipse.etrice.generator.base.io.IGeneratorFileIO
import org.eclipse.etrice.generator.base.logging.ILogger
import org.eclipse.etrice.generator.base.args.Arguments

import static org.eclipse.etrice.generator.contractmonitor.setup.MonitorGeneratorOptions.TARGET_LANG

class MainGen {
	
	@Inject MonitorActorGen monitorGen
	
	def void doGenerate(Resource resource, Arguments arguments, IGeneratorFileIO fileIO, ILogger logger) {
		// TODO proper mechanism for generator options
		monitorGen.detailCodeGen.targetLanguage = arguments.get(TARGET_LANG)
		
		val model = resource.contents.head
		if(model instanceof RoomModel) {
			val contractModel = monitorGen.generateMonitors(model)
			if(!contractModel.actorClasses.empty) {
				val path = contractModel.name.replace('.', '/') + '.room'
				val contents = contractModel.serializeModel(resource.resourceSet, logger)
				fileIO.generateFile("Saving generated contracts", path, contents)
			}
		}
	}
	
	protected def serializeModel(RoomModel model, ResourceSet rs, ILogger logger) {
		val oos = new ByteArrayOutputStream();
		
		val res = rs.createResource(URI.createURI("tmp:/monitor.room"));
		res.contents.add(model);
		try {		
			res.save(oos, null);
		} catch (IOException e) {
			logger.logError(e.getMessage());
			e.printStackTrace
		} finally {
			rs.resources.remove(res)
		}
		
		'''
			/** generated */
			
			«oos»
		'''
	}
	
}
