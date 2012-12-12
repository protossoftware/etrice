/*
 * EventReceiver.h
 *
 * The abstract base class for event receivers.
 *
 *  Created on: 29.08.2012
 *      Author: karlitsc
 */

#ifndef EVENTRECEIVER_H_
#define EVENTRECEIVER_H_

#include "common/messaging/RTObject.h"
#include "common/modelbase/IEventReceiver.h"
#include <string>

namespace etRuntime {

class EventReceiver : public RTObject, public IEventReceiver{
public:
	EventReceiver(IRTObject* parent, std::string name)
	: RTObject(parent, name),
	  IEventReceiver()
	{};
	virtual ~EventReceiver();

private:
	EventReceiver(const EventReceiver& right);
	EventReceiver& operator=(const EventReceiver& right);

};

} /* namespace etRuntime */
#endif /* EVENTRECEIVER_H_ */
