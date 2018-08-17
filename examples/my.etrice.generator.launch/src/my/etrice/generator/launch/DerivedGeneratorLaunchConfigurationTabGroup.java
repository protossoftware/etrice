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

import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.RefreshTab;
import org.eclipse.etrice.generator.launch.java.JavaGeneratorLaunchConfigurationTabGroup;
import org.eclipse.etrice.generator.launch.java.JavaGeneratorMainTab;

/**
 * EXAMPLE: the tabs are assembled. All but one tab are re-used
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class DerivedGeneratorLaunchConfigurationTabGroup extends
		JavaGeneratorLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new JavaGeneratorMainTab(),
				new DerivedGeneratorConfigTab(),
				new RefreshTab(),
				new EnvironmentTab(),
				new CommonTab()
			};
		setTabs(tabs);
	}

}
