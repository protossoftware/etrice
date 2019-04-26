/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "base/etMemory_VariableSize.h"
#include "base/etQueue.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"


#define DO_LOCK	\
	if (self->lock!=NULL) {								\
		self->lock->lockFct(self->lock->lockData);		\
	}

#define DO_UNLOCK	\
	if (self->lock!=NULL) {								\
		self->lock->unlockFct(self->lock->lockData);	\
	}

typedef struct etVariableSizeMemory {
	etMemory base;					/** the "base class" */

	etUInt8* current;				/**< next free position on the heap */
	etLock* lock;					/**< user supplied lock functions */
} etVariableSizeMemory;


void* etMemory_VariableSize_alloc(etMemory* heap, etUInt16 size) {
	etVariableSizeMemory* self = (etVariableSizeMemory*) heap;
	void* mem = NULL;
	size = MEM_CEIL(size);

	DO_LOCK
	if (self->current + size < ((etUInt8*)self) + self->base.size) {
		etUInt32 used;

		mem = (void*) self->current;
		self->current += size;

		used = ((etUInt8*)self) + self->base.size - self->current;
		if (used > self->base.statistics.maxUsed) {
			self->base.statistics.maxUsed = used;
		}
	}
	if (mem==NULL) {
		self->base.statistics.nFailingRequests++;
	}
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

void etMemory_VariableSize_free(etMemory* heap, void* obj) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "free")
	/* do nothing */
	ET_MSC_LOGGER_SYNC_EXIT
}

/*
 * the public interface
 */
etMemory* etMemory_VariableSize_init(void* heap, etUInt32 size) {
	etVariableSizeMemory* self = (etVariableSizeMemory*) heap;
	size_t data_size = MEM_CEIL(sizeof(etVariableSizeMemory));
	etMemory* result = NULL;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "init")

	if (size > data_size) {
		self->base.size = size;
		self->base.statistics.maxUsed = 0;
		self->base.statistics.nFailingRequests = 0;
		self->base.alloc = etMemory_VariableSize_alloc;
		self->base.free = etMemory_VariableSize_free;

		self->current = ((etUInt8*)self)+data_size;
		result = &self->base;
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return result;
}

etUInt8 etMemory_VariableSize_freeHeapMem(etMemory* mem) {
	etVariableSizeMemory* self = (etVariableSizeMemory*) mem;
	return ((etUInt8*) self) + self->base.size - self->current;
}

void etMemory_VariableSize_setUserLock(etMemory* mem, etLock* lock) {
	etVariableSizeMemory* self = (etVariableSizeMemory*) mem;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_VariableSize", "setUserLock")
	self->lock = lock;
	ET_MSC_LOGGER_SYNC_EXIT
}
