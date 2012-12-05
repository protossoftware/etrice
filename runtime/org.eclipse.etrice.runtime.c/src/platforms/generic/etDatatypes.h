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
 * generic Version for most bigger 32 and 64 bit platforms like Linux an Windows
 *
 * */

#include <stdio.h>

#if defined __MINGW32__
#include <windows.h>
#include <process.h>
#elif defined __GNUC__
#else
#error
#endif


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

/* boolean datatypes and values */
typedef char bool;  /* TODO: bool, Bool, Boolean, and boolean are already defined in some platforms*/
#ifndef __MINGW32__
	typedef bool boolean;
#endif

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

typedef bool etBool;

typedef float32 etFloat32;
typedef float64 etFloat64;

typedef FILE* etFileHandle;

typedef int8 etAddressId;

/*
 * typedefs for threading
 */

#if defined __MINGW32__

	typedef CRITICAL_SECTION etMutex;
	typedef HANDLE etThread;
	typedef HANDLE etSema;

	typedef int32 etStacksize;
	typedef int32 etPriority;
	typedef charPtr etThreadname;

#elif defined __GNUC__

	/* dummy for LINUX/UNIX */
	typedef int etMutex;
	typedef int etThread;
	typedef int etSema;

	typedef int32 etStacksize;
	typedef int32 etPriority;
	typedef charPtr etThreadname;

#else
	#error
#endif

#endif /* _DATATYPES_H_ */
