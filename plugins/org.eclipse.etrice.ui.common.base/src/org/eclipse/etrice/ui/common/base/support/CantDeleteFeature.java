/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.support;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CantDeleteFeature extends DefaultDeleteFeature {

	/**
	 * @param fp
	 */
	public CantDeleteFeature(IFeatureProvider fp) {
		super(fp);
	}

	/** 
	 * deny delete
	 * 
	 * @return always {@code false}
	 * 
	 * @see org.eclipse.graphiti.ui.features.DefaultDeleteFeature#canDelete(org.eclipse.graphiti.features.context.IDeleteContext)
	 */
	@Override
	public boolean canDelete(IDeleteContext context) {
		return false;
	}
}
