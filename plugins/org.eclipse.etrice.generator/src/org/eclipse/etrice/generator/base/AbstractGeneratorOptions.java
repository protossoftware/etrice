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

package org.eclipse.etrice.generator.base;

import java.util.List;

import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.StringOption;
import org.eclipse.etrice.generator.base.setup.GeneratorBaseOptions;

public class AbstractGeneratorOptions extends GeneratorBaseOptions {
	
	public static final String GROUP_ETRICE = "eTrice";
	
	public static final BooleanOption LIB = new BooleanOption(
			GROUP_ETRICE,
			"lib",
			"generateAsLibrary",
			"if specified all classes are generated, not only instanciated ones",
			false);
	
	public static final StringOption SAVE_GEN_MODEL = new StringOption(
			GROUP_ETRICE,
			"saveGenModel",
			"genmodel path",
			"if specified the generator model will be saved to this location",
			"");
	
	public static final StringOption MAIN_NAME = new StringOption(
			GROUP_ETRICE,
			"mainName",
			"name",
			"if specified the generated main method will be named as stated",
			"main");
	
	public static final BooleanOption MSC_INSTR = new BooleanOption(
			GROUP_ETRICE,
			"msc_instr",
			"generateMSCInstrumentation",
			"generate instrumentation for MSC generation",
			false);
	
	public static final BooleanOption DATA_INSTR = new BooleanOption(
			GROUP_ETRICE,
			"data_instr",
			"generateDataInstrumentation",
			"generate instrumentation for data logging",
			false);
	
	public static final BooleanOption VERBOSE_RT = new BooleanOption(
			GROUP_ETRICE,
			"gen_as_verbose",
			"generateWithVerboseOutput",
			"generate instrumentation for verbose console output",
			false);
	
	public static final BooleanOption NOTRANSLATE = new BooleanOption(
			GROUP_ETRICE,
			"notranslate",
			"noTranslation",
			"if specified the detail codes won't be translated",
			false);
	
	@Override
	public void configure(List<Option<?>> options) {
		super.configure(options);
		
		options.add(LIB);
		options.add(SAVE_GEN_MODEL);
		options.add(MAIN_NAME);
		options.add(MSC_INSTR);
		options.add(DATA_INSTR);
		options.add(VERBOSE_RT);
		options.add(NOTRANSLATE);
	}
}
