/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz, Thomas Jung (initial contribution)
 *
 *******************************************************************************/


#include "osal/etSema.h"
#include "osal/etTimer.h"

#include "debugging/etMSCLogger.h"
#include "helpers/etTimeHelpers.h"

extern etTimer * singleThreadedTimer;

void etSema_construct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "construct")

	ET_MSC_LOGGER_SYNC_EXIT
}
void etSema_destruct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "destruct")

	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_wakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "wakeup")

	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_waitForWakeup(etSema* self){
	static etTime nextTime = {0,0};
	etTime actualTime;
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "waitForWakeup")
	/* busy wait as specified in etphys */
	getTimeFromTarget(&actualTime);
	if (etTimeHelpers_isGreater(&actualTime, &nextTime)){
		etTimeHelpers_add(&nextTime,&(singleThreadedTimer->timerInterval));
		/* call the do actions for the single thread */
		singleThreadedTimer->timerFunction(singleThreadedTimer->timerFunctionData);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_wakeupFromISR(etSema* self){
   ET_MSC_LOGGER_SYNC_ENTRY("etSema", "wakeupFromISR")

   ET_MSC_LOGGER_SYNC_EXIT
}

