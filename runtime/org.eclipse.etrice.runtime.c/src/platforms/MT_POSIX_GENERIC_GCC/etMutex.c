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
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

/**
 *
 * etMutex.c POSIX implementation of etMutex
 *
 */

#include "osal/etMutex.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

void etMutex_construct(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "construct")
	pthread_mutex_init(&(self->osData), NULL);
	ET_MSC_LOGGER_SYNC_EXIT
}
void etMutex_destruct(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "destruct")
	pthread_mutex_destroy(&(self->osData));
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMutex_enter(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "enter")
	pthread_mutex_lock(&(self->osData));
	ET_MSC_LOGGER_SYNC_EXIT
}
void etMutex_leave(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "leave")
	pthread_mutex_unlock(&(self->osData));
	ET_MSC_LOGGER_SYNC_EXIT
}
