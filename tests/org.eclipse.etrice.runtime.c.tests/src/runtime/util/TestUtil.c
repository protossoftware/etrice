/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "TestUtil.h"

#include "etUnit/etUnit.h"

#include "RandomGenerator.h"

static void TestFifoBuffer (etInt16 id) {
	EXPECT_TRUE(id, "TestFifoBuffer", FALSE);
}

static void TestRandomGenerator (etInt16 id) {
	RandomGenerator rand;
	int i;
	double result, sum, average;

	sum = average = 0;
	RandomGenerator_init(&rand, 0.321, -1, 1);
	for (i=0; i<1000; i++){
		result = RandomGenerator_getNext(&rand);
		EXPECT_RANGE_FLOAT64(id, "random [-1,+1]", -1., +1., result); /* check for range */
		sum += result;
	}
	average = sum / (float64)i;
	EXPECT_RANGE_FLOAT64(id, "average [-1,+1]", -0.1, 0.1, average); /* check for quality */

	sum = average = 0;
	RandomGenerator_init(&rand, 0.321, -500., 1000.);
	for (i=0; i<1000; i++){
		result = RandomGenerator_getNext(&rand);
		EXPECT_RANGE_FLOAT64(id, "random [-500,+1000]", -500., +1000., result); /* check for range */
		sum += result;
	}
	average = sum / (float64)i;
	EXPECT_RANGE_FLOAT64(id, "average [-500,+1000]", 245., 255., average); /* check for quality */


}


void TestUtil_runSuite(void){
	etUnit_openTestSuite("TestUtil");
	ADD_TESTCASE(TestFifoBuffer);
	ADD_TESTCASE(TestRandomGenerator);
	etUnit_closeTestSuite();
}


