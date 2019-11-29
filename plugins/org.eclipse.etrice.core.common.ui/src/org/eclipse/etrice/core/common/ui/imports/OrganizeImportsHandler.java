/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
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
package org.eclipse.etrice.core.common.ui.imports;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.ui.imports.ReplaceConverter;

import com.google.inject.Inject;

/**
 * @author Henrik Rentz-Reichert
 * 
 * @see org.eclipse.xtext.xbase.ui.imports.OrganizeImportsHandler
 *
 */
@SuppressWarnings("restriction") // ReplaceConverter is non-API
public class OrganizeImportsHandler extends AbstractHandler {
	
	private static final Logger LOG = Logger.getLogger(OrganizeImportsHandler.class);

	@Inject	private ReplaceConverter replaceConverter;
	
	@Inject private ImportOrganizer importOrganizer;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
		if (editor != null) {
			final IXtextDocument document = editor.getDocument();
			doOrganizeImports(document);
		}
		return null;
	}
	
	public void doOrganizeImports(final IXtextDocument document) {
		List<ReplaceRegion> result = document.priorityReadOnly(new IUnitOfWork<List<ReplaceRegion>, XtextResource>() {
			@Override
			public List<ReplaceRegion> exec(XtextResource state) throws Exception {
				return importOrganizer.getOrganizedImportChanges(state);
			}
		});
		if (result == null || result.isEmpty())
			return;
		try {
			DocumentRewriteSession session = null;
			if(document instanceof IDocumentExtension4) {
				session = ((IDocumentExtension4)document).startRewriteSession(DocumentRewriteSessionType.UNRESTRICTED);
			}
			replaceConverter.convertToTextEdit(result).apply(document);
			if(session != null) {
				((IDocumentExtension4)document).stopRewriteSession(session);
			}
		} catch (BadLocationException e) {
			LOG.error("Error organizing imports:", e);
		}
	}

}
