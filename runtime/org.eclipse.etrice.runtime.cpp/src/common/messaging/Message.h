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

#ifndef MESSAGE_H_
#define MESSAGE_H_

#include "common/messaging/Address.h"
#include "stddef.h"
#include <iostream>
#include <sstream>
#include <string>

namespace etRuntime {

class Message {

public:

	// Messages with data TODO MessageBuffer
	Message(const Address& addr, int evtId, const void* dataToCopy, std::size_t dataSize);
	Message(const Address& addr, int evtId, void* dataPtr);

	Message(const Address& addr, int evtId);
	~Message();

	const Address& getAddress() const {
		return m_address;
	}

	int getEvtId() const {
		return m_evtId;
	}

	/** Pointer to data */
	void* getData() const {
		return m_data;
	}

	std::string toString() const;

protected:
	friend class MessageSeQueue;

	void setNext(Message* msg) {
		m_next = msg;
	}

	Message* getNext() const {
		return m_next;
	}

private:
	Address m_address;
	int m_evtId;

	Message* m_next;
	size_t m_dataSize;
	void* m_data;

	Message();
	Message(Message const&);
	Message& operator =(Message const&);

};

} /* namespace etRuntime */
#endif /* MESSAGE_H_ */
