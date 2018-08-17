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

import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class DCAstWhitespaceNode extends DCAstTextNode {
	
	String text
	
	new(DCAstNode parent, int readTokens, int pos, String text) {
		super(parent, readTokens, pos, pos+text.length)
		this.text = text
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstWhitespaceNode '" + text + "'")
	}
	
	override getText() { text }
}