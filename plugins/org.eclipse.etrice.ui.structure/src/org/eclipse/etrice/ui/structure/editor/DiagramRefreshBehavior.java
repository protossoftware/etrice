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

package org.eclipse.etrice.ui.structure.editor;

import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.provider.SuperDiagramPositionProvider;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;

public class DiagramRefreshBehavior extends DefaultRefreshBehavior {

	private StructureEditor structureEditor;

	public DiagramRefreshBehavior(StructureEditor structureEditor) {
		super(structureEditor.getDiagramBehavior());
		this.structureEditor = structureEditor;
	}
	
	@Override
	protected void handleAutoUpdateAtStartup() {
		IDiagramTypeProvider diagramTypeProvider = diagramBehavior.getDiagramTypeProvider();
		if (diagramTypeProvider.isAutoUpdateAtStartup()) {
			StructureClass sc = structureEditor.getStructureClass();
			Diagram diagram = diagramTypeProvider.getDiagram();
			if(sc instanceof ActorClass && ((ActorClass)sc).getBase() != null)
				autoUpdate(new PositionUpdateContext(diagram, new SuperDiagramPositionProvider(sc)));
			else
				autoUpdate(new UpdateContext(diagram));
			
		}
	}

	public void autoUpdate(IUpdateContext updateCtx) {
		IDiagramTypeProvider diagramTypeProvider = diagramBehavior.getDiagramTypeProvider();
		IFeatureProvider featureProvider = diagramTypeProvider.getFeatureProvider();
		featureProvider.updateIfPossible(updateCtx);
		refresh();
	}

}
