/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.highlight;

import org.eclipse.etrice.core.common.ui.highlight.BaseHighlightingConfig;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * @author Henrik Rentz-Reichert
 * 
 */
public class RoomHighlightingConfiguration extends BaseHighlightingConfig {

	// provide an id string for the highlighting calculator
	public static final String HL_ANNOTATION_ID = "hl_annotation";

	// default fonts used by this specific highlighting (defaults)
	// private static FontData defaultAnnotationBlockFont = new
	// FontData("Courier New", 12);

	// configure the acceptor providing the id, the description string
	// that will appear in the preference page and the initial text style
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(HL_ANNOTATION_ID, "Annotation", typeAnnotationBlock());
	}

	// method for calculating an actual text styles
	public TextStyle typeAnnotationBlock() {
		TextStyle textStyle = new TextStyle();
		// textStyle.setBackgroundColor(new RGB(155, 55, 255));
		textStyle.setColor(new RGB(160, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		// textStyle.setFontData(defaultCommentFont);
		return textStyle;
	}

}
