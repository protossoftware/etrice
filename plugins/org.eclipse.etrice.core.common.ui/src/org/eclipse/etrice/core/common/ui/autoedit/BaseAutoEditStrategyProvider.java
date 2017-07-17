package org.eclipse.etrice.core.common.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class BaseAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("'''", "'''"), IDocument.DEFAULT_CONTENT_TYPE);
		super.configureStringLiteral(acceptor);
	}
}
