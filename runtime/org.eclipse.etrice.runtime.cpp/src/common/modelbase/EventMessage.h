/*
 * EventMessage.h
 *
 *  A message carrying an event id.
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#ifndef EVENTMESSAGE_H_
#define EVENTMESSAGE_H_

#include "common/messaging/Message.h"
#include <string>

namespace etRuntime {

class EventMessage: public Message {
public:
	EventMessage(Address address, int evtId)
		: 	Message(address),
			m_evtId(evtId) {
	}
	virtual ~EventMessage();
	int getEvtId() {	return m_evtId; 	}
	virtual bool isEvtMessage() {return true;};

	std::string toString();

private:
	int m_evtId;

	EventMessage();
};

} /* namespace etRuntime */
#endif /* EVENTMESSAGE_H_ */
