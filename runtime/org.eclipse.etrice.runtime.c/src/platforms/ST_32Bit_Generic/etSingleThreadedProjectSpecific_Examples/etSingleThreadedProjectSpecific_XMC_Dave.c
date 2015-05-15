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


#include "osal/etTime.h"
#include "XMC4500.h"
#include "Dave.h"
#include "helpers/etTimeHelpers.h"

const PPB_Type *ppb=(PPB_Type *)0xE000E000;

extern etTime etTargetTime;
void DAVE_InstallTickHandler(void);

void getTimeFromTarget(etTime *t) {
etTime t1={0,0};

	// keep in mind that it is not possible to stop the timer counter itself
	// overflow must be checked after reading the counter
	// if an overflow occurs do it again

	// the count flag is clear on read, read it
	t1.nSec=ppb->SYST_CSR;
	do {
		// amount of ticks = reloadRegister - countRegister
		t1.nSec=(ppb->SYST_RVR-ppb->SYST_CVR);
		*t = etTargetTime;
	}while(ppb->SYST_CSR & 0x00010000);

	// nSec = amount of ticks * 1000 / 120; if CPUCLK == 120Mhz
	t1.nSec*=1000;
	t1.nSec/=(SYSTIMER_SYS_CORE_CLOCK/1000000);
	// add t1 to time
	etTimeHelpers_add(t,&t1);
}

/* the timer interrupt */

void etTick_Handler(void *nanoSecPerTick) {
// this interrupt will be called every 1ms
//	targetTime.nSec += 1000000L;
	etTargetTime.nSec += (uint32_t)nanoSecPerTick;

	if (etTargetTime.nSec >= 1000000000L) {
		etTargetTime.nSec -= 1000000000L;
		etTargetTime.sec++;
	}
}

void etSingleThreadedProjectSpecificUserEntry(void){
	DAVE_Init();
	DAVE_InstallTickHandler();
}


void DAVE_InstallTickHandler(void){
uint32_t timerId;
	  timerId = SYSTIMER_CreateTimer(1000,SYSTIMER_PERIODIC,etTick_Handler,(void*) 1000000);
	  SYSTIMER_StartTimer(timerId);
}

