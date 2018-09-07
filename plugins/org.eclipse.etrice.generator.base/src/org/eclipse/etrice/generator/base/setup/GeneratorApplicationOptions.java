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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.EnumOption;
import org.eclipse.etrice.generator.base.args.IOptionModule;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.StringListOption;
import org.eclipse.etrice.generator.base.args.StringOption;
import org.eclipse.etrice.generator.base.logging.Loglevel;

/**
 * Configures the options of the generator application.
 */
public class GeneratorApplicationOptions implements IOptionModule {

	public static final String GROUP_APPLICATION = "application";
	
	public static final StringListOption FILES = new StringListOption(
			GROUP_APPLICATION,
			"files",
			"input files",
			"input files for the generator",
			new ArrayList<>());
	
	public static final BooleanOption HELP = new BooleanOption(
			GROUP_APPLICATION,
			"help",
			"isHelp",
			"display this help text",
			false);
	
	@Deprecated
	public static final BooleanOption GEN_INCREMENTAL = new BooleanOption(
			GROUP_APPLICATION,
			"inc",
			"isInc",
			"if specified the generation is incremental (deprecated)",
			false);
	
	public static final StringOption GEN_DIR = new StringOption(
			GROUP_APPLICATION,
			"genDir",
			"directory",
			"the output directory for generated files",
			"src-gen");
	
	@Deprecated
	public static final StringOption GEN_INFO_DIR = new StringOption(
			GROUP_APPLICATION,
			"genInfoDir",
			"directory",
			"the directory for generated info files (deprecated)",
			"src-gen-info");
	
	public static final BooleanOption CLEAN = new BooleanOption(
			GROUP_APPLICATION,
			"clean",
			"isClean",
			"if specified obsolete files in the output directory are removed",
			false);
	
	public static final EnumOption<Loglevel> LOGLEVEL = new EnumOption<>(
			Loglevel.class,
			GROUP_APPLICATION,
			"loglevel",
			"level",
			"the loglevel for the logger [all, debug, info, warning, error, off]",
			Loglevel.INFO);
	
	@Override
	public void configure(List<Option<?>> options) {
		options.add(FILES);
		options.add(HELP);
		options.add(GEN_INCREMENTAL);
		options.add(GEN_DIR);
		options.add(GEN_INFO_DIR);
		options.add(CLEAN);
		options.add(LOGLEVEL);
	}

}
