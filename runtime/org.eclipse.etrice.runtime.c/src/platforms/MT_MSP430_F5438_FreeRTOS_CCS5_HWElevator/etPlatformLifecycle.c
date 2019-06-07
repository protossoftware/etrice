/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz, Thomas Jung (initial contribution)
 *
 *******************************************************************************/



#include "osal/etPlatformLifecycle.h"
#include "etPlatform.h"

/* implemenatation for eTrice interfaces*/


void etUserEntry(void){
	initHw();
	etTime_init();
}

void etUserPreRun(void){
	enableInterrupt();
	/* Start the scheduler. */
	vTaskStartScheduler();

}

void etUserPostRun(void){ }
void etUserExit(void){ }

