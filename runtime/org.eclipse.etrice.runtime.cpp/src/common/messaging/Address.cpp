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

#include "common/messaging/Address.h"
#include <string>

namespace etRuntime {

const Address Address::EMPTY(0, 0, 0);

Address::Address(int nodeID, int threadID, int objectID) :
		m_nodeID(nodeID),
		m_threadID(threadID),
		m_objectID(objectID) {
}

Address::Address(const Address & right) :
		m_nodeID(right.m_nodeID),
		m_threadID(right.m_threadID),
		m_objectID(right.m_objectID) {
}

Address::~Address() {
	*this = EMPTY;
}

Address& Address::operator=(const Address& right) {
	if (this != &right) {
		m_nodeID = right.m_nodeID;
		m_threadID = right.m_threadID;
		m_objectID = right.m_objectID;
	}
	return *this;
}

bool Address::operator==(const Address& right) const {
	return m_nodeID == right.m_nodeID && m_threadID == right.m_threadID && m_objectID == right.m_objectID;
}

bool Address::operator!=(const Address& right) const {
	return !(*this == right);
}

// needed for ordered containers e.g. std::map
bool Address::operator<(const Address& right) const {
	if (m_nodeID == right.m_nodeID) {
		if (m_threadID == right.m_threadID) {
			return (m_objectID < right.m_objectID);
		}
		else {
			return (m_threadID < right.m_threadID);
		}
	}
	else {
		return (m_nodeID < right.m_nodeID);
	}
}

std::string Address::toID() const {
	char buffer[50];
	sprintf(buffer, "%i_%i_%i", m_nodeID, m_threadID, m_objectID);

	return std::string(buffer);
}

Address Address::createInc() const {
	return Address(m_nodeID, m_threadID, m_objectID + 1);
}

} /* namespace etRuntime */
