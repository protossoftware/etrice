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

import org.eclipse.etrice.generator.base.args.Arguments;
import org.eclipse.etrice.generator.base.logging.Loglevel;

/**
 * Helper class for {@link GeneratorBaseOptions}.
 */
public class GeneratorBaseOptionsHelper {
	
	public boolean isHelp(Arguments args) {
		return args.get(GeneratorBaseOptions.HELP);
	}
	
	public boolean isIncremental(Arguments args) {
		return args.get(GeneratorBaseOptions.GEN_INCREMENTAL);
	}
	
	public String getGenDir(Arguments args) {
		return args.get(GeneratorBaseOptions.GEN_DIR);
	}
	
	public String getGenInfoDir(Arguments args) {
		return args.get(GeneratorBaseOptions.GEN_INFO_DIR);
	}
	
	public Loglevel getLoglevel(Arguments args) {
		return args.get(GeneratorBaseOptions.LOGLEVEL);
	}
}
