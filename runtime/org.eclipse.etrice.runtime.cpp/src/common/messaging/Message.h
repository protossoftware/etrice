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
#include "etDatatypes.h"
#include <string>

namespace etRuntime {

class Message {
public:
	Message(Address addr, int evtId, void* data, size_t dataSize) :
			m_address(addr), m_evtId(evtId), m_next(0),
			m_dataSize(dataSize), m_data(data), m_logFlag(true)
	{}
	Message(Address addr, int evtId) :
			m_address(addr), m_evtId(evtId), m_next(0),
			m_dataSize(0), m_data(0), m_logFlag(true)
	{}
	virtual ~Message();

	void setNext(Message* msg){m_next = msg;}
	Message* getNext() const {return m_next;}

	void setAddress(Address address){m_address = address;	}
	Address getAddress() const { return m_address; };

	int getEvtId() const {	return m_evtId; 	}
	void* getData() const {	return m_data;	}
	bool hasDebugFlagSet() const { return m_logFlag; };

	std::string toString();

private:
	Address m_address;
	int m_evtId;

	Message* m_next;
	size_t m_dataSize;
	void* m_data;
	bool m_logFlag;

	Message();
	Message(const Message & right);
	Message & operator = (const Message& right);

};

} /* namespace etRuntime */
#endif /* MESSAGE_H_ */
