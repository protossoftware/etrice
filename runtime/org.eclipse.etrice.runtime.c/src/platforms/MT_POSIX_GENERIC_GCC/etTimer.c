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

/**
 *
 * etTimer.c POSIX implementation of etTimer
 *
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

#define TIMER_SIGNAL				SIGRTMIN

/* head of linked list of etTimer structs */
static etTimer* timers = NULL;

/* control initialization */
static etBool timer_initialized = FALSE;

/* thread calling the timer functions */
#define TIMER_THREAD_STACK_SIZE		1024
#define TIMER_THREAD_PRIO			5

static etThread timer_thread;

/* semaphore used for signalling */
static etSema timer_sema;

/* mutex to guard linked list access */
static etMutex timer_mutex;

static void timerThreadFunction(void* data) {
	while (TRUE) {
		etTimer* it;

		printf("timerThreadFunction: waiting\n"); fflush(stdout); // remove debug output
		etSema_waitForWakeup(&timer_sema);

		printf("timerThreadFunction: checking\n"); fflush(stdout); // remove debug output

		etMutex_enter(&timer_mutex);
		for (it=timers; it!=NULL; it=(etTimer*) it->osTimerData.next) {
			if (it->osTimerData.signaled) {
				it->osTimerData.signaled = FALSE;
				it->timerFunction(it->timerFunctionData);
				printf("timerThreadFunction: signaled\n"); fflush(stdout); // remove debug output
			}
		}
		etMutex_leave(&timer_mutex);
	}
}

static void timerHandler(int sig, siginfo_t *si, void *uc) {
	timer_t* tid = si->si_value.sival_ptr;
	etTimer* it;

	printf("timerHandler\n"); fflush(stdout); // TODO: remove debug output

	etMutex_enter(&timer_mutex);
	for (it=timers; it!=NULL; it=(etTimer*) it->osTimerData.next) {
		if (&it->osTimerData.timerid==tid) {
			it->osTimerData.signaled = TRUE;
			etSema_wakeup(&timer_sema);
			break;
		}
	}
	etMutex_leave(&timer_mutex);
}

void etTimer_construct(etTimer* self, etTime* timerInterval, etTimerFunction timerFunction, void* timerFunctionData){
	ET_MSC_LOGGER_SYNC_ENTRY("etTimer", "construct")
	{
		self->timerInterval.sec = timerInterval->sec;
		self->timerInterval.nSec = timerInterval->nSec;
		self->timerFunction = timerFunction;
		self->timerFunctionData = timerFunctionData;
		self->osTimerData.signaled = FALSE;

		if (!timer_initialized) {
			struct sigaction sa;

			timer_initialized = TRUE;

			/* initialize our mutex and semaphore */
			etMutex_construct(&timer_mutex);
			etSema_construct(&timer_sema);

			/* we start the timer thread */
			etThread_construct(
					&timer_thread,
					TIMER_THREAD_STACK_SIZE,
					TIMER_THREAD_PRIO,
					"timer_thread",
					timerThreadFunction,
					NULL);
			etThread_start(&timer_thread);

			/* we set up a signal handler */
			sa.sa_flags = SA_SIGINFO;
			sa.sa_sigaction = timerHandler;
			sigemptyset(&sa.sa_mask);
			if (sigaction(TIMER_SIGNAL, &sa, NULL) != 0) {
				fprintf(stderr, "etTimer_construct: failed setting action handler\n");
				fflush(stderr);
				return;
			}
		}

		/* place at list head */
		etMutex_enter(&timer_mutex);
		self->osTimerData.next = timers;
		timers = self;
		etMutex_leave(&timer_mutex);

		{
			struct sigevent te;

			/* create timer */
			te.sigev_notify = SIGEV_SIGNAL;
			te.sigev_signo = TIMER_SIGNAL;
			te.sigev_value.sival_ptr = &self->osTimerData.timerid;
			if (timer_create(CLOCK_REALTIME, &te, &self->osTimerData.timerid) != 0) {
				fprintf(stderr, "etTimer_construct: failed creating a timer\n");
				fflush(stderr);
				return;
			}
		}
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
					fprintf(stderr, "etTimer_start: failed starting a timer with errno EFAULT\n");
					break;
				case EINVAL:
					fprintf(stderr, "etTimer_start: failed starting a timer with errno EINVAL\n");
					break;
				default:
					fprintf(stderr, "etTimer_start: failed starting a timer with errno %d\n", errno);
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
			fprintf(stderr, "etTimer_stop: failed stopping a timer with errno %d\n", errno);
			fflush(stderr);
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
			fprintf(stderr, "etTimer_delete: failed deleting a timer\n");
			fflush(stderr);
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
