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

package org.eclipse.etrice.core.genmodel.fsm;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class ExtendedFsmGenBuilderFactory extends BasicFsmGenBuilderFactory {
	
	@Inject
	private Provider<ICommonDataCalculator> commonDataCalculatorProvider;
	
	@Inject
	private Provider<TriggerExtensions> triggerExtensionsProvider;
	
	public ExtendedFsmGenBuilder create(IDiagnostician diagnostician) {
		return new ExtendedFsmGenBuilder(fsmHelperProvider.get(),
				commonDataCalculatorProvider.get(),
				triggerExtensionsProvider.get(),
				diagnostician);
	}
	
	public ExtendedFsmGenBuilder create() {
		return create(new NullDiagnostician());
	}
}
