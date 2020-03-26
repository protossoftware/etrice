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
#include <limits.h>

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

/* TODO: improve this using a logger */
static void etThread_handleError(int err, const char* msg) {
	errno = err;
	perror(msg);
}

void etThread_start(etThread* self) {
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "start")
	{
		struct sched_param param;
		pthread_attr_t attr;
		int ret;

		/* set policy round robin */
		const int policy = SCHED_RR;

		/* adjust priority if out of range */
		int minPriority = sched_get_priority_min(policy);
		int maxPriority = sched_get_priority_max(policy);
		if (self->priority<minPriority)
			self->priority = minPriority;
		if (self->priority>maxPriority)
			self->priority = maxPriority;

		/* adjust stacksize if too small */
		if (self->stacksize < PTHREAD_STACK_MIN)
			self->stacksize = PTHREAD_STACK_MIN;

		/* initialize attributes */
		ret = pthread_attr_init(&attr);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_init");
		}

		/* initialize parameters */
		ret = pthread_attr_getschedparam(&attr, &param);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_getschedparam");
		}
		param.sched_priority = self->priority;

		ret = pthread_attr_setinheritsched(&attr, PTHREAD_EXPLICIT_SCHED);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_setinheritsched");
		}
		ret = pthread_attr_setschedpolicy(&attr, policy);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_setschedpolicy");
		}
		ret = pthread_attr_setschedparam(&attr, &param);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_setschedparam");
		}
		ret = pthread_attr_setstacksize(&attr, self->stacksize);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_setstacksize");
		}

		/* try to create the thread with these settings (note: setting scheduling requires higher privileges) */
		ret = pthread_create(&(self->osData), &attr, (threadFunc) etThread_execute, self);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_create");
			if (ret==EPERM) {
				printf("pthread_create failed with insufficient permissions, falling back to inherited scheduling\n");
				ret = pthread_attr_setinheritsched(&attr, PTHREAD_INHERIT_SCHED);
				if (ret!=0) {
					etThread_handleError(ret, "pthread_attr_setinheritsched");
				}
				ret = pthread_create(&(self->osData), &attr, (threadFunc) etThread_execute, self);
				if (ret!=0) {
					etThread_handleError(ret, "pthread_create");
				}
			}
		}
		ret = pthread_attr_destroy(&attr);
		if (ret!=0) {
			etThread_handleError(ret, "pthread_attr_destroy");
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void* etThread_execute(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "execute")
	int ret;
	self->started = ET_TRUE;

	/* set cancel state, thread must not change to PTHREAD_CANCEL_DISABLE */
	ret = pthread_setcancelstate(PTHREAD_CANCEL_DEFERRED, NULL);
	if (ret!=0) {
		etThread_handleError(ret, "pthread_setcancelstate");
	}

	/* etThread_execute redirects the call from the thread to the execute function in the eTrice runtime to enable correct synchronous MSC logging */
	self->threadFunction(self->threadFunctionData);
	ET_MSC_LOGGER_SYNC_EXIT
	return NULL;
}

void etThread_destruct(etThread* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etThread", "destruct")
	/* Note: thread must not be in state PTHREAD_CANCEL_DISABLE */
	if (self->started) {
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

