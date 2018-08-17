/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.common.base.support;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class RemoveBendpointsFeature extends AbstractCustomFeature {

	/**
	 * @param fp
	 */
	public RemoveBendpointsFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public String getName() {
		return "Remove All Bend Points";
	}

	@Override
	public String getDescription() {
		return "remove all bend points of the selected connection(s)";
	}
	
	@Override
	public boolean isAvailable(IContext context) {
		if(!(context instanceof ICustomContext))
			return false;
		
		boolean allFreeForm = true;
		PictogramElement[] pes = ((ICustomContext)context).getPictogramElements();
		for (PictogramElement pe : pes) {
			if (!(pe instanceof FreeFormConnection))
				allFreeForm = false;
		}
		
		return allFreeForm;
	}

	@Override
	public void execute(ICustomContext context) {
		for (PictogramElement pe : context.getPictogramElements()) {
			if (pe instanceof FreeFormConnection) {
				FreeFormConnection conn = (FreeFormConnection) pe;
				conn.getBendpoints().clear();
			}
		}
	}

}
