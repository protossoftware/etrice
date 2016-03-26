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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.etrice.generator.ui.wizard.NewSetOfModelsWizard;

/**
 * This singleton collects the extensions registered with {@link #ICONFIGURATOR_ID}.
 * It is called by the {@link NewSetOfModelsWizard} and applies all configured project configurators
 * if the project has the specified nature.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class ProjectConfigurationDelegator implements IProjectConfigurator {

	private static final String ICONFIGURATOR_ID = "org.eclipse.etrice.generator.ui.project_configurator";
	
	private static ProjectConfigurationDelegator instance = null;
	
	private HashMap<String, ArrayList<IProjectConfigurator>> nature2configurators = new HashMap<String, ArrayList<IProjectConfigurator>>();
	
	/**
	 * @return the singleton instance of this class
	 */
	public static ProjectConfigurationDelegator getInstance() {
		if (instance==null)
			instance = new ProjectConfigurationDelegator();
		
		return instance;
	}

	/**
	 * The constructor instantiates the configured extensions.
	 */
	private ProjectConfigurationDelegator() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(ICONFIGURATOR_ID);
		for (IConfigurationElement e : config) {
			try {
				final Object ext = e.createExecutableExtension("class");
				if (ext instanceof IProjectConfigurator) {
					IProjectConfigurator configurator = (IProjectConfigurator) ext;
					String nature = e.getAttribute("appliesToNature");
					addConfigurator(nature, configurator);
				}
			}
			catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * This helper method adds the configurator to our hash map
	 * @param nature the nature to which this configurator is applicable
	 * @param configurator the project configurator
	 */
	private void addConfigurator(String nature, IProjectConfigurator configurator) {
		ArrayList<IProjectConfigurator> configurators = nature2configurators.get(nature);
		if (configurators==null)
			nature2configurators.put(nature, configurators = new ArrayList<IProjectConfigurator>());
		
		configurators.add(configurator);
	}

	/**
	 * This method applies all configurators configured with the {@link #ICONFIGURATOR_ID} extension point.
	 * @param progressMonitor 
	 * 
	 * @see org.eclipse.etrice.generator.ui.configurator.IProjectConfigurator#configure(org.eclipse.core.resources.IProject)
	 */
	@Override
	public void configure(IProject project, IProgressMonitor progressMonitor) {
		for (Entry<String, ArrayList<IProjectConfigurator>> entry : nature2configurators.entrySet()) {
			try {
				if (project.hasNature(entry.getKey())) {
					for (IProjectConfigurator configurator : entry.getValue()) {
						configurator.configure(project, progressMonitor);
					}
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

}
