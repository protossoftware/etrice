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

#ifndef _ETTIMEHELPERS_H_
#define _ETTIMEHELPERS_H_

#include "osal/etTime.h"

void etTime_subtract(etTime *self, etTime* subtractValue);
void etTime_add(etTime *self, etTime* addValue);
etInt32 etTimeHelpers_convertToMSec(etTime *time);
void etTimeHelpers_convertToEtTime(etTime *result, etInt32 milliSeconds);


#endif /* _ETTIMEHELPERS_H_ */
