/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "MSCLoggerTest.h"
#include "common/debugging/MSCLogger.h"
#include "etUnit/etUnit.h"
#include <stdio.h>
#include <string.h>

using namespace etRuntime;

void MSCLoggerTest::testLogger() {

	MSCLogger logger;
	logger.setMSC("MSCTest", "log/testlog/");
	logger.open();
	logger.addMessageAsyncOut("Source", "Target", "MessageAsync");
	logger.addMessageAsyncIn("Source", "Target", "MessageAsync");
	logger.addMessageSyncCall("Source", "Target", "MessageSyncCall");
	logger.addMessageSyncReturn("Source", "Target", "MessageSyncReturn");
	logger.addMessageActorCreate("Source", "Target");
	logger.addMessageActorDestroy("Source", "Target");
	logger.addNote("Actor", "Note");
	logger.addMessageCreate("Source", "Target");
	logger.addActorState("Actor", "State");
	logger.addVisibleComment("This is a comment");
	logger.close();

	const char* failMsg = "MSCLoggerTest failed";
	std::list<std::string>& result = logger.getCommandList();

	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource >-- Target MessageAsync"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource --> Target MessageAsync"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource ==> Target MessageSyncCall"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource <== Target MessageSyncReturn"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource (!) Target "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource (X) Target "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tActor note: Note"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tSource (!) Target "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("\tActor >>> State"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("# This is a comment"));
	result.pop_front();

}

void MSCLoggerTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testLogger)
}
