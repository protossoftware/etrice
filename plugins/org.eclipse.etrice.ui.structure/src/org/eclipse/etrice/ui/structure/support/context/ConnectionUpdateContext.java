/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * CONTRIBUTORS:
 * 		Juergen Haug
 * 
 *******************************************************************************/

package org.eclipse.etrice.ui.structure.support.context;

import org.eclipse.etrice.ui.structure.support.provider.ConnectionProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

/**
 * Used to trigger update of connection after all anchors are up to date.
 *
 */
public class ConnectionUpdateContext extends UpdateContext{

	private ConnectionProvider connectionProvider;
	
	/**
	 * {@link ConnectionUpdateContext}
	 * @param pictogramElement
	 * @param connectionProvider
	 */
	public ConnectionUpdateContext(PictogramElement pictogramElement, ConnectionProvider connectionProvider) {
		super(pictogramElement);
		this.connectionProvider = connectionProvider;
	}
	
	public ConnectionProvider getConnectionProvider(){
		return connectionProvider;
	}

}
