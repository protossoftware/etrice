package org.eclipse.etrice.core.ui.quickfix;

import java.util.List;

import org.eclipse.xtext.ui.editor.quickfix.IssueResolution;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;

public interface IRoomQuickfixProvider {

	void getResolution(final Issue issue, IssueResolutionAcceptor acceptor);
}
