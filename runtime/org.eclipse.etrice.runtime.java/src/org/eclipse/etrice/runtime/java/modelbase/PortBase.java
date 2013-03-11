/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;


/**
 * An abstract base class for port instances.
 * 
 * @author Thomas Schuetz
 *
 */
public abstract class PortBase extends InterfaceItemBase {
	
	public PortBase (IEventReceiver actor, String name, int localId){
		super(actor, name, localId, 0);
	}
	
	public PortBase (IEventReceiver actor, String name, int localId, int idx){
		super(actor, name, localId, idx);
	}
}
