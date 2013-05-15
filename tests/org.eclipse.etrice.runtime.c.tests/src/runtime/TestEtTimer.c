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

#include <stdio.h>

#include "TestEtTimer.h"

#include "etUnit/etUnit.h"

#include "etDatatypes.h"
#include "osal/etTimer.h"
#include "helpers/etTimeHelpers.h"
#include "osal/etThread.h"
#include "osal/etSema.h"

#include "helpers/etTimeHelpers.h"

etSema GlobalSema;
etInt32 counter;

void TestEtTimer_TimerCallback1(void* data){
	printf("TestEtTimer_TimerCallback1\n"); fflush(stdout); // TODO: remove debug output
	etSema_wakeup(&GlobalSema);
}

void TestEtTimer_TimerCallback2(void* data){
	printf("TestEtTimer_TimerCallback2\n"); fflush(stdout); // TODO: remove debug output
	counter++;
}

static void TestEtTimer_lifecycle (etInt16 id) {
	etTimer timer1;
	etTime interval;
	etTime startTime;
	etTime endTime;

	/* create semaphore */
	etSema_construct(&GlobalSema);
	/* create and start timer */
	etTimeHelpers_convertToEtTime(&interval, 1050);
	etTimer_construct(
			&timer1,
			&interval,
			TestEtTimer_TimerCallback1,
			NULL);

	getTimeFromTarget(&startTime);
	printf("TestEtTimer_lifecycle: start timer\n"); fflush(stdout); // TODO: remove debug output
	etTimer_start(&timer1);
	printf("TestEtTimer_lifecycle: wait for timer\n"); fflush(stdout); // TODO: remove debug output
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the first time (fires immediately) */
	printf("TestEtTimer_lifecycle: wait again\n"); fflush(stdout); // TODO: remove debug output
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the second time (fires after first interval)*/
	etTimer_stop(&timer1);
	getTimeFromTarget(&endTime);

	printf("TestEtTimer_lifecycle: timer stopped\n"); fflush(stdout); // TODO: remove debug output

	etInt32 elapsed = etTimeHelpers_convertToMSec(&endTime) - etTimeHelpers_convertToMSec(&startTime);
	EXPECT_TRUE(id, "elapsed time wrong", (elapsed > 1400) && (elapsed < 1600));

	/* release resources */
	etTimer_destruct(&timer1);
	etSema_destruct(&GlobalSema);
}

static void TestEtTimer_multiTimer (etInt16 id) {
	etTimer timer1;
	etTimer timer2;
	etTime interval;
	counter = 0;


	/* create semaphore */
	etSema_construct(&GlobalSema);

	interval.sec = 1; /* = 1000 milliseconds */
	interval.nSec = 0; /* = 0 milliseconds */
	etTimer_construct(&timer1, &interval, TestEtTimer_TimerCallback1, NULL);
	interval.sec = 0; /* = 0 seconds */
	interval.nSec = 1000000; /* = 1 millisecond */
	etTimer_construct(&timer2, &interval, TestEtTimer_TimerCallback2, NULL);

	etTimer_start(&timer1);
	etTimer_start(&timer2);

	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the first time (fires immediately) */
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the second time (fires after first interval)*/


	etTimer_stop(&timer2);
	etTimer_stop(&timer1);

	EXPECT_TRUE(id, "counter wrong", (counter > 950) && (counter < 1050));
	etTimer_destruct(&timer2);
	etTimer_destruct(&timer1);

	etSema_destruct(&GlobalSema);

}

void TestEtTimer_runSuite(void){
	etUnit_openTestSuite("TestEtTimer");
	ADD_TESTCASE(TestEtTimer_lifecycle);
	ADD_TESTCASE(TestEtTimer_multiTimer);
	etUnit_closeTestSuite();
}
