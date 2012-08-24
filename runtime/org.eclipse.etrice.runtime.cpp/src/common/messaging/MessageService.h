/*
 * MessageService.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#ifndef MESSAGESERVICE_H_
#define MESSAGESERVICE_H_

#include <string>
#include "common/messaging/MessageDispatcher.h"
#include "common/messaging/Address.h"
#include "MessageSeQueue.h"

namespace etRuntime {

//TODO: implementation missing yet for threads

class MessageService: public IMessageReceiver {
public:
	virtual ~MessageService();

	MessageService(IRTObject* parent, Address addr, std::string name, int priority = 0);

	Address getAddress() {	return m_address; }	;

	void run();

	//TODO: synchronized
	void receive(Message* msg);
	//TODO: synchronized
	MessageDispatcher& getMessageDispatcher() {	return m_messageDispatcher; }
	std::string getInstancePath();
	std::string getInstancePathName();

	//TODO: synchronized
	void terminate();

	// protected methods for sole use by test cases
protected:
	MessageSeQueue& getMessageQueue() {	return m_messageQueue;	}
	//TODO: synchronized
	long getLastMessageTimestamp() { return m_lastMessageTimestamp;	}

private:
	//TODO: synchronized
	void pollOneMessage();

	IRTObject* m_parent;
	std::string m_name;
	boolean m_running;

	// TODO: add internal message queue for less locks (faster thread internal
	// messaging)
	MessageSeQueue m_messageQueue;
	MessageDispatcher m_messageDispatcher;
	Address m_address;
	long m_lastMessageTimestamp;

	MessageService();
	MessageService(const MessageService& right);
	MessageService& operator=(const MessageService& right);

};

} /* namespace etRuntime */
#endif /* MESSAGESERVICE_H_ */
