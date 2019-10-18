/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.common.base.editor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.etrice.core.common.ui.editor.ISaveOnFocusLostEditor;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class SaveOnFocusLostListener implements IPartListener {

	private final IEditorPart editor;
	private final IPreferenceStore store;
	
	private boolean isActive = true;
	
	@SuppressWarnings("unused")
	private boolean saveAfterCurrentCommand = false;

	public SaveOnFocusLostListener(IEditorPart editor) {
		this.editor = editor;
		this.store = UIBaseActivator.getDefault().getPreferenceStore();
		editor.getSite().getPage().addPartListener(this);
	}

	@Override
	public void partActivated(IWorkbenchPart part) {
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		if(part != editor)
			return;
		
		setActive(false);
		part.getSite().getPage().removePartListener(this);
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {	
		if (part != editor)
			return;
		
		if (part instanceof ISaveOnFocusLostEditor) {
			if (((ISaveOnFocusLostEditor) part).isClosing()) {
				return;
			}
		}
		
		boolean isSaveOnFocus = store.getBoolean(UIBasePreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST);
		if (isActive && isSaveOnFocus && editor.isDirty()) {
			editor.doSave(new NullProgressMonitor());
		}
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
	}
	
	public void setActive(boolean isActive){
		this.isActive = isActive;
	}

}
