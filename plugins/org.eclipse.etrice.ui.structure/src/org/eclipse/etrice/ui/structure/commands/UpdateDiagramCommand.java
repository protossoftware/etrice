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

package org.eclipse.etrice.ui.structure.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.ui.structure.support.DiagramUtil;
import org.eclipse.etrice.ui.structure.support.context.PositionUpdateContext;
import org.eclipse.etrice.ui.structure.support.provider.DefaultPositionProvider;
import org.eclipse.etrice.ui.structure.support.provider.SuperDiagramPositionProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;

public class UpdateDiagramCommand extends RecordingCommand {

	private Diagram diagram;
	private IFeatureProvider featureProvider;
	private StructureClass linkedSc;
	
	public UpdateDiagramCommand(Diagram diagram, TransactionalEditingDomain domain, IFeatureProvider featureProvider) {
		super(domain);
		this.diagram = diagram;
		this.featureProvider = featureProvider;
		this.linkedSc = null;
	}
	
	public UpdateDiagramCommand(Diagram diagram, StructureClass linkedSc, TransactionalEditingDomain domain, IFeatureProvider featureProvider) {
		this(diagram, domain, featureProvider);
		this.linkedSc = linkedSc;
	}

	@Override
	protected void doExecute() {
		if(linkedSc != null)
			featureProvider.link(diagram, linkedSc);
		
		Object diagramBo = featureProvider.getBusinessObjectForPictogramElement(diagram);
		
		IUpdateContext context;
		if(diagramBo instanceof ActorClass && ((ActorClass)diagramBo).getBase() != null)
			context = new PositionUpdateContext(diagram, new SuperDiagramPositionProvider((ActorClass)diagramBo));
		else if(diagramBo instanceof StructureClass && DiagramUtil.findScShape(diagram) == null)
			context = new PositionUpdateContext(diagram, new DefaultPositionProvider((StructureClass)diagramBo));
		else
			context = new UpdateContext(diagram);
		
		featureProvider.updateIfPossible(context);
	}

	public boolean updateNeeded() {
		return featureProvider.updateNeeded(new UpdateContext(diagram)).toBoolean();
	}
}
