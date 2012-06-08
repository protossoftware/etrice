/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.abstractexec.behavior;

import org.eclipse.etrice.core.ui.quickfix.IRoomQuickfixProvider;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public class DemoQuickfix implements IRoomQuickfixProvider {

	public DemoQuickfix() {
	}

	@Override
	public void getResolution(final Issue issue, IssueResolutionAcceptor acceptor) {
		// 3rd arg is image, check ImageHelper how this could work
			acceptor.accept(issue, issue.getData()[0]+"_ac", "change actor class name to "+issue.getData()[0]+"_ac", null, new IModification() {
			public void apply(IModificationContext context) throws BadLocationException {
				IXtextDocument xtextDocument = context.getXtextDocument();
//				String firstLetter = xtextDocument.get(issue.getOffset(), 1);
				xtextDocument.replace(issue.getOffset()+issue.getData()[0].length(), 0, "_ac");
			}
		});
	}

}
