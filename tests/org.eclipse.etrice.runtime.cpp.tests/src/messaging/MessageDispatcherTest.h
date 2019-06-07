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

#ifndef SRC_MESSAGING_MESSAGEDISPATCHERTEST_H_
#define SRC_MESSAGING_MESSAGEDISPATCHERTEST_H_

#include "util/etTestSuite.h"
#include "common/messaging/RTObject.h"
#include "common/messaging/IMessageReceiver.h"

class MessageDispatcherTest: public etTestSuite {
public:
	MessageDispatcherTest(void) :
			etTestSuite("org.eclipse.etrice.runtime.cpp.tests.MessageDispatcherTest") {
	}

protected:
	void testConstructors(void);
	void testFreeAddresses(void);
	void testDispatching(void);

	void runAllTestCases(void);
};

class SimpleMessageReceiver: public etRuntime::RTObject,
		public etRuntime::IMessageReceiver {
public:
	SimpleMessageReceiver(IRTObject *parent, const etRuntime::String& name,
			const etRuntime::Address& address) :
				RTObject(parent, name), m_address(address), m_lastMessage(NULL) {
	}

	void receive(const etRuntime::Message* msg) {
		m_lastMessage = msg;
	}
	const etRuntime::Address& getAddress(void) const {
		return m_address;
	}

	const etRuntime::Message* getLastReceivedMessagePtr(void) const {
		return m_lastMessage;
	}

private:
	etRuntime::Address m_address;
	const etRuntime::Message *m_lastMessage;
};

#endif /* SRC_MESSAGING_MESSAGEDISPATCHERTEST_H_ */
