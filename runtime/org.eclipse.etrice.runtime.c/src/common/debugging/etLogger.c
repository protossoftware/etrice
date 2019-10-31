/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "debugging/etLogger.h"
#include "osal/etTime.h"

#include <stdarg.h>
#include <string.h>

static char* prefixes[] = {
		"E: ",
		"W: ",
		"I: "
	};

static const char* TIMESTAMP_FORMAT = "#%011d.%09d# ";
static const int TIMESTAMP_LENGTH = 24;

static const int PREFIX_LEN = 3;
static const int N_PREFIXES = sizeof(prefixes)/sizeof(*prefixes);

#define DO_LOCK	\
	if (self->lock!=NULL) {								\
		self->lock->lockFct(self->lock->lockData);		\
	}

#define DO_UNLOCK	\
	if (self->lock!=NULL) {								\
		self->lock->unlockFct(self->lock->lockData);	\
	}

void etLogger_init(etLogger* logger, etBufferSender* sender) {
	logger->sender = sender;
	logger->lock = NULL;
	logger->nDropped = 0;
	logger->logLevel = LOG_ERROR;
	logger->usePrefix = ET_TRUE;
	logger->appendNewline = ET_FALSE;
	logger->useTimestamp = ET_FALSE;
}

void etLogger_setAppendNewline(etLogger* logger, etBool appendNewline) {
	logger->appendNewline = appendNewline;
}

void etLogger_setUsePrefix(etLogger* logger, etBool usePrefix) {
	logger->usePrefix = usePrefix;
}

void etLogger_setUseTimestamp(etLogger* logger, etBool useTimestamp) {
	logger->useTimestamp = useTimestamp;
}

void etLogger_log(etLogger* self, LogSeverity severity, const char* msg) {
	if (severity <= self->logLevel) {
		DO_LOCK
		{
			size_t msgLen = strlen(msg);
			size_t size = msgLen
						+ (self->appendNewline ? 1:0)
						+ (self->useTimestamp ? TIMESTAMP_LENGTH : 0)
						+ (self->usePrefix ? PREFIX_LEN:0) + 1;
			void* buffer = self->sender->getBuffer(self->sender, size);
			char* pos = (char*) buffer;

			if (buffer!=NULL) {

				if (severity<0) {
					severity = 0;
				}
				else if (severity>=N_PREFIXES) {
					severity = N_PREFIXES-1;
				}

				if (self->useTimestamp) {
					etTime time;
					getTimeFromTarget(&time);
					pos += sprintf(pos, TIMESTAMP_FORMAT, time.sec, time.nSec);
				}
				if (self->usePrefix) {
					strcpy(pos, prefixes[severity]);
					pos += PREFIX_LEN;
				}
				strcpy(pos, msg);
				if (self->appendNewline) {
					pos += msgLen;
					strcpy(pos, "\n");
				}

				self->sender->sendBuffer(self->sender, buffer, size);
			}
			else {
				++self->nDropped;
			}
		}
		DO_UNLOCK
	}
}

void etLogger_logF(etLogger* self, LogSeverity severity, const char* format, ... ) {
	if (severity <= self->logLevel) {
		DO_LOCK
		{
			va_list arglist;
			va_start(arglist, format);
			{
				int msgLen = vsnprintf(NULL, 0, format, arglist);
				size_t size = msgLen
						+ (self->appendNewline ? 1:0)
						+ (self->useTimestamp ? TIMESTAMP_LENGTH : 0)
						+ (self->usePrefix ? PREFIX_LEN:0) + 1;
				void* buffer = self->sender->getBuffer(self->sender, size);
				char* pos = (char*) buffer;

				if (severity<0) {
					severity = 0;
				}
				else if (severity>=N_PREFIXES) {
					severity = N_PREFIXES-1;
				}

				if (self->useTimestamp) {
					etTime time;
					getTimeFromTarget(&time);
					pos += sprintf(pos, TIMESTAMP_FORMAT, time.sec, time.nSec);
				}
				if (self->usePrefix) {
					strcpy(pos, prefixes[severity]);
					pos += PREFIX_LEN;
				}
				pos += vsnprintf(pos, size, format, arglist);
				if (self->appendNewline) {
					strcpy(pos, "\n");
				}

				self->sender->sendBuffer(self->sender, buffer, size);
			}
			va_end(arglist);
		}
		DO_UNLOCK
	}
}
