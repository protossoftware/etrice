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

package org.eclipse.etrice.core.common.ui.linking;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;

/**
 * This class is needed since the URIs we get are non-platform URIs. In this case we have to convert them if possible.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public class GlobalNonPlatformURIEditorOpener extends GlobalURIEditorOpener {

	@Override
	public IEditorPart open(URI referenceOwnerURI, EReference reference, int indexInList, boolean select) {
		URI platformURI = getPlatformURI(referenceOwnerURI);
		if (platformURI != null)
			return super.open(platformURI, reference, indexInList, select);
		else
			return openExternalFile(referenceOwnerURI);
	}

	@Override
	public IEditorPart open(URI uri, boolean select) {
		URI platformURI = getPlatformURI(uri);
		if (platformURI != null)
			return super.open(platformURI, select);
		else
			return openExternalFile(uri);
	}
	
	public static URI getPlatformURI(URI uri) {
		if (uri.isPlatform())
			return uri;
		
		// HOWTO: find absolute path location in workspace (as platform URI)
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		IFile[] files = root.findFilesForLocationURI(java.net.URI.create(uri.toString()));
		if (files.length!=0) {
			String pluri = files[0].toString();
			// the pluri starts with L/ which we have to omit for URI.createPlatformResourceURI
			uri = URI.createPlatformResourceURI(pluri.substring(2), true).appendFragment(uri.fragment());
			return uri;
		}
		
		return null;
	}

	private IEditorPart openExternalFile(URI referenceOwnerURI) {
		URI folder = referenceOwnerURI.trimSegments(1);
		IFileStore fileStore = EFS.getLocalFileSystem().getStore(new Path(folder.toFileString()));
		fileStore = fileStore.getFileStore(new Path(referenceOwnerURI.lastSegment()));
		if (!fileStore.fetchInfo().isDirectory() && fileStore.fetchInfo().exists()) {
			IWorkbenchPage page = getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				return IDE.openEditorOnFileStore(page, fileStore);
			}
			catch (PartInitException e) {
			}
		}
		return null;
	}
}
