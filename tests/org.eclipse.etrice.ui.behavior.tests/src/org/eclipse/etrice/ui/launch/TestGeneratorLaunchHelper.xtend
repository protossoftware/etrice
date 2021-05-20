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

package org.eclipse.etrice.ui.launch

import java.nio.file.Paths
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.junit.BeforeClass
import org.junit.AfterClass
import java.nio.file.Files
import org.eclipse.etrice.generator.launch.GeneratorLaunchHelper
import java.util.List
import org.eclipse.core.runtime.CoreException

class TestGeneratorLaunchHelper {

	static val basePath = Paths.get('models', 'generatorLaunchHelper')
	static val projects = #['project1', 'project2']
	
	val helper = new GeneratorLaunchHelper
	val root = ResourcesPlugin.workspace.root
	
	@BeforeClass
	def static void createProjects() {
		projects.forEach[ projectName |
			val project = ResourcesPlugin.workspace.root.getProject(projectName)
			val description = ResourcesPlugin.workspace.newProjectDescription(projectName) => [
				location = new Path(basePath.resolve(projectName).toAbsolutePath.toString)
			]
			project.create(description, null)
			project.open(null)
		]
	}

	@Test
	def void notExisting() {
		#[] => [models | assertEquals(#[], get('project2', models))]
		#['/project/ '] => [models | assertThrows(CoreException, [get('project2', models)])]
		#['/project/1', '/project/.0�+/�`}]"�'] => [models | assertThrows(CoreException, [get('project2', models)])]
		#['/project/1.room', '/project/2.etphys', '/project/3.etmap', '/project/4.etconfig', '/project/5.unknown'] =>
			[models | assertThrows(CoreException, [get('project2', models)])]
	}

	@Test
	def void projectURI() {
		assertEquals(#[
			'/project1/System.etmap',
			'/project1/NotMapped.room',
			'/project1/Physical.etphys',
			'/project1/Dep.room',
			'/project1/NotMappedDep.room',
			'/project1/Dep2.room'
		], get('project1', #[
			'/project1/System.etmap',
			'/project1/NotMapped.room'
		]))

	}
	
	@Test
	def void projectModelpath() {
		assertEquals(#[
			'/project2/src/System.etmap',
			'/project2/src/Dep.room',
			'/project2/src/Physical.etphys'
		], get('project2', #[
			'/project2/src/System.etmap'
		]))
	}
	
	@AfterClass
	def static void deleteProjects() {
		projects.forEach[ projectName |
			ResourcesPlugin.workspace.root.getProject(projectName).delete(false, false, null)
			Files.delete(basePath.resolve(projectName + '/.project'))
		]
	}
	
	private def get(String project, List<String> list) {
		helper.loadResources(
			root.getProject(project),
			list.map[root.getFile(new Path(it))],
			true
		).map[URI.toPlatformString(true)]
	}
}
