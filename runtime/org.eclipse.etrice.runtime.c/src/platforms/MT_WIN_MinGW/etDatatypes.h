/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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

#undef WINVER
#define WINVER 0x0500
#include <windows.h>

ET_EXTERN_C_BEGIN

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
typedef DWORD etOSTimerId;
typedef SOCKET etOSSocketData;

/** Switches the etTimer implementation to use the Windows Multimedia timer API **/
/* #define ET_RT_WIN_TIMER_MM */

#ifdef ET_RT_WIN_TIMER_MM
typedef MMRESULT etOSTimerData;
#else /* ET_RUNTIME_WIN_TIMER_MM */
typedef HANDLE etOSTimerData;
#endif /* ET_RUNTIME_WIN_TIMER_MM */

/*-----------------------------------------------------------*/

ET_EXTERN_C_END

#endif /* _DATATYPES_H_ */
