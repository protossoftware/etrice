#include "platform/etTimer.h"

#include <sys/time.h>

#include "etGlobalFlags.h"

void etTimer_init(void){
}

uint64 getTargetTimeUs(void){
	struct timeval time;
	gettimeofday(&time, NULL);

	return time.tv_sec * 1000000L + time.tv_usec;
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

