/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "helpers/etTimeHelpers.h"

#define _1E9	1000000000

void etTimeHelpers_normalize(etTime* time) {
	if (time->nSec < 0){
		/* precondition: -1e9 < nSec < 0 */
		time->sec -= 1;
		time->nSec += _1E9;
		/* postcondition: 0<nSec<1e9 ==> no overflow possible */
	}
	else {
		/* treat possible overflow */
		if (time->nSec < _1E9){
			/* no overflow ==> nothing to do */
		}
		else {
			/* overflow ==> shift both values */
			time->sec += 1;
			time->nSec -= _1E9;
		}
	}
}

void etTimeHelpers_subtract(etTime *first, const etTime* second){
	first->sec -= second->sec;
	first->nSec -= second->nSec;
	etTimeHelpers_normalize(first);
}

etTimeDiff etTimeHelpers_delta(const etTime* first, const etTime* second) {
	etTime result = { first->sec-second->sec, first->nSec-second->nSec };
	etTimeHelpers_normalize(&result);

	return result.nSec + _1E9 * result.sec;
}

void etTimeHelpers_add(etTime *first, const etTime* second){
	first->sec += second->sec;
	first->nSec += second->nSec;
	etTimeHelpers_normalize(first);
}

void etTimeHelpers_copy(const etTime* source, etTime* target){
	target->sec = source->sec;
	target->nSec = source->nSec;
}


etInt32 etTimeHelpers_convertToMSec(const etTime *time){
	return time->sec * 1000 + time->nSec / 1000000;
}

void etTimeHelpers_convertToEtTime(etTime *result, etInt32 milliSeconds){
	result->sec = milliSeconds/1000;
	result->nSec = milliSeconds%1000 * 1000000;
}

etBool etTimeHelpers_isGreater(etTime* t1, etTime* t2) {
	if (t1->sec > t2->sec) return ET_TRUE;
	if (t1->sec < t2->sec) return ET_FALSE;
	if (t1->nSec > t2->nSec) return ET_TRUE;
	return ET_FALSE;
}

etBool etTimeHelpers_isGreaterOrEqual(etTime* t1, etTime* t2) {
	if (t1->sec > t2->sec) return ET_TRUE;
	if (t1->sec < t2->sec) return ET_FALSE;
	if (t1->nSec >= t2->nSec) return ET_TRUE;
	return ET_FALSE;
}

