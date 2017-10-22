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
import org.eclipse.etrice.expressions.ui.highlight.AbstractHighlightStyles;
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
	public static final String HL_EXPR_SPECIAL_FEATURE_ID = "hl_expr_specialfeature";
	public static final String HL_EXPR_OPERATION_ID = "hl_expr_operation";
	public static final String HL_EXPR_ATTRIBUTE_ID = "hl_expr_attribute";
	public static final String HL_EXPR_INTERFACE_ITEM_ID = "hl_expr_interfaceitem";

	// default fonts used by this specific highlighting (defaults)
	// private static FontData defaultAnnotationBlockFont = new
	// FontData("Courier New", 12);

	// configure the acceptor providing the id, the description string
	// that will appear in the preference page and the initial text style
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(HL_ANNOTATION_ID, "Annotation", typeAnnotationBlock());
		acceptor.acceptDefaultHighlighting(HL_EXPR_SPECIAL_FEATURE_ID, "Expression Special Feature", expressionSpecialFeature());
		acceptor.acceptDefaultHighlighting(HL_EXPR_OPERATION_ID, "Expression Operation", expressionOperation());
		acceptor.acceptDefaultHighlighting(HL_EXPR_ATTRIBUTE_ID, "Expression Attribute", expressionAttribute());
		acceptor.acceptDefaultHighlighting(HL_EXPR_INTERFACE_ITEM_ID, "Expression Interface Item", expressionInterfaceItem());
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
	
	public TextStyle expressionSpecialFeature() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(AbstractHighlightStyles.SPECIAL_FEATURE_RGB);
		return textStyle;
	}
	
	public TextStyle expressionOperation() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(AbstractHighlightStyles.OPERATION_RGB);
		return textStyle;
	}
	
	public TextStyle expressionAttribute() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(AbstractHighlightStyles.ATTRIBUTE_RGB);
		return textStyle;
	}
	
	public TextStyle expressionInterfaceItem() {
		TextStyle textStyle = new TextStyle();
		textStyle.setColor(AbstractHighlightStyles.INTERFACE_ITEM_RGB);
		return textStyle;
	}

}
