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
 * 		Thomas Schuetz (initial contribution), Thomas Jung
 *
 *******************************************************************************/

#include "osal/etTimer.h"
#include "helpers/etTimeHelpers.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

etTimer * singleThreadedTimer = 0;

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "construct")
	{
		self->osTimerData = NULL;
		self->timerInterval.sec = timerInterval->sec;
		self->timerInterval.nSec = timerInterval->nSec;
		self->timerFunction = timerFunction;
		self->timerFunctionData = timerFunctionData;
	}
	/* store the timer, it will be needed to call the do actions */
	singleThreadedTimer = self;

	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_start(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "start")

	ET_MSC_LOGGER_SYNC_EXIT
}


void etTimer_stop(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "stop")

	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_destruct(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "destruct")

	ET_MSC_LOGGER_SYNC_EXIT
}


