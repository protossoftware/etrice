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

#include <etDatatypes.h>

/* implemenatation for eTrice interfaces*/

void etUserEntry(void){ }

void etUserPreRun(void){ }

void etUserPostRun(void){ }

void etUserExit(void){ }


/* platform specific functions */

#if defined __MINGW32__

/******************thread********************/
void etThread_construct(etThread* self, const etThreadname name, void (*func)(void *), etStacksize stacksize, etPriority prio){
	   *self = (HANDLE)_beginthread( func, stacksize, NULL );
	   SetThreadPriority(*self,THREAD_PRIORITY_NORMAL);
}

void etThread_destruct(etThread* self){}

/*****************mutex**********************/
void etMutex_construct(etMutex* self){
	InitializeCriticalSection( self );
}
void etMutex_destruct(etMutex* self){}
void etMutex_enter(etMutex* self){
    EnterCriticalSection( self );
}
void etMutex_leave(etMutex* self){
    LeaveCriticalSection( self );
}

/********************semaphore****************/
void etSema_contruct(etSema* self){
	*self = CreateEvent( NULL, FALSE, FALSE, NULL );
}
void etSema_destruct(etSema* self){}

void etSema_wakeup(etSema* self){
	SetEvent(self);
}

void etSema_waitForWakeup(etSema* self){
	WaitForSingleObject( self, INFINITE );
}
/*********************************************/

#elif defined __GNUC__

/******************thread********************/
void etThread_construct(etThread* self, const etThreadname name, void (*func)(void *), etStacksize stacksize, etPriority prio){}

void etThread_destruct(etThread* self){}

/*****************mutex**********************/
void etMutex_construct(etMutex* self){}
void etMutex_destruct(etMutex* self){}
void etMutex_enter(etMutex* self){}
void etMutex_leave(etMutex* self){}

/********************semaphore****************/
void etSema_contruct(etSema* self){}
void etSema_destruct(etSema* self){}

void etSema_wakeup(etSema* self){}

void etSema_waitForWakeup(etSema* self){}
/*********************************************/

#endif
