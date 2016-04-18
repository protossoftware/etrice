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

/**
 *
 * etTime.c FreeRTOS implementation of etTime
 *
 */

#include "osal/etTime.h"

etTime targetTime;

void etTimeInit(void){
	targetTime.nSec=0;
	targetTime.sec=0;
}


void getTimeFromTarget(etTime *t) {
	portENTER_CRITICAL();
	*t = targetTime;
	portEXIT_CRITICAL();
}

void vApplicationTickHook(void){
	/* Tickrate from FreeRTOS Config */
	targetTime.nSec += (1000000000UL / configTICK_RATE_HZ);
	if (targetTime.nSec >= 1000000000UL) {
		targetTime.nSec -= 1000000000UL;
		targetTime.sec++;
		}
}


