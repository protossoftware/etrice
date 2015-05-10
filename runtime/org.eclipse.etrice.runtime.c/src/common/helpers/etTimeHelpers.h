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

/**
 * \file etTimeHelpers.h
 *
 * a collection of useful methods when working with \ref etTime values
 *
 * \author Thomas Schuetz, Henrik Rentz-Reichert
 */

#ifndef _ETTIMEHELPERS_H_
#define _ETTIMEHELPERS_H_

#include "osal/etTime.h"

/**
 * normalizes the time value to ensure that part is always 0 <= nSec < 1E9
 *
 * \param self the this pointer
 */
void etTimeHelpers_normalize(etTime* self);

/**
 * computes the difference of two times
 *
 * \param self the this pointer
 * \param subtractValue the time to be subtracted
 */
void etTimeHelpers_subtract(etTime *self, const etTime* subtractValue);

/**
 * computes the sum of two times
 *
 * \param self the this pointer
 * \param addValue the time to be added
 */
void etTimeHelpers_add(etTime *self, const etTime* addValue);

/**
 * copies time from source to target
 *
 * \param source source of values to copy from
 * \param target target to copy to
 */
void etTimeHelpers_copy(const etTime* source, etTime* target);

/**
 * convert a time to milliseconds
 *
 * \param time the time to be converted
 */
etInt32 etTimeHelpers_convertToMSec(const etTime *time);

/**
 * convert a time from milliseconds
 *
 * \param result the structure obtaining the result
 * \param milliSeconds the time to be converted
 */
void etTimeHelpers_convertToEtTime(etTime *result, etInt32 milliSeconds);

/**
 * check if t1 is greater than t2
 *
 * \param t1 first time
 * \param t2 second time
 */
boolean etTimeHelpers_isGreater(etTime* t1, etTime* t2);

/**
 * check if t1 is greater than or equal as t2
 *
 * \param t1 first time
 * \param t2 second time
 */
boolean etTimeHelpers_isGreaterOrEqual(etTime* t1, etTime* t2);

#endif /* _ETTIMEHELPERS_H_ */
