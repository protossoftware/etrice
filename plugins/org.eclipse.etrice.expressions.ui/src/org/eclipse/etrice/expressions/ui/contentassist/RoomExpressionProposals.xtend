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

package org.eclipse.etrice.expressions.ui.contentassist

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.etrice.core.room.ActorClass
import org.eclipse.etrice.expressions.detailcode.DefaultDetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.DetailExpressionAssistParser
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.etrice.expressions.ui.DetailExpressionUIProvider
import org.eclipse.jface.text.Document
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher
import org.eclipse.xtext.util.Strings
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider

class RoomExpressionProposals {
	
	@Inject
	DetailExpressionUIProvider uiExpressionProvider
	
	@Inject
	PrefixMatcher prefixMatcher
	
	def List<ICompletionProposal> createProposals(IDetailExpressionProvider exprProvider, String text, int offset, int globalOffset) {
		val parser = new DetailExpressionAssistParser(new Document(text), offset, exprProvider)			
		val availableFeatures = newArrayList => [
			if(parser.isContextExpression) {
				val contextFeature = parser?.resolveLatestCompleted
				it += if(contextFeature !== null) exprProvider.getContextFeatures(contextFeature) else exprProvider.initialFeatures
			} else {
				it += exprProvider.initialFeatures
			}	
		]
		
		val prefix = parser.computeIdentifierPrefix(offset)
		availableFeatures.filter[id.startsWith(prefix)].map[ feature | 
			val displayString = new StyledString(uiExpressionProvider.getDisplayString(feature))
			val image = uiExpressionProvider.getImage(feature)
			val prop = doCreateProposal(feature.id, displayString, image, prefix, globalOffset) => [			
				processPostfix(feature)
			]
			
			return prop as ICompletionProposal
		].toList
	}
	
	def	protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString, Image image, String prefix, int globalOffset) {
		new ConfigurableCompletionProposal(proposal, globalOffset - prefix.length, prefix.length, proposal.length, image, displayString, null, null) => [
			matcher = prefixMatcher
			autoInsertable = false
			// TODO adjust length to existing text
			replaceContextLength = proposal.length
		]
	}
	
	def protected processPostfix(ConfigurableCompletionProposal proposal, ExpressionFeature feature){
		proposal => [
			val postfix = uiExpressionProvider.getPostfixReplacement(feature)
			if(!Strings.isEmpty(postfix.key)) {
				if(postfix.value != null) {
					selectionStart = replacementOffset + replacementString.length + postfix.value.x
					cursorPosition = cursorPosition + postfix.value.x
					selectionLength =  postfix.value.y
				} else {
					cursorPosition = cursorPosition + postfix.key.length
				}
				replacementString = replacementString + postfix.key
			}
		]
	}

}