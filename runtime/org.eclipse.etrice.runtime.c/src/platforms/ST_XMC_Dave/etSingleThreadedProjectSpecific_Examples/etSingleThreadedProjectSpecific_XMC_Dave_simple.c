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
#include "Dave.h"
#include "helpers/etTimeHelpers.h"
#include "etRuntimeConfig.h"
#include "etPlatform.h"

extern etTime etTargetTime;
void DAVE_InstallTickHandler(void);

void getTimeFromTarget(etTime *t) {
/* return the time */
/* make sure that reading the time is an atomic opration */
/* => the timer interrupt should not interrupt this operation */
	__disable_irq();
	*t = etTargetTime;
	__enable_irq();
}

/* the timer interrupt */
void etTick_Handler(void *nanoSecPerTick) {

	etTargetTime.nSec += (uint32_t)nanoSecPerTick;

	if (etTargetTime.nSec >= 1000000000L) {
		etTargetTime.nSec -= 1000000000L;
		etTargetTime.sec++;
	}
}

/* this function will be called during initialization */
void etSingleThreadedProjectSpecificUserEntry(void){
	DAVE_InstallTickHandler();
}

#ifdef ET_USE_DAVE_SYSTIMER_APP
#else
void SysTick_Handler(void){
	etTick_Handler((void *)(ET_DAVE_TICK_PERIOD_USEC * 1000));
}
#endif

/* The SYSTIMER App from DAVE must be available */
void DAVE_InstallTickHandler(void){
#ifdef ET_USE_DAVE_SYSTIMER_APP
  uint32_t timerId;
   timerId = SYSTIMER_CreateTimer(ET_DAVE_TICK_PERIOD_USEC,SYSTIMER_MODE_PERIODIC,etTick_Handler,(void*) (ET_DAVE_TICK_PERIOD_USEC * 1000));
   SYSTIMER_StartTimer(timerId);
#else
   SysTick_Config(SystemCoreClock * (ET_DAVE_TICK_PERIOD_USEC * 0.000001F));
#endif /*ET_USE_DAVE_SYSTIMER_APP */
}
