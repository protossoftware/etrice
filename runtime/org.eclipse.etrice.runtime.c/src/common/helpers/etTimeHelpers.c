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

etInt32 etTimeHelpers_convertToMSec(etTime *time){
	return time->sec * 1000 + time->nSec / 1000000;
}

void etTimeHelpers_convertToEtTime(etTime *result, etInt32 milliSeconds){
	result->sec = milliSeconds/1000;
	result->nSec = milliSeconds%1000 * 1000000;
}
