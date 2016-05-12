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


#include "etSystemProtocol.h"
#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

static void etMessageService_timerCallback(void* data);
static void etMessageService_deliverAllMessages(etMessageService* self);

/*
 * initialize message service with all needed data and initialize message queue and message pool
 *
 */
void etMessageService_init(
		etMessageService* self,
		etUInt8* buffer,
		etUInt16 maxBlocks,
		etUInt16 blockSize,
		etStacksize stacksize,
		etPriority priority,
		etTime interval,
		etDispatcherReceiveMessage msgDispatcher,
		etMessageService_execmode execmode){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "init")

	/* copy init data to self */
	self->messageBuffer.buffer = buffer;
	self->messageBuffer.maxBlocks = maxBlocks;
	self->messageBuffer.blockSize = blockSize;
	self->msgDispatcher = msgDispatcher;
	self->execmode = execmode;

	/* init queue and pool */
	etMessageQueue_init( &(self->messagePool) ); 	/* the pool is also a queue*/
	etMessageQueue_init( &(self->messageQueue) );
	etMessageService_initMessagePool(self);

	/* init mutexes and semaphores */
	etMutex_construct( &(self->poolMutex) );
	etMutex_construct( &(self->queueMutex) );
	etSema_construct( &(self->executionSemaphore) );

	/* init high prio functions */
	self->highPrioFuncRoot=NULL;

	/* init thread */
	etThread_construct(&self->thread, stacksize, priority, "MessageService", (etThreadFunction) etMessageService_deliverAllMessages, self);

	if (execmode==EXECMODE_POLLED || execmode==EXECMODE_MIXED) {
		/* init timer */
		etTimer_construct(&self->timer, &interval, etMessageService_timerCallback, self);
	}

	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_start(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "start")
	etThread_start( &(self->thread) );
	if (self->execmode==EXECMODE_POLLED || self->execmode==EXECMODE_MIXED) {
		etTimer_start(&self->timer);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_stop(etMessageService* self){
	etSystemProtocolConjPort port;
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "stop")

	if (self->execmode==EXECMODE_POLLED || self->execmode==EXECMODE_MIXED) {
		etTimer_stop(&self->timer);
	}

	/* create a temporary port struct and send the terminate message */
	port.localId = 0;
	port.msgService = self;
	port.peerAddress = MESSAGESERVICE_ADDRESS;
	etSystemProtocolConjPort_terminate(&port);

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
	etMessageQueue_resetLowWaterMark(&self->messagePool);
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
	etMessage* msg;

	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "popMessage")
	etMutex_enter(&self->queueMutex);
	msg = etMessageQueue_pop(&self->messageQueue);
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
		else {
			etLogger_logErrorF("etMessageService_getMessageBuffer: message pool empty: %d", etMessageService_getMessagePoolLowWaterMark(self));
		}
	}
	else {
		etLogger_logErrorF("etMessageService_getMessageBuffer: message too big: %d, blockSize: %d", size, self->messageBuffer.blockSize);
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

void etMessageService_registerHighPrioFunc(etMessageService* self,etHighPrioFunc *func){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "registerHighPrioFunc")
	func->next=self->highPrioFuncRoot;
	self->highPrioFuncRoot=func;
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMessageService_unregisterHighPrioFunc(etMessageService* self,etHighPrioFunc *func){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "unregisterHighPrioFunc")
	etHighPrioFunc *highPrioFunc;
	if (self->highPrioFuncRoot==func){
		self->highPrioFuncRoot=self->highPrioFuncRoot->next;
	}else{
		highPrioFunc = self->highPrioFuncRoot;
		while(highPrioFunc != NULL){
			if (highPrioFunc->next==func){
				highPrioFunc->next=highPrioFunc->next->next;
				break;
			}
			highPrioFunc=highPrioFunc->next;
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

static void etMessageService_callHighPrioFunc(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "callHighPrioFunc")
	etHighPrioFunc *highPrioFunc;
	highPrioFunc = self->highPrioFuncRoot;
	while (highPrioFunc != NULL){
		(*(highPrioFunc->func))(highPrioFunc->param);
		highPrioFunc=highPrioFunc->next;
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

static void etMessageService_deliverAllMessages(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "deliverAllMessages")
	{
		etBool cont = ET_TRUE;
		while (cont){
			etMessageService_callHighPrioFunc(self);
			while (etMessageQueue_isNotEmpty(&self->messageQueue) && cont){
				etMessage* msg = etMessageService_popMessage(self);
				if (!self->msgDispatcher(msg))
					cont = ET_FALSE;
				etMessageService_returnMessageBuffer(self, msg);
				etMessageService_callHighPrioFunc(self);
			}
			if (cont)
				etSema_waitForWakeup(&self->executionSemaphore);
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etInt16 etMessageService_getMessagePoolLowWaterMark(etMessageService* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "getMessagePoolLowWaterMark")
	etInt16 lowWaterMark = etMessageQueue_getLowWaterMark(&self->messagePool);
	ET_MSC_LOGGER_SYNC_EXIT
	return lowWaterMark;
}

static void etMessageService_timerCallback(void* data) {
	ET_MSC_LOGGER_SYNC_ENTRY("etMessageService", "timerCallback")
	{
		etMessageService* self = (etMessageService*) data;

		/* create a temporary port struct and send the poll message */
		etSystemProtocolConjPort port;
		port.localId = 0;
		port.msgService = self;
		port.peerAddress = MESSAGESERVICE_ADDRESS;
		etSystemProtocolConjPort_poll(&port);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}


