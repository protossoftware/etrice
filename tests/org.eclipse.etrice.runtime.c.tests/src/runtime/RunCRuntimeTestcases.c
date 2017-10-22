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
#include "TestEtMemory.h"
#include "TestEtQueue.h"
#include "TestEtTimer.h"
#include "TestEtDatatypes.h"
#include "helpers/TestEtTimeHelpers.h"
#include "util/TestUtil.h"

#include "container/TestEtStaticDeque.h"

#include "etUnit/etUnit.h"
#include "debugging/etMSCLogger.h"


void RunCRuntimeTestcases(void){
	etInt16 id;
	etMSCLogger_open("log", "test.log");
	etUnit_open("log","TestCRuntime");
	
	TestEtQueue_runSuite();
	TestEtMemory_runSuite();
	TestEtMessage_runSuite();
	TestEtMessageQueue_runSuite();
	TestEtMessageService_runSuite();
	TestEtUnit_runSuite();
	TestEtTimer_runSuite();
	TestEtDatatypes_runSuite();
	TestEtTimeHelpers_runSuite();
	TestUtil_runSuite();

	TestEtStaticDeque_runSuite();

	etUnit_close();

	/* special situation for testing openAll and closeAll of etUnit
	 * this has to be done outside of etUnit_open and etUnit_close */
	id = etUnit_openAll("log","TestEtUnitSpecial", "org.eclipse.etrice.runtime.c.tests.etUnit", "openAll_and_closeAll");
	EXPECT_TRUE(id, "Open and Close", ET_TRUE);
	etUnit_closeAll(id);

	etMSCLogger_close();
}

