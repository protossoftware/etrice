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
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.help.HelpSystem;
import org.eclipse.help.IContext;
import org.eclipse.help.IContextProvider;

public class SelectedModelHelpProvider implements IContextProvider {

	private DiagramBehavior diagramBehavior;

	public SelectedModelHelpProvider(DiagramBehavior diagramBehavior) {
		this.diagramBehavior = diagramBehavior;
	}

	@Override
	public int getContextChangeMask() {
		return SELECTION;
	}

	@Override
	public IContext getContext(Object target) {
		HelpFeature help = new HelpFeature(diagramBehavior.getDiagramTypeProvider().getFeatureProvider());
		ICustomContext context = new CustomContext(diagramBehavior.getSelectedPictogramElements());
		String featureId = help.getFeatureId(context);
		if (featureId != null)
			return HelpSystem.getContext(ContextHelpProvider.getContextId(featureId));

		return null;
	}

	@Override
	public String getSearchExpression(Object target) {
		return null;
	}

}
