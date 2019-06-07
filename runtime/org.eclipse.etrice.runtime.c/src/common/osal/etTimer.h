/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Jung (initial contribution)
 *
 *******************************************************************************/

/**
 * \file etTimer.h
 *
 * a timer abstraction
 *
 * \author Thomas Jung
 */
#ifdef __cplusplus
extern "C" {
#endif

#ifndef _ETTIMER_H_
#define _ETTIMER_H_

#include "etDatatypes.h"
#include "etTime.h"


/**
 * the prototype for the time callback function
 */
typedef void (*etTimerFunction)(void* data);

/**
 * etThread holds all data needed to handle a thread instance
 * the struct has to be filled before calling etThread_construct except for osData and osId
 */
typedef struct etTimer{
	etTime timerInterval;				/**< timer interval */
	etTimerFunction timerFunction;		/**< call back function to be called by timer -> has to be filled in by caller of etTimer_construct */
	void* timerFunctionData;			/**< the data that are passed to the timer function */
	etOSTimerData osTimerData;			/**< OS specific timer id (e.g. handle or id) -> is filled in by etTimer_construct */
} etTimer;

/**
 * This method initializes the etTimer struct with the user settings
 *
 * \param self the 'this' pointer of the timer
 * \param timerInterval the interval to be used for the timer
 * \param timerFunction the user supplied callback function
 * \param timerFunctionData the data that will be passed to the user callback function
 */
void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData);

/**
 * starts the timer
 * \param self the 'this' pointer of the timer
 */
void etTimer_start(etTimer* self);

/**
 * stops the timer
 * \param self the 'this' pointer of the timer
 */
void etTimer_stop(etTimer* self);

/**
 * destroys the timer
 * \param self the 'this' pointer of the timer
 */
void etTimer_destruct(etTimer* self);


#endif /* __ETTIMER_H__ */

#ifdef __cplusplus
}
#endif
