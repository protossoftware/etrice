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
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class RoomSemanticHighlightingCalculator extends BaseSemanticHighlighter {

	// @Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.provideHighlightingFor(resource, acceptor);
		
		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			EObject obj = node.getGrammarElement();
			if (obj instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) obj;
				String name = ruleCall.getRule().getName();
				if (name.equals("Annotation")) {
					acceptor.addPosition(
							node.getOffset(),
							node.getLength(),
							RoomHighlightingConfiguration.HL_ANNOTATION_ID);
				}
			}
		}
	}
}
