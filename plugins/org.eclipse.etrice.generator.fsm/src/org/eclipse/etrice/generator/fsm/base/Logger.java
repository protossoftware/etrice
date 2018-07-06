/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.fsm.base;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * a simple logger class implementing the
 * {@link org.eclipse.etrice.generator.fsm.base.ILineOutputLogger ILineOutputLogger}
 * interface. If no ILineOutputLogger is set then output is sent to
 * {@link java.lang.System#out System.out}.
 * 
 * @author Henrik Rentz-Reichert
 * 
 */
public class Logger implements ILineOutputLogger {

	private int errors = 0;
	private ILineOutput output = null;
	
	@Override
	public boolean hasErrors() {
		return errors!=0;
	}

	public void logInfo(String text) {
		println("Info: " + text);
	}

	@Override
	public void logError(String text) {
		logError(text, null);
	}

	public void logError(String text, EObject obj) {
		++errors;
		if (obj == null)
			println("Error: " + text);
		else {
			// prefer location to toString()
			URI uri = EcoreUtil.getURI(obj);
			String objInfo = (uri != null && !obj.eIsProxy()) ? uri.toString() : obj.toString();
			println("Error: " + text + " " + objInfo);
		}
	}

	private void println(String txt) {
		if (output != null)
			output.println(txt);
		else
			System.out.println(txt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.etrice.generator.ILineOutputLogger#setOutput(org.eclipse.
	 * etrice.generator.ILineOutput)
	 */
	@Override
	public void setOutput(ILineOutput lo) {
		output = lo;
	}

}
