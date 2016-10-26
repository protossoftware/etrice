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
#include <iostream>
#include <string>
#include <cstring>
#include <cstdlib>

namespace etRuntime {

Message::Message(const Address& addr, int evtId, void* dataPtr) :
		m_address(addr),
		m_evtId(evtId),
		m_next(0),
		m_dataSize(0),
		m_data(dataPtr) {
}
Message::Message(const Address& addr, int evtId) :
		m_address(addr),
		m_evtId(evtId),
		m_next(0),
		m_dataSize(0),
		m_data(0) {
}
Message::~Message() {
	m_evtId = 0;
	m_next = 0;
	m_data = 0;
	m_dataSize = 0;
}

std::string Message::toString() const {
	std::stringstream strm;
	strm << "Message(" << m_address.toID() << ", evt=" << m_evtId << ")";
	if (m_data) {
		strm << std::showbase << std::hex << m_data;
	}
	return strm.str();
}

} /* namespace etRuntime */
