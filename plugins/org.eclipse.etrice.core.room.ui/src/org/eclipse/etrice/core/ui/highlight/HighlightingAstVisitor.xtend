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

package org.eclipse.etrice.core.ui.highlight

import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.MessageData
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.core.room.VarDecl
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOtherNode
import org.eclipse.etrice.dctools.fsm.ast.util.IDCAstNodeVisitor
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.etrice.dctools.ast.DCUtil
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOperationCallNode
import org.eclipse.etrice.core.room.Message

class HighlightingAstVisitor implements IDCAstNodeVisitor {
	
	IHighlightedPositionAcceptor acceptor
	int baseOffset

	static def highlight(INode node, IHighlightedPositionAcceptor acceptor, DCUtil util) {
		val ast = util.parseAndLink(node)
		val offset = util.getDelimiterAdjustedOffset(node)
		val visitor = new HighlightingAstVisitor(acceptor, offset)
		ast.visit(visitor)
	}
	
	private new(IHighlightedPositionAcceptor acceptor, int baseOffset) {
		this.acceptor = acceptor
		this.baseOffset = baseOffset
	}

	override boolean visitBegin(DCAstNode node) {
		var int begin
		var int length
		val highlightId = switch node {
			DCAstOtherNode: {
				begin = node.token.begin
				length = node.token.length
				switch node.token.token.kind {
					case COMMENT: RoomHighlightingConfiguration.COMMENT_ID
					case STRING: RoomHighlightingConfiguration.STRING_ID
					case NUMBER: RoomHighlightingConfiguration.NUMBER_ID
					case KEYWORD: RoomHighlightingConfiguration.KEYWORD_ID
					default: null
				}
			}
			DCAstIdentifierNode: {
				begin = node.token.begin
				length = node.token.length
				switch DCUtil.getLinkedObject(node) {
					Attribute,
					MessageData,
					VarDecl: RoomHighlightingConfiguration.HL_EXPR_ATTRIBUTE_ID
					InterfaceItem: RoomHighlightingConfiguration.HL_EXPR_INTERFACE_ITEM_ID
					Operation: RoomHighlightingConfiguration.HL_EXPR_OPERATION_ID
					default: null
				}
			}
			DCAstOperationCallNode: {
				begin = node.idNode.token.begin
				length = node.idNode.token.length
				switch node.linkedObject {
					Message: RoomHighlightingConfiguration.HL_EXPR_OPERATION_ID
					default: null
				}
			}
		}
		if (highlightId !== null) {
			acceptor.addPosition(baseOffset + begin, length, highlightId)
		}
		return true
	}

	override void visitEnd(DCAstNode node) {
	}
}
