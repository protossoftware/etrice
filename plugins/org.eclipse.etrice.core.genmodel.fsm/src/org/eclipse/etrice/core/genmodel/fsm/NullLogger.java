/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class NullLogger implements ILogger {

	private int errors = 0;
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.base.ILogger#logInfo(java.lang.String)
	 */
	@Override
	public void logInfo(String text) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.core.genmodel.base.ILogger#logError(java.lang.String, org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public void logError(String text, EObject obj) {
		++errors;
	}

	@Override
	public void logError(String text) {
		logError(text, null);
	}

	@Override
	public boolean hasErrors() {
		return errors!=0;
	}

}
