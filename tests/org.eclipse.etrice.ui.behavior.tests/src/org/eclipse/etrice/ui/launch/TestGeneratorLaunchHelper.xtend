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

import static org.eclipse.etrice.generator.launch.GeneratorLaunchHelper.*
import static org.junit.Assert.*
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.junit.BeforeClass
import org.junit.AfterClass
import java.nio.file.Files

class TestGeneratorLaunchHelper {

	static val basePath = Paths.get('models', 'generatorLaunchHelper')
	static val projects = #['project1', 'project2']
	
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
		#[] => [models|assertEquals(models, get('project2', models))]
		#[''] => [models|assertEquals(models, get('project2', models))]
		#['1', '.0ß+/§`}]"°'] => [models|assertEquals(models, get('project2', models))]
		#['1.room', '2.etphys', '3.etmap', '4.etconfig', '5.unknown'] => [models|assertEquals(models, get('project2', models))]
	}

	@Test
	def void projectURI() {
		assertEquals(
			#[
			'project1/System.etmap',
			'project1/NotMapped.room',
			'project1/Physical.etphys',
			'project1/Dep.room',
			'project1/NotMappedDep.room',
			'project1/Dep2.room'
		].map[toAbsolutePath], get('project1',
			#[
			'project1/System.etmap',
			'project1/NotMapped.room'
		].map[toAbsolutePath]))

	}
	
	@Test
	def void projectModelpath() {
		assertEquals(#[
				'project2/src/System.etmap',
				'project2//src/Dep.room',
				'project2/src/Physical.etphys'
			].map[toAbsolutePath], get('project2', #[
				'project2/src/System.etmap'
			].map[toAbsolutePath])
		)
	}
	
	@AfterClass
	def static void deleteProjects() {
		projects.forEach[ projectName |
			ResourcesPlugin.workspace.root.getProject(projectName).delete(false, false, null)
			Files.delete(basePath.resolve(projectName + '/.project'))
		]
	}
	
	private def get(String project, Iterable<String> list) {
		getAllDependenciesWithinProject(ResourcesPlugin.workspace.root.getProject(project), list).toList
	}
	
	private def toAbsolutePath(String file) {
		basePath.resolve(file).toAbsolutePath.toString
	}
}
