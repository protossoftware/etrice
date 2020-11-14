/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.etmap.ui.quickfix;

import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.etrice.core.etmap.validation.ETMapValidator;
import org.eclipse.jface.text.BadLocationException;

public class ETMapQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(ETMapValidator.DUPLICATE_SUBSYS_MAPPING)
	public void removeDuplicateSubSysMapping(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove duplicate", "remove this mapping", "remove.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}

	@Fix(ETMapValidator.UNMAPPED_SUBSYS_REFS)
	public void addMissingSubSysMappings(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add missing mappings", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				int offset = issue.getOffset()+issue.getLength();
				String insertion = "\n"+issue.getData()[0];
				if (issue.getData()[1].equals(ETMapValidator.EMPTY)) {
					--offset;
					insertion += "\t\t";
				}
				xtextDocument.replace(offset, 0, insertion);
			}
		});
	}

	@Fix(ETMapValidator.DUPLICATE_THREAD_MAPPING)
	public void removeDuplicateThreadMapping(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove duplicate", "remove this mapping", "remove.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				xtextDocument.replace(issue.getOffset(), issue.getLength(), "");
			}
		});
	}

	@Fix(ETMapValidator.UNMAPPED_THREAD_REFS)
	public void addMissingThreadMappings(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add mappings", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				int offset = issue.getOffset()+issue.getLength();
				String insertion = "\n"+issue.getData()[0];
				if (issue.getData()[1].equals(ETMapValidator.EMPTY)) {
					--offset;
					insertion += "\t\t";
				}
				xtextDocument.replace(offset, 0, insertion);
			}
		});
	}
	
	@Fix(ETMapValidator.WRONG_NAMESPACE)
	public void fixWrongNamespace(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Replace with correct namespace", issue.getData()[0], "add.gif", new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
				String replacement = issue.getData()[0];
				xtextDocument.replace(issue.getOffset(), issue.getLength(), replacement);
			}
		});
	}
}
