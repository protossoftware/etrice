/*******************************************************************************
* Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.generator.base.logging;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class NullLogger implements ILogger {
	
	private boolean hasErrors = false;
	
	@Override
	public void logInfo(String text) {
	}

	@Override
	public void logError(String text) {
		hasErrors = true;
	}

	@Override
	public void logDebug(String text) {
	}

	@Override
	public void logWarning(String text) {
	}

	@Override
	public Loglevel getLoglevel() {
		return Loglevel.OFF;
	}

	public boolean hasErrors() {
		return hasErrors;
	}

}
