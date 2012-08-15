/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.common.editor.RoomDiagramEditor;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.graphics.Image;


public class StructureEditor extends RoomDiagramEditor {

	public static final String STRUCTURE_EDITOR_ID = "org.eclipse.etrice.ui.structure.editor.StructureEditor";
	
	public StructureEditor() {
		super();
	}
	
	@Override
	public Image getDefaultImage() {
		return Activator.getImage("icons/Structure.gif");
	}

	/**
	 * @return the actor class of this editor
	 */
	public StructureClass getStructureClass() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof StructureClass)
			return (StructureClass) bo;
		
		return null;
	}
}
