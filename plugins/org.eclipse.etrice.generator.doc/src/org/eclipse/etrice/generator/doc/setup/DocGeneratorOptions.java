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

package org.eclipse.etrice.generator.doc.setup;

import java.util.List;

import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.args.BooleanOption;
import org.eclipse.etrice.generator.base.args.Option;

public class DocGeneratorOptions extends AbstractGeneratorOptions {
	
	public static final String GROUP_ETRICE_DOC = "eTrice Documentation";
	
	public static final BooleanOption GEN_INST_DIAG = new BooleanOption(
			GROUP_ETRICE_DOC,
			"genInstDiag",
			"generateInstanceDiagram",
			"if specified then an instance diagram is created for each subsystem",
			false);
	
	@Override
	public void configure(List<Option<?>> options) {
		super.configure(options);
		
		options.add(GEN_INST_DIAG);
	}
}
