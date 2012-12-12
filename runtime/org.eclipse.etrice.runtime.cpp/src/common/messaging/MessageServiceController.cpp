/*
 * MessageServiceController.cpp
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#include "MessageServiceController.h"

namespace etRuntime {


MessageServiceController::~MessageServiceController() {
	// TODO Auto-generated destructor stub
}

MessageServiceController::MessageServiceController(/*IRTObject parent*/)
	: 	m_messageServiceList(),
		m_running(false) {
	// TODO: Who is parent of MessageServices and Controller?
	// this.parent = parent;
}

void MessageServiceController::addMsgSvc(MessageService& msgSvc) {
	// TODOTS: Who is parent of MessageServices ?
	//TODO assert
	//assert(msgSvc.getAddress().m_threadID == m_messageServiceList.size());
	m_messageServiceList.push_back(&msgSvc);
}

MessageService* MessageServiceController::getMsgSvc(int threadID) {
	return m_messageServiceList.at(threadID);
}

void MessageServiceController::connectAll() {
	for (size_t i = 0; i < m_messageServiceList.size(); i++) {
		MessageDispatcher& dispatcher = getMsgSvc(i)->getMessageDispatcher();
		for (size_t j = 0; j < m_messageServiceList.size(); j++) {
			if (i != j) {
				dispatcher.addMessageReceiver(*RTServices::getInstance().getMsgSvcCtrl().getMsgSvc(j));
			}
		}
	}
}

void MessageServiceController::start() {
	// start all message services
	for (std::vector<MessageService*>::iterator it = m_messageServiceList.begin();
			it != m_messageServiceList.end(); ++it) {
		//TODO start thread
		//msgSvc.start();
		// TODOTS: start in order of priorities
	}
	m_running = true;
}

void MessageServiceController::stop() {
	//dumpThreads("org.eclipse.etrice.runtime.java.messaging.MessageServiceController.stop()");
	terminate();
	waitTerminate();
}

void MessageServiceController::waitTerminate() {
	for (std::vector<MessageService*>::iterator it = m_messageServiceList.begin();
			it != m_messageServiceList.end(); ++it) {
		//try {
			//TODO thread join
			//msgSvc.join();
		//} catch (InterruptedException e1) {
		//}
	}
}

void MessageServiceController::dumpThreads(std::string msg) {
	std::cout << "<<< begin dump threads <<<" << std::endl;
	std::cout << "=== "  << msg << std::endl;
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
	std::cout <<(">>> end dump threads >>>");
}

void MessageServiceController::terminate() {
	if (!m_running) {
		return;
	}
	m_running = false;

	// terminate all message services
	for (std::vector<MessageService*>::iterator it = m_messageServiceList.begin();
			it != m_messageServiceList.end(); ++it) {
		//TODO: terminate thread
		//msgSvc.terminate();
		// TODOTS: stop in order of priorities
	}
}

void MessageServiceController::runOnce() {
	if (!m_running) {
		return;
	}
	//m_running = false;

	// terminate all message services
	for (std::vector<MessageService*>::iterator it = m_messageServiceList.begin();
			it != m_messageServiceList.end(); ++it) {
		(*it)->runOnce();
	}
}

} /* namespace etRuntime */
