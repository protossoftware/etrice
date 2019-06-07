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
#include "osal/etTime.h"
#include "osal/etThread.h"
#include "etPlatform.h"

/* implemenatation for eTrice interfaces*/

/* noThread contains the pointer to the one and only execute function */
/* in the single threaded environment */
extern etThread * noThread;
void etThread_execute(etThread* self);

/* must be implemented projectspecific */
extern void etSingleThreadedProjectSpecificUserEntry();

void etUserEntry(void){

	etTimeInit();
	etSingleThreadedProjectSpecificUserEntry();
}

void etUserPreRun(void){
/*	__enable_irq(); */
	etThread_execute(noThread);
}

void etUserPostRun(void){ }
void etUserExit(void){ }

