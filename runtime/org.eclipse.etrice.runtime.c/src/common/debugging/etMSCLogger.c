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

#include "debugging/etMSCLogger.h"
#include "debugging/etLogger.h"

#include "osal/etThread.h"

static etFileHandle etMSCLogger_fileHandle = NULL;
static const char* etMSCLogger_objectName = "";

/*TODO: move or replace ET_MAX_FILENAME_LEN */
#define ET_MAX_FILENAME_LEN 256

void etMSCLogger_open(const char* logPath, const char* mscName){
	char path[ET_MAX_FILENAME_LEN];
	sprintf(path, "%s/%s.seq", logPath, mscName);
	etMSCLogger_fileHandle = etLogger_fopen(path, "w+");
}

void etMSCLogger_close(void){
	if (etMSCLogger_fileHandle != NULL){
		etLogger_fclose(etMSCLogger_fileHandle);
	}

}

void etMSCLogger_setObjectName(const char* objectName){
	etMSCLogger_objectName = objectName;
}

const char* etMSCLogger_getObjectName(void){
	return etMSCLogger_objectName;
}

void etMSCLogger_syncCall(const char* sourceName, const char* messageName, const char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s ==> %s %s(thread=%ld)\n", sourceName, targetName, messageName, etThread_self_id());
	}
}

void etMSCLogger_syncReturn(const char* sourceName, const char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s <== %s\n", sourceName, targetName);
	}
}

void etMSCLogger_asyncOut(const char* sourceName, const char* messageName, const char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s >-- %s %s\n", sourceName, targetName, messageName);
		fflush(etMSCLogger_fileHandle);
	}
}

void etMSCLogger_asyncIn(const char* sourceName, const char* messageName, const char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s --> %s %s\n", sourceName, targetName, messageName);
		fflush(etMSCLogger_fileHandle);
	}
}

void etMSCLogger_setState(const char* objectName, const char* stateName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s >>> %s\n", objectName, stateName);
		fflush(etMSCLogger_fileHandle);
	}
}

void etMSCLogger_addVisibleComment(const char* comment){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "# %s\n", comment);
		fflush(etMSCLogger_fileHandle);
	}
}
