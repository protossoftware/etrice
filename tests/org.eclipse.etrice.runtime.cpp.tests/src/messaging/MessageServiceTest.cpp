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

#include "messaging/MessageServiceTest.h"
#include "etUnit/etUnit.h"
#include "common/messaging/MessageService.h"
#include "common/messaging/MessageServiceController.h"
#include "common/messaging/RTServices.h"

using namespace etRuntime;

MessageServiceTest::MessageServiceTest() :
		etTestSuite("org.eclipse.etrice.runtime.cpp.tests.MessageServiceTest"), m_senderTerminated(0) {

	RTServices::getInstance().getMsgSvcCtrl().resetAll();

	etSema_construct(&m_sema);
	etMutex_construct(&m_mutex);
	etTime interval;
	interval.sec = (etInt32) (timeoutTime / 1000);
	interval.nSec = (timeoutTime - interval.sec * 1000) * 1000000;
	etTimer_construct(&m_timer, &interval, MessageServiceTest::timeout,
			static_cast<void*>(this));
}

MessageServiceTest::~MessageServiceTest() {
	etMutex_destruct(&m_mutex);
	etSema_destruct(&m_sema);
	etTimer_destruct(&m_timer);
}

void MessageServiceTest::senderTerminated() {
	etMutex_enter(&m_mutex);
	m_senderTerminated++;
	if (m_senderTerminated >= 2)
		etSema_wakeup(&m_sema);
	etMutex_leave(&m_mutex);
}

void MessageServiceTest::timeout() {
	EXPECT_TRUE(m_caseId, "MessageService test failed (Timeout)", false);
	senderTerminated();
	senderTerminated();

	MessageServiceController &msgSvcCtrl =
			RTServices::getInstance().getMsgSvcCtrl();
	IMessageService* msgSvc = msgSvcCtrl.getMsgSvc(0);
	if (msgSvc) {
		msgSvc->terminate();
		msgSvcCtrl.setMsgSvcTerminated(*msgSvc);
	}
}

void MessageServiceTest::testBlocked() {

	Address addr(1, 2, 1);
	MessageServiceController& msgSvcCtrl =
			RTServices::getInstance().getMsgSvcCtrl();
	MessageService msgService(NULL, IMessageService::BLOCKED, 1, 2,
			"Test MessageService", new StaticMessageMemory(NULL, "TestMemory", sizeof(Message), 10000000));
	msgSvcCtrl.addMsgSvc(msgService);
	MessageCounter msgCounter(NULL, "MessageCounter", addr);
	msgService.addMessageReceiver(msgCounter);
	Sender sender1(*this, msgService, addr);
	Sender sender2(*this, msgService, addr);
	msgSvcCtrl.start();
	sender1.start();
	sender2.start();

	etThread_sleep(testingTime / 3);

	// Construct timeout and terminate senders
	etTimer_start(&m_timer);
	sender1.terminate();
	sender2.terminate();
	// Wait for sender-threads to terminate
	etSema_waitForWakeup(&m_sema);
	etTimer_stop(&m_timer);

	// Wait until all messages are delivered
	etThread_sleep(2 * testingTime / 3);

	// Construct timeout and stop MessageService
	etTimer_start(&m_timer);
	msgSvcCtrl.stop();
	msgSvcCtrl.removeMsgSvc(msgService);

	etTimer_stop(&m_timer);

	EXPECT_EQUAL_INT32(m_caseId, "Blocked MessageService test failed",
			sender1.getSentMessages() + sender2.getSentMessages(),
			msgCounter.getMessageCount());

}

void MessageServiceTest::testPolled() {

	etTime interval;
	interval.sec = (etInt32) (interval_polled / 1000);
	interval.nSec = (interval_polled - interval.sec * 1000) * 1000000;
	MessageServiceController& msgSvcCtrl =
			RTServices::getInstance().getMsgSvcCtrl();
	MessageService msgService(NULL, IMessageService::POLLED, interval, 1, 2,
			"Test MessageService", new StaticMessageMemory(NULL, "TestMemory", 64, 100));
	msgSvcCtrl.addMsgSvc(msgService);
	MessageCounter msgCounter(NULL, "Message Counter",
			msgService.getFreeAddress());
	msgService.addPollingMessageReceiver(msgCounter);
	msgSvcCtrl.start();

	etThread_sleep(testingTime);

	etTimer_start(&m_timer);
	msgSvcCtrl.stop();
	etTimer_stop(&m_timer);
	msgSvcCtrl.removeMsgSvc(msgService);
	msgService.removePollingMessageReceiver(msgCounter);
	etInt32 count = msgCounter.getMessageCount();
	etInt32 expectedCount = testingTime / interval_polled;
	EXPECT_TRUE(m_caseId, "Polled MessageService test failed",
			0.9 * expectedCount <= count && 1.1 * expectedCount >= count);
//	EXPECT_EQUAL_INT32(m_caseId, "Polled MessageService test failed", expectedCount, count);

}

void MessageServiceTest::runAllTestCases() {
	ADD_TESTCASE_CPP(testBlocked)
	ADD_TESTCASE_CPP(testPolled)
}

Sender::Sender(MessageServiceTest &msgServiceTest, MessageService &msgService,
		Address &receiver, int priority) :
		m_msgServiceTest(msgServiceTest), m_msgService(msgService), m_addr(
				receiver), m_messagesSent(0), m_running(false) {

	etThread_construct(&m_thread, static_cast<etStacksize>(1024), priority,
			(etThreadname) "Thread Sender1", Sender::run,
			static_cast<void*>(this));
}

Sender::~Sender() {
	etThread_destruct(&m_thread);
}

void Sender::start() {
	m_running = true;
	etThread_start(&m_thread);
}

void Sender::terminate() {
	m_running = false;
}

void Sender::run() {
	while (m_running) {
		Message* msg = m_msgService.getMessageBuffer(sizeof(Message));
		msg = new (msg) Message(m_addr, 0);
		m_msgService.receive(msg);
		m_messagesSent++;
	}

	m_msgServiceTest.senderTerminated();
}
