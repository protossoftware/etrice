/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Jung (initial contribution)
 *
 *******************************************************************************/
/*******************************************************************************
 * This file implements the project specific part of the FreeRTOS
 * runtime for a XMC ARM Cortex microcontroller from Infineon.
 *
 * It demonstrates how to adapt to your specific microcontroller and Realtime OS.
 *
 ********************************************************************************/

#include "osal/etTime.h"
#include "Dave.h"
#include "helpers/etTimeHelpers.h"

void etMultiThreadedFreeRTOSProjectSpecificUserEntry();

/* this function will be called during initialization */
/* and must be implemented project specific */
void etMultiThreadedFreeRTOSProjectSpecificUserEntry(){
	if (DAVE_Init() == DAVE_STATUS_FAILURE){
		while(1);
	}
}

/* the FreeRTOS Hooks must be implemented depending on */
/* your FreeRTOS configuration */
void vApplicationMallocFailedHook(void){
	while (1);
}

void vApplicationStackOverflowHook( xTaskHandle *pxTask, signed char *pcTaskName )
{
	( void ) pxTask;
	( void ) pcTaskName;

	/* Run time stack overflow checking is performed if
	configconfigCHECK_FOR_STACK_OVERFLOW is defined to 1 or 2.  This hook
	function is called if a stack overflow is detected. */
	taskDISABLE_INTERRUPTS();
	for( ;; );
}

void vApplicationIdleHook(void){
volatile int i;

	i++;
}
