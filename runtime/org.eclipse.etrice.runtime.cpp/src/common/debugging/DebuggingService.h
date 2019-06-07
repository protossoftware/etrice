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

#ifndef DEBUGGINGSERVICE_H_
#define DEBUGGINGSERVICE_H_

#include "common/debugging/MSCLogger.h"
#include "common/containers/Map.h"
#include "common/messaging/Address.h"
#include "etDatatypes.h"
#include "common/modelbase/InterfaceItemBase.h"

namespace etRuntime {

class ActorClassBase;
class SubSystemClassBase;
class PortBase;

class DebuggingService {

public:
	virtual ~DebuggingService() {}

	static DebuggingService& getInstance();

	void addMessageAsyncOut(const Address& source, const Address& target, const String& msg);
	void addMessageAsyncIn(const Address& source, const Address& target, const String& msg);
	void addMessageSyncCall(const Address& source, const Address& target, const String& msg);
	void addMessageSyncReturn(const Address& source, const Address& target, const String& msg);
	void addActorState(const ActorClassBase& actor, const String& state);
	void addMessageActorCreate(const SubSystemClassBase& parent, const String& refName);
	void addMessageActorCreate(const ActorClassBase& parent, const String& refName);
	void addMessageActorDestroy(const ActorClassBase& inst);
	void addVisibleComment(const String& comment);
	void addPortInstance(const InterfaceItemBase& port);
	void removePortInstance(const InterfaceItemBase& port);

	MSCLogger& getSyncLogger() { return m_syncLogger; }
	MSCLogger& getAsyncLogger() { return m_asyncLogger; }

private:

	MSCLogger m_asyncLogger;
	MSCLogger m_syncLogger;
	Map<Address, const InterfaceItemBase*> m_portInstances;

	const InterfaceItemBase* getPort(const Address& address) const;

	DebuggingService();
	DebuggingService(DebuggingService const&);
	DebuggingService& operator=(DebuggingService const&);

};

} /* namespace etRuntime */
#endif /* DEBUGGINGSERVICE_H_ */

