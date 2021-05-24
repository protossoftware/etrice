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

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

import org.eclipse.etrice.core.common.ide.modelpath.ModelPathManager;
import org.eclipse.lsp4j.DidChangeWatchedFilesParams;
import org.eclipse.lsp4j.DidChangeWorkspaceFoldersParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.WorkspaceFoldersChangeEvent;
import org.eclipse.xtext.ide.server.LanguageServerImpl;
import org.eclipse.xtext.util.CancelIndicator;

import com.google.inject.Inject;

/**
 * A language server implementation that extends the default implementation with
 * support for the modelpath import mechanism and modelpath description files.
 */
public class ModelLanguageServer extends LanguageServerImpl {
	
	@Inject
	private ModelPathManager modelpathManager;
	
	@Override
	public CompletableFuture<InitializeResult> initialize(InitializeParams params) {
		if(getLanguageServerAccess().getInitializeParams() == null && params.getWorkspaceFolders() != null) {
			getRequestManager().runWrite(() -> {
				// Inform the modelpath manager about the current workspace folders
				modelpathManager.workspaceFoldersChanged(params.getWorkspaceFolders(), Collections.emptyList());
				return null;
			}, (a, b) -> null);
		}
		return super.initialize(params);
	}
	
	@Override
	public void didChangeWorkspaceFolders(DidChangeWorkspaceFoldersParams params) {
		getRequestManager().runWrite(() -> {
			// Notify the modelpath manager about changed workspace folders
			modelpathManager.workspaceFoldersChanged(params.getEvent().getAdded(), params.getEvent().getRemoved());
			// Inform the super class about the changes
			getWorkspaceManager().didChangeWorkspaceFolders(params, CancelIndicator.NullImpl);
			return null;
		}, (a, b) -> null);
	}
	
	@Override
	public void didChangeWatchedFiles(DidChangeWatchedFilesParams params) {
		getRequestManager().runWrite(() -> {
			// Inform the modelpath manager about changed files and refresh the workspace if
			// the modelpath description of some projects changed.
			if(modelpathManager.filesChanged(params.getChanges())) {
				getWorkspaceManager().didChangeWorkspaceFolders(new DidChangeWorkspaceFoldersParams(
						new WorkspaceFoldersChangeEvent(Collections.emptyList(), Collections.emptyList())),
					CancelIndicator.NullImpl);
			}
			// Notify the super class about the changes
			return toBuildable(params);
		}, (cancelIndicator, buildable) -> buildable.build(cancelIndicator));
	}
}
