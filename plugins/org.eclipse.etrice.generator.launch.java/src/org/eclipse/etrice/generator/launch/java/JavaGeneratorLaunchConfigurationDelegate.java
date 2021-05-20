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

import com.google.inject.Module;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.java.setup.GeneratorModule;
import org.eclipse.etrice.generator.java.setup.GeneratorOptions;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class JavaGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	@Override
	protected Module createGeneratorModule() {
		return new GeneratorModule();
	}
	
	@Override
	protected void configureArguments(Arguments args, ILaunchConfiguration configuration, IProject project) throws CoreException {
		super.configureArguments(args, configuration, project);
		
		boolean persist = configuration.getAttribute(JavaGeneratorConfigTab.PERSIST, false);
		args.set(GeneratorOptions.GEN_PERSIST, persist);
		boolean dataObj = configuration.getAttribute(JavaGeneratorConfigTab.DATA_OBJ, false);
		args.set(GeneratorOptions.GEN_STORE_DATA_OBJ, dataObj);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	@Override
	protected String getConsoleName() {
		return "eTrice Java Generator Console";
	}

}
