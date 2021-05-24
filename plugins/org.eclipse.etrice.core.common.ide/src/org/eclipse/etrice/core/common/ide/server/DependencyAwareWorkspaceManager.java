/*******************************************************************************
 * Copyright (c) 2021 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.common.ide.server;

import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.lsp4j.DidChangeWorkspaceFoldersParams;
import org.eclipse.lsp4j.WorkspaceFolder;
import org.eclipse.lsp4j.WorkspaceFoldersChangeEvent;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.CancelIndicator;

/**
 * A workspace manager that respects project dependencies by always refreshing the whole workspace if there
 * is a change to the workspace folders. Strictly speaking, it is only necessary to rebuild dependent projects
 * of added and deleted projects. However, usually a change to the workspace folders is seldom and rebuilding
 * the whole workspace is simpler.
 */
public class DependencyAwareWorkspaceManager extends WorkspaceManager {
	@Override
	public void didChangeWorkspaceFolders(DidChangeWorkspaceFoldersParams params, CancelIndicator cancelIndicator) {
		// Remove all folders from the workspace
		ArrayList<WorkspaceFolder> folders = new ArrayList<>(getWorkspaceFolders());
		super.didChangeWorkspaceFolders(new DidChangeWorkspaceFoldersParams(
				new WorkspaceFoldersChangeEvent(Collections.emptyList(), folders)),
			cancelIndicator);
		// Compute new list of workspace folders
		folders.removeAll(params.getEvent().getRemoved());
		folders.addAll(params.getEvent().getAdded());
		// Add all folders to the workspace
		super.didChangeWorkspaceFolders(new DidChangeWorkspaceFoldersParams(
				new WorkspaceFoldersChangeEvent(folders, Collections.emptyList())),
			cancelIndicator);
	}
}
