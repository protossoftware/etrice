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

#ifndef ETDATALOGGER_H_
#define ETDATALOGGER_H_

#include "etRuntimeConfig.h"

void etDataLogger_open(const char* logPath, const char* logName);
void etDataLogger_close(void);

void etDataLogger_logString(const char* text);
void etDataLogger_logBool(int val);
void etDataLogger_logInt(int val);
void etDataLogger_logDouble(double val);
void etDataLogger_newRow();

#ifdef ET_DATA_LOGGER_ACTIVATE
	#define ET_DATA_LOGGER_OPEN(name) \
			etDataLogger_open("tmp/log", name);
	#define ET_DATA_LOGGER_CLOSE \
			etDataLogger_close();
	#define ET_DATA_LOGGER_LOG_STRING(text) \
			etDataLogger_logString(text);
	#define ET_DATA_LOGGER_LOG_BOOL(val) \
			etDataLogger_logBool(val);
	#define ET_DATA_LOGGER_LOG_INT(val) \
			etDataLogger_logInt(val);
	#define ET_DATA_LOGGER_LOG_DOUBLE(val) \
			etDataLogger_logDouble(val);
	#define ET_DATA_LOGGER_NEW_ROW \
			etDataLogger_newRow();
#else
	#define ET_DATA_LOGGER_OPEN(name)
	#define ET_DATA_LOGGER_CLOSE
	#define ET_DATA_LOGGER_LOG_STRING(text)
	#define ET_DATA_LOGGER_LOG_BOOL(val)
	#define ET_DATA_LOGGER_LOG_INT(val)
	#define ET_DATA_LOGGER_LOG_DOUBLE(val)
	#define ET_DATA_LOGGER_NEW_ROW
#endif

#endif /* ETDATALOGGER_H_ */
