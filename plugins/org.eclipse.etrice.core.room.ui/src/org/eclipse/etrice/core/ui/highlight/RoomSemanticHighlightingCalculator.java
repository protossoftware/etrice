/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.ui.highlight;

import static org.eclipse.etrice.core.ui.highlight.RoomHighlightingConfiguration.HL_ANNOTATION_ID;
import static org.eclipse.etrice.core.ui.highlight.RoomHighlightingConfiguration.HL_DEPRECATED_ID;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.ui.highlight.BaseSemanticHighlighter;
import org.eclipse.etrice.core.converter.RoomValueConverterService;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.room.RoomElement;
import org.eclipse.etrice.core.room.util.RoomHelpers;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.etrice.core.ui.util.UIExpressionUtil;
import org.eclipse.etrice.core.ui.util.UIExpressionUtil.ExpressionCache;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.ui.highlight.ExpressionRuleFactory;
import org.eclipse.etrice.expressions.ui.highlight.TargetLanguageRuleFactory;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class RoomSemanticHighlightingCalculator extends BaseSemanticHighlighter {

	@Inject RoomGrammarAccess grammar;
	@Inject RoomValueConverterService converterService;
	@Inject RoomHelpers roomHelpers;
	
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource == null || resource.getParseResult() == null)
			return;

		ExpressionCache expressionCache = new ExpressionCache();
		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			if(cancelIndicator.isCanceled()) 
				break;
			
			super.provideHighlightingFor(node, resource, acceptor);	
			
			EObject obj = node.getGrammarElement();
			if (obj instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) obj;
				if(ruleCall.getRule() == grammar.getAnnotationRule()){
					acceptor.addPosition(node.getOffset(), node.getLength(), HL_ANNOTATION_ID);
				}
				else if(ruleCall.getRule() == grammar.getCC_STRINGRule()) {
					detailCodeHighlight(node, acceptor, expressionCache);
				}
				else if(ruleCall.getRule() == grammar.getIDRule() || ruleCall.getRule() == grammar.getFQNRule()) {
					highlightDeprecated(node, acceptor);
				}
			}
			else if(obj instanceof CrossReference) {
				highlightDeprecated(node, acceptor);
			}
		}
	}
	
	protected void detailCodeHighlight(INode node, IHighlightedPositionAcceptor acceptor, ExpressionCache cache) {		
		final String text = converterService.getCC_StringConverter().stripDelim(node.getText());
		final int offset = node.getOffset() + converterService.getCC_StringConverter().getDelim().length();
		
		DetailCode dc = null;
		if(node.getParent().getSemanticElement() instanceof DetailCode) {
			dc = (DetailCode) node.getParent().getSemanticElement();
		}
		IDetailExpressionProvider exprProvider = UIExpressionUtil.getExpressionProvider(dc, null, cache);
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
	
	Map<EClass, Boolean> annotatedClasses = Maps.newHashMap();
	
	protected void highlightDeprecated(INode node, IHighlightedPositionAcceptor acceptor) {	
		if(node.getGrammarElement() instanceof CrossReference) {
			EReference ref = GrammarUtil.getReference((CrossReference) node.getGrammarElement(), node.getSemanticElement().eClass());
			EObject annotatedElement = (ref != null) ? (EObject) node.getSemanticElement().eGet(ref) : null;
			if(annotatedElement instanceof RoomElement) {
				Annotation annotation = roomHelpers.findDeprecatedAnnotation((RoomElement) annotatedElement);		
				if(annotation != null) {
					acceptor.addPosition(node.getOffset(), node.getLength(), HL_DEPRECATED_ID);
				}
			}
		} else {
			EObject annotatedElement = node.getSemanticElement();
			if(annotatedElement instanceof RoomElement) {
				Annotation annotation = roomHelpers.findDeprecatedAnnotation((RoomElement) annotatedElement);		
				if(annotation != null) {
					boolean noGenerate = roomHelpers.isDeprecatedGeneration((RoomElement) annotatedElement);
					if(noGenerate) {
						ICompositeNode completeNode = NodeModelUtils.findActualNodeFor(annotatedElement);
						acceptor.addPosition(completeNode.getOffset(), completeNode.getLength(), HL_DEPRECATED_ID);
					} else {
						acceptor.addPosition(node.getOffset(), node.getLength(), HL_DEPRECATED_ID);	
					}
				}
			}
		}
	}
	
}
