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

#include "messaging/MessageSeQueueTest.h"

#include "common/messaging/MessageSeQueue.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void MessageSeQueueTest::testConstructors() {

	const char* failMsg = "MessageSeQueue constructor test failed";

	// Test constructor MessageSeQueue(IRTObject* parent, const std::string& name)
	MessageSeQueue msgQueue(NULL, "TestQueue");
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 0, msgQueue.getSize());
	EXPECT_TRUE(m_caseId, failMsg, msgQueue.getFirst() == NULL);
	EXPECT_TRUE(m_caseId, failMsg, msgQueue.getLast() == NULL);
	EXPECT_FALSE(m_caseId, failMsg, msgQueue.isNotEmpty());
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, msgQueue.getHightWaterMark());

}

void MessageSeQueueTest::testGetters() {

	const char* failMsg = "MessageSeQueue getter test failed";

	Address addr(1, 2, 3);
	Message msg1(addr, 1);
	Message msg2(addr, 2);
	Message msg3(addr, 3);
	MessageSeQueue msgQueue(NULL, "TestQueue");

	// Test without message
	EXPECT_EQUAL_PTR(m_caseId, failMsg, NULL, msgQueue.getFirst());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, NULL, msgQueue.getLast());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 0, msgQueue.getSize());
	EXPECT_FALSE(m_caseId, failMsg, msgQueue.isNotEmpty());

	// Test with one message
	msgQueue.push(&msg1);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, msgQueue.getFirst());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, msgQueue.getLast());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, msgQueue.getSize());
	EXPECT_TRUE(m_caseId, failMsg, msgQueue.isNotEmpty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, msgQueue.getHightWaterMark());

	// Test with two messages
	msgQueue.push(&msg2);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, msgQueue.getFirst());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg2, msgQueue.getLast());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 2, msgQueue.getSize());
	EXPECT_TRUE(m_caseId, failMsg, msgQueue.isNotEmpty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 2, msgQueue.getHightWaterMark());

	// Test with three messsages
	msgQueue.push(&msg3);
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, msgQueue.getFirst());
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg3, msgQueue.getLast());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, msgQueue.getSize());
	EXPECT_TRUE(m_caseId, failMsg, msgQueue.isNotEmpty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, msgQueue.getHightWaterMark());

}

void MessageSeQueueTest::testPushPop() {

	const char* failMsg = "MessageSeQueue push and pop test failed";
	Address adr(1, 2, 3);
	MessageSeQueue msgQueue(NULL, "TestQueue");
	Message msg1(adr, 1);
	Message msg2(adr, 2);
	Message msg3(adr, 3);
	Message msg4(adr, 4);
	Message msg5(adr, 5);
	const Message *tmpMsg = NULL;

	// Push and pop one message
	msgQueue.push(&msg1);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, tmpMsg);

	// Push and pop two messages
	msgQueue.push(&msg1);
	msgQueue.push(&msg2);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, tmpMsg);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg2, tmpMsg);

	// Push and pop and push and pop
	msgQueue.push(&msg1);
	msgQueue.push(&msg2);
	msgQueue.push(&msg3);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg1, tmpMsg);
	msgQueue.push(&msg4);
	msgQueue.push(&msg5);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg2, tmpMsg);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg3, tmpMsg);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg4, tmpMsg);
	tmpMsg = msgQueue.pop();
	EXPECT_EQUAL_PTR(m_caseId, failMsg, &msg5, tmpMsg);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 4, msgQueue.getHightWaterMark());

}

void MessageSeQueueTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testGetters)
	ADD_TESTCASE_CPP(testPushPop)
}
