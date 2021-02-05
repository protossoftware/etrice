/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

#include "base/etMemory_VariableSize.h"
#include "base/etQueue.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"


#define DO_LOCK	\
	if (self->base.lock!=NULL) {								\
		self->base.lock->lockFct(self->base.lock->lockData);	\
	}

#define DO_UNLOCK	\
	if (self->base.lock!=NULL) {								\
		self->base.lock->unlockFct(self->base.lock->lockData);	\
	}

typedef struct etVariableSizeMemory {
	etMemory base;					/** the "base class" */

	etUInt8* current;				/**< next free position on the heap */
} etVariableSizeMemory;


void* etMemory_VariableSize_alloc(etMemory* heap, etUInt16 size) {
	etVariableSizeMemory* self = (etVariableSizeMemory*) heap;
	void* mem = NULL;
	size = MEM_CEIL(size);

	DO_LOCK
	if (size > 0 && self->current + size < ((etUInt8*)self) + self->base.size) {
		etUInt32 used;

		mem = (void*) self->current;
		self->current += size;

		used = self->current - ((etUInt8*)self);
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
	etUInt32 data_size = MEM_CEIL(sizeof(etVariableSizeMemory));
	etUInt32 actual_size = size - data_size;
	etMemory* result = NULL;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "init")

	if (heap!=NULL && size > data_size) {
		result = &self->base;

		etMemory_init(result, actual_size, etMemory_VariableSize_alloc, etMemory_VariableSize_free);

		self->current = ((etUInt8*)self)+data_size;
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return result;
}

etUInt8 etMemory_VariableSize_freeHeapMem(etMemory* mem) {
	etVariableSizeMemory* self = (etVariableSizeMemory*) mem;
	return ((etUInt8*) self) + self->base.size - self->current;
}
