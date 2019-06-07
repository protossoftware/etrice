/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

#include "AddressTest.h"

#include "common/messaging/Address.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void AddressTest::testConstructors() {

	const char* failMsg = "Address constructor test failed";

	// Test Constructor Address(void)
	Address addr1;
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, addr1.m_nodeID);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, addr1.m_threadID);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 0, addr1.m_objectID);

	// Test Constructor Address(int nodem_caseId, int threadm_caseId, int objectID)
	Address addr2(1, 2, 3);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 1, addr2.m_nodeID);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 2, addr2.m_threadID);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, 3, addr2.m_objectID);

	// Test Constuctor Address(const Address& right)
	Address addr3(addr2);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, addr2.m_nodeID, addr3.m_nodeID);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, addr2.m_threadID, addr3.m_threadID);
	EXPECT_EQUAL_INT16(m_caseId, failMsg, addr2.m_objectID, addr3.m_objectID);
}

void AddressTest::testOperators() {

	const char* failMsg = "Address operator test failed";

	// Test operator==
	Address addr1(1, 2, 3);
	Address addr2(1, 2, 3);
	Address addr3(1, 2, 4);
	Address addr4(1, 4, 3);
	Address addr5(4, 2, 3);
	EXPECT_TRUE(m_caseId, failMsg, addr1 == addr2);
	EXPECT_FALSE(m_caseId, failMsg, addr1 == addr3);
	EXPECT_FALSE(m_caseId, failMsg, addr1 == addr4);
	EXPECT_FALSE(m_caseId, failMsg, addr1 == addr5);

	// Test operator!=
	EXPECT_FALSE(m_caseId, failMsg, addr1 != addr2);
	EXPECT_TRUE(m_caseId, failMsg, addr1 != addr3);
	EXPECT_TRUE(m_caseId, failMsg, addr1 != addr4);
	EXPECT_TRUE(m_caseId, failMsg, addr1 != addr5);

	// Test operator=
	Address addr6(1, 2, 3);
	Address addr7 = addr6;
	EXPECT_TRUE(m_caseId, failMsg, addr6 == addr7);

	// Test operator<
	Address addr8(1, 2, 3);
	Address addr9(1, 2, 4);
	Address addr10(1, 3, 3);
	Address addr11(2, 2, 3);
	EXPECT_TRUE(m_caseId, failMsg, addr8 < addr9);
	EXPECT_FALSE(m_caseId, failMsg, addr9 < addr8);
	EXPECT_TRUE(m_caseId, failMsg, addr8 < addr10);
	EXPECT_FALSE(m_caseId, failMsg, addr10 < addr8);
	EXPECT_TRUE(m_caseId, failMsg, addr8 < addr11);
	EXPECT_FALSE(m_caseId, failMsg, addr11 < addr8);

}

void AddressTest::testToString() {

}

void AddressTest::testToID() {

	// Test toID()
	Address addr(1, 2, 3);
	EXPECT_TRUE(m_caseId, "Address toID test failed", !addr.toID().compare("1_2_3"));

}
void AddressTest::testCreateInc() {

	// Test CreateInc()
	Address addr(1, 2, 3);
	EXPECT_TRUE(m_caseId, "Address CreateInc test failed",
			addr.createInc() == Address(1, 2, 4));

}
void AddressTest::testIsValid() {

	const char* failMsg = "Address IsValid test failed";

	// Test IsValid()
	Address addr1;
	Address addr2(1, 2, 3);
	EXPECT_FALSE(m_caseId, failMsg, addr1.isValid());
	EXPECT_TRUE(m_caseId, failMsg, addr2.isValid());

}

void AddressTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testOperators)
	// ADD_TESTCASE(testToString)
	ADD_TESTCASE_CPP(testToID)
	ADD_TESTCASE_CPP(testCreateInc)
	ADD_TESTCASE_CPP(testIsValid)
}
