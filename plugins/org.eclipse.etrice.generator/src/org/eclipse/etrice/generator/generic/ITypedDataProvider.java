/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.generic;

import org.eclipse.etrice.core.room.VarDecl;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public interface ITypedDataProvider {

	/**
	 * return three strings used by the generator
	 * 
	 * @param data the variable declaration
	 * @return an array of three strings
	 * <ol>
	 *  <li>the string that performs the cast from generic_data to the correct type and assigns it to a new variable</li>
	 *  <li>the data as it appears in a method call</li>
	 *  <li>the data as it is used in the method declaration</li>
	 *  </ol>
	 */
	String[] generateArglistAndTypedData(VarDecl data);
}
