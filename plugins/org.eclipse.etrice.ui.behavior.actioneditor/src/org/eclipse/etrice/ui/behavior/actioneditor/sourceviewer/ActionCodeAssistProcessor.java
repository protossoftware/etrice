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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import org.eclipse.etrice.core.ui.RoomUiActivator;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider.ExpressionFeature;
import org.eclipse.etrice.expressions.ui.contentassist.RoomExpressionProposals;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Point;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

/**
 * An Action Editor specific content assist processor. The processor lexically
 * analyzes the Action Code using {@link ActionCodeContext} and generates
 * proposals based on this context.
 * 
 * @author jayant
 */
public class ActionCodeAssistProcessor implements IContentAssistProcessor {

	/** the local reference of the associated configuration */
	private ActionCodeEditorConfiguration fConfiguration;

	private DetailExpressionUIProvider exprProvider;
	
	@Inject
	RoomExpressionProposals proposals;
	
	public ActionCodeAssistProcessor(ActionCodeEditorConfiguration configuration) {
		super();
		fConfiguration = configuration;
		exprProvider = fConfiguration.getDetailExpressionProvider();
		RoomUiActivator.getDefault().getInjector(RoomUiActivator.ORG_ECLIPSE_ETRICE_CORE_ROOM).injectMembers(this);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		return proposals.createProposals(exprProvider, viewer.getDocument().get(), offset, offset).toArray(new ICompletionProposal[0]);
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { IDetailExpressionProvider.SEPARATOR };
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public String getErrorMessage() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}

}