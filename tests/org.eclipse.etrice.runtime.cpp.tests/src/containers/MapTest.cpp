/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "MapTest.h"

#include "common/containers/Map.h"
#include "common/containers/String.h"
#include "util/etAssert.h"

using namespace etRuntime;

void MapTest::testConstructors(void) {
	Map<int, String> m1;
	EXPECT_TRUE(m_caseId, "map is empty", m1.empty());
	EXPECT_EQUAL_INT32(m_caseId, "map size is 0", 0, m1.size());

	m1[2] = "two";
	EXPECT_TRUE(m_caseId, "map is not empty", !m1.empty());
	EXPECT_EQUAL_INT32(m_caseId, "map size is 1", 1, m1.size());

	// copy constructor
	Map<int, String> m2(m1);
	EXPECT_TRUE(m_caseId, "map is not empty", !m2.empty());
	EXPECT_EQUAL_INT32(m_caseId, "map size is 1", 1, m2.size());
}

void MapTest::testSettersAndGetters(void) {
	Map<int, String> m1;
	m1[2] = "two";
	m1[1] = "one";

	EXPECT_EQUAL_INT32(m_caseId, "map size is 2", 2, m1.size());
	EXPECT_TRUE(m_caseId, "map[1]=='one'", m1[1]=="one");
	EXPECT_TRUE(m_caseId, "map[2]=='two'", m1[2]=="two");
}

void MapTest::testOperators(void) {
}

void MapTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testSettersAndGetters)
	ADD_TESTCASE_CPP(testOperators)
}
