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

#include "base/etMemory.h"

/**
 * initializes the free list memory management on the given heap
 *
 * \param heap pointer to the heap to be managed
 * \param size the size in bytes of the heap
 * \nslots the number of slots to be used (should be greater or equal the number of different object sizes)
 *
 * \return the pointer to the initialized etMemory struct
 */
etMemory* etMemory_FreeList_init(void* heap, etUInt32 size, etUInt16 nslots);

#endif /* _ETMEMORY_FREE_LIST_H_ */
