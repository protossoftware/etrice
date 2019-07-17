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
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.highlight;

import static org.eclipse.etrice.core.common.ui.highlight.BaseHighlightingConfig.HL_ANNOTATION_ID;
import static org.eclipse.etrice.core.common.ui.highlight.BaseHighlightingConfig.HL_DOCUMENTATION;
import static org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration.NUMBER_ID;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.converter.BaseConverterService;
import org.eclipse.etrice.core.common.converter.CCStringConverter;
import org.eclipse.etrice.core.common.converter.CCStringIndentation;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.documentation.IEObjectDocumentationProviderExtension;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

public class BaseSemanticHighlighter implements	ISemanticHighlightingCalculator {

	@Inject BaseGrammarAccess grammar;	
	@Inject BaseConverterService converterService;
	@Inject(optional = true) IEObjectDocumentationProviderExtension docuProvider;
	
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			if(cancelIndicator.isCanceled()) 
				break;
			
			provideHighlightingFor(node, resource, acceptor);
		}
	}
	
	protected void provideHighlightingFor(INode node, XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) grammarElement).getRule();
			if(rule == grammar.getCC_STRINGRule()) {
				ccStringHighlight(node, acceptor, converterService.getCC_StringConverter());
			}
			else if(rule == grammar.getNumberLiteralRule()) {
				acceptor.addPosition(node.getOffset(), node.getLength() , NUMBER_ID);
			}
		} else {		
			if(grammarElement == grammar.getAnnotationAccess().getTypeAnnotationTypeCrossReference_1_0() 
					|| grammarElement == grammar.getAnnotationAccess().getCommercialAtKeyword_0()) {
				// highlight annotation @FQN
				acceptor.addPosition(node.getOffset(), node.getLength(), HL_ANNOTATION_ID);
			}
			else if(docuProvider != null && grammarElement == grammar.getML_COMMENTRule()) {
				// highlight comments that are treated as comments
				EObject semanticObj = NodeModelUtils.findActualSemanticObjectFor(node);
				if(semanticObj != null && docuProvider.getDocumentationNodes(semanticObj).contains(node))
					acceptor.addPosition(node.getOffset(), node.getLength() , HL_DOCUMENTATION);
			}
		}
	}
	
	protected void ccStringHighlight(INode node, IHighlightedPositionAcceptor acceptor, CCStringConverter converter) {
		final String delim = converter.getDelim();
		if (node.getText() == null || node.getText().length() < delim.length() * 2)
			return;
		
		acceptor.addPosition(node.getOffset(), delim.length(), DefaultHighlightingConfiguration.STRING_ID);
		acceptor.addPosition(node.getEndOffset() - delim.length(), delim.length(), DefaultHighlightingConfiguration.STRING_ID);

		int offset = node.getOffset() + delim.length();
		List<Pair<Integer, Integer>> lineStartLength = new CCStringIndentation(converter.stripDelim(node.getText())).highlight();
		for (Pair<Integer, Integer> offsetLength : lineStartLength) {
			acceptor.addPosition(offset + offsetLength.getKey(), offsetLength.getValue(), BaseHighlightingConfig.HL_CCSTRING);
		}	
	}

}
