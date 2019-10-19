/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.core.common.ui.editor;

import static org.eclipse.etrice.core.common.validation.IssueUtils.isBlocking;

import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

public abstract class SaveOnFocusLostXtextEditor extends XtextEditor implements ISaveOnFocusLostEditor, IValidatingEditor {
	
	@Inject
	protected IResourceValidator resourceValidator;
	
	protected SaveDialogEditor saveDialog = new SaveDialogEditor();
	
	@Override
	public boolean isValid() {
		return getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {
			@Override
			public Boolean exec(XtextResource resource) throws Exception {
				return isValid(resource);
			}
		});
	}
	
	protected boolean isValid(XtextResource resource) {
		List<Issue> result = resourceValidator.validate(resource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
		
		return !result.stream().anyMatch((issue) -> issue.isSyntaxError() || isBlocking(issue));
	}
	
	@Override
	public int promptToSaveOnClose() {
		return saveDialog.open(getShell(), getPartName());
	}

	@Override
	public boolean shouldSaveOnFocusLost() {
		return saveDialog.getResult() != NO && isDirty() && isValid();
	}
}
