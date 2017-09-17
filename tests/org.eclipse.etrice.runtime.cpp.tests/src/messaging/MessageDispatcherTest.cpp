/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "messaging/MessageDispatcherTest.h"
#include "etUnit/etUnit.h"
#include "common/messaging/MessageDispatcher.h"
#include "common/messaging/MessageService.h"
#include "common/messaging/StaticMessageMemory.h"
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTServices.h"

using namespace etRuntime;

void MessageDispatcherTest::testConstructors() {

	const char *failMsg = "MessageDispatcher constructor test failed";

	// Test constructor MessageDispatcher(IRTObject* parent, const Address& addr, const String& name)
	Address addr(1, 2, 3);
	MessageDispatcher msgDisp(NULL, addr, "TestMessageDispatcher");
	EXPECT_TRUE(m_caseId, failMsg, addr == msgDisp.getAddress());

}

void MessageDispatcherTest::testFreeAddresses() {

	const char *failMsg = "MessageDispatcher freeAddresses test failed";

	Address addr(1, 2, 3);
	MessageDispatcher msgDisp(NULL, addr, "TestMessageDispatcher");
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 4) == msgDisp.getFreeAddress());
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 5) == msgDisp.getFreeAddress());
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 6) == msgDisp.getFreeAddress());

	// free one address
	msgDisp.freeAddress(Address(1, 2, 5));

	// get it as next address
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 5) == msgDisp.getFreeAddress());

	// free two addresses
	msgDisp.freeAddress(Address(1, 2, 4));
	msgDisp.freeAddress(Address(1, 2, 6));

	// get them in reverse order
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 6) == msgDisp.getFreeAddress());
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 4) == msgDisp.getFreeAddress());

	// no freed address left: get a fresh one
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 7) == msgDisp.getFreeAddress());

}

void MessageDispatcherTest::testDispatching() {

	const char *failMsg = "MessageDispatcher dispatching test failed";

	// Test dispatching Messages
	MessageServiceController& msgSvcCtrl = RTServices::getInstance().getMsgSvcCtrl();
	MessageService msgSvc(NULL, IMessageService::BLOCKED, 1, 2,
				"Test MessageService", new StaticMessageMemory(NULL, "TestMemory", 64, 100));
	msgSvcCtrl.addMsgSvc(msgSvc);
	msgSvcCtrl.start();
	MessageDispatcher msgDisp(&msgSvc, Address(1, 2, 0), "TestMessageDispatcher");
	Address addr1 = msgDisp.getFreeAddress();
	Address addr2 = msgDisp.getFreeAddress();
	Address addr3 = msgDisp.getFreeAddress();
	SimpleMessageReceiver recv1(NULL, "Test receiver1", addr1);
	SimpleMessageReceiver recv2(NULL, "Test receiver2", addr2);
	SimpleMessageReceiver recv3(NULL, "Test receiver3", addr3);
	Message *msg1 = msgSvc.getMessageBuffer(sizeof(Message));
	Message *msg2 = msgSvc.getMessageBuffer(sizeof(Message));
	Message *msg3 = msgSvc.getMessageBuffer(sizeof(Message));
	Message *msg4 = msgSvc.getMessageBuffer(sizeof(Message));
	Message *msg5 = msgSvc.getMessageBuffer(sizeof(Message));
	Message *msg6 = msgSvc.getMessageBuffer(sizeof(Message));
	msg1 = new (msg1) Message(addr1, 1);
	msg2 = new (msg2) Message(addr2, 2);
	msg3 = new (msg3) Message(addr3, 3);
	msg4 = new (msg4) Message(addr1, 4);
	msg5 = new (msg5) Message(addr2, 5);
	msg6 = new (msg6) Message(addr3, 6);

	msgDisp.addMessageReceiver(recv1);
	msgDisp.receive(msg1);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, msg1,
			recv1.getLastReceivedMessagePtr());
	msgDisp.addMessageReceiver(recv2);
	msgDisp.receive(msg2);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, msg2,
			recv2.getLastReceivedMessagePtr());
	msgDisp.addMessageReceiver(recv3);
	msgDisp.receive(msg3);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, msg3,
			recv3.getLastReceivedMessagePtr());
	msgDisp.receive(msg4);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, msg4,
			recv1.getLastReceivedMessagePtr());
	msgDisp.removeMessageReceiver(recv1);
	msgDisp.receive(msg5);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, msg5,
			recv2.getLastReceivedMessagePtr());
	msgDisp.removeMessageReceiver(recv2);
	msgDisp.receive(msg6);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, msg6,
			recv3.getLastReceivedMessagePtr());
	msgDisp.removeMessageReceiver(recv3);

	// Test polling Messages
	Message *pollMsg = msgSvc.getMessageBuffer(sizeof(Message));
	pollMsg = new (pollMsg) Message(Address(1, 2, 0), 0);
	msgDisp.addPollingMessageReceiver(recv1);
	msgDisp.addPollingMessageReceiver(recv2);
	msgDisp.addPollingMessageReceiver(recv3);
	msgDisp.receive(pollMsg);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, pollMsg,
			recv1.getLastReceivedMessagePtr());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, pollMsg,
			recv2.getLastReceivedMessagePtr());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, pollMsg,
			recv3.getLastReceivedMessagePtr());
	msgDisp.removePollingMessageReceiver(recv1);
	msgDisp.removePollingMessageReceiver(recv2);
	msgDisp.removePollingMessageReceiver(recv3);
	msgSvcCtrl.stop();
	msgSvcCtrl.removeMsgSvc(msgSvc);
}

void MessageDispatcherTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testFreeAddresses)
	ADD_TESTCASE_CPP(testDispatching)
}
