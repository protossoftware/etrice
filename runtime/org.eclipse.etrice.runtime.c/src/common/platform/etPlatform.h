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

/*
 * etPlatform.h defines a generic interface for platform specific implementations
 *
 * */

/* platform specific functions */

/******************thread********************/

typedef int32 etStacksize;
typedef int32 etPriority;
typedef charPtr etThreadname;
typedef void (*etThreadFunction)(void *);

typedef struct etThread{
	etOSThreadData osData;  /* OS specific thread data (e.g. handle or id) */
	etStacksize stacksize;
	etPriority priority;
	etThreadname threadName;
	etThreadFunction threadFunction;
	void* threadFunctionData;
} etThread;


void etThread_construct(etThread* self);
void etThread_destruct(etThread* self);

/******************thread helpers********************/
void etThread_sleep(etInt32 millis);


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
