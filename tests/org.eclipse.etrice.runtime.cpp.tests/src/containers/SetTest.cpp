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

#include "SetTest.h"

#include "common/containers/Set.h"
#include "common/messaging/Address.h"
#include "util/etAssert.h"

using namespace etRuntime;

void SetTest::testConstructors(void) {
	Set<int> set;
	EXPECT_TRUE(m_caseId, "set is empty", set.empty());
	EXPECT_TRUE(m_caseId, "set is empty", set.size() == 0);

	set.insert(1);
	set.insert(2);
	set.insert(3);
	EXPECT_TRUE(m_caseId, "set is not empty", !set.empty());
	EXPECT_TRUE(m_caseId, "set has size 3", set.size() == 3);

	// copy constructor
	Set<int> set2(set);
	EXPECT_TRUE(m_caseId, "set is not empty", !set2.empty());
	EXPECT_TRUE(m_caseId, "set has size 3", set2.size() == 3);
}

void SetTest::testSettersAndGetters(void) {
	Set<int> set;

	set.insert(1);
	EXPECT_TRUE(m_caseId, "set is not empty", !set.empty());
	EXPECT_TRUE(m_caseId, "set size is 1", set.size() == 1);

	set.clear();
	EXPECT_TRUE(m_caseId, "set is empty", set.empty());
	EXPECT_TRUE(m_caseId, "set is empty", set.size() == 0);
}

void SetTest::testOperators(void) {
	Set<int> set1, set2;

	//
	// comparison with primitive type
	//
	set1.insert(1); set2.insert(3);
	set1.insert(2); set2.insert(1);
	set1.insert(3); set2.insert(2);
	EXPECT_TRUE(m_caseId, "sets are equal", set1 == set2);

	Set<Address> set3, set4;

	//
	// comparison with class
	//
	set3.insert(Address(1,2,3)); set4.insert(Address(7,8,9));
	set3.insert(Address(4,5,6)); set4.insert(Address(1,2,3));
	set3.insert(Address(7,8,9)); set4.insert(Address(4,5,6));
	EXPECT_TRUE(m_caseId, "sets are equal", set3 == set4);

	//
	// find with primitive type
	//
	Set<int>::iterator it1;
	it1 = set1.find(10);
	EXPECT_TRUE(m_caseId, "value 10 is not found", it1 == set1.end());
	it1 = set1.find(2);
	EXPECT_TRUE(m_caseId, "value 2 is found", it1 != set1.end());

	// remove this occurrence
	set1.erase(it1);

	it1 = set1.find(2);
	EXPECT_TRUE(m_caseId, "value 2 is NOT found", it1 == set1.end());

	//
	// find with class
	//
	Set<Address>::iterator it3;
	it3 = set3.find(Address(3,2,1));
	EXPECT_TRUE(m_caseId, "value Address(3,2,1) is not found", it3 == set3.end());
	it3 = set3.find(Address(4,5,6));
	EXPECT_TRUE(m_caseId, "value Address(4,5,6) is found", it3 != set3.end());

	// remove this occurrence
	set3.erase(it3);

	it3 = set3.find(Address(4,5,6));
	EXPECT_TRUE(m_caseId, "value 2 is NOT found", it3 == set3.end());
}

void SetTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testSettersAndGetters)
	ADD_TESTCASE_CPP(testOperators)
}
