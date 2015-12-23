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

#include "MessageSeQueue.h"

namespace etRuntime {

MessageSeQueue::MessageSeQueue(IRTObject* parent, const std::string& name)
	: 	RTObject(parent, name),
		m_first(0),
		m_last(0),
		m_highWaterMark(0),
		m_size(0)
{
}

MessageSeQueue::~MessageSeQueue() {
	m_first = 0;
	m_last = 0;
}

void MessageSeQueue::push(Message* msg) {
	// TODO: optimize queue for concurrent push / pop
	if (m_first == 0) {
		m_first = m_last = msg;
	} else {
		m_last->setNext(msg);
		m_last = msg;
	}
	if (++m_size > m_highWaterMark)
		m_highWaterMark++;

}

const Message* MessageSeQueue::pop() {
	// TODO: optimize queue for concurrent push / pop
	Message* pop_msg = m_first;
	if (m_first == 0) {
		return m_first;
	}
	if (m_first->getNext() == 0) {
		m_first = m_last = 0;
	} else {
		m_first = m_first->getNext();
	}

	pop_msg->setNext(0);
	m_size--;

	return pop_msg;
}


} /* namespace etRuntime */
