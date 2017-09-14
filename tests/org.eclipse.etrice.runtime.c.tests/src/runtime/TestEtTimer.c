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
static etBool timerIsInvalidated;

static void TestEtTimer_TimerCallback1(void* data){
	if(!timerIsInvalidated)
		etSema_wakeup(&GlobalSema);
}

static void TestEtTimer_TimerCallback2(void* data){
	if(!timerIsInvalidated)
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
	timerIsInvalidated = false;

	getTimeFromTarget(&startTime);
	etTimer_start(&timer1);
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the first time (fires immediately) */
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the second time (fires after first interval)*/
	timerIsInvalidated = true;
	etTimer_stop(&timer1);
	getTimeFromTarget(&endTime);


	{
		etInt32 elapsed = etTimeHelpers_convertToMSec(&endTime) - etTimeHelpers_convertToMSec(&startTime);
		char buffer[64];
		EXPECT_TRUE(id, buffer, (elapsed >= 2100) && (elapsed <= 2200));

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
	timerIsInvalidated = false;

	/* create semaphore */
	etSema_construct(&GlobalSema);

	interval.sec = 1; /* = 1000 milliseconds */
	interval.nSec = 0; /* = 0 milliseconds */
	etTimer_construct(&timer1, &interval, TestEtTimer_TimerCallback1, NULL);
	interval.sec = 0; /* = 0 seconds */
	interval.nSec = 50000000; /* = 50 milliseconds */
	etTimer_construct(&timer2, &interval, TestEtTimer_TimerCallback2, NULL);

	etTimer_start(&timer1);
	etTimer_start(&timer2);

	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the first time (fires immediately) */
	etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer the second time (fires after first interval)*/


	//sleep(10);

	timerIsInvalidated = true;
	etTimer_stop(&timer2);
	etTimer_stop(&timer1);


	EXPECT_TRUE(id, "counter wrong", (counter > 25) && (counter < 45));
	etTimer_destruct(&timer2);
	etTimer_destruct(&timer1);

	etSema_destruct(&GlobalSema);

}

void TestEtTimer_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestEtTimer");
	ADD_TESTCASE(TestEtTimer_lifecycle);
	ADD_TESTCASE(TestEtTimer_multiTimer);
	etUnit_closeTestSuite();
}
