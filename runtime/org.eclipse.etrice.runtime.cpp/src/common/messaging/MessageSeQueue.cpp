/*
 * MessageSeQueue.cpp
 *
 *  Created on: 22.08.2012
 *      Author: karlitsc
 */

#include "MessageSeQueue.h"

namespace etRuntime {


MessageSeQueue::~MessageSeQueue() {
	m_first = 0;
	m_last = 0;
}

MessageSeQueue::MessageSeQueue(IRTObject* parent, std::string name)
	: 	RTObject(parent, name),
		m_first(0),
		m_last(0),
		m_highWaterMark(0),
		m_size(0)
{
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

Message* MessageSeQueue::pop() {
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
