/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
		assertEquals("Address(n=1,t=2,o=3)", addr.toString());
	}

}
