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

#ifndef _ETMESSAGESERVICE_H_
#define _ETMESSAGESERVICE_H_

#include <stddef.h>
#include "etDatatypes.h"
#include "messaging/etMessageQueue.h"
#include "messaging/etMessageReceiver.h"
#include "platform/etPlatform.h"


typedef struct etBuffer{
	etUInt8 *buffer;
	etUInt16 maxBlocks;
	etUInt16 blockSize;
} etBuffer;

typedef struct etMessageService {
	etMessageQueue messageQueue;
	etMessageQueue messagePool;
	etBuffer messageBuffer;
	etDispatcherReceiveMessage msgDispatcher;
	etThread thread;
	etMutex poolMutex;
	etMutex queueMutex;
	etSema executionSemaphore; /* sempahore for waiting and waking up the execution */
} etMessageService;


/* lifecycle functions to startup, execute and shutdown the message service */
void etMessageService_init(etMessageService* self, etUInt8* buffer, etUInt16 maxBlocks, etUInt16 blockSize, etDispatcherReceiveMessage msgDispatcher);
void etMessageService_start(etMessageService* self);
void etMessageService_execute(etMessageService* self);
void etMessageService_stop(etMessageService* self);
void etMessageService_destroy(etMessageService* self);

/* initialization of message pool */
void etMessageService_initMessagePool(etMessageService* self);

/* message queue interface for push and pop messages */
void etMessageService_pushMessage(etMessageService* self, etMessage* msg);
etMessage* etMessageService_popMessage(etMessageService* self);

/* message pool interface to get and return (push and pop) messages */
etMessage* etMessageService_getMessageBuffer(etMessageService* self, etUInt16 size);
void etMessageService_returnMessageBuffer(etMessageService* self, etMessage* buffer);

/* functions for debug and service information  */
etInt16 etMessageService_getMessagePoolLowWaterMark(etMessageService* self);


#endif /* RMESSAGESERVICE_H_ */
