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

@Accessors
class DCAstBracketNode extends DCAstNode {
	
	enum BracketType {
		ROUND,
		CURLY,
		SQUARE
	}
	
	BracketType type
	boolean closed
	
	new(DCAstNode parent, BracketType type, DCAstNode contents) {
		this(parent, type, contents, true)
	}
	
	new(DCAstNode parent, BracketType type, DCAstNode contents, boolean closed) {
		super(parent, 2)
		this.type = type
		this.closed = closed
		
		if (contents!==null) {
			contents.parent = this
		}
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
	
}