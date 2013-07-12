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
import org.eclipse.etrice.runtime.java.messaging.MessageDispatcher;

import junit.framework.TestCase;

public class MessageDispatcherTest extends TestCase {

	public void testAddMessageReceiver() {
		Address dispatcher_address = new Address(0,0,0);

		// Create Receivers to check if the messages are delivered
		DummyMessageReceiver receiver1 = new DummyMessageReceiver(new Address(0,0,1)); 
		DummyMessageReceiver receiver2 = new DummyMessageReceiver(new Address(0,0,2)); 
		DummyMessageReceiver receiver3 = new DummyMessageReceiver(new Address(0,0,3));
		DummyMessageReceiver receiver4 = new DummyMessageReceiver(new Address(0,0,4)); 
		DummyMessageReceiver receiver5 = new DummyMessageReceiver(new Address(0,0,5)); 
		DummyMessageReceiver receiver6 = new DummyMessageReceiver(new Address(0,0,6));
		
		
		// Add all Receivers to the Dispatcher
		MessageDispatcher dispatcher = new MessageDispatcher(null, dispatcher_address, "Dispatcher1");
		dispatcher.addMessageReceiver(receiver1);
		dispatcher.addMessageReceiver(receiver2);
		dispatcher.addMessageReceiver(receiver3);
		dispatcher.addMessageReceiver(receiver4);
		dispatcher.addMessageReceiver(receiver5);
		dispatcher.addMessageReceiver(receiver6);

		Message msg1 = new Message(new Address(0,0,1));
		Message msg2 = new Message(new Address(0,0,2));
		Message msg3 = new Message(new Address(0,0,3));
		Message msg4 = new Message(new Address(0,0,4));
		Message msg5 = new Message(new Address(0,0,5));
		Message msg6 = new Message(new Address(0,0,6));
		
		
		dispatcher.receive(msg1);
		dispatcher.receive(msg2);
		dispatcher.receive(msg3);
		dispatcher.receive(msg4);
		dispatcher.receive(msg5);
		dispatcher.receive(msg6);
		

		assertEquals(msg1, receiver1.getLastReceivedMessage());
		assertEquals(msg2, receiver2.getLastReceivedMessage());
		assertEquals(msg3, receiver3.getLastReceivedMessage());
		assertEquals(msg4, receiver4.getLastReceivedMessage());
		assertEquals(msg5, receiver5.getLastReceivedMessage());
		assertEquals(msg6, receiver6.getLastReceivedMessage());
		
	}

	public void testInstanceId() {
		Address dispatcher_address = new Address(0,0,0);
		MessageDispatcher dispatcher = new MessageDispatcher(null, dispatcher_address, "Dispatcher1");
		assertEquals("/Dispatcher1", dispatcher.getInstancePath());
	}

}
