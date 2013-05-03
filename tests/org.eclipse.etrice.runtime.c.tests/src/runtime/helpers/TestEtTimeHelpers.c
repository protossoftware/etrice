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



void TestEtTimeHelpers_runSuite(void){
	etUnit_openTestSuite("TestEtTimeHelpers");
	ADD_TESTCASE(TestEtTimeHelpers_convertToMSec);
	ADD_TESTCASE(TestEtTimeHelpers_convertToEtTime);
	etUnit_closeTestSuite();
}


