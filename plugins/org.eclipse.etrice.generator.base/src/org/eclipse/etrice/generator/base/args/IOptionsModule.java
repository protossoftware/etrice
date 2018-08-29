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

package org.eclipse.etrice.generator.base.args;

import java.util.List;

/**
 * Describes options that can be used to create a new {@link Options} set.
 */
public interface IOptionsModule {
	
	/**
	 * Configures options on the passed collection.
	 * 
	 * @param options the collection of options to be configured
	 */
	void configure(List<Option<?>> options);
	
}
