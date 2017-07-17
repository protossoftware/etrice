package org.eclipse.etrice.core.common.ui.highlight;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class BaseHighlightingConfig extends DefaultHighlightingConfiguration {

	public static final String HL_CCSTRING = "ccstring";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);

		acceptor.acceptDefaultHighlighting(HL_CCSTRING, "CCString", detailCodeStringStyle());
	}

	public TextStyle detailCodeStringStyle() {
		TextStyle textStyle = stringTextStyle().copy();
		textStyle.setBackgroundColor(new RGB(220, 220, 220));
		return textStyle;
	}
}
