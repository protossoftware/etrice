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

package org.eclipse.etrice.core.ui.hover

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.common.ui.hover.KeywordEObjectTextHover
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.services.RoomGrammarAccess
import org.eclipse.etrice.core.ui.util.UIExpressionUtil
import org.eclipse.jface.text.Region
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.Tuples

class RoomHoverProvider extends KeywordEObjectTextHover {
	
	@Inject
	RoomGrammarAccess grammar
	
	override protected getXtextElementAt(XtextResource resource, int offset) {
		// lookup expression
		val parseResult = resource.parseResult
		if(parseResult !== null) {
			val leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.rootNode, offset)
			if(leafNode?.grammarElement instanceof RuleCall) {
				if((leafNode.grammarElement as RuleCall).rule == grammar.CC_STRINGRule && leafNode.semanticElement instanceof DetailCode){
					val exprFeature = UIExpressionUtil.findAtOffset(leafNode, offset)
					if(exprFeature?.data instanceof EObject)
						return Tuples.create(exprFeature.data as EObject, new Region(offset, exprFeature.id.length))
				}
			}
		}
			
		super.getXtextElementAt(resource, offset)
	}
	
}