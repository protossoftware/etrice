/*******************************************************************************
* Copyright (c) 2010 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.logging;

import com.google.inject.ImplementedBy;

/**
 * A simple logger interface for error messages during model validation and code generation.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
@ImplementedBy(Logger.class)
public interface ILogger {
	
	/**
	 * @param text debug text
	 */
	void logDebug(String text);
	
	/**
	 * @param text informational text
	 */
	void logInfo(String text);
	
	/**
	 * @param text warning text
	 */
	void logWarning(String text);
	
	/**
	 * @param text error text
	 */
	void logError(String text);
	
	/**
	 * @return the loglevel
	 */
	Loglevel getLoglevel();
	
}
