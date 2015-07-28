/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.modelaware;

import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeAssistProcessor;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeColorManager;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.ActionCodeEditorConfiguration;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;

/**
 * An extension of {@link ActionCodeEditorConfiguration} with adds to it a model
 * cum language(general) aware scanner and model aware content assist processor.
 * 
 * @author jayant
 */
public class ModelAwareActionCodeEditorConfiguration extends ActionCodeEditorConfiguration {

	/** token scanner for syntax highlighting */
	private GeneralActionCodeScanner generalActionCodeScanner;
	/** content assist processor for content assistance */
	private ActionCodeAssistProcessor actionCodeAssistProcessor;

	public ModelAwareActionCodeEditorConfiguration(ActionCodeColorManager colorManager,
			IDetailExpressionProvider exprProvider) {
		super(colorManager, exprProvider);
	}

	/**
	 * Constructs and returns an instance of the {@link ITokenScanner}. Same
	 * instance of the scanner is returned on subsequent invocations.
	 * 
	 * @return the token scanner for the configuration
	 */
	private GeneralActionCodeScanner getTokenScanner() {
		if (generalActionCodeScanner == null) {
			generalActionCodeScanner = new GeneralActionCodeScanner(this);
			generalActionCodeScanner.setDefaultReturnToken(new Token(new TextAttribute(getColorManager().getColor(
					ActionCodeColorManager.DEFAULT))));
		}
		return generalActionCodeScanner;
	}

	/**
	 * Constructs and returns an instance of the {@link IContentAssistProcessor}
	 * . Same instance of the processor is returned on subsequent invocations.
	 * 
	 * @return the content assist processor for the configuration
	 */
	private ActionCodeAssistProcessor getContextAssistProcessor() {
		if (actionCodeAssistProcessor == null) {
			actionCodeAssistProcessor = new ActionCodeAssistProcessor(this);
		}
		return actionCodeAssistProcessor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		PresentationReconciler reconciler = new PresentationReconciler();

		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getTokenScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {

		ContentAssistant assistant = new ContentAssistant();
		assistant.setContentAssistProcessor(getContextAssistProcessor(), IDocument.DEFAULT_CONTENT_TYPE);
		assistant.setEmptyMessage("No Proposals.");
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);

		return assistant;
	}
}