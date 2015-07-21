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
 * MinGW version
 */

#define ET_INT64
#define ET_FLOAT32
#define ET_FLOAT64

#include "etStdDatatypes.h"

#include <stdio.h>

#define WINVER 0x0500
#include <windows.h>

/*--- Data types for room.basic.types */

/*-----------------------------------------------------------*/

/*--- Data types for runtime */

#define etALIGNMENT		8	/* power of 2 and >= sizeof(int) ! */

typedef FILE* etFileHandle;

/* types for osal */
typedef CRITICAL_SECTION etOSMutexData;
typedef HANDLE etOSThreadData;
typedef DWORD etOSThreadId;
typedef HANDLE etOSSemaData;
typedef HANDLE etOSTimerData;
typedef DWORD etOSTimerId;

/*-----------------------------------------------------------*/

#endif /* _DATATYPES_H_ */
