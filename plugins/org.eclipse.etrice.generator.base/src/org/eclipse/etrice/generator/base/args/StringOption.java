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
 * Describes an option that takes a {@link String} value.
 */
public class StringOption extends Option<String> {
	
	/**
	 * @see Option#Option
	 */
	public StringOption(String name, String parameterName, String description, String defaultValue) {
		super(String.class, name, parameterName, description, defaultValue);
	}
	
	@Override
	public String parseValue(String str) {
		return str;
	}
}
