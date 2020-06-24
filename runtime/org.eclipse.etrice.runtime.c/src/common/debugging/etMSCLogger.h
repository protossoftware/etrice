/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
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

/**
 * \file etMSCLogger.h
 *
 * A collection of methods that can be used to write a message sequence chart (MSC,
 * also called sequence diagram in UML).
 * The format used is compatible with Astade Trace2UML, an open source MSC viewer.
 *
 * \author Thomas Schuetz
 */
#ifndef _ETMSCLOGGER_H_
#define _ETMSCLOGGER_H_

#include "etRuntimeConfig.h"
#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/**
 * opens a log file for the MSC. Only one at a time can be open.
 *
 * \param logPath the file path
 * \param mscName the file name
 */
void etMSCLogger_open(const char* logPath, const char* mscName);
/**
 * closes the MSC
 */
void etMSCLogger_close(void);

/**
 * sets an object name (for internal use)
 *
 * \param objectName the object name
 */
void etMSCLogger_setObjectName(const char* objectName);
/**
 * returns the object name previously set
 *
 * \return the object name
 */
const char* etMSCLogger_getObjectName(void);

/**
 * logs a synchronous call
 *
 * \param sourceName the calling instance
 * \param messageName the message
 * \param targetName the called instance
 */
void etMSCLogger_syncCall(const char* sourceName, const char* messageName, const char* targetName);
/**
 * logs a synchronous return
 *
 * \param sourceName the calling instance
 * \param targetName the called instance
 */
void etMSCLogger_syncReturn(const char* sourceName, const char* targetName);

/**
 * logs an outgoing asynchronous message
 *
 * \param sourceName the calling instance
 * \param messageName the message
 * \param targetName the called instance
 */
void etMSCLogger_asyncOut(const char* sourceName, const char* messageName, const char* targetName);
/**
 * logs an incoming asynchronous message
 *
 * \param sourceName the calling instance
 * \param messageName the message
 * \param targetName the called instance
 */
void etMSCLogger_asyncIn(const char* sourceName, const char* messageName, const char* targetName);

/**
 * logs a state change
 *
 * \param objectName the stateful instance
 * \param stateName the new state
 */
void etMSCLogger_setState(const char* objectName, const char* stateName);

/**
 * logs a comment
 *
 * \param comment
 */
void etMSCLogger_addVisibleComment(const char* comment);

#ifdef ET_MSC_LOGGER_ACTIVATE
	#define ET_MSC_LOGGER_OPEN(object) \
		etMSCLogger_open("log", "msc"); \
		etMSCLogger_setObjectName(object);

	#define ET_MSC_LOGGER_CLOSE etMSCLogger_close();

	#define ET_MSC_LOGGER_CHANGE_STATE(objectName, stateName) \
		etMSCLogger_setState(objectName, stateName);

	#define ET_MSC_LOGGER_VISIBLE_COMMENT(comment) \
		etMSCLogger_addVisibleComment(comment);

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

/**
 * calls \ref etMSCLogger_open(const char*, const char*) with <code>tmp/log</code> as path
 * and <code>msc</code> as file name for the log. Then it calls \ref etMSCLogger_setObjectName(const char*)
 * with object.
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE isn't defined this macro is void
 *
 * \param object the object name to be set
 */
#define ET_MSC_LOGGER_OPEN(object)

/**
 * calls \ref etMSCLogger_close()
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE isn't defined this macro is void
 */
#define ET_MSC_LOGGER_CLOSE

/**
 * this macro has to be used together with \ref ET_MSC_LOGGER_SYNC_EXIT to log
 * method entry and exit. It declares local variables and calls \ref etMSCLogger_syncCall
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE or \ref ET_SYNC_MSC_LOGGER_ACTIVATE
 * aren't defined this macro is void
 */
#define ET_MSC_LOGGER_SYNC_ENTRY(object, message)
/**
 * this macro has to be used together with \ref ET_MSC_LOGGER_SYNC_ENTRY to log
 * method entry and exit. It uses local variables defined before by \ref ET_MSC_LOGGER_SYNC_ENTRY and
 * calls \ref etMSCLogger_syncCall
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE or \ref ET_SYNC_MSC_LOGGER_ACTIVATE
 * aren't defined this macro is void
 */
#define ET_MSC_LOGGER_SYNC_EXIT

/**
 * calls \ref etMSCLogger_asyncOut(const char*, const char*, const char*)
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE or \ref ET_ASYNC_MSC_LOGGER_ACTIVATE
 * aren't defined this macro is void
 */
#define ET_MSC_LOGGER_ASYNC_OUT(sourceName, message, targetName)

/**
 * calls \ref etMSCLogger_asyncIn(const char*, const char*, const char*)
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE or \ref ET_ASYNC_MSC_LOGGER_ACTIVATE
 * aren't defined this macro is void
 */
#define ET_MSC_LOGGER_ASYNC_IN(sourceName, message, targetName)

/**
 * calls \ref etMSCLogger_setState(const char*, const char*)
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE isn't defined this macro is void
 */
#define ET_MSC_LOGGER_CHANGE_STATE(objectName, stateName)

/**
 * calls \ref etMSCLogger_addVisibleComment(const char*)
 * \par
 * If \ref ET_MSC_LOGGER_ACTIVATE isn't defined this macro is void
 */
#define ET_MSC_LOGGER_VISIBLE_COMMENT(comment)

#endif

ET_EXTERN_C_END

#endif /* _ETMSCLOGGER_H_ */
