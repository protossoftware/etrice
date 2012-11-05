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

#define CEIL_ALIGN(n)          ((n)+((ALIGNMENT-((n)&(ALIGNMENT-1)))&(ALIGNMENT-1)))

/**
 * initializes the heap
 *
 * \param heap pointer to the heap memory
 * \param size the size of the heap in bytes
 */
void etMemory_init(void* heap, etUInt16 size);

/**
 * allocates memory from the heap
 *
 * \param heap pointer to the heap memory
 * \param size the size of the requested memory in bytes
 */
void* etMemory_alloc(void* heap, etUInt16 size);

/**
 * frees memory previously allocated from the heap
 *
 * \param heap pointer to the heap memory
 * \param obj pointer to the memory returned
 * \param size the size in bytes of the memory returned
 */
void etMemory_free(void* heap, void* obj, etUInt16 size);

#endif /* _ETMEMORY_H_ */
