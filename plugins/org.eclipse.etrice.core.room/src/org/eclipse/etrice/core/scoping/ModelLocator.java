/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.scoping;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ModelLocator {
	private static final String IMODEL_LOCATOR_ID = "org.eclipse.etrice.core.room.modellocator";

	private static ModelLocator instance = null;
	private ArrayList<IModelLocator> locators = new ArrayList<IModelLocator>();
	
	private ModelLocator() {
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

	public static ModelLocator getInstance() {
		if (instance==null) {
			instance = new ModelLocator();
		}
		
		return instance;
	}

	public File locateModel(File path) {
		for (IModelLocator locator : locators) {
			File result = locator.locateModel(path);
			if (result!=null)
				return result;
		}
		
		return path;
	}
	
}
