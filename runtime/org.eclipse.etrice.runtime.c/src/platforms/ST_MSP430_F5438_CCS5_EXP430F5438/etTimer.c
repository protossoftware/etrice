#include "platform/etTimer.h"

#include "hal_MSP-EXP430F5438.h"

/* global timer */

static etTargetTime_t targetTime;
static etTargetTime_t lastTargetTime;
static volatile etBool etTimer_executeFlag = ET_FALSE;

void etTimer_init(void){
	targetTime.nSec=0;
	targetTime.sec=0;
	lastTargetTime.nSec=0;
	lastTargetTime.sec=0;
}

etBool etTimer_executeNeeded(void){
	if (etTimer_executeFlag == ET_TRUE){
		etTimer_executeFlag = ET_FALSE;
		return ET_TRUE;
	}
	else {
		return ET_FALSE;
	}
}

int isTimeGreaterThanActualTime(const etTargetTime_t *t) {

	_disable_interrupt();
	if (t->sec > targetTime.sec) {
		_enable_interrupt();
		return 1;
	}

	if (t->sec < targetTime.sec) {
		_enable_interrupt();
		return 0;
	}

	if (t->nSec > targetTime.nSec) {
		_enable_interrupt();
		return 1;
	}
	else {
		_enable_interrupt();
		return 0;
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

#define ET_TIMER_TIME_BASE_NS 15625000L
#define ET_TIMER_TIME_BASE_US ET_TIMER_TIME_BASE_NS / 1000L
#define ET_TIMER_TIME_BASE_MS ET_TIMER_TIME_BASE_US / 1000L

uint32 getTimeBaseNS(void){
	return ET_TIMER_TIME_BASE_NS;
}

uint32 getTimeBaseUS(void){
	return ET_TIMER_TIME_BASE_US;
}

uint32 getTimeBaseMS(void){
	return ET_TIMER_TIME_BASE_MS;
}


/* the timer interrupt */
#pragma INTERRUPT(wdt_isr)

#pragma vector=WDT_VECTOR

void wdt_isr(void) {
// this interrupt will be called every 15,625ms

	static unsigned char secCounter = 0;
	etTimer_executeFlag = ET_TRUE;

	targetTime.nSec += 15625000L;

	if (targetTime.nSec >= 1000000000L) {
		targetTime.nSec -= 1000000000L;
		targetTime.sec++;
	}
	secCounter++;

	if (secCounter >= 64) {
		secCounter = 0;
	}

} // end interrupt
