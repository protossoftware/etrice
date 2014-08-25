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

package org.eclipse.etrice.ui.behavior.support;

import org.eclipse.etrice.ui.behavior.Activator;
import org.eclipse.etrice.ui.behavior.fsm.support.AbstractFSMProviderDispatcher;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;

import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class ProviderDispatcher extends AbstractFSMProviderDispatcher {


	/**
	 * @param dtp
	 */
	public ProviderDispatcher(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.etrice.ui.behavior.fsm.provider.IInjectorProvider#getInjector()
	 */
	@Override
	public Injector getInjector() {
		return Activator.getDefault().getInjector();
	}

}
