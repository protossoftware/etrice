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

#include "messaging/etMessageQueue.h"

#include "debugging/etMSCLogger.h"

void etMessageQueue_init(etMessageQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "init")
	self->first = NULL;
	self->last = NULL;
	self->highWaterMark = 0;
	self->lowWaterMark = 0;
	self->size = 0;
	ET_MSC_LOGGER_SYNC_EXIT
}


void etMessageQueue_push(etMessageQueue* self, etMessage* msg){
	/* TODO: optimize queue for concurrent push / pop */
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "push")
	if (self->first == NULL) {
		/*no message in queue*/
		self->first = self->last = msg;
	}
	else {
		/*at least one message in queue*/
		self->last->next = msg;
		self->last = msg;
	}
	msg->next = NULL; /*TODO: optimization: this line could be removed if we assume that all messages are initialized*/

	if (++self->size > self->highWaterMark)
		self->highWaterMark++;

	ET_MSC_LOGGER_SYNC_EXIT
}

etMessage* etMessageQueue_pop(etMessageQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "pop")
	etMessage* pop_msg = self->first;
	if(self->first == NULL){
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

	if (self->size < self->lowWaterMark)
		self->lowWaterMark--;

	ET_MSC_LOGGER_SYNC_EXIT
	return pop_msg;
}

etInt16 etMessageQueue_getSize(etMessageQueue* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "getSize")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->size;
}

etMessage* etMessageQueue_getFirst(etMessageQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "getFirst")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->first;
}

etMessage* etMessageQueue_getLast(etMessageQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "getLast")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->last;
}

etBool etMessageQueue_isNotEmpty(etMessageQueue* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "isNotEmpty")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->last != NULL;
}

etInt16 etMessageQueue_getHighWaterMark(etMessageQueue* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "getHighWaterMark")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->highWaterMark;
}

etInt16 etMessageQueue_getLowWaterMark(etMessageQueue* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "getLowWaterMark")
	ET_MSC_LOGGER_SYNC_EXIT
	return self->lowWaterMark;
}

void etMessageQueue_resetLowWaterMark(etMessageQueue* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageQueue", "resetLowWaterMark")
	self->lowWaterMark = self->size;
	ET_MSC_LOGGER_SYNC_EXIT
}
