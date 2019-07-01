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
 *******************************************************************************/

package org.eclipse.etrice.generator.contractmonitor.setup;

import java.util.List;

import org.eclipse.etrice.generator.base.AbstractGeneratorOptions;
import org.eclipse.etrice.generator.base.args.Option;
import org.eclipse.etrice.generator.base.args.StringOption;

public class MonitorGeneratorOptions extends AbstractGeneratorOptions {

	public static final String GROUP_CONTRACT_MONITOR = "eTrice Contract Monitior";
	
	public static final StringOption TARGET_LANG = new StringOption(
			GROUP_CONTRACT_MONITOR,
			"targetLang",
			"targetLang",
			"specifies the target language to be used for contract monitors [java, c, cpp]",
			"c");
	
	@Override
	public void configure(List<Option<?>> options) {
		super.configure(options);
		
		options.add(TARGET_LANG);
	}
}
