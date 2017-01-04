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
	Vector<String>& result = logger.getCommandList();
	Vector<String>::iterator it = result.begin();

	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource >-- Target MessageAsync"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource --> Target MessageAsync"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource ==> Target MessageSyncCall"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource <== Target MessageSyncReturn"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource (!) Target "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource (X) Target "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tActor note: Note"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tSource (!) Target "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("\tActor >>> State"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			!(*it).compare("# This is a comment"));
	++it;

}

void MSCLoggerTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testLogger)
}
