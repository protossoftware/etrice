/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 * 
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

/**
 * An abstract base class for instances of replicated ports.
 * 
 * @author Henrik Rentz-Reichert
 *
 */
public abstract class ReplicatedPortBase extends ReplicatedInterfaceItemBase {

	/**
	 * @param parent
	 * @param name
	 * @param localId
	 */
	public ReplicatedPortBase(IEventReceiver parent, String name, int localId) {
		super(parent, name, localId);
	}

}
