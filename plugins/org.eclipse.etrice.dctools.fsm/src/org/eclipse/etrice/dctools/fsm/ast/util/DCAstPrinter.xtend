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

package org.eclipse.etrice.dctools.fsm.ast.util

import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstPeriodNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstWhitespaceNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOtherNode

class DCAstPrinter implements IDCAstNodeVisitor {
	
	val sb = new StringBuilder
	
	def getText() {
		sb.toString
	}
	
	override visitBegin(DCAstNode node) {
		
		switch node {
			DCAstBracketNode: sb.append(node.left)
			DCAstIdentifierNode: sb.append(node.id)
			DCAstPeriodNode: sb.append(".")
			DCAstWhitespaceNode: sb.append(node.text)
			DCAstOtherNode: sb.append(node.text)
		}
		
		return true
	}
	
	override visitEnd(DCAstNode node) {
		switch node {
			DCAstBracketNode: if (node.closed) sb.append(node.right)
		}
	}
}