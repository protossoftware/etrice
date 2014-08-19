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
import org.eclipse.etrice.core.ui.editor.RoomEditor;
import org.eclipse.etrice.ui.common.base.editor.CustomDiagramBehavior;
import org.eclipse.etrice.ui.common.base.editor.DiagramEditorBase;
import org.eclipse.etrice.ui.common.commands.ChangeDiagramInputJob;
import org.eclipse.etrice.ui.structure.Activator;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.provider.SuperDiagramPositionProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;


public class StructureEditor extends DiagramEditorBase {

	public static final String STRUCTURE_EDITOR_ID = "org.eclipse.etrice.ui.structure.editor.StructureEditor";
	private boolean showLostDiagramInputDialog = true;
	
	public StructureEditor() {
		super(RoomEditor.class);
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

	@Override
	protected void superClassChanged() {
		IDiagramTypeProvider diagramTypeProvider = getDiagramTypeProvider();
		Diagram diagram = diagramTypeProvider.getDiagram();
		IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
		IUpdateContext updateCtx = new PositionUpdateContext(diagram, new SuperDiagramPositionProvider(getStructureClass()));
		featureProvider.updateIfPossible(updateCtx);
		getDiagramBehavior().refresh();
	}
	
	@Override
	protected DiagramBehavior createDiagramBehavior() {
		final StructureEditor editor = this;
		return new CustomDiagramBehavior(this) {
			@Override
			protected DefaultRefreshBehavior createRefreshBehavior() {
				return new DiagramRefreshBehavior(editor);
			}
		};
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
	protected EObject getModel() {
		return getStructureClass().eContainer();
	}
}
