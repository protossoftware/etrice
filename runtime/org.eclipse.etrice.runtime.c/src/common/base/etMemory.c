/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "base/etMemory.h"
#include "debugging/etMSCLogger.h"


#define DO_LOCK	\
	if (self->lock!=NULL) {								\
		self->lock->lockFct(self->lock->lockData);		\
	}

#define DO_UNLOCK	\
	if (self->lock!=NULL) {								\
		self->lock->unlockFct(self->lock->lockData);	\
	}

void etMemory_init(etMemory* self, etUInt32 size, etMemory_alloc* alloc, etMemory_free* free) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "init")

	self->name = NULL;
	self->size = size;
	self->lock = NULL;
	self->alloc = alloc;
	self->free = free;
	self->statistics.maxUsed = 0;
	self->statistics.nFailingRequests = 0;

	etRuntime_registerMemoryManagement(self);
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMemory_setUserLock(etMemory* self, etLock* lock) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "setUserLock")
	self->lock = lock;
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMemory_resetStatistics(struct etMemory* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "resetStatistics")
	DO_LOCK
	self->statistics.maxUsed = 0;
	self->statistics.nFailingRequests = 0;
	DO_UNLOCK
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMemory_destroy(etMemory* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "destroy")
	etRuntime_unregisterMemoryManagement(self);
	ET_MSC_LOGGER_SYNC_EXIT
}
