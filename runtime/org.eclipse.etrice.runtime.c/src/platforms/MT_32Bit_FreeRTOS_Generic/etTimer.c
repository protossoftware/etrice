/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution), Thomas Jung
 *
 *******************************************************************************/

/**
 *
 * etTimer.c FreeRTOS implementation of etTimer
 *
 */

#include "osal/etTimer.h"
#include "helpers/etTimeHelpers.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

void etTimer_callback(xTimerHandle timer);

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "construct")
	{
		self->osTimerData = NULL;
		self->timerInterval.sec = timerInterval->sec;
		self->timerInterval.nSec = timerInterval->nSec;
		self->timerFunction = timerFunction;
		self->timerFunctionData = timerFunctionData;
	}

	portTickType period = (timerInterval->sec*configTICK_RATE_HZ) + (timerInterval->nSec / (1000000000 / configTICK_RATE_HZ));


	self->osTimerData = xTimerCreate ( "etTimer", period, pdTRUE, (void *) self, etTimer_callback );

	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_start(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "start")
		if (xTimerStart( self->osTimerData, 0 ) != pdPASS){
			while(1){};
		}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_stop(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "stop")
		 if (xTimerStop( self->osTimerData, 0 ) != pdPASS){
			 while(1){};
		 }
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_destruct(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "destruct")

		 if (xTimerDelete( self->osTimerData, 0 ) != pdPASS){
			 while(1){};
		 }
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_callback(xTimerHandle timer){
	{
		etTimer* self = (etTimer*) pvTimerGetTimerID( timer );
		self->timerFunction(self->timerFunctionData);
	}
}
