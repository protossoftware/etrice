/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

/**
 * An interface for a simple file filter based on path strings
 * 
 * @author Henrik Rentz-Reichert
 */
public interface IFileFilter {
	/**
	 * @param fname a file name (or path)
	 * @return <code>true</code> if the fname is accepted
	 */
	boolean accept(String fname);
}