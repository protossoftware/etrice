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

import static org.eclipse.etrice.ui.common.base.UIBaseActivator.PLUGIN_ID;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.etrice.core.common.ui.editor.ISaveOnFocusLostEditor;
import org.eclipse.etrice.ui.common.base.preferences.UIBasePreferenceConstants;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * Global listener in workbench for {@link ISaveOnFocusLostEditor }.
 */
public class SaveOnFocusLostListener implements IPartListener, IStartup {
		
	@Override
	public void earlyStartup() {
		PlatformUI.getWorkbench().getDisplay().asyncExec(() -> {
			IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			IPartService partService = (window != null) ? window.getPartService() : null;
			if(partService != null) {
				partService.addPartListener(this);
			} else {
				Status status = new Status(Status.ERROR, PLUGIN_ID, "Failed to register " + getClass().getSimpleName());
				StatusManager.getManager().handle(status);
			}
			
		});
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
		if (part instanceof ISaveOnFocusLostEditor) {
			ISaveOnFocusLostEditor editor = (ISaveOnFocusLostEditor) part;
			boolean isPrefSave = Platform.getPreferencesService().getBoolean("org.eclipse.etrice.ui.common.base",
					UIBasePreferenceConstants.SAVE_DIAG_ON_FOCUS_LOST, false, null);
			if(isPrefSave && editor.shouldSaveOnFocusLost()) {
				editor.doSave(new NullProgressMonitor());
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
	 */
	@Override
	public void partOpened(IWorkbenchPart part) {
	}

}
