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

import java.util.Arrays;
import java.util.List;

import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.args.Options;
import org.eclipse.etrice.generator.base.args.StringArrayOption;

import com.google.inject.ImplementedBy;

/**
 * A command line parser provides methods to parse command line arguments.
 */
@ImplementedBy(CommandLineParser.class)
public interface ICommandLineParser {
	
	/**
	 * Parses the specified command line arguments using the passed options.
	 * 
	 * @param options the options
	 * @param defaultOption the option for arguments without option identifier
	 * @param args the command line arguments
	 */
	Arguments parseArgs(Options options, StringArrayOption defaultOption, List<String> args) throws CommandLineParseException;
	
	
	/**
	 * Parses the specified command line arguments using the passed options.
	 * 
	 * @param options the options
	 * @param defaultOption the option to store arguments without identifier
	 * @param args the command line arguments
	 */
	default Arguments parseArgs(Options options, StringArrayOption defaultOption, String[] args) throws CommandLineParseException {
		return parseArgs(options, defaultOption, Arrays.asList(args));
	}
}
