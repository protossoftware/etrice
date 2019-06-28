/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
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

ET_EXTERN_C_BEGIN

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
 * returns the free memory left in bytes
 * \return the free memory left in bytes
 */
etUInt8 etMemory_VariableSize_freeHeapMem(etMemory* mem);

ET_EXTERN_C_END

#endif /* _ETMEMORY_VARIABLE_SIZE_H_ */
