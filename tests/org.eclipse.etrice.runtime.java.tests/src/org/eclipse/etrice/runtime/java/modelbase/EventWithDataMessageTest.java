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
import org.eclipse.etrice.runtime.java.modelbase.EventWithDataMessage;

import junit.framework.TestCase;

public class EventWithDataMessageTest extends TestCase {

	public void testSetGetNext() {
		EventWithDataMessage msg1 = new EventWithDataMessage(new Address(0, 0, 0), 123, "abc");
		EventWithDataMessage msg2 = new EventWithDataMessage(new Address(0, 0, 0), 456, "def");
		msg1.setNext(msg2);
		msg2.setNext(msg1);
		assertEquals(msg1.getNext(), msg2);
		assertEquals(msg2.getNext(), msg1);
		
		assertEquals(123, msg1.getEvtId());
		assertEquals(456, msg2.getEvtId());
		assertEquals("abc", msg1.getData());
		assertEquals("def", msg2.getData());
	}
	
	public void testToString() {
		EventWithDataMessage msg = new EventWithDataMessage(new Address(1,2,3), 789, "eTrice");
		assertEquals("EventWithDataMessage(Address(n=1,t=2,o=3), evt=789, data=(eTrice))", msg.toString());
	}
}
