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
 *******************************************************************************/package org.eclipse.etrice.generator.launch.contractmonitor;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.etrice.generator.launch.GeneratorConfigTab;


public class ContractMonitorGeneratorConfigTab extends GeneratorConfigTab {
	
	@Override
	public String getName() {
		return "Contract Monitor Generator";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy)
	 */
	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(OVERRIDE_DIRECTORIES, true);
		configuration.setAttribute(SRCGEN_PATH, "model-gen");
	}

}
