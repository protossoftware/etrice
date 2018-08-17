/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.common.base.support;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.change.ChangeDescription;
import org.eclipse.emf.ecore.change.util.BasicChangeRecorder;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.etrice.ui.common.base.UIBaseActivator;
import org.eclipse.ui.statushandlers.StatusManager;

public class ResourceChangeRecorder {

	private static final String DEBUG_OPTION_RCR = "org.eclipse.etrice.ui.common.base/trace/ResourceChangeRecorder";
	
	private static boolean isDebugging(){
		return UIBaseActivator.getDefault().isDebugging()
				&& Boolean.valueOf(Platform.getDebugOption(DEBUG_OPTION_RCR));
	}
	
	// static debugging
	private static final boolean DEBUG;
	static {
		DEBUG = isDebugging();
	}

	private Resource resource;
	private boolean wasResourceModifiedBefore;
	private BasicChangeRecorder changeRecorder;

	private boolean result_resourceChanged = false;

	public ResourceChangeRecorder(Resource resource) {
		this.resource = resource;

		// start recording
		this.wasResourceModifiedBefore = resource.isModified();
		this.changeRecorder = new ChangeRecorder(resource);
	}

	public void endRecording(boolean doReverse) {
		ChangeDescription cd = changeRecorder.endRecording();

		boolean hasRecordedChange = !(cd.getObjectChanges().isEmpty() && cd.getObjectsToAttach().isEmpty()
				&& cd.getObjectsToDetach().isEmpty() && cd.getResourceChanges().isEmpty());

		if (DEBUG && !wasResourceModifiedBefore && (resource.isModified() != hasRecordedChange))
			StatusManager.getManager().handle(
					new Status(IStatus.ERROR, UIBaseActivator.PLUGIN_ID,
							"ResourceChangeRecorder: Mismatch between recording and modification flag"),
					StatusManager.LOG);

		if (hasRecordedChange && doReverse) {
			// undo
			cd.apply();
			
			// undo changes look like resource changes
			// set resource unmodified, important for dirty state tracking
			if (!wasResourceModifiedBefore)
				resource.setModified(false);
		}

		if (!doReverse && hasRecordedChange)
			result_resourceChanged = true;
	}

	public boolean hasResourceChanged() {
		return result_resourceChanged;
	}
}
