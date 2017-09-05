/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

class TestGeneratorLaunchHelper {

	private def get(Iterable<String> list) {
		getAllDependenciesWithinProjects(list).toList
	}

	@Test
	def void notExisting() {
		#[] => [models|assertEquals(models, get(models))]
//		#[''] => [models|assertEquals(models, get(models))]
		#['1', '.0ß+/§`}]"°'] => [models|assertEquals(models, get(models))]
		#['1.room', '2.etphys', '3.etmap', '4.etconfig', '5.unknown'] => [models|assertEquals(models, get(models))]
	}

//	@Test
//	def void project() {
//		val (String) => String toAbsolutePath = [file| Paths.get('models/generatorLaunchHelper', file).toAbsolutePath.toString]
//
//		assertEquals(
//			#[
//			'project1/System.etmap',
//			'project1/NotMapped.room',
//			'project1/Physical.etphys',
//			'project1/Dep.room'
//		].map[toAbsolutePath.apply(it)], get(
//			#[
//			'project1/System.etmap',
//			'project1/NotMapped.room'
//		].map[toAbsolutePath.apply(it)]))
//
//	}
}
