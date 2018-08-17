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
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package my.etrice.generator.launch;

import org.eclipse.etrice.generator.launch.java.JavaGeneratorConfigTab;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class DerivedGeneratorConfigTab extends JavaGeneratorConfigTab {

	/**
	 * EXAMPLE: override tab name
	 * 
	 * @see org.eclipse.etrice.generator.launch.java.JavaGeneratorConfigTab#getName()
	 */
	public String getName() {
		return "Derived Java Generator";
	}

}
