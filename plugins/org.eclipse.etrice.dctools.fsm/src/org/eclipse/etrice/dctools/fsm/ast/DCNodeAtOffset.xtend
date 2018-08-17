/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.dctools.fsm.ast

import org.eclipse.etrice.dctools.fsm.ast.util.IDCAstNodeVisitor
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstMatchNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstTextNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode

class DCNodeAtOffset implements IDCAstNodeVisitor {
	
	int offset
	DCAstTextNode result = null
	
	private new (int offset) {
		this.offset = offset
	}
	
	static def find(DCAstMatchNode ast, int offset) {
		val visitor = new DCNodeAtOffset(offset)
		ast.visit(visitor)
		return visitor.result
	}
	
	override visitBegin(DCAstNode node) {
		if (result===null) {
			if (node instanceof DCAstTextNode) {
				if (node.begin<=offset && offset<node.end) {
					result = node
				}
			}
			if (node instanceof DCAstBracketNode) {
				// also test the closing bracket
				if (node.posClose>=0) {
					if (node.posClose==offset) {
						result = node
					}
				}
			}
		}
		return result===null
	}
	
	override visitEnd(DCAstNode node) {
	}
	
}