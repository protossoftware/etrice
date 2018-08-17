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
class DCAstBracketNode extends DCAstTextNode {
	
	enum BracketType {
		ROUND,
		CURLY,
		SQUARE
	}
	
	BracketType type
	int posClose
	boolean closed
	
	new(DCAstNode parent, BracketType type, DCAstNode contents, int posOpen, int posClose) {
		super(parent, 2, posOpen, posOpen+1)
		this.type = type
		this.posClose = posClose
		this.closed = posClose>=0
		
		if (contents!==null) {
			contents.parent = this
		}
	}
	
	new(DCAstNode parent, BracketType type, DCAstNode contents, int posOpen) {
		this(parent, type, contents, posOpen, -1)
	}
	
	def left() {
		switch type {
			case CURLY: "{"
			case ROUND: "("
			case SQUARE: "["
		}
	}
	
	def right() {
		switch type {
			case CURLY: "}"
			case ROUND: ")"
			case SQUARE: "]"
		}
	}
	
	override toString() {
		switch type {
			case CURLY: "{}"
			case ROUND: "()"
			case SQUARE: "[]"
		}
	}
	
	override protected doPrint(String indent) {
		println(indent + "DCAstBracketNode " + this.toString)
	}
	
	override def String getText() { toString }
}