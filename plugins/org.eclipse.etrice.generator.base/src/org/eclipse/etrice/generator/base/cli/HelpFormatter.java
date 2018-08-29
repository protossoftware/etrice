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

import java.util.Formatter;

import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.Options;

/**
 * Simple implementation for command line help formatting.
 */
public class HelpFormatter implements IHelpFormatter {
	
	public HelpFormatter() {
	}
	
	@Override
	public String getHelp(Options options) {
		try(Formatter formatter = new Formatter()) {
			formatter.format("Usage: [options] files...%n");
			formatter.format("Options:%n");
			for(Option<?> opt: options) {
				String optStr = "-" + opt.getName();
				if(!opt.getType().equals(Boolean.class)) {
					optStr += " <" + opt.getParameterName() + ">";
				}
				formatter.format(" %-30s %s%n", optStr, opt.getDescription());
			}
			return formatter.toString();
		}
	}
	
}
