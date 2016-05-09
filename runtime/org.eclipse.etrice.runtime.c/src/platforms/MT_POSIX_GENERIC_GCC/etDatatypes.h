/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 * 		Henrik Rentz-Reichert
 *
 *******************************************************************************/

#ifndef _ETDATATYPES_H_
#define _ETDATATYPES_H_

/*
 * typedefs for platform specific datatypes
 * POSIX version
 */

#define ET_INT64
#define ET_FLOAT32
#define ET_FLOAT64

#include "etStdDatatypes.h"

#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
#include <bits/siginfo.h>
#include <time.h>
#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

/*--- Data types for room.basic.types */

/*-----------------------------------------------------------*/

/*--- Data types for runtime */

#define etALIGNMENT		8	/* power of 2 and >= sizeof(int) ! */

typedef FILE* etFileHandle;

/* types for osal */
typedef pthread_mutex_t etOSMutexData;
typedef pthread_t etOSThreadData;
typedef pthread_t etOSThreadId;
typedef sem_t etOSSemaData;
typedef struct {
	void* next;
	timer_t timerid;
	sigevent_t te;
	etBool signaled;
} etOSTimerData;
typedef timer_t etOSTimerId;

/*-----------------------------------------------------------*/

#endif /* _DATATYPES_H_ */
