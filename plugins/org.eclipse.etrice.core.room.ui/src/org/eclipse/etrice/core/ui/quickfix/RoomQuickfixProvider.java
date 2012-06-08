/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.quickfix;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class RoomQuickfixProvider extends DefaultQuickfixProvider {

//	@Fix(MyJavaValidator.INVALID_TYPE_NAME)
//	public void capitalizeName(final Issue issue, IssueResolutionAcceptor acceptor) {
//		acceptor.accept(issue, "Capitalize name", "Capitalize name of type", "upcase.png", new IModification() {
//			public void apply(IModificationContext context) throws BadLocationException {
//				IXtextDocument xtextDocument = context.getXtextDocument();
//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
//				xtextDocument.replace(issue.getOffset(), 1, Strings.toFirstUpper(firstLetter));
//			}
//		});
//	}

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		List<IssueResolution> result = new ArrayList<IssueResolution>();
		
		result.addAll(super.getResolutions(issue));
		
		IssueResolutionAcceptor acceptor = getIssueResolutionAcceptorProvider().get();
		QuickfixExtensionManager.getInstance().getResolutions(issue, acceptor);
		
		result.addAll(acceptor.getIssueResolutions());
		
		return result;
	}
	
	@Override
		public boolean hasResolutionFor(String issueCode) {
			return super.hasResolutionFor(issueCode) || QuickfixExtensionManager.getInstance().hasResolutionFor(issueCode);
		}
}
