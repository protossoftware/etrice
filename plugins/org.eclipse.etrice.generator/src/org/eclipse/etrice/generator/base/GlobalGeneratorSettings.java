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

package org.eclipse.etrice.generator.base;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Henrik Rentz-Reichert
 *
 */
public class GlobalGeneratorSettings {

	private List<String> inputModelURIs = new ArrayList<String>();
	private boolean generateMSCInstrumentation = false;
	private boolean generateWithVerboseOutput = false;
	private String generatorModelPath = null;
	private boolean generateDocumentation = false;
	private boolean generateAsLibrary = false;
	private boolean debugMode = false;
	
	public boolean generateMSCInstrumentation() {
		return generateMSCInstrumentation;
	}

	public void setGenerateMSCInstrumentation(
			boolean generateMSCInstrumentation) {
		this.generateMSCInstrumentation = generateMSCInstrumentation;
	}

	public boolean generateWithVerboseOutput() {
		return generateWithVerboseOutput;
	}

	public void setGenerateWithVerboseOutput(boolean generateWithVerboseOutput) {
		this.generateWithVerboseOutput = generateWithVerboseOutput;
	}

	public List<String> getInputModelURIs() {
		return inputModelURIs;
	}

	public String getGeneratorModelPath() {
		return generatorModelPath;
	}

	public void setGeneratorModelPath(String generatorModelPath) {
		this.generatorModelPath = generatorModelPath;
	}

	public boolean isGenerateDocumentation() {
		return generateDocumentation;
	}

	public void setGenerateDocumentation(boolean generateDocumentation) {
		this.generateDocumentation = generateDocumentation;
	}

	public boolean isGenerateAsLibrary() {
		return generateAsLibrary;
	}

	public void setGenerateAsLibrary(boolean generateAsLibrary) {
		this.generateAsLibrary = generateAsLibrary;
	}

	public boolean isDebugMode() {
		return debugMode;
	}

	public void setDebugMode(boolean debugMode) {
		this.debugMode = debugMode;
	}

}
