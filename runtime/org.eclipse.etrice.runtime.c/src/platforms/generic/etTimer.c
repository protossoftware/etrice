#include "platform/etTimer.h"

#include <sys/time.h>

#include "etGlobalFlags.h"

void etTimer_init(void){
}

uint64 getTargetTimeUs(void){
	struct timeval currentTime;
	gettimeofday(&currentTime, NULL);

	return currentTime.tv_sec * 1000000L + currentTime.tv_usec;
}

etBool etTimer_executeNeeded(void){

	static uint64 lastTime = 0L;

	uint64 currentTime = getTargetTimeUs();

	uint64 timestep = 1000000L/FREQUENCY;

	if (currentTime >= lastTime +  timestep) {
		lastTime = currentTime;
		return TRUE;
	}
	else {
		return FALSE;
	}
}

void getTimeFromTarget(etTargetTime_t *t){
	struct timeval currentTime;
	gettimeofday(&currentTime, NULL);
	t->sec = currentTime.tv_sec;
	t->nSec = currentTime.tv_usec*1000;
}
