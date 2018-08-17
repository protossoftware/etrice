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
public class SaveOnFocusLostListener implements IPartListener/*, CommandStackListener*/ {

	private final IEditorPart editor;
	private final IPreferenceStore store;
	
	private boolean isActive = true;
	
	@SuppressWarnings("unused")
	private boolean saveAfterCurrentCommand = false;

	public SaveOnFocusLostListener(IEditorPart editor) {
		this.editor = editor;
		this.store = UIBaseActivator.getDefault().getPreferenceStore();
		//editor.getEditingDomain().getCommandStack().addCommandStackListener(this);
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
		if(part != editor)
			return;
		
		boolean isSaveOnFocus = store.getBoolean(UIBasePreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST);
		if (isActive && isSaveOnFocus && editor.isDirty()) {
//			if (editor.getEditingDomain() instanceof TransactionalEditingDomainImpl) {
//				TransactionalEditingDomainImpl ted = (TransactionalEditingDomainImpl) editor.getEditingDomain();
//				if (ted.getActiveTransaction()!=null) {
//					// avoid to run into dead-lock
//					saveAfterCurrentCommand = true;
//					return;
//				}
//			}
			editor.doSave(new NullProgressMonitor());
		}
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
	}

//	@Override
//	public void commandStackChanged(EventObject event) {
//		
//		if (saveAfterCurrentCommand) {
//			saveAfterCurrentCommand = false;
//			editor.doSave(new NullProgressMonitor());
//		}
//	}
	
	public void setActive(boolean isActive){
		this.isActive = isActive;
	}

}
