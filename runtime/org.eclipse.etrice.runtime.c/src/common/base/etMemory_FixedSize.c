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

#include "base/etMemory_FixedSize.h"
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

#define GET_FREE 	(etQueue_getSize(&self->blockPool) * self->blockSize)

typedef struct etFixedSizeMemory {
	etMemory base;

	etUInt8 *buffer;				/**< the heap to be allocated from */
	etUInt16 maxBlocks;				/**< the maximum number of blocks */
	etUInt16 blockSize;				/**< block size */
	etQueue blockPool;				/**< pool of free blocks */
} etFixedSizeMemory;


void* etMemory_FixedSize_alloc(etMemory* heap, etUInt16 size) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) heap;
	void* mem = NULL;
	size = MEM_CEIL(size);

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "alloc")

	DO_LOCK
	if (size<=self->blockSize){
		if (self->blockPool.size>0) {
			etUInt32 used;
			mem = etQueue_pop(&self->blockPool);
			used = self->base.size - GET_FREE;
			if (used > self->base.statistics.maxUsed) {
				self->base.statistics.maxUsed = used;
			}
		}
	}
	if (mem==NULL) {
		self->base.statistics.nFailingRequests++;
	}
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

void etMemory_FixedSize_free(etMemory* heap, void* obj) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) heap;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "free")

	DO_LOCK
	etQueue_push(&self->blockPool, obj);
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
}

/*
 * the public interface
 */
etMemory* etMemory_FixedSize_init(void* heap, etUInt32 size, etUInt16 blockSize) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) heap;
	etUInt32 data_size = MEM_CEIL(sizeof(etFixedSizeMemory));
	etUInt32 actual_size = size - data_size;
	etMemory* result = NULL;
	int i;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "init")

	if (heap!=NULL && size > data_size) {
		result = &self->base;

		etMemory_init(result, actual_size, etMemory_FixedSize_alloc, etMemory_FixedSize_free);

		self->buffer = ((etUInt8*) self) + data_size;
		self->blockSize = blockSize;
		self->maxBlocks = (size - data_size) / self->blockSize;
		etQueue_init(&self->blockPool);
		for (i=0; i<self->maxBlocks; i++){
			void* block = &(self->buffer[i*self->blockSize]);
			etQueue_push(&self->blockPool, block);
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT

	return result;
}

etUInt32 etMemory_FixedSize_getFreeHeapMem(etMemory* mem) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) mem;
	etUInt32 result;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "getFreeHeapMem")

	DO_LOCK
	result = GET_FREE;
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
	return result;
}
