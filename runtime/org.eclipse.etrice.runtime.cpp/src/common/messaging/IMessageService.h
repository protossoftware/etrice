/*******************************************************************************
 * Copyright (c) 2013 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Juergen Haug (initial contribution)
 *
 *******************************************************************************/
#ifndef SRC_COMMON_MESSAGING_IMESSAGESERVICE_H_
#define SRC_COMMON_MESSAGING_IMESSAGESERVICE_H_

#include "common/messaging/IMessageReceiver.h"

namespace etRuntime {

class IMessageService: public virtual IRTObject, public virtual IMessageReceiver {

public:

	virtual ~IMessageService() {}

	enum ExecMode {
		POLLED, BLOCKED, MIXED
	};

	virtual void start() = 0;
	virtual void terminate() = 0;

	virtual Address getFreeAddress() = 0;

	virtual void freeAddress(const Address& addr) = 0;

	virtual void addMessageReceiver(IMessageReceiver& receiver) = 0;
	virtual void removeMessageReceiver(IMessageReceiver& receiver) = 0;

	virtual void addPollingMessageReceiver(IMessageReceiver& receiver) = 0;
	virtual void removePollingMessageReceiver(IMessageReceiver& receiver) = 0;

	virtual Message* getMessageBuffer(int size) = 0;
	virtual void returnMessageBuffer(const Message* buffer) = 0;

	// TODO Thread
//		void setThread(Thread thread);
//
//		Thread getThread();

};

}

#endif /* SRC_COMMON_MESSAGING_IMESSAGESERVICE_H_ */
