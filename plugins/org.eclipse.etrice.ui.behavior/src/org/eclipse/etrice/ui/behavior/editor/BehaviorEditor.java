/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.editor;


import org.eclipse.emf.ecore.EObject;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.editor.RoomEditor;
import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.fsm.editor.AbstractFSMEditor;
import org.eclipse.etrice.ui.common.commands.ChangeDiagramInputJob;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;


public class BehaviorEditor extends AbstractFSMEditor {

	public static final String BEHAVIOR_EDITOR_ID = "org.eclipse.etrice.ui.behavior.editor.BehaviorEditor";
	private boolean showLostDiagramInputDialog = true;
	
	public BehaviorEditor() {
		super(RoomEditor.class);
	}
	
	@Override
	public Image getDefaultImage() {
		return Activator.getImage("icons/Behavior.gif");
	}

	/**
	 * @return the actor class of this editor
	 */
	public ActorClass getActorClass() {
		Diagram diagram = getDiagramTypeProvider().getDiagram();
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(diagram);
		if (bo instanceof ActorClass)
			return (ActorClass) bo;
		
		return null;
	}
	
	protected StructureClass getStructureClass() {
		return (StructureClass) getModelComponent();
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

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase#getModel()
	 */
	@Override
	public EObject getModel() {
		return getActorClass().eContainer();
	}
}
