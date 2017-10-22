/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.text;

import java.util.ArrayList;

import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditorFactory;
import org.eclipse.swt.widgets.Composite;

/**
 * Factory for creation of {@link TextActionCodeEditor}.
 * 
 * @author jayant
 */
public class TextActionCodeEditorFactory implements IActionCodeEditorFactory {

	/** List of constructed editors */
	ArrayList<TextActionCodeEditor> constructedEditors = new ArrayList<TextActionCodeEditor>();

	@Override
	public IActionCodeEditor createActionCodeEditor(Composite parent, String detailCode, IDetailExpressionProvider exprProvider) {
		TextActionCodeEditor textActionCodeEditor = new TextActionCodeEditor();
		textActionCodeEditor.createControl(parent);
		textActionCodeEditor.init(detailCode);
		constructedEditors.add(textActionCodeEditor);
		
		return textActionCodeEditor;
	}

	@Override
	public void dispose() {
		for (TextActionCodeEditor constructedEditor : constructedEditors) {
			constructedEditor.dispose();
		}
		constructedEditors.clear();
	}

	
}