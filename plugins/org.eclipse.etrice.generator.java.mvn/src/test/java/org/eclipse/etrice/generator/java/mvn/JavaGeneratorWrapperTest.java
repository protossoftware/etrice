/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.java.mvn;

import java.io.File;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class JavaGeneratorWrapperTest extends AbstractMojoTestCase {


	/**
	 * @throws Exception
	 * 
	 */
	public void testGenerator() throws Exception {
		File pom = getTestFile("src/test/resources/unit/project-to-test/pom.xml");
		assertNotNull(pom);
		assertTrue(pom.exists());

		JavaGeneratorWrapper gen = (JavaGeneratorWrapper) lookupMojo("eTriceJavaGenerator", pom);
		assertNotNull(gen);
		
		System.out.print("arguments: ");
		for (String arg : gen.arguments) {
			System.out.print(arg+" ");
		}
		System.out.println("");
		
		gen.execute();
	}

}
