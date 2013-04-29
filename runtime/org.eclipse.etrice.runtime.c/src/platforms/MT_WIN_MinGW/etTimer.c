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

/**
 *
 * etTimer.c MinGW implementation of etTimer
 *
 */

#include "osal/etTimer.h"
#include "helpers/etTimeHelpers.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"


/** global handle for the Windows timer queue */
static HANDLE hTimerQueue = NULL;

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction){
	self->osTimerData = NULL;
	self->timerInterval.sec = timerInterval->sec;
	self->timerInterval.nSec = timerInterval->nSec;
	self->timerFunction = timerFunction;
	if (hTimerQueue == NULL){
		/* the Windows timer queue is only needed once for all timers */
		hTimerQueue = CreateTimerQueue();
		if (hTimerQueue == NULL){
			etLogger_logError("etTimer_construct: CreateTimerQueue failed");
		}
	}
}

void etTimer_start(etTimer* self){
	UINT elapse;
	/* calculate the time in milliseconds -> accuracy will of nSec will get lost in windows! */
	elapse = etTimeHelpers_convertToMSec(&(self->timerInterval));

	if (hTimerQueue == NULL){
		etLogger_logError("etTimer_start: no Timer Queue to create timer (NULL)");
	}
	else {
		if (CreateTimerQueueTimer( &(self->osTimerData), hTimerQueue, self->timerFunction, NULL , 0, elapse, 0) == FALSE){
			etLogger_logError("etTimer_start: Timer could not be created");
		}
	}
}

void etTimer_stop(etTimer* self){
	if (DeleteTimerQueueTimer(hTimerQueue, self->osTimerData, NULL) == FALSE){
		etLogger_logError("etTimer_stop: Timer could not be stopped");
	}
}

void etTimer_destruct(etTimer* self){
	/* TODO: destroy hTimerQueue if last timer is destroyed  */
	/* DeleteTimerQueue(hTimerQueue); */
}
