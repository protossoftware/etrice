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

/**
 * \file etLogger.h
 *
 * a simple logging facility writing to file
 *
 * \author: tschuetz
 */

#ifndef _ETLOGGER_H_
#define _ETLOGGER_H_

#include <stdio.h>
#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/**
 * open a log file
 *
 * \param filename the file name
 * \param mode the read/write mode (see standard C fopen)
 *
 * \return a file handle (OS specific)
 */
etFileHandle etLogger_fopen(const char* filename, const char* mode);

/**
 * close a log file
 *
 * \param file the file handle
 *
 * \return <code>0</code> if ok
 */
int etLogger_fclose(etFileHandle file);

/**
 * log an error
 *
 * \param message the message to write
 */
void etLogger_logError(const char* message);

/**
 * log a warning
 *
 * \param message the message to write
 */
void etLogger_logWarning(const char* message);

/**
 * log an information
 *
 * \param message the message to write
 */
void etLogger_logInfo(const char* message);

/**
 * log an error
 *
 * \param format the format to be used (see standard C printf)
 */
void etLogger_logErrorF(const char* format, ... );

/**
 * log a warning
 *
 * \param format the format to be used (see standard C printf)
 */
void etLogger_logWarningF(const char* format, ... );

/**
 * log an information
 *
 * \param format the format to be used (see standard C printf)
 */
void etLogger_logInfoF(const char* format, ... );

/**
 * log a string in free format
 *
 * \param format the format to be used (see standard C printf)
 */
void etLogger_fprintf(etFileHandle file, const char* format, ... );

/***************************************************************************************************/
/*
 * new interface
 */
/***************************************************************************************************/

#include <debugging/etBufferSender.h>
#include "osal/etLock.h"

typedef enum LogSeverity {
	LOG_ERROR,
	LOG_WARNING,
	LOG_INFO
}
LogSeverity;

typedef struct etLogger {
	etBufferSender* sender;	/**< the configured sender */
	etLock* lock;			/**< an optional lock for synchronization */
	uint16 nDropped;		/**< number of unsent messages */
	LogSeverity logLevel;	/**< filter away messages with larger level, default is LOG_ERROR */
	etBool appendNewline;	/**< append a new line character to each message, default is false */
	etBool usePrefix;		/**< prefix each message with the severity, default is true */
	etBool useTimestamp;	/**< prefix each message with a timestamp, default is false */
}
etLogger;

/**
 * initializes the logger object with default values
 *
 * \param logger the logger object
 * \param the sender to be used
 */
void etLogger_init(etLogger* logger, etBufferSender* sender);

/**
 * sets the value of the appendNewline flag
 *
 * \param logger the logger object
 * \param appendNewline the flag
 */
void etLogger_setAppendNewline(etLogger* logger, etBool appendNewline);

/**
 * sets the value of the usePrefix flag
 *
 * \param logger the logger object
 * \param usePrefix the flag
 */
void etLogger_setUsePrefix(etLogger* logger, etBool usePrefix);

/**
 * sets the value of the useTimestamp flag
 *
 * \param logger the logger object
 * \param useTimestamp the flag
 */
void etLogger_setUseTimestamp(etLogger* logger, etBool useTimestamp);

/**
 * supply optional user lock/unlock functions for usage in a multi-threaded environment.
 *
 * \param mem pointer to the memory management struct
 * \lock pointer to a user supplied locking struct
 */
void etLogger_setUserLock(etLogger* logger, etLock* lock);

/**
 * logs a message with a given severity level
 *
 * \param self the logger
 * \param severity the severity level
 * \param msg the message string
 */
void etLogger_log(etLogger* self, LogSeverity severity, const char* msg);

/**
 * logs a formatted message (like the printf family) with a given severity level
 *
 * \param self the logger
 * \param severity the severity level
 * \param format the format string
 * \param ... parameters for the fields
 */
void etLogger_logF(etLogger* self, LogSeverity severity, const char* format, ... );

ET_EXTERN_C_END

#endif /* _ETLOGGER_H_ */
