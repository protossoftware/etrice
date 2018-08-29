/*******************************************************************************
* Copyright (c) 2011 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Henrik Rentz-Reichert (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.io;

import com.google.inject.ImplementedBy;

/**
 * A simple interface for output with just a {@link #println(String)} method.
 * 
 * @author Henrik Rentz-Reichert
 */
@ImplementedBy(LineOutput.class)
public interface ILineOutput {
	
	/**
	 * @param txt the text to output
	 */
	void println(String txt);
}
