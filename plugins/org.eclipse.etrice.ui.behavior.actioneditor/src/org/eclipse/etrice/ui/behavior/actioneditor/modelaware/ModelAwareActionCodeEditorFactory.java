/*******************************************************************************
 * Copyright (c) 2014 Jayant Gupta
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jayant Gupta (initial contribution)
 *
 *
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.actioneditor.modelaware;

import java.util.List;

import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.AbstractActionCodeEditor;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.SourceViewerActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditorFactory;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Lists;

/**
 * Factory for creation of {@link ModelAwareActionCodeEditor}.
 * 
 * @author jayant
 */
public class ModelAwareActionCodeEditorFactory implements IActionCodeEditorFactory {

	List<AbstractActionCodeEditor> constructedEditors = Lists.newArrayList();

	@Override
	public IActionCodeEditor createActionCodeEditor(Composite parent, String detailCode,
			IDetailExpressionProvider exprProvider) {
		SourceViewerActionCodeEditor javaActionCodeEditor = new ModelAwareActionCodeEditor(exprProvider);
		javaActionCodeEditor.init(detailCode);
		javaActionCodeEditor.createControl(parent);
		
		constructedEditors.add(javaActionCodeEditor);
		
		return javaActionCodeEditor;
	}

	@Override
	public void dispose() {
		for (AbstractActionCodeEditor constructedEditor : constructedEditors) {
			constructedEditor.dispose();
		}
		constructedEditors.clear();
	}

}