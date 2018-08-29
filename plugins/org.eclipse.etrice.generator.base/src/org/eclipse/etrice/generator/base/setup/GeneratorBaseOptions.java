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

package org.eclipse.etrice.generator.base.setup;

import java.util.List;

import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.EnumOption;
import org.eclipse.etrice.generator.base.args.IOptionsModule;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.StringOption;
import org.eclipse.etrice.generator.base.logging.Loglevel;

/**
 * Configures standard options for generators.
 */
public class GeneratorBaseOptions implements IOptionsModule {
	
	public static final BooleanOption HELP = new BooleanOption(
			"help",
			"isHelp",
			"display this help text",
			false);
	
	public static final BooleanOption GEN_INCREMENTAL = new BooleanOption(
			"inc",
			"isInc",
			"if specified the generation is incremental",
			false);
	
	public static final StringOption GEN_DIR = new StringOption(
			"genDir",
			"directory",
			"the directory for generated files",
			"src-gen");
	
	public static final StringOption GEN_INFO_DIR = new StringOption(
			"genInfoDir",
			"directory",
			"the directory for generated info files",
			"src-gen-info");
	
	public static final EnumOption<Loglevel> LOGLEVEL = new EnumOption<>(
			Loglevel.class,
			"loglevel",
			"level",
			"the loglevel for the logger [all, debug, info, warning, error, off]",
			Loglevel.INFO);
	
	@Override
	public void configure(List<Option<?>> options) {
		options.add(HELP);
		options.add(GEN_INCREMENTAL);
		options.add(GEN_DIR);
		options.add(GEN_INFO_DIR);
		options.add(LOGLEVEL);
	}
	
}
