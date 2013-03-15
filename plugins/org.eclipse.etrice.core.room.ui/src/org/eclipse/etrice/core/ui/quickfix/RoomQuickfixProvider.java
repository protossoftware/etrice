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

import org.eclipse.etrice.core.validation.RoomJavaValidator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class RoomQuickfixProvider extends DefaultQuickfixProvider {

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
	
	@Fix(RoomJavaValidator.THREAD_MISSING)
	public void fixMissingThread(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add a default thread", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				int offset = issue.getOffset()+issue.getLength()-1;
				String insertion = "\n\t\t"+issue.getData()[0]+"\n\t";
				xtextDocument.replace(offset, 0, insertion);
			}
		});
	}

	@Fix(RoomJavaValidator.DUPLICATE_ACTOR_INSTANCE_MAPPING)
	public void removeDuplicateThreadMapping(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove duplicate mapping", "remove this mapping", "remove.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}
	
	@Fix(RoomJavaValidator.WRONG_NAMESPACE)
	public void fixWrongNamespace(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace with correct namespace", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String replacement = issue.getData()[0];
				xtextDocument.replace(issue.getOffset(), issue.getLength(), replacement);
			}
		});
	}
	
	@Fix(RoomJavaValidator.CIRCULAR_CONTAINMENT)
	public void fixCircularContainment(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make attribute a reference", "add 'ref' keyword", "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				int offset = Integer.parseInt(issue.getData()[0]);
				xtextDocument.replace(issue.getOffset()+offset, 0, " ref");
			}
		});
	}
}
