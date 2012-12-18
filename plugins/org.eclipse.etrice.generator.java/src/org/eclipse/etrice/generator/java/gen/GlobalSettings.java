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

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class GlobalSettings {

	private static boolean generateMSCInstrumentation = false;
	private static boolean generateWithVerboseOutput = false;

	public static boolean generateMSCInstrumentation() {
		return generateMSCInstrumentation;
	}

	public static void setGenerateMSCInstrumentation(
			boolean generateMSCInstrumentation) {
		GlobalSettings.generateMSCInstrumentation = generateMSCInstrumentation;
	}

	public static boolean generateWithVerboseOutput() {
		return generateWithVerboseOutput;
	}

	public static void setGenerateWithVerboseOutput(boolean generateWithVerboseOutput) {
		GlobalSettings.generateWithVerboseOutput = generateWithVerboseOutput;
	}
	
}
