/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "messaging/MessageTest.h"

#include "etUnit/etUnit.h"
#include "common/messaging/Address.h"
#include "common/messaging/Message.h"

using namespace etRuntime;

void MessageTest::testConstructors() {

	const char *failMsg = "Message constructor test failed";
	Address addr(1, 2, 3);
	int data = 128;

	// Test constructor Message(const Address& addr, int evtId)
	Message msg1(addr, 1);
	EXPECT_TRUE(m_caseId, failMsg, msg1.getAddress() == addr);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 1, msg1.getEvtId());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, 0, msg1.getData());

	// Test constructor Message(const Address& addr, int evtm_caseId, void* dataPtr)
	Message msg2(addr, 1, &data);
	EXPECT_TRUE(m_caseId, failMsg, msg2.getAddress() == addr);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 1, msg2.getEvtId());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &data, msg2.getData());

	// Test constructor DataMessage(const Address& addr, int evtm_caseId, const T& dataToCopy)
	Message* msg3 = (Message*) new uint8_t[sizeof(DataMessage<int>)];
	new (msg3) DataMessage<int>(addr, 1, data);
	EXPECT_TRUE(m_caseId, failMsg, msg3->getAddress() == addr);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 1, msg3->getEvtId());
	EXPECT_TRUE(m_caseId, failMsg,
			*(static_cast<int*>(msg3->getData())) == data);
	msg3->~Message();
	delete[] (uint8_t*) msg3;
}

void MessageTest::testGetters() {

	const char *failMsg = "Message getter test failed";
	Address addr(1, 2, 3);
	int data = 128;
	Message msg(addr, 1, &data);

	// Test getAddress()
	EXPECT_TRUE(m_caseId, failMsg, msg.getAddress() == addr);

	// Test getEvtId()
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 1, msg.getEvtId());

	// Test getData()
	EXPECT_TRUE(m_caseId, failMsg, *(static_cast<int*>(msg.getData())) == data);
}

void MessageTest::testToString() {
	Address addr(1, 2, 3);
	Message msg(addr, 1);
	EXPECT_TRUE(m_caseId, "Message toString test failed",
			!msg.toString().compare("Message(1_2_3, evt=1)"));
}

void MessageTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testGetters)
	ADD_TESTCASE_CPP(testToString)
}
