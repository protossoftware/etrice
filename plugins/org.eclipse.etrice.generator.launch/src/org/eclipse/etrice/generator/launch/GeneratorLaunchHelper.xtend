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

package org.eclipse.etrice.generator.launch

import com.google.inject.Inject
import com.google.inject.Provider
import java.nio.file.Paths
import java.util.Collection
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.common.scoping.ModelLocator
import org.eclipse.etrice.core.ui.RoomUiModule
import org.eclipse.etrice.generator.fsm.base.FileSystemHelpers

class GeneratorLaunchHelper {

	@Inject Provider<ResourceSet> resourceSetProvider
	@Inject ModelLocator modelLocator
	
	/**
	 *  @return all transitive dependencies from .etmap files within their projects
	 */
	static def Collection<String> getAllDependenciesWithinProjects(Iterable<String> models) {
		val helper = new GeneratorLaunchHelper => [
			RoomUiModule.injector.injectMembers(it)
		]
		
		newLinkedHashSet => [
			addAll(models)
			addAll(models.map[helper.getAllDependencies(it)].flatten)
		]
	}

	def getAllDependencies(String filePath) {				
		val uri = URI.createURI(modelLocator.resolve(filePath, null)?:"")	
		if(!"etmap".equalsIgnoreCase(uri?.fileExtension))
			return emptyList
		
		val rs = resourceSetProvider.get
		val res = try { rs.getResource(uri, true) } catch(RuntimeException e) {}
		if(res?.contents?.head === null)
			return emptyList
		
		val projectURI = FileSystemHelpers::getProjectURI(res.contents.head)	
		if(projectURI === null || !projectURI.isFile || projectURI.relative) 
			return emptyList
		
		val projectPath = Paths.get(projectURI.toFileString)
			
		EcoreUtil.resolveAll(rs)
		rs.resources.map [
			switch it : URI {
				case isPlatformResource: {
					val platformMember = ResourcesPlugin.workspace.root.findMember(new Path(toPlatformString(false)))
					val location = platformMember?.location?.toOSString
					if(location !== null && Paths.get(location).startsWith(projectPath))
						location
				}
				case isFile: {
					if(Paths.get(toFileString).startsWith(projectPath))
						toFileString
			 	}
			}
		].filterNull
	}
}
