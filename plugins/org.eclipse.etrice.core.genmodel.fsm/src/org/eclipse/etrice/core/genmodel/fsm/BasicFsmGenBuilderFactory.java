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

import org.eclipse.etrice.core.fsm.util.FSMHelpers;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class BasicFsmGenBuilderFactory {
	
	@Inject
	protected Provider<FSMHelpers> fsmHelperProvider;
	
	public BasicFsmGenBuilder create() {
		return new BasicFsmGenBuilder(fsmHelperProvider.get());
	}
}
