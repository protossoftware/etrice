/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.highlight;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.converter.BaseConverterService;
import org.eclipse.etrice.core.common.converter.CCStringConverter;
import org.eclipse.etrice.core.common.converter.CCStringIndentation;
import org.eclipse.etrice.core.common.services.BaseGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

public class BaseSemanticHighlighter implements	ISemanticHighlightingCalculator {

	@Inject
	BaseGrammarAccess grammar;
	
	@Inject
	BaseConverterService converterService;
	
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
		EObject obj = node.getGrammarElement();
		if (obj instanceof RuleCall) {
			if(((RuleCall) obj).getRule() == grammar.getCC_STRINGRule()) {
				ccStringHighlight(node, acceptor, converterService.getCC_StringConverter());
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
