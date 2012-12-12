/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.cpp;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.etrice.generator.base.ILineOutput;
import org.eclipse.etrice.generator.cpp.Main;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CppGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#addArguments(org.eclipse.debug.core.ILaunchConfiguration, java.lang.StringBuffer)
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void addArguments(ILaunchConfiguration configuration, StringBuffer argString) throws CoreException {
		if (configuration.getAttribute(CppGeneratorConfigTab.LIB, false)) {
			argString.append(" "+Main.OPTION_LIB);
		}
		if (configuration.getAttribute(CppGeneratorConfigTab.SAVE_GEN_MODEL, false)) {
			argString.append(" "+Main.OPTION_SAVE_GEN_MODEL);
			argString.append(" "+configuration.getAttribute(CppGeneratorConfigTab.GEN_MODEL_PATH, "?"));
		}
		if (configuration.getAttribute(CppGeneratorConfigTab.GEN_DOCUMENTATION, false)
				|| configuration.getAttribute(CppGeneratorConfigTab.GEN_INSTANCE_DIAGRAM, false))
			argString.append(" "+Main.OPTION_DOCUMENTATION);
		if (configuration.getAttribute(CppGeneratorConfigTab.ETUNIT, false))
			argString.append(" "+Main.OPTION_ETUNIT);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#runGenerator(java.lang.String[], org.eclipse.etrice.generator.launch.ILineOutput)
	 */
	@Override
	protected void runGenerator(String[] args, ILineOutput out) {
		org.eclipse.etrice.generator.cpp.Main.setOutput(out);
		org.eclipse.etrice.generator.cpp.Main.setTerminateOnError(false);
		org.eclipse.etrice.generator.cpp.Main.main(args);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	@Override
	protected String getConsoleName() {
		return "eTrice C++ Generator Console";
	}

}
