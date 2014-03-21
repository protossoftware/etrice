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
 * enumerations that are generated from multiple lists where each of
 * those list might be empty.
 * 
 * @author Henrik Rentz-Reichert
 */
public class IntelligentSeparator {

	private String firstSep;
	private String sep;
	private boolean firstUse = true;

	/**
	 * returns {@code firstSep} on the first call to {@link #toString()}.
	 * The following times it return {@code sep}.
	 * 
	 * @param firstSep the first separator string to be used
	 * @param sep the separator string to be used
	 */
	public IntelligentSeparator(String firstSep, String sep) {
		this.firstSep = firstSep;
		this.sep = sep;
	}

	/**
	 * @param sep the separator string to be used
	 */
	public IntelligentSeparator(String sep) {
		this("", sep);
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
			return firstSep;
		}
		else
			return sep;
	}
}
