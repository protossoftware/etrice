/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.dctools.fsm.ast.nodes

import org.eclipse.etrice.dctools.fsm.ast.tokens.DCTextToken
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class DCAstOtherNode extends DCAstTextNode {
	
	String text
	DCTextToken token
	
	new(DCAstNode parent, String text, DCTextToken token) {
		super(parent, 1, token.begin, token.begin+token.length)
		this.text = text
		this.token = token
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstOtherNode '" + text + "' " + token.token.kind)
	}
}