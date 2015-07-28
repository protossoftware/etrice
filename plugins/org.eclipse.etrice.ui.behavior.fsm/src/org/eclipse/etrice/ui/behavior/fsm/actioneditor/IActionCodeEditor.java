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

import org.eclipse.swt.widgets.Control;

/**
 * This interface need to be implemented by all editors which allow editing
 * Action Code present inside eTrice behavior diagrams.
 * 
 * @author jayant
 */
public interface IActionCodeEditor {

	/**
	 * Getter for the editor {@link Control} representing the Action Code.
	 * 
	 * @return the Control within the editor
	 */
	Control getControl();

	/**
	 * Inserts the given {@code text} String in the editor's control replacing
	 * the selected range.
	 * 
	 * @param text
	 *            The String to be inserted
	 */
	void insertText(String text);
}