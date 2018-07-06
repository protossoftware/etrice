/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.internal

import org.eclipse.jface.text.rules.IWordDetector

class DCWordDetector implements IWordDetector {

	boolean includePreprocessDirectives
	
	new() {
		this(false)
	}
	
	new(boolean includePreprocessDirectives) {
		this.includePreprocessDirectives = includePreprocessDirectives
	}
	
	override boolean isWordStart(char c) {
		Character.isJavaIdentifierStart(c) || (includePreprocessDirectives && c === Character.valueOf('#').charValue) 
	}
	override boolean isWordPart(char c) {
		Character.isJavaIdentifierPart(c) 
	}	
}