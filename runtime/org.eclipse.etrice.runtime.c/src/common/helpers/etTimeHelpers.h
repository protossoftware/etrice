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
 * computes the difference of two times
 *
 * \param self the this pointer
 * \param subtractValue the time to be subtracted
 */
void etTime_subtract(etTime *self, const etTime* subtractValue);

/**
 * computes the sum of two times
 *
 * \param self the this pointer
 * \param addValue the time to be added
 */
void etTime_add(etTime *self, const etTime* addValue);

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


#endif /* _ETTIMEHELPERS_H_ */
