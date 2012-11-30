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
import org.eclipse.etrice.runtime.java.messaging.RTServices;

public class PortBaseTest extends TestCase {
	// TODO: pull out all Mock Objects 
	public class MockEventReceiver implements IEventReceiver {

		@Override
		public String getInstancePath() {
			return "TOP_Path";
		}

		@Override
		public String getInstancePathName() {
			return "TOP_PathName";
		}
		
		@Override
		public String getInstancePath(char delim) {
			if (delim == IRTObject.PATH_DELIM)
				return getInstancePath();
			else
				return getInstancePathName();
		}

		@Override
		public void receiveEvent(InterfaceItemBase ifitem, int evt, Object data) {
		}
	
	}
	public class MockRTObject implements IRTObject {

		@Override
		public String getInstancePath() {
			return "TOP_Path";
		}

		@Override
		public String getInstancePathName() {
			return "TOP_PathName";
		}

		@Override
		public String getInstancePath(char delim) {
			return null;
		}
		
	}

	
	class MockPort extends PortBase {
		public MockPort(IEventReceiver parent, String name, int localId, int idx, Address address,
				Address peerAddress) {
			super(parent, name, localId, idx, address, peerAddress);
		}

		public void receive(Message msg) {
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testPortBase() {
		MockRTObject topRTObject = new MockRTObject();
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(
				new MessageService(topRTObject, new Address(0, 0, 0),"MessageService_0", Thread.NORM_PRIORITY));
		RTServices.getInstance().getMsgSvcCtrl().addMsgSvc(
				new MessageService(topRTObject, new Address(0, 1, 0),"MessageService_1", Thread.NORM_PRIORITY));

		MockEventReceiver eventRcv = new MockEventReceiver();
		Address portAddress = new Address(0, 0, 5);
		Address peerAddress = new Address(0, 1, 10);

		PortBase port0 = new MockPort(eventRcv, "Port0", 33, 0, portAddress, peerAddress);
		PortBase port1 = new MockPort(eventRcv, "Port1", 44, 5, peerAddress, portAddress);
		assertEquals(RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(0), port0.getMsgReceiver());
		assertEquals(RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(1), port1.getMsgReceiver());

		
		assertEquals(portAddress, port0.getAddress());
		assertEquals(peerAddress, port0.getPeerAddress());
		assertEquals(peerAddress, port1.getAddress());
		assertEquals(portAddress, port1.getPeerAddress());
		
		assertEquals("TOP_Path/Port0", port0.getInstancePath());
		assertEquals("TOP_PathName_Port0", port0.getInstancePathName());
		assertEquals("TOP_Path/Port1", port1.getInstancePath());
		assertEquals("TOP_PathName_Port1", port1.getInstancePathName());
		
		assertEquals(33, port0.getLocalId());
		assertEquals(44, port1.getLocalId());
		
		assertEquals(0, port0.getIdx());
		assertEquals(5, port1.getIdx());

		assertEquals(eventRcv, port0.getActor());
		assertEquals(eventRcv, port1.getActor());
	}


}
