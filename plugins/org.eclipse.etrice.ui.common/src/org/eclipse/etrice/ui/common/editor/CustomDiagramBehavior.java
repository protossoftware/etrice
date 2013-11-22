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

package org.eclipse.etrice.ui.common.editor;

import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class CustomDiagramBehavior extends DiagramBehavior {

	/**
	 * @param diagramContainer
	 */
	public CustomDiagramBehavior(IDiagramContainerUI diagramContainer) {
		super(diagramContainer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.editor.DiagramBehavior#createUpdateBehavior()
	 */
	@Override
	protected DefaultUpdateBehavior createUpdateBehavior() {
		return new CustomUpdateBehavior(this);
	}
}
