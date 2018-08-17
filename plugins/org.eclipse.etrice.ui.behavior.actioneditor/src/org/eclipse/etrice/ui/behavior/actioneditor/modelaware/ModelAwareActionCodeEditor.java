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

import org.eclipse.etrice.expressions.detailcode.IDetailExpressionProvider;
import org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer.SourceViewerActionCodeEditor;

/**
 * An extension of the {@link SourceViewerActionCodeEditor} which configures it
 * with a model aware configuration with general language features.
 * 
 * @author jayant
 */
public class ModelAwareActionCodeEditor extends SourceViewerActionCodeEditor {

	public ModelAwareActionCodeEditor(IDetailExpressionProvider exprProvider) {
		super();
		setSourceViewerConfiguration(new ModelAwareActionCodeEditorConfiguration(exprProvider));
	}
}