/*
 * MessageService.cpp
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#include "MessageService.h"

namespace etRuntime {

MessageService::MessageService(IRTObject* parent, Address addr, std::string name, int priority)
	:	// super("MessageService "+name),
		IMessageReceiver(),
		IRTObject(),
		m_parent(parent),
		m_name(name),
		m_running(false),
		m_messageQueue(this, "Queue"),
		m_messageDispatcher( this,
				Address(addr.m_nodeID, addr.m_threadID,	addr.m_objectID + 1),
				"Dispatcher"),
		m_address(addr),
		m_lastMessageTimestamp(0) {

	// check and set priority
//			assert priority >= Thread.MIN_PRIORITY : ("priority smaller than Thread.MIN_PRIORITY (1)");
//			assert priority <= Thread.MAX_PRIORITY : ("priority bigger than Thread.MAX_PRIORITY (10)");
//			this.setPriority(priority);

}

MessageService::~MessageService() {
	m_parent = 0;
}

void MessageService::run() {
	m_running = true;
	while (m_running) {
		pollOneMessage();
	}
}

//TODO: synchronized
void MessageService::receive(Message* msg) {
	if (msg != 0) {
		m_messageQueue.push(msg);
		//TODO
		//notifyAll(); // wake up thread to compute message
	}
}

std::string MessageService::getInstancePath() const {
	std::string path = PATH_DELIM + m_name;

	if (m_parent != 0)
		path = m_parent->getInstancePath() + path;

	return path;
}

std::string MessageService::getInstancePathName() const {
	std::string path = PATHNAME_DELIM + m_name;

	if (m_parent != 0)
		path = m_parent->getInstancePathName() + path;

	return path;
}

// TODO: synchronized
void MessageService::terminate() {
	if (m_running) {
		m_running = false;
		//TODO:
		// notifyAll();
	}
}
//TODO: synchronized
void MessageService::pollOneMessage() {
	Message* msg = m_messageQueue.pop(); // get next Message from Queue
	if (msg == 0) {
		//TODO:
		// no message in queue -> wait till Thread is notified
//		try {
//			wait();
//		} catch (InterruptedException e) {
//		}
	} else {
		//TODO: set timestamp
		// m_lastMessageTimestamp = System.currentTimeMillis();
		m_messageDispatcher.receive(msg);
	}

}


} /* namespace etRuntime */
