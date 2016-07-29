/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "StaticArrayTest.h"

#include "common/containers/StaticArray.h"
#include "common/messaging/Address.h"
#include "util/etAssert.h"

using namespace etRuntime;

void StaticArrayTest::testConstructors(void) {
	// default constructors for simple types
	StaticArray<int32, 5> intArray1; // nothing happens, but should not crash
	StaticArray<int32, 5> intArray2(3);
	StaticArray<int32, 5> intArray3(intArray2);

	EXPECT_EQUAL_INT32(m_caseId, "default value for intArray2 wrong", 3,
			intArray2[0]);
	EXPECT_EQUAL_INT32(m_caseId, "default value for intArray2 wrong", 3,
			intArray2[2]);
	EXPECT_EQUAL_INT32(m_caseId, "default value for intArray2 wrong", 3,
			intArray2[4]);

	EXPECT_EQUAL_INT32(m_caseId, "copy constructor for intArray3 wrong", 3,
			intArray3[0]);
	EXPECT_EQUAL_INT32(m_caseId, "copy constructor for intArray3 wrong", 3,
			intArray3[2]);
	EXPECT_EQUAL_INT32(m_caseId, "copy constructor for intArray3 wrong", 3,
			intArray3[4]);

	// default constructors for classes
	StaticArray<Address, 10> addressArray1; // nothing happens, but should not crash
	StaticArray<Address, 10> addressArray2(Address(1, 2, 3));
	StaticArray<Address, 10> addressArray3(addressArray2);

	EXPECT_EQUAL_INT32(m_caseId, "default value for addressArray2 wrong", 1,
			addressArray2[0].m_nodeID);
	EXPECT_EQUAL_INT32(m_caseId, "default value for addressArray2 wrong", 2,
			addressArray2[2].m_threadID);
	EXPECT_EQUAL_INT32(m_caseId, "default value for addressArray2 wrong", 3,
			addressArray2[9].m_objectID);

	EXPECT_EQUAL_INT32(m_caseId, "copy constructor for intArray3 wrong", 1,
			addressArray3[9].m_nodeID);
	EXPECT_EQUAL_INT32(m_caseId, "copy constructor for intArray3 wrong", 2,
			addressArray3[2].m_threadID);
	EXPECT_EQUAL_INT32(m_caseId, "copy constructor for intArray3 wrong", 3,
			addressArray3[0].m_objectID);

}

void StaticArrayTest::testSettersAndGetters(void) {
	StaticArray<int32, 5> intArray1(99); // nothing happens, but should not crash
	StaticArray<Address, 10> addressArray1(Address(11, 22, 33)); // nothing happens, but should not crash

	// getSize
	EXPECT_EQUAL_INT32(m_caseId, "getSize wrong", 5, intArray1.getSize());
	EXPECT_EQUAL_INT32(m_caseId, "getSize wrong", 10, addressArray1.getSize());

	// getData
	EXPECT_EQUAL_INT32(m_caseId, "getData wrong", 99, intArray1.getData()[3]);
	EXPECT_EQUAL_INT32(m_caseId, "getData wrong", 33, addressArray1.getData()[7].m_objectID);

}

void StaticArrayTest::testOperators(void) {
	StaticArray<int32, 5> intArray1(999);
	StaticArray<Address, 10> addressArray1(Address(11, 22, 33));

	// set some values with index operator
	intArray1[0]=0;
	intArray1[2]=22;
	intArray1[4]=44;

	addressArray1[0]=Address(0,1,2);
	addressArray1[7]=Address(7,8,9);
	addressArray1[9]=Address(9,10,11);

	// check index operator
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 0, intArray1.getData()[0]);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 22, intArray1.getData()[2]);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 44, intArray1.getData()[4]);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 0, intArray1[0]);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 22, intArray1[2]);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 44, intArray1[4]);

	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 0, addressArray1.getData()[0].m_nodeID);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 8, addressArray1.getData()[7].m_threadID);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 11, addressArray1.getData()[9].m_objectID);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 0, addressArray1[0].m_nodeID);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 8, addressArray1[7].m_threadID);
	EXPECT_EQUAL_INT32(m_caseId, "index operator wrong", 11, addressArray1[9].m_objectID);


	// check copy operator
	StaticArray<int32, 5> intArray2, intArray3;
	StaticArray<Address, 10> addressArray2, addressArray3;

	// checking for primitive datatypes
	intArray2 = intArray3 = intArray1;
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 0, intArray2[0]);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 22, intArray2[2]);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 44, intArray2[4]);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 0, intArray3[0]);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 22, intArray3[2]);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 44, intArray3[4]);

	// checking for classes
	addressArray2 = addressArray3 = addressArray1;
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 0, addressArray2[0].m_nodeID);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 8, addressArray2[7].m_threadID);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 11, addressArray2[9].m_objectID);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 0, addressArray3[0].m_nodeID);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 8, addressArray3[7].m_threadID);
	EXPECT_EQUAL_INT32(m_caseId, "copy operator wrong", 11, addressArray3[9].m_objectID);

	// Compare Operator
	// TODO: fix implementation of operator== and activate testcase
//	EXPECT_TRUE(m_caseId, "compare operator wrong", intArray2 == intArray3);
//	intArray2[4]=99;
//	EXPECT_FALSE(m_caseId, "compare operator wrong", intArray2 == intArray3);
//
//	EXPECT_TRUE(m_caseId, "compare operator wrong", addressArray2 == addressArray3);
//	addressArray2[9]=Address(99,88,77);
//	EXPECT_FALSE(m_caseId, "compare operator wrong", addressArray2 == addressArray3);

}

void StaticArrayTest::runAllTestCases() {
	ADD_TESTCASE(testConstructors)
	ADD_TESTCASE(testSettersAndGetters)
	ADD_TESTCASE(testOperators)
}
