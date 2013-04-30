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
	private StructureClass sc;
	
	public UpdateDiagramCommand(StructureClass sc, Diagram diagram, TransactionalEditingDomain domain, IFeatureProvider featureProvider) {
		super(domain);
		this.sc = sc;
		this.diagram = diagram;
		this.featureProvider = featureProvider;
	}

	@Override
	protected void doExecute() {
		if(diagram.getLink() == null)
			featureProvider.link(diagram, sc);
		
		IUpdateContext context;
		if(sc instanceof ActorClass && ((ActorClass)sc).getBase() != null)
			context = new PositionUpdateContext(diagram, new SuperDiagramPositionProvider(sc));
		else if(DiagramUtil.findScShape(diagram) == null)
			context = new PositionUpdateContext(diagram, new DefaultPositionProvider(sc));
		else
			context = new UpdateContext(diagram);
		
		featureProvider.updateIfPossible(context);
	}

	public boolean updateNeeded() {
		return featureProvider.updateNeeded(new UpdateContext(diagram)).toBoolean();
	}
}
