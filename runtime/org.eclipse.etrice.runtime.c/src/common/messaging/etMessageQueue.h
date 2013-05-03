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

#ifndef _ETMESSAGEQUEUE_H_
#define _ETMESSAGEQUEUE_H_

#include "messaging/etMessage.h"
#include <stddef.h>

typedef struct etMessageQueue {
	etMessage* first;
	etMessage* last;
	etInt16 highWaterMark;
	etInt16 lowWaterMark;
	etInt16 size;

} etMessageQueue;

void etMessageQueue_init(etMessageQueue* self);

void etMessageQueue_push(etMessageQueue* self, etMessage* msg);
etMessage* etMessageQueue_pop(etMessageQueue* self);

etMessage* etMessageQueue_getFirst(etMessageQueue* self);
etMessage* etMessageQueue_getLast(etMessageQueue* self);

etBool etMessageQueue_isNotEmpty(etMessageQueue* self);

etInt16 etMessageQueue_getSize(etMessageQueue* self);
etInt16 etMessageQueue_getHighWaterMark(etMessageQueue* self);
etInt16 etMessageQueue_getLowWaterMark(etMessageQueue* self);
void etMessageQueue_resetLowWaterMark(etMessageQueue* self);


#endif /* _RMESSAGEQUEUE_H_ */
