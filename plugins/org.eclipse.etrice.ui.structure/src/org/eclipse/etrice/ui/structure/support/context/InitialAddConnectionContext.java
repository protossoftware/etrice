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

package org.eclipse.etrice.ui.structure.support.context;

import org.eclipse.etrice.ui.structure.support.provider.ConnectionProvider;
import org.eclipse.graphiti.features.context.impl.AddContext;

public class InitialAddConnectionContext extends AddContext {
	
	private ConnectionProvider connectionProvider;
	
	public InitialAddConnectionContext(Object newObject, ConnectionProvider connectionProvider) {
		setNewObject(newObject);
		this.connectionProvider = connectionProvider;
	}
	
	public ConnectionProvider getConnectionProvider() {
		return connectionProvider;
	}
}
