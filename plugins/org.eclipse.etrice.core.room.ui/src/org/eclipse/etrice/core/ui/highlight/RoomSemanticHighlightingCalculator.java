/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.highlight;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.highlight.BaseSemanticHighlighter;
import org.eclipse.etrice.core.converter.RoomValueConverterService;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.etrice.core.ui.util.UIExpressionUtil;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.ui.highlight.ExpressionRuleFactory;
import org.eclipse.etrice.expressions.ui.highlight.TargetLanguageRuleFactory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class RoomSemanticHighlightingCalculator extends BaseSemanticHighlighter {

	@Inject
	RoomGrammarAccess grammar;
	
	@Inject
	RoomValueConverterService converterService;
	
	@Override
	protected void provideHighlightingFor(INode node, XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.provideHighlightingFor(node, resource, acceptor);
		
		EObject obj = node.getGrammarElement();
		if (obj instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) obj;
			if(ruleCall.getRule() == grammar.getAnnotationRule()){
				acceptor.addPosition(
						node.getOffset(),
						node.getLength(),
						RoomHighlightingConfiguration.HL_ANNOTATION_ID);
			}
			else if(node.getParent().getSemanticElement() instanceof DetailCode && ruleCall.getRule() == grammar.getCC_STRINGRule()) {
				detailCodeHighlight(node, acceptor);
			}
			
		}
		
	}
	
	protected void detailCodeHighlight(INode node, IHighlightedPositionAcceptor acceptor) {
		final String text = converterService.getCC_StringConverter().stripDelim(node.getText());
		final int offset = node.getOffset() + converterService.getCC_StringConverter().getDelim().length();
		IDetailExpressionProvider exprProvider = UIExpressionUtil.selectExpressionProvider(node.getSemanticElement().eContainer());
		XtextHighlightStyles styles = new XtextHighlightStyles();
		RuleBasedScanner scanner = new RuleBasedScanner();
		scanner.setRules(Iterables.toArray(Iterables.concat(
				TargetLanguageRuleFactory.getGeneralLiteralRules(styles),
				ExpressionRuleFactory.getInitialExpressionRules(exprProvider, styles),
				TargetLanguageRuleFactory.getGeneralKeywordRules(styles))
		, IRule.class));
		scanner.setRange(new Document(text), 0, text.length());
		
		IToken lastToken = null;
		while(lastToken != Token.EOF) {
			lastToken = scanner.nextToken();
			if(lastToken != null && lastToken.getData() != null) {
				acceptor.addPosition(offset + scanner.getTokenOffset(), scanner.getTokenLength(), (String) lastToken.getData());
			}
		}
	}
	
}
