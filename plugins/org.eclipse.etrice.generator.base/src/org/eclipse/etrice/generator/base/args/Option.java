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
 * Describes an option that takes a value of the passed type.
 * Options are immutable.
 * 
 * @param T the type of the values for this option
 */
public class Option<T> {
	
	private final Class<T> type;
	private final String name;
	private final String argumentName;
	private final String group;
	private final String description;
	private final T defaultValue;
	
	/**
	 * Creates a new option.
	 * 
	 * @param type the type of the values for this option
	 * @param name the name of this option
	 * @param parameterName the name of the parameter of this option
	 * @param description a description for this option
	 * @param defaultValue a default value for this option
	 */
	public Option(Class<T> type, String group, String name, String argumentName, String description, T defaultValue) {
		this.type = type;
		this.group = group;
		this.name = name;
		this.argumentName = argumentName;
		this.description = description;
		this.defaultValue = defaultValue;
	}
	
	/**
	 * Returns the type of the values for this option.
	 * 
	 * @return the type
	 */
	public final Class<T> getType() {
		return type;
	}
	
	/**
	 * Returns the group that this option is associated to.
	 * 
	 * @return the group name
	 */
	public final String getGroup() {
		return group;
	}
	
	/**
	 * Returns the name of this option.
	 * Its name uniquely identifies an option.
	 * 
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Returns the argument name of this option.
	 * 
	 * @return the argument name
	 */
	public final String getArgumentName() {
		return argumentName;
	}
	
	/**
	 * Returns a description of this option.
	 * 
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}
	
	/**
	 * Returns the default value for this option.
	 * 
	 * @return the default value
	 */
	public final T getDefaultValue() {
		return defaultValue;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
