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
#include "osal/etTime.h"
#include "osal/etThread.h"
#include "etPlatform.h"

/* implemenatation for eTrice interfaces*/

// noThread contains the pointer to the one and only execute function
// in the single threaded environment
extern etThread * noThread;
//void etThread_execute(etThread* self);

// must be implemented projectspecific
extern void etSingleThreadedProjectSpecificUserEntry();
void etUserEntry(void){

	etTimeInit();
	etSingleThreadedProjectSpecificUserEntry();
//	DAVE_Init();
//	DAVE_InstallTickHandler();
//	initHw();
}

void etUserPreRun(void){
//	__enable_irq();
	etThread_execute(noThread);
}

void etUserPostRun(void){ }
void etUserExit(void){ }

