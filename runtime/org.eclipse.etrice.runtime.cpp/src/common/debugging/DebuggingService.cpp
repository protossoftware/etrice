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

#include "DebuggingService.h"

#include "common/modelbase/ActorClassBase.h"
#include "common/modelbase/SubSystemClassBase.h"
#include "common/modelbase/InterfaceItemBase.h"

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
	Map<Address, const InterfaceItemBase*>::const_iterator it = m_portInstances.find(address);
	if (it != m_portInstances.end())
		return it->second;

	return 0;
}

void DebuggingService::addMessageAsyncOut(const Address& source, const Address& target, const String& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0) {
		etRuntime::String srcPath = srcPort->getActor()->getInstancePath();
		etRuntime::String tgtPath = tgtPort->getActor()->getInstancePath();
		m_asyncLogger.addMessageAsyncOut(srcPath, tgtPath, msg);
	}

}

void DebuggingService::addMessageAsyncIn(const Address& source, const Address& target, const String& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0) {
		etRuntime::String srcPath = srcPort->getActor()->getInstancePath();
		etRuntime::String tgtPath = tgtPort->getActor()->getInstancePath();
		m_asyncLogger.addMessageAsyncIn(srcPath, tgtPath, msg);
	}
}

void DebuggingService::addMessageSyncCall(const Address& source, const Address& target, const String& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0) {
		etRuntime::String srcPath = srcPort->getActor()->getInstancePath();
		etRuntime::String tgtPath = tgtPort->getActor()->getInstancePath();
		m_asyncLogger.addMessageSyncCall(srcPath, tgtPath, msg);
	}
}

void DebuggingService::addMessageSyncReturn(const Address& source, const Address& target, const String& msg) {
	const InterfaceItemBase* srcPort = getPort(source);
	const InterfaceItemBase* tgtPort = getPort(target);
	if (srcPort != 0 && tgtPort != 0) {
		m_asyncLogger.addMessageSyncReturn(srcPort->getActor()->getInstancePath(),
				tgtPort->getActor()->getInstancePath(), msg);
	}
}

void DebuggingService::addActorState(const ActorClassBase& actor, const String& state) {
	etRuntime::String instancePath = actor.getInstancePath();
	m_asyncLogger.addActorState(instancePath, state);
}

void DebuggingService::addMessageActorCreate(const SubSystemClassBase& parent, const String& refName) {
	etRuntime::String parentPath = parent.getInstancePath();
	m_asyncLogger.addMessageActorCreate(parentPath, String(parentPath) + IRTObject::PATH_DELIM + refName);
}

void DebuggingService::addMessageActorCreate(const ActorClassBase& parent, const String& refName) {
	etRuntime::String parentPath = parent.getInstancePath();
	m_asyncLogger.addMessageActorCreate(parentPath, String(parentPath) + IRTObject::PATH_DELIM + refName);
}

void DebuggingService::addMessageActorDestroy(const ActorClassBase& inst) {
	etRuntime::String parentPath = inst.getParent()->getInstancePath();
	etRuntime::String instancePath = inst.getInstancePath();
	//if (!(inst.getParent() instanceof OptionalActorInterfaceBase))
	m_asyncLogger.addMessageActorDestroy(parentPath, instancePath);
}

void DebuggingService::addVisibleComment(const String& comment) {
	m_asyncLogger.addVisibleComment(comment);
}

void DebuggingService::addPortInstance(const InterfaceItemBase& port) {
	m_portInstances[port.getAddress()] = &port;
}

void DebuggingService::removePortInstance(const InterfaceItemBase& port) {
	m_portInstances.erase(port.getAddress());
}

} /* namespace etRuntime */
