/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.ui.common.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

/**
 * @author Henrik Rentz-Reichert - initial contribution and API
 *
 */
public class UpdateCommand extends RecordingCommand {

	private Diagram diagram;
	private AbstractUpdateFeature feature;

	public UpdateCommand(Diagram diag, TransactionalEditingDomain domain, AbstractUpdateFeature feature) {
		super(domain);
		this.feature = feature;
	}

	public boolean updateNeeded() {
		UpdateContext context = new UpdateContext(diagram);
		return feature.updateNeeded(context).toBoolean();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.emf.transaction.RecordingCommand#doExecute()
	 */
	@Override
	protected void doExecute() {
		UpdateContext context = new UpdateContext(diagram);
		feature.update(context);
	}

}
