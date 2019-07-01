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

package org.eclipse.etrice.generator.contractmonitor.setup

import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class GeneratorSettings {
	
	// TODO set at runtime
	boolean forwardInvalidMessages = true
	
	String toConjugatedPortName = "toConjugated"
	String toUnconjugatedPortName = "toUnconjugated"
	
}
