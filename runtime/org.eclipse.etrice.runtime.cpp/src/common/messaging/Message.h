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

#ifndef MESSAGE_H_
#define MESSAGE_H_

#include "common/messaging/Address.h"
#include "stddef.h"
#include "common/containers/String.h"

namespace etRuntime {

class Message {

public:

	Message(const Address& addr, int evtId, void* dataPtr);

	Message(const Address& addr, int evtId);
	virtual ~Message();

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

	String toString() const;

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

template<class T>
class DataMessage : public Message {
public:
	DataMessage(const Address& addr, int evtId, const T& dataToCopy) :
		Message(addr, evtId, &m_data), m_data(dataToCopy) {}
private:
	T m_data;

	DataMessage(void);
	DataMessage(DataMessage const&);
	DataMessage& operator=(DataMessage const&);
};

} /* namespace etRuntime */
#endif /* MESSAGE_H_ */
