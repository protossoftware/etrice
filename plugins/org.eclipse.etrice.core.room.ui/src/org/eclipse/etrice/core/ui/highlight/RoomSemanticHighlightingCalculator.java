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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.highlight.BaseSemanticHighlighter;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class RoomSemanticHighlightingCalculator extends BaseSemanticHighlighter {

	@Inject
	RoomGrammarAccess grammar;
	
	private static String[] fgKeywords = { "while", "do", "for", "if", "else",
			"break", "continue", "switch", "case", "default", "static", "return",
			"struct", "union", "sizeof", "explicit", "export", "extern", "goto",
			"this", "throw", "try", "catch", "new", "delete",
			"public", "private", "protected", "sizeof",
			"typedef", "virtual", "class", "using", "template", "volatile", "mutable", "friend", "inline",
			"typeid", "typename", "namespace",
			"const", "int", "float", "double", "short", "long", "unsigned", "signed", "void", "true", "false"};
	
	private List<Pattern> keywordPattern = new ArrayList<Pattern>();
	
	protected List<Pattern> getKeywordPatterns() {
		if(keywordPattern.isEmpty()) {
			for(String keyword : fgKeywords)
				keywordPattern.add(Pattern.compile(keyword));
		}
		
		return keywordPattern;
	}
	
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
				final String text = node.getText();
				for(Pattern keywordPattern : getKeywordPatterns()){							
					Matcher matcher = keywordPattern.matcher(text);
					while(matcher.find()){
						boolean leftNotId = !Character.isJavaIdentifierPart(text.charAt(matcher.start()-1));
						boolean rightNotId = !Character.isJavaIdentifierPart(text.charAt(matcher.end()+1));
						if(leftNotId && rightNotId){
							acceptor.addPosition(node.getOffset() + matcher.start(), matcher.end() - matcher.start(), RoomHighlightingConfiguration.HL_TARGET_LANG_KEYWORD_ID);
						}
					}
				}
			}
		}
		
	}
	
}
