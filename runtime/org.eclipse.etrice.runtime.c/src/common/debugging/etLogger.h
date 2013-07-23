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

/*
 * etLogger.h
 *
 *  Created on: 16.01.2012
 *      Author: tschuetz
 */

#ifndef _ETLOGGER_H_
#define _ETLOGGER_H_

#include <stdio.h>
#include "etDatatypes.h"
/* logging */

void etLogger_logError(const char* message);

void etLogger_logWarning(const char* message);

void etLogger_logInfo(const char* message);

void etLogger_logErrorF(const char* format, ... );

void etLogger_logWarningF(const char* format, ... );

void etLogger_logInfoF(const char* format, ... );


/* File handling */

etFileHandle etLogger_fopen(const char* filename, const char* mode);

int etLogger_fclose(etFileHandle file);

void etLogger_fprintf(etFileHandle file, const char* format, ... );

#endif /* _ETLOGGER_H_ */
