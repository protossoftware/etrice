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

#include "DebuggingService.h"

#include "common/modelbase/ActorClassBase.h"
#include "common/modelbase/SubSystemClassBase.h"
#include "common/modelbase/InterfaceItemBase.h"
#include <iostream>

namespace etRuntime {

DebuggingService& DebuggingService::getInstance() {
	static DebuggingService instance;

	return instance;
}

DebuggingService::DebuggingService() :
		m_asyncLogger(),
		m_syncLogger(),
		m_portInstances() {
}

const InterfaceItemBase* DebuggingService::getPort(const Address& address) const {
	std::map<Address, const InterfaceItemBase*>::const_iterator it = m_portInstances.find(address);
	if (it != m_portInstances.end())
		return it->second;

	return 0;
}

void DebuggingService::addMessageAsyncOut(const Address& source, const Address& target, const std::string& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0)
		m_asyncLogger.addMessageAsyncOut(srcPort->getActor()->getInstancePath(), tgtPort->getActor()->getInstancePath(),
				msg);

}

void DebuggingService::addMessageAsyncIn(const Address& source, const Address& target, const std::string& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0)
		m_asyncLogger.addMessageAsyncIn(srcPort->getActor()->getInstancePath(), tgtPort->getActor()->getInstancePath(),
				msg);
}

void DebuggingService::addMessageSyncCall(const Address& source, const Address& target, const std::string& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0)
		m_asyncLogger.addMessageSyncCall(srcPort->getActor()->getInstancePath(), tgtPort->getActor()->getInstancePath(),
				msg);
}

void DebuggingService::addMessageSyncReturn(const Address& source, const Address& target, const std::string& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0)
		m_asyncLogger.addMessageSyncReturn(srcPort->getActor()->getInstancePath(),
				tgtPort->getActor()->getInstancePath(), msg);
}

void DebuggingService::addActorState(const ActorClassBase& actor, const std::string& state) {
	m_asyncLogger.addActorState(actor.getInstancePath(), state);
}

void DebuggingService::addMessageActorCreate(const SubSystemClassBase& parent, const std::string& refName) {
	m_asyncLogger.addMessageActorCreate(parent.getInstancePath(),
			parent.getInstancePath() + IRTObject::PATH_DELIM + refName);
}

void DebuggingService::addMessageActorCreate(const ActorClassBase& parent, const std::string& refName) {
	m_asyncLogger.addMessageActorCreate(parent.getInstancePath(),
			parent.getInstancePath() + IRTObject::PATH_DELIM + refName);
}

void DebuggingService::addMessageActorDestroy(const ActorClassBase& inst) {
	//if (!(inst.getParent() instanceof OptionalActorInterfaceBase))
	m_asyncLogger.addMessageActorDestroy(inst.getParent()->getInstancePath(), inst.getInstancePath());
}

void DebuggingService::addVisibleComment(const std::string& comment) {
	m_asyncLogger.addVisibleComment(comment);
}

void DebuggingService::addPortInstance(const InterfaceItemBase& port) {
	m_portInstances[port.getAddress()] = &port;
}

void DebuggingService::removePortInstance(const InterfaceItemBase& port) {
	m_portInstances.erase(port.getAddress());
}

} /* namespace etRuntime */
