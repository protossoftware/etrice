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

import org.eclipse.etrice.core.ui.RoomUiModule;
import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.expressions.ui.contentassist.RoomExpressionProposalProvider;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.google.inject.Inject;

/**
 * An Action Editor specific content assist processor. The processor lexically
 * analyzes the Action Code using {@link ActionCodeContext} and generates
 * proposals based on this context.
 * 
 * @author jayant
 */
public class ActionCodeAssistProcessor implements IContentAssistProcessor {

	@Inject RoomExpressionProposalProvider proposals;
	
	private IDetailExpressionProvider exprProvider;
	
	public ActionCodeAssistProcessor(IDetailExpressionProvider exprProvider) {
		super();
		this.exprProvider = exprProvider;
		RoomUiModule.getInjector().injectMembers(this);
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