/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import org.eclipse.etrice.runtime.java.messaging.Address;

import junit.framework.TestCase;

public class AddressTest extends TestCase {

	public void testAddress() {
		Address addr = new Address(1,2,3);
		assertEquals(1, addr.nodeID);
		assertEquals(2, addr.threadID);
		assertEquals(3, addr.objectID);
	}
	public void testToString() {
		Address addr = new Address(1,2,3);
		assertEquals("Address(nodeID=1,threadID=2,objectID=3)", addr.toString());
	}

}
