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

package org.eclipse.etrice.ui.behavior.fsm.commands;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.ui.behavior.fsm.support.ContextSwitcher;
import org.eclipse.etrice.ui.behavior.fsm.support.FSMSupportUtil;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.ui.services.GraphitiUi;

import com.google.inject.Injector;


public class PopulateDiagramCommand extends RecordingCommand {

	private ModelComponent mc;
	private Diagram diagram;
	private IFeatureProvider fp;
	private Injector injector;

	public PopulateDiagramCommand(String providerId, Diagram diag, ModelComponent mc, Injector injector, TransactionalEditingDomain domain) {
		super(domain);
		this.diagram = diag;
		this.mc = mc;
		this.injector = injector;

		IDiagramTypeProvider dtp = GraphitiUi.getExtensionManager().createDiagramTypeProvider(diagram, providerId); //$NON-NLS-1$
		fp = dtp.getFeatureProvider();
	}

	@Override
	protected void doExecute() {
		
		fp.link(diagram, mc);
		
		// we use a temporary structure to create the whole tree
		StateGraphContext tree = StateGraphContext.createContextTree(mc, injector);
		//System.out.println(tree);
		
		FSMSupportUtil.getInstance().addStateGraph(tree, diagram, fp);
		
		ContextSwitcher.switchTop(diagram);
	}
}
