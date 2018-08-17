/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.ui.common.base.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;

/**
 * @author Henrik Rentz-Reichert - initial contribution and API
 *
 */
public class UpdateCommand extends RecordingCommand {

	private IDiagramTypeProvider dtp;

	public UpdateCommand(String providerId, Diagram diagram, TransactionalEditingDomain editingDomain) {
		super(editingDomain);
		
		dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, providerId); //$NON-NLS-1$
	}

	public boolean updateNeeded() {
		UpdateContext ctx = new UpdateContext(dtp.getDiagram());
		return dtp.getFeatureProvider().getUpdateFeature(ctx).updateNeeded(ctx).toBoolean();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {	
		UpdateContext ctx = new UpdateContext(dtp.getDiagram());
		dtp.getFeatureProvider().getUpdateFeature(ctx).update(ctx);
	}

}
