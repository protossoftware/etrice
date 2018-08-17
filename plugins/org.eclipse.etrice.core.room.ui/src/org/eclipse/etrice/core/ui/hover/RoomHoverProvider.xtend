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
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.hover

import com.google.inject.Inject
import org.eclipse.etrice.core.common.ui.hover.KeywordEObjectTextHover
import org.eclipse.etrice.core.fsm.fSM.DetailCode
import org.eclipse.etrice.core.services.RoomGrammarAccess
import org.eclipse.etrice.dctools.ast.DCUtil
import org.eclipse.jface.text.Region
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.Tuples

class RoomHoverProvider extends KeywordEObjectTextHover {
	
	@Inject RoomGrammarAccess grammar
	@Inject DCUtil util
	
	override protected getXtextElementAt(XtextResource resource, int offset) {
		// lookup expression
		val parseResult = resource.parseResult
		if(parseResult !== null) {
			val leafNode = NodeModelUtils.findLeafNodeAtOffset(parseResult.rootNode, offset)
			if(leafNode?.grammarElement instanceof RuleCall) {
				if((leafNode.grammarElement as RuleCall).rule == grammar.CC_STRINGRule && leafNode.semanticElement instanceof DetailCode){
//					println("RoomHoverProvider at offset " + offset + " " + leafNode.offset + " " + leafNode.text.substring(offset - leafNode.offset))
					val result = util.findAtOffset(leafNode, offset)
					if (result!==null) {
//						val begin = result.begin
//						println("RoomHoverProvider hit " + (leafNode.offset + result.begin) +" " + result.length + " " + leafNode.text.substring(begin, begin + result.length))
						return Tuples.create(result.object, new Region(leafNode.offset + result.begin, result.length))
					}
				}
			}
		}
			
		super.getXtextElementAt(resource, offset)
	}
	
}