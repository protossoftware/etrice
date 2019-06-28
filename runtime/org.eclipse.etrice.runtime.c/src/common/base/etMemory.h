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

#ifndef _ETMEMORY_H_
#define _ETMEMORY_H_

#include "etDatatypes.h"
#include "osal/etLock.h"

ET_EXTERN_C_BEGIN

/**
 * this macro computes the memory aligned value for a given size. It uses the ALIGNMENT
 * defined in etDatatypes.h
 */
#define MEM_CEIL(n)          ((n)+((etALIGNMENT-((n)&(etALIGNMENT-1)))&(etALIGNMENT-1)))

struct etMemory;

/**
 * allocates memory from the heap
 *
 * \param heap pointer to the memory management
 * \param size the size of the requested memory in bytes
 */
typedef void* etMemory_alloc(struct etMemory* mem, etUInt16 size);

/**
 * frees memory previously allocated from the heap
 *
 * \param heap pointer to the memory management
 * \param obj pointer to the memory returned
 * \param size the size in bytes of the memory returned
 */
typedef void etMemory_free(struct etMemory* mem, void* obj);

typedef struct etMemoryStatistics {
	etUInt32 maxUsed;
	etUInt32 nFailingRequests;
}
etMemoryStatistics;

typedef struct etMemory {
	/** name */
	const char* name;

	/** linked list */
	struct etMemory* next;

	/** size of the heap in bytes */
	etUInt32 size;

	/** statistical data made available through the runtime */
	etMemoryStatistics statistics;

	/** the configured allocation method */
	etMemory_alloc* alloc;
	/** the configured freeing method */
	etMemory_free* free;

	/** user supplied lock functions */
	etLock* lock;
} etMemory;


/**
 * initializes the struct
 *
 * \param mem pointer to the heap to be managed
 * \param size the size in bytes of the heap
 * \param alloc the allocation function
 * \param free the free function
 *
 * \return the pointer to the initialized etMemory struct
 */
void etMemory_init(etMemory* mem, etUInt32 size, etMemory_alloc* alloc, etMemory_free* free);

/**
 * resets the statistical data to their initial values
 *
 * \param heap pointer to the memory management
 */
void etMemory_resetStatistics(etMemory* mem);

/**
 * supply optional user lock/unlock functions for usage in a multi-threaded environment.
 * \param mem pointer to the memory management struct
 * \lock pointer to a user supplied locking struct
 */
void etMemory_setUserLock(etMemory* mem, etLock* lock);

/**
 * destroys the memory management and unregisters it from the runtime
 * \param mem pointer to the memory management struct
 */
void etMemory_destroy(etMemory* mem);

ET_EXTERN_C_END

#endif /* _ETMEMORY_H_ */
