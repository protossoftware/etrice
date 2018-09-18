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

import org.eclipse.etrice.generator.base.args.Arguments;

public class AbstractGeneratorOptionsHelper {

	public boolean isGenerateAsLibrary(Arguments args) {
		return args.get(AbstractGeneratorOptions.LIB);
	}
	
	public boolean isGenerateMSCInstrumentation(Arguments args) {
		return args.get(AbstractGeneratorOptions.MSC_INSTR);
	}
	
	public boolean isGenerateDataInstrumentation(Arguments args) {
		return args.get(AbstractGeneratorOptions.DATA_INSTR);
	}
	
	public boolean isNoTranslation(Arguments args) {
		return args.get(AbstractGeneratorOptions.NOTRANSLATE);
	}
	
	public String getMainMethodName(Arguments args) {
		return args.get(AbstractGeneratorOptions.MAIN_NAME);
	}
	
	public String getGeneratorModelPath(Arguments args) {
		return args.get(AbstractGeneratorOptions.SAVE_GEN_MODEL);
	}
	
	public boolean isGenerateWithVerboseOutput(Arguments args) {
		return args.get(AbstractGeneratorOptions.VERBOSE_RT);
	}
}
