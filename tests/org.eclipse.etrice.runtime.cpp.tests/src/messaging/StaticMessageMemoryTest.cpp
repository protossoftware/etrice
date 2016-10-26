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

#include "StaticMessageMemoryTest.h"
#include "common/messaging/Message.h"
#include "common/messaging/StaticMessageMemory.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void StaticMessageMemoryTest::test() {
	const char* failMsg = "StaticMessageMemoryTest failed";

	StaticMessageMemory mem(NULL, "TestMemory", sizeof(DataMessage<uint32_t>), 10);

	EXPECT_EQUAL_INT32(m_caseId, failMsg, sizeof(DataMessage<uint32_t>), mem.getBufferSize());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 10, mem.getMessagePoolSize());

	Message* msg[10];

	for (int i = 0; i < 10; ++i) {
		msg[i] = mem.getMessageBuffer(0);
		EXPECT_TRUE(m_caseId, failMsg, msg[i] != NULL);
		EXPECT_EQUAL_INT32(m_caseId, failMsg, 9 - i, mem.getMessagePoolSize());
		new (msg[i]) Message(Address::EMPTY, 0, NULL);
	}
	EXPECT_EQUAL_PTR(m_caseId, failMsg, NULL, mem.getMessageBuffer(0));
	for (int i = 0; i < 10; ++i) {
		mem.returnMessageBuffer(msg[i]);
		EXPECT_EQUAL_INT32(m_caseId, failMsg, i + 1, mem.getMessagePoolSize());
	}

	msg[0] = mem.getMessageBuffer(4);
	EXPECT_TRUE(m_caseId, failMsg, msg[0] != NULL);
	msg[1] = mem.getMessageBuffer(2);
	EXPECT_TRUE(m_caseId, failMsg, msg[1] != NULL);
	msg[2] = mem.getMessageBuffer(1);
	EXPECT_TRUE(m_caseId, failMsg, msg[2] != NULL);
	uint32_t* ui32 = new uint32_t(32);
	uint16_t* ui16 = new uint16_t(16);
	uint8_t* ui8 = new uint8_t(8);
	new (msg[0]) DataMessage<uint32_t>(Address::EMPTY, 1, *ui32);
	new (msg[1]) DataMessage<uint16_t>(Address::EMPTY, 1, *ui16);
	new (msg[2]) DataMessage<uint8_t>(Address::EMPTY, 1, *ui8);
	delete ui32;
	delete ui16;
	delete ui8;
	ui32 = (uint32_t*) msg[0]->getData();
	ui16 = (uint16_t*) msg[1]->getData();
	ui8 = (uint8_t*) msg[2]->getData();
	EXPECT_EQUAL_UINT32(m_caseId, failMsg, 32, *ui32);
	EXPECT_EQUAL_UINT16(m_caseId, failMsg, 16, *ui16);
	EXPECT_EQUAL_UINT8(m_caseId, failMsg, 8, *ui8);
	msg[0]->~Message();
	msg[1]->~Message();
	msg[2]->~Message();
	mem.returnMessageBuffer(msg[2]);
	mem.returnMessageBuffer(msg[1]);
	mem.returnMessageBuffer(msg[0]);
}

void StaticMessageMemoryTest::runAllTestCases() {
	ADD_TESTCASE_CPP(test)
}

