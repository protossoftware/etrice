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
import org.eclipse.etrice.expressions.detailcode.DetailExpressionAssistParser
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature
import org.eclipse.jface.text.Document
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.jface.viewers.StyledString
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher
import org.eclipse.xtext.util.Strings

/**
 *  Create {@link ICompletionProposal}s for current position.
 *  Uses DetailExpressionAssistParser to parse expressions and DetailExpressionUIProvider for decoration.
 */
class RoomExpressionProposalProvider {
	
	@Inject
	DetailExpressionProposalConfig uiExpressionProvider
	
	@Inject
	PrefixMatcher prefixMatcher
	
	def List<ICompletionProposal> createProposals(IDetailExpressionProvider exprProvider, String text, int offset, int globalOffset) {
		// parser to use
		val parser = new DetailExpressionAssistParser(new Document(text), offset, exprProvider)
		// get features that follow last completed feature			
		val availableFeatures = newArrayList => [
			if(parser.isContextExpression) {
				val contextFeature = parser?.resolveLatestCompleted				
				it += if(contextFeature !== null) exprProvider.getContextFeatures(contextFeature) else exprProvider.initialFeatures
			} else {
				it += exprProvider.initialFeatures
			}	
		]
		// filter by incomplete text prefix
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
				if(postfix.value !== null) {
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