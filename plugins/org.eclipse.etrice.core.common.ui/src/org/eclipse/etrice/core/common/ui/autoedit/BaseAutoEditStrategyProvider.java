package org.eclipse.etrice.core.common.ui.autoedit;

import org.eclipse.etrice.core.common.ui.editor.model.BaseTokenTypeToPartitionMapper;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class BaseAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		acceptor.accept(defaultIndentLineAutoEditStrategy.get(), BaseTokenTypeToPartitionMapper.STRING_LITERAL_PARTITION);
		super.configureIndentationEditStrategy(acceptor);
	}
	
	@Override
	protected void configureStringLiteral(IEditStrategyAcceptor acceptor) {
		acceptor.accept(partitionInsert.newInstance("'''", "'''"), IDocument.DEFAULT_CONTENT_TYPE);
		super.configureStringLiteral(acceptor);
	}
}
