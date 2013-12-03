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
 * determines and returns the free memory of the heap
 *
 * \param heap pointer to the heap to be managed
 *
 * \return the free memory of the heap
 */
etUInt32 etMemory_FreeList_freeHeapMem(void* heap);

/**
 * returns the number of objects in a given slot
 *
 * \param heap pointer to the heap to be managed
 * \param slot the slot number
 *
 * \return the number of objects in a given slot or <code>0</code> if invalid slot
 * or <code>DEBUG_FREE_LISTS</code> isn't <code>true</code>
 */
etUInt16 etMemory_FreeList_nObjects(void* heap, etUInt16 slot);

/**
 * returns the size of the objects in a given slot
 *
 * \param heap pointer to the heap to be managed
 * \param slot the slot number
 *
 * \return the size of the objects in a given slot
 */
etUInt16 etMemory_FreeList_sizeObjects(void* heap, etUInt16 slot);

/**
 * returns the number of free slots
 *
 * \param heap pointer to the heap to be managed
 *
 * \return the number of free slots
 */
etUInt16 etMemory_FreeList_freeSlots(void* heap);

#endif /* _ETMEMORY_FREE_LIST_H_ */
