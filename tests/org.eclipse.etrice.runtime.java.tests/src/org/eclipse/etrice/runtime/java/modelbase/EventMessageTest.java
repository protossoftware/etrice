/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.modelbase.EventMessage;

import junit.framework.TestCase;

public class EventMessageTest extends TestCase {

	public void testSetGetNext() {
		EventMessage msg1 = new EventMessage(new Address(0, 0, 0), 123);
		EventMessage msg2 = new EventMessage(new Address(0, 0, 0), 456);
		msg1.setNext(msg2);
		msg2.setNext(msg1);
		assertEquals(msg1.getNext(), msg2);
		assertEquals(msg2.getNext(), msg1);
		
		assertEquals(123, msg1.getEvtId());
		assertEquals(456, msg2.getEvtId());
	}
	
	public void testToString() {
		EventMessage msg = new EventMessage(new Address(1,2,3), 789);
		assertEquals("EventMessage(Address(n=1,t=2,o=3), evt=789)", msg.toString());
	}
}
