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

package org.eclipse.etrice.generator.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.RefreshUtil;
import org.eclipse.debug.ui.RefreshTab;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class GeneratorRefreshTab extends RefreshTab {

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		try {
			String scope = null;
			scope = configuration.getAttribute(ATTR_REFRESH_SCOPE, (String)null);
			if (scope==null)
				configuration.setAttribute(ATTR_REFRESH_SCOPE, RefreshUtil.MEMENTO_WORKSPACE);
			setAttribute(ATTR_REFRESH_RECURSIVE, configuration, true, true);
		} catch (CoreException ce) {
		}
	}
}
