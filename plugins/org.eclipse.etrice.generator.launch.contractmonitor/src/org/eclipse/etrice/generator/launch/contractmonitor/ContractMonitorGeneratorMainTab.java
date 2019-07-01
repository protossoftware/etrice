/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Christian Hilden (initial contribution)
 * 
 *******************************************************************************/package org.eclipse.etrice.generator.launch.contractmonitor;

import org.eclipse.core.resources.IResource;
import org.eclipse.etrice.generator.launch.GeneratorMainTab;

public class ContractMonitorGeneratorMainTab extends GeneratorMainTab {

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.generator.launch.GeneratorMainTab#isValidModelFile(org.eclipse.core.resources.IResource)
	 */
	@Override
	protected boolean isValidModelFile(IResource resource) {
		return resource.getName().endsWith(".room")
				|| resource.getName().endsWith(".config")
				|| resource.getName().endsWith(".etphys")
				|| resource.getName().endsWith(".etmap");
	}

}
