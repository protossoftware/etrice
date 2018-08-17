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
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.messaging.MessageSeQueue;

import junit.framework.TestCase;

public class MessageSeQueueTest extends TestCase {

	public void testPushPop() {
		MessageSeQueue queue = new MessageSeQueue(null, "QueueName");
		Message msg1 = new Message(new Address(0, 0, 0));
		Message msg2 = new Message(new Address(0, 0, 0));
		Message msg3 = new Message(new Address(0, 0, 0));
		
		Message msg_received = null;
		
		// check fresh queue
		assertEquals(null, queue.getFirst());
		assertEquals(null, queue.getLast());
		
		// push first message
		queue.push(msg1);
		assertEquals(null, msg1.getNext());

		assertEquals(msg1, queue.getFirst());
		assertEquals(msg1, queue.getLast());
		
		// push second message
		queue.push(msg2);
		assertEquals(msg2, msg1.getNext());
		assertEquals(null, msg2.getNext());

		assertEquals(msg1, queue.getFirst());
		assertEquals(msg2, queue.getLast());

		// push third message
		queue.push(msg3);
		assertEquals(msg2, msg1.getNext());
		assertEquals(msg3, msg2.getNext());
		assertEquals(null, msg3.getNext());

		assertEquals(msg1, queue.getFirst());
		assertEquals(msg3, queue.getLast());

		// pop msg1
		msg_received = queue.pop();
		assertEquals(msg1, msg_received);
		assertEquals(null, msg1.getNext());
		assertEquals(msg3, msg2.getNext());
		assertEquals(null, msg3.getNext());

		assertEquals(msg2, queue.getFirst());
		assertEquals(msg3, queue.getLast());

		
		// pop msg2
		msg_received = queue.pop();
		assertEquals(msg2, msg_received);
		assertEquals(null, msg2.getNext());
		assertEquals(null, msg3.getNext());

		assertEquals(msg3, queue.getFirst());
		assertEquals(msg3, queue.getLast());
		
		// pop msg3
		msg_received = queue.pop();
		assertEquals(msg3, msg_received);
		assertEquals(null, msg3.getNext());

		assertEquals(null, queue.getFirst());
		assertEquals(null, queue.getLast());
		
		msg_received = queue.pop();
		assertEquals(null, msg_received);

	}
	
	
	public void testSizeAndHighwatermark() {
		MessageSeQueue queue = new MessageSeQueue(null, "QueueName");
		Message msg1 = new Message(new Address(0, 0, 0));
		Message msg2 = new Message(new Address(0, 0, 0));
		Message msg3 = new Message(new Address(0, 0, 0));
		
		Message msg_received = null;
		
		assertEquals(0, queue.getSize());
		assertEquals(0, queue.getHightWaterMark());

		queue.push(msg1);
		assertEquals(1, queue.getSize());
		assertEquals(1, queue.getHightWaterMark());
		
		queue.push(msg2);
		assertEquals(2, queue.getSize());
		assertEquals(2, queue.getHightWaterMark());

		queue.push(msg3);
		assertEquals(3, queue.getSize());
		assertEquals(3, queue.getHightWaterMark());

		msg_received = queue.pop();
		assertEquals(msg1, msg_received);
		assertEquals(2, queue.getSize());
		assertEquals(3, queue.getHightWaterMark());
		
		msg_received = queue.pop();
		assertEquals(msg2, msg_received);
		assertEquals(1, queue.getSize());
		assertEquals(3, queue.getHightWaterMark());

		msg_received = queue.pop();
		assertEquals(msg3, msg_received);
		assertEquals(0, queue.getSize());
		assertEquals(3, queue.getHightWaterMark());

	}
	
}
