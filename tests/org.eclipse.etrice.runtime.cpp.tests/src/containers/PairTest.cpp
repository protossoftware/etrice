/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "PairTest.h"

#include "common/containers/Pair.h"
#include "common/containers/String.h"
#include "util/etAssert.h"

using namespace etRuntime;

void PairTest::testConstructors(void) {
	Pair<int, int> p1;
	EXPECT_EQUAL_INT32(m_caseId, "p1.first", 0, p1.first);
	EXPECT_EQUAL_INT32(m_caseId, "p1.second", 0, p1.second);

	Pair<int, int> p2(1, 2);
	EXPECT_EQUAL_INT32(m_caseId, "p1.first", 1, p2.first);
	EXPECT_EQUAL_INT32(m_caseId, "p1.second", 2, p2.second);

	Pair<int, String> p3;
	EXPECT_EQUAL_INT32(m_caseId, "p1.first", 0, p3.first);
	EXPECT_TRUE(m_caseId, "p1.second", p3.second=="");

	Pair<int, String> p4(123, "pair");
	EXPECT_EQUAL_INT32(m_caseId, "p1.first", 123, p4.first);
	EXPECT_TRUE(m_caseId, "p1.second", p4.second=="pair");
}

void PairTest::testOperators(void) {
	Pair<int, int> p1(2,2), p2(1, 1);
	EXPECT_TRUE(m_caseId, "p1>p2", p1>p2);
	EXPECT_TRUE(m_caseId, "!p1<p2", !(p1<p2));
	EXPECT_TRUE(m_caseId, "p1!=p2", p1!=p2);

	p1.first = 1;
	EXPECT_TRUE(m_caseId, "p1>p2", p1>p2);
	EXPECT_TRUE(m_caseId, "!p1<p2", !(p1<p2));
	EXPECT_TRUE(m_caseId, "p1!=p2", p1!=p2);

	p1.second = 1;
	EXPECT_TRUE(m_caseId, "!p1>p2", !(p1>p2));
	EXPECT_TRUE(m_caseId, "!p1<p2", !(p1<p2));
	EXPECT_TRUE(m_caseId, "p1>=p2", p1>=p2);
	EXPECT_TRUE(m_caseId, "p1<=p2", p1<=p2);
	EXPECT_TRUE(m_caseId, "p1==p2", p1==p2);
}

void PairTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testOperators)
}
