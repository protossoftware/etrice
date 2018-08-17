/*******************************************************************************
 * Copyright (c) 2012 Juergen Haug
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class ConfigStandaloneSetup extends ConfigStandaloneSetupGenerated {

	public static void doSetup() {
		new ConfigStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
