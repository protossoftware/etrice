#ifndef _ETTIMER_H_
#define _ETTIMER_H_


#include "etDatatypes.h"

typedef struct etTargetTime {
       unsigned long nSec;
       unsigned long sec;
} etTargetTime_t;

void etTimer_init(void);

uint32 getNSecFromTarget(void);
uint32 getSecFromTarget(void);

void getTimeFromTarget(etTargetTime_t *t);

int isTimeGreaterThanActualTime(const etTargetTime_t *t);

etBool etTimer_executeNeeded(void);

uint32 getTimeBaseNS(void);

uint32 getTimeBaseUS(void);

uint32 getTimeBaseMS(void);

#endif /* ETTIMER_H_ */
