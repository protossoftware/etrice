/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "messaging/etMessage.h"

#include "debugging/etMSCLogger.h"

#include <stddef.h>

void etMessage_init(etMessage* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etMessage", "init")
	self->next = NULL;
	self->address = 0;
	self->evtID = 0;
	ET_MSC_LOGGER_SYNC_EXIT
}
