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

package org.eclipse.etrice.ui.behavior;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.ui.behavior.editor.BehaviorEditor;
import org.eclipse.etrice.ui.behavior.fsm.commands.PopulateDiagramCommand;
import org.eclipse.etrice.ui.behavior.fsm.editor.BehaviorExporter;
import org.eclipse.etrice.ui.behavior.fsm.support.DiagramUpdateFeature;
import org.eclipse.etrice.ui.common.base.commands.UpdateCommand;
import org.eclipse.etrice.ui.common.base.export.IBulkDiagramExporter;
import org.eclipse.etrice.ui.common.base.support.DiagramAccessBase;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;

public class DiagramAccess extends DiagramAccessBase {
	
	public DiagramAccess() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.base.support.DiagramAccessBase#injectMembers()
	 */
	@Override
	protected void injectMembers() {
		Activator activator = Activator.getDefault();
		activator.getInjector().injectMembers(this);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.DiagramAccessBase#getDiagramName(org.eclipse.etrice.core.room.StructureClass)
	 */
	@Override
	public String getDiagramName(EObject rootObject) {
		if (rootObject instanceof ActorClass) {
			ActorClass ac = (ActorClass) rootObject;
			return "Behavior of "+ac.getName();
		}
		return "unknown";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.DiagramAccessBase#getDiagramTypeId()
	 */
	@Override
	protected String getDiagramTypeId() {
		return "room.behavior";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.DiagramAccessBase#getEditorId()
	 */
	@Override
	protected String getEditorId() {
		return BehaviorEditor.BEHAVIOR_EDITOR_ID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.DiagramAccessBase#getFileExtension()
	 */
	@Override
	public String getDigramFileName(EObject rootObject) {
		if (rootObject instanceof ActorClass) {
			ActorClass ac = (ActorClass) rootObject;
			String modelName = ((RoomModel) ac.eContainer()).getName();
			return modelName+"."+ac.getName()+".behavior";
		}
		return "unknown";
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.DiagramAccessBase#getInitialCommand(org.eclipse.etrice.core.room.StructureClass, org.eclipse.graphiti.mm.pictograms.Diagram, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	protected Command getInitialCommand(EObject rootObject, Diagram diagram, TransactionalEditingDomain editingDomain) {
		if (rootObject instanceof ModelComponent) {
			return new PopulateDiagramCommand("org.eclipse.etrice.ui.behavior.diagramTypeProvider", diagram, (ModelComponent) rootObject, Activator.getDefault().getInjector(), editingDomain);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.common.DiagramAccessBase#getUpdateCommand(org.eclipse.graphiti.mm.pictograms.Diagram, org.eclipse.emf.transaction.TransactionalEditingDomain)
	 */
	@Override
	protected Command getUpdateCommand(Diagram diagram, TransactionalEditingDomain editingDomain) {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, DiagramTypeProvider.PROVIDER_ID); //$NON-NLS-1$
		IFeatureProvider featureProvider = dtp.getFeatureProvider();
		UpdateCommand cmd = new UpdateCommand(diagram, editingDomain, new DiagramUpdateFeature(featureProvider));
		if (cmd.updateNeeded())
			return cmd;
		
		return null;
	}

	@Override
	public IBulkDiagramExporter getDiagramExporter() {
		return new BehaviorExporter(this);
	}
}
