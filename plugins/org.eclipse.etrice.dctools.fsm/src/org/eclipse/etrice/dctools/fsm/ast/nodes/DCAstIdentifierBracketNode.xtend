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

abstract class DCAstIdentifierBracketNode extends DCAstNode {
	
	new(DCAstNode parent, DCAstIdentifierNode id, DCAstWhitespaceNode ws, DCAstBracketNode bracket) {
		super(parent, 0 /* consumed no tokens itself */)
		
		id.parent = this
		
		if (ws!==null) {
			ws.parent = this
		}
		
		bracket.parent = this
	}
	
	def DCAstIdentifierNode idNode() {
		children.head as DCAstIdentifierNode
	}
	
	def String id() {
		idNode.identifier
	}
	
	def String ws() {
		if (children.size==3) {
			(children.get(1) as DCAstWhitespaceNode).text
		}
		else {
			""
		}
	}
	
	def DCAstBracketNode bracketNode() {
		children.last as DCAstBracketNode
	}
	
	def String bracket() {
		bracketNode.toString
	}
}