/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.base;

import org.eclipse.emf.ecore.EObject;

/**
 * A simple logger interface for error messages during model validation and code generation.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public interface ILogger {

	/**
	 * @param text informational text
	 */
	void logInfo(String text);
	
	/**
	 * @param text error text
	 * @param obj {@link org.eclipse.emf.ecore.EObject EObject} (if available) where the error occurred
	 */
	void logError(String text, EObject obj);
}
