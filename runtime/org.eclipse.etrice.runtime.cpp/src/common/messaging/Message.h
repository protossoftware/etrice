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

namespace etRuntime {

class Message {
public:
	// Message(Address addr) : m_address(addr), m_evtID(0), m_next(0) {};
	Message(Address addr, etInt16 evtID) : m_address(addr), m_evtID(evtID), m_next(0) {};
	Message(Address addr, etInt16 evtID, void* data) : m_address(addr), m_evtID(evtID), m_next(0) {};
	~Message();
	etInt16 getEvtId() const {return m_evtID;};
	Address getAddress() const {return m_address;};
	void* getData() const {return 0;}; //TODO handling of events with data

private:
	Address m_address;
	etInt16 m_evtID;
	Message* m_next;

	Message();
};

} /* namespace etRuntime */
#endif /* MESSAGE_H_ */
