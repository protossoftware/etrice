/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 * 		Juergen Haug
 *
 *******************************************************************************/

#ifndef COMMON_BASE_ETQUEUE2_H_
#define COMMON_BASE_ETQUEUE2_H_

#include "base/etQueue.h"
#include "osal/etLock.h"
#include "base/etQueueStatistics.h"

ET_EXTERN_C_BEGIN

/**
 *  etQueue with locking and statistics
 */
typedef struct etQueue2 {
	etQueue queue;
	etLock* lock;
	etQueueStatistics statistics;
} etQueue2;

void etQueue2_init(etQueue2* self);

void etQueue2_setLock(etQueue2* self, etLock* lock);

void etQueue2_push(etQueue2* self, etQueueObj* obj);

etQueueObj* etQueue2_pop(etQueue2* self);

etQueueObj* etQueue2_getFirst(etQueue2* self);

etQueueObj* etQueue2_getLast(etQueue2* self);

etBool etQueue2_isNotEmpty(etQueue2* self);

etInt16 etQueue2_getSize(etQueue2* self);

const etQueueStatistics* etQueue2_getStatistics(etQueue2* self);

void etQueue2_resetStatistics(etQueue2* self);


ET_EXTERN_C_END

#endif /* COMMON_BASE_ETQUEUE2_H_ */
