/*******************************************************************************
 * Copyright (c) 2010 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.eclipse.etrice.runtime.java.modelbase;

import junit.framework.TestCase;

import org.eclipse.etrice.runtime.java.messaging.Address;
import org.eclipse.etrice.runtime.java.messaging.IRTObject;
import org.eclipse.etrice.runtime.java.messaging.Message;
import org.eclipse.etrice.runtime.java.messaging.MessageService;
import org.eclipse.etrice.runtime.java.messaging.MessageServiceController;
import org.eclipse.etrice.runtime.java.messaging.RTServices;

public class ActorClassBaseTest extends TestCase {

	public class MockActor extends ActorClassBase {
		public MockActor(IRTObject parent, String name) {
			super(parent, name);
		}
		public void receive(Message msg) {
			
		}
		public Address getAddress() {
			return null;
		}
		public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
		}
		
		@Override
		public void init() {}
		@Override
		public void start() {}
		@Override
		public void stop() {}
		@Override
		public void destroy() {}
		@Override
		public void executeInitTransition() {
		}
	}

	public void testActorClassBase() {
		TopRTObject topRTObject = new TopRTObject("TOP");
		MessageServiceController msgSvcCtrl = RTServices.getInstance().getMsgSvcCtrl();
		msgSvcCtrl.addMsgSvc(
				new MessageService(topRTObject, 0, msgSvcCtrl.getNMsgSvc(), "MessageService_Main", Thread.NORM_PRIORITY));

		// PathNames
		ActorClassBase actor = new MockActor(topRTObject, "MockActor1");
		assertEquals("/TOP/MockActor1", actor.getInstancePath());
		assertEquals("_TOP_MockActor1", actor.getInstancePathName());
		
		// ClassName
		actor.setClassName("MockActor");
		assertEquals("MockActor", actor.getClassName());

		actor.setClassName("MockActor");
		assertEquals("ActorClass(className=MockActor, instancePath=/TOP/MockActor1)", actor.toString());
		
	}


}
