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

#include "etWakeupService.h"
#include "etMessage.h"
#include "etMessageService.h"


/**
 * static instance of the execute Message
 */

/**
 * calls cyclically all receiveMessage functions (at the right time) to deliver the poll message
 * */
void etWakeupService_execute(etWakeupService* self) {
	int i;
	for (i=0; i<self->targetListLength; i++){
		/** send message call the receiveMessage function to deliver the execute message */
		etSystemProtocolConjPort_poll( &(self->targetList[i].messageServicePort) );
	}
}


