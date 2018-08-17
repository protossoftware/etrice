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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.common.ui.highlight.BaseSemanticHighlighter;
import org.eclipse.etrice.core.converter.RoomValueConverterService;
import org.eclipse.etrice.core.services.RoomGrammarAccess;
import org.eclipse.etrice.dctools.ast.DCUtil;
import org.eclipse.etrice.dctools.fsm.ast.DCLanguage;
import org.eclipse.etrice.ui.behavior.fsm.Activator;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.preferences.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class RoomSemanticHighlightingCalculator extends BaseSemanticHighlighter {
	
	@Inject RoomGrammarAccess grammar;
	@Inject RoomValueConverterService converterService;
	@Inject DCUtil detailCodeUtil;
	DCLanguage language = null;
	
	public RoomSemanticHighlightingCalculator() {
	}
	
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource == null || resource.getParseResult() == null)
			return;
		
		if (language==null) {
			setLanguage();
		}

		INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			if(cancelIndicator.isCanceled()) 
				break;
			
			super.provideHighlightingFor(node, resource, acceptor);	
			
			EObject obj = node.getGrammarElement();
			if (obj instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) obj;
				if(ruleCall.getRule() == grammar.getAnnotationRule()){
					acceptor.addPosition(node.getOffset(), node.getLength(), RoomHighlightingConfiguration.HL_ANNOTATION_ID);
				}
				else if(ruleCall.getRule() == grammar.getCC_STRINGRule()) {
					HighlightingAstVisitor.highlight(node, acceptor, detailCodeUtil);
				}
			}

		}
	}

	private void setLanguage() {
		IPreferenceStore preferenceStore = Activator.getDefault().getPreferenceStore();
		String lang = preferenceStore.getString(PreferenceConstants.EDITOR_LANGUAGE);
		if (lang.equals(PreferenceConstants.JAVA_LANGUAGE)) {
			language = DCLanguage.JAVA_LANGUAGE;
		}
		else {
			language = DCLanguage.CPP_LANGUAGE;
		}
		detailCodeUtil.setLanguage(language);
	}
}
