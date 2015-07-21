/*******************************************************************************
 * Copyright (c) 2015 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

#include "TestEtDatatypes.h"
#include "etUnit/etUnit.h"

void TestEtDatatypes_IntegerSize(etInt16 id) {
	EXPECT_EQUAL_INT32(id, "", 1, sizeof(int8));
	EXPECT_EQUAL_INT32(id, "", 1, sizeof(uint8));
	EXPECT_EQUAL_INT32(id, "", 2, sizeof(int16));
	EXPECT_EQUAL_INT32(id, "", 2, sizeof(uint16));
	EXPECT_EQUAL_INT32(id, "", 4, sizeof(int32));
	EXPECT_EQUAL_INT32(id, "", 4, sizeof(uint32));

#ifdef ET_INT64
	EXPECT_EQUAL_INT32(id, "", 8, sizeof(int64));
	EXPECT_EQUAL_INT32(id, "", 8, sizeof(uint64));
#endif

	EXPECT_EQUAL_INT32(id, "", 1, sizeof(etInt8));
	EXPECT_EQUAL_INT32(id, "", 1, sizeof(etUInt8));
	EXPECT_EQUAL_INT32(id, "", 2, sizeof(etInt16));
	EXPECT_EQUAL_INT32(id, "", 2, sizeof(etUInt16));
	EXPECT_EQUAL_INT32(id, "", 4, sizeof(etInt32));
	EXPECT_EQUAL_INT32(id, "", 4, sizeof(etUInt32));

#ifdef ET_INT64
	EXPECT_EQUAL_INT32(id, "", 8, sizeof(etInt64));
	EXPECT_EQUAL_INT32(id, "", 8, sizeof(etUInt64));
#endif
}

void TestEtDatatypes_IntegerSign(etInt16 id) {
	EXPECT_TRUE(id, "", ((int8 )-1) < 0);
	EXPECT_TRUE(id, "", ((uint8 )-1) >= 0);
	EXPECT_TRUE(id, "", ((int16 )-1) < 0);
	EXPECT_TRUE(id, "", ((uint16 )-1) >= 0);
	EXPECT_TRUE(id, "", ((int32 )-1) < 0);
	EXPECT_TRUE(id, "", ((uint32 )-1) >= 0);

#ifdef ET_INT64
	EXPECT_TRUE(id, "", ((int64 )-1) < 0);
	EXPECT_TRUE(id, "", ((uint64 )-1) >= 0);
#endif

	EXPECT_TRUE(id, "", ((etInt8 )-1) < 0);
	EXPECT_TRUE(id, "", ((etUInt8 )-1) >= 0);
	EXPECT_TRUE(id, "", ((etInt16 )-1) < 0);
	EXPECT_TRUE(id, "", ((etUInt16 )-1) >= 0);
	EXPECT_TRUE(id, "", ((etInt32 )-1) < 0);
	EXPECT_TRUE(id, "", ((etUInt32 )-1) >= 0);

#ifdef ET_INT64
	EXPECT_TRUE(id, "", ((etInt64 )-1) < 0);
	EXPECT_TRUE(id, "", ((etUInt64 )-1) >= 0);
#endif
}

void TestEtDatatypes_Boolean(etInt16 id) {
	EXPECT_TRUE(id, "", (bool)1);
	EXPECT_FALSE(id, "", (bool)0);

	EXPECT_TRUE(id, "", (etBool )1);
	EXPECT_FALSE(id, "", (etBool )0);
}

void TestEtDatatypes_FLOAT(etInt16 id) {
#ifdef ET_FLOAT32
	EXPECT_EQUAL_INT32(id, "", 4, sizeof(float32));
	EXPECT_EQUAL_INT32(id, "", 4, sizeof(etFloat32));
#endif
#ifdef ET_FLOAT64
	EXPECT_EQUAL_INT32(id, "", 8, sizeof(float64));
	EXPECT_EQUAL_INT32(id, "", 8, sizeof(etFloat64));
#endif
}

void TestEtDatatypes_runSuite(void) {
	etUnit_openTestSuite("TestDatatypes");
	ADD_TESTCASE(TestEtDatatypes_IntegerSize);
	ADD_TESTCASE(TestEtDatatypes_IntegerSign);
	ADD_TESTCASE(TestEtDatatypes_Boolean);
	ADD_TESTCASE(TestEtDatatypes_FLOAT);
	etUnit_closeTestSuite();
}
