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

#ifndef MESSAGESERVICECONTROLLER_H_
#define MESSAGESERVICECONTROLLER_H_

#include "common/messaging/MessageService.h"
#include "common/messaging/RTServices.h"
#include <vector>
#include <string>
#include <iostream>
#include <algorithm>

namespace etRuntime {

class MessageServiceController {
public:
	MessageServiceController(/*IRTObject parent*/);
	virtual ~MessageServiceController();

	void addMsgSvc(MessageService& msgSvc);
	//raises an exception if the service does not exist for this threadID
	MessageService* getMsgSvc(int threadID);

	void addAsyncActor(IEventReceiver& evtReceiver);
	void pollAsyncActors();

	//the connectAll method connects all messageServices
	//it is included for test purposes
	//currently it is not called
	void connectAll();
	void start(bool singlethreaded);
	void stop(bool singlethreaded);

	//TODO: this is only for single threaded configurations
	void runOnce();

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate
	 * ! not threadsafe !
	 */
	void waitTerminate();

protected:
	void dumpThreads(std::string msg);

private:
	void terminate();

	MessageServiceController(const MessageServiceController& right);
	MessageServiceController& operator=(const MessageServiceController& right);


	std::vector<MessageService*> m_messageServiceList;
	//	 IRTObject parent = null;
	bool m_running;

};

} /* namespace etRuntime */
#endif /* MESSAGESERVICECONTROLLER_H_ */
