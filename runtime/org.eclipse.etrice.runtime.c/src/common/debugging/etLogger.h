/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

#endif /* _ETLOGGER_H_ */
