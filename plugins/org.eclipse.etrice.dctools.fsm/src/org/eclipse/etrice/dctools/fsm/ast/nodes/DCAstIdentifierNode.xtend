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

import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.etrice.dctools.fsm.ast.internal.DCTextToken

@Accessors
class DCAstIdentifierNode extends DCAstNode {
	
	String identifier
	DCTextToken token
	
	new(DCAstNode parent, String identifier, DCTextToken token) {
		super(parent, 1)
		this.identifier = identifier
		this.token = token
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstIdentifierNode '" + identifier + "'" + linkedObjectText)
	}
	
}