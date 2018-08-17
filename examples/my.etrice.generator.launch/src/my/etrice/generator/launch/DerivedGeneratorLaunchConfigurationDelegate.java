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

package my.etrice.generator.launch;

import my.etrice.generator.DerivedGenerator;

import org.eclipse.etrice.generator.base.io.ILineOutput;
import org.eclipse.etrice.generator.launch.java.JavaGeneratorLaunchConfigurationDelegate;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DerivedGeneratorLaunchConfigurationDelegate extends
		JavaGeneratorLaunchConfigurationDelegate {

	/**
	 * EXAMPLE: override console name
	 * 
	 * @see org.eclipse.etrice.generator.launch.java.JavaGeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	protected String getConsoleName() {
		return "Derived Java Generator Console";
	}

	/**
	 * call the main generator
	 * 
	 * @see org.eclipse.etrice.generator.launch.java.JavaGeneratorLaunchConfigurationDelegate#runGenerator(java.lang.String[], org.eclipse.etrice.generator.base.ILineOutput)
	 */
	protected void runGenerator(String[] args, ILineOutput out) {
		DerivedGenerator.setOutput(out);
		DerivedGenerator.run(args);
	}

}
