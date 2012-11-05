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

#include "base/etQueue.h"
#include "debugging/etMSCLogger.h"

void etQueue_init(etQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "init")

	self->first = NULL;
	self->last = NULL;
	self->highWaterMark = 0;
	self->size = 0;

	ET_MSC_LOGGER_SYNC_EXIT
}


void etQueue_push(etQueue* self, void* obj){
	// TODO: optimize queue for concurrent push / pop
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "push")

	if (self->first == NULL) {
		/*no object in queue*/
		self->first = self->last = obj;
	}
	else {
		/*at least one object in queue*/
		self->last->next = obj;
		self->last = obj;
	}
	((etQueueObj*)obj)->next = NULL; /*TODO: optimization: this line could be removed if we assume that all objects are initialized*/

	if (++self->size > self->highWaterMark)
		self->highWaterMark++;

	ET_MSC_LOGGER_SYNC_EXIT
}

void* etQueue_pop(etQueue* self){
	etQueueObj* pop_msg = self->first;

	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "pop")

	if (self->first == NULL){
		/*no message in queue*/
		ET_MSC_LOGGER_SYNC_EXIT
		return NULL;
	}
	if (self->first->next==NULL){
		/*only one message in queue*/
		self->first = self->last = NULL;
	}
	else {
		/*more than one message in queue -> set first to nex message*/
		self->first = self->first->next;
	}

	pop_msg->next=NULL;
	self->size--;

	ET_MSC_LOGGER_SYNC_EXIT
	return pop_msg;
}

etInt16 etQueue_getSize(etQueue* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "getSize")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->size;
}

void* etQueue_getFirst(etQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "getFirst")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->first;
}

void* etQueue_getLast(etQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "getLast")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->last;
}

etBool etQueue_isNotEmpty(etQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "isNotEmpty")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->last != NULL;
}

etInt16 etQueue_getHighWaterMark(etQueue* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etQueue", "getHightWaterMark")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->highWaterMark;
}
