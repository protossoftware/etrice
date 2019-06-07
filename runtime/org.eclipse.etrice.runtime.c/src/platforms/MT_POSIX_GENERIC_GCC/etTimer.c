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
 * etTimer.c POSIX implementation of etTimer
 *
 * We use standard POSIX timers and signal handlers for the implementation.
 *
 * The idea is that all timer data (of type etTimer) are added to a linked list.
 * When a timer goes off the handler is called which sets the 'signaled' flag of the corresponding list element
 * (all list access is guarded by a global mutex) and signals a global semaphore.
 *
 * The global timer thread (which together with the other global synchronization objects is started once and
 * for all when the first timer is constructed) is waiting on this semaphore. When it is released it iterates
 * the linked list and checks for signaled timers. For signaled timers it resets the signaled flag and
 * calls the user function and retires again.
 */

#include <signal.h>
#include <string.h>
#include <errno.h>

#include "osal/etTimer.h"
#include "osal/etThread.h"
#include "osal/etSema.h"
#include "osal/etMutex.h"
#include "helpers/etTimeHelpers.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"

/* the signal used for the timer */
#define TIMER_SIGNAL				SIGRTMIN

/* head of linked list of etTimer structs */
static etTimer* timers = NULL;

/* control initialization */
static etBool timer_initialized = ET_FALSE;

/* thread calling the timer functions */
#define TIMER_THREAD_STACK_SIZE		1024
#define TIMER_THREAD_PRIO			5

static etThread timer_thread;

/* semaphore used for signaling */
static etSema timer_sema;

/* mutex to guard linked list access */
static etMutex timer_mutex;

static void timerThreadFunction(void* data) {
	while (ET_TRUE) {
		etTimer* it;
		int idx;
		int signaled = ET_FALSE;

#ifdef DEBUG_TIMER
		printf("timerThreadFunction: waiting\n"); fflush(stdout);
#endif
		etSema_waitForWakeup(&timer_sema);

#ifdef DEBUG_TIMER
		printf("timerThreadFunction: checking\n"); fflush(stdout);
#endif

		etMutex_enter(&timer_mutex);
		for (it=timers, idx=0; it!=NULL; it=(etTimer*) it->osTimerData.next, ++idx) {
			if (it->osTimerData.signaled) {
#ifdef DEBUG_TIMER
				printf("timerThreadFunction: signaled %d, calling user fct %p\n", idx, (void*)it->timerFunction); fflush(stdout);
#endif
				it->osTimerData.signaled = ET_FALSE;
				it->timerFunction(it->timerFunctionData);
				signaled = ET_TRUE;
			}
		}
		etMutex_leave(&timer_mutex);

		if (!signaled) {
			etLogger_logError("timerThreadFunction: signaled timer NOT found\n");
		}
	}
}

static void timerHandler(int sig, siginfo_t *si, void *uc) {
	etTimer* timer = si->si_value.sival_ptr;
	int sval = 0;

	etMutex_enter(&timer_mutex);
	timer->osTimerData.signaled = ET_TRUE;
	etMutex_leave(&timer_mutex);

	sem_getvalue(&(timer_sema.osData), &sval);
	if (sval==0)
		etSema_wakeup(&timer_sema);
}

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "construct")
	{
		memset(self, 0, sizeof(etTimer));

		self->timerInterval.sec = timerInterval->sec;
		self->timerInterval.nSec = timerInterval->nSec;
		self->timerFunction = timerFunction;
		self->timerFunctionData = timerFunctionData;
		self->osTimerData.signaled = ET_FALSE;

		if (!timer_initialized) {
			/*
			 * All this is done once and for all.
			 * The resources are never released again.
			 */
			struct sigaction sa;

			timer_initialized = ET_TRUE;

			/* initialize our mutex and semaphore */
			etMutex_construct(&timer_mutex);
			etSema_construct(&timer_sema);

			/* we set up a signal handler */
			sigemptyset(&sa.sa_mask);
			sa.sa_flags = SA_SIGINFO;
			sa.sa_sigaction = timerHandler;
			if (sigaction(TIMER_SIGNAL, &sa, NULL) != 0) {
				etLogger_logError("etTimer_construct: failed setting action handler\n");
				return;
			}

			/* we start the timer thread */
			etThread_construct(
					&timer_thread,
					TIMER_THREAD_STACK_SIZE,
					TIMER_THREAD_PRIO,
					"timer_thread",
					timerThreadFunction,
					NULL);
			etThread_start(&timer_thread);

#ifdef DEBUG_TIMER
			printf("etTimer_construct: installed signal handler and started thread\n"); fflush(stdout);
#endif
		}

		/* create the timer (in disarmed state) */
		{
			/* create timer */
			self->osTimerData.te.sigev_notify = SIGEV_SIGNAL;
			self->osTimerData.te.sigev_signo = TIMER_SIGNAL;
			self->osTimerData.te.sigev_value.sival_ptr = self;
			if (timer_create(CLOCK_REALTIME, &self->osTimerData.te, &self->osTimerData.timerid) != 0) {
				fprintf(stderr, "etTimer_construct: failed creating a timer\n");
				fflush(stderr);
				return;
			}
#ifdef DEBUG_TIMER
			printf("etTimer_construct: user callback is %p\n", (void*)self->timerFunction); fflush(stdout);
#endif
		}

		/* place at list head */
		etMutex_enter(&timer_mutex);
		self->osTimerData.next = timers;
		timers = self;
		etMutex_leave(&timer_mutex);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_start(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "start")
	{
		if (timers == NULL){
			etLogger_logError("etTimer_start: no timer initialized (NULL)");
		}
		else {
			struct itimerspec its;

			its.it_interval.tv_sec = self->timerInterval.sec;
			its.it_interval.tv_nsec = self->timerInterval.nSec;
			its.it_value.tv_sec = self->timerInterval.sec;
			its.it_value.tv_nsec = self->timerInterval.nSec;
			if (timer_settime(self->osTimerData.timerid, 0, &its, NULL) != 0) {
				switch (errno) {
				case EFAULT:
					etLogger_logError("etTimer_start: failed starting a timer with errno EFAULT");
					break;
				case EINVAL:
					etLogger_logError("etTimer_start: failed starting a timer with errno EINVAL");
					break;
				default:
					etLogger_logErrorF("etTimer_start: failed starting a timer with errno %d", errno);
					break;
				}
				fflush(stderr);
			}
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_stop(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "stop")
	{
		struct itimerspec its;

		/* disarm the timer */
		memset(&its, 0, sizeof(its));
		if (timer_settime(self->osTimerData.timerid, 0, &its, NULL) != 0) {
			etLogger_logErrorF("etTimer_stop: failed stopping a timer with errno %d\n", errno);
		}
	}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etTimer_destruct(etTimer* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "destruct")
	{
		etTimer* it;
		etTimer* pred = NULL;

		/* delete timer */
		if (timer_delete(self->osTimerData.timerid) != 0) {
			etLogger_logError("etTimer_delete: failed deleting a timer\n");
		}

		/* remove from queue */
		etMutex_enter(&timer_mutex);
		for (it=timers; it!=NULL; pred=it, it=(etTimer*) it->osTimerData.next) {
			if (it==self) {

				/* remove from list */
				if (pred==NULL) {
					timers = (etTimer*) it->osTimerData.next;

					if (timers==NULL) {
						/* TODO: last element removed, stop thread etc.? */
					}
				}
				else {
					pred->osTimerData.next = (etTimer*) it->osTimerData.next;
				}
			}
		}
		etMutex_leave(&timer_mutex);
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
