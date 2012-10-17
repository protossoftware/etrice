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

class MessageService: public IMessageReceiver, public IRTObject {
public:
	MessageService(IRTObject* parent, Address addr, std::string name, int priority = 0);
	virtual ~MessageService();

	Address getAddress() const {	return m_address; }	;

	void run();
	//TODO: for single threaded configuration only
	void runOnce();

	//TODO: synchronized
	void terminate();
	//TODO: synchronized
	void receive(Message* msg);
	//TODO: synchronized
	virtual MessageDispatcher& getMessageDispatcher() {	return m_messageDispatcher; }
	virtual std::string getInstancePath() const ;
	virtual std::string getInstancePathName() const ;
	virtual bool isMsgService() const { return true;};

	// protected methods for sole use by test cases
protected:
	MessageSeQueue& getMessageQueue() {	return m_messageQueue;	}
	//TODO: synchronized
	long getLastMessageTimestamp() const { return m_lastMessageTimestamp;	}

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
