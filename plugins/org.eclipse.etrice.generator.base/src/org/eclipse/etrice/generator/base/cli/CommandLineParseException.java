/*******************************************************************************
* Copyright (c) 2018 protos software gmbh (http://www.protos.de).
* All rights reserved.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
*
* CONTRIBUTORS:
*           Jan Belle (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.cli;

/**
 * An exception that indicates a command line parsing error.
 */
public class CommandLineParseException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public CommandLineParseException(String message) {
		super(message);
	}
	
	public CommandLineParseException(Throwable cause) {
		super(cause);
	}
	
	public CommandLineParseException(String message, Throwable cause) {
		super(message, cause);
	}
}
