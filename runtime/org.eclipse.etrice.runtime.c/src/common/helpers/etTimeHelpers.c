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

#include "helpers/etTimeHelpers.h"

#define _1E9	1000000000

static void normalize(etTime* time) {
	etInt32 f = time->nSec / _1E9;
	if (f>0) {
		time->sec += f;
		time->nSec -= f*_1E9;
	}
	else if (f<0) {
		++f;
		time->sec -= f;
		time->nSec += f*_1E9;
	}
}

void etTimeHelpers_subtract(etTime *first, const etTime* second){
	first->sec -= second->sec;
	first->nSec -= second->nSec;
	normalize(first);
}

void etTimeHelpers_add(etTime *first, const etTime* second){
	first->sec += second->sec;
	first->nSec += second->nSec;
	normalize(first);
}

etInt32 etTimeHelpers_convertToMSec(const etTime *time){
	return time->sec * 1000 + time->nSec / 1000000;
}

void etTimeHelpers_convertToEtTime(etTime *result, etInt32 milliSeconds){
	result->sec = milliSeconds/1000;
	result->nSec = milliSeconds%1000 * 1000000;
}
