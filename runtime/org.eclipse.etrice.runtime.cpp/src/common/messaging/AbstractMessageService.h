/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/
#ifndef SRC_COMMON_MESSAGING_ABSTRACTMESSAGESERVICE_H_
#define SRC_COMMON_MESSAGING_ABSTRACTMESSAGESERVICE_H_

#include "common/messaging/Address.h"
#include "common/messaging/IMessageService.h"
#include "common/messaging/MessageDispatcher.h"
#include "common/messaging/MessageSeQueue.h"
#include <string>

namespace etRuntime {

class AbstractMessageService: public RTObject, public IMessageService {

public:
	virtual ~AbstractMessageService() {}

	virtual const Address& getAddress() const  { return m_address; }

	virtual Address getFreeAddress();

	virtual void freeAddress(const Address& addr);

	virtual void addMessageReceiver(IMessageReceiver& receiver);
	virtual void removeMessageReceiver(IMessageReceiver& receiver);

	virtual void addPollingMessageReceiver(IMessageReceiver& receiver);
	virtual void removePollingMessageReceiver(IMessageReceiver& receiver);
	virtual void receive(const Message* msg);

protected:
	AbstractMessageService(IRTObject* parent, const std::string& name, int node, int thread);

	MessageSeQueue& getMessageQueue() {
		return m_messageQueue;
	}
	MessageDispatcher& getMessageDispatcher() {
		return m_messageDispatcher;
	}

	std::string toString() const;

private:
	// TODO: add internal message queue for less locks (faster thread internal
	// messaging)
	Address m_address;
	MessageSeQueue m_messageQueue;
	MessageDispatcher m_messageDispatcher;

	AbstractMessageService();
	AbstractMessageService(AbstractMessageService const&);
	AbstractMessageService& operator=(AbstractMessageService const&);
};

}
#endif /* SRC_COMMON_MESSAGING_ABSTRACTMESSAGESERVICE_H_ */
