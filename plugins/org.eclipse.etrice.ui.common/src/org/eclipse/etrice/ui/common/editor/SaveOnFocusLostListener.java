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

import java.util.EventObject;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
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
public class SaveOnFocusLostListener implements IPartListener, CommandStackListener {

	private DiagramEditor editor;
	private IPreferenceStore store;
	private boolean saveAfterCurrentCommand = false;

	public SaveOnFocusLostListener(DiagramEditor editor) {
		this.editor = editor;
		this.store = Activator.getDefault().getPreferenceStore();
		editor.getEditingDomain().getCommandStack().addCommandStackListener(this);
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
	@Override
	public void partDeactivated(IWorkbenchPart part) {
		boolean save = store.getBoolean(PreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST);
		if (save && editor.isDirty()) {
			if (editor.getEditingDomain() instanceof TransactionalEditingDomainImpl) {
				TransactionalEditingDomainImpl ted = (TransactionalEditingDomainImpl) editor.getEditingDomain();
				if (ted.getActiveTransaction()!=null) {
					// avoid to run into dead-lock
					saveAfterCurrentCommand = true;
					return;
				}
			}
			editor.doSave(new NullProgressMonitor());
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void partOpened(IWorkbenchPart part) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.CommandStackListener#commandStackChanged(java.util.EventObject)
	 */
	@Override
	public void commandStackChanged(EventObject event) {
		
		if (saveAfterCurrentCommand) {
			saveAfterCurrentCommand = false;
			editor.doSave(new NullProgressMonitor());
		}
	}

}
