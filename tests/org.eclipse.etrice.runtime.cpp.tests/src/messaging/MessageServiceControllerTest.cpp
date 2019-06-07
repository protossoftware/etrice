/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "messaging/MessageServiceControllerTest.h"
#include "etUnit/etUnit.h"
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/MessageService.h"
#include "common/messaging/RTServices.h"
#include "osal/etThread.h"

using namespace etRuntime;

MessageServiceControllerTest::MessageServiceControllerTest() :
		etTestSuite("org.eclipse.etrice.runtime.cpp.tests.MessageServiceControllerTest") {

	etTime interval;
	interval.sec = 5;
	interval.nSec = 0;
	etTimer_construct(&m_timer, &interval,
			MessageServiceControllerTest::timeout, static_cast<void*>(this));

	RTServices::getInstance().getMsgSvcCtrl().resetAll();
}

MessageServiceControllerTest::~MessageServiceControllerTest() {

	etTimer_destruct(&m_timer);
}

void MessageServiceControllerTest::testThreadIds() {

	const char* failMsg = "MessageServiceControllerTest testThreadIds failed";
	MessageServiceController& msgSvcController =
			RTServices::getInstance().getMsgSvcCtrl();

	EXPECT_EQUAL_INT32(m_caseId, failMsg, 0, msgSvcController.getNewID());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, msgSvcController.getNewID());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 2, msgSvcController.getNewID());
	msgSvcController.freeID(1);
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 1, msgSvcController.getNewID());
	EXPECT_EQUAL_INT32(m_caseId, failMsg, 3, msgSvcController.getNewID());
	msgSvcController.resetAll();

}

void MessageServiceControllerTest::testMsgSvcManagement() {
	// Construct timeout for the case that the MessageServiceController doesn't terminate
	etTimer_start(&m_timer);

	const char* failMsg =
			"MessageServiceControllerTest testMsgSvcManagement failed";
	MessageServiceController& msgSvcController =
			RTServices::getInstance().getMsgSvcCtrl();
	MessageService msgSvc1(NULL, IMessageService::BLOCKED, 1,
			msgSvcController.getNewID(), "MessageService1", new StaticMessageMemory(NULL, "TestMemory", 64, 100));
	MessageService msgSvc2(NULL, IMessageService::POLLED, 1,
			msgSvcController.getNewID(), "MessageService2", new StaticMessageMemory(NULL, "TestMemory", 64, 100));

	msgSvcController.addMsgSvc(msgSvc1);
	msgSvcController.addMsgSvc(msgSvc2);
	msgSvcController.start();
	EXPECT_EQUAL_PTR(m_caseId, failMsg,
			dynamic_cast<IMessageService*>(&msgSvc1),
			msgSvcController.getMsgSvc(0));
	EXPECT_EQUAL_PTR(m_caseId, failMsg,
			dynamic_cast<IMessageService*>(&msgSvc2),
			msgSvcController.getMsgSvc(1));
	msgSvcController.resetAll();

	msgSvcController.addMsgSvc(msgSvc1);
	msgSvcController.addMsgSvc(msgSvc2);
	msgSvcController.start();
	EXPECT_EQUAL_PTR(m_caseId, failMsg,
			dynamic_cast<IMessageService*>(&msgSvc1),
			msgSvcController.getMsgSvc(0));
	EXPECT_EQUAL_PTR(m_caseId, failMsg,
			dynamic_cast<IMessageService*>(&msgSvc2),
			msgSvcController.getMsgSvc(1));
	msgSvcController.stop();
	msgSvcController.removeMsgSvc(msgSvc1);
	msgSvcController.removeMsgSvc(msgSvc2);

	etTimer_stop(&m_timer);
}

void MessageServiceControllerTest::timeout() {
	EXPECT_TRUE(m_caseId,
			"MessageServiceControllerTest testMsgSvcManagement failed (timeout)",
			false);
	MessageServiceController& msgSvcController =
			RTServices::getInstance().getMsgSvcCtrl();
	IMessageService *msgSvc1 = msgSvcController.getMsgSvc(0);
	IMessageService *msgSvc2 = msgSvcController.getMsgSvc(1);
	if (msgSvc1) {
		msgSvc1->terminate();
		msgSvcController.setMsgSvcTerminated(*msgSvc1);
	}
	if (msgSvc2) {
		msgSvc2->terminate();
		msgSvcController.setMsgSvcTerminated(*msgSvc2);
	}
}

void MessageServiceControllerTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testThreadIds)
	ADD_TESTCASE_CPP(testMsgSvcManagement)
}
