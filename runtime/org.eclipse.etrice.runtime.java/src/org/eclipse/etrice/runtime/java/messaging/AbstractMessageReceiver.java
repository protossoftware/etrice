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


package org.eclipse.etrice.runtime.java.messaging;

/**
 * Abstract base class for message receivers.
 * 
 * @author Thomas Schuetz
 *
 */
public abstract class AbstractMessageReceiver extends RTObject implements IMessageReceiver{

	private Address address = null;

	protected AbstractMessageReceiver(IRTObject parent, String name){
		this(parent, null, name);
	}

	protected AbstractMessageReceiver(IRTObject parent, Address address, String name){
		super(parent, name);
		this.address = address;
	}

	protected void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public Address getAddress() {
		return this.address;
	}

}
