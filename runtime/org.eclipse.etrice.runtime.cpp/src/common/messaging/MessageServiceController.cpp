/*******************************************************************************
 * Copyright (c) 2012 Draeger Medical GmbH (http://www.draeger.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Peter Karlitschek (initial contribution)
 *
 *******************************************************************************/

#include "MessageServiceController.h"
#include "common/containers/String.h"

namespace etRuntime {

typedef Vector<IMessageService*>::iterator iterator;
static iterator find(iterator begin, iterator end, const IMessageService* value) {
	iterator current = begin;
	for (; current!=end; ++current) {
		if (*current==value) {
			return current;
		}
	}
	return current;
}

MessageServiceController::MessageServiceController() :
		m_messageServices(),
		m_freeIDs(),
		m_running(false),
		m_nextFreeID(0),
		m_terminateServices(){
	etMutex_construct(&m_mutex);
	etSema_construct(&m_terminateSema);
}

int MessageServiceController::getNewID() {
	etMutex_enter(&m_mutex);
	int newID;
	if (m_freeIDs.empty())
		newID = m_nextFreeID++;
	else {
		newID = m_freeIDs.back();
		m_freeIDs.pop_back();
	}
	etMutex_leave(&m_mutex);

	return newID;
}

void MessageServiceController::freeID(int id) {
	etMutex_enter(&m_mutex);
	m_freeIDs.push_back(id);
	etMutex_leave(&m_mutex);
}

void MessageServiceController::addMsgSvc(IMessageService& msgSvc) {
	etMutex_enter(&m_mutex);
	if (m_nextFreeID <= msgSvc.getAddress().m_threadID)
		m_nextFreeID = msgSvc.getAddress().m_threadID + 1;

	m_messageServices.push_back(&msgSvc);
	etMutex_leave(&m_mutex);
}

void MessageServiceController::removeMsgSvc(IMessageService& msgSvc) {
	etMutex_enter(&m_mutex);

	MsgSvcList::iterator it = find(m_messageServices.begin(), m_messageServices.end(), &msgSvc);
	if (it!=m_messageServices.end()) {
		m_messageServices.erase(it);
	}
	etMutex_leave(&m_mutex);
}

IMessageService* MessageServiceController::getMsgSvc(int id) {
	IMessageService* msgSvc = 0;
	etMutex_enter(&m_mutex);
	for (MsgSvcList::iterator it = m_messageServices.begin(); it!=m_messageServices.end(); ++it) {
		if ((*it)->getAddress().m_threadID==id) {
			msgSvc = *it;
			break;
		}
	}
	etMutex_leave(&m_mutex);

	return msgSvc;
}

void MessageServiceController::start() {
	// start all message services
	for (MsgSvcList::iterator it = m_messageServices.begin(); it != m_messageServices.end(); ++it) {
		(*it)->start();
	}
	m_running = true;
}

void MessageServiceController::stop() {
	if (!m_running)
		return;

	//dumpThreads("org.eclipse.etrice.runtime.java.messaging.MessageServiceController.stop()");
	terminate();
	waitTerminate();

	m_running = false;
}

void MessageServiceController::dumpThreads(String msg) {
//	std::cout << "<<< begin dump threads <<<" << std::endl;
//	std::cout << "=== "  << msg << std::endl;
	//TODO dump stack traces
//		Map<Thread, StackTraceElement[]> traces = Thread.getAllStackTraces();
//		for (Thread thread : traces.keySet()) {
//			std::cout << "thread " << thread.getName() << std::endl;
//			StackTraceElement[] elements = traces.get(thread);
//			int n = 2;
//			if (elements.length < n)
//				n = elements.length;
//			for (int i = 0; i < n; i++) {
//				std::cout << " " << elements[i].toString() << std::endl;
//			}
//		}
//	std::cout <<(">>> end dump threads >>>");
}

void MessageServiceController::terminate() {
	// terminate all message services
	etMutex_enter(&m_mutex);
	m_terminateServices = m_messageServices;

	MsgSvcList::reverse_iterator it = m_terminateServices.rbegin();
	for (; it != m_terminateServices.rend(); ++it) {
		(*it)->terminate();
	}
	etMutex_leave(&m_mutex);
}

void MessageServiceController::waitTerminate() {
	etBool wait = true;

	while(wait){
		etMutex_enter(&m_mutex);
		wait = !m_terminateServices.empty();
		etMutex_leave(&m_mutex);

		if(wait)
			etSema_waitForWakeup(&m_terminateSema);
	}
}

void MessageServiceController::resetAll() {
	stop();
	etMutex_enter(&m_mutex);
	m_messageServices.clear();
	while (!m_freeIDs.empty()) {
		m_freeIDs.pop_back();
	}
	m_nextFreeID = 0;
	etMutex_leave(&m_mutex);
}

void MessageServiceController::setMsgSvcTerminated(const IMessageService& msgSvc){
	etMutex_enter(&m_mutex);
	MsgSvcList::iterator it = find(m_terminateServices.begin(), m_terminateServices.end(), &msgSvc);
	if (it!=m_terminateServices.end()) {
		m_terminateServices.erase(it);
	}
	etSema_wakeup(&m_terminateSema);
	etMutex_leave(&m_mutex);
}

} /* namespace etRuntime */
