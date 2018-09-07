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
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.java;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.etrice.generator.base.io.ILineOutput;
import org.eclipse.etrice.generator.java.Main;
import org.eclipse.etrice.generator.java.setup.GeneratorOptions;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class JavaGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#addArguments(org.eclipse.debug.core.ILaunchConfiguration, java.lang.StringBuffer)
	 */
	@Override
	protected void addArguments(ILaunchConfiguration configuration, IProject project, StringBuffer argString) throws CoreException {
		super.addArguments(configuration, project, argString);
		
		if (configuration.getAttribute(JavaGeneratorConfigTab.PERSIST, false)) {
			argString.append(" -"+GeneratorOptions.GEN_PERSIST.getName());
		}
		
		if (configuration.getAttribute(JavaGeneratorConfigTab.DATA_OBJ, false)) {
			argString.append(" -"+GeneratorOptions.GEN_STORE_DATA_OBJ.getName());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#runGenerator(java.lang.String[], org.eclipse.etrice.generator.launch.ILineOutput)
	 */
	@Override
	protected void runGenerator(String[] args, ILineOutput out) {
		Main.setOutput(out);
		Main.run(args);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	@Override
	protected String getConsoleName() {
		return "eTrice Java Generator Console";
	}

}
