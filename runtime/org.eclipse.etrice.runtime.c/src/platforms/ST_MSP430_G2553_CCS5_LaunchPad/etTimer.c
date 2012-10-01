#include "msp430g2553.h"
#include "platform/etTimer.h"

/* global timer */

static etTargetTime_t targetTime;
static etTargetTime_t lastTargetTime;
static volatile etBool etTimer_executeFlag = FALSE;

void etTimer_init(void){
	targetTime.nSec=0;
	targetTime.sec=0;
	lastTargetTime.nSec=0;
	lastTargetTime.sec=0;
}

etBool etTimer_executeNeeded(void){
	if (etTimer_executeFlag == TRUE){
		etTimer_executeFlag = FALSE;
		return TRUE;
	}
	else {
		return FALSE;
	}
}

uint32 getNSecFromTarget(void){
	etTargetTime_t time;
	getTimeFromTarget(&time);
	return time.nSec;
}

uint32 getSecFromTarget(void){
	etTargetTime_t time;
	getTimeFromTarget(&time);
	return time.sec;
}


void getTimeFromTarget(etTargetTime_t *t) {
	_disable_interrupt();
	*t = targetTime;
	_enable_interrupt();
}

/* the timer interrupt */
#pragma INTERRUPT(wdt_isr)
#pragma vector=WDT_VECTOR

void wdt_isr(void) {
// this interrupt will be called every 15,625ms

	static unsigned char secCounter = 0;
	etTimer_executeFlag = TRUE;

	targetTime.nSec += 15625000L;

	if (targetTime.nSec >= 1000000000L) {
		targetTime.nSec -= 1000000000L;
		targetTime.sec++;
	}
	secCounter++;

	if (secCounter >= 64) {
		secCounter = 0;
//		P1OUT^=0x01;
	}

} // end interrupt
