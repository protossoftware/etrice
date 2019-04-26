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

#include "base/etMemory_FixedSize.h"
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

#define GET_USED 	(etQueue_getSize(&self->blockPool) * self->blockSize)

typedef struct etFixedSizeMemory {
	etMemory base;

	etUInt8 *buffer;				/**< the heap to be allocated from */
	etUInt16 maxBlocks;				/**< the maximum number of blocks */
	etUInt16 blockSize;				/**< block size */
	etQueue blockPool;				/**< pool of free blocks */
	etLock* lock;					/**< user supplied lock functions */
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
			used = GET_USED;
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
	size_t data_size = MEM_CEIL(sizeof(etFixedSizeMemory));
	int i;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "init")

	self->base.size = size;
	self->base.statistics.maxUsed = 0;
	self->base.statistics.nFailingRequests = 0;
	self->base.alloc = etMemory_FixedSize_alloc;
	self->base.free = etMemory_FixedSize_free;

	if (size > data_size) {
		self->buffer = ((etUInt8*) self) + data_size;
		self->blockSize = blockSize;
		self->maxBlocks = (size - data_size) / self->blockSize;
		for (i=0; i<self->maxBlocks; i++){
			void* block = &(self->buffer[i*self->blockSize]);
			etQueue_push(&self->blockPool, block);
		}
	}
	else {
		self->blockSize = 0;
	}

	ET_MSC_LOGGER_SYNC_EXIT

	return &self->base;
}

void etMemory_FixedSize_setUserLock(etMemory* mem, etLock* lock) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) mem;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "setUserLock")
	self->lock = lock;
	ET_MSC_LOGGER_SYNC_EXIT
}

etUInt32 etMemory_FixedSize_getFreeHeapMem(etMemory* mem) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) mem;
	etUInt32 result;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FixedSize", "getFreeHeapMem")

	DO_LOCK
	result = GET_USED;
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
	return result;
}
