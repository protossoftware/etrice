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

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Encapsulates an immutable set of options.
 */
public class Options implements Iterable<Option<?>>  {
	
	private LinkedHashMap<String, Option<?>> name2Option;
	
	/**
	 * Creates a new set of options that contains the passed options.
	 * 
	 * @param options the options
	 */
	public  Options(Option<?>... options) {
		init(Arrays.asList(options));
	}
	
	/**
	 * Creates a new set of options that contains the passed options.
	 * 
	 * @param options the options
	 */
	public Options(List<Option<?>> options) {
		init(options);
	}
	
	/**
	 * Creates a new set of options that contains the options configured by the passed module.
	 * 
	 * @param module the options module
	 */
	public Options(IOptionsModule module) {
		List<Option<?>> options = new LinkedList<>();
		module.configure(options);
		init(options);
	}
	
	/**
	 * Queries an option by its name.
	 * 
	 * @param name the name of the requested option
	 */
	public final Option<?> get(String name) throws IllegalArgumentException {
		Option<?> opt = name2Option.get(name);
		if(opt == null) {
			throw new IllegalArgumentException("Option " + name + " not recognized");
		}
		return opt;
	}
	
	@Override
	public final Iterator<Option<?>> iterator() {
		return Collections.unmodifiableCollection(name2Option.values()).iterator();
	}
	
	@Override
	public String toString() {
		return name2Option.values().toString();
	}
	
	private final void init(List<Option<?>> options) {
		name2Option = new LinkedHashMap<>(options.size());
		options.forEach(opt -> name2Option.put(opt.getName(), opt));
	}
}
