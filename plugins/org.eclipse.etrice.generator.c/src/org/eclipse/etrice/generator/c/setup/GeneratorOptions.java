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

package org.eclipse.etrice.generator.c.setup;

import java.util.List;

import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.Option;

public class GeneratorOptions extends AbstractGeneratorOptions {
	
	public static final BooleanOption CPP_FILE_EXTENSIONS = new BooleanOption(
			GROUP_ETRICE,
			"cppfileextensions",
			"cppFileExtensions",
			"if specified the file extensions for C source and header files will be *.cpp and *.hpp resp.'",
			false);
	
	@Override
	public void configure(List<Option<?>> options) {
		super.configure(options);
		
		options.add(CPP_FILE_EXTENSIONS);
	}

}
