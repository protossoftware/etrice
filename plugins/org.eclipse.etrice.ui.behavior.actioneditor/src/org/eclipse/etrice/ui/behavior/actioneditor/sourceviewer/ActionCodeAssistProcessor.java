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
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.etrice.core.room.InterfaceItem;
import org.eclipse.etrice.ui.behavior.actioneditor.Activator;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

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

	public ActionCodeAssistProcessor(ActionCodeEditorConfiguration configuration) {
		super();
		fConfiguration = configuration;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {
		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

		if (fConfiguration != null) {
			ActionCodeContext context = createContext(viewer, offset);
			if (context.isMethodContext()) {
				proposals.addAll(collectMethodProposals(context));
			} else {
				if (fConfiguration.isMemberAware())
					proposals.addAll(collectMemberProposals(context));

				if (fConfiguration.isMessageAware())
					proposals.addAll(collectInterfaceItemProposals(context));
			}
		}

		return proposals.toArray(new ICompletionProposal[proposals.size()]);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @author jayant
	 */
	@Override
	public char[] getCompletionProposalAutoActivationCharacters() {
		return new char[] { ActionCodeContext.METHOD_ITEM_SEPARATOR };
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

	/**
	 * Create the {@link ActionCodeContext} object for the given invocation.
	 * 
	 * @author jayant
	 */
	protected ActionCodeContext createContext(ITextViewer viewer, int offset) {
		ActionCodeParser parser = null;
		if (fConfiguration != null)
			parser = fConfiguration.getActionCodeParser();
		return new ActionCodeContext(viewer, offset, parser);
	}

	/**
	 * Collect the proposals for method completion. These would only be
	 * generated if the Interface Item has been identified in the
	 * {@code context} and is followed by
	 * {@link ActionCodeContext#METHOD_ITEM_SEPARATOR}.
	 * 
	 * @author jayant
	 * 
	 * @param context
	 *            the {@link ActionCodeContext} object contain the context of
	 *            content assist invocation
	 * @return the collection of proposals for method completion
	 */
	private Collection<ICompletionProposal> collectMethodProposals(
			ActionCodeContext context) {
		Assert.isNotNull(fConfiguration);

		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
		InterfaceItem interfaceItem = context.computeInterfaceItem();
		if (interfaceItem != null) {
			for (String item : fConfiguration.getActionCodeParser()
					.getInterfaceItemMethods(interfaceItem)) {
				ICompletionProposal proposal = createPrefixCompletionProposal(
						context, item, Activator.getImage("icons/method.gif"));
				if (proposal != null)
					proposals.add(proposal);
			}
		}
		return proposals;
	}

	/**
	 * Collect the proposals for member name completion.
	 * 
	 * @author jayant
	 * 
	 * @param context
	 *            the {@link ActionCodeContext} object contain the context of
	 *            content assist invocation
	 * @return the collection of proposals for member name completion
	 */
	private Collection<ICompletionProposal> collectMemberProposals(
			ActionCodeContext context) {
		Assert.isNotNull(fConfiguration);

		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();
		for (String item : fConfiguration.getActionCodeParser()
				.getAllMemberNames()) {
			ICompletionProposal proposal = createPrefixCompletionProposal(
					context, item, Activator.getImage("icons/member.gif"));
			if (proposal != null)
				proposals.add(proposal);
		}
		return proposals;
	}

	/**
	 * Collect the proposals for Interface Item name completion.
	 * 
	 * @author jayant
	 * 
	 * @param context
	 *            the {@link ActionCodeContext} object contain the context of
	 *            content assist invocation
	 * @return the collection of proposals for Interface Item name completion.
	 */
	private Collection<ICompletionProposal> collectInterfaceItemProposals(
			ActionCodeContext context) {
		Assert.isNotNull(fConfiguration);

		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

		for (String item : fConfiguration.getActionCodeParser()
				.getAllInterfaceItemNamesWithIndex()) {
			ICompletionProposal proposal = createPrefixCompletionProposal(
					context, item, Activator.getImage("icons/interfaceitem.gif"));
			if (proposal != null)
				proposals.add(proposal);
		}
		return proposals;
	}

	/**
	 * Utility method for creating proposals given {@code context} and the
	 * possible completion string. The proposal is generated only if the
	 * character sequence to be completed is a prefix of the {@code completion}
	 * string.
	 * 
	 * @author jayant
	 * 
	 * @param context
	 *            the {@link ActionCodeContext} object contain the context of
	 *            content assist invocation
	 * @param completion
	 *            the completion string
	 * @return completion proposal
	 */
	private static ICompletionProposal createPrefixCompletionProposal(
			ActionCodeContext context, String completion, Image img) {

		String prefix = context.getPrefix();
		if (completion.startsWith(prefix))
			// replaces the incomplete prefix + selected range with the
			// completion string
			return new CompletionProposal(completion,
					context.getInvocationOffset() - prefix.length(),
					prefix.length() + context.getViewer().getSelectedRange().y,
					completion.length(),
					img,
					null, null, null);

		return null;
	}
}