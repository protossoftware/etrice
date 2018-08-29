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

import com.google.inject.ImplementedBy;

/**
 * An ILineOutputLogger will send its output to the specified {@link ILineOutput} if one is set.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
@ImplementedBy(Logger.class)
public interface ILineOutputLogger extends ILogger {

	/**
	 * @param lo a line output to be used by the logger
	 */
	void setOutput(ILineOutput lo);
}
