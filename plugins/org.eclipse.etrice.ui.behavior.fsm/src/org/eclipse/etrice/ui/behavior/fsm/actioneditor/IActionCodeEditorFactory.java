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

package org.eclipse.etrice.ui.behavior.fsm.actioneditor;

import org.eclipse.etrice.ui.behavior.fsm.detailcode.IDetailExpressionProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * Factory Interface for Action Code Editor Factories.
 * 
 * @author jayant
 */
public interface IActionCodeEditorFactory {

	/**
	 * Create a new instance of an implementation of the
	 * {@link IActionCodeEditor} with given configuration parameters.
	 * 
	 * @param parent
	 *            the {@link Composite} which will hold the editor
	 * @return the created instance of the action code editor.
	 */
	IActionCodeEditor createActionCodeEditor(Composite parent, String detailCode, IDetailExpressionProvider exprProvider);

	/**
	 * Disposes all the resources allocate by the factory.
	 */
	public void dispose();
}