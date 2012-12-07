/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "debugging/etMSCLogger.h"

#include "debugging/etLogger.h"

static etFileHandle etMSCLogger_fileHandle = NULL;
static char* etMSCLogger_objectName = "";

#define ET_MAX_FILENAME_LEN 256

void etMSCLogger_open(char* logPath, char* mscName){
	char path[ET_MAX_FILENAME_LEN];
	sprintf(path, "%s/%s.seq", logPath, mscName);
	etMSCLogger_fileHandle = etLogger_fopen(path, "w+");
}

void etMSCLogger_close(void){
	if (etMSCLogger_fileHandle != NULL){
		etLogger_fclose(etMSCLogger_fileHandle);
	}

}

void etMSCLogger_setObjectName(char* objectName){
	etMSCLogger_objectName = objectName;
}

char* etMSCLogger_getObjectName(void){
	return etMSCLogger_objectName;
}

void etMSCLogger_syncCall(char* sourceName, char* messageName, char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s ==> %s %s\n", sourceName, targetName, messageName);
	}
}

void etMSCLogger_syncReturn(char* sourceName, char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s <== %s\n", sourceName, targetName);
	}
}

void etMSCLogger_asyncOut(char* sourceName, char* messageName, char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s >-- %s %s\n", sourceName, targetName, messageName);
	}
}

void etMSCLogger_asyncIn(char* sourceName, char* messageName, char* targetName){
	if (etMSCLogger_fileHandle != NULL) {
		etLogger_fprintf(etMSCLogger_fileHandle, "%s --> %s %s\n", sourceName, targetName, messageName);
	}
}
