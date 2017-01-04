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

#include "VectorTest.h"

#include "common/containers/Vector.h"
#include "common/messaging/Address.h"
#include "util/etAssert.h"

using namespace etRuntime;

void VectorTest::testConstructors(void) {
	Vector<int> vec;
	EXPECT_TRUE(m_caseId, "vector is empty", vec.empty());
	EXPECT_TRUE(m_caseId, "vector is empty", vec.size() == 0);

	Vector<Address> vec2(3);
	EXPECT_TRUE(m_caseId, "vector is not empty", !vec2.empty());
	EXPECT_TRUE(m_caseId, "vector has size 3", vec2.size() == 3);
}

void VectorTest::testSettersAndGetters(void) {
	Vector<int> vec;

	vec.push_back(1);
	EXPECT_TRUE(m_caseId, "vector is not empty", !vec.empty());
	EXPECT_TRUE(m_caseId, "vector size is 1", vec.size() == 1);
	EXPECT_TRUE(m_caseId, "element 0 is 1", vec[0] == 1);

	vec[0] = 2;
	EXPECT_TRUE(m_caseId, "element 0 is 2", vec[0] == 2);

	vec[0] = 1;
	EXPECT_TRUE(m_caseId, "element 0 is 1", vec[0] == 1);
	vec.push_back(2);
	EXPECT_TRUE(m_caseId, "vector is not empty", !vec.empty());
	EXPECT_TRUE(m_caseId, "vector size is 2", vec.size() == 2);
	EXPECT_TRUE(m_caseId, "element 1 is 2", vec[1] == 2);
}

void VectorTest::testOperators(void) {
	Vector<int> vec1, vec2;

	//
	// comparison
	//
	vec1.push_back(1); vec2.push_back(1);
	vec1.push_back(2); vec2.push_back(2);
	vec1.push_back(3); vec2.push_back(3);
	EXPECT_TRUE(m_caseId, "vectors are equal", vec1 == vec2);

	//
	// iterators
	//
	Vector<int>::iterator it1 = vec1.begin();
	EXPECT_TRUE(m_caseId, "element at iterator position is 1", *it1 == 1);
	EXPECT_TRUE(m_caseId, "element at iterator position is 2", *(++it1) == 2);

	it1 = vec1.erase(it1);
	EXPECT_EQUAL_INT32(m_caseId, "new vector size is 2", 2, vec1.size());
	EXPECT_EQUAL_INT32(m_caseId, "element at iterator position is 3", 3, *it1);
	EXPECT_TRUE(m_caseId, "incremented iterator is at end", ++it1 == vec1.end());

	EXPECT_TRUE(m_caseId, "vectors are not equal", vec1 != vec2);

	//
	// front and back
	//
	EXPECT_EQUAL_INT32(m_caseId, "element at front is 1", 1, vec2.front());
	EXPECT_EQUAL_INT32(m_caseId, "element at front is 3", 3, vec2.back());
}

void VectorTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testSettersAndGetters)
	ADD_TESTCASE_CPP(testOperators)
}
