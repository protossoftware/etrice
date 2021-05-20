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
 * 		Christian Hilden (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.contractmonitor;

import com.google.inject.Module;

import org.eclipse.etrice.generator.contractmonitor.setup.GeneratorModule;
import org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate;


public class ContractMonitorGeneratorLaunchConfigurationDelegate extends GeneratorLaunchConfigurationDelegate {

	@Override
	protected Module createGeneratorModule() {
		return new GeneratorModule();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorLaunchConfigurationDelegate#getConsoleName()
	 */
	@Override
	protected String getConsoleName() {
		return "Contract Monitor Generator Console";
	}

}
