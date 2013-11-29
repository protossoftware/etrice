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

#include "debugging/etDataLogger.h"
#include "debugging/etLogger.h"

static etFileHandle etDataLogger_fileHandle = NULL;
static int etDataLogger_row = 0;

/*TODO: move or replace ET_MAX_FILENAME_LEN */
#define ET_MAX_FILENAME_LEN 256

void etDataLogger_open(const char* logPath, const char* logName) {
	char path[ET_MAX_FILENAME_LEN];
	etDataLogger_row = 0;
	sprintf(path, "%s/%s.data.csv", logPath, logName);
	etDataLogger_fileHandle = etLogger_fopen(path, "w+");
}

void etDataLogger_close(void) {
	if (etDataLogger_fileHandle != NULL) {
		etLogger_fclose(etDataLogger_fileHandle);
	}
}

void etDataLogger_logString(const char* entry) {
	if (etDataLogger_fileHandle != NULL) {
		etLogger_fprintf(etDataLogger_fileHandle, ",%s", entry);
	}
}

void etDataLogger_logBool(int val) {
	if (etDataLogger_fileHandle != NULL) {
		etLogger_fprintf(etDataLogger_fileHandle, ",%d", val);
	}
}

void etDataLogger_logInt(int val) {
	if (etDataLogger_fileHandle != NULL) {
		etLogger_fprintf(etDataLogger_fileHandle, ",%d", val);
	}
}

void etDataLogger_logDouble(double val) {
	if (etDataLogger_fileHandle != NULL) {
		etLogger_fprintf(etDataLogger_fileHandle, ",%lf", val);
	}
}

void etDataLogger_newRow() {
	if (etDataLogger_fileHandle != NULL) {
		etLogger_fprintf(etDataLogger_fileHandle, "\n%d", etDataLogger_row++);
	}
}
