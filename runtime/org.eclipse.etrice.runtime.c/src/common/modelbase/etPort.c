/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "modelbase/etPort.h"

#include "debugging/etMSCLogger.h"
#include "base/etMemory.h"
#include <string.h>

/*
void etPort_receive(const etPort* self, const etMessage* msg) {
	ET_MSC_LOGGER_SYNC_ENTRY("etPort", "receive")
	if (self->receiveMessageFunc!=NULL)
		(self->receiveMessageFunc)(self->myActor, (void*)self, msg);
	ET_MSC_LOGGER_SYNC_EXIT
}
*/

void etPort_sendMessage(const etPort* self, etInt16 evtId, int size, void* data) {
	int offset = MEM_CEIL(sizeof(etMessage));
	int totalSize = offset+size;
	etMessage* msg = NULL;
	ET_MSC_LOGGER_SYNC_ENTRY("etPort", "sendMessage")
	msg = etMessageService_getMessageBuffer(self->msgService, totalSize);
	if (msg!=NULL) {
		msg->address = self->peerAddress;
		msg->evtID = evtId;

		if (size>0 && data!=NULL) {
			memcpy(((char*)msg)+offset, data, size);
		}

		etMessageService_pushMessage(self->msgService, msg);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
