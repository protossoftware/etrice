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
 * \file etDataLogger.h
 *
 * The data logger is a means that lets data driven send ports write their data to file
 * in every cycle. Only one log file can be open at a time. The data are written
 * in comma separated value (csv) format.
 *
 * \author Henrik Rentz-Reichert
 */

#ifndef ETDATALOGGER_H_
#define ETDATALOGGER_H_

#include "etRuntimeConfig.h"

/**
 * opens a file for data logging
 *
 * \param logPath the path to the file
 * \param logName the name of the log file
 */
void etDataLogger_open(const char* logPath, const char* logName);
/**
 * closes a previously opened data log file
 */
void etDataLogger_close(void);

/**
 * writes a string to the log
 *
 * \param text the string to be written
 */
void etDataLogger_logString(const char* text);
/**
 * writes a boolean value to the log (as integer)
 *
 * \param val the value to be written
 */
void etDataLogger_logBool(int val);
/**
 * writes an integer value to the log
 * \param val the value to be written
 */
void etDataLogger_logInt(int val);
/**
 * writes a double value to the log
 * \param val the value to be written
 */
void etDataLogger_logDouble(double val);
/**
 * starts a new row of the log
 */
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
	/**
	 * calls \ref etDataLogger_open(const char*, const char*) with path <code>tmp/log</code>
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 */
	#define ET_DATA_LOGGER_OPEN(name)
	/**
	 * calls \ref etDataLogger_close()
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 */
	#define ET_DATA_LOGGER_CLOSE
	/**
	 * calls etDataLogger_logString(const char*)
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 *
	 * \param text the text to be written
	 */
	#define ET_DATA_LOGGER_LOG_STRING(text)
	/**
	 * calls \ref etDataLogger_logBool(int val)
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 *
	 * \param val the value to be written
	 */
	#define ET_DATA_LOGGER_LOG_BOOL(val)
	/**
	 * calls \ref etDataLogger_logInt(int val)
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 *
	 * \param val the value to be written
	 */
	#define ET_DATA_LOGGER_LOG_INT(val)
	/**
	 * calls \ref etDataLogger_logDouble(double val)
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 *
	 * \param val the value to be written
	 */
	#define ET_DATA_LOGGER_LOG_DOUBLE(val)
	/**
	 * calls \ref etDataLogger_newRow()
	 * or <code>void</code> if <code>ET_DATA_LOGGER_ACTIVATE</code> is not defined
	 */
	#define ET_DATA_LOGGER_NEW_ROW
#endif

#endif /* ETDATALOGGER_H_ */
