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
#include "debugging/etMSCLogger.h"


static etSema terminateSemaphore;
static etMessageService* etRuntime_msgsvc_head;
static etMemory* etRuntime_memmgmt_head;

etSema* etRuntime_getTerminateSemaphore() {
	static etBool initialized = ET_FALSE;
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getTerminateSemaphore")

	if (!initialized) {
		initialized = ET_TRUE;
		etSema_construct(&terminateSemaphore);
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return &terminateSemaphore;
}

static void etRuntime_initInternal() {
	// global variables might not be initialized before a function call - so we use this trick
	static etBool initialized = ET_FALSE;

	if (!initialized) {
		initialized = ET_TRUE;
		etRuntime_msgsvc_head = NULL;
		etRuntime_memmgmt_head = NULL;
	}

}

int etRuntime_getMessageServiceCount() {
	int count = 0;
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMessageServiceCount")
	etRuntime_initInternal();
	{
		etMessageService* p = etRuntime_msgsvc_head;
		while (p!=NULL) {
			++count;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return count;
}

int etRuntime_getMessageServiceByName(const char* name) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMessageServiceByName")

	{
		etMessageService* p = etRuntime_msgsvc_head;
		int idx = 0;
		while (p!=NULL) {
			if (strcmp(p->name, name)==0) {
				ET_MSC_LOGGER_SYNC_EXIT
				return idx;
			}
			++idx;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return -1;
}

const etMessageServiceStatistics* etRuntime_getMessageServiceStatistics(unsigned int i) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMessageServiceStatistics")

	{
		etMessageService* p = etRuntime_msgsvc_head;
		int count = 0;
		while (p!=NULL) {
			if (count==i) {
				ET_MSC_LOGGER_SYNC_EXIT
				return &p->statistics;
			}
			++count;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

const char* etRuntime_getMessageServiceName(unsigned int i) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMessageServiceName")

	{
		etMessageService* p = etRuntime_msgsvc_head;
		int count = 0;
		while (p!=NULL) {
			if (count==i) {
				ET_MSC_LOGGER_SYNC_EXIT
				return p->name;
			}
			++count;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

void etRuntime_resetAllMessageServiceStatistics() {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "resetAllMessageServiceStatistics")

	{
		etMessageService* p = etRuntime_msgsvc_head;
		while (p!=NULL) {
			p->resetStatistics = ET_TRUE;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
}

void etRuntime_registerMessageService(etMessageService* msgService) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "registerMessageService")

	{
		msgService->next = etRuntime_msgsvc_head;
		etRuntime_msgsvc_head = msgService;
		if (msgService->name==NULL) {
			void* p = malloc(16);
			sprintf(p, "MsgSvc_%d", etRuntime_getMessageServiceCount());
			msgService->name = (const char*) p;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
}

void etRuntime_unregisterMessageService(etMessageService* msgService) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "unregisterMessageService")

	{
		etMessageService* p = etRuntime_msgsvc_head;
		etMessageService* last = NULL;
		while (p!=NULL) {
			if (p==msgService) {
				if (last==NULL) {
					/* remove the first one */
					etRuntime_msgsvc_head = p->next;
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

	ET_MSC_LOGGER_SYNC_EXIT
}

void etRuntime_registerMemoryManagement(etMemory* mem) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "registerMemoryManagement")

	{
		mem->next = etRuntime_memmgmt_head;
		etRuntime_memmgmt_head = mem;
		if (mem->name==NULL) {
			void* p = malloc(16);
			sprintf(p, "MemMgmt_%d", etRuntime_getMemoryManagementCount());
			mem->name = (const char*) p;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
}

void etRuntime_unregisterMemoryManagement(etMemory* mem) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "unregisterMemoryManagement")

	{
		etMemory* p = etRuntime_memmgmt_head;
		etMemory* last = NULL;
		while (p!=NULL) {
			if (p==mem) {
				if (last==NULL) {
					/* remove the first one */
					etRuntime_memmgmt_head = p->next;
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

	ET_MSC_LOGGER_SYNC_EXIT
}

int etRuntime_getMemoryManagementCount() {
	int count = 0;
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMemoryManagementCount")

	{
		etMemory* p = etRuntime_memmgmt_head;
		while (p!=NULL) {
			++count;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return count;
}

int etRuntime_getMemoryManagementByName(const char* name) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMemoryManagementByName")

	{
		etMemory* p = etRuntime_memmgmt_head;
		int idx = 0;
		while (p!=NULL) {
			if (strcmp(p->name, name)==0) {
				ET_MSC_LOGGER_SYNC_EXIT
				return idx;
			}
			++idx;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return -1;
}

const etMemoryStatistics* etRuntime_getMemoryManagementStatistics(unsigned int i) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMemoryManagementStatistics")

	{
		etMemory* p = etRuntime_memmgmt_head;
		int count = 0;
		while (p!=NULL) {
			if (count==i) {
				ET_MSC_LOGGER_SYNC_EXIT
				return &p->statistics;
			}
			++count;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

const char* etRuntime_getMemoryManagementName(unsigned int i) {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "getMemoryManagementName")

	{
		etMemory* p = etRuntime_memmgmt_head;
		int count = 0;
		while (p!=NULL) {
			if (count==i) {
				ET_MSC_LOGGER_SYNC_EXIT
				return p->name;
			}
			++count;
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

void etRuntime_resetAllMemoryManagementStatistics() {
	etRuntime_initInternal();
	ET_MSC_LOGGER_SYNC_ENTRY("etRuntime", "resetAllMemoryManagementStatistics")

	{
		etMemory* p = etRuntime_memmgmt_head;
		while (p!=NULL) {
			etMemory_resetStatistics(p);
			p = p->next;
		}
	}

	ET_MSC_LOGGER_SYNC_EXIT
}
