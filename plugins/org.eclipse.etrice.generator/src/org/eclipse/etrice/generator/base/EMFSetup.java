/*******************************************************************************
* Copyright (c) 05.09.2018 protos software gmbh (http://www.protos.de).
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

import org.eclipse.etrice.core.ConfigStandaloneSetup;
import org.eclipse.etrice.core.RoomStandaloneSetup;
import org.eclipse.etrice.core.etmap.ETMapStandaloneSetup;
import org.eclipse.etrice.core.etphys.ETPhysStandaloneSetup;
import org.eclipse.etrice.core.genmodel.SetupGenmodel;
import org.eclipse.etrice.generator.base.io.IGeneratorEMFSetup;

public class EMFSetup implements IGeneratorEMFSetup {

	@Override
	public void doEMFRegistration() {
		RoomStandaloneSetup.doSetup();
		SetupGenmodel.doSetup();
		ConfigStandaloneSetup.doSetup();
		ETMapStandaloneSetup.doSetup();
		ETPhysStandaloneSetup.doSetup();
	}

}
