/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
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

import org.eclipse.etrice.runtime.java.messaging.IRTObject;

/**
 * {@link IRTObject runtime objects} that own interface items are derived
 * from this interface. They have an {@link IEventReceiver} associated
 * and they own the replicated system port responsible for their
 * sub tree or delegate to their parent.
 * 
 * @author Henrik Rentz-Reichert
 */
public interface IInterfaceItemOwner extends IRTObject {

	/**
	 * @return the event receiver that receives messages of the owned interface items
	 */
	IEventReceiver getEventReceiver();
	
	/**
	 * @return the replicated system port which is responsible for this
	 * instance sub tree
	 */
	IReplicatedInterfaceItem getSystemPort();
}
