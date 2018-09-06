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
 * Describes an option that takes an {@link Enum} value.
 */
public class EnumOption<T extends Enum<?>> extends Option<T> {
	
	/**
	 * @see Option#Option
	 */
	public EnumOption(Class<T> enumClass, String group, String name, String argumentName, String description, T defaultValue) {
		super(enumClass, group, name, argumentName, description, defaultValue);
	}
	
}
