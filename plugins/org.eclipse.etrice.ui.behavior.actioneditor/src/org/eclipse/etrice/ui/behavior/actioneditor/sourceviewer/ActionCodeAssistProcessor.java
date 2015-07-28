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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider.ExpressionFeature;
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

	public ActionCodeAssistProcessor(ActionCodeEditorConfiguration configuration) {
		super();
		fConfiguration = configuration;
		exprProvider = fConfiguration.getDetailExpressionProvider();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

		// get last context feature + prefix
		DetailExpressionAssistParser resolver = new DetailExpressionAssistParser(viewer.getDocument(), offset,
				exprProvider);
		ExpressionFeature contextFeature = resolver.resolveLatestCompleted();
		String idPrefix = "";
		try {
			idPrefix = resolver.computeIdentifierPrefix(offset);
		}
		catch (BadLocationException e) {
		}

		// cancel, if user expects proposals from context, but contextFeature
		// could not be resolved
		if (contextFeature == null && isExpressionSeparator(viewer, offset))
			return new ICompletionProposal[0];

		// create proposals
		Iterable<ExpressionFeature> features = (contextFeature != null) ? exprProvider.getContextFeaturesWithPrefix(
				contextFeature, idPrefix) : exprProvider.getInitialFeaturesWithPrefix(idPrefix);
		for (ExpressionFeature feature : features) {
			try {
				proposals.add(createPrefixCompletionProposal(feature, offset, idPrefix));
			}
			catch (Exception e) {
			}
		}

		return proposals.toArray(new ICompletionProposal[proposals.size()]);
	}

	private boolean isExpressionSeparator(ITextViewer viewer, int offset) {
		try {
			return viewer.getDocument().getChar(offset - 1) == IDetailExpressionProvider.SEPARATOR;
		}
		catch (BadLocationException e) {
		}
		return false;
	}

	private ICompletionProposal createPrefixCompletionProposal(ExpressionFeature feature, int offset, String prefix) {
		Pair<String, Point> completionPair = exprProvider.getCompletion(feature);
		String completion = completionPair.getKey();
		String displayString = exprProvider.getDisplayString(feature);
		if (Strings.isEmpty(displayString))
			displayString = completion;

		ICompletionProposal proposal = new CompletionProposal(completion, offset - prefix.length(), prefix.length(),
				completion.length(), exprProvider.getImage(feature), displayString, null, null);

		Point selection = completionPair.getValue();
		if (selection != null)
			selection.x += (offset - prefix.length());
		return new CustomCompletionProposal(proposal, selection);
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