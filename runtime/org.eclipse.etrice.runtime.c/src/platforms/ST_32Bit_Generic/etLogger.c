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
 * etLogger.c
 *
 *  Created on: 16.01.2012
 *      Author: tschuetz
 */


#include "debugging/etLogger.h"

#include <stdarg.h>
#include "etRuntimeConfig.h"

void etLogger_logError(const char* message){
#ifdef ET_LOGGER_ACTIVATE
	printf("ERROR:   %s\n", message);
#endif
}

void etLogger_logWarning(const char* message){
#ifdef ET_LOGGER_ACTIVATE
	printf("WARNING: %s\n", message);
#endif
}

void etLogger_logInfo(const char* message){
#ifdef ET_LOGGER_ACTIVATE
	printf("INFO:    %s\n", message);
#endif
}

void etLogger_logErrorF(const char* format, ... ){
#ifdef ET_LOGGER_ACTIVATE
	printf("ERROR:   ");
	va_list arglist;
	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
#endif
}

void etLogger_logWarningF(const char* format, ... ){
#ifdef ET_LOGGER_ACTIVATE
	printf("WARNING: ");
	va_list arglist;
	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
#endif
}

void etLogger_logInfoF(const char* format, ... ){
#ifdef ET_LOGGER_ACTIVATE
	printf("INFO:    ");
	va_list arglist;
	va_start( arglist, format );
	vprintf( format, arglist );
	va_end( arglist );
	printf("\n");
#endif
}

etFileHandle etLogger_fopen(const char* filename, const char* mode){
#ifdef ET_LOGGER_ACTIVATE
	return( fopen(filename, mode) );
#else
	return (0);
#endif
}

int etLogger_fclose(etFileHandle file){
#ifdef ET_LOGGER_ACTIVATE
	return( fclose(file) );
#else
	return(0);
#endif
}

void etLogger_fprintf(etFileHandle file, const char* format, ... ){
#ifdef ET_LOGGER_ACTIVATE
	va_list arglist;
	va_start( arglist, format );
	vfprintf(file, format, arglist );
	va_end( arglist );
#endif
}
