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


#include "runtime/etRuntime.h"


static etSema terminateSemaphore;
static etMessageService* head = NULL;

etSema* etRuntime_getTerminateSemaphore() {
	static etBool initialized = ET_FALSE;

	if (!initialized) {
		initialized = ET_TRUE;
		etSema_construct(&terminateSemaphore);
	}

	return &terminateSemaphore;
}

int etRuntime_getMessageServiceCount() {
	etMessageService* p = head;

	int count = 0;
	while (p!=null) {
		++count;
		p = p->next;
	}
	return count;
}

int etRuntime_getMessageServiceByName(const char* name) {
	etMessageService* p = head;

	int idx = 0;
	while (p!=null) {
		if (strcmp(p->name, name)==0) {
			return idx;
		}
		++idx;
		p = p->next;
	}

	return -1;
}

const etMessageServiceStatistics* etRuntime_getMessageServiceStatistics(unsigned int i) {
	etMessageService* p = head;

	int count = 0;
	while (p!=null) {
		if (count==i) {
			return &p->statistics;
		}
		++count;
		p = p->next;
	}

	return NULL;
}

void etRuntime_resetAllMessageServiceStatistics() {
	etMessageService* p = head;

	while (p!=null) {
		p->resetStatistics = ET_TRUE;
		p = p->next;
	}
}

void etRuntime_registerMessageService(etMessageService* msgService) {
	msgService->next = head;
	head = msgService;

	if (msgService->name==NULL) {
		void* p = malloc(16);
		sprintf(p, "MsgSvc_%d", etRuntime_getMessageServiceCount());
		msgService->name = (const char*) p;
	}
}

void etRuntime_unregisterMessageService(etMessageService* msgService) {
	etMessageService* p = head;
	etMessageService* last = NULL;

	while (p!=null) {
		if (p==msgService) {
			if (last==NULL) {
				/* remove the first one */
				head = p->next;
			}
			else {
				last->next = p->next;
			}
			break;
		}
		last = p;
		p = p->next;
	}
}
