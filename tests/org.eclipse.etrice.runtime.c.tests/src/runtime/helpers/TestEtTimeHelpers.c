/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "TestEtTimeHelpers.h"
#include "helpers/etTimeHelpers.h"

#include "etUnit/etUnit.h"

/* 1 second in nano seconds */
#define _1E9 1000000000

static void TestEtTimeHelpers_normalize (etInt16 id) {
	etTime time1;

	time1.sec = 5;
	time1.nSec = 33;
	etTimeHelpers_normalize(&time1);
	EXPECT_EQUAL_INT32(id, "sec normal case", 5, time1.sec);
	EXPECT_EQUAL_INT32(id, "nSec normal case", 33, time1.nSec);

	time1.sec = 5;
	time1.nSec = -33;
	etTimeHelpers_normalize(&time1);
	EXPECT_EQUAL_INT32(id, "sec normal case", 4, time1.sec);
	EXPECT_EQUAL_INT32(id, "nSec normal case", _1E9-33, time1.nSec);

	time1.sec = 5;
	time1.nSec = _1E9 + 33;
	etTimeHelpers_normalize(&time1);
	EXPECT_EQUAL_INT32(id, "sec normal case", 6, time1.sec);
	EXPECT_EQUAL_INT32(id, "nSec normal case", 33, time1.nSec);

	time1.sec = -5;
	time1.nSec = -33;
	etTimeHelpers_normalize(&time1);
	EXPECT_EQUAL_INT32(id, "sec normal case", -6, time1.sec);
	EXPECT_EQUAL_INT32(id, "nSec normal case", _1E9-33, time1.nSec);
}

static void TestEtTimeHelpers_convertToMSec (etInt16 id) {
	etInt32 result;
	etTime time;

	time.sec = 0;
	time.nSec = 0;
	result = etTimeHelpers_convertToMSec(&time);
	EXPECT_EQUAL_INT32(id, "0 ms", 0, result);

	time.sec = 1;
	time.nSec = 1000000;
	result = etTimeHelpers_convertToMSec(&time);
	EXPECT_EQUAL_INT32(id, "1001 ms", 1001, result);

	time.sec = 1111;
	time.nSec = 55000000;
	result = etTimeHelpers_convertToMSec(&time);
	EXPECT_EQUAL_INT32(id, "111055 ms", 1111055, result);

}

static void TestEtTimeHelpers_convertToEtTime (etInt16 id) {
	etInt32 ms_time;
	etTime result;

	ms_time=0;
	etTimeHelpers_convertToEtTime(&result, ms_time);
	EXPECT_EQUAL_INT32(id, "0 s", 0, result.sec);
	EXPECT_EQUAL_INT32(id, "0 ns", 0, result.nSec);

	ms_time=1234567;
	etTimeHelpers_convertToEtTime(&result, ms_time);
	EXPECT_EQUAL_INT32(id, "1234 s", 1234, result.sec);
	EXPECT_EQUAL_INT32(id, "567000000 ns", 567000000, result.nSec);

}

static void TestEtTimeHelpers_copy (etInt16 id) {
	etTime time1;
	etTime time2;
	time1.sec = 5;
	time1.nSec = 33;

	etTimeHelpers_copy(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "copy sec failed", 5, time2.sec);
	EXPECT_EQUAL_INT32(id, "copy nSec failed", 33, time2.nSec);
}


static void TestEtTimeHelpers_add (etInt16 id) {
	etTime time1;
	etTime time2;

	time1.sec = 5;
	time1.nSec = 33;
	time2.sec = 3;
	time2.nSec = 12;
	etTimeHelpers_add(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "add normal case sec failed", 8, time1.sec);
	EXPECT_EQUAL_INT32(id, "add normal case nSec failed", 45, time1.nSec);

	time1.sec = 5;
	time1.nSec = 900000000;
	time2.sec = 3;
	time2.nSec = 100000001;
	etTimeHelpers_add(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "add overflow case for sec failed", 9, time1.sec);
	EXPECT_EQUAL_INT32(id, "add overflow case for nSec failed", 1, time1.nSec);

	time1.sec = 5;
	time1.nSec = 900000000;
	time2.sec = -3;
	time2.nSec = 100000001;
	etTimeHelpers_add(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "add negative and overflow case for sec failed", 3, time1.sec);
	EXPECT_EQUAL_INT32(id, "add negative and overflow case for nSec failed", 1, time1.nSec);

	time1.sec = -5;
	time1.nSec = 44;
	time2.sec = 3;
	time2.nSec = 55;
	etTimeHelpers_add(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "add negative case for sec failed", -2, time1.sec);
	EXPECT_EQUAL_INT32(id, "add negative case for nSec failed", 99, time1.nSec);
}

static void TestEtTimeHelpers_subtract (etInt16 id) {
	etTime time1;
	etTime time2;

	time1.sec = 3;
	time1.nSec = 33;
	time2.sec = 2;
	time2.nSec = 12;
	etTimeHelpers_subtract(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "subtract normal case for sec failed", 1, time1.sec);
	EXPECT_EQUAL_INT32(id, "subtract normal case for nSec failed", 21, time1.nSec);

	time1.sec = 3;
	time1.nSec = 100000000;
	time2.sec = 2;
	time2.nSec = 900000000;
	etTimeHelpers_subtract(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "subtract overflow case for sec failed", 0, time1.sec);
	EXPECT_EQUAL_INT32(id, "subtract overflow case for nSec failed", 200000000, time1.nSec);

	time1.sec = 3;
	time1.nSec = 33;
	time2.sec = -2;
	time2.nSec = 12;
	etTimeHelpers_subtract(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "subtract negative case for sec failed", 5, time1.sec);
	EXPECT_EQUAL_INT32(id, "subtract negative case for nSec failed", 21, time1.nSec);

	time1.sec = 3;
	time1.nSec = 100000000;
	time2.sec = -2;
	time2.nSec = 900000000;
	etTimeHelpers_subtract(&time1, &time2);
	EXPECT_EQUAL_INT32(id, "subtract negative and overflow case for sec failed", 4, time1.sec);
	EXPECT_EQUAL_INT32(id, "subtract negative and overflow case for nSec failed", 200000000, time1.nSec);

}

void TestEtTimeHelpers_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestEtTimeHelpers");
	ADD_TESTCASE(TestEtTimeHelpers_convertToMSec);
	ADD_TESTCASE(TestEtTimeHelpers_convertToEtTime);
	ADD_TESTCASE(TestEtTimeHelpers_copy);
	ADD_TESTCASE(TestEtTimeHelpers_add);
	ADD_TESTCASE(TestEtTimeHelpers_subtract);
	ADD_TESTCASE(TestEtTimeHelpers_normalize);
	etUnit_closeTestSuite();
}


