/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.java.gen;

import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class GlobalSettings extends GlobalGeneratorSettings {
	
	private boolean generatePersistenceInterface = false;
	private boolean generateStoreDataObj = false;
	
	/**
	 * @return the generatePersistenceInterface
	 */
	public boolean isGeneratePersistenceInterface() {
		return generatePersistenceInterface;
	}

	/**
	 * @param generatePersistenceInterface the generatePersistenceInterface to set
	 */
	public void setGeneratePersistenceInterface(boolean generatePersistenceInterface) {
		this.generatePersistenceInterface = generatePersistenceInterface;
	}

	/**
	 * @return the generateStoreDataObj
	 */
	public boolean isGenerateStoreDataObj() {
		return generateStoreDataObj;
	}

	/**
	 * @param generateStoreDataObj the generateStoreDataObj to set
	 */
	public void setGenerateStoreDataObj(boolean generateStoreDataObj) {
		this.generateStoreDataObj = generateStoreDataObj;
	}
}
