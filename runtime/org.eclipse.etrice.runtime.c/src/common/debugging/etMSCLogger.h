/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef _ETMSCLOGGER_H_
#define _ETMSCLOGGER_H_

#include "etRuntimeConfig.h"

void etMSCLogger_open(char* logPath, char* mscName);
void etMSCLogger_close(void);

void etMSCLogger_setObjectName(char* objectName);
char* etMSCLogger_getObjectName(void);

void etMSCLogger_syncCall(char* sourceName, char* messageName, char* targetName);
void etMSCLogger_syncReturn(char* sourceName, char* targetName);

void etMSCLogger_asyncOut(char* sourceName, char* messageName, char* targetName);
void etMSCLogger_asyncIn(char* sourceName, char* messageName, char* targetName);

#ifdef ET_MSC_LOGGER_ACTIVATE
	#define ET_MSC_LOGGER_OPEN(object) \
		etMSCLogger_open("tmp", "msc"); \
		etMSCLogger_setObjectName(object);

	#define ET_MSC_LOGGER_CLOSE etMSCLogger_close();

	#define ET_MSC_LOGGER_SYNC_ENTRY(object, message) 			\
		char* sourceName = etMSCLogger_getObjectName(); 	\
		char* targetName = object;							\
		etMSCLogger_syncCall(sourceName, message, targetName); 	\
		etMSCLogger_setObjectName(targetName);

	#define ET_MSC_LOGGER_SYNC_EXIT \
		etMSCLogger_syncReturn(sourceName, targetName); \
		etMSCLogger_setObjectName(sourceName);

#else
	#define ET_MSC_LOGGER_OPEN
	#define ET_MSC_LOGGER_CLOSE

	#define ET_MSC_LOGGER_SYNC_ENTRY(object, message)
	#define ET_MSC_LOGGER_SYNC_EXIT
#endif


#endif /* _ETMSCLOGGER_H_ */
