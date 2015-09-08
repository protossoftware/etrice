/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class GlobalGeneratorSettings {
	
	// all models from input
	val List<String> inputModelURIs = newArrayList
	
	// generation options
	boolean generateAsLibrary = false
	boolean generateMSCInstrumentation = false
	boolean generateDataInstrumentation = false
	boolean noTranslation = false
	
	// extra generators
	String generatorModelPath = null
	boolean generateDocumentation = false
	
	// generator logging
	boolean generateWithVerboseOutput = false
	boolean debugMode = false
	
}