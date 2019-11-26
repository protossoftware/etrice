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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.launch.doc;

import org.eclipse.etrice.generator.launch.GeneratorConfigTab;
import org.eclipse.etrice.generator.ui.preferences.PreferenceConstants;

public class DocGeneratorConfigTab extends GeneratorConfigTab {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTab#getName()
	 */
	@Override
	public String getName() {
		return "Doc Generator";
	}
	
	protected String getSrcgenDirPreferenceConstantName() {
		return PreferenceConstants.GEN_DOC_DIR;
	}
}
