/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 		Jayant Gupta (Added Fix methods)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.quickfix;

import org.eclipse.etrice.abstractexec.behavior.AbstractExecutionValidator;
import org.eclipse.etrice.abstractexec.behavior.ReachabilityValidator;
import org.eclipse.etrice.ui.common.quickfix.AbstractQuickfixProvider;
import org.eclipse.etrice.ui.common.quickfix.IDiagramModification;
import org.eclipse.etrice.ui.common.quickfix.IssueResolutionAcceptor;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

/**
 * @author Henrik Rentz-Reichert
 * @author jayant
 * 
 */
public class BehaviorQuickfixProvider extends AbstractQuickfixProvider {

	private static final String ADD_IMG = "icons/quickfix/add.gif";

	@Fix(AbstractExecutionValidator.DIAG_CODE_MISSING_TRIGGER)
	public void fixMissingTrigger(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(
				issue,
				"Add the missing trigger",
				"Adds a new transition with trigger to handle message "
						+ issue.getIssueData()[2] + " from port "
						+ issue.getIssueData()[3], ADD_IMG,
				new IDiagramModification() {

					@Override
					public void apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// make a new transition & add a Trigger to handle
						// message
					}
				});
	}

	@Fix(AbstractExecutionValidator.DIAG_CODE_MISSING_MESSAGESEND)
	public void fixMissingMessageSend(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(
				issue,
				"Send message " + issue.getIssueData()[2] + " to port "
						+ issue.getIssueData()[3],
				"Adds a new transition with sends message "
						+ issue.getIssueData()[2] + " to port "
						+ issue.getIssueData()[3], ADD_IMG,
				new IDiagramModification() {

					@Override
					public void apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// make a new transition & send the message to the port

					}

				});
	}

	@Fix(AbstractExecutionValidator.DIAG_CODE_VIOLATION_TRIGGER)
	public void fixViolationTrigger(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change Trigger", "Changes the trigger",
				ADD_IMG, new IDiagramModification() {
					@Override
					public void apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// modify diagram using features and issue data...

					}

				});
	}

	@Fix(AbstractExecutionValidator.DIAG_CODE_VIOLATION_MESSAGESEND)
	public void fixViolationMessageSend(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Change Sent Message",
				"Changes the sent message", ADD_IMG,
				new IDiagramModification() {

					@Override
					public void apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// modify diagram using features and issue data...

					}

				});
	}

	@Fix(ReachabilityValidator.DIAG_CODE_UNREACHABLE)
	public void fixUnreachable(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue,
				"Add Transition from XYZ to " + issue.getIssueData()[0],
				"Adds Transition from XYZ to " + issue.getIssueData()[0],
				ADD_IMG, new IDiagramModification() {

					@Override
					public void apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// Add the transition

					}

				});
	}

	@Fix(ReachabilityValidator.DIAG_CODE_UNREACHABLE)
	public void fixUnreachable2(final FeatureBasedDiagnostic issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue,
				"Add Transition from ABC to " + issue.getIssueData()[0],
				"Adds Transition from ABC to " + issue.getIssueData()[0],
				ADD_IMG, new IDiagramModification() {

					@Override
					public void apply(Diagram diagram, IFeatureProvider fp)
							throws Exception {
						// Add the transition

					}

				});
	}
}
