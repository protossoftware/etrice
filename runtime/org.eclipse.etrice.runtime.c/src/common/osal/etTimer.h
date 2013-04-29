/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Jung (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETTIMER_H_
#define _ETTIMER_H_

#include "etDatatypes.h"
#include "etTime.h"
#include "etThread.h"


/**
 * etThread holds all data needed to handle a thread instance
 * the struct has to be filled before calling etThread_construct except for osData and osId
 **/
typedef struct etTimer{
	etOSTimerId osTimerId;			/**< OS specific timer id (e.g. handle or id) -> is filled in by etTimer_construct **/
	etTime timerInterval;			/**< timer interval **/
	etTimerFunction timerFunction; /**< call back function to be called by timer -> has to be filled in by caller of etTimer_construct **/
} etTimer;


void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction threadFunction);
void etTimer_start(etTimer* self);
void etTimer_stop(etTimer* self);
void etTimer_destruct(etTimer* self);


#endif /* __ETTIMER_H__ */
