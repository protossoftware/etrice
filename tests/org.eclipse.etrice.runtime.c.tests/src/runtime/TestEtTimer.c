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


#include "TestEtTimer.h"

#include "etUnit/etUnit.h"

#include "etDatatypes.h"
#include "osal/etTimer.h"
#include "osal/etSema.h"

#include "helpers/etTimeHelpers.h"

etSema GlobalSema;


VOID CALLBACK TestEtTimer_TimerCallback(HWND arg1, UINT arg2, UINT arg3, DWORD arg4){
//etTimerFunction_RETURN_VALUE TestEtTimer_TimerCallback(etTimerFunction_ARGUMENT_LIST){
	//etSema_wakeup(&GlobalSema);
	int i=5;
	printf("\nTestEtTimer_TimerCallback: tick: %d", i);
}

static void TestEtTimer_lifecycle (etInt16 id) {
	etTimer timer1;
	etTime interval;
	etTime startTime;
	etTime endTime;

	/* create semaphore */
	etSema_construct(&GlobalSema);
	/* create and start timer */
	interval.sec = 0; /* = 1000 milliseconds */
	interval.nSec = 500000000; /* = 50 milliseconds */
	etTimer_construct(&timer1, &interval, TestEtTimer_TimerCallback);
	etTimer_start(&timer1);


	getTimeFromTarget(&startTime);
	etThread_sleep(5000);
	//etSema_waitForWakeup(&GlobalSema); /* wait until callback function releases timer */
	etTimer_stop(&timer1);
	getTimeFromTarget(&endTime);


	printf("\nelapsed time: %ld\n", etTimeHelpers_convertToMSec(&endTime) - etTimeHelpers_convertToMSec(&startTime));

	/* release resources */
	etTimer_destruct(&timer1);
	etSema_destruct(&GlobalSema);
}


void TestEtTimer_runSuite(void){
	etUnit_openTestSuite("TestEtTimer");
	ADD_TESTCASE(TestEtTimer_lifecycle);
	etUnit_closeTestSuite();
}
