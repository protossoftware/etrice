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

package org.eclipse.etrice.generator.base.args;

/**
 * Describes an option that takes an {@link Integer} value.
 */
public class IntegerOption extends Option<Integer> {

	/**
	 * @see Option#Option
	 */
	public IntegerOption(String name, String parameterName, String description, int defaultValue) {
		super(Integer.class, name, parameterName, description, defaultValue);
	}

	@Override
	public Integer parseValue(String str) throws IllegalArgumentException {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
}
