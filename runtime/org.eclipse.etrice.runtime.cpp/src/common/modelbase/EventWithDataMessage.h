/*
 * EventWithDataMessage.h
 *
 * An event message carrying an arbitrary number of objects.
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#ifndef EVENTWITHDATAMESSAGE_H_
#define EVENTWITHDATAMESSAGE_H_
#include "common/modelbase/EventMessage.h"
#include <string>

namespace etRuntime {

class EventWithDataMessage: public EventMessage {
public:
	virtual ~EventWithDataMessage();

	EventWithDataMessage(Address address, int evtId, void* data)
		: 	EventMessage(address, evtId),
			m_data(data) {
	}
	virtual bool isEvtMessageWithData() {return true;};

	void* getData() {	return m_data;	}

	std::string toString();
	std::string dataToString();

private:
	void* m_data;

	EventWithDataMessage();

};

} /* namespace etRuntime */
#endif /* EVENTWITHDATAMESSAGE_H_ */
