/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.editor;

import org.eclipse.etrice.core.common.ui.editor.SaveOnFocusLostXtextEditor;
import org.eclipse.help.IContextProvider;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RoomEditor extends SaveOnFocusLostXtextEditor {
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (IContextProvider.class.isAssignableFrom(adapter)) {
			return adapter.cast(new SelectedModelHelpProvider(this));
		}
		return super.getAdapter(adapter);

	}

}
