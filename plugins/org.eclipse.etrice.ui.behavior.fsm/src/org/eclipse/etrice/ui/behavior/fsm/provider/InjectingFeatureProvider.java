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

package org.eclipse.etrice.ui.behavior.fsm.provider;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import com.google.inject.Injector;

/**
 * @author Henrik Rentz-Reichert
 *
 */
public class InjectingFeatureProvider extends DefaultFeatureProvider {

	private Injector injector;

	/**
	 * @param dtp
	 */
	public InjectingFeatureProvider(IDiagramTypeProvider dtp, Injector injector) {
		super(dtp);
		this.injector = injector;
	}

	/**
	 * @return the Guice injector
	 */
	public Injector getInjector() {
		return injector;
	}

}
