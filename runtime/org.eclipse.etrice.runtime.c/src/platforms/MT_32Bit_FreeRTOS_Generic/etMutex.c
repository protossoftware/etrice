/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Jung (initial contribution)
 *
 *******************************************************************************/

/**
 *
 * etMutex.c FreeRTOS implementation of etMutex
 *
 */

#include "osal/etMutex.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

void etMutex_construct(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "construct")
		self->osData = xSemaphoreCreateMutex();
		if((self->osData) == NULL){
			while(1){};
		}
	ET_MSC_LOGGER_SYNC_EXIT
}
void etMutex_destruct(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "destruct")
		vSemaphoreDelete( self->osData );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMutex_enter(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "enter")
		xSemaphoreTake(self->osData,portMAX_DELAY );
	ET_MSC_LOGGER_SYNC_EXIT
}
void etMutex_leave(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "leave")
		xSemaphoreGive(self->osData);
	ET_MSC_LOGGER_SYNC_EXIT
}
