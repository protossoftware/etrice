/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.common.editor;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.editor.RoomEditor;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.etrice.ui.common.commands.ChangeDiagramInputJob;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;

/**
 * description
 *
 * @author Henrik Rentz-Reichert initial contribution and API
 *
 */
public abstract class RoomDiagramEditor extends DiagramEditorBase {

	private boolean showLostDiagramInputDialog = true;

	public RoomDiagramEditor() {
		super();
		textEditorClass = RoomEditor.class;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.graphiti.ui.internal.editor.DiagramEditorInternal#setFocus()
	 */
	@Override
	public void setFocus() {
		super.setFocus();
		
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject diagramBo = diagram.getLink().getBusinessObjects().iterator().next();
		if(diagramBo == null || diagramBo.eIsProxy())
			handleMissingDiagramBo(diagram);
	}
	
	protected void handleMissingDiagramBo(Diagram diagram){
		if(!showLostDiagramInputDialog)
			return;
		
		// show only once
		showLostDiagramInputDialog = false;
		MessageDialog dialog = new MessageDialog(getGraphicalControl().getShell(),
				"Diagram out-dated", null,
				"Diagram input lost. Cannot find ROOM file or class for "+diagram.getName() +"\n\n"
				+ "Please ensure that no whitespace or special characters are contained in any related path, file or project",
				MessageDialog.ERROR, new String[] { "OK", "Reconnect Diagram" }, 0);
		int result = dialog.open();
		
		if(result == 1)
			new ChangeDiagramInputJob("Change input for "+diagram.getName(), this).schedule();	
	}
	
	protected abstract StructureClass getStructureClass();

}
