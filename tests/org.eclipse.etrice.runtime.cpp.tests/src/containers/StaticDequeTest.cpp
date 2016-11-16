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

#include "common/containers/StaticDeque.h"
#include "common/containers/StaticQueue.h"
#include "common/containers/StaticStack.h"
#include "containers/StaticDequeTest.h"
#include "etUnit/etUnit.h"

void StaticDequeTest::testConstructors(void) {
	const char* failMsg = "testConstructors failed";

	// Test constructor StaticDeque(void)
	StaticDeque<int, 10> deque;
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 0, deque.size());
	EXPECT_TRUE(m_caseId, failMsg, deque.empty());

	// Test copy constructor StaticDeque(const StaticDeque& copy) with empty deque
	StaticDeque<int, 10> deque2(deque);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 0, deque2.size());
	EXPECT_TRUE(m_caseId, failMsg, deque2.empty());

	// Test copy constructor with filled deque
	deque.push_back(1);
	deque.push_back(2);
	deque.push_back(3);

	StaticDeque<int, 10> deque3(deque);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, deque3.size());
	EXPECT_FALSE(m_caseId, failMsg, deque3.empty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, deque3[0]);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 2, deque3[1]);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, deque3[2]);
}

void StaticDequeTest::testAssignment() {
	const char* failMsg = "testAssignment operator failed";

	// Test copy assignment operator
	StaticDeque<int, 10> deque;
	deque.push_back(1);
	deque.push_back(2);
	deque.push_back(3);

	StaticDeque<int, 10> deque2;
	deque2.push_back(4);
	deque2.push_back(5);

	deque2 = deque;
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, deque2.size());
	EXPECT_FALSE(m_caseId, failMsg, deque2.empty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, deque2[0]);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 2, deque2[1]);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, deque2[2]);
}

void StaticDequeTest::testPushPop() {
	const char* failMsg = "testPushPop failed";

	// Test push_back and push_front with 6 objects of type DataClass
	StaticDeque<DataClass, 6> deque;
	DataClass d1(1, 1.5, "Data 1");
	DataClass d2(2, 2.5, "Data 2");
	DataClass d3(3, 3.5, "Data 3");
	DataClass d4(4, 4.5, "Data 4");
	DataClass d5(5, 5.5, "Data 5");
	DataClass d6(1, 1.5, "Data 6");
	deque.push_front(d3);
	deque.push_front(d2);
	deque.push_back(d4);
	deque.push_front(d1);
	deque.push_back(d5);
	deque.push_back(d6);

	EXPECT_TRUE(m_caseId, failMsg, d1 == deque.front());
	EXPECT_TRUE(m_caseId, failMsg, d2 == deque[1]);
	EXPECT_TRUE(m_caseId, failMsg, d3 == deque[2]);
	EXPECT_TRUE(m_caseId, failMsg, d4 == deque[3]);
	EXPECT_TRUE(m_caseId, failMsg, d5 == deque[4]);
	EXPECT_TRUE(m_caseId, failMsg, d6 == deque.back());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 6, deque.size());
	EXPECT_FALSE(m_caseId, failMsg, deque.empty());

	// Test pop_back and pop_front
	deque.pop_back();
	deque.pop_front();
	deque.pop_front();
	deque.pop_back();

	EXPECT_TRUE(m_caseId, failMsg, d3 == deque[0]);
	EXPECT_TRUE(m_caseId, failMsg, d4 == deque[1]);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 2, deque.size());
	EXPECT_FALSE(m_caseId, failMsg, deque.empty());

	// Test pushing after popping
	deque.push_front(d2);
	deque.push_back(d5);

	EXPECT_TRUE(m_caseId, failMsg, d2 == deque.front());
	EXPECT_TRUE(m_caseId, failMsg, d3 == deque[1]);
	EXPECT_TRUE(m_caseId, failMsg, d4 == deque[2]);
	EXPECT_TRUE(m_caseId, failMsg, d5 == deque.back());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 4, deque.size());
	EXPECT_FALSE(m_caseId, failMsg, deque.empty());

	// Test pop all objects
	while(deque.size() > 0) {
		deque.pop_front();
	}
}

void StaticDequeTest::testQueue() {
	const char* failMsg = "testQueue failed";

	// short test of StaticQueue because StaticQueue uses only methods of StaticDeque
	StaticQueue<int, 3> queue;
	queue.push(1);
	queue.push(2);
	queue.push(3);
	EXPECT_FALSE(m_caseId, failMsg, queue.empty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, queue.size());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, queue.front());
	StaticQueue<int, 3> q2(queue);
	q2 = queue;
	queue.pop();
	queue.pop();
	queue.pop();
}

void StaticDequeTest::testStack() {
	const char* failMsg = "testStack failed";

	// short test of StaticStack because StaticStack uses only methods of StaticStack
	StaticStack<int, 3> stack;
	stack.push(1);
	stack.push(2);
	stack.push(3);
	EXPECT_FALSE(m_caseId, failMsg, stack.empty());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, stack.size());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, stack.top());
	stack.pop();
	stack.pop();
	stack.pop();
}

void StaticDequeTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testConstructors)
	ADD_TESTCASE_CPP(testAssignment)
	ADD_TESTCASE_CPP(testPushPop)
	ADD_TESTCASE_CPP(testQueue)
	ADD_TESTCASE_CPP(testStack)
}
