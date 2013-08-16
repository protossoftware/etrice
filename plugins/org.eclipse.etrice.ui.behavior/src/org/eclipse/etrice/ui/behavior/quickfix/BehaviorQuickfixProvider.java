/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.quickfix;

import org.eclipse.etrice.ui.common.quickfix.AbstractQuickfixProvider;
import org.eclipse.etrice.ui.common.quickfix.IDiagramModification;
import org.eclipse.etrice.ui.common.quickfix.IssueResolutionAcceptor;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.validation.Issue;


/**
 * @author Henrik Rentz-Reichert
 *
 */
public class BehaviorQuickfixProvider extends AbstractQuickfixProvider {

	@Fix("SomeIssue")
	public void fixSomeIssue(final Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "my label", "my description", "image.gif", new IDiagramModification() {

			@Override
			public void apply(Diagram diagram, IFeatureProvider fp) throws Exception {
				// modify diagram using features and issue data...
			}
			
		});
	}
}
