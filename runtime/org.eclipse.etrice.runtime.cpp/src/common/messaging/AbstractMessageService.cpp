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

#include "common/messaging/AbstractMessageService.h"
#include <string>

namespace etRuntime {

AbstractMessageService::AbstractMessageService(IRTObject* parent, const std::string& name, int node, int thread) :
		RTObject(parent, name),
		m_address(node, thread, 0),
		m_messageQueue(this, "Queue"),
		m_messageDispatcher(this, m_address.createInc(), "Dispatcher") {
}

Address AbstractMessageService::getFreeAddress() {
	return m_messageDispatcher.getFreeAddress();
}

void AbstractMessageService::freeAddress(const Address& addr) {
	m_messageDispatcher.freeAddress(addr);
}

void AbstractMessageService::addMessageReceiver(IMessageReceiver& receiver) {
	m_messageDispatcher.addMessageReceiver(receiver);
}

void AbstractMessageService::removeMessageReceiver(IMessageReceiver& receiver) {
	m_messageDispatcher.removeMessageReceiver(receiver);
}

void AbstractMessageService::addPollingMessageReceiver(IMessageReceiver& receiver) {
	m_messageDispatcher.addPollingMessageReceiver(receiver);
}

void AbstractMessageService::removePollingMessageReceiver(IMessageReceiver& receiver) {
	m_messageDispatcher.removePollingMessageReceiver(receiver);
}

void AbstractMessageService::receive(const Message* msg) {
	if (msg != 0) {
		m_messageQueue.push(const_cast<Message*>(msg));
	}
}

std::string AbstractMessageService::toString() const {
	return getName() + " " + getAddress().toID();
}

}
