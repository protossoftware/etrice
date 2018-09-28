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

package org.eclipse.etrice.core.genmodel.builder;

import org.eclipse.etrice.core.genmodel.fsm.ExtendedFsmGenBuilderFactory;
import org.eclipse.etrice.core.genmodel.fsm.IDiagnostician;
import org.eclipse.etrice.generator.base.logging.ILogger;

import com.google.inject.Inject;

public class GeneratorModelBuilderFactory {
	
	@Inject
	private ExtendedFsmGenBuilderFactory fsmGenBuilderFactory;
	
	public GeneratorModelBuilder create(ILogger logger, IDiagnostician diagnostician) {
		return new GeneratorModelBuilder(fsmGenBuilderFactory, logger, diagnostician);
	}
	
}
