/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.fsm.fSM.Guard
import org.eclipse.etrice.core.fsm.fSM.StateGraphItem
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.expressions.detailcode.DefaultDetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.DetailExpressionAssistParser
import org.eclipse.etrice.expressions.detailcode.GuardDetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider
import org.eclipse.jface.text.Document
import org.eclipse.xtext.nodemodel.ILeafNode
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature

class UIExpressionUtil {

	static def IDetailExpressionProvider selectExpressionProvider(EObject it) {
		switch it {
			Guard: new GuardDetailExpressionProvider(findActorClass)
			StateGraphItem: new DefaultDetailExpressionProvider(findActorClass)
			default: new IDetailExpressionProvider.EmptyDetailExpressionProvider
		}
	}

	static def private ActorClass findActorClass(EObject model) {
		var parent = model;
		while (parent !== null) {
			if (parent instanceof ActorClass) {
				return parent as ActorClass
			}
			parent = parent.eContainer();
		}

		return null
	}
	
	static def ExpressionFeature findAtOffset(ILeafNode leafNode, int offset) {
		// work in progress - show eObject for detail code
		val exprProvider = UIExpressionUtil.selectExpressionProvider(leafNode.semanticElement.eContainer)
		
		// TODO explicit support for hover info in DetailExpressionAssistParser
		val text = leafNode.text
		val completeExprOffset = {
			var exprEndOfsset = offset - leafNode.offset
			while(text.length > exprEndOfsset && Character.isJavaIdentifierPart(text.charAt(exprEndOfsset))) 
				exprEndOfsset += 1
			exprEndOfsset
		}
		val parser = new DetailExpressionAssistParser(new Document(leafNode.text), completeExprOffset, exprProvider)
		
		switch contextFeature : parser?.resolveLatestCompleted {
			case null: exprProvider.initialFeatures.findFirst[id == parser.computeIdentifierPrefix(completeExprOffset)]
			default: exprProvider.getContextFeatures(contextFeature).findFirst[id == parser.computeIdentifierPrefix(completeExprOffset)]
		}
	}
}
