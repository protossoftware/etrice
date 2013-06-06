/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

/**
 *
 * etSema.c POSIX implementation of etSema
 *
 */

#include <errno.h>

#include "osal/etSema.h"
#include "etDatatypes.h"

#include "debugging/etMSCLogger.h"
#include "debugging/etLogger.h"


void etSema_construct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "construct")
	if (sem_init(&(self->osData), 0, 0) == -1) {
		/* handle error */
		etLogger_logError("etSema_construct: error\n");
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
void etSema_destruct(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "destruct")
	sem_destroy(&(self->osData));
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_wakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "wakeup")
		{
#ifdef DEBUG_SEMA
			int sval = 0;
			sem_getvalue(&(self->osData), &sval);
			printf("etSema_wakeup: %p before post val=%d\n", (void*)self, sval);
#endif
			sem_post(&(self->osData));
#ifdef DEBUG_SEMA
			sem_getvalue(&(self->osData), &sval);
			printf("etSema_wakeup: %p after post val=%d\n", (void*)self, sval);
			fflush(stdout);
#endif
		}
	ET_MSC_LOGGER_SYNC_EXIT
}

void etSema_waitForWakeup(etSema* self){
	ET_MSC_LOGGER_SYNC_ENTRY("etSema", "waitForWakeup")
	{
		int again = FALSE;

#ifdef DEBUG_SEMA
		printf("etSema_waitForWakeup: %p wait %ld\n", (void*)self, pthread_self()); fflush(stdout);
#endif
		do {
			errno = 0;
			again = FALSE;
			if (sem_wait(&(self->osData))==-1) {
				if (errno==EINTR) {
					again = TRUE;
#ifdef DEBUG_SEMA
					printf("etSema_waitForWakeup: %p interrupted - again %ld (val=%d)\n", (void*)self, pthread_self(), sval); fflush(stdout);
#endif
				}
			}
		}
		while (again);
#ifdef DEBUG_SEMA
		printf("etSema_waitForWakeup: %p waked up %ld\n", (void*)self, pthread_self()); fflush(stdout);
#endif
	}
	ET_MSC_LOGGER_SYNC_EXIT
}
