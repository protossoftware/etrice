/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etMemory_VariableSize.h
 *
 * a simple memory management that uses equal sized chunks. The free chunks are maintained in
 * a \ref etQueue
 *
 * \author Henrik Rentz-Reichert
 */
#ifndef _ETMEMORY_VARIABLE_SIZE_H_
#define _ETMEMORY_VARIABLE_SIZE_H_

#include "base/etMemory.h"
#include "base/etQueue.h"
#include "osal/etLock.h"

/**
 * initializes the heap with a simple block management
 *
 * \param heap pointer to the heap to be managed
 * \param size the size in bytes of the heap
 * \param blockSize the size of the (equal sized) blocks
 *
 * \return the pointer to the initialized etMemory struct
 */
etMemory* etMemory_VariableSize_init(void* heap, etUInt32 size);

/**
 * supply optional user lock/unlock functions for usage in a multi-threaded environment.
 * \param mem pointer to the memory management struct
 * \lock pointer to a user supplied locking struct
 */
void etMemory_VariableSize_setUserLock(etMemory* mem, etLock* lock);

/**
 * returns the free memory left in bytes
 * \return the free memory left in bytes
 */
etUInt8 etMemory_VariableSize_freeHeapMem(etMemory* mem);


#endif /* _ETMEMORY_VARIABLE_SIZE_H_ */
