/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution), Thomas Jung
 *
 *******************************************************************************/

#ifndef _ETDATATYPES_H_
#define _ETDATATYPES_H_

/*
 * typedefs for platform specific datatypes
 * Version for TI MSP 430
 *
 * */

#include <stdio.h>

/* unsigned integer datatypes */
typedef unsigned char uint8;
typedef unsigned short int uint16;
typedef unsigned long uint32;
/* typedef unsigned long long uint64; */ /* not available on this platform */

/* signed integer datatypes */
typedef char int8;
typedef short int int16;
typedef long int32;
/* typedef long long int64; */ /* not available on this platform */


/* float datatypes */
typedef float float32;
/* typedef double float64; */ /* not available on this platform */

/* boolean datatypes and values */
typedef char bool;  /* TODO: bool, Bool, Boolean, and boolean are already defined in some platforms*/
typedef bool boolean;
#ifndef ET_TRUE
	#define ET_TRUE 1
#endif
#ifndef ET_FALSE
	#define ET_FALSE 0
#endif
#ifndef true
	#define true 1
#endif
#ifndef false
	#define false 0
#endif

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

typedef bool etBool;

#define ALIGNMENT		2	/* power of 2 and >= sizeof(int) ! */

typedef float32 etFloat32;
typedef float32 etFloat64;

/* string datatypes */
typedef char* charPtr;


typedef FILE* etFileHandle;

typedef int8 etAddressId;


/*
 * typedefs for OS-specific types
 */

typedef uint16 etOSThreadId;

typedef uint16 etOSTimerId;


#endif /* _DATATYPES_H_ */
