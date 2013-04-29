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

#ifndef _ETWAKEUPSERVICE_H_
#define _ETWAKEUPSERVICE_H_

#include "etDatatypes.h"
#include "etSystemProtocol.h"

#include "osal/etTime.h"



typedef struct etWakeupTarget {
	etSystemProtocolConjPort messageServicePort;	/** port to send the poll message to the message service  */
	etTime wakeupTime;			/** time for the cyclic wake up call */
} etWakeupTarget;


typedef struct etWakeupService {
	etWakeupTarget* targetList; /** array with targets to be called */
	etInt16 targetListLength; 	/** number of targets to be called */
} etWakeupService;

void etWakeupService_execute(etWakeupService* self);


#endif /* _ETWAKEUPSERVICE_H_ */
