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

package org.eclipse.etrice.generator.launch.cpp;

import com.google.inject.Module;

import org.eclipse.etrice.generator.cpp.setup.GeneratorModule;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;


/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CppGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	@Override
	protected Module createGeneratorModule() {
		return new GeneratorModule();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	@Override
	protected String getConsoleName() {
		return "eTrice C++ Generator Console";
	}

}
