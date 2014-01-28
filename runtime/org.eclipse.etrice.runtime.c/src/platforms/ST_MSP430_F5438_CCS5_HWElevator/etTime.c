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

#include "osal/etTime.h"

etTime targetTime;

void etTime_init(void){
	targetTime.nSec=0;
	targetTime.sec=0;
}


void getTimeFromTarget(etTime *t) {
	_disable_interrupt();
	*t = targetTime;
	_enable_interrupt();
}

/* the timer interrupt */
#pragma INTERRUPT(wdt_isr)
#pragma vector=WDT_VECTOR
void wdt_isr(void) {
// this interrupt will be called every 15,625ms or 1,953125ms
	targetTime.nSec += 15625000L;

	if (targetTime.nSec >= 1000000000L) {
		targetTime.nSec -= 1000000000L;
		targetTime.sec++;
	}
//	P10OUT ^= 0x01; //toggle testpin
} // end interrupt


