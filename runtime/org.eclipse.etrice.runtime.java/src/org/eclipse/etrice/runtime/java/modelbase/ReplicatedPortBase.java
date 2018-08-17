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
	public ReplicatedPortBase(IInterfaceItemOwner parent, String name, int localId) {
		super(parent, name, localId);
	}

}
