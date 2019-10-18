/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/
package org.eclipse.etrice.core.common.ui.editor;

import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class SaveOnFocusLostXtextEditor extends XtextEditor implements ISaveOnFocusLostEditor {

	private boolean isClosing = false;

	@Override
	public int promptToSaveOnClose() {
		isClosing   = true;
		return DEFAULT;
	}

	@Override
	public boolean isClosing() {
		return isClosing;
	}
}
