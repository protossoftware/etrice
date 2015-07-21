/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/

/*
 *  Generic version for most platforms based on std.
 */

#ifndef _ETSTDDATATYPES_H_
#define _ETSTDDATATYPES_H_

/*
 Define switches for additional data types:
 #define ET_INT64
 #define ET_FLOAT32
 #define ET_FLOAT64
 */

#include <stddef.h>
#include <stdint.h>
#include <stdbool.h>

/* --- Data types for room.basic.types */

// bool already defined
typedef uint8_t uint8;
typedef uint16_t uint16;
typedef uint32_t uint32;

typedef int8_t int8;
typedef int16_t int16;
typedef int32_t int32;

#ifdef ET_INT64
typedef uint64_t uint64;
typedef int64_t int64;
#endif

#ifdef ET_FLOAT32
typedef float float32;
#endif
#ifdef ET_FLOAT64
typedef double float64;
#endif

typedef char* charPtr;

/*-----------------------------------------------------------*/

/*--- Cross language support (e.g. Java,C/C++) */

#define null NULL
// typedef x boolean

/*-----------------------------------------------------------*/

//--- Required types of runtime
typedef bool etBool;
#define ET_TRUE true
#define ET_FALSE false

typedef uint8 etUInt8;
typedef uint16 etUInt16;
typedef uint32 etUInt32;

typedef int8 etInt8;
typedef int16 etInt16;
typedef int32 etInt32;

#ifdef ET_INT64
typedef uint64_t etUInt64;
typedef int64_t etInt64;
#endif

#ifdef ET_FLOAT32
typedef float32 etFloat32;
#endif
#ifdef ET_FLOAT64
typedef float64 etFloat64;
#endif

typedef charPtr etCharPtr;

typedef etInt16 etAddressId;

/* mandatory:
 #define etALIGNMENT		x	// power of 2 and >= sizeof(int) !
 typedef x etFileHandle;
 */

/*
 typedef float32 etFloat32;
 typedef float64 etFloat64;
 */

/* types for osal */

/* mandatory:
 typedef x etOSMutexData;
 typedef x etOSThreadData;
 typedef x etOSThreadId;
 typedef x etOSSemaData;
 typedef x etOSTimerData;
 typedef x etOSTimerId;
 */

/*-----------------------------------------------------------*/

#endif /* _ETSTDDATATYPES_H_ */
