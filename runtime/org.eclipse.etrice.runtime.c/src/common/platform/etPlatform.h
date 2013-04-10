/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef __ETPLATFORM_H__
#define __ETPLATFORM_H__

#include "etDatatypes.h"

/**
 * etPlatform.h defines a generic interface for platform specific implementations
 *
 * */

/*
 * typedefs
 */

typedef int32 etStacksize;
typedef int32 etPriority;
typedef charPtr etThreadname;
typedef void (*etThreadFunction)(void *);

/**
 * etThread holds all data needed to handle a thread instance
 * the struct has to be filled before calling etThread_construct except for osData and osId
 **/
typedef struct etThread{
	etOSThreadData osData;		/**< OS specific thread data (e.g. handle or id) -> is filled in by etThread_construct **/
	etOSThreadId osId;			/**< integer thread id (used e.g. for debugging)  -> is filled in by etThread_construct **/
	etStacksize stacksize;		/**< configuration of stacksize -> has to be filled in by caller of etThread_construct **/
	etPriority priority;		/**< configuration of priority -> has to be filled in by caller of etThread_construct **/
	etThreadname threadName;	/**< configuration of threadName -> has to be filled in by caller of etThread_construct **/
	etThreadFunction threadFunction; /**< call back function to be called by thread -> has to be filled in by caller of etThread_construct **/
	void* threadFunctionData;	/**< data for call back function to be called by thread -> has to be filled in by caller of etThread_construct **/
} etThread;

/**
 * create and start a new thread
 * \param self pointer to thread instance
 */
// TODO: add return values for error handling
void etThread_construct(etThread* self);

/**
 * stop and destroy a new thread
 * \param self pointer to thread instance
 */
void etThread_destruct(etThread* self);

/**
 * pausing the execution of the thread for <b>millis</b> milliseconds
 * \param millis sleeping time in milliseconds
 */
void etThread_sleep(etInt32 millis);
etOSThreadData etThread_self(void);
etOSThreadId etThread_self_id(void);


/*****************mutex**********************/

typedef struct etMutex {
	etOSMutexData osData;
} etMutex;

void etMutex_construct(etMutex* self);
void etMutex_destruct(etMutex* self);
void etMutex_enter(etMutex* self);
void etMutex_leave(etMutex* self);

/********************semaphore****************/

typedef struct etSema {
	etOSSemaData osData;
} etSema;

void etSema_construct(etSema* self);
void etSema_destruct(etSema* self);
void etSema_wakeup(etSema* self);
void etSema_waitForWakeup(etSema* self);

/*********************************************/



/*
 * Platform startup and shutdown -> generated code for SubSystemClass uses these interfaces
 * */

void etUserEntry(void);
void etUserPreRun(void);
/* void etUserRun(void); */ /* TODO: do we need this function? */
void etUserPostRun(void);
void etUserExit(void);

#endif /* __ETPLATFORM_H__ */
