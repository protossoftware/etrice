/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#ifndef MESSAGESERVICE_H_
#define MESSAGESERVICE_H_

#include <string>
#include <vector>
#include <pthread.h>
#include "common/messaging/MessageDispatcher.h"
#include "common/messaging/Address.h"
#include "common/modelbase/IEventReceiver.h"
#include "MessageSeQueue.h"

namespace etRuntime {

//TODO: abstraction from posix threads missing

class MessageService: public IMessageReceiver, public RTObject {
public:
	MessageService(IRTObject* parent, Address addr, std::string name, int priority = 0);
	virtual ~MessageService();

	Address getAddress() const {	return m_address; }	;

	void start(bool singlethreaded);
	void run();
	// for single threaded configuration only
	void runOnce();

	void join();
	void terminate();
	void receive(Message* msg);

	virtual MessageDispatcher& getMessageDispatcher() {	return m_messageDispatcher; }
	virtual bool isMsgService() const { return true;};

	void addAsyncActor(IEventReceiver& evtReceiver);
	void pollAsyncActors();


	// protected methods for sole use by test cases
protected:
	MessageSeQueue& getMessageQueue() {	return m_messageQueue;	}
	long getLastMessageTimestamp() const { return m_lastMessageTimestamp;	}

private:
	//TODO: synchronized
	void pollOneMessage();

	bool m_running;
	pthread_t m_thread;
	pthread_mutex_t m_mutex;
	pthread_mutexattr_t m_mutexAttr;
	pthread_cond_t m_conditionVar;
	pthread_attr_t m_threadAttr;

	// TODO: add internal message queue for less locks (faster thread internal
	// messaging)
	MessageSeQueue m_messageQueue;
	MessageDispatcher m_messageDispatcher;
	Address m_address;
	long m_lastMessageTimestamp;

	std::vector<IEventReceiver*> m_asyncActors;

	MessageService();
	MessageService(const MessageService& right);
	MessageService& operator=(const MessageService& right);

};

} /* namespace etRuntime */
#endif /* MESSAGESERVICE_H_ */
