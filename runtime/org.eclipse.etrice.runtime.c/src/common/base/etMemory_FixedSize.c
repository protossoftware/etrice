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


typedef struct etFixedSizeMemory {
	etMemory base;

	etUInt8 *buffer;
	etUInt16 maxBlocks;
	etUInt16 blockSize;
	etQueue blockPool;
} etFixedSizeMemory;


void* etMemory_FixedSize_alloc(etMemory* heap, etUInt16 size) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) heap;
	void* mem = NULL;
	size = CEIL_ALIGN(size);

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "alloc")

	if (size<=self->blockSize){
		if (self->blockPool.size>0) {
			mem = etQueue_pop(&self->blockPool);
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

void etMemory_FixedSize_free(etMemory* heap, void* obj, etUInt16 size) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) heap;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "free")

	etQueue_push(&self->blockPool, obj);

	ET_MSC_LOGGER_SYNC_EXIT
}

/*
 * the public interface
 */
etMemory* etMemory_FixedSize_init(void* heap, etUInt16 size, etUInt16 blockSize) {
	etFixedSizeMemory* self = (etFixedSizeMemory*) heap;
	size_t data_size = CEIL_ALIGN(sizeof(etFixedSizeMemory));
	int i;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "init")

	self->base.size = size;
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
