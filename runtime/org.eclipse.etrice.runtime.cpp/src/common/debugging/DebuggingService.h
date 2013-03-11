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

#ifndef DEBUGGINGSERVICE_H_
#define DEBUGGINGSERVICE_H_

#include "common/messaging/Address.h"
#include "common/debugging/MSCLogger.h"
#include "common/modelbase/PortBase.h"
#include <string>
#include <map>

namespace etRuntime {
	class ActorClassBase;


class DebuggingService {
private:
	static DebuggingService* s_instance;

public:
	virtual ~DebuggingService();

	static DebuggingService& getInstance() {
		if (s_instance == 0) {
			s_instance = new DebuggingService();
		}
		return *s_instance;
	}

	void addMessageAsyncOut(Address source, Address target, const std::string& msg);
	void addMessageAsyncIn(Address source, Address target, const std::string& msg);
	void addMessageSyncCall(Address source, Address target, const std::string& msg);
	void addMessageSyncReturn(Address source, Address target, const std::string& msg);
	void addActorState(const ActorClassBase& actor, const std::string& state);
	void addPortInstance(PortBase& port);
	MSCLogger& getSyncLogger();
	MSCLogger& getAsyncLogger();

private:

	MSCLogger asyncLogger;
	MSCLogger syncLogger;
	std::map<Address, PortBase*> portInstances;

	DebuggingService();
	DebuggingService(const DebuggingService& right);
	DebuggingService& operator=(const DebuggingService& right);

};

} /* namespace etRuntime */
#endif /* DEBUGGINGSERVICE_H_ */





