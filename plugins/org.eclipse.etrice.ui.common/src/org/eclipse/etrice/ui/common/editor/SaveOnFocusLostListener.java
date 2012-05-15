/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.etrice.ui.common.Activator;
import org.eclipse.etrice.ui.common.preferences.PreferenceConstants;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class SaveOnFocusLostListener implements IPartListener {

	private DiagramEditor editor;
	private IPreferenceStore store;

	public SaveOnFocusLostListener(DiagramEditor editor) {
		this.editor = editor;
		this.store = Activator.getDefault().getPreferenceStore();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void partActivated(IWorkbenchPart part) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void partClosed(IWorkbenchPart part) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
	 */
	@SuppressWarnings("restriction")
	@Override
	public void partDeactivated(IWorkbenchPart part) {
		boolean save = store.getBoolean(PreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST);
		if (save && editor.isDirty())
			editor.doSave(new NullProgressMonitor());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void partOpened(IWorkbenchPart part) {
	}

}
