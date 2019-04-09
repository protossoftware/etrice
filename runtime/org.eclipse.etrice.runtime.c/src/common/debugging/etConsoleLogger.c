/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include <stdio.h>
#include "debugging/etConsoleLogger.h"

#define BUFFER_SIZE		1024
static char buffer[BUFFER_SIZE];

etLogger theConsoleLogger;
static etBufferSender theConsoleSender;

/*
 * console sender with fixed buffer (may need synchronization)
 */

static void* etConsoleSender_getBuffer(etBufferSender* self, size_t size) {
	if (size<BUFFER_SIZE) {
		return buffer;
	}
	else {
		return NULL;
	}
}

void etConsoleSender_sendBuffer(etBufferSender* self, void* buffer, size_t size) {
	fprintf(stdout, buffer);
	fflush(stdout);
}


void etConsoleLogger_init() {
	static etBool initialized = ET_FALSE;
	if (!initialized) {
		initialized = ET_TRUE;

		theConsoleSender.getBuffer = etConsoleSender_getBuffer;
		theConsoleSender.sendBuffer = etConsoleSender_sendBuffer;

		etLogger_init(&theConsoleLogger, &theConsoleSender);

		etLogger_setAppendNewline(&theConsoleLogger, ET_TRUE);
		etLogger_setUsePrefix(&theConsoleLogger, ET_TRUE);
	}
}
