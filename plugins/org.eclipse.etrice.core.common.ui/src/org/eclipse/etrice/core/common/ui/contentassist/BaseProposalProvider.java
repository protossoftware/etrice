/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;

import com.google.common.base.Function;

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
	
	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(String ruleName,
			ContentAssistContext contentAssistContext) {
		// Proposal creator that always proposes unqualified names
		return new DefaultProposalCreator(contentAssistContext, ruleName, new IQualifiedNameConverter() {
			@Override
			public String toString(QualifiedName name) {
				// The converted string contains only the last segment of the qualified name
				if(!name.isEmpty()) {
					return name.getLastSegment();
				}
				return "";
			}
			
			@Override
			public QualifiedName toQualifiedName(String qualifiedNameAsText) {
				return getQualifiedNameConverter().toQualifiedName(qualifiedNameAsText);
			}
		});
	}
	
}
