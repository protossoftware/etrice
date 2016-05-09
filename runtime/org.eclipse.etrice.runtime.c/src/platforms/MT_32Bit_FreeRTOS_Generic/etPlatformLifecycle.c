/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz, Thomas Jung (initial contribution)
 *
 *******************************************************************************/



#include "osal/etPlatformLifecycle.h"
#include "etPlatform.h"


/* implemenatation for eTrice interfaces*/

/* must be implemented projectspecific */
extern void etMultiThreadedFreeRTOSProjectSpecificUserEntry();
void etTimeInit(void);

void etUserEntry(void){
	etTimeInit();
	etMultiThreadedFreeRTOSProjectSpecificUserEntry();
}

void etUserPreRun(void){

	/* Start the scheduler. */
	vTaskStartScheduler();
}

void etUserPostRun(void){ }
void etUserExit(void){ }

