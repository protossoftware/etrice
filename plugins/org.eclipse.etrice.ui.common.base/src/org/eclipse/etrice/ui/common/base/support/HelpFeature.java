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

package org.eclipse.etrice.ui.common.base.support;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.doc.ContextHelpProvider;
import org.eclipse.etrice.ui.common.base.BaseImageProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class HelpFeature extends AbstractCustomFeature {

	public HelpFeature(IFeatureProvider fp) {
		super(fp);
	}

	protected String getBoClassName(PictogramElement pe) {
		Object bo = getBusinessObjectForPictogramElement(pe);
		if (bo instanceof EObject)
			return ((EObject) bo).eClass().getName();

		return null;
	}

	public String getFeatureId(ICustomContext context) {
		if (context instanceof ICustomContext) {
			ICustomContext peContext = (ICustomContext) context;
			if (peContext.getPictogramElements() != null && peContext.getPictogramElements().length == 1){
				PictogramElement pe = peContext.getPictogramElements()[0];
				// don't show help for diagram input
				if(getBusinessObjectForPictogramElement(pe) == getBusinessObjectForPictogramElement(getDiagram()))
					return null;
				return getBoClassName(pe);
			}
		}

		return null;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		String featureId = getFeatureId(context);
		if (featureId != null)
			return ContextHelpProvider.isAvailable(featureId);

		return false;
	}

	@Override
	public void execute(ICustomContext context) {
		ContextHelpProvider.showHelp(getBoClassName(((ICustomContext) context).getPictogramElements()[0]));
	}

	@Override
	public String getName() {
		return "Help";
	}

	@Override
	public String getDescription() {
		return "Open help view";
	}

	@Override
	public String getImageId() {
		return BaseImageProvider.IMG_HELP;
	}

	@Override
	public boolean hasDoneChanges() {
		return false;
	}

}
