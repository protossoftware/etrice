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

package org.eclipse.etrice.generator.doc.gen;

import org.eclipse.etrice.generator.base.GlobalGeneratorSettings;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class GlobalSettings extends GlobalGeneratorSettings {

	private boolean generateInstanceDiagram = false;

	public boolean isGenerateInstanceDiagram() {
		return generateInstanceDiagram;
	}

	public void setGenerateInstanceDiagram(boolean generateInstanceDiagram) {
		this.generateInstanceDiagram = generateInstanceDiagram;
	}
}
