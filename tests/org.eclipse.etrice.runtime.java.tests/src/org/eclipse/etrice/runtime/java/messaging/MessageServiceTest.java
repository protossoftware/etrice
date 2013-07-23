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
import org.eclipse.etrice.runtime.java.messaging.MessageService;

import junit.framework.TestCase;

public class MessageServiceTest extends TestCase {


	public void testRun() {
		
		// testing basic functionality of MessageService and Dispatcher
		MessageService msg_service1 = new MessageService(null, 0, 0, "MessageService1", Thread.NORM_PRIORITY);
		MessageService msg_service2 = new MessageService(null, 0, 0, "MessageService2", Thread.NORM_PRIORITY);
		MessageService msg_service3 = new MessageService(null, 0, 0, "MessageService3", Thread.NORM_PRIORITY);
		MessageService msg_service4 = new MessageService(null, 0, 0, "MessageService4", Thread.NORM_PRIORITY);
		MessageService msg_service5 = new MessageService(null, 0, 0, "MessageService5", Thread.NORM_PRIORITY);
		MessageService msg_service6 = new MessageService(null, 0, 0, "MessageService6", Thread.NORM_PRIORITY);

		DummyMessageReceiver receiver1 = new DummyMessageReceiver(new Address(0,0,1)); 
		DummyMessageReceiver receiver2 = new DummyMessageReceiver(new Address(0,1,2)); 
		DummyMessageReceiver receiver3 = new DummyMessageReceiver(new Address(0,2,5));
		DummyMessageReceiver receiver4 = new DummyMessageReceiver(new Address(0,3,18)); 
		DummyMessageReceiver receiver5 = new DummyMessageReceiver(new Address(0,4,39)); 
		DummyMessageReceiver receiver6 = new DummyMessageReceiver(new Address(0,5,111));
		
		
		msg_service1.getMessageDispatcher().addMessageReceiver(receiver1);
		msg_service2.getMessageDispatcher().addMessageReceiver(receiver2);
		msg_service3.getMessageDispatcher().addMessageReceiver(receiver3);
		msg_service4.getMessageDispatcher().addMessageReceiver(receiver4);
		msg_service5.getMessageDispatcher().addMessageReceiver(receiver5);
		msg_service6.getMessageDispatcher().addMessageReceiver(receiver6);
		
		Message msg1 = new Message(new Address(0,0,1));
		Message msg2 = new Message(new Address(0,1,2));
		Message msg3 = new Message(new Address(0,2,5));
		Message msg4 = new Message(new Address(0,3,18));
		Message msg5 = new Message(new Address(0,4,39));
		Message msg6 = new Message(new Address(0,5,111));

		start(msg_service1);
		start(msg_service2);
		start(msg_service3);
		start(msg_service4);
		start(msg_service5);
		start(msg_service6);

		msg_service1.receive(msg1);
		msg_service2.receive(msg2);
		msg_service3.receive(msg3);
		msg_service4.receive(msg4);
		msg_service5.receive(msg5);
		msg_service6.receive(msg6);

		try {
			// give the other thread in MessageService a bit time to compute the queue
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(msg1, receiver1.getLastReceivedMessage());
		assertEquals(msg2, receiver2.getLastReceivedMessage());
		assertEquals(msg3, receiver3.getLastReceivedMessage());
		assertEquals(msg4, receiver4.getLastReceivedMessage());
		assertEquals(msg5, receiver5.getLastReceivedMessage());
		assertEquals(msg6, receiver6.getLastReceivedMessage());
		
		
	}
	
	public void testMassiveMessaging(){
		// testing massive use of messaging between two threads
		// current thread sends, MessageService has its own thread to dispatch the received messages
		// implicit test of race conditions -> test breaks if you take out the synchronized keywords from the MessageService
		
		MessageService msg_service = new MessageService(null, 0, 0, "MessageService1");

		int max=3000;
		int max_iter=10;
		
		// create and register message receivers
		DummyMessageReceiver receiver[]=new DummyMessageReceiver[max];
		for (int i=0; i<max; i++){
			receiver[i] = new DummyMessageReceiver(new Address(0,0,1+i));
			msg_service.getMessageDispatcher().addMessageReceiver(receiver[i]);
		}
		

		// Create all Messages
		Message msg[][]=new Message[max][max_iter];
		for (int j=0; j<max_iter; j++){
			for (int i=0; i<max; i++){
				msg[i][j] = new Message(new Address(0,0,i+1));
			}
		}

		// Start Message Service before sending the Messages to test the synchronization
		// This test fails without the synchronized keywords in the MessageService 
		start(msg_service);
		
		// send all messages
		for (int j=0; j<max_iter; j++){
			for (int i=0; i<max; i++){
				msg_service.receive(msg[i][j]);
			}
		}

		
		try {
			// give the other thread in MessageService a bit time to compute the queue
			// TODO: maybe not a good choice to make a sleep in a test, a better strategy for multi threaded unit tests is needed
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i=0; i<max; i++){
			assertEquals(msg[i][max_iter-1], receiver[i].getLastReceivedMessage());
		}
		
	}

	public void testMessageService() {
		Address addr = new Address(0,0,0);
		MessageService msg_service = new MessageService(null, 0, 0, "MessageService1");
		assertEquals(addr, msg_service.getAddress());
		assertEquals(msg_service.getMessageDispatcher().getAddress().objectID, msg_service.getAddress().objectID+1);
	}

	public void testInstanceId() {
		// setInstanceId via Constructor
		MessageService msg_service = new MessageService(null, 0, 0, "MessageService1");
		assertEquals("/MessageService_MessageService1", msg_service.getInstancePath());
		assertEquals("/MessageService_MessageService1/Queue", msg_service.getMessageQueue().getInstancePath());
		assertEquals("/MessageService_MessageService1/Dispatcher", msg_service.getMessageDispatcher().getInstancePath());
	}

	private void start(MessageService svc) {
		Thread thread = new Thread(svc, svc.getName());
		svc.setThread(thread);
		thread.start();
	}
}
