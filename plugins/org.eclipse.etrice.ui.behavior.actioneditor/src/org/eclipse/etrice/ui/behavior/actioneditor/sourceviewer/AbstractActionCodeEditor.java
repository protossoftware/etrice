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

package org.eclipse.etrice.ui.behavior.actioneditor.sourceviewer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.etrice.core.fsm.fSM.DetailCode;
import org.eclipse.etrice.ui.behavior.fsm.actioneditor.IActionCodeEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * Abstract implementation of the {@link IActionCodeEditor} interface. Clients
 * need to implement the following methods:
 * <ul>
 * <li> {@link #init(String)}</li>
 * <li> {@link #createControl(Composite)}</li>
 * <li> {@link #getControl()}</li>
 * <li> {@link #insertText(String)}</li>
 * </ul>
 * 
 * The lifecycle of the editor requires {@code init} method to be called before
 * the {@code createControl} method.
 * 
 * @author jayant
 */
public abstract class AbstractActionCodeEditor implements IActionCodeEditor {

	/**
	 * Intializes the editor with the given {@link DetailCode} object. This
	 * method must be called before the {@link #createControl(Composite)} method
	 * in the editor lifecycle.
	 * 
	 * @param detailCode
	 *            the {@code DetailCode} object for initializing the editor
	 * @throws CoreException
	 *             if the editor cannot be initialized with the given
	 *             {@code DetailCode} object
	 */
	public abstract void init(String detailCode);

	/**
	 * Creates the controls of the editor within the {@code parent}
	 * {@link Composite}.
	 * 
	 * @param parent
	 */
	public abstract void createControl(Composite parent);
	
	/**
	 * Disposes all the resources allocate by the editor.
	 */
	public abstract void dispose();
	

}