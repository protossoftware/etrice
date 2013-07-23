/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.support;

import org.eclipse.etrice.ui.behavior.commands.StateGraphContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * @author Henrik Rentz-Reichert (initial contribution)
 *
 */
public class StateGraphUpdateContext extends UpdateContext {

	private StateGraphContext context;

	/**
	 * @param pictogramElement
	 */
	public StateGraphUpdateContext(PictogramElement pe, StateGraphContext ctx) {
		super(pe);
		
		this.context = ctx;
	}

	/**
	 * @return the context
	 */
	public StateGraphContext getContext() {
		return context;
	}

}
