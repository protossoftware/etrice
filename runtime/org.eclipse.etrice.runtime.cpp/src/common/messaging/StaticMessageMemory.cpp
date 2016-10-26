/*******************************************************************************
 * Copyright (c) 2016 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Jan Belle (initial contribution)
 *
 *******************************************************************************/

#include "common/messaging/StaticMessageMemory.h"

namespace etRuntime {

StaticMessageMemory::StaticMessageMemory(IRTObject* parent, const std::string& name, size_t size, int number) :
		RTObject(parent, name), m_size(size), m_msgPool(NULL, "memory"), m_buffer(0) {
	m_buffer = new uint8_t[m_size * number];
	uint8_t* ptr = m_buffer;
	for(int i = 0; i < number; ++i) {
		Message* msg = new (ptr) Message(Address::EMPTY, 0);
		m_msgPool.push(msg);
		ptr += m_size;
	}
}

StaticMessageMemory::~StaticMessageMemory() {
	delete[] m_buffer;
}

Message* StaticMessageMemory::getMessageBuffer(size_t size) {
	if(size <= m_size && m_msgPool.getSize() > 0) {
		return const_cast<Message*>(m_msgPool.pop());
	}
	else {
		return 0;
	}
}

void StaticMessageMemory::returnMessageBuffer(const Message* buffer) {
	m_msgPool.push(const_cast<Message*>(buffer));
}

} /* namespace etRuntime */
