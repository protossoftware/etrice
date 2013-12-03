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

#ifndef _ETMEMORY_H_
#define _ETMEMORY_H_

#include "etDatatypes.h"

/**
 * this macro computes the memory aligned value for a given size. It uses the ALIGNMENT
 * defined in etDatatypes.h
 */
#define MEM_CEIL(n)          ((n)+((ALIGNMENT-((n)&(ALIGNMENT-1)))&(ALIGNMENT-1)))

struct etMemory;

/**
 * allocates memory from the heap
 *
 * \param heap pointer to the heap memory
 * \param size the size of the requested memory in bytes
 */
typedef void* etMemory_alloc(struct etMemory* heap, etUInt16 size);

/**
 * frees memory previously allocated from the heap
 *
 * \param heap pointer to the heap memory
 * \param obj pointer to the memory returned
 * \param size the size in bytes of the memory returned
 */
typedef void etMemory_free(struct etMemory* heap, void* obj, etUInt16 size);

typedef struct etMemory {
	/** size of the heap in bytes */
	etUInt32 size;

	/** the configured allocation method */
	etMemory_alloc* alloc;
	/** the configured freeing method */
	etMemory_free* free;
} etMemory;

#endif /* _ETMEMORY_H_ */
