/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETQUEUE_H_
#define _ETQUEUE_H_

#include <stddef.h>
#include "etDatatypes.h"

typedef struct etQueueObj {
	struct etQueueObj* next;
} etQueueObj;

typedef struct etQueue {
	etQueueObj* first;
	etQueueObj* last;
	etInt16 highWaterMark;
	etInt16 size;

} etQueue;

void etQueue_init(etQueue* self);

void etQueue_push(etQueue* self, void* obj);

void* etQueue_pop(etQueue* self);

void* etQueue_getFirst(etQueue* self);

void* etQueue_getLast(etQueue* self);

etBool etQueue_isNotEmpty(etQueue* self);

etInt16 etQueue_getHighWaterMark(etQueue* self);

etInt16 etQueue_getSize(etQueue* self);



#endif /* _ETQUEUE_H_ */
