/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.dialogs;

import java.util.ArrayList;

import org.eclipse.etrice.core.common.ui.contentassist.FQNLastSegmentFinder;
import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;

public class FilteredContentProposalProvider implements IContentProposalProvider {
	
	private String[] proposals;	
	private FQNPrefixMatcher matcher;
	
	public FilteredContentProposalProvider(String... proposals) {
		this.proposals = proposals;
		this.matcher = new FQNPrefixMatcher();
		this.matcher.setDelegate(new PrefixMatcher.IgnoreCase());
		this.matcher.setLastSegmentFinder(new FQNLastSegmentFinder());
	}
	
	@Override
	public IContentProposal[] getProposals(String contents, int position) {
		ArrayList<ContentProposal> list = new ArrayList<>();
		for (String proposal : proposals) {
			if (matcher.isCandidateMatchingPrefix(proposal, contents)) {
				list.add(new ContentProposal(proposal));
			}
		}
		return list.toArray(new IContentProposal[list.size()]);
	}
}
