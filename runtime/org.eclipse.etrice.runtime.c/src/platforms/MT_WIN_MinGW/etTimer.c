/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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


#ifdef ET_RUNTIME_WIN_TIMER_MM

VOID CALLBACK etTimer_callback(UINT uTimerID, UINT uMsg, DWORD_PTR dwUser, DWORD_PTR dw1, DWORD_PTR dw2);

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData){
    ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "construct")
    {
        self->osTimerData = 0;
        self->timerInterval.sec = timerInterval->sec;
        self->timerInterval.nSec = timerInterval->nSec;
        self->timerFunction = timerFunction;
        self->timerFunctionData = timerFunctionData;
    }
    ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_start(etTimer* self){
    ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "start")
    {
        /* calculate the time in milliseconds -> accuracy of nSec will get lost in windows! */
        UINT elapse = etTimeHelpers_convertToMSec(&(self->timerInterval));
        self->osTimerData = timeSetEvent(/*interval*/ elapse, /*res (ms)*/ 1, etTimer_callback, (DWORD_PTR)self, TIME_PERIODIC);
        if (self->osTimerData == 0) {
            etLogger_logError("etTimer_start: Timer could not be created");
        }
    }
    ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_stop(etTimer* self){
    ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "stop")
    if (timeKillEvent(self->osTimerData) == TIMERR_NOERROR) {
        self->osTimerData = 0;
    }
    else {
        etLogger_logError("etTimer_stop: Timer could not be stopped");
    }
    ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_destruct(etTimer* self){
    ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "destruct")
    ET_MSC_LOGGER_SYNC_EXIT
}

VOID CALLBACK etTimer_callback(UINT uTimerID, UINT uMsg, DWORD_PTR dwUser, DWORD_PTR dw1, DWORD_PTR dw2) {
    ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "callback")
    {
        etTimer* self = (etTimer*) dwUser;
        self->timerFunction(self->timerFunctionData);
    }
    ET_MSC_LOGGER_SYNC_EXIT
}

#else /* ET_RUNTIME_WIN_TIMER_MM */

/** global handle for the Windows timer queue */
static HANDLE hTimerQueue = NULL;

VOID CALLBACK etTimer_callback(PVOID lpParameter, BOOLEAN TimerOrWaitFired);

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "construct")
	{
		self->osTimerData = NULL;
		self->timerInterval.sec = timerInterval->sec;
		self->timerInterval.nSec = timerInterval->nSec;
		self->timerFunction = timerFunction;
		self->timerFunctionData = timerFunctionData;
		if (hTimerQueue == NULL){
			/* the Windows timer queue is only needed once for all timers */
			hTimerQueue = CreateTimerQueue();
			if (hTimerQueue == NULL){
				etLogger_logError("etTimer_construct: CreateTimerQueue failed");
			}
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_start(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "start")
	{
		/* calculate the time in milliseconds -> accuracy of nSec will get lost in windows! */
		UINT elapse = etTimeHelpers_convertToMSec(&(self->timerInterval));

		if (hTimerQueue == NULL){
			etLogger_logError("etTimer_start: no Timer Queue to create timer (NULL)");
		}
		else {
		if (CreateTimerQueueTimer(&(self->osTimerData), hTimerQueue,
				etTimer_callback, self, elapse, elapse, 0) == ET_FALSE) {
				etLogger_logError("etTimer_start: Timer could not be created");
			}
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_stop(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "stop")
	/* To wait until timer has expired use INVALID_HANDLE_VALUE */
	if (DeleteTimerQueueTimer(hTimerQueue, self->osTimerData, NULL) == ET_FALSE){
		/* ERROR_IO_PENDING indicates outstanding callback functions => no error */
		if(GetLastError() != ERROR_IO_PENDING)
			etLogger_logError("etTimer_stop: Timer could not be stopped");
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_destruct(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "destruct")
	/* TODO: destroy hTimerQueue if last timer is destroyed  */
	/* DeleteTimerQueue(hTimerQueue); */
	ET_MSC_LOGGER_SYNC_EXIT
}

VOID CALLBACK etTimer_callback(PVOID lpParameter, BOOLEAN TimerOrWaitFired) {
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "callback")
	{
		etTimer* self = (etTimer*) lpParameter;
		self->timerFunction(self->timerFunctionData);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

#endif // ET_RUNTIME_WIN_TIMER_MM
