/*******************************************************************************
 * Copyright (c) 2019 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/


/*
 * TestEtConsoleLogger.c
 */

#include "TestEtConsoleLogger.h"
#include "debugging/etConsoleLogger.h"
#include "etUnit/etUnit.h"

static void TestEtUnit_useConsoleLogging(etInt16 id) {
	etConsoleLogger_init();

	/* will be dropped because of log level ERROR by default */
	etLogger_log(&theConsoleLogger, LOG_WARNING, "first message for testing (WARNING)");

	theConsoleLogger.logLevel = LOG_WARNING;
	etLogger_log(&theConsoleLogger, LOG_WARNING, "first message for testing (WARNING)");
	etLogger_logF(&theConsoleLogger, LOG_ERROR, "%d. message for testing (ERROR)", 2);
}

static void TestEtUnit_useConsoleLoggingWithTimestamp(etInt16 id) {
	etConsoleLogger_init();

	etLogger_setUseTimestamp(&theConsoleLogger, ET_TRUE);

	etLogger_logF(&theConsoleLogger, LOG_ERROR, "%d. message for testing (ERROR with timestamp)", 3);
}

void TestEtConsoleLogger_runSuite(void){
	etUnit_openTestSuite("org.eclipse.etrice.runtime.c.tests.TestEtConsoleLogger");
	ADD_TESTCASE(TestEtUnit_useConsoleLogging);
	ADD_TESTCASE(TestEtUnit_useConsoleLoggingWithTimestamp);
	etUnit_closeTestSuite();
}


