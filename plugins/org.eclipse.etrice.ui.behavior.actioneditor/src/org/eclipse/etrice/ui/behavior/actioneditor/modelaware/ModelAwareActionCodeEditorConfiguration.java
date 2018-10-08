/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.modelaware;

import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.ui.highlight.ExpressionRuleFactory;
import org.eclipse.etrice.expressions.ui.highlight.TargetLanguageRuleFactory;
import org.eclipse.etrice.ui.behavior.actioneditor.Activator;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeAssistProcessor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

import com.google.common.collect.Iterables;

/**
 * An extension of {@link ActionCodeEditorConfiguration} with adds to it a model
 * cum language(general) aware scanner and model aware content assist processor.
 * 
 * @author jayant
 */
public class ModelAwareActionCodeEditorConfiguration extends TextSourceViewerConfiguration {

	/** token scanner for syntax highlighting */
	private RuleBasedScanner tokenScanner;
	/** content assist processor for content assistance */
	private ActionCodeAssistProcessor actionCodeAssistProcessor;
	
	private IDetailExpressionProvider exprProvider;

	public ModelAwareActionCodeEditorConfiguration(IDetailExpressionProvider exprProvider) {
		// preference from behavior.fsm (preferences: eTrice->Action Editor)
		super(Activator.getDefault().getReadonlyEditorPreferenceStore());
		this.exprProvider = exprProvider;
	}

	/**
	 * Constructs and returns an instance of the {@link ITokenScanner}. Same
	 * instance of the scanner is returned on subsequent invocations.
	 * 
	 * @return the token scanner for the configuration
	 */
	private RuleBasedScanner getTokenScanner() {
		if (tokenScanner == null) {
			JFaceHighlightStyles styles = new JFaceHighlightStyles();
			tokenScanner = new RuleBasedScanner();
			tokenScanner.setRules(Iterables.toArray(Iterables.concat(
					TargetLanguageRuleFactory.getGeneralLiteralRules(styles),
					ExpressionRuleFactory.getInitialExpressionRules(exprProvider, styles),
					TargetLanguageRuleFactory.getGeneralKeywordRules(styles))
			, IRule.class));
			tokenScanner.setDefaultReturnToken(new Token(styles.getDefault()));
		}
		return tokenScanner;
	}

	/**
	 * Constructs and returns an instance of the {@link IContentAssistProcessor}
	 * . Same instance of the processor is returned on subsequent invocations.
	 * 
	 * @return the content assist processor for the configuration
	 */
	private ActionCodeAssistProcessor getContextAssistProcessor() {
		if (actionCodeAssistProcessor == null) {
			actionCodeAssistProcessor = new ActionCodeAssistProcessor(exprProvider);
		}
		return actionCodeAssistProcessor;
	}

	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getTokenScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {

		ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(getContextAssistProcessor(), IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setEmptyMessage("No Proposals.");
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);

		return assistant;
	}
}