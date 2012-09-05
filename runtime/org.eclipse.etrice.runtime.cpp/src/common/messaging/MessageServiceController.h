/*
 * MessageServiceController.h
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

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

	//the connectAll method connects all messageServices
	//it is included for test purposes
	//currently it is not called
	void connectAll();
	void start();
	void stop();

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
