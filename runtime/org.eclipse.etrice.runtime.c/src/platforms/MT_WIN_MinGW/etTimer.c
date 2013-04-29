/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

/**
 *
 * etTimer.c MinGW implementation of etTimer
 *
 */

#include "osal/etTimer.h"
#include "helpers/etTimeHelpers.h"

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction threadFunction){
	self->osTimerId = 0;
	self->timerInterval.sec = timerInterval->sec;
	self->timerInterval.nSec = timerInterval->nSec;
	self->timerFunction = threadFunction;
}

void etTimer_start(etTimer* self){
	UINT elapse;
	/* calculate the time in milliseconds -> accuracy will of nSec will get lost in windows! */
	elapse = etTimeHelpers_convertToMSec(&(self->timerInterval));
	/*TODO: should we replace the forced cast by a platform specific implementation of the timer callback function? */
	self->osTimerId = SetTimer(NULL, 0, elapse, self->timerFunction);
}

void etTimer_stop(etTimer* self){
	KillTimer(NULL, self->osTimerId);
}

void etTimer_destruct(etTimer* self){
	/* no implementation needed for this operating system */
}
