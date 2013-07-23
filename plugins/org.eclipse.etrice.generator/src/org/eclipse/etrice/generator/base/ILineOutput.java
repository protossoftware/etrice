/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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
 * A simple interface for output with just a {@link #println(String)} method.
 * @author Henrik Rentz-Reichert
 */
public interface ILineOutput {
	
	/**
	 * @param txt the text to output
	 */
	void println(String txt);
}
