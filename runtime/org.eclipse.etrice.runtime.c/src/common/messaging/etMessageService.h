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
 *
 *******************************************************************************/

/**
 * \file etMessageService.h
 *
 * this component implements a message service that delivers messages asynchronously
 *
 * \author Thomas Schuetz
 */

#ifndef _ETMESSAGESERVICE_H_
#define _ETMESSAGESERVICE_H_

#include <stddef.h>
#include "etDatatypes.h"
#include "messaging/etMessageQueue.h"
#include "messaging/etMessageReceiver.h"
#include "base/etQueue.h"
#include "base/etQueueStatistics.h"

#include "osal/etMutex.h"
#include "osal/etThread.h"
#include "osal/etSema.h"
#include "osal/etTimer.h"

ET_EXTERN_C_BEGIN

/** the address of the message service */
#define MESSAGESERVICE_ADDRESS		1
/** the base address for other receivers */
#define BASE_ADDRESS				32

/** enumeration for execution modes */
typedef enum etMessageService_execmode {
	EXECMODE_POLLED,		/**< polled execution for data driven systems */
	EXECMODE_BLOCKED,		/**< blocked execution for asynchronous systems */
	EXECMODE_MIXED			/**< mixed execution for mixed systems */
} etMessageService_execmode;

/**
 * the data structure for the message buffer (chunks of equal size)
 */
typedef struct etBuffer{
	etUInt8 *buffer;		/**< buffer points to the actual memory position for the message pool */
	etUInt16 maxBlocks;		/**< number of blocks for the message pool */
	etUInt16 blockSize;		/**< size of blocks for the message pool */
} etBuffer;

/**
 * the data structure for the high prio functions (needed from PInterrupt)
 */
typedef struct etHighPrioFunc etHighPrioFunc;
struct etHighPrioFunc{
	void (*func)(void *);
	void * param;
	etHighPrioFunc *next;
};

/**
 * a data structure for the performance statistics
 */
typedef struct etMessageServiceStatistics {
	etTimeDiff highWaterMark;					/** high water mark */
	etQueueStatistics queueStatistics;			/** a pointer to the queue statistics */
}
etMessageServiceStatistics;

typedef struct etMessageService {
	const char* name;							/** (unique) name */
	struct etMessageService* next;				/** linked list */
	etMessageQueue messageQueue;				/** message queue that holds all used messages */
	etMessageQueue messagePool;					/** message pool that holds all free messages */
	etBuffer messageBuffer;						/** information about the message buffer that holds information about the actual memory position and size for the message pool */
	etDispatcherReceiveMessage msgDispatcher;	/** function pointer to the generated message dispatcher function */
	etThread thread;							/** thread for the execution of the message service */
	etMutex poolMutex;							/** mutex for synchronizing the access to the message pool */
	etMutex queueMutex;							/** mutex for synchronizing the access to the message queue */
	etSema executionSemaphore; 					/** semaphore for waiting and waking up the execution */
	etTimer timer;								/** timer for cyclic calls */
	etMessageService_execmode execmode;			/** execution mode*/
	etHighPrioFunc *highPrioFuncRoot;
	etMessageServiceStatistics statistics;		/** statistical data */
	etBool resetStatistics;						/** flag that tells the message service to reset all statistics values */
} etMessageService;

/**
 * initialization (construction)
 *
 * \param self the this pointer
 * \param name the name of the message service
 * \param buffer the buffer for the message pool
 * \param maxBlocks the number of (equal sized) message blocks in the buffer
 * \param blockSize the size of each message block
 * \param stackSize the stack size for the thread in which this service will run
 * \param priority the thread priority
 * \param interval the polling interval
 * \param msgDispatcher the dispatcher method
 * \param execmdoe the execution mode for this message service
 */
void etMessageService_initx(
		etMessageService* self,
		const char* name,
		etUInt8* buffer,
		etUInt16 maxBlocks,
		etUInt16 blockSize,
		etStacksize stacksize,
		etPriority priority,
		etTime interval,
		etDispatcherReceiveMessage msgDispatcher,
		etMessageService_execmode execmode);

/**
 * initialization (construction)
 *
 * \param self the this pointer
 * \param buffer the buffer for the message pool
 * \param maxBlocks the number of (equal sized) message blocks in the buffer
 * \param blockSize the size of each message block
 * \param stackSize the stack size for the thread in which this service will run
 * \param priority the thread priority
 * \param interval the polling interval
 * \param msgDispatcher the dispatcher method
 * \param execmdoe the execution mode for this message service
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
		etMessageService_execmode execmode);

/**
 * start of the message service (starts the associated thread)
 *
 * \param self the this pointer
 */
void etMessageService_start(etMessageService* self);

/**
 * the polling method to be called cyclically
 *
 * \param self the this pointer
 */
void etMessageService_execute(etMessageService* self);

/**
 * stops the message service thread
 *
 * \param self the this pointer
 */
void etMessageService_stop(etMessageService* self);

/**
 * destroys the message service
 *
 * \param self the this pointer
 */
void etMessageService_destroy(etMessageService* self);

/**
 * initialization of message pool
 *
 * \param self the this pointer
 */
void etMessageService_initMessagePool(etMessageService* self);

/**
 * push a message to the queue. The queue access is synchronized. The method notifies the dispatch thread.
 *
 * \param self the this pointer
 * \msg the message to push
 */
void etMessageService_pushMessage(etMessageService* self, etMessage* msg);

/**
 * pop a message from the queue. The queue access is synchronized.
 *
 * \param self the this pointer
 * \return the extracted message
 */
etMessage* etMessageService_popMessage(etMessageService* self);

/**
 * get a chunk of uninitialized memory interpreted as \ref etMessage from the services memory management
 *
 * \param self the this pointer
 * \param size the size of the message in bytes
 * \return a message pointer to a chunk of memory with at least the required size
 */
etMessage* etMessageService_getMessageBuffer(etMessageService* self, etUInt16 size);

/**
 * return a chunk of previously obtained memory to the message service memory management
 *
 * \param self the this pointer
 * \param buffer the memory to be freed
 */
void etMessageService_returnMessageBuffer(etMessageService* self, etMessage* buffer);

/* functions to register and unregister high prio functions */
void etMessageService_registerHighPrioFunc(etMessageService* self, etHighPrioFunc* func);
void etMessageService_unregisterHighPrioFunc(etMessageService* self, etHighPrioFunc*  func);

ET_EXTERN_C_END

#endif /* RMESSAGESERVICE_H_ */
