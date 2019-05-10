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

#include "debugging/etLogger.h"

#include <stdarg.h>


void etLogger_logError(const char* message){
	printf("ERROR:   %s\n", message);
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
	va_list arglist;

	printf("ERROR:   ");
	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
	fflush(stdout);
}

void etLogger_logWarningF(const char* format, ... ){
	va_list arglist;
	printf("WARNING: ");

	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
	fflush(stdout);
}

void etLogger_logInfoF(const char* format, ... ){
	va_list arglist;

	printf("INFO:    ");
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
	fflush(file);
}
