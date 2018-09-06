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

package org.eclipse.etrice.generator.base.cli;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.Options;
import org.eclipse.etrice.generator.base.args.StringListOption;

/**
 * Simple implementation of a command line parser.
 * Options must start with a prefixed single dash and parameters must be separated with a space.
 * Everything remaining is interpreted as input files.
 * <br>
 * Example:
 *  -genDir myGenDir MyFile.txt
 * 
 */
public class CommandLineParser implements ICommandLineParser {
	
	public CommandLineParser() {
	}
	
	@Override
	public Arguments parseArgs(Options options, StringListOption defaultOption, List<String> args) throws CommandLineParseException {
		Arguments parsedArgs = new Arguments(options);
		List<String> nArgs = normalize(args);
		ListIterator<String> iterator = nArgs.listIterator();
		ArrayList<String> defaultArgs = new ArrayList<>();
		
		while(iterator.hasNext()) {
			String str = iterator.next().trim();
			if(str.startsWith("-")) {
				Option<?> opt = parseOption(options, str);
				Object value = parseValue(opt, iterator);
				parsedArgs.set(opt.getName(), value);
			}
			else {
				defaultArgs.add(str);
			}
		}
		
		if(!defaultArgs.isEmpty()) {
			parsedArgs.set(defaultOption, defaultArgs);
		}
		
		return parsedArgs;
	}
	
	private List<String> normalize(List<String> args) throws CommandLineParseException {
		List<String> nArgs = new LinkedList<>(args);
		return nArgs;
	}
	
	private Option<?> parseOption(Options options, String str) throws CommandLineParseException {
		try {
			String optionName = str.substring(1);
			Option<?> opt = options.get(optionName);
			return opt;
		}
		catch(IllegalArgumentException e) {
			throw new CommandLineParseException("Option " + str + " not recognized");
		}
	}
	
	private Object parseValue(Option<?> opt, ListIterator<String> iterator) throws CommandLineParseException {
		Class<?> type = opt.getType();
		
		if(type == Boolean.class) {
			return true;
		}
		
		if(iterator.hasNext()) {
			String str = iterator.next();
			
			if(type == String.class) {
				return str;
			}
			else if(type.isEnum()) {
				return parseEnum(opt, str);
			}
			else {
				throw new CommandLineParseException("Option " + opt.getName() + " is not supported on the command line");
			}
			
		}
		else {
			throw new CommandLineParseException("Expected one argument for option " + opt.getName());
		}
	}
	
	private Object parseEnum(Option<?> opt, String str) {
		Object[] constants = opt.getType().getEnumConstants();
		
		for(Object c: constants) {
			if(c.toString().equalsIgnoreCase(str)) {
				return c;
			}
		}
		
		throw new CommandLineParseException("Argument " + str + " not allowed for option " + opt.getName());
	}
}
