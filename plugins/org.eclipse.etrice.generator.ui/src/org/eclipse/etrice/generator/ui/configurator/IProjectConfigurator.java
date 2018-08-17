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

package org.eclipse.etrice.generator.ui.configurator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.etrice.generator.ui.wizard.NewSetOfModelsWizard;

/**
 * This interface is used by the org.eclipse.etrice.generator.ui.project_configurator extension point.
 * The method is called when a new set of models is created by the {@link NewSetOfModelsWizard}.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public interface IProjectConfigurator {

	/**
	 * @param project the project to be configured
	 * @param progressMonitor the progress monitor
	 * @param copyRuntime <code>true</code> if runtime should be copied into the project
	 * @param platform the name of the chosen platform (others will be excluded from the build)
	 */
	void configure(IProject project, IPath path, boolean copyRuntime, String platform, IProgressMonitor progressMonitor);
}
