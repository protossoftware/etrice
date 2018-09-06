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

import java.util.HashMap;

/**
 * Encapsulates a set of arguments.
 */
public class Arguments {
	
	private Options options;
	private HashMap<String, Object> option2Arg;
	
	/**
	 * Creates a new set of arguments initialized to their default values.
	 * 
	 * @param options the options to create the arguments from
	 */
	public Arguments(Options options) {
		this.options = options;
		option2Arg = new HashMap<>();
		
		for(Option<?> option: options) {
			option2Arg.put(option.getName(), option.getDefaultValue());
		}
	}
	
	/**
	 * Queries an argument by its name.
	 * 
	 * @param name the name of the option
	 * @return the argument
	 */
	public Object get(String name) throws IllegalArgumentException {
		Object value = option2Arg.get(name);
		if(value == null) {
			throw new IllegalArgumentException("option " + name + " not recognized");
		}
		return value;
	}
	
	/**
	 * Queries an argument.
	 * 
	 * @param option the option of the argument
	 * @return the argument
	 */
	public <T> T get(Option<T> option) throws IllegalArgumentException {
		return option.getType().cast(get(option.getName()));
	}
	
	/**
	 * Sets an argument to the passed value.
	 * 
	 * @param name the name of the option
	 * @param value the value to be set
	 */
	public void set(String name, Object value) throws IllegalArgumentException {
		Option<?> opt = options.get(name);
		if(!opt.getType().isInstance(value)) {
			throw new IllegalArgumentException("value " + value.toString() + " is not assignable to Option " + opt.toString());
		}
		option2Arg.put(name, value);
	}
	
	/**
	 * Sets an argument to the passed value.
	 * 
	 * @param option the option
	 * @param value the value to be set
	 */
	public <T> void set(Option<T> option, T value) throws IllegalArgumentException {
		set(option.getName(), value);
	}
	
	/**
	 * Returns the options for the arguments.
	 * 
	 * @return options the options
	 */
	public Options getOptions() {
		return options;
	}
	
	@Override
	public String toString() {
		return option2Arg.toString();
	}
}
