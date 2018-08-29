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

package org.eclipse.etrice.generator.java.setup;

import java.util.List;

import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.Option;

public class GeneratorOptions extends AbstractGeneratorOptions {
	
	public static final BooleanOption GEN_PERSIST = new BooleanOption(
			"persistable",
			"generatePersistenceInterface",
			"if specified make actor classes persistable",
			false);
	
	public static final BooleanOption GEN_STORE_DATA_OBJ = new BooleanOption(
			"storeDataObj",
			"generateStoreDataObj",
			"if specified equip actor classes with store/restore using POJOs",
			false);
	
	@Override
	public void configure(List<Option<?>> options) {
		super.configure(options);
		
		options.add(GEN_PERSIST);
		options.add(GEN_STORE_DATA_OBJ);
	}
}
