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
 * 		Thomas Jung (initial contribution)
 *
 *******************************************************************************/

/*******************************************************************************
 * This file implements the project specific part of teh single threaded
 * runtime for a XMC ARM Cortex microcontroller from Infineon.
 *
 * It demonstrates how to adapt to your specific microcontroller. The only thing
 * you need is a periodic interrupt which maintains the etTime. This is the base
 * for all the modeltimers you can use in your eTrice model.
 *
 * This implementation gives you a 1ms accurate time. For most applications this
 * resolution is sufficient and the implementation is much simpler. This version
 * could serve as a starting point for your own project with any other microcontroller.
 *
 ********************************************************************************/

#include "osal/etTime.h"
#include "helpers/etTimeHelpers.h"
#include "debugging/etLogger.h"

#include <windows.h>

extern etTime etTargetTime;
void incTimeFromTarget(etUInt32 ms);

void getTimeFromTarget(etTime *t) {
	/* return the time */
	/* make sure that reading the time is an atomic operation */
	/* => the timer interrupt should not interrupt this operation */

	/* for windows we use the Sleep function to enforce the time slices for single threaded */
	/* the WindowsMinGW_ST is only meant for debugging, since the single threaded concept is only meant for bare metal targets */
	etUInt32 cycle_time_ms = 100;
	Sleep(cycle_time_ms);
	incTimeFromTarget(cycle_time_ms); /* hack to satisfy timer needs: increment time by 100 ms per cycle */

	*t = etTargetTime;

}

void incTimeFromTarget(etUInt32 ms) {
	etTargetTime.nSec += ms * 1000000; /* ns = ms *1000000 */

	if (etTargetTime.nSec >= 1000000000L) {
		etTargetTime.nSec -= 1000000000L;
		etTargetTime.sec++;
	}
}

/* this function will be called during initialization */
void etSingleThreadedProjectSpecificUserEntry(void) {
}

