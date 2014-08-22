/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.core.genmodel.fsm.builder;

import org.eclipse.etrice.core.fsm.fSM.ModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.base.NullDiagnostician;
import org.eclipse.etrice.core.genmodel.fsm.base.NullLogger;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.ExpandedModelComponent;
import org.eclipse.etrice.core.genmodel.fsm.fsmgen.FsmGenFactory;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class FSMGeneratorModelBuilder {

	private boolean debug = false;
	private NullLogger logger;
	private NullDiagnostician diagnostician;

	/**
	 * @param nullLogger
	 * @param diagnostician
	 */
	public FSMGeneratorModelBuilder(NullLogger logger, NullDiagnostician diagnostician) {
		this.logger = logger;
		this.diagnostician = diagnostician;
	}

	/**
	 * @param mc
	 * @return
	 */
	public ExpandedModelComponent createExpandedModelComponent(ModelComponent mc) {
		if (debug)
			logger.logInfo("GeneratorModelBuilder: creating expanded model compoent from "+mc.getComponentName());
		
		ExpandedModelComponent xmc = FsmGenFactory.eINSTANCE.createExpandedModelComponent();
		xmc.setModelComponent(mc);
		
		xmc.prepare(diagnostician);
		
		return xmc;
	}

}
