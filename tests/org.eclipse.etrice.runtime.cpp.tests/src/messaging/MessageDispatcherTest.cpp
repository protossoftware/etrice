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

using namespace etRuntime;

void MessageDispatcherTest::testConstructors() {

	const char *failMsg = "MessageDispatcher constructor test failed";

	// Test constructor MessageDispatcher(IRTObject* parent, const Address& addr, const std::string& name)
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
	msgDisp.freeAddress(Address(1, 2, 5));
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 5) == msgDisp.getFreeAddress());
	msgDisp.freeAddress(Address(1, 2, 4));
	msgDisp.freeAddress(Address(1, 2, 6));
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 4) == msgDisp.getFreeAddress());
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 6) == msgDisp.getFreeAddress());
	EXPECT_TRUE(m_caseId, failMsg,
			Address(1, 2, 7) == msgDisp.getFreeAddress());

}

void MessageDispatcherTest::testDispatching() {

	const char *failMsg = "MessageDispatcher dispatching test failed";

	// Test dispatching Messages
	MessageDispatcher msgDisp(NULL, Address(1, 2, 0), "TestMessageDispatcher");
	Address addr1 = msgDisp.getFreeAddress();
	Address addr2 = msgDisp.getFreeAddress();
	Address addr3 = msgDisp.getFreeAddress();
	SimpleMessageReceiver recv1(NULL, "Test receiver1", addr1);
	SimpleMessageReceiver recv2(NULL, "Test receiver2", addr2);
	SimpleMessageReceiver recv3(NULL, "Test receiver3", addr3);
	Message *msg1 = new Message(addr1, 1, NULL);
	Message *msg2 = new Message(addr2, 2, NULL);
	Message *msg3 = new Message(addr3, 3, NULL);
	Message *msg4 = new Message(addr1, 4, NULL);
	Message *msg5 = new Message(addr2, 5, NULL);
	Message *msg6 = new Message(addr3, 6, NULL);

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
	Message *pollMsg = new Message(Address(1, 2, 0), 0, NULL);
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
}

void MessageDispatcherTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testFreeAddresses)
	ADD_TESTCASE_CPP(testDispatching)
}
