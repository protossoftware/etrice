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

package org.eclipse.etrice.ui.structure;


import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.ui.common.base.export.IBulkDiagramExporter;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.etrice.ui.structure.commands.UpdateDiagramCommand;
import org.eclipse.etrice.ui.structure.editor.StructureEditor;
import org.eclipse.etrice.ui.structure.editor.StructureExporter;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.ui.RoomUiModule;

import com.google.inject.Injector;

public class DiagramAccess extends DiagramAccessBase {

	public DiagramAccess() {
		super();
	}
	
	public String getDiagramName(EObject rootObject) {
		if (rootObject instanceof StructureClass) {
			StructureClass sc = (StructureClass) rootObject;
			return "Structure of "+sc.getName();
		}
		return "unknown";
	}

	protected String getDiagramTypeId() {
		return "room.structure";
	}

	protected String getEditorId() {
		return StructureEditor.STRUCTURE_EDITOR_ID;
	}

	public String getDigramFileName(EObject rootObject) {
		if (rootObject instanceof StructureClass) {
			StructureClass sc = (StructureClass) rootObject;
			String modelName = ((RoomModel) sc.eContainer()).getName();
			return modelName+"."+sc.getName()+".structure";
		}
		return "unknown";
	}

	protected Command getInitialCommand(EObject rootObject, Diagram diagram, TransactionalEditingDomain editingDomain) {
		if (rootObject instanceof StructureClass) {
			IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, DiagramTypeProvider.PROVIDER_ID); //$NON-NLS-1$
			IFeatureProvider featureProvider = dtp.getFeatureProvider();
			return new UpdateDiagramCommand(diagram, (StructureClass) rootObject, editingDomain, featureProvider);
		}
		return null;
	}

	@Override
	protected Command getUpdateCommand(Diagram diagram, TransactionalEditingDomain editingDomain) {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, DiagramTypeProvider.PROVIDER_ID); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		UpdateDiagramCommand cmd = new UpdateDiagramCommand(diagram, editingDomain, featureProvider);
		if (cmd.updateNeeded())
			return cmd;

		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.base.support.DiagramAccessBase#injectMembers()
	 */
	@Override
	protected void injectMembers() {
		Injector injector = RoomUiModule.getInjector();
        injector.injectMembers(this);
	}

	@Override
	public IBulkDiagramExporter getDiagramExporter() {
		return new StructureExporter();
	}
}
