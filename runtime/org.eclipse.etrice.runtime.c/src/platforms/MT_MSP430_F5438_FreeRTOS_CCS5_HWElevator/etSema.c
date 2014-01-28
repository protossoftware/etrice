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

/**
 *
 * etSema.c MinGW implementation of etSema
 *
 */

#include "osal/etSema.h"

#include "debugging/etMSCLogger.h"


void etSema_construct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "construct")
		self->osData = xSemaphoreCreateCounting( 1, 0 );
	ET_MSC_LOGGER_SYNC_EXIT
}
void etSema_destruct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "destruct")
		vSemaphoreDelete( self->osData );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_wakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "wakeup")
		xSemaphoreGive( self->osData );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_waitForWakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "waitForWakeup")
			xSemaphoreTake(self->osData, portMAX_DELAY );
	ET_MSC_LOGGER_SYNC_EXIT
}
