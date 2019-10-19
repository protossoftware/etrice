/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ui.editor;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISaveablePart2;

/**
 * Replacement for save dialog of platform. Provides access to user choice.
 */
public class SaveDialogEditor {
	
	private int lastResult = ISaveablePart2.CANCEL;
	
	public int open(Shell shell, String name) {
		// dialog mimic from SaveablesList in platform
		String[] buttons = new String[] { "&Save", "Do&n't Save", "Cancel" };
		String message = "Save changes in '"+ name + "'?";
		MessageDialog dialog = new MessageDialog(shell, "Save Resource", null, message, MessageDialog.QUESTION, 0, buttons) {
			@Override
			protected int getShellStyle() {
				return SWT.CLOSE | SWT.TITLE | SWT.BORDER | SWT.APPLICATION_MODAL | SWT.SHEET | getDefaultOrientation();
			}
		};
		
		lastResult = dialog.open();
		if(lastResult != ISaveablePart2.YES && lastResult != ISaveablePart2.NO) {
			// treat all other options as cancel
			lastResult = ISaveablePart2.CANCEL;
		}
		
		return lastResult;
	}
	
	public int getResult() {
		return lastResult;
	}
	
	public void reset() {
		lastResult = ISaveablePart2.CANCEL;
	}
}
