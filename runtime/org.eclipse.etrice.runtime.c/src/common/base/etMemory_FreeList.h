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

#ifndef _ETMEMORY_FREE_LIST_H_
#define _ETMEMORY_FREE_LIST_H_

/**
 * \file etMemory_FreeList.h
 *
 * a heap management that recycles freed objects in slots of objects of equal size
 *
 * \author Henrik Rentz-Reichert
 */
#include "base/etMemory.h"
#include "osal/etLock.h"

ET_EXTERN_C_BEGIN

typedef etUInt16 roundUpSize(etUInt16 size);

/**
 * this function rounds up to the next highest power of 2
 */
etUInt16 etMemory_FreeList_power2(etUInt16 v);

/**
 * initializes the free list memory management on the given heap
 *
 * \param heap pointer to the heap to be managed
 * \param size the size in bytes of the heap
 * \param nslots the number of slots to be used (should be greater or equal the number of different object sizes)
 *
 * \return the pointer to the initialized etMemory struct
 */
etMemory* etMemory_FreeList_init(void* heap, etUInt32 size, etUInt16 nslots);

/**
 * by default the requested size is just rounded up to the next alignment boundary.
 * In this case for every new size a slot is used. To use less slots at the cost of some 'wasted' memory
 * the user can supply an optional round-up method to create less equivalence classes of object sized
 * and thus reduce the number of slots needed.
 * An alternative is to use etMemory_FreeList_power2().
 */
void etMemory_FreeList_setUserRounding(etMemory* mem, roundUpSize* roundup);

/**
 * determines and returns the free memory of the heap
 *
 * \param mem pointer to the heap to be managed
 *
 * \return the free memory of the heap
 */
etUInt32 etMemory_FreeList_getFreeHeapMem(etMemory* mem);

/**
 * returns the number of objects in a given slot
 *
 * \param mem pointer to the heap to be managed
 * \param slot the slot number
 *
 * \return the number of objects in a given slot or <code>0</code> if invalid slot
 * or <code>DEBUG_FREE_LISTS</code> isn't <code>true</code>
 */
etUInt16 etMemory_FreeList_nObjects(etMemory* mem, etUInt16 slot);

/**
 * returns the size of the objects in a given slot
 *
 * \param mem pointer to the heap to be managed
 * \param slot the slot number
 *
 * \return the size of the objects in a given slot
 */
etUInt16 etMemory_FreeList_sizeObjects(etMemory* mem, etUInt16 slot);

/**
 * returns the number of free slots
 *
 * \param mem pointer to the heap to be managed
 *
 * \return the number of free slots
 */
etUInt16 etMemory_FreeList_freeSlots(etMemory* mem);

/**
 * the size of the management data per allocated object
 */
etUInt16 etMemory_FreeList_MgmtDataPerObject();

ET_EXTERN_C_END

#endif /* _ETMEMORY_FREE_LIST_H_ */
