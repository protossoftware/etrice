/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

/**
 *
 * etThread.c POSIX implementation of etThread
 *
 */

#include "osal/etThread.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

#include <time.h>
#include <sys/unistd.h>
#include <errno.h>

typedef void *(*threadFunc)(void *);
void* etThread_execute(etThread* self);

void etThread_construct(
		etThread* self,
		etStacksize stacksize,
		etPriority priority,
		etThreadname threadName,
		etThreadFunction threadFunction,
		void* threadFunctionData)
{
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "construct")

	/* fill in data */
	self->stacksize = stacksize;
	self->priority = priority;
	self->threadName = threadName;
	self->threadFunction = threadFunction;
	self->threadFunctionData = threadFunctionData;
	self->started = ET_FALSE;

	ET_MSC_LOGGER_SYNC_EXIT
}

void etThread_start(etThread* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "start")
	{
		struct sched_param param;
		pthread_attr_t attr;

		const int policy = SCHED_RR;
		int minPriority = sched_get_priority_min(policy);
		int maxPriority = sched_get_priority_max(policy);

		if (self->priority<minPriority)
			self->priority = minPriority;
		if (self->priority>maxPriority)
			self->priority = maxPriority;

		param.sched_priority = self->priority;
		pthread_attr_init(&attr);
		pthread_attr_setschedparam(&attr, &param);
		pthread_attr_setschedpolicy(&attr, policy);
		pthread_attr_setstacksize(&attr, self->stacksize);

		pthread_create(&(self->osData), &attr, (threadFunc) etThread_execute, self);
		pthread_attr_destroy(&attr);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void* etThread_execute(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "execute")
	self->started = ET_TRUE;
	/* set cancel state, thread must not change to PTHREAD_CANCEL_DISABLE */
	pthread_setcancelstate(PTHREAD_CANCEL_DEFERRED, NULL);
	/* etThread_execute redirects the call from the thread to the execute function in the eTrice runtime to enable correct synchronous MSC logging */
	self->threadFunction(self->threadFunctionData);
	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

void etThread_destruct(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "destruct")
	if (self->started) {
		self->started = ET_FALSE;
		/* Note: thread must not be in state PTHREAD_CANCEL_DISABLE */
		pthread_cancel(self->osData);
		pthread_join(self->osData, NULL);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etThread_sleep(etInt32 millis){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "sleep")
	{
		struct timespec time;
		time.tv_sec = millis / 1000;
		time.tv_nsec = (millis - time.tv_sec * 1000) * 1000*1000;
		while(nanosleep(&time, &time) != 0) {
			if(errno != EINTR)
				break;
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

etOSThreadData etThread_self(void){
	return pthread_self();
}

etOSThreadId etThread_self_id(void){
	return pthread_self();
}

