/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.ui.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.doc.ContextHelpProvider;
import org.eclipse.help.HelpSystem;
import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class SelectedModelHelpProvider implements IContextProvider {

	private EObjectAtOffsetHelper helper = new EObjectAtOffsetHelper();

	private XtextEditor editor;

	public SelectedModelHelpProvider(XtextEditor editor) {
		this.editor = editor;
	}

	@Override
	public int getContextChangeMask() {
		return SELECTION;
	}

	@Override
	public IContext getContext(Object target) {
		final ITextSelection ss = (ITextSelection) editor.getSelectionProvider().getSelection();
		IXtextDocument document = editor.getDocument();
		EObject obj = document.readOnly(new IUnitOfWork<EObject, XtextResource>() {
			@Override
			public EObject exec(XtextResource resource) throws Exception {
				return helper.resolveElementAt(resource, ss.getOffset());
			}
		});

		IContext context = null;
		if (obj != null)
			context = HelpSystem.getContext(ContextHelpProvider.getContextId(obj.eClass().getName()));
		if (context == null)
			context = HelpSystem.getContext(ContextHelpProvider.getContextId(editor.getClass().getSimpleName()));

		return context;
	}

	@Override
	public String getSearchExpression(Object target) {
		return null;
	}

}
