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

package org.eclipse.etrice.generator.base.logging;

import org.eclipse.etrice.generator.base.io.ILineOutput;
import org.eclipse.etrice.generator.base.io.LineOutput;

/**
 * A simple logger class implementing the
 * {@link ILineOutputLogger ILineOutputLogger}
 * interface. If no ILineOutputLogger is set then output is sent to
 * {@link java.lang.System#out System.out}.
 * 
 * @author Henrik Rentz-Reichert
 * 
 */
public class Logger implements ILineOutputLogger, ILineOutput {

	private static final String DEBUG_PREFIX =		"[DEBUG]   ";
	private static final String INFO_PREFIX =		"[INFO]    ";
	private static final String WARNING_PREFIX =	"[WARNING] ";
	private static final String ERROR_PREFIX =		"[ERROR]   ";
	
	
	private Loglevel loglevel;
	private ILineOutput output;
	
	public Logger() {
		this(Loglevel.WARNING, new LineOutput());
	}
	
	public Logger(Loglevel loglevel) {
		this(loglevel, new LineOutput());
	}
	
	public Logger(ILineOutput out) {
		this(Loglevel.WARNING, out);
	}
	
	public Logger(Loglevel loglevel, ILineOutput out) {
		setLoglevel(loglevel);
		setOutput(out);
	}
	
	@Override
	public void logDebug(String text) {
		if(Loglevel.DEBUG.compareTo(loglevel) >= 0) {
			println(DEBUG_PREFIX + text);
		}
	}
	
	@Override
	public void logInfo(String text) {
		if(Loglevel.INFO.compareTo(loglevel) >= 0) {
			println(INFO_PREFIX + text);
		}
	}
	
	@Override
	public void logWarning(String text) {
		if(Loglevel.WARNING.compareTo(loglevel) >= 0) {
			println(WARNING_PREFIX + text);
		}
	}

	@Override
	public void logError(String text) {
		if(Loglevel.ERROR.compareTo(loglevel) >= 0) {
			println(ERROR_PREFIX + text);
		}
	}

	@Override
	public Loglevel getLoglevel() {
		return loglevel;
	}
	
	@Override
	public void setLoglevel(Loglevel loglevel) {
		this.loglevel = loglevel;
	}
	
	@Override
	public void setOutput(ILineOutput out) {
		output = out;
	}

	@Override
	public void println(String txt) {
		output.println(txt);
	}
	
}
