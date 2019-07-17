/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.highlight;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class BaseHighlightingConfig extends DefaultHighlightingConfiguration {

	/** Annotations */
	public static final String HL_ANNOTATION_ID = "hl_annotation";
	/** Smart strings */
	public static final String HL_CCSTRING = "ccstring";
	/** Comments that are treated as documentation */
	public static final String HL_DOCUMENTATION = "documentation";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);

		acceptor.acceptDefaultHighlighting(HL_ANNOTATION_ID, "Annotation", typeAnnotationBlock());
		acceptor.acceptDefaultHighlighting(HL_CCSTRING, "CCString", detailCodeStringStyle());
		acceptor.acceptDefaultHighlighting(HL_DOCUMENTATION, "Documentation", documentationStyle());
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

	public TextStyle detailCodeStringStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setBackgroundColor(new RGB(220, 220, 220));
		return textStyle;
	}
	
	public TextStyle documentationStyle() {
		TextStyle textStyle = commentTextStyle().copy();
		textStyle.setColor(new RGB(62, 87, 118));
		return textStyle;
	}
}
