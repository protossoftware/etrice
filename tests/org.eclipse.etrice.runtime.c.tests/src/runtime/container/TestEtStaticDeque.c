/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "TestEtStaticDeque.h"

#include "etUnit/etUnit.h"
#include "container/etStaticDeque.h"

typedef struct {
	int attr1;
	double attr2;
	const char* attr3;
}
DataClass;

bool compareDataClass(DataClass* d1, DataClass* d2) {
	return d1->attr1 == d2->attr1
			&& d1->attr2 == d2->attr2
			&& d1->attr3 == d2->attr3;
}

void TestEtStaticDeque_testConstruct(etInt16 caseId) {
	const char* failMsg = "testConstructors failed";

	// Test constructor StaticDeque(void)
	etStaticDeque deque;
	int memory[10];
	etStaticDeque_construct(&deque, memory, sizeof(memory), sizeof(int));
	EXPECT_EQUAL_INT32(caseId, failMsg, 0, deque.size);
	EXPECT_TRUE(caseId, failMsg, deque.size == 0);
}

void TestEtStaticDeque_testPushPop(etInt16 caseId) {
	const char* failMsg = "testPushPop failed";

	// Test push_back and push_front with 6 objects of type DataClass
	etStaticDeque deque;
	DataClass memory[6];
	etStaticDeque_construct(&deque, memory, sizeof(memory), sizeof(DataClass));
	DataClass d1 = { 1, 1.5, "Data 1" };
	DataClass d2 = { 2, 2.5, "Data 2" };
	DataClass d3 = { 3, 3.5, "Data 3" };
	DataClass d4 = { 4, 4.5, "Data 4" };
	DataClass d5 = { 5, 5.5, "Data 5" };
	DataClass d6 = { 1, 1.5, "Data 6" };
	etStaticDeque_push_front(&deque, &d3);
	etStaticDeque_push_front(&deque, &d2);
	etStaticDeque_push_back(&deque, &d4);
	etStaticDeque_push_front(&deque, &d1);
	etStaticDeque_push_back(&deque, &d5);
	etStaticDeque_push_back(&deque, &d6);

	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d1, etStaticDeque_front(&deque)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d2, etStaticDeque_get(&deque, 1)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d3, etStaticDeque_get(&deque, 2)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d4, etStaticDeque_get(&deque, 3)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d5, etStaticDeque_get(&deque, 4)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d6, etStaticDeque_back(&deque)));
	EXPECT_EQUAL_INT32(caseId, failMsg, 6, deque.size);
	EXPECT_FALSE(caseId, failMsg, deque.size == 0);

	// Test pop_back and pop_front
	etStaticDeque_pop_back(&deque);
	etStaticDeque_pop_front(&deque);
	etStaticDeque_pop_front(&deque);
	etStaticDeque_pop_back(&deque);

	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d3, etStaticDeque_get(&deque, 0)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d4, etStaticDeque_get(&deque, 1)));
	EXPECT_EQUAL_INT32(caseId, failMsg, 2, deque.size);
	EXPECT_FALSE(caseId, failMsg, deque.size == 0);

	// Test pushing after popping
	etStaticDeque_push_front(&deque, &d2);
	etStaticDeque_push_back(&deque, &d5);

	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d2, etStaticDeque_front(&deque)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d3, etStaticDeque_get(&deque, 1)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d4, etStaticDeque_get(&deque, 2)));
	EXPECT_TRUE(caseId, failMsg, compareDataClass(&d5, etStaticDeque_back(&deque)));
	EXPECT_EQUAL_INT32(caseId, failMsg, 4, deque.size);
	EXPECT_FALSE(caseId, failMsg, deque.size == 0);

	// Test pop all objects
	while(deque.size > 0) {
		etStaticDeque_pop_front(&deque);
	}
}

void TestEtStaticDeque_runSuite(void) {
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestEtStaticDeque");
	ADD_TESTCASE(TestEtStaticDeque_testConstruct);
	ADD_TESTCASE(TestEtStaticDeque_testPushPop);
	etUnit_closeTestSuite();
}
