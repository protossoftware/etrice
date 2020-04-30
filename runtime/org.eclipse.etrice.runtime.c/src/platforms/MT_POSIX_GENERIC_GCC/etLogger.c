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

#include <stdarg.h>

/*
 * Error log messages are redirected to stdout to preserve the chronological order of the logs.
 * Furthermore writing to stderr from threads other than the main thread sometimes causes segfaults.
 * This seems to be related to the fact that stderr ist usually unbuffered whereas stdout is buffered.
 * However, I could not comprehend the problem.
 */

void etLogger_logError(const char* message){
	fprintf(stdout, "ERROR:   %s\n", message);
	fflush(stdout);
}

void etLogger_logWarning(const char* message){
	printf("WARNING: %s\n", message);
	fflush(stdout);
}

void etLogger_logInfo(const char* message){
	printf("INFO:    %s\n", message);
	fflush(stdout);
}

void etLogger_logErrorF(const char* format, ... ){
	fprintf(stdout, "ERROR:   ");
	va_list arglist;
	va_start( arglist, format );
	vfprintf(stdout, format, arglist );
	va_end( arglist );
	fprintf(stdout, "\n");
	fflush(stdout);
}

void etLogger_logWarningF(const char* format, ... ){
	printf("WARNING: ");
	va_list arglist;
	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
	fflush(stdout);
}

void etLogger_logInfoF(const char* format, ... ){
	printf("INFO:    ");
	va_list arglist;
	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
	fflush(stdout);
}

etFileHandle etLogger_fopen(const char* filename, const char* mode){
	return( fopen(filename, mode) );
}

int etLogger_fclose(etFileHandle file){
	return( fclose(file) );
}

void etLogger_fprintf(etFileHandle file, const char* format, ... ){
	va_list arglist;
	va_start( arglist, format );
	vfprintf(file, format, arglist );
	va_end( arglist );
	fflush(stdout);
}
