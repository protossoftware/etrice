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

#include "debugging/DebuggingServiceTest.h"
#include "common/debugging/DebuggingService.h"
#include "common/messaging/MessageService.h"
#include "common/messaging/RTServices.h"
#include "etUnit/etUnit.h"

using namespace etRuntime;

void DebuggingServiceTest::testLogging() {

	MessageService msgSvc(NULL, IMessageService::BLOCKED, 0, 0,
			"TestMessageService");
	RTServices::getInstance().getMsgSvcCtrl().addMsgSvc(msgSvc);
	SubSystemClass subSystem(NULL, "TestSubSystem");
	ActorClass actor1(&subSystem, "TestActor1");
	ActorClass actor2(&subSystem, "TestActor2");
	Port port1(&actor1, "TestPort1");
	Port port2(&actor2, "TestPort2");
	DebuggingService& dbgSvc = DebuggingService::getInstance();
	dbgSvc.getAsyncLogger().setMSC("DebuggingServiceTest", "log/testlog/");
	dbgSvc.getAsyncLogger().open();

	InterfaceItemBase::connect(&subSystem, port1.getInstancePath(),
			port2.getInstancePath());
	dbgSvc.addPortInstance(port1);
	dbgSvc.addPortInstance(port2);

	dbgSvc.addMessageActorCreate(subSystem, "TestActor1");
	dbgSvc.addMessageActorCreate(subSystem, "TestActor2");
	dbgSvc.addMessageActorCreate(actor1, "SubActor");
	dbgSvc.addMessageAsyncOut(port1.getAddress(), port2.getAddress(),
			"MessageAsync");
	dbgSvc.addMessageAsyncIn(port1.getAddress(), port2.getAddress(),
			"MessageAsync");
	dbgSvc.addMessageSyncCall(port1.getAddress(), port2.getAddress(),
			"MessageSyncCall");
	dbgSvc.addMessageSyncReturn(port1.getAddress(), port2.getAddress(),
			"MessageSyncReturn");
	dbgSvc.addActorState(actor1, "TestState");
	dbgSvc.addMessageActorDestroy(actor1);
	dbgSvc.addVisibleComment("This is a comment");

	dbgSvc.removePortInstance(port1);
	dbgSvc.removePortInstance(port2);

	dbgSvc.getAsyncLogger().close();

	const char* failMsg = "DebuggingServiceTest failed";
	std::list<std::string>& result = dbgSvc.getAsyncLogger().getCommandList();

	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem (!) /TestSubSystem/TestActor1 "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem (!) /TestSubSystem/TestActor2 "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem/TestActor1 (!) /TestSubSystem/TestActor1/SubActor "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem/TestActor1 >-- /TestSubSystem/TestActor2 MessageAsync"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem/TestActor1 --> /TestSubSystem/TestActor2 MessageAsync"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem/TestActor1 ==> /TestSubSystem/TestActor2 MessageSyncCall"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem/TestActor1 <== /TestSubSystem/TestActor2 MessageSyncReturn"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem/TestActor1 >>> TestState"));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare(
					"\t/TestSubSystem (X) /TestSubSystem/TestActor1 "));
	result.pop_front();
	EXPECT_TRUE(m_caseId, failMsg,
			!result.front().compare("# This is a comment"));
	result.pop_front();

}

void DebuggingServiceTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testLogging)
}
