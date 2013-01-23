/*
 * MessageService.cpp
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#include "MessageService.h"
#include <iostream>
#include <unistd.h>

namespace etRuntime {

extern "C" {
	void* threadStarter(void* arg) {
		MessageService* thisPtr = static_cast<MessageService*>(arg);
		std::cout << "Thread " << thisPtr->getName() << " is started." << std::endl;
		thisPtr->run();
		return arg;
		//		pthread_exit(NULL);
	}
}

MessageService::MessageService(IRTObject* parent, Address addr, std::string name, int priority)
	:	// super("MessageService "+name),
		IMessageReceiver(),
		IRTObject(),
		m_parent(parent),
		m_name(name),
		m_running(false),
		m_thread(),
		m_mutex(),
		m_mutexAttr(),
		m_conditionVar(),
		m_threadAttr(),
		m_messageQueue(this, "Queue"),
		m_messageDispatcher( this,
				Address(addr.m_nodeID, addr.m_threadID,	addr.m_objectID + 1),
				"Dispatcher"),
		m_address(addr),
		m_lastMessageTimestamp(0),
        m_asyncActors()
{
	pthread_mutexattr_init(&m_mutexAttr);
	pthread_mutexattr_settype(&m_mutexAttr, PTHREAD_MUTEX_RECURSIVE);
	pthread_mutex_init(&m_mutex, &m_mutexAttr);
    pthread_cond_init (&m_conditionVar, NULL);
    pthread_attr_init(&m_threadAttr);
    pthread_attr_setdetachstate(&m_threadAttr, PTHREAD_CREATE_JOINABLE);

	// check and set priority
//			assert priority >= Thread.MIN_PRIORITY : ("priority smaller than Thread.MIN_PRIORITY (1)");
//			assert priority <= Thread.MAX_PRIORITY : ("priority bigger than Thread.MAX_PRIORITY (10)");
//			this.setPriority(priority);

}

MessageService::~MessageService() {
	m_parent = 0;
	pthread_attr_destroy(&m_threadAttr);
	pthread_mutex_destroy(&m_mutex);
	pthread_cond_destroy(&m_conditionVar);
	pthread_exit(NULL);

}

void MessageService::start(bool singlethreaded) {
	if (singlethreaded) {
		std::cout << "starting message service " << m_name << " singlethreaded" << std::endl;
	}
	else {
		std::cout << "starting message service " << m_name << " on own thread" << std::endl;
		int rc = pthread_create(&m_thread, &m_threadAttr, threadStarter, static_cast<void *>(this));
		if (rc){
			 std::cout << "ERROR; return code from pthread_create() is " << rc << std::endl;
			 exit(-1);
		}
	}
}

void MessageService::join() {
	void *status;
	int rc = pthread_join(m_thread, &status);
    if (rc){
         std::cout << "ERROR; return code from pthread_join() is " << rc << std::endl;
         exit(-1);
    }
}
void MessageService::run() {
	m_running = true;
	while (m_running) {
		pollOneMessage();
		usleep(10000);
	}
	std::cout << "ending message service " << m_name << " on own thread" << std::endl;
}

void MessageService::runOnce() {
	pollAsyncActors();
	while (m_messageQueue.isNotEmpty()){
		Message* msg = m_messageQueue.pop(); // get next Message from Queue
		if (msg != 0) {
			m_messageDispatcher.receive(msg);
		}
	}
}

void MessageService::receive(Message* msg) {
	pthread_mutex_lock(&m_mutex);
	if (msg != 0) {
		m_messageQueue.push(msg);
		pthread_cond_signal(&m_conditionVar); // wake up thread to compute message
	}
	pthread_mutex_unlock(&m_mutex);
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
	pthread_mutex_lock(&m_mutex);
	if (m_running) {
		m_running = false;
		pthread_cond_signal(&m_conditionVar); // wake up thread to terminate
	}
	pthread_mutex_unlock(&m_mutex);
}

void MessageService::pollOneMessage() {
	pthread_mutex_lock(&m_mutex);
	Message* msg = m_messageQueue.pop(); // get next Message from Queue
	if (msg == 0) {
		// no message in queue -> wait till Thread is notified
		pthread_cond_wait(&m_conditionVar, &m_mutex);
	} else {
		//TODO: set timestamp
		// m_lastMessageTimestamp = System.currentTimeMillis();
		m_messageDispatcher.receive(msg);
	}
	pthread_mutex_unlock(&m_mutex);

}

void MessageService::addAsyncActor(IEventReceiver& evtReceiver) {
	m_asyncActors.push_back(&evtReceiver);
}

void MessageService::pollAsyncActors() {
	std::vector<IEventReceiver*>::iterator it = m_asyncActors.begin();
	for ( ; it != m_asyncActors.end(); ++it) {
		// polling event
		(*it)->receiveEvent(0,0,0);
	}
}

} /* namespace etRuntime */
