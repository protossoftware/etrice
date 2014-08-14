/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * Class used to initialize default preference values.
 */
public class UIBasePreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = UIBaseActivator.getDefault().getPreferenceStore();
		store.setDefault(UIBasePreferenceConstants.USE_GRID, true);
		store.setDefault(UIBasePreferenceConstants.SNAP_TO_GRID, false);
		store.setDefault(UIBasePreferenceConstants.HOR_GRID_UNIT, 10);
		store.setDefault(UIBasePreferenceConstants.VER_GRID_UNIT, 10);
		store.setDefault(UIBasePreferenceConstants.CONFIRM_DELETE, true);
		store.setDefault(UIBasePreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST, false);
		store.setDefault(UIBasePreferenceConstants.EXPORT_DIAGRAM_PATH, "doc-gen/images");
		store.setDefault(UIBasePreferenceConstants.EXPORT_DIAGRAM_PATH_RELATIVE_TO, UIBasePreferenceConstants.PATH_REL_TO_PROJECT);
		store.setDefault(UIBasePreferenceConstants.EXPORT_DIAGRAM_FORMAT, UIBasePreferenceConstants.FORMAT_JPG);
		store.setDefault(UIBasePreferenceConstants.MAX_LABEL_LINE_LENGTH, UIBasePreferenceConstants.MAX_LINE_LENGTH_DEFAULT);
		store.setDefault(UIBasePreferenceConstants.MAX_LABEL_LINES, UIBasePreferenceConstants.MAX_LINES_DEFAULT);
	}

}
