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

/**
 * \file etMemory_FixedSize.h
 *
 * a simple memory management that uses equal sized chunks. The free chunks are maintained in
 * a \ref etQueue
 *
 * \author Thomas Schuetz, Henrik Rentz-Reichert
 */
#ifndef _ETMEMORY_FIXED_SIZE_H_
#define _ETMEMORY_FIXED_SIZE_H_

#include "base/etMemory.h"
#include "base/etQueue.h"

/**
 * initializes the heap with a simple block management
 *
 * \param heap pointer to the heap to be managed
 * \param size the size in bytes of the heap
 * \param blockSize the size of the (equal sized) blocks
 *
 * \return the pointer to the initialized etMemory struct
 */
etMemory* etMemory_FixedSize_init(void* heap, etUInt32 size, etUInt16 blockSize);

/**
 * determines and returns the free memory of the heap
 *
 * \param mem pointer to the heap to be managed
 *
 * \return the free memory of the heap
 */
etUInt32 etMemory_FixedSize_getFreeHeapMem(etMemory* mem);

#endif /* _ETMEMORY_FIXED_SIZE_H_ */
