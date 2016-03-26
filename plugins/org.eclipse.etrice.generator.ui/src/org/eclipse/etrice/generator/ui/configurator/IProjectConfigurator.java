/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.ui.configurator;

import org.eclipse.core.resources.IProject;
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
	 */
	void configure(IProject project, IProgressMonitor progressMonitor);
}
