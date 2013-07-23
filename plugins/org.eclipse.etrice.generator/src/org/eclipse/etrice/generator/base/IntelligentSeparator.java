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

/**
 * This class implements an intelligent separator for continued
 * enumerations that are generated from multiple list where each of
 * those list might be empty.
 * 
 * @author Henrik Rentz-Reichert
 */
public class IntelligentSeparator {

	private String sep;
	private boolean firstUse = true;

	/**
	 * @param sep the separator string to be used
	 */
	public IntelligentSeparator(String sep) {
		this.sep = sep;
	}

	/**
	 * reset the used state to unused
	 */
	public void reset() {
		firstUse = true;
	}

	/**
	 * @param sep the separator string to be used from now on
	 */
	public void setSep(String sep) {
		this.sep = sep;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (firstUse) {
			firstUse = false;
			return "";
		}
		else
			return sep;
	}
}
