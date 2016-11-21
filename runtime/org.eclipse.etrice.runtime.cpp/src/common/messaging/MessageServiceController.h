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

#include "common/messaging/IMessageService.h"
#include "osal/etMutex.h"
#include "osal/etSema.h"
#include <map>
#include <vector>
#include <queue>
#include <string>

namespace etRuntime {

class MessageServiceController {
public:
	MessageServiceController();
	virtual ~MessageServiceController() {}

	int getNewID();
	void freeID(int id);
	void addMsgSvc(IMessageService& msgSvc);
	void removeMsgSvc(IMessageService& msgSvc);
	IMessageService* getMsgSvc(int threadID);
	void start();
	void stop();
	void resetAll();

	/**
	 * waitTerminate waits blocking for all MessageServices to terminate
	 * ! not thread safe !
	 */
	void waitTerminate();

	void setMsgSvcTerminated(const IMessageService& msgSvc);

protected:
	void dumpThreads(std::string msg);

private:
	void terminate();

	std::map<int, IMessageService*> m_messageServices;
	std::vector<IMessageService*> m_messageServicesOrdered;
	std::queue<int> m_freeIDs;
	etBool m_running;
	int m_nextFreeID;

	etMutex m_mutex;
	etSema m_terminateSema;
	std::vector<IMessageService*> m_terminateServices;

	MessageServiceController(MessageServiceController const&);
	MessageServiceController& operator=(MessageServiceController const&);
};

} /* namespace etRuntime */
#endif /* MESSAGESERVICECONTROLLER_H_ */
