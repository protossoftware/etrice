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

#include "base/etQueue2.h"

#define DO_LOCK	\
	if (self->lock!=NULL) {								\
		self->lock->lockFct(self->lock->lockData);	\
	}

#define DO_UNLOCK	\
	if (self->lock!=NULL) {								\
		self->lock->unlockFct(self->lock->lockData);	\
	}

void etQueue2_init(etQueue2* self){
	etQueue_init(&self->queue);
	self->lock = NULL;
	etQueueStatistics_init(&self->statistics);
}

void etQueue2_setLock(etQueue2* self, etLock* lock) {
	self->lock = lock;
}

void etQueue2_push(etQueue2* self, etQueueObj* obj) {
	DO_LOCK

	etQueue_push(&self->queue, obj);
	if(self->queue.size > self->statistics.highWaterMark) {
		self->statistics.highWaterMark = self->queue.size;
	}

	DO_UNLOCK
}

etQueueObj* etQueue2_pop(etQueue2* self) {
	DO_LOCK

	etQueueObj* pop_msg = etQueue_pop(&self->queue);
	if (self->queue.size < self->statistics.lowWaterMark) {
		self->statistics.lowWaterMark = self->queue.size;
	}

	DO_UNLOCK
	return pop_msg;
}

etInt16 etQueue2_getSize(etQueue2* self) {
	DO_LOCK
	etInt16 size = self->queue.size;
	DO_UNLOCK

	return size;
}

etQueueObj* etQueue2_getFirst(etQueue2* self) {
	DO_LOCK
	etQueueObj* obj = self->queue.first;
	DO_UNLOCK

	return obj;
}

etQueueObj* etQueue2_getLast(etQueue2* self) {
	DO_LOCK
	etQueueObj* obj = self->queue.last;
	DO_UNLOCK

	return obj;
}

etBool etQueue2_isNotEmpty(etQueue2* self) {
	DO_LOCK
	etBool notEmpty = self->queue.last != NULL;
	DO_UNLOCK

	return notEmpty;
}

const etQueueStatistics* etQueue2_getStatistics(etQueue2* self) {
	return &self->statistics;
}

void etQueue2_resetStatistics(etQueue2* self) {
	DO_LOCK
	etQueueStatistics_reset(&self->statistics, self->queue.size);
	DO_UNLOCK
}

