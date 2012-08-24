/*
 * Message.h
 *
 *  Created on: 06.06.2012
 *      Author: karlitsc
 */

#ifndef MESSAGE_H_
#define MESSAGE_H_

#include "common/messaging/Address.h"
#include "platforms/generic/etDatatypes.h"
#include <string>

namespace etRuntime {

class Message {
public:
	// Message(Address addr) : m_address(addr), m_evtID(0), m_next(0) {};
	Message(Address addr, etInt16 evtID) :
			m_address(addr), m_evtID(evtID), m_next(0) {
	};
	Message(Address addr, etInt16 evtID, void* data) :
			m_address(addr), m_evtID(evtID), m_next(0) {
	};
	~Message();
	etInt16 getEvtId() const {return m_evtID;	};
	void* getData() const {	return 0; }
	; //TODO handling of events with data

	void setNext(Message* msg){m_next = msg;}
	Message* getNext() const {return m_next;}

	void setAddress(Address address){m_address = address;	}
	Address getAddress() const { return m_address; };

	std::string toString();

private:
	Address m_address;
	etInt16 m_evtID;
	Message* m_next;

	Message();
};

} /* namespace etRuntime */
#endif /* MESSAGE_H_ */
