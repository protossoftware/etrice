/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz, Thomas Jung (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etThread.h
 *
 * defines a generic interface for platform specific implementations of a thread
 *
 * \author Thomas Schuetz, Thomas Jung
 *
 */

#ifndef _ETTHREAD_H_
#define _ETTHREAD_H_

#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/*
 * typedefs for etThread
 */

typedef int32 etStacksize;
typedef int32 etPriority;
typedef charPtr etThreadname;
typedef void (*etThreadFunction)(void *);

/**
 * etThread holds all data needed to handle a thread instance
 * the struct has to be filled before calling etThread_construct except for osData and osId
 */
typedef struct etThread{
	etOSThreadData osData;		/**< OS specific thread data (e.g. handle or id) -> is filled in by etThread_construct **/
	etOSThreadId osId;			/**< integer thread id (used e.g. for debugging)  -> is filled in by etThread_construct **/
	etStacksize stacksize;		/**< configuration of stacksize -> has to be filled in by caller of etThread_construct **/
	etPriority priority;		/**< configuration of priority -> has to be filled in by caller of etThread_construct **/
	etThreadname threadName;	/**< configuration of threadName -> has to be filled in by caller of etThread_construct **/
	etThreadFunction threadFunction; /**< call back function to be called by thread -> has to be filled in by caller of etThread_construct **/
	void* threadFunctionData;	/**< data for call back function to be called by thread -> has to be filled in by caller of etThread_construct **/
} etThread;

/* TODO: add return values for error handling */

/**
 * initialize the thread data
 * \param (uninitialized) self pointer to thread instance
 * \param stacksize the size of the thread's stack
 * \param prioritiy the thread priority
 * \param threadName the name of the thread
 * \param threadFunction the thread function
 * \param threadFunctionData the data will be passed to the thread function
 */
void etThread_construct(
		etThread* self,
		etStacksize stacksize,
		etPriority priority,
		etThreadname threadName,
		etThreadFunction threadFunction,
		void* threadFunctionData);

/**
 * start a new thread
 * \param self pointer to thread instance
 */
void etThread_start(etThread* self); /*TODO: add all neededarguments to constructor arguments */

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

/**
 * get the self pointer of the OS specific data (e.g. handle) of the current thread
 * \return self pointer of the OS specific data (e.g. handle) of the current thread
 */
etOSThreadData etThread_self(void);

/**
 * get the unique id of the current thread
 * \return unique id of the current thread
 */
etOSThreadId etThread_self_id(void);

ET_EXTERN_C_END

#endif /* _ETTHREAD_H_ */
