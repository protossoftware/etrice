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

import org.eclipse.etrice.core.genmodel.fsm.ILogger;


/**
 * An ILineOutputLogger will send its output to the specified {@link ILogger} if one is set.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public interface ILineOutputLogger extends ILogger {

	/**
	 * @param lo a line output to be used by the logger
	 */
	void setOutput(ILineOutput lo);
}
