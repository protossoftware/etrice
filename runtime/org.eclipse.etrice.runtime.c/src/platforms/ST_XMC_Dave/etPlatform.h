/*
 * etPlatform.h
 *
 *  Created on: 23.06.2012
 *      Author: junggtho
 */

#ifndef ETPLATFORM_H_
#define ETPLATFORM_H_

/** Dave ST specific definitions */

/* define if SYSTIMER App is available or not */
/* some higher level Apps requires the SYSTIMER App */
/* if SYSTIMER App is not required from the application, */
/* eTrice will use the TimerTick Interrupt directly */
#define ET_USE_DAVE_SYSTIMER_APP

/* define systimer interrupt period [us] */
/* valid with or without SYSTIMER App */
/* e.g. 1000 => Systimer will tick every 1ms */
/*      500  => Systimer will tick every 500us */
/*      4000 => Systimer will tick every 4ms */
#define ET_DAVE_TICK_PERIOD_USEC	1000

/*********************************/

void initHw(void);

#endif /* ETPLATFORM_H_ */
