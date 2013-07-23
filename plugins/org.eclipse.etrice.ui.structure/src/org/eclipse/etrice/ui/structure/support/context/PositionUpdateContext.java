/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support.context;

import org.eclipse.etrice.ui.structure.support.provider.IPositionProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

public class PositionUpdateContext extends UpdateContext {

	IPositionProvider positionProvider;
	

	public PositionUpdateContext(PictogramElement pictogramElement, IPositionProvider positionProvider) {
		super(pictogramElement);
		this.positionProvider = positionProvider;
	}
	
	public IPositionProvider getPositionProvider() {
		return positionProvider;
	}
	
}
