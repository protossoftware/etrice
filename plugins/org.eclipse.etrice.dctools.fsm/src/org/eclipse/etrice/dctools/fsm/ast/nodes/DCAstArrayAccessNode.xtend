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

import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierBracketNode

class DCAstArrayAccessNode extends DCAstIdentifierBracketNode {
	
	new(DCAstNode parent, DCAstIdentifierNode id, DCAstWhitespaceNode ws, DCAstBracketNode bracket) {
		super(parent, id, ws, bracket)
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstArrayAccessNode '" + id + ws + bracket + "'" + linkedObjectText)
	}
	
}