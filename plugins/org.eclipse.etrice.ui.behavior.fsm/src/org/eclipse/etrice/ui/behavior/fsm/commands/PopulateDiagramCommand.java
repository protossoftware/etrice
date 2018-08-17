/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Thomas Schuetz and Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.behavior.fsm.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.ui.behavior.fsm.support.ContextSwitcher;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;


public class PopulateDiagramCommand extends RecordingCommand {

	private String providerId;
	private ModelComponent mc;
	private Diagram diagram;

	public PopulateDiagramCommand(String providerId, Diagram diag, ModelComponent mc, TransactionalEditingDomain domain) {
		super(domain);
		this.providerId = providerId;
		this.diagram = diag;
		this.mc = mc;
	}

	@Override
	protected void doExecute() {
		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, providerId); //$NON-NLS-1$
		
		dtp.getFeatureProvider().link(diagram, mc);

		UpdateContext ctx = new UpdateContext(diagram);
		dtp.getFeatureProvider().getUpdateFeature(ctx).update(ctx);
		
		ContextSwitcher.switchTop(diagram);
	}
}
