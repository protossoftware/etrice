/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package my.etrice.generator;

import my.etrice.generator.setup.DerivedGeneratorModule;

import org.eclipse.etrice.generator.java.Main;

/**
 * EXAMPLE: just delegate to base class
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class DerivedGenerator extends Main {

	public static void main(String[] args) {
		int ret = createAndRunGenerator(new DerivedGeneratorModule(), args);
		if (isTerminateOnError() && ret!=GENERATOR_OK)
			System.exit(ret);
	}
}
