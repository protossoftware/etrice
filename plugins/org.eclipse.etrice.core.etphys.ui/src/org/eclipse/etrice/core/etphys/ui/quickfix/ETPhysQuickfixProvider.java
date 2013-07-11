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

package org.eclipse.etrice.core.etphys.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalThread;
import org.eclipse.etrice.core.etphys.validation.ETPhysJavaValidator;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.validation.Issue;

public class ETPhysQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(ETPhysJavaValidator.ADD_TIME_INTERVAL)
	public void addTimeInterval(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add time interval of 10ms", "interval = 10ms", "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				PhysicalThread pt = (PhysicalThread) element;
				pt.setTime(10000000);
			}
		});
	}

	@Fix(ETPhysJavaValidator.REMOVE_TIME_INTERVAL)
	public void removeTimeInterval(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove time interval", "[interval = ...]", "add.gif", new ISemanticModification() {
			@Override
			public void apply(EObject element, IModificationContext context) throws Exception {
				PhysicalThread pt = (PhysicalThread) element;
				
				/* made this attribute unsettable - but unsetting and deserializing
				 * doesn't give the desired result (removing the 'interval = ...' totally)
				 * but rather sets the time to 0
				 */
				pt.unsetTime();
			}
		});
	}

}
