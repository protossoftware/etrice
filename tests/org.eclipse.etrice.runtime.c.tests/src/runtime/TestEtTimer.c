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

static etSema GlobalSema;
static etInt32 counter;

static void TestEtTimer_TimerCallback1(void* data){
	printf("TestEtTimer_TimerCallback1\n"); fflush(stdout); // TODO: remove debug output
	etSema_wakeup(&GlobalSema);
}

static void TestEtTimer_TimerCallback2(void* data){
	printf("TestEtTimer_TimerCallback2\n"); fflush(stdout); // TODO: remove debug output
	counter++;
}

static void TestEtTimer_lifecycle (etInt16 id) {
	etTimer timer1;
	etTime interval;
	etTime startTime;
	etTime endTime;
	/* create and start timer */
	etTimeHelpers_convertToEtTime(&interval, 1050);
	etTimer_construct(
			&timer1,
			&interval,
			TestEtTimer_TimerCallback1,
			NULL);

	/* create semaphore */
	etSema_construct(&GlobalSema);

	getTimeFromTarget(&startTime);
	printf("TestEtTimer_lifecycle: start timer\n"); fflush(stdout); // TODO: remove debug output
	etTimer_start(&timer1);
	printf("TestEtTimer_lifecycle: wait for timer %ld\n", etThread_self_id()); fflush(stdout); // TODO: remove debug output
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the first time (fires immediately) */
	printf("TestEtTimer_lifecycle: wait again\n"); fflush(stdout); // TODO: remove debug output
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the second time (fires after first interval)*/
	etTimer_stop(&timer1);
	getTimeFromTarget(&endTime);

	printf("TestEtTimer_lifecycle: timer stopped\n"); fflush(stdout); // TODO: remove debug output

	{
		etInt32 elapsed = etTimeHelpers_convertToMSec(&endTime) - etTimeHelpers_convertToMSec(&startTime);
		EXPECT_TRUE(id, "elapsed time wrong", (elapsed > 2100) && (elapsed < 2200));

		printf("TestEtTimer_lifecycle: elapsed %d\n", (int)elapsed); fflush(stdout); // TODO: remove debug output
	}

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
	interval.nSec = 50000000; /* = 50 milliseconds */
	etTimer_construct(&timer2, &interval, TestEtTimer_TimerCallback2, NULL);

	printf("TestEtTimer_multiTimer: start timer1\n"); fflush(stdout); // TODO: remove debug output
	etTimer_start(&timer1);
	printf("TestEtTimer_multiTimer: start timer2\n"); fflush(stdout); // TODO: remove debug output
	etTimer_start(&timer2);

	printf("TestEtTimer_multiTimer: wait for timer (sema %p, thread %ld)\n", (void*)&GlobalSema, etThread_self_id()); fflush(stdout); // TODO: remove debug output
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the first time (fires immediately) */
	printf("TestEtTimer_multiTimer: wait again for timer (thread %ld)\n", etThread_self_id()); fflush(stdout); // TODO: remove debug output
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the second time (fires after first interval)*/

	printf("TestEtTimer_multiTimer: stop timers %ld\n", etThread_self_id()); fflush(stdout); // TODO: remove debug output

	//sleep(10);

	etTimer_stop(&timer2);
	etTimer_stop(&timer1);

	printf("TestEtTimer_multiTimer: counter %d\n", (int)counter); fflush(stdout); // TODO: remove debug output

	EXPECT_TRUE(id, "counter wrong", (counter > 33) && (counter < 45));
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
