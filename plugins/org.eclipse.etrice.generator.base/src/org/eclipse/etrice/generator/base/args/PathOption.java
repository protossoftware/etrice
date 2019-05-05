/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.generator.base.args;

public class PathOption extends Option<String[]> {
	
	/**
	 * @see Option#Option
	 */
	public PathOption(String group, String name, String argumentName, String description, String[] defaultValue) {
		super(String[].class, group, name, argumentName, description, defaultValue);
	}

}
