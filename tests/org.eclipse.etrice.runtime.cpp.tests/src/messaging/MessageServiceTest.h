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

#ifndef SRC_MESSAGING_MESSAGESERVICETEST_H_
#define SRC_MESSAGING_MESSAGESERVICETEST_H_

#include "util/etTestSuite.h"
#include "common/messaging/RTObject.h"
#include "common/messaging/IMessageReceiver.h"
#include "common/messaging/MessageService.h"
#include "osal/etThread.h"
#include "osal/etSema.h"
#include "osal/etMutex.h"
#include "osal/etTimer.h"

class MessageServiceTest: public etTestSuite {
public:
	static const etInt32 testingTime = 1000;
	static const etInt32 timeoutTime = 5000;
	static const etInt32 interval_polled = 20;

	MessageServiceTest(void);

	~MessageServiceTest(void);

	void senderTerminated(void);

protected:
	void testBlocked(void);
	void testPolled(void);
	void runAllTestCases(void);

private:
	int m_senderTerminated;
	etSema m_sema;
	etMutex m_mutex;
	etTimer m_timer;

	void timeout(void);
	static void timeout(void* self) {
		(static_cast<MessageServiceTest*>(self))->timeout();
	}
};

class MessageCounter: public etRuntime::RTObject,
		public etRuntime::IMessageReceiver {
public:
	MessageCounter(IRTObject *parent, const etRuntime::String &name,
			const etRuntime::Address &address) :
			RTObject(parent, name), m_counter(0), m_address(address) {
	}

	void receive(const etRuntime::Message *msg) {
		m_counter++;
	}

	const etRuntime::Address& getAddress(void) const {
		return m_address;
	}

	etInt32 getMessageCount(void) {
		return m_counter;
	}

private:
	etInt32 m_counter;
	etRuntime::Address m_address;
};

class Sender {
public:
	Sender(MessageServiceTest &msgServiceTest,
			etRuntime::MessageService &msgService, etRuntime::Address &receiver,
			int priority = 0);
	~Sender(void);
	etInt32 getSentMessages(void) {
		return m_messagesSent;
	}
	void start(void);
	void terminate(void);
	void run(void);

private:
	MessageServiceTest &m_msgServiceTest;
	etRuntime::MessageService &m_msgService;
	etThread m_thread;
	etRuntime::Address m_addr;
	etInt32 m_messagesSent;bool m_running;

	static void run(void* self) {
		(static_cast<Sender*>(self))->run();
	}
};

#endif /* SRC_MESSAGING_MESSAGESERVICETEST_H_ */
