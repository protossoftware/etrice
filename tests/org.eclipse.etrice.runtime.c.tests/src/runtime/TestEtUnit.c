/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/


/*
 * TestEtUnit.c
 *
 *  Created on: 16.01.2012
 *      Author: tschuetz
 */

#include "TestEtUnit.h"
#include "etUnit/etUnit.h"

void TestEtUnit_Expect(void){
	EXPECT_TRUE("EXPECT_TRUE", TRUE);
	EXPECT_FALSE("EXPECT_FALSE", FALSE);

	/* signed integer values */
	EXPECT_EQUAL_INT8("EXPECT_EQUAL_INT8", -123, -123);
	EXPECT_EQUAL_INT16("EXPECT_EQUAL_INT16", -12345, -12345);
	EXPECT_EQUAL_INT32("EXPECT_EQUAL_INT32", -1234567, -1234567);

	/* unsigned integer values */
	EXPECT_EQUAL_UINT8("EXPECT_EQUAL_INT8", 123, 123);
	EXPECT_EQUAL_UINT16("EXPECT_EQUAL_INT16", 12345, 12345);
	EXPECT_EQUAL_UINT32("EXPECT_EQUAL_INT32", 1234567, 1234567);

	/* float values */
	EXPECT_EQUAL_FLOAT32("EXPECT_EQUAL_FLOAT32", (etFloat32) 123.456, (etFloat32) 123.456, (etFloat32) 0.0001);
	EXPECT_EQUAL_FLOAT32("EXPECT_EQUAL_FLOAT32", (etFloat32) 123.456, (etFloat32) 123.456, (etFloat32) 0.0001);

	/* Pointers */
	etUInt16 value;
	etUInt16* valuePtr = &value;

	EXPECT_EQUAL_PTR("EXPECT_EQUAL_PTR", &value, valuePtr) \

}


void TestEtUnit_Expect_Order(void){
	etInt16 list[] = {1,2,3,4};
	EXPECT_ORDER_START(list, 4);
	EXPECT_ORDER("id=1", 1);
	EXPECT_ORDER("id=2", 2);
	EXPECT_ORDER("id=3", 3);
	EXPECT_ORDER_END("id=4", 4);
}

void TestEtUnit_runSuite(void){
	etUnit_openTestSuite("TestEtUnit");
	ADD_TESTCASE(TestEtUnit_Expect_Order);
	ADD_TESTCASE(TestEtUnit_Expect);
	etUnit_closeTestSuite();
}


