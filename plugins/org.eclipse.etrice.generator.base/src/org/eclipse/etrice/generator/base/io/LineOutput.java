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
*           Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
*
 *******************************************************************************/

package org.eclipse.etrice.generator.base.io;

import java.io.PrintStream;

/**
 * A line output that prints to a {@link PrintStream}
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class LineOutput implements ILineOutput {
	
	private PrintStream stream;
	
	/**
	 * Creates a new line output that prints to {@link System#out}
	 */
	public LineOutput() {
		this(System.out);
	}
	
	/**
	 * Creates a new line output that print to the passed stream.
	 * 
	 * @param stream the stream
	 */
	public LineOutput(PrintStream stream) {
		this.stream = stream;
	}
	
	@Override
	public void println(String txt) {
		stream.println(txt);
	}

}
