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

void etMSCLogger_open(const char* logPath, const char* mscName);
void etMSCLogger_close(void);

void etMSCLogger_setObjectName(const char* objectName);
const char* etMSCLogger_getObjectName(void);

void etMSCLogger_syncCall(const char* sourceName, const char* messageName, const char* targetName);
void etMSCLogger_syncReturn(const char* sourceName, const char* targetName);

void etMSCLogger_asyncOut(const char* sourceName, const char* messageName, const char* targetName);
void etMSCLogger_asyncIn(const char* sourceName, const char* messageName, const char* targetName);

void etMSCLogger_setState(const char* objectName, const char* stateName);

#ifdef ET_MSC_LOGGER_ACTIVATE
	#define ET_MSC_LOGGER_OPEN(object) \
		etMSCLogger_open("tmp/log", "msc"); \
		etMSCLogger_setObjectName(object);

	#define ET_MSC_LOGGER_CLOSE etMSCLogger_close();

	#define ET_MSC_LOGGER_CHANGE_STATE(objectName, stateName) \
		etMSCLogger_setState(objectName, stateName);

	#ifdef ET_SYNC_MSC_LOGGER_ACTIVATE
		#define ET_MSC_LOGGER_SYNC_ENTRY(object, message) 			\
			const char* sourceName = etMSCLogger_getObjectName(); 	\
			const char* targetName = object;							\
			etMSCLogger_syncCall(sourceName, message, targetName); 	\
			etMSCLogger_setObjectName(targetName);
		#define ET_MSC_LOGGER_SYNC_EXIT \
			etMSCLogger_syncReturn(sourceName, targetName); \
			etMSCLogger_setObjectName(sourceName);
	#else
		#define ET_MSC_LOGGER_SYNC_ENTRY(object, message)
		#define ET_MSC_LOGGER_SYNC_EXIT
	#endif


	#ifdef ET_ASYNC_MSC_LOGGER_ACTIVATE
		#define ET_MSC_LOGGER_ASYNC_OUT(sourceName, message, targetName) 			\
			etMSCLogger_asyncOut(sourceName, message, targetName);

		#define ET_MSC_LOGGER_ASYNC_IN(sourceName, message, targetName) 			\
			etMSCLogger_asyncIn(sourceName, message, targetName);
	#else
		#define ET_MSC_LOGGER_ASYNC_OUT(sourceName, message, targetName)
		#define ET_MSC_LOGGER_ASYNC_IN(sourceName, message, targetName)
	#endif


#else
	#define ET_MSC_LOGGER_OPEN
	#define ET_MSC_LOGGER_CLOSE

	#define ET_MSC_LOGGER_SYNC_ENTRY(object, message)
	#define ET_MSC_LOGGER_SYNC_EXIT

	#define ET_MSC_LOGGER_ASYNC_OUT(sourceName, message, targetName)
	#define ET_MSC_LOGGER_ASYNC_IN(sourceName, message, targetName)

	#define ET_MSC_LOGGER_CHANGE_STATE(objectName, stateName)
#endif


#endif /* _ETMSCLOGGER_H_ */
