/*
 * MessageServiceController.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#ifndef MESSAGESERVICECONTROLLER_H_
#define MESSAGESERVICECONTROLLER_H_

#include "common/messaging/MessageService.h"
#include <list>
#include <string>
#include <iostream>

namespace etRuntime {

class MessageServiceController {
public:
	virtual ~MessageServiceController();

	MessageServiceController(/*IRTObject parent*/)
		: 	m_messageServiceList(),
			m_running(false) {
		// TODO: Who is parent of MessageServices and Controller?
		// this.parent = parent;
	}

	void addMsgSvc(MessageService msgSvc) {
		// TODOTS: Who is parent of MessageServices ?
		//TODO assert
		//assert(msgSvc.getAddress().m_threadID == m_messageServiceList.size());
		m_messageServiceList.push_back(msgSvc);
	}

	MessageService getMsgSvc(int threadID) {
		//TODO
		//assert(threadID < m_messageServiceList.size());
		return m_messageServiceList.get(threadID);
	}

	//the connectAll method connects all messageServices
	//it is included for test purposes
	//currently it is not called
	void connectAll() {
		for (size_t i = 0; i < m_messageServiceList.size(); i++) {
			MessageDispatcher& dispatcher = getMsgSvc(i).getMessageDispatcher();
			for (int j = 0; j < m_messageServiceList.size(); j++) {
				if (i != j) {
					dispatcher.addMessageReceiver(RTServices.getInstance().getMsgSvcCtrl().getMsgSvc(j));
				}
			}
		}
	}

	void start() {
		// start all message services
		for (MessageService msgSvc : m_messageServiceList) {
			msgSvc.start();
			// TODOTS: start in order of priorities
		}
		m_running = true;
	}

	void stop() {
		//dumpThreads("org.eclipse.etrice.runtime.java.messaging.MessageServiceController.stop()");
		terminate();
		waitTerminate();
	}

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate
	 * ! not threadsafe !
	 */
public:
	void waitTerminate() {
		for (MessageService msgSvc : m_messageServiceList) {
			try {
				msgSvc.join();
			} catch (InterruptedException e1) {
			}
		}
	}

protected:
	void dumpThreads(std::string msg) {
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

private:
	void terminate() {
		if (!m_running) {
			return;
		}
		m_running = false;

		// terminate all message services
		for (MessageService msgSvc : m_messageServiceList) {
			msgSvc.terminate();
			// TODOTS: stop in order of priorities
		}
	}

	std::list<MessageService> m_messageServiceList;
	//	 IRTObject parent = null;
	bool m_running;

};

} /* namespace etRuntime */
#endif /* MESSAGESERVICECONTROLLER_H_ */
