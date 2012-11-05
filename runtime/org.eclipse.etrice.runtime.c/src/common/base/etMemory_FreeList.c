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

#include "base/etMemory.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

#define UNUSED_LIST		0
#define NSLOTS			128

/*
 * private data structures
 */

typedef struct etFreeListObj {
	struct etFreeListObj* next;
} etFreeListObj;

typedef struct etFreeListInfo {
	/** the size in bytes of the objects in this list */
	etUInt16 objsize;

	/** the list head */
	etFreeListObj* head;
} etFreeListInfo;

typedef struct etFreeListMemory {
	/** size of the heap in bytes */
	etUInt16 size;

	/** next free position on the heap */
	etUInt8* current;

	/** number of free lists */
	etUInt16 nslots;

	/** array of free list infos (array used with size nslots) */
	etFreeListInfo freelists[1];
} etFreeListMemory;

/*
 * private functions
 */
static void* etMemory_getHeapMem(etFreeListMemory* self, etUInt16 size) {
	etUInt8* obj = NULL;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "getHeapListMem")

	if (self->current < ((etUInt8*)self)+self->size)
	{
		obj = self->current;
		self->current += size;
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return obj;
}

static void* etMemory_getFreeListMem(etFreeListMemory* self, etUInt16 size) {
	etUInt8* mem = NULL;
	int asize, slot_offset, slot, slot_size;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "getFreeListMem")

	asize = (size / ALIGNMENT);
	for (slot_offset = 0; slot_offset < self->nslots; slot_offset++) {
		slot = (asize + slot_offset) % self->nslots;
		slot_size = self->freelists[slot].objsize;
		if (slot_size == size) {
			if (self->freelists[slot].head != NULL) {
				etFreeListObj* obj = self->freelists[slot].head;
				self->freelists[slot].head = obj->next;
				mem = (void *) obj;
			}
			break;
		}
		else if (slot_size == UNUSED_LIST)
			break;
	}
	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

static void etMemory_putFreeListMem(void* heap, void* obj, etUInt16 size) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "putFreeListMem")
	{
		etFreeListMemory* self = (etFreeListMemory*) heap;
		int asize, slot_offset, slot, slot_size;

		asize = (size / ALIGNMENT);
		for (slot_offset = 0; slot_offset < self->nslots; slot_offset++) {
			slot = (asize + slot_offset) % self->nslots;
			slot_size = self->freelists[slot].objsize;
			if (slot_size == size) {
				/* we insert the object as new head */
				((etFreeListObj*)obj)->next = self->freelists[slot].head;
				self->freelists[slot].head = (etFreeListObj*)obj;
				break;
			}
			else if (slot_size == UNUSED_LIST) {
				/* initialize unused list and insert the object as new head */
				self->freelists[slot].objsize = size;
				((etFreeListObj*)obj)->next = NULL;
				self->freelists[slot].head = (etFreeListObj*)obj;
				break;
			}
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

/*
 * the public interface
 */
void etMemory_init(void* heap, etUInt16 size) {
	etFreeListMemory* self = (etFreeListMemory*) heap;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "init")

	self->size = size;
	self->nslots = NSLOTS;
	{
		int used = sizeof(etFreeListMemory)+(self->nslots-1)*sizeof(etFreeListObj);
		self->current = ((etUInt8*)self)+CEIL_ALIGN(used);
	}

	/* initialize the free lists */
	{
		int i;
		for (i=0; i<self->nslots; ++i)
			self->freelists[i].objsize = UNUSED_LIST;
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void* etMemory_alloc(void* heap, etUInt16 size) {
	void* mem;
	size = CEIL_ALIGN(size);
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "alloc")

	mem = etMemory_getFreeListMem((etFreeListMemory*) heap, size);
	if (mem==NULL)
		mem = etMemory_getHeapMem((etFreeListMemory*) heap, size);

	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

void etMemory_free(void* heap, void* obj, etUInt16 size) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory", "free")
	{
		size = CEIL_ALIGN(size);
		etMemory_putFreeListMem((etFreeListMemory*) heap, obj, size);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
