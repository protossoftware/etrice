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
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTServices.h"
#include "common/messaging/StaticMessageMemory.h"
#include "etUnit/etUnit.h"
#include <iostream>

using namespace etRuntime;

void DebuggingServiceTest::testLogging() {

	MessageServiceController& msgSvcCtrl = RTServices::getInstance().getMsgSvcCtrl();
	MessageService msgSvc(NULL, IMessageService::BLOCKED, 0, 0,
			"TestMessageService", new StaticMessageMemory(NULL, "TestMemory", 64, 100));
	msgSvcCtrl.addMsgSvc(msgSvc);
	msgSvcCtrl.start();
	SubSystemClass subSystem(NULL, "TestSubSystem");
	ActorClass actor1(&subSystem, "TestActor1");
	ActorClass actor2(&subSystem, "TestActor2");
	Port port1(&actor1, "TestPort1");
	Port port2(&actor2, "TestPort2");
	DebuggingService& dbgSvc = DebuggingService::getInstance();
	dbgSvc.getAsyncLogger().setMSC("DebuggingServiceTest", "log/");
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
	msgSvcCtrl.stop();
	msgSvcCtrl.removeMsgSvc(msgSvc);

	const char* failMsg = "DebuggingServiceTest failed";
	Vector<String>& result = dbgSvc.getAsyncLogger().getCommandList();

	typedef Vector<String> CmdList;
	for (CmdList::iterator it=result.begin(); it!=result.end(); ++it) {
		std::cout << (*it).c_str() << std::endl;
	}

	Vector<String>::iterator it = result.begin();

	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem (!) /TestSubSystem/TestActor1 "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem (!) /TestSubSystem/TestActor2 "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem/TestActor1 (!) /TestSubSystem/TestActor1/SubActor "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem/TestActor1 >-- /TestSubSystem/TestActor2 MessageAsync"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem/TestActor1 --> /TestSubSystem/TestActor2 MessageAsync"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem/TestActor1 ==> /TestSubSystem/TestActor2 MessageSyncCall"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem/TestActor1 <== /TestSubSystem/TestActor2 MessageSyncReturn"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem/TestActor1 >>> TestState"));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare(
					"\t/TestSubSystem (X) /TestSubSystem/TestActor1 "));
	++it;
	EXPECT_TRUE(m_caseId, failMsg,
			0==(*it).compare("# This is a comment"));
	++it;

}

void DebuggingServiceTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testLogging)
}
