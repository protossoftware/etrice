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
		System.exit(ret);
	}
}
