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

#include "etDatatypes.h"
#include "platform/etPlatform.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

/* implemenatation for eTrice interfaces*/

void etUserEntry(void){ }

void etUserPreRun(void){ }

void etUserPostRun(void){ }

void etUserExit(void){ }


/* platform specific functions */

#if defined __MINGW32__

/******************thread********************/
void etThread_execute(etThread* self);

void etThread_construct(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "construct")
	self->osData = (HANDLE)_beginthread( (etThreadFunction)etThread_execute, self->stacksize, self );
	SetThreadPriority(self->osData, self->priority);
	ET_MSC_LOGGER_SYNC_EXIT
}

void etThread_execute(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "execute")
	/* etThread_execute redirects the call from the thread to the execute function in the eTrice runtime to enable correct synchronous MSC logging */
	self->threadFunction(self->threadFunctionData);
	ET_MSC_LOGGER_SYNC_EXIT
}


void etThread_destruct(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "destruct")
	TerminateThread(self->osData, 0);
	ET_MSC_LOGGER_SYNC_EXIT
}


/******************thread helpers********************/
void etThread_sleep(etInt32 millis){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "sleep")
	Sleep(millis);
	ET_MSC_LOGGER_SYNC_EXIT
}

/*****************mutex**********************/
void etMutex_construct(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "construct")
	InitializeCriticalSection( &(self->osData) );
	ET_MSC_LOGGER_SYNC_EXIT
}
void etMutex_destruct(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "destruct")
	DeleteCriticalSection( &(self->osData) );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etMutex_enter(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "enter")
    EnterCriticalSection( &(self->osData) );
	ET_MSC_LOGGER_SYNC_EXIT
}
void etMutex_leave(etMutex* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMutex", "leave")
    LeaveCriticalSection( &(self->osData) );
	ET_MSC_LOGGER_SYNC_EXIT
}

/********************semaphore****************/
void etSema_construct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "construct")
	self->osData = CreateEvent( NULL, FALSE, FALSE, NULL );
	ET_MSC_LOGGER_SYNC_EXIT
}
void etSema_destruct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "destruct")
	// TODO: implement this function
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_wakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "wakeup")
	SetEvent( self->osData );
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_waitForWakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "waitForWakeup")
	WaitForSingleObject( self->osData, INFINITE );
	ET_MSC_LOGGER_SYNC_EXIT
}
/*********************************************/

#elif defined __GNUC__

/******************thread********************/
void etThread_construct(etThread* self){}

void etThread_destruct(etThread* self){}

/*****************mutex**********************/
void etMutex_construct(etMutex* self){}
void etMutex_destruct(etMutex* self){}
void etMutex_enter(etMutex* self){}
void etMutex_leave(etMutex* self){}

/********************semaphore****************/
void etSema_construct(etSema* self){}
void etSema_destruct(etSema* self){}

void etSema_wakeup(etSema* self){}

void etSema_waitForWakeup(etSema* self){}
/*********************************************/

#endif
