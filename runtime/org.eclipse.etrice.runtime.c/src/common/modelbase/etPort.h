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



#ifndef _ETPORT_H_
#define _ETPORT_H_


#include "messaging/etMessage.h"
#include "messaging/etMessageReceiver.h"
#include "messaging/etMessageService.h"

typedef struct {
	void* varData;
	etMessageService* msgService;
	etAddressId peerAddress;
	etAddressId localId;

	#ifdef etDEBUG
	etAddressId address;
	/* thread ID from msg service: msgService->threadId */
	#endif
} etPort;

typedef struct {
	void* varData;
	etMessageService* msgService;
	etAddressId peerAddress;
	etAddressId localId;
	etAddressId index;

	#ifdef etDEBUG
	etAddressId address;
	/* thread ID from msg service: msgService->threadId */
	#endif
} etReplSubPort;

typedef struct {
	etInt16 size;
	const etReplSubPort* ports;
} etReplPort;

typedef etPort InterfaceItemBase;

//void etPort_receive(const etPort* self, const etMessage* msg);
void etPort_sendMessage(const etPort* self, etInt16 evtId, int size, void* data);



#endif /* _ETPORT_H_ */
