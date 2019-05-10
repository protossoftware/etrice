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

#include "base/etMemory_FreeList.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

#define UNUSED_LIST			0
#define DEBUG_FREE_LISTS	1
#define OBJ_OFFSET			etALIGNMENT

#define DO_LOCK	\
	if (self->base.lock!=NULL) {								\
		self->base.lock->lockFct(self->base.lock->lockData);	\
	}

#define DO_UNLOCK	\
	if (self->base.lock!=NULL) {								\
		self->base.lock->unlockFct(self->base.lock->lockData);	\
	}

typedef struct etFreeListObj {
	struct etFreeListObj* next;
} etFreeListObj;

typedef struct etFreeListInfo {
	etUInt16 objsize;		/**< the size in bytes of the objects in this list */
	etFreeListObj* head;	/**< the list head */

#if DEBUG_FREE_LISTS
	etUInt16 nobjects;		/**< the number of objects in the list */
#endif

} etFreeListInfo;

typedef struct etFreeListMemory {
	etMemory base;					/** the "base class" */
	etUInt8* current;				/**< next free position on the heap */
	etUInt16 nslots;				/**< number of free lists */
	roundUpSize* roundUp;			/**< rounding method (identity by default) */
	etFreeListInfo freelists[1];	/**< array of free list infos (array used with size nslots) */
} etFreeListMemory;

/*
 * private functions
 */
