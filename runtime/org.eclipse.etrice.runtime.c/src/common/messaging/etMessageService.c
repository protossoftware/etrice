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


#include "etMessageService.h"


#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"



/*
 * initialize message service with all needed data and initialize message queue and message pool
 *
 */
void etMessageService_init(etMessageService* self, etUInt8* buffer, etUInt16 maxBlocks, etUInt16 blockSize, etDispatcherReceiveMessage msgDispatcher){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "init")

	/* copy init data to self */
	self->messageBuffer.buffer = buffer;
	self->messageBuffer.maxBlocks = maxBlocks;
	self->messageBuffer.blockSize = blockSize;
	self->msgDispatcher = msgDispatcher;

	/* copy init queue and pool */
	etMessageQueue_init( &(self->messagePool) ); 	/* the pool is also a queue*/
	etMessageQueue_init( &(self->messageQueue) );
	etMessageService_initMessagePool(self);

	/* init mutexes and semaphores */
	etMutex_construct( &(self->poolMutex) );
	etMutex_construct( &(self->queueMutex) );
	etSema_construct( &(self->executionSemaphore) );

	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_start(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "start")
	etThread_construct( &(self->thread) );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_stop(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "stop")
	etThread_destruct( &(self->thread) );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_destroy(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "destroy")
	etMutex_destruct( &(self->poolMutex) );
	etMutex_destruct( &(self->queueMutex) );
	etSema_destruct( &(self->executionSemaphore) );
	ET_MSC_LOGGER_SYNC_EXIT
}


/*
 * initialize message pool with block buffer
 * all blocks are added to pool
 */
void etMessageService_initMessagePool(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "initMessagePool")
	etInt16 i;

	for (i=0; i<self->messageBuffer.maxBlocks; i++){
		etMessage* block = (etMessage*) &self->messageBuffer.buffer[i*self->messageBuffer.blockSize];
		etMessageQueue_push(&self->messagePool, block);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_pushMessage(etMessageService* self, etMessage* msg){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "pushMessage")
	etMutex_enter(&self->queueMutex);
	etMessageQueue_push(&self->messageQueue, msg);
	etSema_wakeup(&self->executionSemaphore);
	etMutex_leave(&self->queueMutex);
	ET_MSC_LOGGER_SYNC_EXIT
}

etMessage* etMessageService_popMessage(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "popMessage")
	etMutex_enter(&self->queueMutex);
	etMessage* msg = etMessageQueue_pop(&self->messageQueue);
	etMutex_leave(&self->queueMutex);
	ET_MSC_LOGGER_SYNC_EXIT
	return msg;
}


etMessage* etMessageService_getMessageBuffer(etMessageService* self, etUInt16 size){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "getMessageBuffer")
	etMutex_enter(&self->poolMutex);
	if (size<=self->messageBuffer.blockSize){
		if (self->messagePool.size>0){
			etMessage* msg = etMessageQueue_pop(&self->messagePool);
			etMutex_leave(&self->poolMutex);
			ET_MSC_LOGGER_SYNC_EXIT
			return msg;
		}
	}
	etMutex_leave(&self->poolMutex);
	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

void etMessageService_returnMessageBuffer(etMessageService* self, etMessage* buffer){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "returnMessageBuffer")
	etMutex_enter(&self->poolMutex);
	etMessageQueue_push(&self->messagePool, buffer);
	etMutex_leave(&self->poolMutex);
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_deliverAllMessages(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "deliverAllMessages")
	while (TRUE){
		while (etMessageQueue_isNotEmpty(&self->messageQueue)){
			etMessage* msg = etMessageService_popMessage(self);
			self->msgDispatcher(msg);
			etMessageService_returnMessageBuffer(self, msg);
		}
		etSema_waitForWakeup(&self->executionSemaphore);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_execute(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "execute")
	etMessageService_deliverAllMessages(self);
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt16 etMessageService_getMessagePoolLowWaterMark(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "getMessagePoolLowWaterMark")
	etInt16 lowWaterMark = self->messageBuffer.maxBlocks - etMessageQueue_getHighWaterMark(&self->messageQueue);
	ET_MSC_LOGGER_SYNC_EXIT
	return lowWaterMark;
}
