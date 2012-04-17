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
 * RunRuntimeTestcases.c
 *
 *  Created on: 12.01.2012
 *      Author: tschuetz
 */



#include "RunCRuntimeTestcases.h"

#include "TestEtMessage.h"
#include "TestEtMessageQueue.h"
#include "TestEtMessageService.h"
#include "TestEtUnit.h"

#include "etUnit/etUnit.h"


void RunCRuntimeTestcases(void){
	etInt16 id;
	etUnit_open("tmp/testlog","TestCRuntime");

	TestEtMessage_runSuite();
	TestEtMessageQueue_runSuite();
	TestEtMessageService_runSuite();
	TestEtUnit_runSuite();

	etUnit_close();

	/* special situation for testing openAll and closeAll of etUnit
	 * this has to be done outside of etUnit_open and etUnit_close */
	id = etUnit_openAll("tmp/testlog","TestEtUnitSpecial", "etUnit", "openAll and closeAll");
	EXPECT_TRUE(id, "Open and Close", TRUE);
	etUnit_closeAll(id);
}

