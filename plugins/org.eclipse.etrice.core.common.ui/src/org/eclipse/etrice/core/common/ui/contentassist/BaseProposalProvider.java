/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Eyrak Paen (initial contribution)
 * 		Juergen Haug
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.common.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

/**
 * see http://www.eclipse.org/Xtext/documentation.html#contentAssist on how to
 * customize content assistant
 */
public class BaseProposalProvider extends org.eclipse.etrice.core.common.ui.contentassist.AbstractBaseProposalProvider {

	@Override
	public void complete_TIME(EObject model, RuleCall ruleCall, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		ICompletionProposal[] proposals = new ICompletionProposal[] {
				createCompletionProposal("  ns", "nano seconds - TIME", null, context),
				createCompletionProposal("  us", "micro seconds - TIME", null, context),
				createCompletionProposal("  ms", "milli seconds - TIME", null, context),
				createCompletionProposal("  s", "seconds - TIME", null, context) };
		for (ICompletionProposal proposal : proposals) {
			if (proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
				configurable.setSelectionStart(configurable.getReplacementOffset());
				configurable.setSelectionLength(1);
				configurable.setAutoInsertable(false);
				// configurable.setSimpleLinkedMode(context.getViewer(),
				// proposalText.charAt(0), '\t');
			}
			acceptor.accept(proposal);
		}
		super.complete_TIME(model, ruleCall, context, acceptor);
	}
}
