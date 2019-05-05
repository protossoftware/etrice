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

package org.eclipse.etrice.generator.base.cli;

import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.Options;

import com.google.inject.ImplementedBy;

/**
 * Formats help messages for {@link Options}.
 */
@ImplementedBy(HelpFormatter.class)
public interface IHelpFormatter {
	
	/**
	 * Produces a help message for the passed options.
	 * 
	 * @param name the name of the application
	 * @param options the options
	 * @param defaultOption the option for arguments without option identifier
	 * @return the help message
	 */
	String getHelp(String name, Options options, Option<String[]> defaultOption);
	
}
