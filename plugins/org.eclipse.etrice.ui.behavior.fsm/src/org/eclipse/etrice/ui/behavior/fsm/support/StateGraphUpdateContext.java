/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

package org.eclipse.etrice.ui.behavior.fsm.support;

import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class StateGraphUpdateContext extends UpdateContext {

	private IStateGraphContext context;

	/**
	 * @param pictogramElement
	 */
	public StateGraphUpdateContext(PictogramElement pe, IStateGraphContext ctx) {
		super(pe);
		
		this.context = ctx;
	}

	/**
	 * @return the context
	 */
	public IStateGraphContext getContext() {
		return context;
	}

}
