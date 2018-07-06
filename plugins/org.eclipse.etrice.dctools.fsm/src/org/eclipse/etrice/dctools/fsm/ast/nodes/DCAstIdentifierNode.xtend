/*******************************************************************************
 * Copyright (c) 2018 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.dctools.fsm.ast.nodes

import org.eclipse.etrice.dctools.fsm.ast.tokens.DCTextToken
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class DCAstIdentifierNode extends DCAstTextNode {
	
	String id
	DCTextToken token
	
	new(DCAstNode parent, String id, DCTextToken token) {
		super(parent, 1, token.begin, token.begin+token.length)
		this.id = id
		this.token = token
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstIdentifierNode '" + id + "'" + linkedObjectText)
	}
	
	override getText() { id }
	
}