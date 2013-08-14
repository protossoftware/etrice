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
	
	private static boolean generatePersistenceInterface = false;

	public static void reset() {
		generatePersistenceInterface = false;
		
		GlobalGeneratorSettings.reset();
	}
	
	/**
	 * @return the generatePersistenceInterface
	 */
	public static boolean isGeneratePersistenceInterface() {
		return generatePersistenceInterface;
	}

	/**
	 * @param generatePersistenceInterface the generatePersistenceInterface to set
	 */
	public static void setGeneratePersistenceInterface(boolean generatePersistenceInterface) {
		GlobalSettings.generatePersistenceInterface = generatePersistenceInterface;
	}
}
