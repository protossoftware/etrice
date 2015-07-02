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

package org.eclipse.etrice.ui.common.base.editor;

import org.eclipse.etrice.doc.ContextHelpProvider;
import org.eclipse.etrice.ui.common.base.support.HelpFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.impl.CustomContext;
import org.eclipse.help.HelpSystem;
import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;

public class SelectedModelHelpProvider implements IContextProvider {

	private DiagramEditorBase diagramEditor;

	public SelectedModelHelpProvider(DiagramEditorBase diagramEditor) {
		this.diagramEditor = diagramEditor;
	}

	@Override
	public int getContextChangeMask() {
		return SELECTION;
	}

	@Override
	public IContext getContext(Object target) {
		HelpFeature helpFeature = new HelpFeature(diagramEditor.getDiagramTypeProvider().getFeatureProvider());
		ICustomContext featureContext = new CustomContext(diagramEditor.getSelectedPictogramElements());
		String featureId = helpFeature.getFeatureId(featureContext);

		IContext context = null;
		if (featureId != null)
			context = HelpSystem.getContext(ContextHelpProvider.getContextId(featureId));
		if (context == null)
			context = HelpSystem.getContext(ContextHelpProvider.getContextId(diagramEditor.getClass().getSimpleName()));

		return context;
	}

	@Override
	public String getSearchExpression(Object target) {
		return null;
	}

}
