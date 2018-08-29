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

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.Options;

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
	public Arguments parseArgs(Options options, List<String> args) throws CommandLineParseException {
		Arguments parameters = new Arguments(options);
		List<String> nArgs = normalize(args);
		ListIterator<String> iterator = nArgs.listIterator();
		
		while(iterator.hasNext()) {
			String str = iterator.next().trim();
			if(str.startsWith("-")) {
				Option<?> opt = parseOption(options, str);
				Object value = parseValue(opt, iterator);
				parameters.set(opt.getName(), value);
			}
			else {
				parameters.getFiles().add(str);
			}
		}
		
		return parameters;
	}
	
	private List<String> normalize(List<String> args) throws CommandLineParseException {
		List<String> nArgs = new LinkedList<>(args);
		return nArgs;
	}
	
	private Option<?> parseOption(Options options, String str) throws CommandLineParseException {
		try {
			Option<?> opt = options.get(str.substring(1));
			return opt;
		}
		catch(IllegalArgumentException e) {
			throw new CommandLineParseException(e);
		}
	}
	
	private Object parseValue(Option<?> opt, ListIterator<String> iterator) throws CommandLineParseException {
		if(opt.getType().equals(Boolean.class)) {
			return true;
		}
		else if(iterator.hasNext()) {
			try {
				return opt.parseValue(iterator.next());
			}
			catch(IllegalArgumentException e) {
				throw new CommandLineParseException(e);
			}
			catch(UnsupportedOperationException e) {
				throw new CommandLineParseException(e);
			}
		}
		else {
			throw new CommandLineParseException("Expected one argument for option " + opt.getName());
		}
	}
}
