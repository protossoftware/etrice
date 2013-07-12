/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.messaging;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.Message;

import junit.framework.TestCase;

public class MessageTest extends TestCase {

	public void testSetGetNext() {
		Message msg1 = new Message(new Address(0, 0, 0));
		Message msg2 = new Message(new Address(0, 0, 0));
		msg1.setNext(msg2);
		msg2.setNext(msg1);
		assertEquals(msg1.getNext(), msg2);
		assertEquals(msg2.getNext(), msg1);
	}
	
	public void testToString() {
		Message msg = new Message(new Address(1,2,3));
		assertEquals("Message(Address(nodeID=1,threadID=2,objectID=3))", msg.toString());
	}


}
