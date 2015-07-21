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
 * Version for 32 Bit Controllers like ARM Cortex M
 */

#define ET_INT64
#define ET_FLOAT32
//#define ET_FLOAT64 /* not available on this platform */


#include "etStdDatatypes.h"

#include <stdio.h>

/*--- Data types for room.basic.types */

/*-----------------------------------------------------------*/

/*--- Data types for runtime */

#define ALIGNMENT		4	/* power of 2 and >= sizeof(int) ! */

typedef FILE* etFileHandle;

/* types for osal */
typedef etUInt32 etOSMutexData;
typedef etUInt32 etOSSemaData;
typedef etUInt32 etOSThreadData;
typedef etUInt32 etOSThreadId;
typedef etUInt32 etOSTimerData;
typedef etUInt32 etOSTimerId;

/*-----------------------------------------------------------*/

#endif /* _DATATYPES_H_ */
