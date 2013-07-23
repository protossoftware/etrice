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

typedef struct etTargetTime {
       unsigned long nSec;
       unsigned long sec;
} etTargetTime_t;

#ifdef __cplusplus
extern "C" {
#endif
void etTimer_init(void);

uint32 getNSecFromTarget(void);
uint32 getSecFromTarget(void);

void getTimeFromTarget(etTargetTime_t *t);

int isTimeGreaterThanActualTime(const etTargetTime_t *t);

etBool etTimer_executeNeeded(void);

uint32 getTimeBaseNS(void);

uint32 getTimeBaseUS(void);

uint32 getTimeBaseMS(void);

#ifdef __cplusplus
}
#endif
#endif /* __ETTIMER_H__ */
