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
 * FreeRTOS on a 32Bit version
 */

#define ET_INT64
#define ET_FLOAT32
/*#define ET_FLOAT64 /* not available on this platform */ */

#include "etStdDatatypes.h"

#include <stdio.h>
#include <FreeRTOS.h>
#include <task.h>
#include <timers.h>
#include <semphr.h>

/*--- Data types for room.basic.types */

/*-----------------------------------------------------------*/

/*--- Data types for runtime */

#define etALIGNMENT		4	/* power of 2 and >= sizeof(int) ! */

typedef FILE* etFileHandle;

/* types for osal */
typedef xSemaphoreHandle etOSMutexData;
typedef xSemaphoreHandle etOSSemaData;

typedef xTaskHandle etOSThreadData;
typedef etUInt16 etOSThreadId;

typedef xTimerHandle etOSTimerData;
typedef etUInt16 etOSTimerId;

/*-----------------------------------------------------------*/

#endif /* _DATATYPES_H_ */
