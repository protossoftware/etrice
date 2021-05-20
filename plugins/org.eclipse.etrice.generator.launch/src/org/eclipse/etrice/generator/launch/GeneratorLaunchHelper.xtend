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
import java.util.Collection
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.etrice.core.ui.RoomUiModule
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.etrice.core.common.scoping.ModelLocatorUriResolver

class GeneratorLaunchHelper {

	@Inject XtextResourceSetProvider resourceSetProvider
	@Inject ModelLocatorUriResolver modelLocator
	
	/**
	 *  @return all transitive dependencies from files within the project
	 */
	static def Iterable<String> getAllDependenciesWithinProject(IProject project, Iterable<String> models) {
		val helper = new GeneratorLaunchHelper => [
			RoomUiModule.injector.injectMembers(it)
		]
		
		newLinkedHashSet => [
			addAll(models)
			addAll(helper.getAllDependencies(project, models))
		]
	}

	def getAllDependencies(IProject project, Iterable<String> models) {
		val ws = ResourcesPlugin.workspace.root
		val rs = resourceSetProvider.get(project)
		
		models.map[filePath | URI.createURI(modelLocator.resolve(filePath, null)?:"")]
			.forEach[uri | try { rs.getResource(uri, true) } catch(RuntimeException e) {}]
			
		EcoreUtil.resolveAll(rs)

		rs.resources.map [
				switch it : URI {
					case isPlatformResource: ws.findMember(new Path(toPlatformString(false)))
					case isFile: ws.getFileForLocation(new Path(toFileString))
				}].filterNull
			.filter[file | file.project.equals(project)]
			.map[location?.toOSString].filterNull
	}
	
	def static groupByProject(Collection<String> files) {
		val ws = ResourcesPlugin.workspace.root
		val m = files.groupBy[ws.getFileForLocation(new Path(it))?.project]
		m.remove(null)
		return m
	}
}
