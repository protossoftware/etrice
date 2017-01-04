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

#include "common/messaging/Message.h"
#include "common/messaging/MessageDispatcher.h"
#include "common/messaging/IMessageService.h"

namespace etRuntime {

MessageDispatcher::MessageDispatcher(IRTObject* parent, const Address& addr, const String& name) :
		RTObject(parent, name),
		m_local_map(),
		m_freeAdresses(),
		m_pollingMessageReceiver(),
		m_address(addr),
		m_nextFreeObjId(addr.m_objectID + 1) {
	m_local_map[addr.m_objectID] = this;
}

Address MessageDispatcher::getFreeAddress() {
	if (m_freeAdresses.empty()) {
		return Address(getAddress().m_nodeID, getAddress().m_threadID, m_nextFreeObjId++);
	}
	else {
		Address address = m_freeAdresses.back();
		m_freeAdresses.pop_back();

		return address;
	}
}
void MessageDispatcher::freeAddress(const Address& addr) {
	m_freeAdresses.push_back(addr);
}
void MessageDispatcher::addMessageReceiver(IMessageReceiver& receiver) {
	if (!receiver.getAddress().isValid())
		return;

	if (receiver.getAddress().m_nodeID == m_address.m_nodeID
			&& receiver.getAddress().m_threadID == m_address.m_threadID) {

		m_local_map[receiver.getAddress().m_objectID] = &receiver;
	}

}

void MessageDispatcher::removeMessageReceiver(IMessageReceiver& receiver) {
	if (!receiver.getAddress().isValid())
		return;

	m_local_map.erase(receiver.getAddress().m_objectID);
}

void MessageDispatcher::addPollingMessageReceiver(IMessageReceiver& receiver) {
	m_pollingMessageReceiver.insert(&receiver);
}
void MessageDispatcher::removePollingMessageReceiver(IMessageReceiver& receiver) {
	m_pollingMessageReceiver.erase(&receiver);
}

void MessageDispatcher::receive(const Message* msg) {

	IMessageReceiver* receiver = 0;
	if (msg->getAddress().m_nodeID == m_address.m_nodeID && msg->getAddress().m_threadID == m_address.m_threadID) {
		Map<int, IMessageReceiver*>::iterator it = m_local_map.find(msg->getAddress().m_objectID);
		if (it != m_local_map.end()) {
			receiver = it->second;
		}
	}
	if (receiver == this) {
		for (Set<IMessageReceiver*>::iterator it = m_pollingMessageReceiver.begin();
				it != m_pollingMessageReceiver.end(); ++it) {
			(*it)->receive(msg);
		}
	} else if (receiver != 0) {
		receiver->receive(msg);
		// TODO: error handling for not found addresses
	}

	msg->~Message();
	dynamic_cast<IMessageService*>(getParent())->returnMessageBuffer(msg);
}

String MessageDispatcher::toString() const {
	return getName() + " " + getAddress().toID().c_str();
}

} /* namespace etRuntime */