static void* etMemory_FreeList_getHeapMem(etFreeListMemory* self, etUInt16 size) {
	etUInt8* obj = NULL;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList", "getHeapListMem")

	if (self->current + size < ((etUInt8*)self) + self->base.size)
	{
		etUInt32 used;

		// store size in the first bytes
		*((etUInt16*)self->current) = size;

		// object pointer at offset
		obj = self->current + OBJ_OFFSET;

		// shift current
		self->current += size;

		used = ((etUInt8*)self) + self->base.size - self->current;
		if (used > self->base.statistics.maxUsed) {
			self->base.statistics.maxUsed = used;
		}
	}

	if (obj==NULL) {
		self->base.statistics.nFailingRequests++;
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return obj;
}

static void* etMemory_FreeList_getFreeListMem(etFreeListMemory* self, etUInt16 size) {
	etUInt8* mem = NULL;
	int asize, slot_offset, slot, slot_size;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList", "getFreeListMem")

	asize = (size / etALIGNMENT);
	for (slot_offset = 0; slot_offset < self->nslots; slot_offset++) {
		slot = (asize + slot_offset) % self->nslots;
		slot_size = self->freelists[slot].objsize;
		if (slot_size == size) {
			if (self->freelists[slot].head != NULL) {
				etFreeListObj* obj = self->freelists[slot].head;
				self->freelists[slot].head = obj->next;
				mem = (void *) obj;
#if DEBUG_FREE_LISTS
				--self->freelists[slot].nobjects;
#endif
			}
			break;
		}
		else if (slot_size == UNUSED_LIST)
			break;
	}
	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

static void etMemory_FreeList_putFreeListMem(etFreeListMemory* self, void* obj) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList", "putFreeListMem")
	{
		int asize, slot_offset, slot, slot_size;
		etUInt16 size = *((etUInt16*) (((etUInt8*) obj) - OBJ_OFFSET));

		asize = (size / etALIGNMENT);
		for (slot_offset = 0; slot_offset < self->nslots; slot_offset++) {
			slot = (asize + slot_offset) % self->nslots;
			slot_size = self->freelists[slot].objsize;
			if (slot_size == size) {
				/* we insert the object as new head */
				((etFreeListObj*)obj)->next = self->freelists[slot].head;
				self->freelists[slot].head = (etFreeListObj*)obj;
#if DEBUG_FREE_LISTS
				++(self->freelists[slot].nobjects);
#endif
				break;
			}
			else if (slot_size == UNUSED_LIST) {
				/* initialize unused list and insert the object as new head */
				self->freelists[slot].objsize = size;
				((etFreeListObj*)obj)->next = NULL;
				self->freelists[slot].head = (etFreeListObj*)obj;
#if DEBUG_FREE_LISTS
				self->freelists[slot].nobjects = 1;
#endif
				break;
			}
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

static void* etMemory_FreeList_alloc(etMemory* heap, etUInt16 size) {
	etFreeListMemory* self = (etFreeListMemory*) heap;
	void* mem;

	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList", "alloc")

	// rounded required size + space to store the size
	size = MEM_CEIL(self->roundUp(size) + OBJ_OFFSET);

	DO_LOCK
	mem = etMemory_FreeList_getFreeListMem((etFreeListMemory*) heap, size);
	if (mem==NULL) {
		mem = etMemory_FreeList_getHeapMem((etFreeListMemory*) heap, size);
	}
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
	return mem;
}

static void etMemory_FreeList_free(etMemory* heap, void* obj) {
	etFreeListMemory* self = (etFreeListMemory*) heap;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList", "free")

	DO_LOCK
	etMemory_FreeList_putFreeListMem(self, obj);
	DO_UNLOCK

	ET_MSC_LOGGER_SYNC_EXIT
}

static etUInt16 etMemory_FreeList_identity(etUInt16 size) {
	return size;
}

etUInt16 etMemory_FreeList_power2(etUInt16 v) {
	/* https://graphics.stanford.edu/~seander/bithacks.html#RoundUpPowerOf2 */
	v--;
	v |= v >> 1;
	v |= v >> 2;
	v |= v >> 4;
	v |= v >> 8;
	v++;
	return v;
}


/*
 * the public interface
 */
etMemory* etMemory_FreeList_init(void* heap, etUInt32 size, etUInt16 nslots) {
	etFreeListMemory* self = (etFreeListMemory*) heap;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList_init", "init")
	etUInt32 data_size = MEM_CEIL(sizeof(etFreeListMemory)+(nslots-1)*sizeof(etFreeListInfo));
	etUInt32 actual_size = size - data_size;
	etMemory* result = NULL;

	if (heap!=NULL & size > data_size) {
		result = &self->base;

		etMemory_init(result, actual_size, etMemory_FreeList_alloc, etMemory_FreeList_free);

		self->roundUp = etMemory_FreeList_identity;
		self->nslots = nslots;
		self->current = ((etUInt8*) self) + data_size;

		/* initialize the free lists */
		{
			int i;
			for (i=0; i<self->nslots; ++i)
				self->freelists[i].objsize = UNUSED_LIST;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return result;
}

void etMemory_FreeList_setUserRounding(etMemory* mem, roundUpSize* roundup) {
	etFreeListMemory* self = (etFreeListMemory*) mem;
	ET_MSC_LOGGER_SYNC_ENTRY("etMemory_FreeList_init", "setUserRounding")
	self->roundUp = roundup;
	ET_MSC_LOGGER_SYNC_EXIT
}

etUInt32 etMemory_FreeList_getFreeHeapMem(etMemory* mem) {
	etFreeListMemory* self = (etFreeListMemory*) mem;

	DO_LOCK
	etUInt32 result = ((etUInt8*) self) + self->base.size - self->current;
	DO_UNLOCK

	return result;
}

etUInt16 etMemory_FreeList_freeSlots(etMemory* mem) {
	etFreeListMemory* self = (etFreeListMemory*) mem;
	etUInt16 free = 0;
	int slot;

	DO_LOCK
	for (slot=0; slot<self->nslots; ++slot)
		if (self->freelists[slot].objsize==UNUSED_LIST)
			++free;
	DO_UNLOCK

	return free;
}

etUInt16 etMemory_FreeList_nObjects(etMemory* mem, etUInt16 slot) {
	etUInt16 result = 0;
#if DEBUG_FREE_LISTS
	etFreeListMemory* self = (etFreeListMemory*) mem;
	DO_LOCK
	if (slot<self->nslots) {
		result = self->freelists[slot].nobjects;
	}
	DO_UNLOCK
#endif
	return result;
}

etUInt16 etMemory_FreeList_sizeObjects(etMemory* mem, etUInt16 slot) {
	etFreeListMemory* self = (etFreeListMemory*) mem;
	etUInt16 result = 0;
	DO_LOCK
	if (slot<self->nslots) {
		result = self->freelists[slot].objsize - OBJ_OFFSET;
	}
	DO_UNLOCK
	return result;
}

etUInt16 etMemory_FreeList_MgmtDataPerObject() {
	return OBJ_OFFSET;
}
