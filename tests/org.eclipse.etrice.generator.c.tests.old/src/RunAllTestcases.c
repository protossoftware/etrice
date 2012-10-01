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

#include <stdio.h>

#include "test/generator/RunCGeneratorTestcases.h"
#include "test/runtime/RunCRuntimeTestcases.h"
#include "debugging/etMSCLogger.h"

void runTestCases(void);

int main(void){
	ET_MSC_LOGGER_OPEN("RunAllTestcases")
	runTestCases();
	ET_MSC_LOGGER_CLOSE
	return 0;
}


void runTestCases(void){
	ET_MSC_LOGGER_SYNC_ENTRY("RunAllTestcases", "runTestCases")
	RunCGeneratorTestcases();
	RunCRuntimeTestcases();
	ET_MSC_LOGGER_SYNC_EXIT
}

