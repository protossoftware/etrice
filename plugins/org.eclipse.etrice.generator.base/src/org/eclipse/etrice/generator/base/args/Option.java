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
	private final String parameterName;
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
	public Option(Class<T> type, String name, String parameterName, String description, T defaultValue) {
		this.type = type;
		this.name = name;
		this.parameterName = parameterName;
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
	 * Returns the name of this option.
	 * Its name uniquely identifies an option.
	 * 
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	
	/**
	 * Returns the parameter name of this option.
	 * 
	 * @return the parameter name
	 */
	public final String getParameterName() {
		return parameterName;
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
	
	/**
	 * Checks whether the passed value is assignable to this option.
	 * 
	 * @param value the value to be checked
	 * @return whether the value is assignable to this option
	 */
	public boolean checkValue(Object value) {
		return type.isInstance(value);
	}
	
	/**
	 * Parses a value for this option from the passed string.
	 * 
	 * @param str the string to be parsed
	 * @return the parsed value
	 */
	public T parseValue(String str) throws IllegalArgumentException, UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
