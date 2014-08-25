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
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.impl.DefaultRemoveFeature;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CantRemoveFeature extends DefaultRemoveFeature {

	public CantRemoveFeature(IFeatureProvider fp) {
		super(fp);
	}

	/**
	 * deny removal
	 * @return always {@code false}
	 * 
	 * @see org.eclipse.graphiti.features.impl.DefaultRemoveFeature#canRemove(org.eclipse.graphiti.features.context.IRemoveContext)
	 */
	public boolean canRemove(IRemoveContext context) {
		return false;
	}

}
