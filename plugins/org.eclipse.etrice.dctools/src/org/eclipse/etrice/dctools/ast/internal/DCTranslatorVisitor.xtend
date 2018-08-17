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

package org.eclipse.etrice.dctools.ast.internal

import org.eclipse.etrice.core.room.Attribute
import org.eclipse.etrice.core.room.InterfaceItem
import org.eclipse.etrice.core.room.Message
import org.eclipse.etrice.core.room.Operation
import org.eclipse.etrice.dctools.ast.ITranslationProvider
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstArrayAccessNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstBracketNode.BracketType
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstIdentifierNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOperationCallNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstOtherNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstPeriodNode
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstWhitespaceNode
import org.eclipse.etrice.dctools.fsm.ast.util.DCAstPrinter
import org.eclipse.etrice.dctools.fsm.ast.util.IDCAstNodeVisitor
import org.eclipse.etrice.dctools.fsm.ast.nodes.DCAstFeatureCallNode
import org.eclipse.etrice.core.room.Port
import org.eclipse.etrice.core.room.VarDecl

class DCTranslatorVisitor implements IDCAstNodeVisitor {

	ITranslationProvider translationProvider
	
	val sb = new StringBuilder
	var currentSB = sb
	
	new(ITranslationProvider translationProvider) {
		this.translationProvider = translationProvider
	}
	
	def String getTranslatedCode() {
		sb.toString
	}
	
	
	override visitBegin(DCAstNode node) {
		
		if (node instanceof DCAstBracketNode) {
			if (node.shouldCollectArguments) {
				currentSB = new StringBuilder
				node.linkedData = currentSB
			}
			else {
				currentSB.append(node.left)
			}
		}
		else {
			if (!node.skipOutput) {
				switch node {
					DCAstIdentifierNode: currentSB.append(node.id)
					DCAstPeriodNode: currentSB.append(".")
					DCAstWhitespaceNode: currentSB.append(node.text)
					DCAstOtherNode: currentSB.append(node.text)
				}
			}
		}
		
		return true
	}
	
	override visitEnd(DCAstNode node) {
		switch node {
			DCAstBracketNode: {
				if (node.linkedData!==null) {
					// leave the nested StringBuilder and switch to the enclosing (or top) one
					currentSB = node.enclosingSB
				}
				else if (node.closed) {
					currentSB.append(node.right)
				}
			}
			
			DCAstFeatureCallNode case node.canTranslate: node.translate
		}
	}
	
	private def canTranslate(DCAstFeatureCallNode node) {
		// if all even children are linked then we can translate the whole
		for (var i=0; i<node.children.size; i=i+2) {
			if (node.c(i).linkedObject===null) {
				return false
			}
		}
		
		// make sure the last child is not a period
		val lastNode = node.children.last
		if (lastNode instanceof DCAstPeriodNode) {
			return false
		}
		
		return true
	}
	
	private def translate(DCAstFeatureCallNode node) {
		val lastNode = node.children.last
		var linkedObject = lastNode.linkedObject
		
		// TODO: handle getter for data driven ports: port.message - i.e. no () after message
		
		if (lastNode instanceof DCAstOperationCallNode) {
			if (linkedObject instanceof Message) {
				handleSendMessage(lastNode, linkedObject)
				return
			}
		}
		
		node.handleCallChain
	}
	
	def handleCallChain(DCAstFeatureCallNode node) {
		var String instance = null
		for (var i=0; i<node.children.size; i=i+2) {
			val childNode = node.c(i)
			val linkedObject = childNode.linkedObject
			switch linkedObject {
				Attribute: {
					val index = if (childNode instanceof DCAstArrayAccessNode) {
						(childNode.bracketNode.linkedData as StringBuilder).toString
					}
					instance = translationProvider.getAttributeGetter(linkedObject, instance, index, childNode.originalText)
				}
				
				VarDecl: {
					instance = linkedObject.name
				}
				
				Operation: {
					val args = if (childNode instanceof DCAstOperationCallNode) {
						(childNode.bracketNode.linkedData as StringBuilder).toString
					}
					instance = translationProvider.getOperationText(linkedObject, instance, args, childNode.originalText)
				}
			}
		}
		currentSB.append(instance)
	}
	
	private def handleSendMessage(DCAstOperationCallNode msgNode, Message msg) {
		val args = (msgNode.bracketNode.linkedData as StringBuilder).toString
		// look back to interface item
		val ifItemNode = msgNode.parent.c(0)
		val ifItem = ifItemNode.linkedObject as InterfaceItem
		
		val translated =
			if (ifItemNode instanceof DCAstIdentifierNode) {
				// accessed as scalar (means broadcast for replicated port)
				val inst = ifItemNode.id
				translationProvider.getInterfaceItemMessageText(ifItem, msg, inst, args, null, msgNode.originalText)
			}
			else if (ifItemNode instanceof DCAstArrayAccessNode) {
				// accessed as array
				val inst = ifItemNode.id
				val index = (ifItemNode.bracketNode.linkedData as StringBuilder).toString
				translationProvider.getInterfaceItemMessageText(ifItem, msg, inst, args, index, msgNode.originalText)
			}
			else {
				// TODO: assert(false)
				"internal translator error"
			}
		currentSB.append(translated)
	}
	
	private def skipOutput(DCAstNode node) {
		val surroundingContext = node.getEnclosingBracketOrFeatureCall
		
		// check whether we are inside a bracket without a feature call
		if (surroundingContext instanceof DCAstBracketNode) {
			return false
		}
		
		if (surroundingContext instanceof DCAstFeatureCallNode) {
			return surroundingContext.canTranslate
		}
		
		return false
	}
	
	private def getEnclosingBracketOrFeatureCall(DCAstNode node) {
		var parent = node.parent
		while (parent!==null) {
			if (parent instanceof DCAstFeatureCallNode || parent instanceof DCAstBracketNode) {
				return parent
			}
			parent = parent.parent
		}
		
		return null
	}
	
	private def getOriginalText(DCAstNode node) {
		val printer = new DCAstPrinter
		node.visit(printer)
		return printer.text
	}
	
	private def getEnclosingSB(DCAstBracketNode node) {
		var parent = node.parent
		while (parent!==null) {
			if (parent instanceof DCAstBracketNode && parent.linkedData instanceof StringBuilder) {
				return parent.linkedData as StringBuilder
			}
			parent = parent.parent
		}
		
		// return top level
		return sb
	}
	
	private def shouldCollectArguments(DCAstBracketNode node) {
		val linkedObject = node.parent.linkedObject
		
		if (node.type==BracketType.CURLY) {
			false
		}
		else if (linkedObject instanceof Operation) {
			true
		}
		else if (linkedObject instanceof Message) {
			true
		}
		else if (linkedObject instanceof Attribute) {
			true
		}
		else if (linkedObject instanceof Port) {
			true
		}
		else {
			false
		}
	}
}