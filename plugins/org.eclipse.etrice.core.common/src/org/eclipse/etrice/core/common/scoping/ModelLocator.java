/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.scoping;

import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Henrik Rentz-Reichert
 *
 */
@Singleton
public class ModelLocator {
	private static final String IMODEL_LOCATOR_ID = "org.eclipse.etrice.core.common.modellocator";

	private ArrayList<IModelLocator> locators = new ArrayList<IModelLocator>();
	
	@Inject
	public ModelLocator(IModelLocator defaultLocator) {
		addLocator(defaultLocator);
	}
	
	public void loadExtensions() {
		IConfigurationElement[] config = Platform.getExtensionRegistry()
				.getConfigurationElementsFor(IMODEL_LOCATOR_ID);
		
		for (IConfigurationElement e : config) {
			try {
				final Object ext = e.createExecutableExtension("class");
				if (ext instanceof IModelLocator) {
					IModelLocator locator = (IModelLocator) ext;
					locators.add(locator);
				}
			}
			catch (CoreException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	public void addLocator(IModelLocator locator) {
		if (locator!=null) {
			locators.add(0, locator);
		}
	}

	public void removeLocator(IModelLocator locator) {
		locators.remove(locator);
	}
	
	public String resolve(String resolve, Resource resource) {
		for (IModelLocator locator : locators) {
			String result = locator.resolve(resolve, resource);
			if (result!=null)
				return result;
		}
		return null;
	}
	
}
