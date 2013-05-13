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

#ifndef _ETDATATYPES_H_
#define _ETDATATYPES_H_

/*
 * typedefs for platform specific datatypes
 * POSIX version
 *
 * */

#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <sys/types.h>

/* unsigned integer datatypes */
typedef unsigned char uint8;
typedef unsigned short int uint16;
typedef unsigned long uint32;
typedef unsigned long long uint64;

/* signed integer datatypes */
typedef char int8;
typedef short int int16;
typedef long int32;
typedef long long int64;


/* float datatypes */
typedef float float32;
typedef double float64;

/* string datatypes */
typedef char* charPtr;


#ifndef NULL
	#define NULL 0
#endif

/* boolean datatypes and values */
typedef char bool;  	/* TODO: bool, Bool, Boolean, and boolean are already defined in some platforms*/
typedef bool boolean;

#ifndef TRUE
	#define TRUE 1
#endif
#ifndef FALSE
	#define FALSE 0
#endif

#define ALIGNMENT		4

/*
 * typedefs for eTrice Runtime and Testing
 *
 * */

typedef int8 etInt8;
typedef int16 etInt16;
typedef int32 etInt32;

typedef uint8 etUInt8;
typedef uint16 etUInt16;
typedef uint32 etUInt32;

typedef charPtr etCharPtr;

typedef float32 etFloat32;
typedef float64 etFloat64;

typedef bool etBool;


typedef FILE* etFileHandle;

typedef int16 etAddressId;

/*
 * typedefs for OS-specific types
 */

typedef pthread_mutex_t etOSMutexData;
typedef pthread_t etOSThreadData;
typedef pid_t etOSThreadId;
typedef sem_t etOSSemaData;
typedef struct {
	void* next;
	timer_t timerid;
	etBool signaled;
}
etOSTimerData;
typedef timer_t etOSTimerId;


#endif /* _DATATYPES_H_ */
